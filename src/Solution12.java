import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

/*В этой задаче вам надо реализовать структуру данных исторический массив. Исторический массив изначально имеет размер n
и заполнен нулями. Он поддерживает следующие операции:
set(index, value) - присвоить элементу на позиции i значение value
begin_new_era(era_id) - эта операция начинает новую эру с номером era_id. В каждый момент времени активна единственная эра.
                        Изначальная эра имеет индекс era_id=0. Когда начинается новая эра, предыдущая заканчивается.
get(index, era_id) - получить значение элемента на позиции index на момент окончания эры era_id.*/
public class Solution12 {

    private static class HistoricalArray {
        private final Map<Integer, int[]> map = new HashMap<>();
        private int era = 0;
        private final int n;

        public HistoricalArray(int n) {
            map.put(0, new int[n]);
            this.n = n;
        }

        public void set(int index, int value) {
            if(map.containsKey(era)) {
                map.get(era)[index] = value;
            }
        }

        public void beginNewEra(int eraId) {
            this.era = eraId;
            map.put(era, new int[n]);
        }

        public int get(int index, int eraId) {
            if (map.containsKey(eraId)) {

                return map.get(eraId)[index];
            }
            return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = readInt(reader);
            HistoricalArray array = new HistoricalArray(n);
            int q = readInt(reader);
            for (int i = 0; i < q; i++) {
                List<String> queryParts = Arrays.asList(reader.readLine().strip().split(" "));
                String queryType = queryParts.get(0);
                if (queryType.equals("set")) {
                    int index = Integer.parseInt(queryParts.get(1));
                    int value = Integer.parseInt(queryParts.get(2));
                    array.set(index, value);
                } else if (queryType.equals("begin_new_era")) {
                    int eraId = Integer.parseInt(queryParts.get(1));
                    array.beginNewEra(eraId);
                } else if (queryType.equals("get")) {
                    int index = Integer.parseInt(queryParts.get(1));
                    int eraId = Integer.parseInt(queryParts.get(2));
                    writer.write(array.get(index, eraId) + "\n");
                }
            }
        }
    }

    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }
}