import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Solution15 {

    private static boolean isOnOneLine(List<Point> points) {
        if (points == null || points.isEmpty() || points.size() < 2) {
            return false;
        }
        if (points.size() == 2) return true;
        Point pointA = points.get(0);
        Point pointB = points.get(1);

        //(x1-x3)*(y2-y3)-(x2-x3)*(y1-y3)=0;

        for (int i = 0; i < points.size(); i++) {
            Point pointC = points.get(i);
            if((pointA.x - pointC.x) * (pointB.y - pointC.y) - (pointB.x - pointC.x)*(pointA.y - pointC.y) != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = readInt(reader);
            List<Point> points = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                List<Integer> coordinates = readTwoNumbers(reader);
                points.add(new Point(coordinates.get(0), coordinates.get(1)));
            }
            if (isOnOneLine(points)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
    }

    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static List<Integer> readTwoNumbers(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().strip().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static class Point {
        public final int x;
        public final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}