/*
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.
*/

public void moveZeroes(int[] nums) {
	int zeros = 0;

	//This for loop puts all the zeros in the beginning
	for(int i = 0; i < nums.length; i++){
		if(nums[i] != 0){
			nums[zeros++] = nums[i];
		}
	}

	//Everything afterwards should be zeros
	for(; zeros < nums.length; zeros++){
		nums[zeros] = 0;
	}
}