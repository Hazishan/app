package app.exercise.tests;

import app.exercise.algebra.Rational;

import java.util.EmptyStackException;
import java.util.Stack;

/**
RPN = Reverse Polish Notation
@link {https://en.wikipedia.org/wiki/Reverse_Polish_notation}
test class for @see uebung02.src.algebra_unbuilt.BasisFraction
uses
 */

public class RPN {
    public static void main(String[] args) {
        String rpnString = "12*4/5+45+-";
        Stack<Rational> numbers = new Stack();


        for (int i = 0; i <= rpnString.length() - 1; i++) {
            if (rpnString.charAt(i) != '+' && rpnString.charAt(i) != '-' && rpnString.charAt(i) != '*' && rpnString.charAt(i) != '/') {
                long currentVal = Character.getNumericValue(rpnString.charAt(i));
                numbers.push(new Rational(currentVal, 1));
            } else{
                try {
                    Rational operantOne = numbers.pop();
                    Rational operantTwo = numbers.pop();
                    char operator = rpnString.charAt(i);
                    switch (operator) {
                        case '+' -> operantTwo.add(operantOne);
                        case '-' -> operantTwo.sub(operantOne);
                        case '*' -> operantTwo.mul(operantOne);
                        case '/' -> operantTwo.div(operantOne);
                    }
                    numbers.push(operantTwo);
                } catch (EmptyStackException e) {
                    System.out.println("ERROR: Invalid amount of operators/operands");
                    System.out.println(e.getClass());
                    break;
                }
            }
        }
        System.out.println("solution: " + numbers.pop());
    }
}

