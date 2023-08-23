package Week2;

import java.io.*;
class Day8 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int countItem = 0;
		while(N > 0) {
			if(N >= 14) N -= 14;
			else if (N >= 7) N -= 7;
			else N -= 1;
	
			countItem++;
		}
		
		System.out.println(countItem);
	}
}