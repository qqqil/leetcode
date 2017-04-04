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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode tmp = root;
        while(true){
            st.push(tmp);
            if(tmp.left == null){
                break;
            }
            tmp = tmp.left;
        }
        int rank=0;
        int rtn=0;
        while(!st.isEmpty()){

            tmp = st.pop();
            rank++;
            rtn = tmp.val;
            if(rank == k){

                break;
            }
            if(tmp.right != null){
                tmp = tmp.right;
                while(true){
                    st.push(tmp);
                    if(tmp.left ==null){
                        break;
                    }
                    tmp = tmp.left;
                }
            }
        }
        return rtn;
    }
}
