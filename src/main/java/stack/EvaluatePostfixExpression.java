package stack;

import java.util.Stack;

/**
 * Problem Statement
 * Write a program to evaluate a postfix expression (also known as Reverse Polish Notation or RPN).
 *
 * In postfix notation, operators follow their operands. For example,
 *  the infix expression "3 + 4" is written as "3 4 +" in postfix notation.
 *
 * Input:
 * A string array of tokens representing a valid postfix expression
 * Each token is either an operator (+, -, *, /) or an integer operand
 * Output:
 * The integer result of evaluating the expression
 * Rules
 * Operators work on exactly two operands
 * All operations are integer operations (division truncates toward zero)
 * The expression is guaranteed to be valid (no division by zero)
 * Operands can be multi-digit integers (positive or negative)
 *
 * Examples
 * Example 1:
 *
 * Input: ["2", "1", "+", "3", "*"]
 * Expression: ((2 + 1) * 3)
 * Output: 9
 *
 * Example 2:
 *
 * Input: ["4", "13", "5", "/", "+"]
 * Expression: (4 + (13 / 5))
 * Output: 6
 * Example 3:
 *
 * Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * Expression: (10 * (6 / ((9 + 3) * -11))) + 17 + 5
 * Output: 22
 * Constraints
 * 1 ≤ tokens.length ≤ 10^4
 * tokens[i] is either an operator: "+", "-", "*", "/", or an integer in the range [-200, 200]
 */

public class EvaluatePostfixExpression {
    
    public static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            
            // If the character is a digit, push it to the stack
            if (Character.isDigit(c)) {
                stack.push(c - '0');  // Convert char to int
            }
            // If the character is an operator, pop two elements from stack, apply the operator, and push the result back
            else if (c == '+' || c == '-' || c == '*' || c == '/') {
                int val1 = stack.pop();
                int val2 = stack.pop();

                stack.push(switch(c) {
                    case '+' -> val2 + val1;
                    case '-' -> val2 - val1;
                    case '*' -> val2 * val1;
                    case '/' -> val2 / val1;
                    default -> throw new IllegalArgumentException("Unknown operator: " + c);
                });
            }
        }
        
        return stack.pop();
    }

    public static void main(String[] args) {
        String postfixExpression = "23+5*";  // Equivalent to (2+3)*5 = 25
        System.out.println("Postfix expression: " + postfixExpression);
        System.out.println("Result: " + evaluatePostfix(postfixExpression));

        String postfixExpression2 = "234*+";  // Equivalent to 2+(3*4) = 14
        System.out.println("Postfix expression: " + postfixExpression2);
        System.out.println("Result: " + evaluatePostfix(postfixExpression2));
    }
}
    