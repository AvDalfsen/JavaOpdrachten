package src;

import java.io.*;
import java.util.*;

public class DecisionTree {
    private String fileName;
    private Node startingNode;
    
    //Instantiating the class allows to avoid the static limitation of main(), though why we should avoid it, what it actually is,  etc. still eludes me
    private DecisionTree(String fileName) {
        this.fileName = fileName;
    }
    
    //Runs the actual program and provides the name of the file
    public static void main(String[] args) {
        DecisionTree decisionTree = new DecisionTree("decision-tree-data.txt");
        decisionTree.run();
        decisionTree.readInput();
    }
    
    //If the program has issues reading or finding the file it will throw an error
    private void run() {
        try {
            readFile();
        } 
        catch (IOException FileNotFound) {
            System.out.println("Something went wrong while finding or reading the file. Please ensure it exists and is accessible.");
        }
    }
    
    private void readFile() throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        ArrayList<String[]> nodeStrings = new ArrayList<>();
        ArrayList<String[]> edgeStrings = new ArrayList<>();
        ArrayList<Node> allNodes = new ArrayList<>();
        ArrayList<Node> possibleNodes = new ArrayList<>();

        while ((line = reader.readLine()) != null) {
            String[] splitLine = line.split("\\s*,\\s*");
            if (splitLine.length > 2 ? edgeStrings.add(splitLine) : nodeStrings.add(splitLine)); 
        }
        for (String[] i : nodeStrings) {
            Node node = new Node(i[0],i[1]);
            allNodes.add(node);
        }
        for (String[] i : edgeStrings) {
            Node origin = null;
            Node destination = null;
            for(Node node: allNodes) {
                if(i[0].equals(node.getId())) {
                	origin = node;
                }
                else if(i[1].equals(node.getId())) {
                	destination = node;
                }
            }
            possibleNodes.add(destination);
            Edge edge = new Edge(origin, destination, i[2]);
            origin.addEdge(edge);
        }
        allNodes.removeAll(possibleNodes);
        startingNode = allNodes.get(0);
        reader.close();
    }

	private void readInput() {
	    Node currentNode = startingNode;
	    Scanner scanner = new Scanner(System.in);
	    while (true) {
	        System.out.println(currentNode.destination);
	        if(currentNode.edges.size() == 0) {
	            return;
	        }
	        System.out.println("Ja of Nee?");
	        String input = scanner.next();
	        if (input.equalsIgnoreCase("ja") || input.equalsIgnoreCase("nee")) {
	            for (Edge edge : currentNode.edges) {
	                if (edge.answer.equalsIgnoreCase(input)) {
	                    currentNode = edge.destination;
	                }
	            }
	        }
	        else {
	        	System.out.println("Please enter only 'ja'  or 'nee'.");
		    }
		}
	}
}