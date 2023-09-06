package Week4;

import java.io.*;
import java.util.*;

class Day18 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(tk.nextToken());
		int M = Integer.parseInt(tk.nextToken());
		
		long[][][] board = new long[N][N][2]; // 보드Y 보드X 가로세로
		
		for(int i=0; i<M; i++) {
			tk = new StringTokenizer(br.readLine(), " ");
			int y = Integer.parseInt(tk.nextToken()) - 1;
			int x = Integer.parseInt(tk.nextToken()) - 1;
			String direction = tk.nextToken();
			
			switch(direction) {
				case "U" :
					for(int a=y; a>=0; a--) board[a][x][1]++;
					break;
				case "D" :
					for(int a=y; a<N; a++) board[a][x][1]++;
					break;
				case "L" :
					for(int a=x; a>=0; a--) board[y][a][0]++;
					break;
				case "R" :
					for(int a=x; a<N; a++) board[y][a][0]++;
			}
		}
		
		long count = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				count += (board[i][j][0] * board[i][j][1]);
			}
		}
		System.out.print(count);
	}
}