package main.java.binarysearch;

public class DivideIntegersBitwise {
	public static void main(String[] args) {
		int quotient = divide(179, 7);
		System.out.println(quotient);
	}

	private static int divide(int dividend, int divisor) {
		if(divisor==-1 && dividend == Integer.MIN_VALUE)
	        return Integer.MAX_VALUE;
		
		long pdividend =Math.abs((long)dividend);
		long pdivisor =Math.abs((long)divisor);
		int quo = 0;
		
		while(pdividend >= pdivisor) {
			int count = 0;
			while(pdividend >= (pdivisor << count)) {
				count++;
				//System.out.println("Count : " + count);
			}
			//System.out.println(divisor << (count-1));
			quo += 1 << (count-1);
			pdividend -= pdivisor << (count-1);
			//System.out.println("Quo : " + quo + ", Dividend : " + dividend);
		}
		
		if((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
			return quo;
		}else {
			return -quo;
		}		
	}
}
