package textbookExercises;
import java.util.Scanner;
public class Monogram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String first,middle,last;
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter your first name: ");
		first = input.nextLine().toLowerCase();
		System.out.print("Enter your middle initial: ");
		middle = input.nextLine();
		System.out.print("Enter your last name: ");
		last = input.nextLine();
		
		input.close();
		
		System.out.format("Your monogram is: %s%s%s", first.charAt(0),(last.charAt(0)),middle.toLowerCase());
	}

}
