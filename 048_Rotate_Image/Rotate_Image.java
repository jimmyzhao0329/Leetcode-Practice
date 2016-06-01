//https://leetcode.com/problems/rotate-image/

public class Solution {
    public void rotate(int[][] nums) {
        int n = nums.length;
        for(int i = 0; i < n - 1; i++){
            for(int j = i + 1; j < n; j++){
                int temp = nums[i][j];
                nums[i][j] = nums[j][i];
                nums[j][i] = temp;
            }
        }
        for(int i = 0; i < n; i++){
            reverseArray(nums[i], 0, n - 1);
        }
    }
    
    private static void reverseArray(int arr[], int start, int end)
    {
        int temp;
        if (start >= end)
            return;
        temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        reverseArray(arr, start+1, end-1);
    }
}