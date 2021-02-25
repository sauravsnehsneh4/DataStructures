package graphTraversal;

import java.util.Iterator;
import java.util.LinkedList;

import graphImpl.GraphAL;

public class BFSAL extends GraphAL{
	public BFSAL(int V) {
		super(V);
	}
	public BFSAL(int V, int E) {
		super(V, E);
	}

	public void BFS(int s){
        boolean visited[] = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[s]=true;
        queue.add(s);
 
        while (queue.size() != 0){
            s = queue.poll();
            System.out.print(s+" ");
            Iterator<Integer> i = adjList[s].listIterator();
            while (i.hasNext()){
                int n = i.next();
                if (!visited[n]){
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
 
    // Driver method to
    public static void main(String args[])
    {
        BFSAL g = new BFSAL(4);
 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        System.out.println("Following is Breadth First Traversal "+
                           "(starting from vertex 2)");
 
        g.BFS(2);
    }
}
