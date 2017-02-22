//
// Created by andy on 17-2-22.
//

int longestPalindrome(string s) {
    map<char,int> tbl;
    for(char ch :s){
        if(tbl.find(ch) == tbl.end()){
            tbl[ch] =1;
        }else{
            tbl[ch]++;
        }
    }
    int sum=0;
    int sig_sum=0;
    for(auto itr : tbl){
        int num = itr.second;
        if(num %2 ==0){
            sum +=num;
        }else{
            if(num ==1){
                sig_sum++;
            }else{
                sum+=(num -1);
                sig_sum++;
            }
        }
    }
    if(sig_sum >0){
        sum +=1;
    }
    return sum;
}