package dsa.graph;

import java.util.*;

public class UnionFind {
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {

        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        ArrayList<Edge> bridge=new ArrayList<Edge>();
        for(ArrayList<Integer> x:B){
            Edge e=new Edge(x.get(0),x.get(1),x.get(2));
            bridge.add(e);
        }

        Collections.sort(bridge);
        /*for(Edge e:bridge){
            System.out.println(e.src+" "+e.dest+" "+e.w);
        }*/

        int cost=0;
        for(Edge e:bridge){
            int xset=find(e.src,map);
            int yset=find(e.dest,map);

            if(xset == yset){
                continue;
            }else{
                cost += e.w;
                union(e.src,e.dest,map);
            }

        }

        return cost;
    }

    private int find(int x, HashMap<Integer,Integer> map){

        if(map.containsKey(x)){
            return find(map.get(x),map);
        }else{
            return x;
        }
    }

    private void union(int x, int y,HashMap<Integer,Integer> map){

        int setA = find(x,map);
        int setB = find(y,map);

        map.put(setA,setB);
    }

    public static class Edge implements Comparable<Edge>{
        int src,dest,w;

        Edge(int a,int b,int c){
            this.src=a;
            this.dest=b;
            this.w=c;
        }

        public int compareTo(Edge e){
            return this.w-e.w;
        }
    }

}
