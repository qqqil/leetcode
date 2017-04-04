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
    void flatten(TreeNode *root) {
        TreeNode *tmp;
        if(root == NULL)
        {
            return;
        }
        if(root->left)
        {
            flatten(root->left);
            tmp = root->right;
            root->right = root->left;
            appendToLast(root->right,tmp);
            root->left = NULL;
        }
        if(root->right)
        {
            flatten(root->right);
        }
    }
    void appendToLast(TreeNode *root,TreeNode *node)
    {
        if(root == NULL)
        {
            return;
        }
        if(root->right)
        {
            appendToLast(root->right,node);
        }else
        {
            root->right = node;
        }
    }
};
