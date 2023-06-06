
/** Comment it before submitting
 public class Node {
 public final int val;
 public Node next;
 public Node(int val) {
 this.val = val;
 }
 public Node(int val, Node next) {
 this.val = val;
 this.next = next;
 }
 }
 */

/*В этой задаче требуется сделать разворот части односвязного списка.
Каждая вершина списка описывается структурой Node,
каждый экземпляр хранит указатель на следующую вершину или null (nullptr, None, nil), если вершина последняя.
По заданным индексам from и to разверните все вершины на отрезке с from до to включительно.
Заметьте, что нумерация в индексах from и to с единицы.
1,2,3,4,5 from 2 to 4
1,4,3,2,5*/
class Solution9 {

    public static void main(String[] args) {
        Node node5 = new Node(5, null);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);

        Node noder = reverse(node1, 3,4);


        while (noder != null) {
            System.out.println(noder.val);
            noder = noder.next;
        }
    }
    public static Node reverse(Node head, int left, int right) {
        Node current = head;
        Node start = current;
        Node end = current;
        Node pred = current;
        if (left > right) return head;
        while (current != null && current.val != right + 1) {
            if (current.val <= left) {
                start = pred;
                end = current;
                pred = current;
                current = current.next;
                continue;
            }

            if (current.val <= right) {
                Node next = current.next;
                current.next = pred;
                pred = current;
                current = next;
            }
        }

        if (start != null) start.next = pred; else head = pred;
        end.next = current;
        return head;
    }

    public static class Node {
        public final int val;
        public Node next;
        public Node(int val) {
            this.val = val;
        }
        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}