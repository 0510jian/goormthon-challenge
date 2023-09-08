package Week4;

import java.io.*;
import java.util.*;

class Day19 {
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static int N, S, E;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(tk.nextToken()); // 도시의 수
		int M = Integer.parseInt(tk.nextToken()); // 도로의 수
		S = Integer.parseInt(tk.nextToken()) - 1; // 출발 도시
		E = Integer.parseInt(tk.nextToken()) - 1; // 도착 도시
		
		for(int i=0; i<N; i++) graph.add(new ArrayList<Integer>());
		
		for(int i=0; i<M; i++) {
			tk = new StringTokenizer(br.readLine(), " ");
			
			int u = Integer.parseInt(tk.nextToken()) - 1;
			int v = Integer.parseInt(tk.nextToken()) - 1;
			
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		
		for(int i=0; i<N; i++) System.out.println(bfs(i));
	}
	
	public static int bfs(int R) {
		// 시작 도시나 도착 도시가 공사중일 경우 -1 반환
		if(S == R || E == R) return -1;
		
		int[] visited = new int[N];
		visited[S] = 1;
		
		Queue<Integer> queue = new LinkedList();
		queue.offer(S);
		
		while(!queue.isEmpty()) {
			int u = queue.poll();
			
			for(int v : graph.get(u)) {
				// 공사중일 경우 지나갈 수 없음
				if(v == R) continue;
				
				if(visited[v] == 0 || (visited[v] != 0 && visited[v] > visited[u] + 1)) {
					visited[v] = visited[u] + 1;
					queue.offer(v);
				}
			}
		}
		
		if(visited[E] == 0) return -1;
		else return visited[E];
	}
}