import java.util.Stack;

/*
* Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true*/
public class iValidParanthesis {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
                continue;
            }

            if (s.charAt(i) == ']') {
                if (stack.peek() == '[') {
                    stack.pop();
                    continue;
                }
            }
            if (s.charAt(i) == '}') {
                if (stack.peek() == '{')
                    stack.pop();
                continue;
            }
            if (s.charAt(i) == ')') {
                if (stack.peek() == '(')
                    stack.pop();
                continue;
            }
            stack.push(s.charAt(i));
        }
        return stack.isEmpty();
    }
}
