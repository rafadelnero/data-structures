package stack;

import java.util.Stack;

/**
 * Problem:
 * A string containing only the characters (, ), {, }, [, and ] is valid if:
 *
 * Open brackets are closed by the same type of brackets.
 * Open brackets are closed in the correct order.
 *
 * Sample Input and Output:
 * Input	Output
 * ()	true
 * ()[]{} 	true
 * (]	false
 * ([)]	false
 * {[]}	true
 */
public class ValidParentheses {

    public static boolean isValid(String s) {
        // Use a stack to keep track of opening brackets
        Stack<Character> stack = new Stack<>();

        // Traverse through each character in the string
        for (char ch : s.toCharArray()) {
            // Push opening brackets onto the stack
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            // Handle closing brackets
            else {
                // If the stack is empty or does not match the current closing bracket, it's invalid
                if (stack.isEmpty() || !isMatchingPair(stack.pop(), ch)) {
                    return false;
                }
            }
        }

        // If the stack is empty, all brackets were matched; otherwise, it's invalid
        return stack.isEmpty();
    }

    // Helper function to check if two brackets are a matching pair
    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '{' && close == '}') ||
               (open == '[' && close == ']');
    }

    public static void main(String[] args) {
        // Test cases
        String s1 = "()";
        String s2 = "()[]{}";
        String s3 = "(]";
        String s4 = "([)]";
        String s5 = "{[]}";

        System.out.println(isValid(s1)); // true
        System.out.println(isValid(s2)); // true
        System.out.println(isValid(s3)); // false
        System.out.println(isValid(s4)); // false
        System.out.println(isValid(s5)); // true
    }
}