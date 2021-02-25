package graphAlgo;

import java.util.Iterator;
import java.util.Stack;

import graphImpl.GraphAL;

public class topologicalSort extends GraphAL{

	public topologicalSort(int V) {
		super(V);
		// TODO Auto-generated constructor stub
	}
	
	public void Sort() {
		boolean visited[]=new boolean[V];
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < V; i++) {
			if(visited[i]==false) {
				topologicalsortUtil(i,visited,stack);
				
				while(stack.isEmpty()==false) {
					System.out.println(stack.pop()+" ");
				}
			}
		}
	}

	public void topologicalsortUtil(int v, boolean[] visited, Stack<Integer> stack) {
		visited[v]=true;
		Integer i;
		
		Iterator<Integer> it = adjList[v].iterator();
		while(it.hasNext()) {
			i=it.next();
			if (!visited[i]) {
				topologicalsortUtil(i, visited, stack);
			}
			
			stack.push(v);
		}
		
	}
	
	public static void main(String args[]) 
    { 
        // Create a graph given in the above diagram 
		topologicalSort g = new topologicalSort(6); 
        g.addEdge(5, 2); 
        g.addEdge(5, 0); 
        g.addEdge(4, 0); 
        g.addEdge(4, 1); 
        g.addEdge(2, 3); 
        g.addEdge(3, 1); 
  
        System.out.println("Following is a Topological "
                           + "sort of the given graph"); 
        // Function Call 
          g.Sort(); 
    } 
}
