package dsa.graph;

import java.util.*;

public class MinimumSpanningTree {

    public static void main(String args[]){

        ArrayList<ArrayList<Integer>> edges = new ArrayList<ArrayList<Integer>>();
        List<Edge> edgeList = new ArrayList<>();
        for(List<Integer> list:edges){
            Edge e= new Edge(list.get(0), list.get(1),list.get(2));
            edgeList.add(e);
        }
        Collections.sort(edgeList);
        Map<Integer,Integer> map = new HashMap<>();
        int cost= 0;
        for(Edge e:edgeList){
            int setA = find(e.src, map);
            int setB = find(e.des, map);

            if(setA != setB){
                union(e.src,e.des,map);
                cost+=e.wt;
            }
        }
    }

    public  static int find(int node, Map<Integer,Integer> map){
        if(map.containsKey(node)){
            return find(map.get(node),map);
        }else{
            return node;
        }
    }

    public static void union(int nodeA,int nodeB, Map<Integer,Integer> map){
        int setA = find(nodeA,map);
        int setB = find(nodeB,map);

        map.put(setA,setB);
    }

    public static class Edge implements Comparable<Edge>{
        int src,des, wt;

        Edge(int src,int des,int wt){
            this.src= src;
            this.des=des;
            this.wt=wt;
        }
        public int compareTo(Edge b){
            return this.wt - b.wt;
        }
    }

}
