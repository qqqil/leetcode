//
// Created by andy on 17-2-28.
//

class Solution {
public:
    int numberOfBoomerangs(vector<pair<int, int>>& points) {
        int ret =0;
        for(auto &p : points){
            unordered_map<double,int> tbl;
            for(auto &q :points){
                ret +=2*tbl[hypot((double)(p.first-q.first),p.second-q.second)]++;
            }
        }
        return ret;
    }
};