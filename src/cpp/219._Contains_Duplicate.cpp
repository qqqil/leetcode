//
// Created by andy on 17-2-23.
//

bool containsNearbyDuplicate(vector<int>& nums, int k) {
    map<int,vector<int>> tbl;

    size_t  len = nums.size();
    for(int i=0;i<len;i++){
        if(tbl.find(nums[i]) == tbl.end()){
            vector<int> v;
            v.push_back(i);
            tbl[nums[i]] = v;
        }else{
            tbl[nums[i]].push_back(i);
        }
    }
    for(auto &ele : tbl){
        vector<int> v = ele.second;
        if(v.size() <2){
            continue;
        }
        for(int i=0;i<v.size()-1;i++){
            if(v[i+1] - v[i] <=k){
                return true;
            }
        }

    }
    return false;
}