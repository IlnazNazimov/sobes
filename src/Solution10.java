/*В этой задаче вам надо определить, подходит ли строка под конкретный шаблон. Шаблон задаётся в следующем формате:
Символ «?» соответствует одному вхождению любого символа;
Символ «*» соответствует произвольному числу любых символов, в том числе нулю символов;
Остальные символы шаблона должны совпадать с символами строки;*/
public class Solution10 {
    public static boolean isMatch(String pattern, String string) {
        // Создаем двумерный массив размером (len(pattern) + 1) x (len(string) + 1)
        // и инициализируем все ячейки значением false
        boolean[][] dp = new boolean[pattern.length() + 1][string.length() + 1];

        // Пустой шаблон и пустая строка считаются совпадением
        dp[0][0] = true;

        // Обработка случая, когда шаблон начинается с '*'
        for (int i = 1; i <= pattern.length(); i++) {
            if (pattern.charAt(i - 1) == '*') {
                dp[i][0] = dp[i - 1][0];
            }
        }

        // Заполнение таблицы с использованием динамического программирования
        for (int i = 1; i <= pattern.length(); i++) {
            for (int j = 1; j <= string.length(); j++) {
                // Если символы совпадают или шаблон содержит '?', переносим значение из предыдущей ячейки
                if (pattern.charAt(i - 1) == '?' || pattern.charAt(i - 1) == string.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                // Если шаблон содержит '*', проверяем возможность совпадения с пустой строкой (dp[i][j-1])
                // или совпадения с предыдущим символом в шаблоне (dp[i-1][j])
                else if (pattern.charAt(i - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }

        // Возвращаем значение из правого нижнего угла таблицы
        return dp[pattern.length()][string.length()];
    }

    public static void main(String[] args) {
        String pattern = "*ca?a*";
        String string = "ocabag";
        boolean isMatch = isMatch(pattern, string);
        System.out.println("Соответствие: " + isMatch);
    }
}