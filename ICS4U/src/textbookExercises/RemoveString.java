package textbookExercises;
import java.util.Scanner;
public class RemoveString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sentence,removed,word,first = "",last = "";
		int counter = 0;
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a Sentence: ");
		sentence = input.nextLine();
		System.out.print("Enter a string: ");
		removed = input.nextLine();
		
		input.close();
		
		for (int i = 0; i < sentence.length(); i++) {
			for (int j = i; j < sentence.length(); j++) {
				if (sentence.substring(i, j).equals(removed)) {
					first = sentence.substring(0,i);
					last = sentence.substring(j);
				}
			}
		}
		
		System.out.println(first + last.substring(1, last.length()));
			
	}

}
