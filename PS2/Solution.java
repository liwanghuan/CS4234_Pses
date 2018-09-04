import java.util.*;
import java.io.*;

class Vertex {
	public int index;
	public ArrayList<Edge> edges;
	
	Vertex (int i) {
		this.index= i;
		this.edges = new ArrayList<Edge>();
	}
}

class Edge {
	public Vertex left;
	public Vertex right;
	public int weight;
	
	Edge(Vertex l, Vertex r, int w) {
		this.left = l;
		this.right = r;
		this.weight = w;
		l.edges.add(this);
		r.edges.add(this);
	}
}

class Solution {
	private static Scanner sc;
	private static ArrayList<Vertex> graph;
	private static ArrayList<Integer> results;
	private static int[][] memoization;
	
	private static int compute(Vertex target, int k, ArrayList<Vertex> visited) {
		if (k == 0) {
			return 0;
		} else {
			int result = Integer.MAX_VALUE;
			ArrayList<Edge> edges = target.edges;
			for (int i = 0; i < edges.size(); i++) {
				Edge current = edges.get(i);
				Vertex next;
				if (current.left.index == i) {
					next = current.right;
				} else {
					next = current.left;
				}
			
				if (!visited.contains(next)) {
					if (memoization[next.index][k-1] != 0 && memoization[next.index][k-1] < Integer.MAX_VALUE) {
						result = Math.min(memoization[next.index][k-1], result);
					} else {
						visited.add(next);
						result = Math.min(result, compute(next, k-1, visited));
						visited.remove(next);
						if (result < Integer.MAX_VALUE) result += current.weight;
						memoization[next.index][k-1] = result;
					}
				}
			}
			return result;
		}
	}
	
	public static void main(String[] args) {
		try {
			//File input = new File("C://Users/e0012666/eclipse-workspace/CS4234 PS2/src/input.txt");
			sc = new Scanner (Sytstem.in);
			results = new ArrayList<Integer>();
			while (sc.hasNext()) {
				int n = sc.nextInt();
				int k = sc.nextInt();
				int t= sc.nextInt();
				graph = new ArrayList<Vertex>();
				for (int i = 0; i < n; i++) {
					graph.add(new Vertex(i));
				}
				memoization = new int[n][k];
				for (int i = 0; i < t; i++) {
					int start = sc.nextInt();
					int end = sc.nextInt();
					int weight = sc.nextInt();
					Edge e = new Edge(graph.get(start), graph.get(end), weight);
				}
				int min = Integer.MAX_VALUE;
				for (int i = 0; i < n; i++) {
					min = Math.min(min, compute(graph.get(i), k, new ArrayList<Vertex>()));
				}
				results.add(min);
			}
			sc.close();
			for (int i = 0; i < results.size(); i++) {
				System.out.println(results.get(i));
			}
		} catch (FileNotFoundException f) {
			System.out.println(f);
		}
	}
}