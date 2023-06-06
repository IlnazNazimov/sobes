import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/*Вы играете в игру «Монополия++». В этой игре можно купить не более k зданий,
каждое из которых будет добавлять к вашему капиталу какую-то сумму. Всего есть выбор из n зданий.
Чтобы купить здание i, надо иметь текущий капитал хотя бы ci. После покупки здание добавит в ваш текущий капитал сумму pi.
Изначально ваш капитал равен M. Определите, каким максимальным капиталом можно овладеть к концу игры.*/
public class Solution14 {

    private static long getMaxFinalCapital(List<Building> buildings, int startCapital, int maxNumberOfBuildings) {
        buildings.sort(Comparator.comparingInt(a -> a.needCapital));
        int buy = 0;
        int sum = startCapital;
        int i = 0;
        PriorityQueue<Building> q = new PriorityQueue<>((a, b) -> b.addedCapital - a.addedCapital);

        while(buy < maxNumberOfBuildings) {
            while(i < buildings.size() && buildings.get(i).needCapital <= sum) {
                q.add(buildings.get(i));
                i++;
            }
            Building b = q.poll();
            if (b != null) {sum += b.addedCapital;} else break;
            buy++;
        }

        return sum;
    }
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            List<Integer> nAndK = readTwoNumbers(reader);
            int n = nAndK.get(0);
            int k = nAndK.get(1);
            List<Building> buildings = readBuildings(reader, n);
            int M = readInt(reader);
            System.out.println(getMaxFinalCapital(buildings, M, k));
        }
    }

    private static List<Building> readBuildings(BufferedReader reader, int n) throws IOException {
        List<Building> buildings = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            List<Integer> parameters = readTwoNumbers(reader);
            buildings.add(new Building(parameters.get(0), parameters.get(1)));
        }
        return buildings;
    }

    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static List<Integer> readTwoNumbers(BufferedReader reader) throws IOException {
        return Arrays.asList(reader.readLine().strip().split(" "))
                .stream()
                .map(elem -> Integer.parseInt(elem))
                .collect(Collectors.toList());
    }

    private static class Building {
        public final int needCapital;
        public final int addedCapital;

        public Building(int c, int p) {
            needCapital = c;
            addedCapital = p;
        }
    }

}