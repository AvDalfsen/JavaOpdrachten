package src;

import java.util.ArrayList;

class Node {
    private String id;
    String destination;
    ArrayList<Edge> edges;

    Node(String id, String destination) {
        this.id = id;
        this.destination = destination;
        edges = new ArrayList<>();
    }

    void addEdge(Edge edge) {
        edges.add(edge);
    }
    
    String getId() {
        return id;
    }
}

