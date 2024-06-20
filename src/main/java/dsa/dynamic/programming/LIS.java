package dsa.dynamic.programming;

import java.util.HashMap;

public class LIS {

    public static void main(String args[]){

        int arr[] = {1,2,6,8,7,3,4,10};
        System.out.println(findNumber(arr,7));
    }

    static int findNumber(int arr[], int n)
    {
        HashMap<Integer, String> map = new HashMap<Integer,String>();

        for(int i =0;i< arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                int num = arr[i]*arr[i] + arr[j]*arr[j];
                if(map.containsKey(num)) {
                    if (!map.get(num).equals(i + "," + j)) return num;
                }
                map.put(num,i+","+j);
            }
        }
        return 0;
    }
}
