/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BTZigZag {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root==null)
            return list;
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        s1.push(root);
        while(!s1.isEmpty() || !s2.isEmpty()){
            List<Integer> l1 = new ArrayList<>();
            while(!s1.isEmpty()){
                TreeNode temp = s1.pop();
                l1.add(temp.val);
                if(temp.left!=null)
                    s2.push(temp.left);
                if(temp.right!=null)
                    s2.push(temp.right);
            }
            if(l1.size()>0)
                list.add(new ArrayList<>(l1));
            l1.clear();
            while(!s2.isEmpty()){
                TreeNode temp = s2.pop();
                l1.add(temp.val);
                if(temp.right!=null)
                    s1.push(temp.right);
                if(temp.left!=null)
                    s1.push(temp.left);
            }
            if(l1.size()>0)
                list.add(new ArrayList<>(l1));
            l1.clear();
        }
         return list;   
    }
}
