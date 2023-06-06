import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

/*Назовем строку хорошей, если в ней нет двух соседних букв, которые различаются только регистром.
Например, строка «abba» хорошая, а строка «aBba» нет.Со строкой можно делать преобразование:
если два соседних символа обозначают одну и ту же букву, но записаны в разных регистрах, то их можно удалить.
При этом строка «схлопнется», то есть пробелов при удалении не образуется.*/
public class Solution6 {

    private static String convertToGoodString(String probablyBadString) {
        Stack<Character> stack = new Stack<>();
        StringBuilder str = new StringBuilder();

        for (char ch : probablyBadString.toCharArray()) {
            if (!stack.isEmpty() && Math.abs(stack.peek() - ch) == 32) {
                stack.pop();
            } else stack.push(ch);
        }

        stack.forEach(str::append);
        return str.toString();
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String probablyBadString = reader.readLine().strip();
            System.out.println(convertToGoodString(probablyBadString));
        }
    }
}