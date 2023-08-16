package Week1;

import java.io.*;

class Day3 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int sum = 0;
		
		int T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			String[] fomula = br.readLine().split(" ");
			
			int a = Integer.parseInt(fomula[0]);
			String operator = fomula[1];
			int b = Integer.parseInt(fomula[2]);
			
			switch(operator) {
				case "+" :
					sum += (a + b);
					break;
				case "-" :
					sum += (a - b);
					break;
				case "*" :
					sum += (a * b);
					break;
				case "/" :
					sum += (a / b);	
			}
		}
		
		System.out.print(sum);
	}
}