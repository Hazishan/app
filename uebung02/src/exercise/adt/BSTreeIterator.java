package src.exercise.adt;

import java.util.Iterator;
import java.util.function.Consumer;

public class BSTreeIterator<T>  implements Iterator<T> {
    private T[] arrayList;
    private int currentSize;
    private int currentIndex=0;

    public BSTreeIterator(T[] arr){
        arrayList = arr;
        currentSize = arr.length;
    }

    @Override
    public boolean hasNext() {
        return currentIndex<currentSize&&arrayList[currentIndex++]!=null;
    }

    @Override
    public T next() {
        return arrayList[currentIndex++];
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("remove");
    }

    @Override
    public void forEachRemaining(Consumer<? super T> action){throw new UnsupportedOperationException("remove");}
}
