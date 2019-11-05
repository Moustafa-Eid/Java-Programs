package textbookExercises;

public class GeneratedNums {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] gnumber = new int[101];
		int one,ten,hundred;


		for (int i = 0; i < gnumber.length; i++) {
			one = i % 10;
			ten = (i /10) % 10;
			hundred = (i/100) % 10;
			gnumber[i] = i+one+ten+hundred;
		}
		
		System.out.format("%-10s%s\n", "Index","Generated Number");
		
		for (int i = 0; i < gnumber.length; i++) {
			System.out.format("%-10d%d\n", i,gnumber[i]);
		}
	}

}
