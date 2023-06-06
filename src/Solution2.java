import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*На стол в ряд выложены карточки, на каждой карточке написано натуральное число.
За один ход разрешается взять карточку либо с левого, либо с правого конца ряда.
Всего можно сделать k ходов. Итоговый счет равен сумме чисел на выбранных карточках.
Определите, какой максимальный счет можно получить по итогам игры.*/
public class Solution2 {

    private static long getCardCount(int n, int k, List<Long> carts) {
        long max = 0;
        long sum = 0;

        for(int i = 0; i < k; i++) {
            sum += carts.get(i);
        }
        max = sum;

        for(long i = 0; i < k; i++) {
            sum-= carts.get((int)((long)k - i - 1));
            sum+= carts.get((int)((long)n - i - 1));
            if (sum > max) max = sum;
        }

        return max;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = 6;
            int k = 2;
            List<Long> cards = List.of(1L,12L,3L,4L,5L,6L);

            System.out.println(getCardCount(n, k, cards));
        }
    }

    private static List<Long> readList(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().strip().split(" "))
                .map(Long::parseLong)
                .collect(Collectors.toList());
    }

    private static int readInt(BufferedReader reader) throws NumberFormatException, IOException {
        return Integer.parseInt(reader.readLine());
    }
}
