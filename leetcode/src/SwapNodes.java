public class SwapNodes {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode curr = head;
        head = curr.next;
        ListNode last = null;

        while (curr != null && curr.next != null) {
            ListNode next = curr.next;
            ListNode temp = next.next;

            if (last != null) {
                last.next = curr.next;
            }
            next.next = curr;
            curr.next = null;
            last = curr;

            curr = temp;
        }

        if (curr != null && curr.next == null) last.next = curr;

        return head;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
//        ListNode n4 = new ListNode(4);

        n1.next = n2;
        n2.next = n3;
//        n3.next = n4;

        SwapNodes s = new SwapNodes();
        ListNode head = s.swapPairs(n1);
        System.out.println(head.val);
    }
}
