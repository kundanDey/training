package dsa.dynamic.programming;

public class KnapSack01 {

    public static void main(String args[]){
        int value[] = {60,100,120};
        int wt[] = {10,20,30};
        int C = 30;
        Integer dp[][] = new Integer[3][C+1];

        System.out.println(solve(value,wt,dp,0,C));

    }

    public static int solve(int value[], int wt[],Integer dp[][],int i,int w){

        if(i == value.length) return 0;

        if(dp[i][w]!=null) return dp[i][w];

        if(w - wt[i] <0 ){
            dp[i][w] = solve(value,wt,dp,i+1,w);
        }else{
            dp[i][w] = Math.max(value[i]+solve(value,wt,dp,i+1,w-wt[i]),solve(value,wt,dp,i+1,w));
        }


        return  dp[i][w];
    }
}
