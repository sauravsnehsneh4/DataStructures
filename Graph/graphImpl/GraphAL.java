package graphImpl;

import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;


public class GraphAL {
	private static final String NEWLINE=System.getProperty("line.separator");
	protected final int V ;
	private int E;
	public LinkedList<Integer>[] adjList;
	
	//Initializes a empty graph with V vertex and 0 edge
	public GraphAL(int V) {
		if (V<0)
			throw new IllegalArgumentException("Too few Vertices");
		this.V=V;
		this.E=0;
		adjList=new LinkedList[V];
		for(int u=0;u<V;u++) {
			adjList[u]=new LinkedList<Integer>();
		}
	}
	
	//random graph with V vertices and E Edges
	public GraphAL(int V,int E) {
		this(V);
		if(E>(long)V*(V-1)/2+V)
			throw new IllegalArgumentException("Too many Edges");
		if(E<0)
			throw new IllegalArgumentException("Too few Edges");
		Random random=new Random();
		while(this.E!=E) {
			int u=random.nextInt(V);
			int v=random.nextInt(V);
			addEdge(u,v);
		}	
	}
	
	//Initializes a new graph
	public GraphAL(GraphAL G) {
		this(G.V());
		this.E=G.E();
		for(int u=0;u<G.V();u++) {
			//reverse so that adjacency list is in same order as original
			Stack<Integer> reverse =new Stack<Integer>();
			for(int v:G.adjList[u]) {
				reverse.push(v);
			}
			for(int v:reverse) {
				adjList[u].add(v);
			}
		}
	}

	public int V() {
		return V;
	}
	public int E() {
		return E;
	}
	
	private void validateVertex(int u) {
		if(u<0||u>V)
			throw new IllegalArgumentException();
	}
	
	public void addEdge(int u,int v) {
		validateVertex(u);
		validateVertex(v);
		E++;
		adjList[u].add(v);
	}
	
	public Iterable<Integer> adjList(int u){
		validateVertex(u);
		return adjList[u];
	}
	
	public int degree(int u) {
		validateVertex(u);
		return adjList[u].size();
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("Undirected graph"+NEWLINE);
		s.append("Vertices:"+V+ " and Edges:"+E+NEWLINE);
		for(int u=0;u<V;u++) {
			s.append(u+":");
			for(int v:adjList[u]) {
				s.append(v+" ");
			}
			s.append(NEWLINE);
		}
		return s.toString();
	}
	
	
	public static void main(String[] args) {
		GraphAL G=new GraphAL(5,7);
		System.out.println(G.toString());
	}
	
}