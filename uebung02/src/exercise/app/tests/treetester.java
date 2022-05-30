package src.exercise.app.tests;

import src.exercise.adt.BSTree;
import src.exercise.app.algebra.CompRational;
import src.exercise.visualtree.Node;

import java.util.Iterator;

public class treetester {
    public static void main(String[] args) {
        BSTree<CompRational> myTree = new BSTree<CompRational>();
        CompRational one = new CompRational(17,1);
        CompRational two = new CompRational(13,1);
        CompRational three = new CompRational(21,1);
        CompRational five = new CompRational(8,1);
        CompRational six = new CompRational(15,1);
        myTree.add(one);
        myTree.add(two);
        myTree.add(three);
        myTree.add(five);
        myTree.add(six);

        Iterator<CompRational> i= myTree.iterator();

        while(i.hasNext()){
            System.out.println(i.next());
        }
    }

}
