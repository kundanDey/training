package dsa.graph;

import java.util.*;

public class WordLadder {
    public int solve(String A, String B, ArrayList<String> C) {
        HashSet<String> set = new HashSet<String>();

        set.addAll(C);

        if(!set.contains(B)) return 0;

        Queue<String>  q = new LinkedList<String>();

        int level = 1, size = 1;

        q.add(A);
        HashSet<String> visited = new HashSet<String>();
        visited.add(A);

        while(size> 0){
            level++;
            int nextSize = 0;
            while(size>0){
                StringBuilder node = new StringBuilder(q.poll());
                int len = node.length();
                for(int i = 0; i< len; i++){
                    int present = node.charAt(i) - 'a';
                    for(int j = 0; j<26; j++){

                        if(j == present) continue;

                        node.setCharAt(i,(char)('a'+j));
                        String now = node.toString();

                        if(now.equals(B)) return level;

                        if(set.contains(now) && !visited.contains(now)){
                            visited.add(now);
                            nextSize++;
                            q.add(now);
                        }
                    }
                    node.setCharAt(i,(char)('a'+present));
                }
                size --;
            }
            size = nextSize;
        }
        return 0;
    }
}
