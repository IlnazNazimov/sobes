import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*Вам даны две последовательности отрезков. Каждый отрезок задаётся координатой начала и конца — [starti,endi].
Отрезки каждой последовательности отсортированы слева направо и не имеют общих точек.
Найдите пересечение двух последовательностей отрезков. То есть третью последовательность отрезков, такую, что:

Каждый отрезок содержится в некотором отрезке и первой, и второй последовательности;
Никакой отрезок нельзя увеличить;
Отрезки этой последовательности не имеют общих точек;
Отрезки в последовательности также отсортированы в порядке возрастания.*/

public class Solution11 {

    private static List<Segment> getIntersection(List<Segment> firstSequence, List<Segment> secondSequence) {
        List<Segment> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i < firstSequence.size() && j < secondSequence.size()) {
            Segment f = firstSequence.get(i);
            Segment s = secondSequence.get(j);
            if (f.left <= s.right  && s.left <= f.right) {
                int right = Math.min(f.right, s.right);
                int left = Math.max(f.left, s.left);
                result.add(new Segment(left,right));
            }

            if(f.right < s.right) {
                i++;
            } else j++;

        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            Segment s = new Segment(1,4);
            Segment s1 = new Segment(5,10);
            Segment s2 = new Segment(15,16);
            Segment f1 = new Segment(0,2);
            Segment f2 = new Segment(4,5);
            List<Segment> firstSequence = List.of(s,s1,s2);
            List<Segment> secondSequence = List.of(f1,f2);

            List<Segment> intersection = getIntersection(firstSequence, secondSequence);
            outputAnswer(intersection, writer);
        }
    }

    private static void outputAnswer(List<Segment> intersection, BufferedWriter writer) throws IOException {
        for (Segment segment : intersection) {
            writer.write(segment.left + " " + segment.right + "\n");
        }
    }

    private static List<Segment> readSegments(BufferedReader reader) throws IOException {
        int n = readInt(reader);
        List<Segment> segments = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            List<Integer> borders = readTwoNumbers(reader);
            segments.add(new Segment(borders.get(0), borders.get(1)));
        }
        return segments;
    }

    private static class Segment {
        public final int left;
        public final int right;

        public Segment(int left, int right) {
            this.left = left;
            this.right = right;
        }
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
}