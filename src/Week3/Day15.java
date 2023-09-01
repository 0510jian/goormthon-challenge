package Week3;

import java.io.*;
import java.util.*;

class Day15 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(tk.nextToken());
		int K = Integer.parseInt(tk.nextToken());
		
		int[][] Cs = new int[N][2]; // P C
		for(int i=0; i<N; i++) {
			tk = new StringTokenizer(br.readLine(), " ");
			
			Cs[i][0] = Integer.parseInt(tk.nextToken());
			Cs[i][1] = Integer.parseInt(tk.nextToken());
		}
		
		Arrays.sort(Cs, (o1, o2) -> {
			if(o2[1]/o2[0] == o1[1]/o1[0]) return o1[0] - o2[0];
			else return o2[1]/o2[0] - o1[1]/o1[0];
			});
		
		long result = 0;
		for(int i=0; i<Cs.length; i++) {
			// 하나 사기
			if(Cs[i][0] <= K) {
				result += Cs[i][1];
				K -= Cs[i][0];
			}
			// 나누어 사기
			else {
				int CP = Cs[i][1] / Cs[i][0];
				result += (K * CP);
				K -= K;
			}
			if(K == 0) break;
		}
		
		System.out.print(result);
	}
}