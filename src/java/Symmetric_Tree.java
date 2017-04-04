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
    public boolean isSymmetric(TreeNode root) {
       List<TreeNode> ls = new ArrayList<>();
        ls.add(root);
        while(ls.size() >0){
            List<TreeNode> tmp = new ArrayList<>();
            for(int i=0;i<ls.size()/2;i++){
                TreeNode t1 = ls.get(i);
                TreeNode t2 = ls.get(ls.size()-1-i);
                if((t1 == null && t2 != null) || (t1 != null && t2 == null)){
                    return false;
                } else if(t1 !=null && t2!=null && t1.val != t2.val){
                    return false;
                }
            }
            for(TreeNode t : ls){
                if(t == null){
                    continue;
                }
                tmp.add(t.left);
                tmp.add(t.right);
            }
            ls = tmp;
        }
        return true;
    }
}
