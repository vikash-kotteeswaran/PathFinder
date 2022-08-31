package main.java.Algorithms;

import main.java.Model.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class AStar<T> {

    public Node<T> AStarSolve(Path<T> Paths, Node<T> start, Node<T> end) {
        PriorityQueue<Node<T>> currentNodes = new PriorityQueue<>(100, (a, b) -> a.getF() - b.getF());
        HashMap<T, LinkedList<Node<T>>> paths = Paths.getPaths();
        currentNodes.add(new Node<>(start));

        Node<T> currentNode = new Node<T>();
        while(currentNodes.size() > 0) {
            currentNode = currentNodes.poll();
            currentNode.calcH(end);

            if(currentNode.getVal() == end.getVal()) {
                break;
            }

            LinkedList<Node<T>> currentNeighbours = new LinkedList<>(paths.get(currentNode.getVal()));
            int cNsize = currentNeighbours.size();
            while(cNsize > 0) {
                Node<T> currentNeighbour = new Node<>(currentNeighbours.pop());
                currentNeighbour.calcH(end);
                currentNeighbour.setG(currentNode.getG() + currentNeighbour.getEdgeLength());
                currentNeighbour.setParentNode(currentNode);
                currentNodes.add(currentNeighbour);
                cNsize--;
            }
        }

        return currentNode;
    }
}
