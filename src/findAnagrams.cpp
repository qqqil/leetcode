#include <iostream>
#include <vector>
#include <limits>
#include <map>
#include <algorithm>
#include <sstream>

vector<int> findAnagrams(string s, string p) {
    map<string,int> table;
    size_t  len = s.length();
    int plen=p.length();
    for(int i=0;i<len-3;++i){
        string tmp = s.substr(i,plen);
        table[tmp] = i;
    }
    sort(p.begin(),p.end());
    vector<int> rtn;
    for(auto ele:table){
        string key = ele.first;
        sort(key.begin(),key.end());
        if(key == p){
            rtn.push_back(ele.second);
        }
    }
    return rtn;
}