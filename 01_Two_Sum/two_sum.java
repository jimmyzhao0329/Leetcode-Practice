//https://leetcode.com/problems/two-sum/

public class two_sum{
	public int[] twoSum(int[] nums, int target){
		int[] res = {0, 0};
		Map<Integer, Integer> mp = new HashMap<>();
		for(int i = 0; i < nums.length; i++){
			if(mp.containsKey(target - nums[i])){
				res[0] = mp.get(target - nums[i]);
				res[1] = i;
				break;
			}
			else{
				mp.put(nums[i], i);
			}
		}
		return res;
	}
}
