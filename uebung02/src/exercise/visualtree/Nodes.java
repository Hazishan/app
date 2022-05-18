package src.exercise.visualtree;

import src.exercise.visualtree.DrawableTreeElement;

public class Nodes<T> implements DrawableTreeElement<T> {


    @Override
    public DrawableTreeElement<T> getLeft() {
        return null;
    }

    @Override
    public DrawableTreeElement<T> getRight() {
        return null;
    }

    @Override
    public boolean isRed() {
        return false;
    }

    @Override
    public T getValue() {
        return null;
    }
}
