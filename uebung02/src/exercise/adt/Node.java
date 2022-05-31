package src.exercise.adt;

import src.exercise.visualtree.DrawableTreeElement;

import java.util.Random;

/***
 *
 * @param <T>
 *     Node class
 */
public class Node<T> implements DrawableTreeElement<T> {
    /***
     * Childs and root are Node objects which later get assigned in setx
     */
    private Node<T> left,right,root;
    /***
     * value of Node
     */
    private T value;
    /***
     * random assignement if red or not red in constructor
     */
    private boolean red;

    /***
     *
     * @param val
     * defines childs as null, random coloration
     */
    public Node(T val){
        value=val;
        left = null;
        right = null;
        Random random = new Random();
        red = random.nextBoolean();
    }


    /**
     *
     * @param right
     */
    public void setRight(Node<T> right) {
        this.right = right;
    }

    /***
     *
     * @param left
     */
    public void setLeft(Node<T> left) {
        this.left = left;
    }

    /***
     *
     * @return
     */
    @Override
    public DrawableTreeElement<T> getLeft() {
        return left;
    }

    /***
     *
     * @return
     */
    @Override
    public DrawableTreeElement<T> getRight() {
        return right;
    }

    /***
     *
     * @return
     */
    @Override
    public boolean isRed() {
        return red;
    }

    /***
     *
     * @return
     */
    public boolean hasChild(){
        return left == null && right == null;
    }

    /***
     *
     * @return value of Node
     */
    @Override
    public T getValue() {
        return value;
    }

    /***
     *
     * @return Root of Node
     */
    public Node<T> getRoot() {
        return root;
    }

    /***
     *
     * @param root
     * sets root of Node
     */
    public void setRoot(Node<T> root) {
        this.root = root;
    }

    /***
     *
     * @return boolean if Node has right child
     */
    public boolean hasRight(){
        return right!=null;
    }

    /***
     *
     * @return Node to String
     */
    @Override
    public String toString() {
        return "node " + this.getValue();
    }

    /***
     *
     * @return boolean if node has left child
     */
    public boolean hasLeft(){
        return left!=null;
    }
}
