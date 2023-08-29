package Week3;

import java.io.*;
import java.util.*;

class Day12 {
	static boolean[] visit;
	static boolean[][] house;
	static Queue<Integer> queue = new LinkedList<>();
	static int N;
	static int[][] neighbor = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		visit = new boolean[N*N];
		house = new boolean[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				if(Integer.parseInt(tk.nextToken()) == 1) house[i][j] = true;
			}
		}

		int count = 0;
		for(int i=0; i<N*N; i++) {
			if(!house[i/N][i%N]) continue;
			if(bfs(i)) count++;
		}
		
		System.out.print(count);
	}
	
	public static boolean bfs(int R) {
		if(visit[R]) return false; // 처음부터 이미 visit인 경우 -> 이미 전기 공급 받음
		visit[R] = true;
		queue.offer(R);
		
		while(!queue.isEmpty()) {
			int u = queue.poll();
			int i = u/N;
			int j = u%N;
			
			for(int k=0; k<neighbor.length; k++) {
				try {
					int v = (i + neighbor[k][0]) * N + (j + neighbor[k][1]);
					if(!visit[v] && house[i + neighbor[k][0]][j + neighbor[k][1]]) {
						visit[v] = true;
						if(!queue.contains(v)) queue.offer(v);
					}
				} catch(Exception e) {}
			}
		}
		
		return true;
	}
}