/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        List<TreeLinkNode> children = new ArrayList<>();
        if(root != null){
            children.add(root);
        }
        while(children.size()>0){
            TreeLinkNode pre = null;
            TreeLinkNode tmpNode = null;
            List<TreeLinkNode> tmpNodes = new ArrayList<>();
            for(int i=0;i<children.size();i++) {
                tmpNode = children.get(i);
                if(pre != null){
                    pre.next = tmpNode;
                }
                pre = tmpNode;

                if(tmpNode.left != null){
                    tmpNodes.add(tmpNode.left);
                }
                if(tmpNode.right != null){
                    tmpNodes.add(tmpNode.right);
                }
            }
            if(tmpNode != null){
                tmpNode.next = null;
            }
            children = tmpNodes;
        }
    }
}
