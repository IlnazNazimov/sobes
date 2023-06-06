import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {


    private static long getCardCount(int k, List<Integer> carts) {
        int n = carts.size();
        int[][] dp = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (i > 1) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 2][j - 1] + carts.get(n - i + 1));
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + carts.get(0));
                }
            }
        }

        return dp[n][k];
    }
    //1,1,9,2,2,2,6

    //0 0 0 0 0
    //0 1 1 1 1
    //0 6 6 6 6
    //0 6 6 6 6
    //0 0 0 0 0
    //0 0 0 0 0
    //0 0 0 0 0

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = 7;
            int k = 4;
            List<Integer> cards = List.of(1,1,9,2,2,2,6);

            System.out.println(getCardCount(k, cards));
        } catch (NumberFormatException e){
        System.out.println("not a number" + e.getMessage());
    }
}

    private static List<Integer> readList(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().strip().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static int readInt(BufferedReader reader) throws NumberFormatException, IOException {
        return Integer.parseInt(reader.readLine());
    }
}
