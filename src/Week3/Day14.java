package Week3;

import java.io.*;
import java.util.*;

class Day14 {
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static int[] visited;
	static int count = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(tk.nextToken());
		int M = Integer.parseInt(tk.nextToken());
		int K = Integer.parseInt(tk.nextToken());
		
		visited = new int[N];
		
		for(int i=0; i<N; i++) graph.add(new ArrayList<Integer>());
		for(int i=0; i<M; i++) {
			tk = new StringTokenizer(br.readLine(), " ");
			
			int u = Integer.parseInt(tk.nextToken()) - 1;
			int v = Integer.parseInt(tk.nextToken()) - 1;
			
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		for(int i=0; i<N; i++) Collections.sort(graph.get(i));
		
		dfs(K - 1);
		
		int countNode = 0;
		int maxIndex = 0;
		int maxCount = 0;
		
		for(int i=0; i<visited.length; i++) {
			if(visited[i] == 0) continue;
			countNode++;
			if(maxCount < visited[i]) {
				maxCount = visited[i];
				maxIndex = i;
			}
		}
		
		System.out.print(countNode + " " + (maxIndex+1));
	}
	
	public static void dfs(int R) {
		visited[R] = ++count;
		
		for(int v : graph.get(R)) {
			if(visited[v] == 0) {
				dfs(v);
				break;
			}
		}
	}
}