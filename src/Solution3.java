import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*Вам дан массив натуральных чисел ai. Найдите число таких пар элементов
(ai,aj), где ∣ai−aj∣%200==0 и i < j. */
public class Solution3 {

    private static long getNumberOfGoodPairs(int n, List<Integer> numbers) {
        Map<Integer, Long> map = new HashMap<>();
        long count = 0;

        for (Integer number : numbers) {
            int ost = number % 200;
            if (map.containsKey(ost)) {
                count += map.get(ost);
            }
            map.merge(ost, 1L, Long::sum);
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = readInt(reader);
            List<Integer> numbers = readList(reader);
            System.out.println(getNumberOfGoodPairs(n, numbers));
        }
    }

    private static List<Integer> readList(BufferedReader reader) throws IOException {
        return Arrays.asList(reader.readLine().strip().split(" "))
                .stream()
                .map(token -> Integer.parseInt(token))
                .collect(Collectors.toList());
    }

    private static int readInt(BufferedReader reader) throws NumberFormatException, IOException {
        return Integer.parseInt(reader.readLine());
    }
}
