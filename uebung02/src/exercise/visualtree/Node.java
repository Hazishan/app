package src.exercise.visualtree;

import src.exercise.visualtree.DrawableTreeElement;

import java.util.Random;

public class Node<T> implements DrawableTreeElement<T> {

    private Node<T> left,right,root;
    private T value;
    private boolean passed = false;
    private boolean red;

    public Node(T val){
        value=val;
        left = null;
        right = null;
        Random random = new Random();
        red = random.nextBoolean();
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
        return red;
    }

    public boolean hasChild(){
        return left == null && right == null;
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

    public boolean hasRight(){
        return right!=null;
    }

    @Override
    public String toString() {
        return "node " + this.getValue();
    }

    public boolean hasLeft(){
        return left!=null;
    }
}
