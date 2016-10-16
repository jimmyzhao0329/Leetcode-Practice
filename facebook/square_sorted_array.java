import java.util.*;

public class square_sorted_array{
	public static void main(String[] args){
		int[] arr = {-4, -2, 0, 1, 3};
		int[] res = square_array(arr);
		for(int i : res){
			System.out.print(i + " ");
		}
		System.out.println("");
	}

	public static int[] square_array(int[] nums){
		if(nums == null || nums.length == 0){
			return new int[0];
		}

		for(int i = 0; i < nums.length; i++){
			nums[i] = nums[i] * nums[i];
		}

		int[] res = new int[nums.length];
		int l = 0, r = nums.length - 1;
		int len = nums.length;
		for(int i = 0; i < len; i++){
			if(nums[l] < nums[r]){
				res[len - i - 1] = nums[r--];
			}
			else{
				res[len - i - 1] = nums[l++];
			}
		}
		return res;
	}
}