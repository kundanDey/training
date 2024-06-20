package dsa.tree;

import java.util.ArrayList;

public class TreeFromPostAndInorder {

    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        return construct(A,B,0,B.size()-1,0,A.size()-1);

    }

    private TreeNode construct(ArrayList<Integer> A, ArrayList<Integer> B, int start, int end, int start2, int end2){

        //System.out.println(start +" "+end +" "+start2 +" "+end2);
        if(end<0 || end<start) return null;

        int i = B.get(end);

        TreeNode root = new TreeNode(i);
        //System.out.println("root"+i);

        int inorderRoot = start2;

        for(inorderRoot =start2;inorderRoot<=end2;inorderRoot++)
        {
            if(A.get(inorderRoot) == i) break;
        }


        int left = inorderRoot-start2;

        root.left = construct(A,B,start,start+left-1,start2,inorderRoot-1);
        root.right = construct(A,B,start+left,end-1,inorderRoot+1,end2);


        return root;

    }

    static class TreeNode {
      int val;
     TreeNode left;
      TreeNode right;
      TreeNode(int x) {
       val = x;
       left=null;
       right=null;
      }
  }
}
