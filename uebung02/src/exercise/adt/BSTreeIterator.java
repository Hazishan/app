package src.exercise.adt;

import src.exercise.visualtree.Node;

import java.util.Iterator;
import java.util.Stack;
import java.util.function.Consumer;

public class BSTreeIterator<T>  implements Iterator<T> {
    private Stack<Node<T>> treestack = new Stack<Node<T>>();
    private int currentSize;
    private Node<T> currentNode;
    private Node<T> root;

    public BSTreeIterator(Node<T> root){
        this.root = root;
        stackFiller(root);
    }

    @Override
    public boolean hasNext() {
        return !treestack.isEmpty();
    }

    @Override
    public T next() {
        Node<T> p = treestack.pop();
        stackFiller((Node<T>) p.getRight());
        return p.getValue();
    }

    private void stackFiller(Node<T> currentNode){
        while(currentNode!= null){
            treestack.push(currentNode);
            currentNode= (Node<T>) currentNode.getLeft();
        }
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("remove");
    }

    @Override
    public void forEachRemaining(Consumer<? super T> action){throw new UnsupportedOperationException("remove");}
}
