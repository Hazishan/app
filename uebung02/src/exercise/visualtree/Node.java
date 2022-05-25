package src.exercise.visualtree;

import src.exercise.visualtree.DrawableTreeElement;

public class Node<T> implements DrawableTreeElement<T> {

    private Node<T> left,right,root;
    private T value;

    public Node(T val){
        value=val;
        left = null;
        right = null;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    @Override
    public DrawableTreeElement<T> getLeft() {
        return left;
    }

    @Override
    public DrawableTreeElement<T> getRight() {
        return right;
    }

    @Override
    public boolean isRed() {
        return false;
    }

    @Override
    public T getValue() {
        return value;
    }

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }
}
