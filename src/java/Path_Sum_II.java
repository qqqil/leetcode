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
        public void dfs(TreeNode root,int sum,List<Integer> ls){
            if(root == null){
            return;
        }
        ls.add(root.val);
        if(root.left == null && root.right == null){
            if(sum - root.val == 0){
                lss.add(new ArrayList<Integer>(ls));
            }
        }
        if(root.left != null){
            dfs(root.left,sum-root.val,ls);
            ls.remove(ls.size()-1);
        }
        if(root.right != null){
            dfs(root.right,sum - root.val,ls);
            ls.remove(ls.size()-1);
        }
    }
    List<List<Integer>> lss = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
      dfs(root,sum,new ArrayList<Integer>());

        return lss;
    }
}
