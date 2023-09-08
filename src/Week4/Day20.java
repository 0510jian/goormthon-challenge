package Week4;

import java.io.*;
import java.util.*;

class Day20 {
	static class Node {
		int y;
		int x;
		
		Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	static int N, K;
	static String[] board;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(tk.nextToken());
		K = Integer.parseInt(tk.nextToken());
		int Q = Integer.parseInt(tk.nextToken());
		
		board = new String[N*N];
		for(int i=0; i<N; i++) {
			String[] split = br.readLine().split("");
			for(int j=0; j<N; j++) {
				board[i*N + j] = split[j];
			}
		}
		
		for(int i=0; i<Q; i++) {
			tk = new StringTokenizer(br.readLine(), " ");
			int y = Integer.parseInt(tk.nextToken()) - 1;
			int x = Integer.parseInt(tk.nextToken()) - 1;
			String d = tk.nextToken();
			
			board[y*N+ x] = d;
			
			bfs(y, x);
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				bw.write(board[i*N + j] + "");
			}
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	public static void bfs(int y, int x) {
		int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		boolean[] visited = new boolean[N*N];
		String[] origBoard = board.clone();

		int count = 1;
		Queue<Node> queue = new LinkedList();
		queue.offer(new Node(y, x));
		board[y*N + x] = ".";
		visited[y*N + x] = true;
		
		while(!queue.isEmpty()) {
			Node u = queue.poll();
			
			for(int i=0; i<direction.length; i++) {
				int Y = u.y + direction[i][0];
				int X = u.x + direction[i][1];
				if(Y < 0 || Y >= N || X < 0 || X >= N) continue;
				if(visited[Y*N + X]) continue;
				
				if(origBoard[Y*N + X].equals(origBoard[u.y*N + u.x])) {
					board[Y*N + X] = ".";
					visited[Y*N + X] = true;
					queue.offer(new Node(Y, X));
					count++;
				}
			}
		}
		
		if(count < K) board = origBoard;
	}
}