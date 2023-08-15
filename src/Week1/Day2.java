package Week1;

import java.io.*;
import java.util.*;

class Day2 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int T = sc.nextInt();
		int M = sc.nextInt();
		
		for(int i=0; i<N; i++) {
			int c = sc.nextInt();
			M += c;
		}
		
		T = (T + M / 60) % 24;
		M %= 60;
		
		System.out.print(T + " " + M);
	}
}