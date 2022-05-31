package src.exercise.app.tests;

import src.exercise.adt.BSTree;
import src.exercise.app.algebra.CompRational;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class BSTreeTester {
    public static void main(String args[]) {
        if(args.length%2!=0){
            throw new IllegalArgumentException("Illegal Argument: no odd numbers allowed");
        }



        BSTree<CompRational> bsMain = new BSTree<>();
        BSTree<CompRational> bsEven = new BSTree<>();
        BSTree<CompRational> bsOdd = new BSTree<>();

        boolean alternator = true;

        for(int i=0; i<=args.length-1; i+=2){
            bsMain.add(new CompRational(Long.parseLong(args[i]),Long.parseLong(args[i+1])));
            if(alternator) {
                System.out.println();
                bsEven.add(new CompRational(Long.parseLong(args[i]),Long.parseLong(args[i+1])));
            }
            else {
                bsOdd.add(new CompRational(Long.parseLong(args[i]),Long.parseLong(args[i+1])));
            }
            alternator= !alternator;
        }
        System.out.println("Odd Tree: " + bsOdd.toString());
        System.out.println("Even Tree: " + bsEven.toString());


        /**
         * remove method still missing
         */

        System.out.println("Is odd tree in main tree: " + bsMain.containsAll(bsOdd));
        System.out.println("Is even tree in main tree: " + bsMain.containsAll(bsEven));

        CompRational min = bsMain.getSmallest().getValue();
        CompRational max = bsMain.getLargest().getValue();

        long a,b,c,d;

        a= min.getN();
        b=min.getD();
        c=max.getN();
        d=max.getD();


        for(int i = 0;i<100;i++){
            double n = Math.floor(Math.random()*1000);
            double part0 = ((c*b-a*d)/(double)(d*b*1000));
            part0*=n;
            CompRational part1 = convertDecimalToFraction(part0);
            part1.add(min);
            System.out.println(part1);

            if(bsMain.contains(part1)){
                System.out.println("Tree contains last element");
                break;
            }
        }



    }
    static private CompRational convertDecimalToFraction(double x){
        double tolerance = 1.0E-3;
        double h1=1; double h2=0;
        double k1=0; double k2=1;
        double b = x;
        do {
            double a = Math.floor(b);
            double aux = h1; h1 = a*h1+h2; h2 = aux;
            aux = k1; k1 = a*k1+k2; k2 = aux;
            b = 1/(b-a);
        } while (Math.abs(x-h1/k1) > x*tolerance);

        return new CompRational((long)h1,(long)k1);
    }
}
