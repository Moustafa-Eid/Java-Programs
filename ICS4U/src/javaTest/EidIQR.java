package javaTest;

public class EidIQR {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] numbers = {-3,-2,-1,0,2,6};
		double half, tot1 = 0,tot2 = 0, range1, range2, iqr;
		int end, start;
		for (int i = 1; i < numbers.length; i++) {
			int temp = numbers[i];
			int pre = i-1;
			// if first number is bigger than 2nd then switch
			while ((numbers[pre] > temp) && (pre > 0)) {
				numbers[pre+1] = numbers[pre];
				pre -= 1;
			}
			if (numbers[pre] > temp) {
				numbers[pre+1] = numbers[pre];
				numbers[pre] = temp;
			}
			else {
				numbers[pre+1] = temp;
			}
		}

		
		half = (numbers.length / 2.0);
		
		if (numbers.length % 2 == 0) {
			end = (int) (half - 1);
			start = (int) (half);
			
		}
		else {
			end = (int) (half - 1.5);
			start = (int) (half + 0.5);
		}
		
		for (int i = 0; i <= end; i++) {
			tot1 += numbers[i];
		}
		for (int i = start; i < numbers.length; i++) {
			tot2 += numbers[i];
		}
		

		
		range1 = tot1 / 2;
		range2 = tot2 / 2;

		
		iqr = range2 - range1;
		
		System.out.println("IQR = " + range2 + " - " + range1 + " = " + iqr);
		
		
		

		
		
	}

}
