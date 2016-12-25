package leetcode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class DeleteNode {
    
    public TreeNode findMin(TreeNode root){
        TreeNode temp = root;
        while(temp.left!=null)
        {
            temp = temp.left;
        }
        return temp;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        
        if(root==null)
            return root;
        if(root.val>key)
            root.left = deleteNode(root.left,key);
        else if(root.val<key)
            root.right = deleteNode(root.right,key);
        else{
            // case 1 both child are null
            if(root.left==null && root.right==null){
                root=null;
                return root;
            }
            // case 2 : one of the child is null
            else if(root.left==null){
                TreeNode temp = root.right;
                root=null;
                return temp;
            }else if(root.right == null){
                TreeNode temp = root.left;
                root = null;
                return temp;
            }
            // case 3 : both children are not null
            else{
                TreeNode temp = findMin(root.right);
                root.val = temp.val;
                root.right = deleteNode(root.right,root.val);
                return root;
            }
            
            
        }
        return root;
        
        
        /*if(root==null)
            return null;
        if(root.left==null && root.right==null && root.val==key)
            return null;
        // find key and its parent
        TreeNode [] treeNodes = new TreeNode[2];
        findNode(root,null,treeNodes,key);
        
        // 5 cases
        // case 0 key not found : return the same root
        if(treeNodes.length==0)
            return root;
        // case 2 : if both the left and right node of key node is null; simply delete it
        else if(treeNodes[0].left == null && treeNodes[0].right==null){
            TreeNode parent = treeNodes[1];
            if(parent.left.val==key)
                parent.left = null;
            else
                parent.right = null;
            return root;
        }
        //case 2 : delete the root itself
        if(treeNodes[1]==null){
            //delete node
            // if right node is not null parent is right node
            TreeNode keyNode = treeNodes[0];
            TreeNode parent = treeNodes[1];
            if(keyNode.right!=null){
                TreeNode futureRoot = root.right;
                TreeNode futureRootRight = null;
                while(futureRoot!=null && futureRoot.left!=null){
                    futureRoot = futureRoot.left;
                }
                futureRootRight = futureRoot.right;
                while(futureRootRight!=null && futureRootRight.right!=null){
                      futureRootRight = futureRootRight.right;
                }
                // dance starts
                futureRoot.left = root.left;
                futureRootRight.right = root.right;
                return futureRoot;
            }
            return keyNode.left;
        }
        return null;*/
    }
    
    // find key and its parent
    public void findNode(TreeNode root,TreeNode parent,TreeNode[] treeNodes, int key){
        // will have key node and its parent
        //null case
        if(root==null){
            return;
        }
        else if(root.val==key){
            treeNodes[0] = root;
            treeNodes[1] = parent;
        }else if(root.val>key){ // search left
            findNode(root.left,root,treeNodes,key);
        }else{
            findNode(root.right,root,treeNodes,key);
        }
    }
}
