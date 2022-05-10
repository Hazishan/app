package uebung02.algebra.testing;
import uebung02.algebra.Rational;

import java.util.EmptyStackException;
import java.util.Stack;
public class RPN {
    public static void main(String[] args) {
        String rpnString = "48/";
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
                        case '+':
                            operantTwo.add(operantOne);
                            break;
                        case '-':
                            operantTwo.sub(operantOne);
                            break;
                        case '*':
                            operantTwo.mul(operantOne);
                            break;
                        case '/':
                            operantTwo.div(operantOne);
                            break;
                    }
                    System.out.println("solution: " + operantTwo);
                    numbers.push(operantTwo);
                } catch (EmptyStackException e) {
                    System.out.println("ERROR: Invalid amount of operators/operands");
                    System.out.println(e.getClass());
                    break;
                }
            }
        }
    }
}

