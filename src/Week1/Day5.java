package Week1;

import java.io.*;
import java.util.*;

class Day5 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(tk.nextToken());
		int K = Integer.parseInt(tk.nextToken());
		
		tk = new StringTokenizer(br.readLine(), " ");
		int[][] list = new int[N][2];
		for(int i=0; i<N; i++) {
			list[i][0] = Integer.parseInt(tk.nextToken());
			list[i][1] = countBinary(list[i][0]);
		}
		
		Arrays.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1])
					return o2[0] - o1[0];
				else
					return o2[1] - o1[1];
			}
		});
		
		System.out.print(list[K-1][0]);
	}
	
	public static int countBinary(int num) {
		int count = 0;

		while(num != 0 && num != 1) {
			if(num % 2 == 1) count++;
			num /= 2;
		}
		if(num == 1) count++;
	
		return count;
	}
}