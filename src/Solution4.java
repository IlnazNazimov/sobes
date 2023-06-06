import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*Вам дана матрица из n строк и m столбцов, заполненная натуральными числами.
По матрице можно перемещаться, из клетки можно уходить только в соседнюю по стороне клетку, переходы по диагонали,
а также выход за границу матрицы запрещены.Ваша задача — найти наиболее длинный возрастающий путь в матрице.
Путь возрастающий, если значения в посещаемых клетках строго возрастают от начала пути к его концу.*/
public class Solution4{

    private static int getLongestIncreasingPath(List<List<Integer>> matrix) {
        int n = matrix.size();
        int m = matrix.get(0).size();
        int[][] results = new int[n][m];
        int max = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int length = getLength(matrix, results, i, j);
                if (length > max) max = length;
            }
        }
        return max;
    }

    private static int getLength(List<List<Integer>> matrix, int[][] results, int i, int j) {
        if (results[i][j] != 0) {
            return results[i][j];
        }

        int max = 1;

        if (j != matrix.get(0).size() - 1 && matrix.get(i).get(j + 1) > matrix.get(i).get(j)) {
            int length = getLength(matrix, results, i, j + 1);
            if (length > max) {
                max = length;
            }
        }

        if (i != 0 && matrix.get(i - 1).get(j) > matrix.get(i).get(j)) {
            int length = getLength(matrix, results, i - 1, j);
            if (length > max) {
                max = length;
            }
        }

        if (j != 0 && matrix.get(i).get(j - 1) > matrix.get(i).get(j)) {
            int length = getLength(matrix, results, i, j - 1);
            if (length > max) {
                max = length;
            }
        }

        if (i != matrix.size() - 1 && matrix.get(i + 1).get(j) > matrix.get(i).get(j)) {
            int length = getLength(matrix, results, i + 1, j);
            if (length > max) {
                max = length;
            }
        }

        results[i][j] = max;


        return max;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            List<List<Integer>> matrix = readMatrix(reader);

            System.out.println(getLongestIncreasingPath(matrix));
        }

    }

    private static List<List<Integer>> readMatrix(BufferedReader reader) throws IOException {
        String[] sizes = reader.readLine().strip().split(" ");
        int n = Integer.parseInt(sizes[0]);
        List<List<Integer>> matrix = new ArrayList<List<Integer>>(n);
        for (int i = 0; i < n; i++) {
            matrix.add(readList(reader));
        }
        return matrix;
    }

    private static List<Integer> readList(BufferedReader reader) throws IOException {
        return Arrays.asList(reader.readLine().strip().split(" "))
                .stream()
                .map(token -> Integer.parseInt(token))
                .collect(Collectors.toList());
    }
}