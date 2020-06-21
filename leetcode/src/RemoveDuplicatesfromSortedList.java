public class RemoveDuplicatesfromSortedList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode curr = head.next;
        ListNode temp = head;

        while (curr != null) {
            if (temp.val != curr.val) {
                temp.next = curr;
                temp = curr;
            }
            curr = curr.next;
        }
        temp.next = null;

        return head;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);

        l1.next = l2;
        l2.next = l3;
        l3.next = null;

        RemoveDuplicatesfromSortedList re = new RemoveDuplicatesfromSortedList();
        ListNode head = re.deleteDuplicates(l1);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

}
