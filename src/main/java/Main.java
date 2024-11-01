package recursiveHM;

import java.util.Random;

public class Main {

	public static int q1(int n) {
		if (n==1) 
			return 1;
		return n+ q1(n-1);
	}


	public static int q2(int n) {
		if (n==1) 
			return 1;
		return n* q2(n-1);
	}

	public static int q3(int n) {

		if (n==1) {
			return 1;
		}
		if (n%2==0) { 
			return q3(n-1);
		}
		else {
			return n*q3(n-1);
		}

	}

	public static int q4(int n) {
		if (n==0) 
			return 0;
		return 1 + q4(n/10);
	}

	public static int q5(int numerator,int denominator) {

		if (numerator<denominator) 
			return 0;
		return 1 + q5(numerator-denominator,denominator);
	}

	public static int q6(int numerator,int denominator) {

		if (numerator<denominator) 
			return numerator;
		return q6(numerator-denominator,denominator);
	}

	public static boolean q7(int x,int y) {

		if (x<y) 
			if (x==0)
				return true;
			else
				return false;
		return q7(x-y,y);
	}


	public static boolean q8Helper(int num, int count) {

		if (num <= 1) {
			return false; 
		}
		if (count == 1) {
			return true;  
		}
		if (q7(num, count)) {
			return false; 
		}

		return q8Helper(num, count - 1);
	}

	public static boolean q8(int num) {
		return q8Helper(num, (int)Math.sqrt(num));
	}



	public static boolean q9Helper(int n,boolean isDigitEven) {
		if (n>0)
			if ((n%2 == 0)&&(isDigitEven==true)) 
				return q9Helper(n/10,true);
			else if ((n%2 == 1)&&(isDigitEven==false)) 
				return q9Helper(n/10,false);
			else
				return false;

		else
			return true;
	}

	public static boolean q9(int num) {
		if (num % 2 == 0)
			return q9Helper(num/10,true);
		else
			return q9Helper(num/10,false);

	}



/*Current Homework*/

	public static int q14(int[] a, int i) {
		if (i==0) 
			return a[0];
		return a[i]+ q14(a,i-1);
	}


	public static int q15(int[] arr,int i) {
		if (i==-1) {
			return 0;
		}
		if (arr[i]>0) {
			return 1+q15(arr,i-1);
		}
		return q15(arr,i-1);
	}

	public static int q16(int[] arr,int i,int num ) {
		if (i==-1) {
			return -1;
		}
		if (arr[i]==num) {
			return i;
		}
		return q16(arr,i-1,num);
	}

	public static boolean q17(int[] arr,int i) {
		if (i==-1) {
			return true;
		}
		if (arr[i]>=arr[i+1]) {
			return false;
		}
		else {	
			return q17(arr,i-1);
		}
	}
	
	public static boolean q18(int[] arr,int i) {
		if (i==-1) {
			return true;
		}
		if (q8(arr[i])) {
			return false;
		}
		else {	
			return q18(arr,i-1);
		}
	}
	
	public static int q19(int[][] arr,int i,int num) {
		if (i==-1) {
			return 0;
		}
		if (q16(arr[i],arr[i].length-1,num)==-1) {
			return q19(arr,i-1,num);
		}
		else {	
			return 1+q19(arr,i-1,num);
		}
	}
	
	public static boolean q20(int[] arr) {
	      
        Random rand = new Random();
        int leftPointer = rand.nextInt(arr.length);
        int rightPointer = rand.nextInt(arr.length);

        if (leftPointer > rightPointer) {
            int temp = leftPointer;
            leftPointer = rightPointer;
            rightPointer = temp;
        }
        System.out.println("Left Pointer:" + leftPointer);
        System.out.println("Right Pointer:" + rightPointer);
        
        
        return q20Helper(arr, leftPointer, rightPointer);
    }

	
	    public static boolean q20Helper(int[] arr, int left, int right) {
	      
	        if (left >= right) {
	            return true;
	        }
	       
	        if (arr[left] != arr[right]) {
	            return false;
	        }
	        return q20Helper(arr, left + 1, right - 1);
	    }
	
	public static void main(String[] args) {
		int[] arr = new int [] {1, 2, 3, 2, 1, 4, 5, 4, 1, 2, 3, 2, 1};
        System.out.println(q20(arr));
	}
	
}

