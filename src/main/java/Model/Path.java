package main.java.Model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Path<T> {
    // Here the node is represented by the node value
    HashMap<T, LinkedList<Node<T>>> path;

    public Path() {
        this.path = new HashMap<T, LinkedList<Node<T>>>();
    }

    // Here the node is represented by the node value
    public HashMap<T, LinkedList<Node<T>>> getPaths() {
        return this.path;
    }

    // Here the node is represented by the node value
    public void addNode(T node) {
        if(!this.path.containsKey(node)) {
            this.path.put(node, new LinkedList<Node<T>>());
        }
    }

    public void addEdge(Node<T> source, Node<T> destination, int edgeWeight) {
        if(!this.path.containsKey(destination.getVal())) {
            this.addNode(destination.getVal());
        }

        if(!this.path.containsKey(source.getVal())) {
            this.addNode(source.getVal());
        }

        destination = new Node<>(destination);
        destination.setEdgeWeight(edgeWeight);
        destination.calcEdgeLength(source);
        this.path.get(source.getVal()).add(destination);
    }

    public void removeEdge(Node<T> source, Node<T> destination) {
        if(this.path.containsKey(source.getVal())) {
            LinkedList<Node<T>> sourceEdges = this.path.get(source.getVal());

            while(sourceEdges.size() > 0){
                Node<T> sourceEdge = sourceEdges.pop();

                if(sourceEdge == destination) {
                    this.path.get(source.getVal()).remove(sourceEdge);
                    break;
                }
            }
        }
    }

    public void showPath() {
//        Here the node is represented by the node value
        System.out.println("\nPaths: ");
        for(Map.Entry<T, LinkedList<Node<T>>> node : this.path.entrySet()) {
            System.out.print("\t\t" + node.getKey() + " := [ ");
            LinkedList<Node<T>> sourceEdges = new LinkedList<>(node.getValue());

            while(sourceEdges.size() > 0) {
                Node<T> sourceEdge = sourceEdges.pop();
                System.out.print(sourceEdge.getVal() + " | ");
            }
            System.out.println("null ]");
        }
    }
}
