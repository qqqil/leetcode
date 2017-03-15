//
// Created by andy on 17-3-16.
//

//complexity:time logN
class Solution {
public:
    double myPow(double x, int n) {
        if(n == 0)
            return 1;
        if(x ==0)return 0;
        if (n < 0) return 1 / (x*myPow(x, -(++n)));
        return (n%2 == 0) ? pow(x*x, n/2) : x*pow(x*x, n/2);
    }
};