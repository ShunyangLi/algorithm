public class PalindromeLinkedList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
//    public boolean isPalindrome(ListNode head) {
//        if (head == null) return false;
//        if (head.next == null) return true;
//        long [] nums = new long[]{0, 0};
//        recur(head,nums);
//
//        return nums[0] == nums[1];
//    }
//
//    public void recur(ListNode curr, long[] nums) {
//        if (curr == null) return ;
//
//        nums[0] = nums[0]*10 + curr.val;
//        recur(curr.next, nums);
//        nums[1] = nums[1]*10 + curr.val;
//    }

    boolean flag = true;
    public boolean isPalindrome(ListNode head) {
        recur(head, head);
        return flag;
    }

    public ListNode recur(ListNode p1, ListNode p2) {
        if (p1 == null) return p2;
        ListNode node = recur(p1.next, p2);
        if (node.val != p1.val) flag = false;
        return node.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);

        n1.next = n2;
        n2.next = n3;

        PalindromeLinkedList p = new PalindromeLinkedList();
        System.out.println(p.isPalindrome(n1));

    }
}
