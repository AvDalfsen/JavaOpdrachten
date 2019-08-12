package src;

import java.util.ArrayList;

class Node {
    String id;
    String questionOrAnswer;
    ArrayList<Edge> edges;

    Node(String id, String questionOrAnswer) {
        this.id = id;
        this.questionOrAnswer = questionOrAnswer;
        edges = new ArrayList<>();
    }

    void addEdge(Edge edge) {
        edges.add(edge);
    }
    
    String getId() {
        return id;
    }
}

