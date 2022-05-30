package src.exercise.adt;

import src.exercise.visualtree.Node;

import java.util.*;

public class BSTree<T extends java.lang.Comparable<T>> extends AbstractCollection<T>{
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


    @Override
    public int size() {
        return currentSize;

    }



    @Override
    public boolean isEmpty(){
        return currentSize==0;

    }

    /// TODO check T
    @Override
    public boolean contains(Object o){
        if(!(o instanceof T)){
            return false;
        }
        for (T t : this) {
            if (t.equals(o)) {
                return true;
            }
        }
        return false;
    }

    /// TODO containsAll
    @Override
    public boolean containsAll(Collection<?> c){
        for(Object t:c){
            if(!contains(t)){
                return false;
            }
        }
        return true;
    }


    /// TODO toArray
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

    /// TODO remove
    public boolean remove(Object o){
    }


    @Override
    public String toString() {
        String output = "";

        for (T t : this) {
            output += t;

        }
        return output;
    }
}
