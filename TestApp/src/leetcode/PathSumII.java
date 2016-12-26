/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<>();
        if(root==null)
            return list;
        findPathSum(root,sum,list,new ArrayList<Integer>());
        return list;
    }
    public void findPathSum(TreeNode root, int sum, List<List<Integer>> list, List<Integer> l){
        if(root==null)
            return;
        l.add(root.val);
        if(root.left == null && root.right==null){
             System.out.println(l);

            int sumAll = 0;
            for(int a:l){
                sumAll+=a;
            }
            if(sumAll==sum)
                list.add(new ArrayList<>(l));
            l.remove(l.size()-1);
            return;
        }
        
        findPathSum(root.left,sum,list,l);
        findPathSum(root.right,sum,list,l);
        l.remove(l.size()-1);
    }
}
