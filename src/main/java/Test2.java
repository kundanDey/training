import java.util.HashMap;
import java.util.HashSet;

public class Test2 {

    public static Service service;
    public static void main (String args[]){
//      HashMap<Integer,String> map = new HashMap<>();
//      map.put(1, "string1");
//      map.put(2, "string2");
//      String str =map.get(1);
//      System.out.println(str);
//
////      for(int key : map.keySet()){
////          if(map.get(key) == "value") return key;
////      }
//
//        HashSet<Integer> set = new HashSet<>();
//        set.add(1);
//        set.add(4);
//
//        set.contains(2); //O(1)

      //[1,3 ,5, 6, 7] -> O(n)
      // hash_func(key) 09ab8shs -> O(1)
        // 1- 10
        // store[10]
        // string1 -> hashng -> 4
        //string2 -> hasing -> 9
        //string3 -> hashing ->8
        //[ , , , ,{}, , , , ,{},]

//      C a = new A();
//      a.display2();
//      A a = new C();

        //service = new ServiceImpl2();
        service.getService();
    }
}
