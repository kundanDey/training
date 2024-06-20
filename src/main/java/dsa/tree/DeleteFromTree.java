package dsa.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DeleteFromTree {

    public static void main(String args[]){
        Integer[] arr = {3,1,4,5,7,6,3,8};

        TreeNode root = null;
        for(int i :arr)
         root = insert(root,i);

        print(root);

        root = delete(root, 3);

        System.out.println("/////");

        Queue<Integer> q = new LinkedList<Integer>();
        q.addAll(Arrays.asList(arr));


        print(root);
    }

    private static void print(TreeNode root){

        if(root == null) {
            System.out.println("null");
            return;
        };
        System.out.println(root.val);
        print(root.left);
        print(root.right);
    }

    private static TreeNode delete(TreeNode root, int i){

        if(root == null){
            return root;
        }


        if(root.val < i){
            root.right = delete(root.right,i);
        }else if( root.val > i){
            root.left = delete(root.left,i);
        }

        if(root.left == null){
            return root.right;
        }
        if(root.right == null)
            return root.right;

        TreeNode min = minVal(root.right);
        root.right = delete(root.right, min.val);

        min.left = root.left;
        min.right =root.right;
        return  min;
    }

    private static TreeNode minVal(TreeNode root){

        while(root.left !=null){
            root = root.left;
        }

        return root;
    }

    private static TreeNode insert(TreeNode root, int i){

        if(root == null){
            return new TreeNode(i);
        }

        if(root.val > i){
            root.left = insert(root.left,i);
        }else if(root.val< i){
            root.right = insert(root.right,i);
        }

        return root;
    }

    static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val){
            this.val= val;
        }
    }
}
