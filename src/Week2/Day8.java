package Week2;

import java.io.*;
class Day8 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int countItem = 0;
		countItem += (N / 14);
		N %= 14;
		countItem += (N / 7);
		countItem += N % 7;
		
		System.out.println(countItem);
	}
}