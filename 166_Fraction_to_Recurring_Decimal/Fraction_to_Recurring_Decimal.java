// https://leetcode.com/problems/fraction-to-recurring-decimal/

public class Solution {
    public String fractionToDecimal(int num, int den) {
        if(num == 0){
            return "0";
        }
        if(den == 0){
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        if((num < 0) ^ (den < 0)){
            sb.append('-');
        }
        long n = num, d = den;
        n = Math.abs(n);
        d = Math.abs(d);
        
        long res = n / d;
        sb.append(res);
        long rem = (n % d) * 10;
        if(rem == 0){
            return sb.toString();
        }
        
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        sb.append('.');
        while(rem != 0){
            if(map.containsKey(rem)){
                int begin = map.get(rem);
                String p1 = sb.substring(0, begin);
                String p2 = sb.substring(begin, sb.length());
                StringBuilder r = new StringBuilder(p1);
                r.append('(');
                r.append(p2);
                r.append(')');
                return r.toString();
            }
            else{
                map.put(rem, sb.length());
                res = rem / d;
                sb.append(res);
                rem = (rem % d) * 10;
            }
        }
        return sb.toString();
    }
}