import java.util.*;
public class Test {
    public static void main(String args[]){

        ArrayList<Integer> list = new ArrayList<Integer>();
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>(); // order is not retained
        map.put(1, 1001);
        list.indexOf(8); //O(n);
        map.get(1); // O(1)

        // 2 3 6 7 8 20 12 5
        // 20

        int arr[] = {2, 3, 6, 7, 8, 20, 12, 5};

        for(int i: arr) {
            if (i == 20) {
                //print present
            }
        }
        HashSet<Integer> set = new HashSet<>();
        set.add(2);
        set.contains(20);

        //LinedHashMap<Integer,Integer> // order is retained

//        C a = new C();
//        a.display2();

        Thread one = new Thread(new B("thread1"));
        one.start();
        int i = 0;
//        while(i <100){
//            System.out.println("thread 1" + " " + i);
//            i++;
//        }

         i = 0;
        while(i< 100){
            System.out.println(" main " + i);
            i++;
        }
        
        System.out.println("Monetize360".substring(3));

        int now= 5000000;

        for(int t= 1;t<=20;t++){
            now+= now*1.15+ 5000000;
        }
        System.out.println(now);
    }

    public static void display(){
    }

}
