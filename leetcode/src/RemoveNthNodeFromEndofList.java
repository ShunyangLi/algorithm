
public class RemoveNthNodeFromEndofList {
    public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = null;
        ListNode slow = head;
        ListNode fast = head;


        while (fast != null) {
            if (n <= 0) {
                curr = slow;
                slow = slow.next;
            }
            fast = fast.next;
            n --;
        }

        // means at the head
        if(curr == null) head = head.next;
        if (curr != null) curr.next = slow.next;

        return head;
    }
}
