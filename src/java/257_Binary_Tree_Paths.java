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
     List<String> listPaths = new LinkedList<String>();
    private void preOrder(TreeNode root,String path){
        if(root == null){
            return;
        }

        if(root.left ==null && root.right == null) {
            if(path.isEmpty()){
                path+=root.val;
            }else{
                path +="->"+root.val;
            }
            listPaths.add(path);
        }
        String newPath ="";
        if(path.isEmpty()){
            newPath=root.val+"";
        }else{
            newPath = path+"->"+root.val;
        }
        preOrder(root.left,newPath);
        preOrder(root.right,newPath);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        preOrder(root,"");
        return listPaths;
    }
}
