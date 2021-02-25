package graphTraversal;

import java.util.Iterator;

import graphImpl.GraphAL;

public class DFSAL extends GraphAL{
	
	public DFSAL(int V) {
		super(V);
	}
	
	public DFSAL(int V, int E) {
		super(V, E);
	}

	public void DFSUtil(int v, boolean visited[])
    {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");
 
        Iterator<Integer> i = adjList[v].listIterator();
        while (i.hasNext()) 
        {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }
 
    public void DFS(int v)
    {
        boolean visited[] = new boolean[super.V];
        DFSUtil(v, visited);
    }
    
    public static void main(String args[])
    {
        DFSAL g = new DFSAL(4);
 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        System.out.println(
            "Following is Depth First Traversal "
            + "(starting from vertex 2)");
 
        g.DFS(2);
    }
}
