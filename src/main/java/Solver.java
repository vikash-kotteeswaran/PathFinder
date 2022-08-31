package main.java;

import main.java.Model.*;
import main.java.Algorithms.*;

public class Solver<T> {

    Node<T> shortestPath;

    public Solver() {
        this.shortestPath = new Node<>();
    }

    public Node<T> Solve(Path<T> Paths, Node<T> start, Node<T> end, String Method) {

        switch (Method) {
            case "AStar":
                AStar<T> aStar = new AStar<>();
                this.shortestPath = aStar.AStarSolve(Paths, start, end);
                showShortestPath();
        }

        return this.shortestPath;
    }

    public void showShortestPath() {
        Node<T> pathEndNode = new Node<T>(this.shortestPath);
        Node<T> current = pathEndNode;

        System.out.println("\nShortest Path: ");
        System.out.print("\t\t");
        while(current != null) {
            System.out.print("{[ " + current.getVal() + " ]}----G" + current.getG() + "-H" + current.getH() + "-F" + current.getF() + "-X" + current.getX() + "-Y" + current.getY() + "" + "---->-");
            current = current.getParentNode();
        }
        System.out.println("null");
    }
}
