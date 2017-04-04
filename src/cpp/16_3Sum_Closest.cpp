#include <stdlib.h>
#include <cstddef>
#include <algorithm>
#include <vector>

using namespace std;
//
// Created by andy on 17-2-22.
//
int threeSumClosest(vector<int>& nums, int target) {

    sort(nums.begin(),nums.end());
    size_t  len = nums.size();
    int min = nums[0]+nums[1]+nums[2];
    for(int i=0;i<len-2;i++){
        int start = i+1;
        int end = len -1;
        int delt = nums[i]+nums[start]+nums[end];
        bool is_start = true;
        while(start != end){

            int sum = nums[i]+nums[start]+nums[end];
            if(is_start){
                delt = sum;
                is_start = false;
            }else{
                if(abs(target - sum) <=abs(target - delt)){
                    delt = sum;
                }
                if(delt == target){
                    break;
                }else if(sum >target){
                    end--;
                }else{
                    start++;
                }
            }
        }
        if(abs(target - delt) < abs(target - min)){
            min = delt;
        }
    }
    return min;
}
