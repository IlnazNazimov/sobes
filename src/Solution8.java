import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Collections;

public class Solution8 {

    private static long getEnergyForUnion(List<Integer> stones) {
        long energi = 0;
        if (stones == null || stones.isEmpty() || stones.size() == 1) return energi;
        Collections.sort(stones);
        long predEl = stones.get(0);
        for(int i = 1; i < stones.size(); i++) {
            predEl = (long)stones.get(i) + predEl;
            energi += predEl;
        }
        return energi;
    }

    public static void main(String[] args) throws IOException {

            int n = 3;
            List<Integer> stones = new ArrayList<>();
            stones.add(2);
            stones.add(6);
            stones.add(3);
            stones.add(10);
            stones.add(15);

            System.out.println(getEnergyForUnion(stones));

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