/*
 * a class to maintain edges between two nodes.
 * the trick here is: use a integer named small and another integer named large to 
 * represent each edge. So that, we can present all undirected edges without duplicates.
 */

package Model;

public class Edge {
	int small;
	int large;
	
	public Edge(int node1, int node2) {
		if(node1 <= node2) {
			this.small = node1;
			this.large = node2;
		}
		else {
			this.small = node2;
			this.large = node1;
		}
	}	
}
