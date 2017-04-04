/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Solution {
         private boolean isValidBst(TreeNode root,TreeNode parent,boolean isLess){
        if(root == null){
            return true;
        }
        if(root.left != null){
            if(root.left.val >= root.val){
                return false;
            }
            if(parent != null){
                if(isLess) {
                    if (root.left.val >= parent.val) {
                        return false;
                    }
                }else {
                    if (root.left.val <= parent.val) {
                        return false;
                    }

                }

            }
            if(!isValidBst(root.left, root, true)){
                return false;
            }
        }
        if(root.right != null){
            if(root.right.val <= root.val){
                return false;
            }
            if(parent != null){
                if(isLess) {
                    if (root.right.val >= parent.val) {
                        return false;
                    }
                }else {
                    if (root.right.val <= parent.val) {
                        return false;
                    }
                }

            }
            if(!isValidBst(root.right, root, false)){
                return false;
            }
        }
        return true;
    }
    private boolean checkValidBst(TreeNode root, Integer min, Integer max){
        if(root == null){
            return true;

        }

        if(min != null && root.val <= min){
            return false;
        }
        if(max != null && root.val >= max){
            return false;
        }

        return checkValidBst(root.left,min,root.val) && checkValidBst(root.right,root.val,max);
    }
    public boolean isValidBST(TreeNode root) {
        return checkValidBst(root,null,null);
    }
}
