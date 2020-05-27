public class TwoNumAdd {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int overflow = 0;
        if (l1 == null && l2 == null) return null;

        ListNode new_node = new ListNode();
        ListNode head = new_node;

        while (l1 != null || l2 != null) {
            int v1 = (l1 != null) ? l1.val : 0;
            int v2 = (l2 != null) ? l2.val : 0;

            int sum = v1+v2 + overflow;
            overflow = sum / 10;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;

            new_node.val = sum % 10;

            if (l1 != null || l2 != null) {
                new_node.next = new ListNode();
                new_node = new_node.next;
            }

        }

        if (overflow > 0) {
            new_node.next = new ListNode(overflow % 10);
        }

        return head;
    }

}
