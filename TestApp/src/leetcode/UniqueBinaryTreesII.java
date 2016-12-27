/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sudhansu
 *
 */
public class UniqueBinaryTreesII {
    public List<TreeNode> generateTrees(int n) {
        if(n==0)
            return new ArrayList<TreeNode>();
        return getTrees(1,n);
    }
    public List<TreeNode>getTrees(int m, int n){
        List<TreeNode> list = new ArrayList<>();
        if(m>n){
            list.add(null);
            return list;
        }
        for(int i = m;i<=n;i++){
            List<TreeNode> left = getTrees(m,i-1);
            List<TreeNode> right = getTrees(i+1,n);
            for(TreeNode l:left){
                for(TreeNode r: right){
                    TreeNode curr = new TreeNode(i);
                    curr.left = l;
                    curr.right = r;
                    list.add(curr);
                }
            }
        }
        return list;
    }
}
