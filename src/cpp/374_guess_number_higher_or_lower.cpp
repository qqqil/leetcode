//
// Created by andy on 17-3-15.
//374_guess_number_higher_or_lower
//

// Forward declaration of guess API.
// @param num, your guess
// @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
// complexity:time(logN)
int guess(int num);

class Solution {
public:
    int guessNumber(int n) {
        int lo =1;
        int hi = n;
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            int rlt = guess(mid);
            if(rlt == 0){
                return mid;
            }
            if(rlt == 1){
                lo = mid +1;
            }else{
                hi = mid -1;
            }

        }
        return n;
    }
};