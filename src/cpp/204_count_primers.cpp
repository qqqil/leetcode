//
// Created by andy on 17-3-1.
//
class Solution {
public:
//埃拉托斯特尼筛法
    int countPrimes(int n) {
        if (n <2) return 0;
        int upper = sqrt(n);
        vector<bool> tbl(n,true);
        int sum =0;
        for(int i=2;i<n;i++){
            if(tbl[i]){
                sum++;
                if(i>upper){
                    continue;
                }
                for(int j=i*i;j<n;j=j+i){
                    tbl[j] = false;
                }
            }
        }
        return sum;
    }
};
