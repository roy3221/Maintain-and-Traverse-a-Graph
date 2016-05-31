/*
 * A Class of Graph to maintain all Emails(Integers) as nodes.
 * Use a HashSet to maintain all links in current graph, so that we can do "is linked" in O(1);
 * The graph is maintained in a adjacent List, which implemented using a hashMap <Integer, List<Integer>>.
 */

package Model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph {
	Set<Link> links;
	Map<Integer,List<Integer>> adjacent;
	
	public Graph() {
		links = new HashSet<>();
		adjacent = new HashMap<>();
	}
	
	// add O(deg(v^deg(v))), where v is the # of nodes, deg(v) is the maximum neighbors of each node.
	public void add(Edge edge){
		if(!adjacent.containsKey(edge.small)) adjacent.put(edge.small, new LinkedList<>());
		if(!adjacent.get(edge.small).contains(edge.large)){
			adjacent.get(edge.small).add(edge.large);
			updateLinks();
		}	
	}
	
	// remove O(deg(v^deg(v))), where v is the # of nodes, deg(v) is the maxium neibors of each node.
	public void remove(Edge edge) {
		links.remove(edge);
		if(adjacent.containsKey(edge.small)&& adjacent.get(edge.small).contains(edge.large)){
			adjacent.get(edge.small).remove(adjacent.get(edge.small).indexOf(edge.large));
			updateLinks();
		}
	}
	// update links when the graph is changed.
	private void updateLinks() {
		links = new HashSet<>();
		Iterator<Integer> it = adjacent.keySet().iterator();
		while(it.hasNext()){
			int keyNode = it.next();
			for(int adjacentNode : adjacent.get(keyNode)) {
				links.add(new Link(keyNode,keyNode));
				links.add(new Link(keyNode,adjacentNode));
				getLinks(keyNode,adjacentNode);
			}
		}
		//printLinks();
	}
	
	// a recursive call for get all links for each node.
	private void getLinks(int node1, int node2) {
		if(!adjacent.containsKey(node2)) return;
		for(int node : adjacent.get(node2)) {
			links.add(new Link(node1, node));
			getLinks(node1, node);
		}	
	}
	
	// a method to print links in current graph, use for test.
	private void printLinks(){
		Iterator<Link> it = links.iterator();
		while(it.hasNext()){
			String link = (String) it.next().getLink();
			System.out.print(link+ "		");
		}
		System.out.println();
	}
	
	// is linked O(1)
	public boolean hasLink(Edge edge) {
		Link link = new Link(edge.small, edge.large);
		if(links.contains(link)) return true;
		return false;
	}
}
