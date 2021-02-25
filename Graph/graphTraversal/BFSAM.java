package graphTraversal;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import graphImpl.GraphAM;

public class BFSAM extends GraphAM{
	
	boolean visited[];
	
	public BFSAM(int V) {
		super(V);
		visited=new boolean[V];
	}
	
	public BFSAM(int V, int E) {
		super(V, E);
		visited=new boolean[V];
	}
	public void clearVisited() {
		visited=new boolean[V()];
	}
	public void BFS() {
		
		Queue<Integer> q= new LinkedList<Integer>();
		clearVisited();
		q.add(0);
		
		while(!q.isEmpty()) {
			int nextNode;
			int i;
			nextNode=q.remove();
			if(!visited[nextNode]) {
				visited[nextNode]=true;
				System.out.println("nextNode= "+nextNode);
				
				for(i=0;i<V;i++) {
					//for(i=V-1;i>=0;i--) {
					if((adjMatrix[nextNode][i]==true)&&!visited[i])
						q.add(i);
					}
			}
		}
	}
	public static void main(String[] args) {
		BFSAM D=new BFSAM(5,7);
		System.out.println(D.toString());
		D.BFS();
	}
}
