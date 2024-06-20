package dsa.heap;

import java.util.Arrays;

public class DeleteFromHeap {

    public  static void main(String args[]){
        Integer input[] = {0,2,4,1,5,3,15} ;//{2,3,5,6,9,1,6,7,10};
        Heapify.heapify(0,input);

        int temp = input[0];
        input[0] = input[input.length-1];
        input[input.length-1] = temp;

        Integer input2[] = new Integer[input.length-1];
        for(int i=0;i<input.length-1;i++){
            input2[i]=input[i];
        }

        Heapify.heapify(0,input2);

        System.out.println(Arrays.toString(input2));
    }
}
