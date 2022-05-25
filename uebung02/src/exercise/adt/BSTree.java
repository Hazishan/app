package src.exercise.adt;

import src.exercise.app.algebra.CompRational;
import src.exercise.visualtree.Node;

import java.util.*;
import java.util.Collection;

public class BSTree<T extends Comparable<T>> extends AbstractCollection<T>{
    private T[] arrayList;
    private int currentSize;
    private Node<T> root;

    /// TODO constructor
    public BSTree(){
    }


    @Override
    public boolean add(T t) {


        /***
         * no root set
         */
        Node<T> toAddingNode = new Node<T>(t);
        if(root == null) {
            root = toAddingNode;
            return true;
        }

        else{
            Node<T> currentNode = root;
            while(true){
                if(currentNode.getRight()==null && currentNode.getValue().compareTo(t)>0){
                    currentSize++;
                    toAddingNode.setRoot(currentNode);
                    currentNode.setRight(toAddingNode);
                    return true;
                }
                if(currentNode.getLeft()==null && currentNode.getValue().compareTo(t)<0){
                    currentSize++;
                    toAddingNode.setRoot(currentNode);
                    currentNode.setLeft(toAddingNode);
                    return true;
                }
                if(currentNode.getRight().getValue().compareTo(toAddingNode.getValue())>0){
                    currentNode = (Node<T>) currentNode.getRight();
                }
                if(currentNode.getLeft().getValue().compareTo(toAddingNode.getValue())<0){
                    currentNode = (Node<T>) currentNode.getLeft();
                }
            }

        }

    }


    @Override
    public Iterator<T> iterator() {
        return new BSTreeIterator<T>(arrayList);
    }

    /// TODO size
    @Override
    public int size() {
        return currentSize;

    }
/**

    /// TODO isEmpty
    @Override
    public boolean isEmpty(){
        return root==null;

    }


    /// TODO contains
    @Override
    public boolean contains(Object o){

    }

    /// TODO containsAll
    @Override
    public boolean containsAll(Collection<?> c){

    }


    /// TODO toArray
    @Override
    public Object[] toArray(){
        return arrayList;
    }

    /// TODO toString
    @Override
    public String toString(){

    }
    **/

}
