import java.util.*;

public class CCCQ1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numV;
		double min = 0;
		Scanner input = new Scanner (System.in);
		numV = input.nextInt();
		input.nextLine();
		
		int pos[] = new int[numV];
		double territory[] = new double[numV];
		
		for (int i = 0; i < numV; i++) {
			pos[i] = input.nextInt();
			input.nextLine();
		}
		
		for (int i = 1; i < pos.length; i++) {
			while (true) {
				if (i != 0 && pos[i] < pos[i-1]) {
					int temp = pos[i-1];
					pos[i-1] = pos[i];
					pos[i] = temp; 
					i -= 1;
				}
				else {
					break;
				}
			}
		}
		
		
		territory[0] = -1;
		territory[territory.length-1] = -1;
		
		
		for (int i = 1; i < pos.length-1; i++) {
			double disleft = (pos[i] - pos[i-1])/2.0;
			double disright = (pos[i+1] - pos[i])/2.0;
			double dis = disleft + disright;
			territory[i] = dis;
		}
		
		min = territory[1];
		
		for (int i = 1; i < territory.length-1; i++) {
			if (territory[i] < min) {
				min = territory[i];
			}
		}
		
		System.out.format("%.1f", min);

	}

}
