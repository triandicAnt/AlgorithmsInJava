package leetcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SortedListToBST {
    ListNode current;
    public TreeNode sortedListToBST(ListNode head) {
        TreeNode root = null;
        current = head;
        root = buildTree(0,getLength(head)-1);
        return root;
        
    }
    public TreeNode buildTree(int start, int end){
        if(start>end)
            return null;
        int m = (start+end)/2;
        TreeNode left = buildTree(start, m-1);
        TreeNode root = new TreeNode(current.val);
        current = current.next;
        TreeNode right = buildTree(m+1,end);
        root.left = left;
        root.right = right;
        return root;
    }
    public int getLength(ListNode head){
        int l = 0;
        while(head!=null){
            l++;
            head = head.next;
        }
        return l;
    }
    public TreeNode insert(TreeNode root, int value){
        
        if(root==null)
            return new TreeNode(value);
        else if(root.val>value)
            root.left = insert(root.left,value);
        else 
            root.right = insert(root.right,value);
        return root;
    }
}
