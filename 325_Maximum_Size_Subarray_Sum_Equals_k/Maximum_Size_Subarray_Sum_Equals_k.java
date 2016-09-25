//https://segmentfault.com/a/1190000005771068

public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();//key:prefix和; value:到第几个数
        int max = Integer.MIN_VALUE;
        map.put(0, 0);
        for (int i = 1; i < nums.length + 1; i++) {
            sum += nums[i - 1];
            int lookingfor = sum - k;
            if (map.containsKey(lookingfor)) {
                max = Math.max(max, i - map.get(lookingfor));
            }
            if (!map.containsKey(sum))
                map.put(sum, i);
        }
        if (max == Integer.MIN_VALUE)
            return 0;
        return max;
    }
}