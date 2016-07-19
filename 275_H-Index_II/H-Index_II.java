// https://leetcode.com/problems/h-index-ii/

public class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0){
            return 0;
        }
        int len = citations.length;
        int left = 0, right = len - 1;
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(citations[mid] == len - mid){
                return len - mid;
            }
            else if(citations[mid] < len - mid){
                left = mid;
            }
            else{
                right = mid;
            }
        }
        if(citations[left] >= len - left){
            return len - left;
        }
        else if(citations[right] >= len - right){
            return len - right;
        }
        else{
            return 0;
        }
    }
}