/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

TreeNode *ans = nullptr;
class Solution {
public:

    int find(TreeNode* root, TreeNode* p, TreeNode* q){
        int ret = 0;
        if(root == p || root == q){
            ret = 1;
        }
        if(root != nullptr){
            if((ret += find(root->left,p,q) + find(root->right,p,q))==2){
                if(ans == nullptr)
                    ans = root;
            }
        }
        return ret;
    }
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        ans = nullptr;
        find(root,p,q);
        return ans;
    }
};
