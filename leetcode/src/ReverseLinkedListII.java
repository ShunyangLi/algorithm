public class ReverseLinkedListII {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m >= n || head == null || head.next == null) return head;

        int index = 1;
        ListNode curr = head;
        ListNode start = null;
        ListNode end = null;
        ListNode pre = null;

        while (curr != null) {
            if (index == m) start = curr;
            if (index == n) end = curr;
            if (start == null) pre = curr;
            curr = curr.next;
            ++index;
        }

        if (end == null || start == null) return head;

        ListNode rest = end.next;
        end.next = null;
        reverse(start, start.next);
        // 现在endu应该是head

        if (pre == null) head = end;
        else pre.next = end;

        start.next = rest;

        return head;
    }

    public void reverse(ListNode curr, ListNode next) {
        if (next == null) return;

        reverse(next, next.next);
        next.next = curr;
        curr.next = null;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        ReverseLinkedListII r = new ReverseLinkedListII();
        r.reverseBetween(l1, 1, 4);
    }
}
