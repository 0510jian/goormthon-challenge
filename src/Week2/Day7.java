package Week2;

import java.io.*;
import java.util.*;

class Day7 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(tk.nextToken());
		int K = Integer.parseInt(tk.nextToken());
		
		// 게임판 구성
		boolean[][] board = new boolean[N][N];
		for(int i=0; i<N; i++) {
			tk = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				board[i][j] = tk.nextToken().equals("1") ? true : false;
			}
		}
		
		// 깃발 개수 카운트
		int countK = 0;
		int[][] search = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				// 구름이 없는 칸일 경우
				if(!board[i][j]) {
					int countCloud = 0;
					for(int k=0; k<search.length; k++) {
						try {
							if(board[i+search[k][0]][j+search[k][1]]) countCloud++;
						} catch(Exception e) {}
					}
					if(countCloud == K) countK++;
				}
			}
		}
		
		System.out.print(countK);
	}
}