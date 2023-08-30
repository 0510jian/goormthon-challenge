package Week3;

import java.io.*;
import java.util.*;

class Day13 {
	static int[][] building;
	static boolean[] visit;
	static int N;
	
	static Queue<Integer> queue = new LinkedList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tk.nextToken());
		int K = Integer.parseInt(tk.nextToken());
		
		building = new int[N][N];
		for(int i=0; i<N; i++) {
			tk = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				building[i][j] = Integer.parseInt(tk.nextToken());
			}
		}
		
		visit = new boolean[N*N];
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<N*N; i++) {
			int count = bfs(i);
			if(count < K) continue;
			
			if(map.containsKey(building[i/N][i%N])) map.put(building[i/N][i%N], map.get(building[i/N][i%N]) + 1);
			else map.put(building[i/N][i%N], 1);
		}
		
		int maxKey = 0, maxCount = 0;
		for(int key : map.keySet()) {
			if(maxCount < map.get(key) || (maxCount == map.get(key) && maxKey < key)) {
				maxKey = key;
				maxCount = map.get(key);
			}
		}
		System.out.print(maxKey);
	}
	
	public static int bfs(int R) {
		int count = 0;
		
		if(visit[R]) return count;
		visit[R] = true;
		count++;
		
		int[][] list = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		
		queue.offer(R);
		
		while(!queue.isEmpty()) {
			int u = queue.poll();
			
			for(int i=0; i<list.length; i++) {
				int v = (u/N + list[i][0]) * N + (u%N + list[i][1]);
				try {
					if(visit[v] || building[u/N][u%N] != building[u/N + list[i][0]][u%N + list[i][1]]) continue;
					
					count++;
					visit[v] = true;
					queue.offer(v);
				} catch(Exception e) {} // 인덱스 범위 초과
			}
		}
		
		return count;
	}
}