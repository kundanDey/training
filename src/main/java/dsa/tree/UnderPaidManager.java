package dsa.tree;

import java.util.ArrayList;
import java.util.List;

public class UnderPaidManager {

    public static void main(String args[]){

        Node head = new Node("A",200);

        iterate(head);

    }

    private static void iterate(Node node){
        int total = 0, count =0;
       if (node.subordinates.size() ==0) return;
        for(Node employee: node.subordinates){
            iterate(employee);
            total += employee.salary + employee.sum;
            count += employee.numberOfEmployees+1;
        }

        node.sum = total;
        node.numberOfEmployees = count;

        if(total/count > node.salary){}

    }


    public static class Node {
        String name;
        int salary;
        List<Node> subordinates;
        int sum =0;
        int numberOfEmployees;


        public Node(String name, int salary){
            this.name = name;
            this.salary = salary;
            subordinates = new ArrayList<>();
        }
    }
}
