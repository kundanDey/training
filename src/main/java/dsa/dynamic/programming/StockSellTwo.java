package dsa.dynamic.programming;

public class StockSellTwo {

    public static void main(String args[]){

        int arr[] = {3,4,5,2,6,7,10,3,4,1};

        int maxProfit = 0;

       for(int i = 1; i<arr.length; i++){
           if(arr[i] > arr[i-1]){
               maxProfit+=arr[i]-arr[i-1];
           }
       }

        System.out.println(maxProfit);
    }

}
