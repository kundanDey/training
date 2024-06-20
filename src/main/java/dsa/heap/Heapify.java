package dsa.heap;

import java.util.Arrays;

public class Heapify {
    public static void main(String args[]){
        Integer input[] = {0,2,4,1,5,3,15} ;//{2,3,5,6,9,1,6,7,10};
        heapify(0,input);
        System.out.println(Arrays.toString(input));
    }

    public static void heapify(int i , Integer input[]){

        if(i>input.length-1) return;

        int left = 2*i+1;
        int right = 2*i+2;

        heapify(left,input);
        heapify(right,input);
        int max = i;
        if(left < input.length && input[max]<input[left]){
            max = left;
        }

        if(right < input.length  && input[max] < input[right]){
            max = right;
        }

        if(max != i){
            int temp = input[i];
            input[i]=input[max];
            input[max]= temp;
            heapify(max,input);
        }
    }
}
