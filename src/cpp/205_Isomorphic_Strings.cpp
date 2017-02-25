//
// Created by andy on 17-2-25.
//

class Solution {
public:
    bool isIsomorphic(string s, string t) {
        map<char,char> tbl;
        set<char> setb;
        for(int i=0;i<s.length();i++){
            char ch = s[i];
            if(tbl.find(ch) == tbl.end()){
                tbl[ch] =t[i];
                if(setb.find(t[i]) != setb.end()){
                    return false;
                }else{
                    setb.insert(t[i]);
                }
            }else{

                if(tbl[ch] != t[i]){
                    return false;
                }
            }
        }
        return true;
    }
};