package dsa.string;

import java.util.Calendar;
import java.util.Date;

public class MinimumSwapsToPalindrome {

    public static void main(String args[]){
        StringBuilder str = new StringBuilder("tinin");
        int count = 0;
//        Date d = new Date();
//        d.get(Calendar.YEAR);
        if(isPossiblePalin(str.toString())){
            int left = 0;
            int right = str.length()-1;

            while(left<right){
                if(str.charAt(left) != str.charAt(right)){
                    int k = right;
                    while(k>left && str.charAt(k)!= str.charAt(left))k--;

                    if(left == k){
                        count++;
                        char c = str.charAt(left);
                        str.setCharAt(left,str.charAt(left+1));
                        str.setCharAt(left+1,c);
                        System.out.println(str.toString());
                    }else{
                        while(k<right){
                            char c = str.charAt(k);
                            str.setCharAt(k,str.charAt(k+1));
                            str.setCharAt(k+1,c);
                            System.out.println(str.toString());
                            k++;
                            count++;
                        }
                    }
                }else{
                    left++;
                    right--;
                }
            }

            System.out.println(count + " "+ str.toString());
        }else{
            System.out.println(-1);
        }
    }

    public static boolean isPossiblePalin(String str){

        int countOdd = 0;

        int store[] = new int[26];

        for(int i =0; i<str.length(); i++){
            store[str.charAt(i)-'a']++;
        }

        for(int i = 0;i<26;i++){
            if(store[i]%2==1) countOdd++;
        }

        return countOdd<=1;
    }
}
