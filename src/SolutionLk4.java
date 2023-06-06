/*Перевернуть односвязный список. Учитывая head односвязный список, переверните список и верните перевернутый список.*/
class SolutionLk4 {
    public ListNode reverseList(ListNode head) {
        ListNode next = null;
        ListNode current = head;
        ListNode pred = null;

        while(current != null) {
            next = current.next;
            current.next = pred;
            pred = current;
            current = next;
        }
        return pred;
    }

      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}