package graphTraversal;

import java.util.Stack;

import graphImpl.GraphAM;


public class DFSAM extends GraphAM{
	
	boolean visited[];
	
	public DFSAM(int V) {
		super(V);
		visited=new boolean[V];
	}
	
	public DFSAM(int V, int E) {
		super(V, E);
		visited=new boolean[V];
	}
	public void clearVisited() {
		visited=new boolean[V()];
	}
	public void DFS() {
		
		Stack<Integer> s= new Stack<Integer>();
		clearVisited();
		s.push(0);
		
		while(!s.isEmpty()) {
			int nextNode;
			int i;
			nextNode=s.pop();
			if(!visited[nextNode]) {
				visited[nextNode]=true;
				System.out.println("nextNode= "+nextNode);
				
				for(i=0;i<V;i++) {
					//for(i=V-1;i>=0;i--) {
					if((adjMatrix[nextNode][i]==true)&&!visited[i])
						s.push(i);
					}
			}
		}
	}
	public static void main(String[] args) {
		DFSAM D=new DFSAM(5,7);
		System.out.println(D.toString());
		D.DFS();
	}
}
	