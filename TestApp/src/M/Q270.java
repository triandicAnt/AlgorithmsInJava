import java.io.*;

public class Q270
{
    public static void main (String[] args) throws java.lang.Exception
    {
        
        int [] a = {6,10,14,8,32,17,3,21};
        BinaryTree bt = new BinaryTree();
        
        for(int i:a){
            bt.root = bt.add(i);
        }
        bt.inorder(bt.root);
        
        System.out.println("\n" + bt.findClosest(bt.root,2));
                
    }
     
}

class BinaryTree{
    
    Node root;
    int closest;
    double min = Double.MAX_VALUE;

     public Node add(int v){
       return add(this.root, v);
    }
    public Node add(Node root, int v){
       if(root==null)
           return new Node(v);
        if(root.val>=v)
            root.left = add(root.left, v);
        else 
            root.right = add(root.right,v);
        return root;
    }
    public void inorder(Node root){
        if(root==null)
            return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }
    
    //find closest
    public int findClosest(Node root, int v){
        find(root,v);
        return closest;
    }
    public int find(Node root, int v){
        if(root==null)
            return closest;
        if(Math.abs(root.val-v)<min){
            min = Math.abs(root.val-v);
            closest = root.val;
        }
        if(root.val>v)
            return find(root.left, v);
        else
            return find(root.right,v);
    }
    
    
}

class Node{
    int val;
    Node left;
    Node right;
    Node(int v){
        this.val = v;
        left = null;
        right = null;
    }
}
