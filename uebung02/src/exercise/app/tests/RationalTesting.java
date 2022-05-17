package src.exercise.app.tests;

import src.exercise.app.algebra.Fractional;
import src.exercise.app.algebra.Rational;

public class RationalTesting {
    public static void main(String[] args) {
        Rational one = new Rational(5,1);
        Rational two = new Rational(2,1);


        System.out.print(one.toString()+" + " +two.toString()+ " = ");
        one.add(two);
        System.out.println(one.toString());

        System.out.print(one.toString()+" - " +two.toString()+ " = ");
        one.sub(two);
        System.out.println(one.toString());

        System.out.print(one.toString()+" * " +two.toString()+ " = ");
        one.mul(two);
        System.out.println(one.toString());

        System.out.print(one.toString()+" / " +two.toString()+ " = ");
        one.div(two);
        System.out.println(one.toString());
        System.out.println("getN, getD of one = " +one.getN()+"/"+one.getD());


        Fractional three = one.negation();
        System.out.println("three (equal to one) negated: " + three.toString());
        Fractional four = one.reciprocal();
        System.out.println("four (equal to one) reciproced: " + four.toString());

        Rational five = one.clone();
        System.out.println("one == one.clone()? "+ five.equals(one));
        System.out.println("hash(one): "+ one.hashCode());
        System.out.println("hash(one.clone(): "+ five.hashCode());


    }
}
