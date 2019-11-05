package javaRecursion;

public class A1E1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(triangleNum(2));
	}
	public static int triangleNum (int num) {
		if (num == 1) {
			return 1;
		}
		else {
			return triangleNum (num-1) + num;
		}
	}
}
