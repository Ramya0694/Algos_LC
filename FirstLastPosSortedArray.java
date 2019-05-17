package main.java.binarysearch;

public class FirstLastPosSortedArray {
	public static void main(String[] args) {
		int[] nums = {3,4,4,5};
		int target = 4;
		int result[] = new int[2];
		result[0] = binarySearchFirstPos(nums, target, 0, nums.length - 1);
		result[1] = binarySearchLastPos(nums, target, 0, nums.length - 1);
		System.out.println(result);
	}
	
	private static int binarySearchFirstPos(int[] array, int ele, int begin, int end) {

		int mid = begin + (end-begin)/2;	
		if(array.length == 0) {
			return -1;
		}
		
		if(end >= begin) {
			if((mid == 0 || array[mid-1] < ele) && array[mid] == ele) {
				return mid;
			}else if(ele > array[mid]) {
				return binarySearchFirstPos(array, ele, mid+1, end);
			}else {
				return binarySearchFirstPos(array, ele, begin, mid-1);
			}
		}
		return -1;
	}
	
	private static int binarySearchLastPos(int[] array, int ele, int begin, int end) {

		int mid = begin + (end-begin)/2;	
		if(array.length == 0) {
			return -1;
		}
		
		if(end >= begin) {
			if((mid == array.length - 1 || array[mid+1] > ele) && array[mid] == ele) {
				return mid;
			}else if(ele < array[mid]) {
				return binarySearchLastPos(array, ele, begin, mid-1);
			}else {
				return binarySearchLastPos(array, ele, mid+1, end);
			}
		}
		return -1;
	}
	
}
