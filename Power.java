package main.java.binarysearch;

public class Power {

	public static void main(String[] args) {
		System.out.println(myPow(2,Integer.MIN_VALUE));
	}
	
	public static double myPow(double x, int n) {
        double pow = getPower(x,n);
        if(x<0 && n<0) {
        	if(n%2 == 0) {
        		return 1/pow;
        	}else {
        		return -1/pow;
        	}
        }else if(x<0 && n>0) {
        	if(n%2 == 0) {
        		return pow;
        	}else {
        		return -pow;
        	}
        }else if(x>0 && n<0) {
        	return 1/pow;
        }else {
        	return pow;
        }
    }

	private static double getPower(double x, int n) {
		if(n == Integer.MIN_VALUE) {
			n = Integer.MAX_VALUE - 1;
		}
		x = Math.abs(x);
		n = Math.abs(n);
		if(n == 0) {
        	return 1;
		}
		double temp = myPow(x, n/2);
        if(n%2 == 0) {
        	return temp * temp;
        }else {
        	return x * temp * temp;
        }
	}

}
