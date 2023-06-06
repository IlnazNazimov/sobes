/*Объединить отсортированные списки*/
class SolutionLk1 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeMas(lists, 0, lists.length - 1);
    }

    private ListNode mergeMas(ListNode[] mas, int start, int end) {
        if (start == end) {
            return mas[start];
        }

        int k = start + (end - start) / 2;
        ListNode a = mergeMas(mas, start, k);
        ListNode b = mergeMas(mas, k + 1, end);

        ListNode result = new ListNode(0);
        ListNode current = result;

        while (a != null && b != null) {
            if (a.val < b.val) {
                current.next = a;
                a = a.next;
            } else {
                current.next = b;
                b = b.next;
            }
            current = current.next;
        }

        current.next = a == null ? b : a;
        return result.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}