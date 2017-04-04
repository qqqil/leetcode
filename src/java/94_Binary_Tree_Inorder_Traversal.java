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
    List<Integer> rtn = new LinkedList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return rtn;
        if(root.left != null){
            inorderTraversal(root.left);
        }
        rtn.add(root.val);
        if(root.right != null){
            inorderTraversal(root.right);
        }

        return rtn;
    }
}
