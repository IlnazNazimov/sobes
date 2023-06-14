import java.util.Stack;
/*Учитывая строку s, содержащую только символы '(', ')', '{', и '}', определите, допустима ли входная строка.'['']'*/
class SolutionLk18 {
    public boolean isValid(String s) {
        if (s == null || s.isEmpty() || s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();

        for(char ch : chars) {
            if (ch == '(') {
                stack.push(')');
            } else if (ch == '[') {
                stack.push(']');
            } else if (ch == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.pop() != ch) {
                return false;
            }
        }

        return stack.isEmpty();
    }
}