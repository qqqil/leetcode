/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        if(root.left != null){
            if(root.left.left == null && root.left.right == null) {
                return root.left.val + sumOfLeftLeaves(root.left) +sumOfLeftLeaves(root.right);
            }else{
                return sumOfLeftLeaves(root.left)+sumOfLeftLeaves(root.right);
            }
        }
        if(root.right != null){
            return sumOfLeftLeaves(root.right);
        }
        return 0;
    }
}
