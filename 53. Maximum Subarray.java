/*
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
*/

public int maxSubArray(int[] nums) {
    int cur = 0;
    int maxSum = Integer.MIN_VALUE;
    
    for(int i = 0; i < nums.length; i++){
        cur += nums[i];
        maxSum = Math.max(maxSum, cur);
        
        if(cur < 0){
            cur = 0;
        }
    }
    return maxSum;
}