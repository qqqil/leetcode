//
// Created by andy on 17-3-14.
//

int firstBadVersion(int n){
    int lo = 1;
    int hi =n;
    while(lo <hi){
        int mid = lo + (hi -lo)/2;
        if(isBadVersion(mid)){
            if(mid >1 && !isBadVersion(mid -1)){
                return mid;
            }else{
                hi = mid;
            }
        }else{
            if(isBadVersion(mid+1)){
                return mid+1;
            }
            lo = mid;
        }
    }
    return hi;
}