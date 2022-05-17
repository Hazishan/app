package src.exercise.app.tests;

import src.exercise.app.algebra.Rational;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Stack;

/**
RPN = Reverse Polish Notation
 {@link <a href="https://en.wikipedia.org/wiki/Reverse_Polish_notation">RPN</a> }
test class
 {@link Rational }

 */

public class RPN {
    public static void main(String[] args) {
        String rpnString = String.join("",args);
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
        System.out.println("solution of " + rpnString +" = " + numbers.pop());
    }
}
