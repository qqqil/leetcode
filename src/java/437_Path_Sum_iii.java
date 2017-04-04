int number =0;
private void preorder(TreeNode root, List<Integer> sumPath, int target){
    if(root == null) {
        return;
    }
    visit(root);
    sumPath.add(root.val);
    preorder(root.left,sumPath,target);
    preorder(root.right,sumPath,target);


    int sum = 0;
    for(int i=sumPath.size()-1;i>=0;i--){
        sum += sumPath.get(i);
        if(sum == target){
            number++;
        }
    }

    sumPath.remove(sumPath.size()-1);

}
@Test
public int pathSum(TreeNode root, int sum) {
    List<Integer> sumPath = new LinkedList<Integer>();
    preorder(root,sumPath,sum);

    return number;
}
