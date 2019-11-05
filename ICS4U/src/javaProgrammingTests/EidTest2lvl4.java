package javaProgrammingTests;
import java.util.Scanner;
public class EidTest2lvl4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				char [] letters = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
				int [] score = {1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10};
				final String PUNCTUATION = "~!@#$%^&*()_+={}[]|\\:;\"\'<,>.?/";
				String bestword = "", word = "";
				int wordscore = 0,bestwordscore = 0,totalwordscore = 0;
				double average,wordcounter = 0;
				boolean run = true,ispunctuation = false;
				Scanner input = new Scanner(System.in);
				System.out.print("Enter a word (enter -1 to end): ");

				while (run = true) {
					while (true) {
						word = input.next().toLowerCase();
						ispunctuation = false;
						for (int i=0; i<word.length();i++) {
							for (int j = 0; j<PUNCTUATION.length();j++) {
								if (word.charAt(i) == PUNCTUATION.charAt(j)) {
									ispunctuation = true;
								}
							}
						}

						if (ispunctuation == false) {
							break;
						}
					}
					
					if (word.equals("-1")) {
						break;
					}
					

					
					for (int i = 0; i < word.length(); i++) {
						for (int j = 0; j < letters.length; j++) {
							if (word.charAt(i) == (letters[j])) {
								wordscore += score[j];
							
							}
						}
					}
					totalwordscore += wordscore;
					System.out.format("%s - %d points\n",word,wordscore);
					wordcounter += 1;
					if (wordscore > bestwordscore) {
						bestwordscore = wordscore;
						bestword = word;
					}
					wordscore = 0;
				}
				average = totalwordscore / wordcounter;
				System.out.format("\nThe highest scoring word is: %s with %d points.", bestword,bestwordscore);
				System.out.format("\nThe average word score is: %.2f points.", average);

				
				
				

				
				
				
			}

	}
