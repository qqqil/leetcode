/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    bool isBal(TreeNode *root,int& depth){
        if(root == NULL){
            depth = 0;
            return true;
        }
        int left=0,right=0;
        if(isBal(root ->left ,left) && isBal(root->right,right)){
            int diff = left - right;
            if(diff <0) diff = -diff;
            if(diff >1) return false;
            int max = left>right?left:right;
            depth = max+1;
            return true;
        }
        return false;
    }
    bool isBalanced(TreeNode *root) {
        int depth = 0;
        return isBal(root,depth);
    }
};
