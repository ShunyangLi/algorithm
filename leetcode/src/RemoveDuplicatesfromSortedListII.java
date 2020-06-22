public class RemoveDuplicatesfromSortedListII {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode last = null;
        ListNode curr = head;

        while (curr.next != null) {
            if (curr.val == curr.next.val) {
                ListNode node = different(curr);
                if (last == null) {
                    head = node;
                } else {
                    last.next = node;
                }
                curr = node;
                if (curr == null) break;
                continue;
            } else {
                last = curr;
            }
            curr = curr.next;
        }

        return head;
    }

    public ListNode different(ListNode node) {
        ListNode last = node;
        while (node.next != null) {
            if (node.val != node.next.val) {
                return node.next;
            }
            last = node;
            node = node.next;
        }
        if (last.val == node.val) return null;
        return node;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(2);
//        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
//        l4.next = l5;

        RemoveDuplicatesfromSortedListII r = new RemoveDuplicatesfromSortedListII();
        r.deleteDuplicates(l1);
    }
}
