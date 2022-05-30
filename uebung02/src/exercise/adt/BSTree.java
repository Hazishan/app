package src.exercise.adt;

import src.exercise.visualtree.Node;

import java.util.*;

public class BSTree<T extends java.lang.Comparable<T>> extends AbstractCollection<T>{
    private T[] arrayList;
    private int currentSize;
    private Node<T> root=null;


    public BSTree(){}

    /// TODO constructor
    public BSTree(Node<T> rootNode){
        root = rootNode;
    }


    @Override
    public boolean add(T nodeValue) {

        Node<T> nodeToAdd = new Node<T>(nodeValue);

        if(root == null) {
            currentSize++;
            root = nodeToAdd;
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
            currentSize++;
            return true;

        }

    }


    @Override
    public Iterator<T> iterator() {
        return new BSTreeIterator<>(root);
    }

    /// TODO size
    @Override
    public int size() {
        return currentSize;

    }


    /// TODO isEmpty
    @Override
    public boolean isEmpty(){
        return currentSize==0;

    }
/**
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
