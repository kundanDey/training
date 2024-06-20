package dsa.miscellaneous;

import java.util.ArrayList;
import java.util.HashSet;

public class Sudoku {

    public static void main(String args[]) {

        Integer board[][] = {{7,3,8,5,1,0,9,6,2},{0,4,9,3,0,7,0,0,5},{0,5,1,0,2,0,0,0,0},{3,0,2,7,0,0,0,0,0},{0,0,6,4,0,2,7,5,3},{4,0,0,6,0,0,2,1,0},{0,0,0,2,0,0,0,3,0},{0,0,0,0,3,0,6,4,0},{0,0,3,9,0,5,0,2,0}};

        ArrayList<HashSet<Integer>> rows = new ArrayList<HashSet<Integer>>();
        ArrayList<HashSet<Integer>> cols = new ArrayList<HashSet<Integer>>();
        HashSet<Integer> groups[][] = new HashSet[3][3];

        for (int i = 0; i < 9; i++) {
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                groups[i][j] = new HashSet<Integer>();
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                rows.get(i).add(board[i][j]);
                cols.get(j).add(board[i][j]);
                groups[i/3][j/3].add(board[i][j]);
            }
        }

        if(solve(0,0,board,rows,cols,groups)){
            for(int i =0;i< 9;i++){
                for(int j=0;j< 9;j++){
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
        }

    }

    private static  boolean solve(int i,int j, Integer board[][],ArrayList<HashSet<Integer>> rows, ArrayList<HashSet<Integer>> cols, HashSet<Integer> groups[][]){

        if(j == board[0].length){
            j = 0;
            i++;
            if(i == board.length) return true;
        }
        if(board[i][j]!=0){
            return solve(i,j+1,board,rows,cols,groups);
        }

        for(int k =1;k <= 9 ;k++){
            if(!rows.get(i).contains(k) && !cols.get(j).contains(k) && !groups[i/3][j/3].contains(k)){
                rows.get(i).add(k);
                cols.get(j).add(k);
                groups[i/3][j/3].add(k);

                board[i][j]=k;

                if(solve(i,j+1,board,rows,cols,groups)){
                    return true;
                }

                board[i][j]=0;

                rows.get(i).remove(k);
                cols.get(j).remove(k);
                groups[i/3][j/3].remove(k);
            }
        }

        return false;


    }
}
