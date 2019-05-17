package main.java.binarysearch;

public class MedianTwoSortedArrays {

	public static void main(String[] args) {
//	 int[] firstArr = {10,23,26,30,45};
//	 int[] secondArr = {1,21,32,44,60};
	 
	 int[] firstArr = {1,2};
	 int[] secondArr = {3,4};
		
	 findMedianSortedArrays(firstArr, secondArr);
	 
//	 if(firstArr.length >= secondArr.length) {
//		 medianOfSortedArrays(firstArr, secondArr);
//	 }else {
//		 medianOfSortedArrays(secondArr, firstArr);
//	 }
	 
	}

	private static void medianOfSortedArrays(int[] firstArr, int[] secondArr) {
		int[] mergeSortedArray = new int[firstArr.length+secondArr.length];
		int mergeSortedArrayIndex = 0;
		int i = 0, j = 0;
		while(i<firstArr.length && j<secondArr.length) {
			if(firstArr[i]<secondArr[j]) {
				mergeSortedArray[mergeSortedArrayIndex] = firstArr[i];
				i++;
			}else {
				mergeSortedArray[mergeSortedArrayIndex] = secondArr[j];
				j++;
			}
			mergeSortedArrayIndex++;
		}

		int median = 0;
		if(mergeSortedArray.length%2 == 0) {
			median = (mergeSortedArray[mergeSortedArray.length/2] + mergeSortedArray[(mergeSortedArray.length-1)/2])/2;
		}else {
			median = mergeSortedArray[(mergeSortedArray.length-1)/2];
		}
		System.out.print("Median : " + median);
	}
	
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] firstArr = null;
        int[] secondArr = null;
        if(nums1.length >= nums2.length){
            firstArr = nums1;
            secondArr = nums2;
        }else{
        	firstArr = nums2;
            secondArr = nums1;
        }
		int[] mergeSortedArray = new int[firstArr.length+secondArr.length];
		int mergeSortedArrayIndex = 0;
		int i = 0, j = 0;
		while(i<firstArr.length && j<secondArr.length) {
			if(firstArr[i]<secondArr[j]) {
				mergeSortedArray[mergeSortedArrayIndex] = firstArr[i];
				i++;
			}else {
				mergeSortedArray[mergeSortedArrayIndex] = secondArr[j];
				j++;
			}
			mergeSortedArrayIndex++;
		}
		
		while(i<firstArr.length) {
			mergeSortedArray[mergeSortedArrayIndex] = firstArr[i];
			mergeSortedArrayIndex++;
			i++;
		}
		
		while(j<secondArr.length) {
			mergeSortedArray[mergeSortedArrayIndex] = secondArr[j];
			mergeSortedArrayIndex++;
			j++;
		}
		
		double median = 0;
		if(mergeSortedArray.length%2 == 0) {
			median = (double)(mergeSortedArray[mergeSortedArray.length/2] + mergeSortedArray[(mergeSortedArray.length-1)/2])/2;
		}else {
			median = (double)mergeSortedArray[(mergeSortedArray.length-1)/2];
		}
		return median;
    }
	
}
