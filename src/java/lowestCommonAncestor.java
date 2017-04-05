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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         return lca(root,p,q);

    }

    private TreeNode lca(TreeNode root,TreeNode p,TreeNode q){
        if(root == null) return null;
        if(root == p || root == q){

            return root;
        }
        TreeNode l = lca(root.left,p,q);
        TreeNode r = lca(root.right ,p,q);

        if(l != null && r != null) {
            return root;
        }
        else if(l == null && r == null) return null;
        else
        return l!=null ?l:r;
    }
}
