package main.java.binarysearch;

/*
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Example 1:

Input: [1,3,5,6], 5
Output: 2
Example 2:

Input: [1,3,5,6], 2
Output: 1
Example 3:

Input: [1,3,5,6], 7
Output: 4
Example 4:

Input: [1,3,5,6], 0
Output: 0
 */
public class SearchInsertPosition {

	public static void main(String[] args) {
		int[] nums = {1,3,4,5};
		int target = 4;
		System.out.println(searchInsert(nums, target));
	}
	
	public static int searchInsert(int[] nums, int target) {
        return searchInsertBinarySearch(nums, target, 0, nums.length - 1);
    }

	private static int searchInsertBinarySearch(int[] nums, int target, int begin, int end) {
		int mid = begin + (end-begin)/2;
		if(end >= begin) {
			if(nums[mid] == target) {
				return mid;
			}else if(target > nums[mid]) {
				return searchInsertBinarySearch(nums, target, mid+1, end);
			}else {
				return searchInsertBinarySearch(nums, target, begin, mid-1);
			}
		}
		return mid;
	}

}
