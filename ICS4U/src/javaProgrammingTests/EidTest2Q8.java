package javaProgrammingTests;
import java.util.Scanner;
public class EidTest2Q8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// declaring variables
		String firstname, lastname, name;
		int index = 0;
		
		// initiating scanner
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter your name: ");
		// adding string to variable
		name = input.nextLine();
		
		for (int i = name.length() - 1; i > 0; i--) {
			if (name.substring(i,i+1).equals(" ")) {
				index = i;
				break;
			}
		}
		
		
		// making last name equal to variable
		lastname = name.substring(index+1, name.length());
		
		// making first name equal to variable
		firstname = name.substring(0 , index + 1);
		
		// printing it
		System.out.println(lastname.toUpperCase() + "," + " " + firstname);
	}

}
