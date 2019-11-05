package javaRecursion;

public class A1E3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Factorial(5);
	}
	public static void Factorial (int num) {
		System.out.print(num + "! = ");
		for (int i = 0; i < num; i++) {
			if (i != num-1) {
				System.out.print(num - i + " X ");
			}
			else {
				System.out.print(num - i);
			}
		}
		System.out.print(" = " + FacCalc(num));
	}
	
	public static int FacCalc (int num) {
		if (num == 0) {
			return 1;
		}
		if (num == 1) {
			return 1;
		}
		else {
			return num * FacCalc (num - 1);
		}
	}
}
