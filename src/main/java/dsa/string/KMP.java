package dsa.string;

public class KMP {

    public static void main(String args[]){

        String str ="EggNackEEggnh";
        String pattern ="EEg";

        int lps[] = computeLPS(pattern);

        int i= 0, j=0 , n = pattern.length();

        while(i< str.length()){
            if(str.charAt(i) == pattern.charAt(j)){
                i++;j++;
                if(j == n){
                    System.out.println("present");
                    return;
                }
            }else{
                if(j == 0){
                    i++;
                }else{
                    j= lps[j-1];
                }
            }
        }

        System.out.println("not present");
    }

    private static int[] computeLPS(String pattern) {

        int[] lps = new int[pattern.length()];

        int i = 1, j=0;

        while(i<lps.length){
            if(pattern.charAt(i) == pattern.charAt(j)){
                lps[i] = j+1;
                j++;
                i++;
            }else{
                if(j == 0){
                    i++;
                }else{
                    j = lps[j-1];
                }
            }
        }

        return lps;
    }
}
