/*Вам даны два непустых связанных списка, представляющих два неотрицательных целых числа.
Цифры хранятся в обратном порядке , и каждый из их узлов содержит одну цифру.
Добавьте два числа и верните сумму в виде связанного списка.
Ввод: l1 = [2,4,3], l2 = [5,6,4]
 Вывод: [7,0,8]
 Объяснение: 342 + 465 = 807.*/
class SolutionLk3 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return sum(l1, l2);
    }

    private ListNode sum(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode newNode = new ListNode(0);
        ListNode result = newNode;
        boolean flag = false;

        while(l1 != null || l2 != null || flag) {
            int sum = 0;
            if (l1!=null) {
                sum = sum + l1.val;
                l1 = l1.next;
            }
            if (l2!=null) {
                sum = sum + l2.val;
                l2 = l2.next;
            }
            if (flag) {
                sum = sum + 1;
                flag = false;
            }
            if (sum > 9) {
                newNode.next = new ListNode(sum % 10);
                flag = true;
            } else newNode.next = new ListNode(sum);
            newNode = newNode.next;
        }
        return result.next;
    }

      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}