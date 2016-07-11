// https://leetcode.com/problems/kth-largest-element-in-an-array/

public class Solution {
    
    // O( N log(N) ) time + O(1) memory
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    
    /*O( N log(K) ) + O(K) memory
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        for(int val : nums){
            q.offer(val);
            if(q.size() > k){
                q.poll();
            }
        }
        return q.peek();
    }
    */
    
}