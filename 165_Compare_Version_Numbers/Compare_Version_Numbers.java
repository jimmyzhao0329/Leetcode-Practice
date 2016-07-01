// https://leetcode.com/problems/compare-version-numbers/

public class Solution {
    public int compareVersion(String v1, String v2) {
        if(v1 == null || v1.length() == 0 || v2 == null || v2.length() == 0 ){
            return 0;
        }
        int i1 = 0, i2 = 0;
        while(i1 < v1.length() || i2 < v2.length()){
            int t1 = 0, t2 = 0;
            while(i1 < v1.length() && v1.charAt(i1) != '.'){
                t1 = t1 * 10 + (v1.charAt(i1) - '0');
                i1++;
            }
            while(i2 < v2.length() && v2.charAt(i2) != '.'){
                t2 = t2 * 10 + (v2.charAt(i2) - '0');
                i2++;
            }
            if(t1 > t2){
                return 1;
            }
            else if(t1 < t2){
                return -1;
            }
            else{
                i1++;
                i2++;
            }
        }
        return 0;
    }
}