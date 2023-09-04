package Week4;

import java.io.*;
import java.util.*;

class Day16 {
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static int N;
	static int count = 0;
	static int[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(tk.nextToken());
		int M = Integer.parseInt(tk.nextToken());
		
		for(int i=0; i<N; i++) graph.add(new ArrayList<Integer>());
		visited = new int[N];
		
		for(int i=0; i<M; i++) {
			tk = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(tk.nextToken()) - 1;
			int v = Integer.parseInt(tk.nextToken()) - 1;
			
			graph.get(u).add(v);
		}
		
		for(int i=0; i<N; i++) bfs(i);
		
		System.out.print(count);
	}
	
	public static void bfs(int R) {
		if(visited[R] == 0) visited[R] = ++count;
		else return;
		
		Queue<Integer> queue = new LinkedList();
		queue.offer(R);
		
		while(!queue.isEmpty()) {
			int u = queue.poll();
			
			for(int v : graph.get(u)) {
				if(visited[v] == 0 && graph.get(v).contains(u)) {
					visited[v] = visited[R];
					queue.offer(v);
				}
			}
		}
	}
}