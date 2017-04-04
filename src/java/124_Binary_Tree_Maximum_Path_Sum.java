/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
 #include <limits>
class Solution {
public:
    int ret_max=INT_MIN;
    int maxp(TreeNode *root){
        int sum=0;
    	if(root==NULL) return 0;
    	int lmax = 0;
    	int rmax=0;
    	int val=root->val;
    	lmax=maxp(root->left);
    	rmax =maxp(root->right);
    	if(lmax>0) val +=lmax;
    	if(rmax>0) val +=rmax;
    	if(val>ret_max) ret_max = val;
    	return max(root->val,max(root->val + lmax,root->val +rmax));
    }
    int maxPathSum(TreeNode *root) {
        maxp(root);
        return ret_max;
    }
};
