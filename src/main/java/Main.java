package main.java;

import main.java.Model.*;

public class Main {

    public static void main(String[] args) {

        Path<String> path = new Path<>();

        Node<String> A = new Node<>("A", 0, 0);
        Node<String> B = new Node<>("B", 0, 2);
        Node<String> C = new Node<>("C", 3, 1);
        Node<String> D = new Node<>("D", 4, 3);
        Node<String> E = new Node<>("E", 7, 9);
        Node<String> F = new Node<>("F", 9, 13);
        Node<String> G = new Node<>("G", 8, 17);
        Node<String> H = new Node<>("H", 13, 15);
        Node<String> I = new Node<>("I", 15, 17);

        path.addEdge(A, B, 100);
        path.addEdge(A, C, 10);
        path.addEdge(C, D, 8);
        path.addEdge(D, I, 5);
        path.addEdge(B, E, 700);
        path.addEdge(E, I, 9);
        path.addEdge(E, F, 100);
        path.addEdge(E, G, 100);
        path.addEdge(I, F, 50);
        path.addEdge(G, H, 4);
        path.addEdge(H, G, 400);
        path.addEdge(F, H, 20);
        path.addEdge(D, F, 3500);

        path.showPath();

        Solver<String> solver = new Solver<>();
        solver.Solve(path, A, H, "AStar");

        path.showPath();
        solver.Solve(path, A, G, "AStar");
    }
}
