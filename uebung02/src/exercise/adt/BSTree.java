package src.exercise.adt;

import src.exercise.visualtree.RedBlackTreeDrawer;

import java.util.*;

/***
 *
 * @param <T>
 *     Builds trees with T generics, which have to inherit from Comparable
 *     Class inherits from AbstractCollection
 * @see AbstractCollection
 */
public class BSTree<T extends java.lang.Comparable<T>> extends AbstractCollection<T>{
    /***
     * currentsize shows size of tree
     */
    private int currentSize;
    /***
     * Root starting point of tree
     */

    private Node<T> root=null;
    /***
     * currentFocus to navigate through Tree
     */


    private Node<T> currentFocus;
    /***
     * visual to visualize tree
     */
    
    RedBlackTreeDrawer<T> visual = new RedBlackTreeDrawer<T>();

    /***
     * Default Constructor
     */
    public BSTree(){}

    /***
     *
     * @param rootNode
     */
    public BSTree(Node<T> rootNode){
        root = rootNode;
    }

    /***
     *
     * @param nodeValue
     * @return
     */
    @Override
    public boolean add(T nodeValue) {

        Node<T> nodeToAdd = new Node<T>(nodeValue);

        if(root == null) {
            currentSize++;
            root = nodeToAdd;
            visual.draw(root);
            return true;
        }

        else{
            Node<T> currentNode = root;

            /**
             * search for bottom leaf
             */
            while(!currentNode.hasChild()){

                if(currentNode.hasLeft() && currentNode.getValue().compareTo(nodeValue)>0){
                    currentNode = (Node<T>) currentNode.getLeft();
                }
                else if (currentNode.hasRight() && currentNode.getValue().compareTo(nodeValue)<0){
                    currentNode = (Node<T>) currentNode.getRight();
                }
                else{
                    break;
                }
            }

            if(currentNode.getValue().compareTo(nodeValue)>0){
                currentNode.setLeft(nodeToAdd);

            }
            else{
                currentNode.setRight(nodeToAdd);
            }
            nodeToAdd.setRoot(currentNode);
            visual.draw(root);
            currentSize++;
            return true;

        }

    }

    /***
     *
     * @return
     */
    @Override
    public Iterator<T> iterator() {
        return new BSTreeIterator<>(root);
    }

    /***
     *
     * @return size
     */
    @Override
    public int size() {
        return currentSize;

    }


    /***
     *
     * @return boolean
     */
    @Override
    public boolean isEmpty(){
        return currentSize==0;

    }

    /***
     *
     * @param o
     * @return boolean
     */
    @Override
    public boolean contains(Object o){
        currentFocus=root;
        while(currentFocus!=null){
            if(currentFocus.getValue().compareTo((T) o)==0){
                return true;
            }
            else if(currentFocus.getValue().compareTo((T) o)>0){
                currentFocus= (Node<T>) currentFocus.getLeft();
            }
            else{
                currentFocus=(Node<T>) currentFocus.getRight();
            }
        }
        return false;
    }

    /***
     *
     * @param c
     * @return boolean
     */
    @Override
    public boolean containsAll(Collection<?> c){
        for(Object t:c){
            if(!contains(t)){
                return false;
            }
        }
        return true;
    }


    /***
     *
     * @return array of tree
     */
    @Override
    public Object[] toArray(){
        Iterator<T> iter= this.iterator();
        Object[] arrayList = new Object[size()-1];
        int i = 0;
        while(iter.hasNext()){
            arrayList[i] =  iter.next();
            i++;
        }
        return arrayList;
    }

    /***
     *
     * @return Smallest node
     */
    public Node<T> getSmallest(){
        Node<T> currentFocus = root;
        while(currentFocus.hasLeft()){
             currentFocus= (Node<T>) currentFocus.getLeft();
        }
        return currentFocus;
    }

    /***
     *
     * @return Largest node
     */
    public Node<T> getLargest(){
        Node<T> currentFocus = root;
        while(currentFocus.hasRight()){
            currentFocus= (Node<T>) currentFocus.getRight();
        }
        return currentFocus;
    }

/**
    /// TODO remove
    public boolean remove(Object o){
    }

**/
    /***
     *
     * @return String of Tree
     */
    @Override
    public String toString() {
        String output = "";

        for (T t : this) {
            output += t + " ";

        }
        return output;
    }
}