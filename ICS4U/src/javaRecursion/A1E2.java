package javaRecursion;

public class A1E2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FibSequence(10);
	}
	public static void FibSequence (int num) {
		System.out.println("The first " + num + " terms of the Fibonacci Sequence are:");
		for (int i = 0; i <= num; i++) {
			if (i != num) {
				System.out.print(FibTerm(i) + ", ");
			}
			else {
				System.out.print(FibTerm(i));
			}
		}
	}
	
	public static int FibTerm (int num) {
		if (num == 0) {
			return 0;
		}
		if (num == 1) {
			return 1;
		}
		else {
			return FibTerm (num-1) + FibTerm (num - 2);
		}
	}
}
