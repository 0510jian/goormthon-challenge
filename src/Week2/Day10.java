package Week2;

import java.io.*;
import java.util.*;

class Day10 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] temp = br.readLine().split(" ");
		int[] goorm = {Integer.parseInt(temp[0]) - 1, Integer.parseInt(temp[1]) - 1};
		temp = br.readLine().split(" ");
		int[] player = {Integer.parseInt(temp[0]) - 1, Integer.parseInt(temp[1]) - 1};
		
		boolean[][] visitGoorm = new boolean[N][N];
		boolean[][] visitPlayer = new boolean[N][N];
		
		String[][] board = new String[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				board[i][j] = tk.nextToken();
			}
		}
		
		visitGoorm[goorm[0]][goorm[1]] = true;
		visitPlayer[player[0]][player[1]] = true;
		int pointGoorm = playGame(board, visitGoorm, goorm, N);
		int pointPlayer = playGame(board, visitPlayer, player, N);
		
		if(pointGoorm > pointPlayer) System.out.print("goorm " + pointGoorm);
		else System.out.print("player " + pointPlayer);
	}
	
	public static int playGame(String[][] board, boolean[][] visit, int[] user, int N) {
		boolean isBreak = false;
		while(true) {
			if(isBreak) break;
			
			String[] go = new String[2];
			go[0] = board[user[0]][user[1]].substring(0, board[user[0]][user[1]].length()-1);
			go[1] = String.valueOf(board[user[0]][user[1]].charAt(board[user[0]][user[1]].length()-1));

			if(go[1].equals("L")) {
				for(int i=0; i<Integer.parseInt(go[0]); i++) {
					user[1]--;
					if(user[1] < 0) user[1] = N-1;
						
					if(visit[user[0]][user[1]]) {
						isBreak = true;
						break;
					}
						
					//방문처리
					if(!visit[user[0]][user[1]]) visit[user[0]][user[1]] = true;
				}
			} else if(go[1].equals("R")) {
				for(int i=0; i<Integer.parseInt(go[0]); i++) {
					user[1]++;
					if(user[1] > N-1) user[1] = 0;
						
					if(visit[user[0]][user[1]]) {
						isBreak = true;
						break;
					}
						
					//방문처리
					if(!visit[user[0]][user[1]]) visit[user[0]][user[1]] = true;
				}
			} else if(go[1].equals("U")) {
				for(int i=0; i<Integer.parseInt(go[0]); i++) {
					user[0]--;
					if(user[0] < 0) user[0] = N-1;
						
					if(visit[user[0]][user[1]]) {
						isBreak = true;
						break;
					}
						
					//방문처리
					if(!visit[user[0]][user[1]]) visit[user[0]][user[1]] = true;
				}
			} else {
				for(int i=0; i<Integer.parseInt(go[0]); i++) {
					user[0]++;
					if(user[0] > N-1) user[0] = 0;
						
					if(visit[user[0]][user[1]]) {
						isBreak = true;
						break;
					}
						
					//방문처리
					if(!visit[user[0]][user[1]]) visit[user[0]][user[1]] = true;
				}
			}
		}
		
		int point = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(visit[i][j]) point++;
			}
		}
		return point;
	}
}