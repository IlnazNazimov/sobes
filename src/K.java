import com.sun.source.tree.Tree;

import java.util.*;

public class K {

    public static int countWays(int n, int k) {
        int sum = 1;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        for (int i = 2; i < n; i++) {
            q.add(sum);
            sum+=sum;
            if (i >= k + 1) {
                sum -= q.poll();
            }
        }
        return sum;
    }

    public static int countWays2(int[] mas, int k) {
        int n = mas.length;
        int[] sums = new int[n];
        sums[0] = mas[0];

        for (int i = 1; i < n; i++) {
            int min = Integer.MIN_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0 && sums[i - j] > min) {
                    min = sums[i - j];
                }
            }

            sums[i] = min + mas[i];
        }
        return sums[n - 1];
    }

    public static void main(String[] args) {
        int n = 5; // номер целевой клетки
        int k = 2; // максимальное количество клеток, на которое можно прыгнуть
        int[] nn = new int[]{1,3,2,1,7,2};
        int result = countWays2(nn, k);
        System.out.println("Количество способов достичь клетки " + n +
                " с использованием прыжков от 1 до " + k + ": " + result);
    }
}
