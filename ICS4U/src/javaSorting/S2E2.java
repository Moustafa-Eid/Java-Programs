package javaSorting;

public class S2E2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] numbers = {6,1,2,3};
		double half;
		double median;
		
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
						
			median = ((numbers[(int) half-1] + numbers[(int) half]) / 2.0);
			
		}
		else {
			median = (double) (numbers[(int) half]);

		}
		
		System.out.print("[");
		for (int i = 0; i < numbers.length; i++) {
			if (i < numbers.length -1) {
				System.out.print(numbers[i] + ", ");
			}
			else {
				System.out.print(numbers[i]+"]");
			}
		}
		System.out.println("\nThe median for the above array is " + median + ".");
	}

}
