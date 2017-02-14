public class DeleteNode {

     protected BTNode root;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DeleteNode bt = new DeleteNode();
        
     
        int []a = new int []{12,5,15,3,7,13,17,1,9,8,11};
        for(int i : a){
            bt.add(i);
        }
        bt.bfs(bt.root);
        bt.delete(bt.root,13);
        System.out.println();
        bt.bfs(bt.root);
        
    }
    
    /**
     * 
     * @param data
     * @return
     */
    
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
  
    
    
    
    // Iterative in order traversal
   
    
    // Iterative level order traversal
    /**
     * 
     * @param root
     */
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
    
    // Add node to a binary tree iteratively
    /**
     * 
     * @param value
     */
    private void add(int value){
        if(root==null)
            root = createNode(value);
        else{
            BTNode temp = root;
            BTNode parent = root;
            while(temp!=null){
                if(temp.data>=value){
                    parent = temp;
                    temp =temp.left;
                }
                else{
                    parent = temp;
                    temp = temp.right; 
                }
            }
            if(value<=parent.data){
                parent.left = createNode(value);
                parent.left.parent = parent;
            }
            else{
                parent.right = createNode(value);
                parent.right.parent = parent;
            }
        }
        
    }
    
    // Add node to a binary tree recursively
    /**
     * 
     * @param value
     */
    private void addRecursive(int value){
        root = addRecursive(root, value);
    }
    
    private BTNode addRecursive(BTNode root, int data){
        if(root == null){
            root = createNode(data);
            return root;
        }
        if(data<=root.data){
            root.left =  addRecursive(root.left, data);
        }
        else{
            root.right =  addRecursive(root.right, data);
        }
        return root;
    }
    
    
    public BTNode delete(BTNode root, int data){
        if(root==null)
            return root;
        
        if(root.data>data){
            root.left = delete(root.left, data);
        }else if(root.data<data){
            root.right = delete(root.right, data);
        }else{
            // case 1: child node
            if(root.left==null && root.right==null)
                return null;
            //case 2: 
            if(root.left==null)
                return root.right;
            else if(root.right==null)
                return root.left;
            else{
                BTNode temp = findMin(root.right);
                root.data = temp.data;
                root.right = delete(root.right, temp.data);
            }
        }
        return root;
    }
    public BTNode findMin(BTNode temp){
        BTNode current = temp;
        while(current.left!=null)
            current = current.left;
        return current;
    }
}
