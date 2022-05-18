package src.exercise.adt;

import java.util.*;
import java.util.Collection;

public class BSTree<T extends Comparable<T>> extends AbstractCollection<T>{
    private T[] arrayList;
    private int currentSize;

    public BSTree(T[] array){
        arrayList = array;
        currentSize = array.length;
    }


    @Override
    public Iterator<T> iterator() {
        return new BSTreeIterator<T>(arrayList);
    }

    @Override
    public int size() {
        return currentSize;
    }

    @Override
    public boolean isEmpty(){
        if(size()==0){return true;}
        /***
         * dangerouse but only used internally to compare array with empty array
         */
        T[] emptyArray = (T[])new Object[size()];
        return Arrays.equals(arrayList, emptyArray);
    }

    @Override
    public boolean contains(Object o){
        for (T t : this) {
            if (o.equals(t)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c){

        for(){
            if(!contains(t)){return false;}
        }
        return false;

    }

    @Override
    public Object[] toArray(){
        return arrayList;
    }

    @Override
    public String toString(){
        return Arrays.toString(arrayList);
    }

}
