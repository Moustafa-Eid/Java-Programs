import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size;
		int counter = 0;
		Scanner input = new Scanner (System.in);
		size = input.nextInt();
		input.nextLine();
		ArrayList<Integer> num = new ArrayList();
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				num.add(new Integer (input.nextInt()));
			}
			input.nextLine();
			
		}
		
		int [] [] table = new int[size] [size];
		int [] [] table2 = new int[size] [size];
		int [] [] table3 = new int[size] [size];
		int [] [] table4 = new int[size] [size];

		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				table [i] [j] = num.get(counter);
				counter++;
			}
		}
		

		
		
		
		
		
		
		
		
		for (int i = 0; i < size; i++)
		{
			for (int j = 0; j < size; j++)
			{
				System.out.print(table [i][j] + " ");
			}
			System.out.println();

		}
		
		

	}

}
