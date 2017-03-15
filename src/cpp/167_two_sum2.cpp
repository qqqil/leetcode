//
// Created by andy on 17-3-15.
//
class Solution {
public:
    int binarySearch(vector<int> &nums,int target,int lo,int hi){

        while(lo <=hi){
            int mid = lo + (hi - lo)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] > target){
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }
        return -1;
    }
    vector<int> twoSum(vector<int>& numbers, int target) {
        vector<int> rtn;
        for(int i=0;i<numbers.size();i++){
            int ele = numbers[i];
            int rem = target -ele;
            int idx = binarySearch(numbers,rem,i+1,numbers.size()-1);
            if(idx != -1){
                rtn.push_back(i+1);
                rtn.push_back(idx+1);
                break;
            }
        }
        return rtn;
    }
};
