package dsa.dynamic.programming;

public class StockSellOne {

    public static void main(String args[]){

        int arr[] = {3,4,5,2,6,7,10,3,4,1};

        int minNow = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i: arr){
            minNow = Math.min(minNow,i);
            maxProfit = Math.max(maxProfit,i-minNow);
        }

        System.out.println(maxProfit);
    }
}
