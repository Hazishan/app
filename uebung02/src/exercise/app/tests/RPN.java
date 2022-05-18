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
    public static void main(String[] args) throws Exception {
        Stack<Rational> numbers = new Stack();

        /// Check if RPN task makes sense, if ratio of integers to operands is invalid, throws Exception
        int intcounter=0;
        int operatorcounter=0;
        for(int i =0;i<args.length;i++){
            if(args[i].matches("^[0-9]*[1-9][0-9]*$")){intcounter++;}
            if(args[i].matches("^[\\*,\\+,\\-,\\/]{1}$")){operatorcounter++;}
        }
        if(!(intcounter-1==operatorcounter)){
            throw new Exception("ERROR: Invalid amount of operators/operands");
        }

        ///adds integers to stack, if operant is given: popsx2 calculates and push solution

        for (int i = 0; i <= args.length - 1; i++) {
            String currentString = args[i];
            if (currentString.matches("^[0-9]*[1-9][0-9]*$")) {
                long currentVal = Integer.parseInt(currentString);
                numbers.push(new Rational(currentVal, 1));
            }
            else if(currentString.matches("^[\\*,\\+,\\-,\\/]{1}$")){
                Rational operantOne = numbers.pop();
                Rational operantTwo = numbers.pop();
                switch (currentString) {
                    case "+" -> operantTwo.add(operantOne);
                    case "-" -> operantTwo.sub(operantOne);
                    case "*" -> operantTwo.mul(operantOne);
                    case "/" -> operantTwo.div(operantOne);
                }
                numbers.push(operantTwo);
            }
            else{
                System.out.println("Invalid input: " + currentString + " Skipping to next...");
            }
        }
        System.out.println("solution of " + String.join(" ", args) +" = " + numbers.pop());
    }
}

