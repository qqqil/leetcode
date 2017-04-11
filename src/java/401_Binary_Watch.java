
/**backtracing
**/
public class Solution {
    List<String> watchs = new LinkedList<String>();
    public List<String> readBinaryWatch(int num) {
        readBinaryWatches(num,0,0,0);
        return watchs;
    }
    private void readBinaryWatches(int num,int idx,int w,int count){
        if(idx > 10){
            if(count == num){
                int hours = w >>6;
                int mints = w&(0x3f);
                if(hours >=12 || mints >=60) return;
                watchs.add(hours+":"+String.format("%02d",mints));
            }
            return;
        }

            readBinaryWatches(num,idx+1,w|(0x01<<idx),count+1);
            readBinaryWatches(num,idx+1,w,count);

    }
}
