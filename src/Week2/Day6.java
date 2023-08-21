package Week2;

import java.io.*;
import java.util.*;

class Day6 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		ArrayList<String> list = new ArrayList<>(); // 중복 없는 모든 부분 문자열
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<String[]> input = new ArrayList<String[]>(); // 각 문자열의 부분 문자열
		
		String S = br.readLine();
		
		// 부분문자열을 list에 추가 후 정렬
		int index = 0;
		for(int a=1; a<S.length()-1; a++) {
			for(int b=a+1; b<S.length(); b++) {				
				String temp1 = S.substring(0, a);
				String temp2 = S.substring(a, b);
				String temp3 = S.substring(b, S.length());
				String[] temp = {temp1, temp2, temp3};
				input.add(temp);	
				
				if(!list.contains(input.get(index)[0])) list.add(input.get(index)[0]);
				if(!list.contains(input.get(index)[1])) list.add(input.get(index)[1]);
				if(!list.contains(input.get(index)[2])) list.add(input.get(index)[2]);
				
				index++;
			}
		}
		Collections.sort(list);
		
		// 정렬 후 문자에 대한 점수 부여
		HashMap<String, Integer> map = new HashMap<>();
		for(int i=0; i<list.size(); i++) {
			map.put(list.get(i), i+1);
		}
		
		// 부분문자열의 최댓값 구하기
		int max = 0;
		for(int i=0; i<input.size(); i++) {
			String temp1 = input.get(i)[0];
			String temp2 = input.get(i)[1];
			String temp3 = input.get(i)[2];
			
			int sum = map.get(temp1) + map.get(temp2) + map.get(temp3);
				if(max < sum) max = sum;
		}
		
		// 결과 출력
		System.out.print(max);
	}
}