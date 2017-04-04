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
    public List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>> ls = new ArrayList<>();
        List<TreeNode> nodes = new ArrayList<>();
        if(root == null){
            return ls;
        }
        nodes.add(root);
        while(nodes.size() >0){
            List<TreeNode> tmp = new ArrayList<>();
            List<Integer> num = new ArrayList<>(nodes.size());
            for(TreeNode n : nodes){
                num.add(n.val);
                if(n.left != null){
                    tmp.add(n.left);
                }
                if(n.right != null){
                    tmp.add(n.right);
                }
            }
            nodes = tmp;
            ls.add(num);
        }

        return ls;
    }
}
