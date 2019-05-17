package main.java.binarysearch;

import java.util.Arrays;

public class SearchRotatedSortedArray2 {

	public static void main(String[] args) {
		int[] array = {1,1,3,1};
		int ele = 2;
		boolean exists = searchRotatedSortedArray(array, ele);
		System.out.println(exists);
	}

	private static boolean searchRotatedSortedArray(int[] nums, int target) {
		nums = handlingTrailingDuplicates(nums);
		if(nums.length == 0) {
			return false;
		}else if(nums.length == 1) {
			if(nums[0] == target) { 
				return true;
			}else {
				return false;
			}
		}
		
		int pos = findPivot(nums);
		//System.out.println(pos);

		int[] array1 = Arrays.copyOfRange(nums, 0, pos);
		int[] array2 = Arrays.copyOfRange(nums, pos, nums.length);
		boolean exists = binarySearch(array1, target);
		if(exists == false) {
			exists = binarySearch(array2, target);
		}
		//System.out.println("Index" + index);
		return exists;
	}

	private static int[] handlingTrailingDuplicates(int[] nums) {
		int firstEle = nums[0];
		int i = nums.length - 1;
		while(nums[i] == firstEle && i>0) {
			i--;
		}
		nums = Arrays.copyOfRange(nums, 0, i+1);
		return nums;
	}

	private static int findPivot(int[] array) {
		int temp;
		int begin = 0;
		int end = array.length - 1;
		int firstEle = array[0];
		while(end - begin > 1) {
			temp = (begin + end)/2;
			if(array[temp] < firstEle) {
				end = temp;
			}else {
				begin = temp;
			}
			//System.out.println(begin + " " + end);
		}
		return end;
	}
	
	private static boolean binarySearch(int[] array, int ele) {

		int begin = 0;
		int end = array.length - 1;
		int mid = (begin+end)/2;
		
		if(ele == array[begin]) {
			return true;
		}else if(ele == array[end]) {
			return true;
		}else if(ele > array[begin] && ele < array[end]) {
			while(begin != end && end-begin != 1) {
				int currEle = array[mid];
				if(ele < currEle) {
					end = mid;
				}else if(ele > currEle) {
					begin = mid;
				}else {
					return true;
				}
				mid = (begin+end)/2;
			}
			return false;
		}else {
			return false;
		}
	}
	
}
