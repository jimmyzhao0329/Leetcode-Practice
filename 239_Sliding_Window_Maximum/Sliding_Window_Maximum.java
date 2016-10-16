// https://leetcode.com/problems/sliding-window-maximum/

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k <= 0){
            return new int[0];
        }
        int len = nums.length;
        int[] res = new int[len - k + 1];
        int resIndex = 0;
        Deque<Integer> dq = new ArrayDeque<Integer>();
        for(int i = 0; i < len; i++){
            // remove item that is out of window boundary
            while(!dq.isEmpty() && dq.peek() < i - k + 1){
                dq.poll();
            }
            // remove item that is smaller than a[i] from tail
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
            }
            dq.offer(i);
            if(i >= k - 1){
                res[resIndex++] = nums[dq.peek()];
            }
        }
        return res;
    }

    public int[] maxSlidingWindow_1(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k <= 0){
            return new int[0];
        }
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k, new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b){
                return b - a;
            }
        });
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            pq.offer(nums[i]);
            if(pq.size() == k){
                res[index++] = pq.peek();
                pq.remove(nums[i - k + 1]);
            }
        }
        return res;
    }
}