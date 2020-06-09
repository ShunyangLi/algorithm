public class ReverseLinkedList {

      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

//    public ListNode reverseList(ListNode head) {
//          if (head == null) return null;
//          ListNode curr = head;
//          ListNode next = head.next;
//          ListNode temp = null;
//          curr.next = null;
//
//
//          while (next != null) {
//              temp = next.next;
//              next.next = curr;
//              curr = next;
//              next = temp;
//          }
//
//          return curr;
//    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode last = reverseList(head.next);

        head.next.next = head;
        head.next = null;

        return last;
    }
}
