package src;

import java.io.*;
import java.util.*;

public class DecisionTree {
    private String fileName;
    private Node startingNode;
    
  //Instantiating the class allows to avoid the static limitation of main(), though why we should avoid it, what it actually is,  etc. still eludes me
    DecisionTree(String fileName) {
        this.fileName = fileName;
    }
    
  //Runs the actual program and provides the name of the file
    public static void main(String[] args) {
        DecisionTree decisionTree = new DecisionTree("decision-tree-data.txt");
        decisionTree.run();
    }
    
  //If the program has issues reading or finding the file it will throw an error
    void run() {
        try {
            readFile();
            readInput();
        } 
        catch (IOException FileNotFound) {
            System.out.println("Something went wrong while finding or reading the file. Please ensure it exists and is accessible.");
        }
    }
    
    void readFile() throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        ArrayList<String[]> nodeStrings = new ArrayList<>();
        ArrayList<String[]> edgeStrings = new ArrayList<>();
        ArrayList<Node> allNodes = new ArrayList<>();
        ArrayList<Node> possibleNodes = new ArrayList<>();
        
      //So long as there are lines in the file, split each line into parts divided by a comma and whitespace on either side. Then add the resulting string lists to either nodeStrings
      //or edgeStrings based on length
        while ((line = reader.readLine()) != null) {
            String[] splitLine = line.split("\\s*,\\s*");
            if (splitLine.length == 2 ? nodeStrings.add(splitLine) : edgeStrings.add(splitLine)); 
        }
      //For each string list in nodeStrings, create a new Node object with the values inside the string list and add the new object to the ArrayList of type Node
        for (String[] i : nodeStrings) {
            Node node = new Node(i[0],i[1]);
            allNodes.add(node);
        }
      //Iterates over all edges in edgeStrings. If first value equals the ID of a node, set the variable origin's value to that of the entire node.
      //If the second value equals a node's ID turn the destination variable value to that of the entire node
        for (String[] i : edgeStrings) {
            Node origin = null;
            Node destination = null;
            for(Node node : allNodes) {
                if(i[0].equals(node.getId())) {
                	origin = node;
                }
                else if(i[1].equals(node.getId())) {
                	destination = node;
                }
            }
          //Add the edge destination nodes to the possibleNodes arraylist
            possibleNodes.add(destination);
          //Create a new Edge object with the values mentioned above and set its string to that of the third value
            Edge edge = new Edge(origin, destination, i[2]);
          //Adds the newly created edge to the arraylist inside the node object inside the origin variable
            origin.addEdge(edge);
        }
      //Removes all nodes inside possibleNodes from allNodes so only the starting node remains
        allNodes.removeAll(possibleNodes);
      //Sets the first node to the variable startingNode
        startingNode = allNodes.get(0);
        reader.close();
    }

	void readInput() {
	    Node currentNode = startingNode;
	    Scanner scanner = new Scanner(System.in);
	  //So long as there is an destination (edge) for the node to refer to...
	    while (true) {
	      //Print the question stored in the node, as well as the answer when the final node is reached
	        System.out.println(currentNode.questionOrAnswer);
	      //If there's no destination or edge stop the while loop
	        if(currentNode.edges.size() == 0) {
	            return;
	        }
	        System.out.println("Ja of Nee?");
	        String input = scanner.next();
	      //Checks the edges stored inside the node for the one that holds an answer that matches that of the input
	        if (input.equalsIgnoreCase("ja") || input.equalsIgnoreCase("nee")) {
	            for (Edge edge : currentNode.edges) {
	              //When (if..w/e) it finds the right edge..
	                if (edge.answer.equalsIgnoreCase(input)) {
	                  //..the destination stored inside that edge then becomes the new currentNode and so it continues until the final node is reached
	                    currentNode = edge.destination;
	                }
	            }
	        }
	      //Prevents incorrect input.
	        else {
	        	System.out.println("Please enter only 'ja'  or 'nee'.");
		    }
		}
	}
}