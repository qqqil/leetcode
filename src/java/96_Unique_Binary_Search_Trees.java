public class Solution {
    public int numTrees(int n) {
       if(n == 0){
            return 0;
        }else if(n ==1){
            return 1;
        }
        int[] trees = new int[n+1];
        trees[0] = trees[1] = 1;
        for(int i =2;i<=n;i++) {
            trees[i] = 0;
            for (int j = 0; j < i; j++) {
                trees[i] += trees[j] * trees[i - j - 1];
            }
        }
        return trees[n];
    }
}
