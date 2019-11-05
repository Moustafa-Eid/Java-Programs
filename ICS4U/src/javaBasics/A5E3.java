package javaBasics;
public class A5E3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number = 100, numberhundreds = 0, numbertens = 0, numberones = 0;
		
		while (number >= 100 && number < 1000) {
			numberones = number%10;
			numbertens = (number/10)%10;
			numberhundreds = (number/100)%10;
			
			if (Math.pow(numberhundreds, 3)+ Math.pow(numbertens, 3) + Math.pow(numberones, 3) == number) {
				System.out.println(number);
			}
			number++;
			
		}

	}

}
