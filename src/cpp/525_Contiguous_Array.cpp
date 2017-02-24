//
// Created by andy on 17-2-24.
//

class Solution {
public:
    int findMaxLength(vector<int>& nums) {
        for(auto &ele : nums){
            if(ele == 0){
                ele = -1;
            }
        }
        int sum=0;
        int max =0;
        map<int,int> tbl;
        tbl[0] = -1;
        for(int i=0;i<nums.size();i++){
            sum+=nums[i];
            if(tbl.find(sum) != tbl.end()){
                max = std::max(max,i-tbl[sum]);
            }else{
                tbl[sum] =i;
            }
        }

        return max;
    }
};