package stack;

import java.util.Stack;

public class ArithmeticExpressionValidator {

    // Method to validate the arithmetic expression
    public static boolean isValidExpression(String expression) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char currentChar = expression.charAt(i);

            // Invalid characters in the expression
            if (!(Character.isDigit(currentChar) ||
                    currentChar == '+' ||
                    currentChar == '-' ||
                    currentChar == '*' ||
                    currentChar == '/' ||
                    currentChar == '(' ||
                    currentChar == ')')) {
                return false;
            }

            // Handle opening parenthesis
            if (currentChar == '(') {
                stack.push(currentChar);
            }
            // Handle closing parenthesis
            else if (currentChar == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return false;  // Unmatched parenthesis
                }
                stack.pop();  // Pop the matching '('
            }
            // Handle operators
            else if (currentChar == '+' || currentChar == '-' || currentChar == '*' || currentChar == '/') {
                // Check if the previous character was an operator or the start of the string
                if (i == 0 || expression.charAt(i - 1) == '(' ||
                        expression.charAt(i - 1) == '+' ||
                        expression.charAt(i - 1) == '-' ||
                        expression.charAt(i - 1) == '*' ||
                        expression.charAt(i - 1) == '/') {
                    return false;  // Consecutive operators or operator at the start
                }
            }
            // Handle digits (valid)
            else if (Character.isDigit(currentChar)) {
                // No extra checks needed for digits
            }
            System.out.println("===>"+ stack);
        }

        // Ensure no unmatched parentheses and the expression does not end with an operator
        return stack.isEmpty() && !(expression.charAt(expression.length() - 1) == '+' ||
                expression.charAt(expression.length() - 1) == '-' ||
                expression.charAt(expression.length() - 1) == '*' ||
                expression.charAt(expression.length() - 1) == '/');
    }

    public static void main(String[] args) {
        // Hardcoded test cases for validation
        String[] expressions = {
                "2+3*(5-2)",    // Valid expression
                "2++3",         // Invalid expression (consecutive operators)
                "2+(3*5",       // Invalid expression (unbalanced parentheses)
                "(2+3)*(5-2)",  // Valid expression
                "2*3/(5-2)",    // Valid expression
                "2+3/*5-2",     // Invalid expression (invalid operator usage)
                "5+((2+3)*4)",  // Valid expression
                "3+5/2",        // Valid expression
                "((5+3)*2)/4"   // Valid expression
        };

        // Validate each expression
        for (String expression : expressions) {
            System.out.println("Expression: \"" + expression + "\" is " +
                    (isValidExpression(expression) ? "valid" : "invalid"));
        }
    }
}
