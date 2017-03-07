/* package whatever; // don't place package name! */

import java.io.*;
import java.util.*;


class Q333{
    int data;
    BTNode left;
    BTNode right;
    BTNode parent;
    int vd;
    
    BTNode(){
        
    }
    
    BTNode(int n){
        data = n;
        left = right = parent = null;
    }
}
 class BinaryTree {



    protected BTNode root;

   
    /**
     * 
     * @param data
     * @return
     */
    public static void main(String[]args){
        BTNode root = new BTNode(25);
        root.left = new BTNode(18);
        root.right = new BTNode(50);
        root.left.left = new BTNode(19);
        root.left.right = new BTNode(20);
        
        root.right.left = new BTNode(38);
        root.right.right = new BTNode(60);
        
        root.left.left.right = new BTNode(15);
        
        root.left.right.left = new BTNode(18);
        root.left.right.right = new BTNode(25);
        
        root.right.left.left = new BTNode(20);
        root.right.left.right = new BTNode(56);
        root.right.left.left.right = new BTNode(25);
        
        root.right.right.left = new BTNode(55);
        root.right.right.right = new BTNode(70);
        
        BinaryTree bt = new BinaryTree();
        //bt.bfs(root);
        
        System.out.println(bt.maxBST(root));
        
    }
     
    protected  BTNode createNode(int data){
        BTNode newNode = new BTNode();
        newNode.data = data;
        newNode.left = newNode.right = newNode.parent = null;
        return newNode;
    }
    
    // In-order recursive
    /**
     * 
     * @param root
     */
    protected void inOrder(BTNode root){
        if(root==null)
            return;
        inOrder(root.left);
        System.out.print(root.data + " ");
//        if(root.parent!=null)
//            System.out.println(root.parent.data);
//        else
//            System.out.println();
        inOrder(root.right);
    }
    
   private void bfs(BTNode root){
        if(root == null)
            return;
        Queue<BTNode> q = new LinkedList<BTNode>();
        q.add(root);
        while(!q.isEmpty()){
            BTNode temp = (BTNode) q.poll();
            System.out.print(temp.data + " ");
            if(temp.left!=null)
                q.add(temp.left);
            if(temp.right!=null)
                q.add(temp.right);
        }
        
    }
     
     public int maxBST(BTNode root){
         if(root==null)
            return 0;
         return getBST(root).size;
     }
     
     public Value getBST(BTNode root){
         if(root==null)
            return new Value(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
         Value left = getBST(root.left);
         Value right = getBST(root.right);
         Value value = new  Value();
         if(root.left==null)
             value.min = root.data;
         else
             value.min = left.min;
         if(root.right==null)
            value.max = root.data;
         else
             value.max = right.max;
         if(left.max<=root.data && right.min>root.data){
             value.size = left.size+right.size+1;
             value.isBST = true;
             return value;
         }else{
             value.size = Math.max(left.size, right.size);
             value.min = 0;
             value.max = 0;
             value.isBST = false;
             return value;
         }
             
     }

    
}
class Value{
    boolean isBST;
    int size;
    int min;
    int max;
    public Value(){
        
    }
    public Value(boolean isBST, int size, int min, int max){
        this.isBST = isBST;
        this.size = size;
        this.min = min;
        this.max = max;
    }
    
}
