package src.exercise.app.tests;

import src.exercise.adt.BSTree;
import src.exercise.app.algebra.CompRational;

import java.util.Arrays;

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


        CompRational oneCopy = new CompRational(17,2);

        CompRational[] comparray = {one, two,three};
        for (CompRational compRational : myTree) {
            System.out.println(compRational);
        }
        System.out.println(myTree.contains(new CompRational(13,1)));
        System.out.println(myTree.containsAll(Arrays.asList(comparray)));
    }

}
