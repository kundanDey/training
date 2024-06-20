package dsa.graph;

import java.util.*;

public class Djikstra {

    public static void main(String args[]){

        //Integer input[][] = {{1,2,3},{2,3,2},{3,4,6},{2,4,2},{5,6,1},{}}
        int A = 10; ArrayList<ArrayList<Integer>> B = null;int C = 3;
        HashMap<Integer,ArrayList<Edge>> map = new HashMap<Integer,ArrayList<Edge>>();

        for(ArrayList<Integer> edge: B){
            int src = edge.get(0);
            int des = edge.get(1);
            int wt = edge.get(2);

            if(map.containsKey(src)){
                map.get(src).add(new Edge(des,wt));
            }else{
                ArrayList<Edge> list = new ArrayList<Edge>();
                list.add(new Edge(des,wt));
                map.put(src,list);
            }

            if(map.containsKey(des)){
                map.get(des).add(new Edge(src,wt));
            }else{
                ArrayList<Edge> list = new ArrayList<Edge>();
                list.add(new Edge(src,wt));
                map.put(des,list);
            }
        }

        Queue<Edge> q = new PriorityQueue<Edge>();
        HashSet<Integer> visited = new HashSet<Integer>();
        Integer dist[] = new Integer[A];

        Arrays.fill(dist,-1);

        dist[C] = 0;

        q.add(new Edge(C,0));
//        q.remove(new Edge(0,0));


        while(!q.isEmpty()){
            Edge edge = q.poll();
            visited.add(edge.des);
            if(map.containsKey(edge.des)){
                for(Edge target : map.get(edge.des)){
                    if(!visited.contains(target.des)){
                        Edge updated = new Edge(target.des,0);
                        if(dist[target.des] == -1){
                            dist[target.des] = target.wt+ dist[edge.des];
                        }else{
                            dist[target.des] = Math.min(target.wt+ dist[edge.des],dist[target.des] );
                        }
                        updated.wt = dist[target.des];
                        q.add(updated);
                    }
                }
            }
        }

    }

    static class Edge implements Comparable<Edge>{
        int des;
        int wt;
        Edge(int a,int b){
            des = a;
            wt = b;
        }

        public int compareTo(Edge e){
            return this.wt - e.wt;
        }

        public String toString(){
            return "("+des+","+wt+")";
        }
    }

}
