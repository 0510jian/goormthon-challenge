package Week2;

import java.io.*;
import java.util.*;

class Day9 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(tk.nextToken());
		int K = Integer.parseInt(tk.nextToken());
		
		String[][] ground = new String[N][N];
		int[][] point = new int[N][N];
		for(int i=0; i<N; i++) {
			tk = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				ground[i][j] = tk.nextToken();
			}
		}
		
		int max = 0;
		int[][] area = {{1,0}, {0,-1}, {0,0}, {0,1}, {-1,0}};
		for(int k=0; k<K; k++) {
			tk = new StringTokenizer(br.readLine());
			int Y = Integer.parseInt(tk.nextToken()) - 1;
			int X = Integer.parseInt(tk.nextToken()) - 1;
			
			for(int l=0; l<area.length; l++) {
				try {
					if(ground[Y+area[l][0]][X+area[l][1]].equals("0")) point[Y+area[l][0]][X+area[l][1]]++;
					else if(ground[Y+area[l][0]][X+area[l][1]].equals("@")) point[Y+area[l][0]][X+area[l][1]] += 2;
				
					if(max < point[Y+area[l][0]][X+area[l][1]]) max = point[Y+area[l][0]][X+area[l][1]];
				} catch(Exception e) {} 
			}
		}
		
		System.out.print(max);
	}
}