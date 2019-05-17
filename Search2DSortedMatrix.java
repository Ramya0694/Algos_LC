package main.java.binarysearch;

public class Search2DSortedMatrix {
	public static void main(String[] args) {
		//int[][] matrix = {{1,2},{3,4},{5,6}};
		int[][] matrix = {{1,2,2},{4,5,6}};
		//int target = 3;
		//System.out.println(searchMatrix(matrix, 3));

		for(int i=0; i<11; i++) { System.out.println(searchMatrix(matrix, i)); }
		 
	}
	
	public static boolean searchMatrix(int[][] matrix, int target) {
		if(matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int low = 0;
        int high = rows-1;
        int col = cols/2;
        
        while(low+1 < high) {
        	int mid = (low+high)/2;
        	if(matrix[mid][col] == target) {
        		return true;
        	}else if(matrix[mid][col] > target) {
        		high = mid;
        	}else {
        		low = mid;
        	}
        }
        
        boolean exists = findElement(matrix, low, high, target);
        
        //System.out.println(low + " " + high);
        //System.out.println(exists);
        return exists;
    }

	private static boolean findElement(int[][] matrix, int low, int high, int target) {
		boolean exists = false;
		int cols = matrix[0].length;
		
		if(matrix[low][cols/2] == target || matrix[high][cols/2] == target) {
			return true;
		}
		
		exists = binarySearch(matrix[low], 0, cols/2, target);
		if(exists == false) {
			exists = binarySearch(matrix[low], cols/2, cols-1, target);
		}
		if(exists == false) {
			exists = binarySearch(matrix[high], 0, cols/2, target);
		}
		if(exists == false) {
			exists = binarySearch(matrix[high], cols/2, cols-1, target);
		}
		return exists;
	}

	private static boolean binarySearch(int[] matrix, int begin, int end, int target) {
		int mid = begin+(end-begin)/2;
		if(begin <= end) {
			if(matrix[mid] == target) {
				return true;
			}else if(matrix[mid] > target) {
				return binarySearch(matrix, begin, mid-1, target);
			}else{
				return binarySearch(matrix, mid+1, end, target);
			}
		}
		return false;
	}

}
