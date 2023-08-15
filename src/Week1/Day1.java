package Week1.Day1;

import java.io.*;
import java.util.*;

class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
		int W = Integer.parseInt(tk.nextToken());
		int R = Integer.parseInt(tk.nextToken());
		
		System.out.print((int)(W * (1+R/30.0)));
	}
}