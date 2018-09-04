import java.util.*;

class Solution {
	private static final Scanner sc = new Scanner (System.in);
	
	private static int[][] tunnels;
	private static int[] rubbles;
	private static ArrayList<Integer> results;
	
	private static int compute(int n, int k) {
		return 0;
	}
	public static void main(String[] args) {
		results = new ArrayList<Integer>();
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int t= sc.nextInt();
			tunnels = new int[t][2];
			rubbles = new int[t];
			for (int i = 0; i < t; i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				int[] tunnel = new int[2];
				tunnel[0] = start;
				tunnel[1] = end;
				tunnels[i] = tunnel;
				int ruble = sc.nextInt();
				rubbles[i] = ruble;
			}
			results.add(compute(n, k));
		}
		
		for (int i = 0; i < results.size(); i++) {
			System.out.println(results.get(i));
		}
	}
}
