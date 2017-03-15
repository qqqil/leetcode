//
// Created by andy on 17-3-16.
//

//complexity:time(logn)
class Solution {
public:
    bool isPerfectSquare(int num) {
        int lo =2;
        int hi = num;
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            int rlt = num /mid;
            if(rlt == mid){
                if(mid *mid == num){
                    return true;
                }
            }
            if(rlt >mid){
                lo = mid +1;
            }else{
                hi = mid -1;
            }
        }
        if(num ==1) return true;
        return false;
    }
};