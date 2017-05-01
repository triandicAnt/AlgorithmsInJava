public class BSTDistance {
 
  public static void main(String[] args) {
    BSTDistance s = new BSTDistance();
    Node root = new Node(5);
    root.left = new Node(10);
    root.right = new Node(15);
    root.left.left = new Node(20);
    root.left.right = new Node(25);
    root.left.right.right = new Node(45);
    root.right.left = new Node(30);
    root.right.right = new Node(35);
    
    System.out.println(s.findDistance(root, 20,45)==3);
    System.out.println(s.findDistance(root, 30,35)==2);
    System.out.println(s.findDistance(root, 20,35)==4);

  }
  
  int pathLength(Node root, int n1){
    if(root==null)
      return -1;
    int x = 0;
    if(root.val==n1 || (x=pathLength(root.left,n1))>0 || (x=pathLength(root.right, n1))>0)
       return x+1;
    return 0;
  }
  
  Node findLCA(Node root, int n1, int n2){
    if(root==null)
      return null;
    if(root.val==n1 || root.val==n2)
      return root;
    Node left = findLCA(root.left, n1,n2);
    Node right = findLCA(root.right, n1,n2);
    if(left!=null && right!=null)
        return root;
    return left!=null?left:right;
  }
  int findDistance(Node root, int n1, int n2){
    if(root==null)
      return 0;
    int d1 = pathLength(root, n1)-1;
    int d2 = pathLength(root, n2)-1;
    Node lca = findLCA(root, n1,n2);
    int l = pathLength(root, lca.val)-1;
    return d1+d2-2*l;
  }
}
 class Node{
  int val;
  Node left;
  Node right;
  
  Node(int n){
    val = n;
    left = right  = null;
  }
}
