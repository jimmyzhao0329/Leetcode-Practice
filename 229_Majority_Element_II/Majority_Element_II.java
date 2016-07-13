// https://leetcode.com/problems/majority-element-ii/

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if(nums == null || nums.length == 0){
            return res;
        }
        int count1 = 0, count2 = 0, m1 = nums[0], m2 = nums[0];
        for(int val : nums){
            if(val == m1){
                count1++;
            }
            else if(val == m2){
                count2++;
            }
            else if(count1 == 0){
                count1 = 1;
                m1 = val;
            }
            else if(count2 == 0){
                count2 = 1;
                m2 = val;
            }
            else{
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for(int val : nums){
            if(val == m1){
                count1++;
            }
            else if(val == m2){
                count2++;
            }
        }
        if(count1 > nums.length / 3){
            res.add(m1);
        }
        if(count2 > nums.length / 3){
            res.add(m2);
        }
        return res;
    }
}