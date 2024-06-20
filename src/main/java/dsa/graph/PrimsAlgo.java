package dsa.graph;

import java.util.*;

public class PrimsAlgo {

    public static void main(String args[]){
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        Map<Integer,ArrayList<Pair>> map = new HashMap<>();
        Pair smallest = new Pair(0,0,Integer.MAX_VALUE);
        for(ArrayList<Integer> edge:edges){
            Pair pair = new Pair(edge.get(0),edge.get(1),edge.get(2));
            if(smallest.compareTo(pair) < 0){
                smallest = pair;
            }
            if(map.containsKey(edge.get(0))){
                map.get(edge.get(0)).add(pair);
            }else{
                ArrayList<Pair> list = new ArrayList<>();
                list.add(pair);
                map.put(edge.get(0),list);
            }
            if(map.containsKey(edge.get(1))){
                map.get(edge.get(1)).add(pair);
            }else{
                ArrayList<Pair> list = new ArrayList<>();
                list.add(pair);
                map.put(edge.get(1),list);
            }
        }

        PriorityQueue<Pair> heap = new PriorityQueue<>();
        HashSet<Integer> added = new HashSet<>();
        heap.add(smallest);
        int cost = 0;
        while(heap.size()>0){
            Pair pair = heap.poll();
            if(added.contains(pair.src) && added.contains(pair.des)) continue;
            if(!added.contains(pair.des)){
                if(map.containsKey(pair.des)) heap.addAll(map.get(pair.des));
                cost+=pair.wt;
                added.add(pair.des);
            }
            if(!added.contains(pair.src)){
                if(map.containsKey(pair.src)) heap.addAll(map.get(pair.src));
                cost+=pair.wt;
                added.add(pair.src);
            }
        }

        System.out.println(cost-smallest.wt);
    }

    public static class Pair implements Comparable<Pair>{
        int src,des,wt;
        Pair(int a,int b, int c){
            src = a;
            des =b;
            wt = c;
        }

        @Override
        public int compareTo(Pair o) {
            return this.wt-o.wt;
        }
    }
}
