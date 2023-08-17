package Week1;

import java.util.*;

class Day4 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		Integer[] array = new Integer[N];
		
		int target = 0;
		for(int i=0; i<N; i++) {
			array[i] = sc.nextInt();
			if(array[i] > target) target = array[i];
		}
		
		int sum = array[0];
		boolean up = true;
		int pre = array[0];
		
		// N이 1일 경우 return
		if(N == 1) {
			System.out.println(sum);
			return;
		}
		
		// 처음부터 내림차순일 경우
		if(pre == target) {
			pre = Integer.MAX_VALUE;
			up = false;
		}
		
		// 햄버거 확인
		for(int i=1; i<N; i++) {
			sum += array[i];
			
			// 오름차순이어야 함
			if(up) {

				// 오름차순에 맞지 않을 경우 return
				if(array[i] < pre) {
					System.out.print(0);
					return;
				}
				
				pre = array[i];
				
				// 가장 높은 재료일 시 내림차순으로 전환
				if(array[i] == target) {
					pre = Integer.MAX_VALUE;
					up = false;
				}
			}
			
			// 내림차순이어야 함
			else {

				// 내림차순에 맞지 않을 경우 return
				if(array[i] > pre) {
					System.out.print(0);
					return;
				}
				
				pre = array[i];
			}
		}
		System.out.println(sum);
	}
}