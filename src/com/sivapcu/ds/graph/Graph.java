package com.sivapcu.ds.graph;

import com.sivapcu.ds.queue.Queue;
import com.sivapcu.ds.stack.Stack;

public class Graph {
	private Vertex[] vertexList;
	private int[][] adjMatrix;
	private int verticesCount;
	private Stack stack;
	private Queue queue;
	
	public Graph(int size) {
		vertexList = new Vertex[size];
		adjMatrix = new int[size][size];
		verticesCount = 0;
		
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				adjMatrix[i][j] = 0;
			}
		}
		stack = new Stack(size);
		queue = new Queue(size);
	}
	
	public void addVertex(char label) {
		vertexList[verticesCount++] = new Vertex(label);
	}
	
	public void addEdge(int from, int to) {
		adjMatrix[from][to] = 1;
		adjMatrix[to][from] = 1;
	}
	
	public void displayVertex(int i){
		System.out.print(vertexList[i].label+"  ");
	}
	
	public void dfs() {
		vertexList[0].wasVisited = true;	// begin at 0
		displayVertex(0); 					// mark as visited
		stack.push(0);						// push it to stack
		
		while(!stack.isEmpty()) {			// until the stack is empty
			int a = getUnvisitedAdjVertex(stack.peek()); // get an unvisited adjacent vertex for the verted at the stack top
			if(a == -1) {					// no adjacency vertex found
				stack.pop();
			} else {
				vertexList[a].wasVisited = true;
				displayVertex(a);
				stack.push(a);
			}
		}
		
		// stack is now empty, reset the flags
		resetVisitedFlags();
	}
	
	public void bfs() {
		vertexList[0].wasVisited = true;
		displayVertex(0);
		queue.insert(0);

		while(!queue.isEmpty()) {
			int v1 = queue.remove();
			int a;
			while((a = getUnvisitedAdjVertex(v1)) != -1) {
				vertexList[a].wasVisited = true;
				displayVertex(a);
				queue.insert(a);
			}
		}
		
		resetVisitedFlags();
	}

	private void resetVisitedFlags() {
		for(int i = 0; i < verticesCount; i++) {
			vertexList[i].wasVisited = false;
		}
	}

	private int getUnvisitedAdjVertex(int row) {
		for(int col = 0; col < verticesCount; col++) {
			if(adjMatrix[row][col] == 1 && vertexList[col].wasVisited == false) {
				return col;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Graph g = new Graph(5);
		g.addVertex('A');
		g.addVertex('B');
		g.addVertex('C');
		g.addVertex('D');
		g.addVertex('E');
		
		g.addEdge(0, 1); // AB
		g.addEdge(1, 2); // BC
		g.addEdge(0, 3); // AD
		g.addEdge(3, 4); // DE
		
//		g.addEdge(0, 2);
//		g.addEdge(2, 4);
//		g.addEdge(4, 0);
		System.out.println("DFS");
		g.dfs();
		System.out.println();
		System.out.println("BFS");
		g.bfs();
	}
}
