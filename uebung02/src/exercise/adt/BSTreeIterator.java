package src.exercise.adt;

import java.util.Iterator;
import java.util.Stack;
import java.util.function.Consumer;

/***
 *
 * @param <T>
 *     Iterator iterates through Binary Search Tree
 */
public class BSTreeIterator<T>  implements Iterator<T> {
    /***
     * Stack for Nodes --> Order high values at bottom, low values at top for inorder access
     */
    private Stack<Node<T>> treestack = new Stack<Node<T>>();
    /***
     * size of stack for hasNext
     */


    /***
     *
     * @param root
     */
    public BSTreeIterator(Node<T> root){
        stackFiller(root);
    }

    /***
     *
     * @return boolean if stack is empty
     */
    @Override
    public boolean hasNext() {
        return !treestack.isEmpty();
    }

    /***
     *
     * @return pops stack
     */
    @Override
    public T next() {
        Node<T> p = treestack.pop();
        stackFiller((Node<T>) p.getRight());
        return p.getValue();
    }

    /***
     *
     * @return fills stack with right children
     */
    public Node<T> nextNode() {
        Node<T> p = treestack.pop();
        stackFiller((Node<T>) p.getRight());
        return p;
    }

    /***
     *
     * @param currentNode
     * Fills stack with left children
     */
    private void stackFiller(Node<T> currentNode){
        while(currentNode!= null){
            treestack.push(currentNode);
            currentNode= (Node<T>) currentNode.getLeft();
        }
    }

    /***
     * not supported
     */
    @Override
    public void remove() {
        throw new UnsupportedOperationException("remove");
    }
    /***
     * not supported
     */
    @Override
    public void forEachRemaining(Consumer<? super T> action){throw new UnsupportedOperationException("remove");}
}
