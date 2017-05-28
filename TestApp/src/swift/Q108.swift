/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public var val: Int
 *     public var left: TreeNode?
 *     public var right: TreeNode?
 *     public init(_ val: Int) {
 *         self.val = val
 *         self.left = nil
 *         self.right = nil
 *     }
 * }
 */
class Q108 {
    func sortedArrayToBST(_ nums: [Int]) -> TreeNode? {
        if nums == nil || nums.isEmpty{
            return nil
        }
        
        let l:Int = 0
        let r:Int = nums.count-1
        return buildTree(nums:nums, left:l,right:r)
    }
    func buildTree(nums:[Int], left:Int, right:Int) -> TreeNode?{
        if left > right {
            return nil
        }
        let mid:Int = (left+right)/2
        let root:TreeNode? = TreeNode(nums[mid])
        root!.left = buildTree(nums:nums, left:left, right:mid-1)
        root!.right = buildTree(nums:nums, left:mid+1, right:right)
        return root
    }
    
}
