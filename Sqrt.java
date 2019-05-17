package main.java.binarysearch;

public class Sqrt {

	public static void main(String[] args) {
		System.out.println(mySqrt(1000000));

		System.out.println(floorSqrt(1000000));
		
		//System.out.println(mySqrt(81));
		//for (int i = 0 ; i< 100; i ++) { System.out.println(i + " " + mySqrt(i)); }
	}
	
	public static int mySqrt(int x) {
		if(x == 0) {
			return 0;
		}
        return getPower(1, (x/2)+1, x);
    }
	
	private static int getPower(int begin, int end, int num) {
		int mid = (begin+end)/2;
		double midSq = (double)mid * (double)mid;
		if(midSq == num) {
			return mid;
		}else if(midSq > num) {
			return getPower(begin, mid-1, num);
		}else if(midSq < num && begin <= end) {
			return getPower(mid+1, end, num);
		}
		return mid;
	}
	
	public static int floorSqrt(int x) 
    { 
        // Base Cases 
        if (x == 0 || x == 1) 
            return x; 
  
        // Do Binary Search for floor(sqrt(x)) 
        int start = 1, end = x, ans=0; 
        while (start <= end) 
        { 
            int mid = (start + end) / 2; 
  
            // If x is a perfect square 
            if (mid*mid == x) 
                return mid; 
  
            // Since we need floor, we update answer when mid*mid is 
            // smaller than x, and move closer to sqrt(x) 
            if (mid*mid < x) 
            { 
                start = mid + 1; 
                ans = mid; 
            } 
            else   // If mid*mid is greater than x 
                end = mid-1; 
        } 
        return ans; 
    } 
  
}
