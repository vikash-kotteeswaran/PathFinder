package main.java.Model;

public class Node<T> {
    private T value;
    private int X;
    private int Y;
    private Node<T> parentNode;
    private int edgeLength;
    private int edgeWeight;
    private int H;
    private int G;
    private int F;

    public Node() {
        this.value = null;
    }

    public Node(Node<T> node) {
        this.value = node.getVal();
        this.parentNode = node.getParentNode();
        this.H = node.getH();
        this.X = node.getX();
        this.Y = node.getY();
        this.G = node.getG();
        this.F = node.getF();
        this.edgeLength = node.getEdgeLength();
        this.edgeWeight = node.getEdgeWeight();
    }

    public Node(T value, int X, int Y) {
        this.value = value;
        this.H = 0;
        this.X = X;
        this.Y = Y;
        this.G = 0;
        updateF();
    }

    public void setH(int newH) {
        this.H = newH;
        updateF();
    }

    public void calcH(Node end) {
        this.H = Math.abs(end.getX() - this.X) + Math.abs(end.getY() - this.Y);
        updateF();
    }

    public int getH() {
        return this.H;
    }

    public void setX(int newX) {
        this.X = newX;
    }

    public int getX() {
        return this.X;
    }

    public void setY(int newY) {
        this.Y = newY;
    }

    public int getY() {
        return this.Y;
    }

    public void setG(int newG) {
        this.G = newG;
        updateF();
    }

    public int getG() {
        return this.G;
    }

    public void updateF() {
        this.F = this.G + this.H + this.edgeWeight;
    }

    public int getF() {
        return this.F;
    }

    public void setVal(T newVal) {
        this.value = newVal;
    }

    public T getVal() {
        return this.value;
    }

    public void calcEdgeLength(Node<T> node) {
        this.edgeLength = Math.abs(node.getX() - this.X) + Math.abs(node.getY() - this.Y);
        updateF();
    }

    public int getEdgeLength() {
        return this.edgeLength;
    }

    public void setEdgeLength(int newEdgeLength) {
        this.edgeLength = newEdgeLength;
    }

    public int getEdgeWeight() {
        return this.edgeWeight;
    }

    public void setEdgeWeight(int newEdgeWeight) {
        this.edgeWeight = newEdgeWeight;
    }

    public Node<T> getParentNode() {
        return this.parentNode;
    }

    public void setParentNode(Node<T> newParentNode) {
        this.parentNode = newParentNode;
    }
}
