package main.java.binarysearch;

import java.util.Arrays;

public class SearchRotatedSortedArray {

	public static void main(String[] args) {
		int[] array = {1,3,4};
		int ele = 2;
		int index = searchRotatedSortedArray(array, ele);
		System.out.println(index);
	}

	private static int searchRotatedSortedArray(int[] nums, int target) {
		if(nums.length == 0) {
			return -1;
		}else if(nums.length == 1) {
			if(nums[0] == target) {
				return 0;
			}else {
				return -1;
			}
		}
		int pos = findPivot(nums);
		//System.out.println(pos);

		int[] array1 = Arrays.copyOfRange(nums, 0, pos);
		int[] array2 = Arrays.copyOfRange(nums, pos, nums.length);
		int index = binarySearch(array1, target);
		if(index == -1) {
			index = binarySearch(array2, target);
			if(index != -1) {
				index += array1.length;
			}
		}
		//System.out.println("Index" + index);
		return index;
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
	
	private static int binarySearch(int[] array, int ele) {

		int begin = 0;
		int end = array.length - 1;
		int mid = (begin+end)/2;
		
		if(ele == array[begin]) {
			return begin;
		}else if(ele == array[end]) {
			return end;
		}else if(ele > array[begin] && ele < array[end]) {
			while(begin != end && end-begin != 1) {
				int currEle = array[mid];
				if(ele < currEle) {
					end = mid;
				}else if(ele > currEle) {
					begin = mid;
				}else {
					return mid;
				}
				mid = (begin+end)/2;
			}
			return -1;
		}else {
			return -1;
		}
	}
	
}
