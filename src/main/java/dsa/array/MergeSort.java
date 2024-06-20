package dsa.array;

import java.util.Arrays;

public class MergeSort {

    public static void main(String args[]){

        int arr[] = {3,5,1,2,8,6,4,9};

        mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int arr[], int start,int end){
        int mid = (start+end)/2;

        if(end == start) return;

        mergeSort(arr,start,mid);
        mergeSort(arr,mid+1,end);

        int i=start,j= mid+1,k=0;
        int arr2[] = new int[(end-start+1)];
        while(i<=mid && j<=end){
            if(arr[i]<arr[j]){
                arr2[k]=arr[i];
                i++;
            }else{
                arr2[k]=arr[j];
                j++;
            }
            k++;
        }

        while(i<=mid){
            arr2[k] =arr[i];
            i++;
            k++;
        }

        while(j<=end){
            arr2[k]=arr[j];
            j++;
            k++;
        }
        k=0;
        for(int m = start; m<=end;m++,k++){
            arr[m]=arr2[k];
        }
    }
}
