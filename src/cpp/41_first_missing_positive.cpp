//
// Created by andy on 17-3-17.
//

//41_first_missing_positive
//complexity:time N,space 1

class Solution {
public:
    int firstMissingPositive(vector<int>& nums) {
        map<int,int> tbl;
        for(auto &ele : nums){
            tbl[ele] = 1;
        }
        int i =1;
        for(i=1;i<=nums.size();i++){
            if(tbl.find(i) == tbl.end()){
                return i;
            }
        }
        return i;
    }
};