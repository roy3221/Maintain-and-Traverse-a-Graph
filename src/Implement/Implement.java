/*
 * the control of the all program:
 * 		check input file line by line;
 *  	traversal and update the graph;
 * 		create the output file.
 */

package Implement;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import IO.*;
import Model.Edge;
import Model.Graph;

public class Implement {
	Graph mGraph;
	Input input;
	Output output;
	String line;
	
	public Implement() throws IOException {
		mGraph = new Graph();
		input = new Input("inputs/Input");
		output = new Output("outputs/Output");
	}
	
	// read each line from input file.
	public void readLine() throws IOException {
		while(!input.finish()) {
			line = input.getLine();
			while(!isValidInput(line) && !input.finish()) line = input.getLine();
			if(!input.finish()){
				String[] words = line.split(" ");
				handleQuery(words);		
			}		
		}
		output.finish();
	}
	
	// to check the input line is valid or not.
	private boolean isValidInput(String line) {
		if(line == null) return false;
		String[] words = line.split(" ");
		if(words.length == 3 && (words[0].equals("add") || words[0].equals("remove")) && isInteger(words[1]) && isInteger(words[2]))
			return true;
		else if(words.length == 4 && words[0].equals("is") && words[1].equals("linked") && isInteger(words[2]) && isInteger(words[3]))
			return true;
		return false;		
	}
	
	// a help method to check a String is an Integer or not.
	private boolean isInteger(String str) {
	    try {
	        Integer.parseInt(str);
	        return true;
	    }
	    catch(Exception e) {
	        return false;
	    }
	}
	
	// handle the valid query, if the query is "is linked", put to output file
	private void handleQuery(String[] words) throws IOException {
		Edge edge = createEdge(words);
		if(words.length == 3 && words[0].equals("add")) 
			mGraph.add(edge);
		if(words.length == 3 && words[0].equals("remove")) 
			mGraph.remove(edge);
		if(words.length == 4){
			boolean hasLink = mGraph.hasLink(edge);
			output.putLine(String.valueOf(hasLink));
		}
	}
	
	// a method to create an Edge object.
	private Edge createEdge(String[] words) {
		int node1 = Integer.parseInt(words[words.length-2]);
		int node2 = Integer.parseInt(words[words.length-1]);
		return new Edge(node1, node2);
	}
}
