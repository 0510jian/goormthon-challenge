package Week4;

import java.io.*;
import java.util.*;

class Day17 {
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static ArrayList<ArrayList<Integer>> component = new ArrayList<>();
	static HashMap<ArrayList<Integer>, Integer> map = new HashMap<>();
	
	static int N;
	static int[] visited;
	static int count = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(tk.nextToken());
		int M = Integer.parseInt(tk.nextToken());
		
		int[] countU = new int[N];
		visited = new int[N];
		
		for(int i=0; i<N; i++) graph.add(new ArrayList<Integer>());
		
		for(int i=0; i<M; i++) {
			tk = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(tk.nextToken()) - 1;
			int v = Integer.parseInt(tk.nextToken()) - 1;
			
			countU[u]++;
			
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		
		for(int i=0; i<N; i++) bfs(i);
		
		/*
		float[] density = new float[component.size()];
		for(int i=0; i<component.size(); i++) {
			Collections.sort(component.get(i));
			
			// 밀도 측정
			density[i] = (float)countComponent.get(i) / (float)component.get(i).size();
		}
		*/
		
		
		// 밀도가 높은 컴포넌트
		Collections.sort(component, (o1, o2) -> {
			// 컴퓨터의 수가 가장 작은 컴포넌트
			if(map.get(o1) == map.get(o2)) {
				// 더 작은 번호 컴퓨터 컴포넌트
				if(o1.size() == o2.size()) {
					return Collections.min(o1) - Collections.min(o2);
				} else {
					return o1.size() - o2.size();
				}
			} else {
				return map.get(o2) - map.get(o1);
			}
		});
		
		Collections.sort(component.get(0));
		for(int i : component.get(0)) System.out.print((i+1) + " ");
	}
	
	public static void bfs(int R) {
		if(graph.get(R).size() == 0 || visited[R] != 0) return;
		
		visited[R] = ++count;
		int countComponentTemp = 0; // 통신 회선 개수 카운트
		component.add(new ArrayList<Integer>());
		component.get(component.size()-1).add(R);
		
		Queue<Integer> queue = new LinkedList();
		queue.offer(R);
		
		while(!queue.isEmpty()) {
			int u = queue.poll();
			
			for(int v : graph.get(u)) {
				countComponentTemp++;
				if(visited[v] == 0) {
					visited[v] = visited[R];
					component.get(component.size()-1).add(v);
					queue.offer(v);
				}
			}
		}
		
		map.put(component.get(component.size()-1), countComponentTemp / 2);
	}
}