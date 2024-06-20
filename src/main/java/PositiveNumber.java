public class PositiveNumber {

    public static void main(String args[]){

        Integer arr[] = {2, 3, 7, 6, 8, -1, -10, 15};

        for(int i =0;i<arr.length;){
            if((arr[i] <= 0 )|| (arr[i] >= arr.length) ) {
                i++;
                continue;
            }
            int temp = arr[arr[i]-1];
            arr[arr[i]-1] = -1;
            arr[i]=temp;
        }

        for(int i =0;i<arr.length;i++){
            if(arr[i] <= 0){
                System.out.println(i+1);
                return;
            }
        }
    }
}
