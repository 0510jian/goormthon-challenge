package Week3;

import java.io.*;
import java.util.*;

class Day11 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] split = br.readLine().split(" ");
		int A = Math.max(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
		int B = Math.min(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
		
		int count = Integer.MAX_VALUE;
		for(int i=N/A; i>=0; i--) {
			if((N - i*A) % B != 0) continue;
			
			for(int j=0; j<N/B+1; j++) {
				if(i * A + j * B == N) {
					System.out.print(i+j);
					return;
				}
			}
		}
		System.out.print(-1);
	}
}