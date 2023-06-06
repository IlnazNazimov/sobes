import java.util.*;

/*В этой задаче требуется создать копию связного графа. Оригинальный граф задается одной вершиной.
Вершина содержит свое уникальное значение – value, и список соседей neighbours.
Граф будет считаться копией, если в графе-копии есть связь между вершинами со значениями v1 и v2
 тогда и только тогда, когда она есть в оригинальном графе.
 Все вершины графа-копии должны быть созданы заново, то есть нельзя переиспользовать вершины из оригинального графа.
 Создавайте новые вершины с помощью публичных конструкторов и фабричных методов, указанных в шаблонах.*/
public class Solution13 {
    private static Map<Integer, Node> set = new HashMap<>();
    private static Set<Integer> setP = new HashSet<>();

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        n1.neighbours.add(n2);
        n1.neighbours.add(n3);
        n2.neighbours.add(n1);
        n2.neighbours.add(n4);
        n2.neighbours.add(n5);
        n3.neighbours.add(n1);
        n3.neighbours.add(n4);
        n4.neighbours.add(n3);
        n4.neighbours.add(n2);
        n4.neighbours.add(n5);
        n5.neighbours.add(n2);
        n5.neighbours.add(n4);

        Node clone = cloneGraph(n1);
        System.out.println("");
        print(clone);

    }

    private static void print(Node clone) {
        setP.add(clone.val);
        System.out.println(clone.val);
        for (Node neighbour : clone.neighbours) {
            if (!setP.contains(neighbour.val)) {
                print(neighbour);
            }
        }
    }
    public static Node cloneGraph(Node node) {
        Node n = new Node(node.val);
        set.put(node.val, n);

        for(Node nod : node.neighbours) {
            if (!set.containsKey(nod.val)) {
                n.neighbours.add(cloneGraph(nod));
            } else {
                n.neighbours.add(set.get(nod.val));
            }

        }
        return n;
    }

    public static class Node {
        public final int val;
        public final List<Node> neighbours;


        public Node(int val) {
            this.val = val;
            this.neighbours = new ArrayList<>();
        }
    }
}