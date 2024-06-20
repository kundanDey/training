package dsa.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Anagrams {

    public static void main(String args[]){

        String input[] = {"fdd","dfd","pplo","ddf","ffd","plop"};

        HashMap<String, List<String>> map = new HashMap<String, List<String>>();

        for(String s : input){
            StringBuffer br = new StringBuffer("");
            for(int i=0;i<26;i++) br.append("0");

            for(char ch :s.toCharArray()){
                int i = Integer.parseInt(""+br.charAt((ch-'a')));
                br.setCharAt(ch-'a',(""+(i+1)).charAt(0));
            }

            if(map.containsKey(br.toString())){
                map.get(br.toString()).add(s);
            }else{
                List<String> list = new ArrayList<String>();
                list.add(s);
                map.put(br.toString(),list);
            }
        }

        System.out.println(map);
    }
}
