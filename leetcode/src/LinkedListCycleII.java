import java.util.HashMap;

public class LinkedListCycleII {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // hashmap的解决方法
//    public ListNode detectCycle(ListNode head) {
//        HashMap<ListNode, Integer> map = new HashMap<>();
//
//        ListNode curr = head;
//        while (curr != null) {
//            if (map.containsKey(curr)) {
//                return curr;
//            } else {
//                map.put(curr, 1);
//            }
//            curr = curr.next;
//        }
//
//        return null;
//    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode curr = head;

        while (curr.next != null) {
            ListNode temp = loop(curr.next, curr.next.next, curr);
            if (temp != null) return curr;
            curr = curr.next;
        }

        return null;
    }

    public ListNode loop(ListNode slow, ListNode fast, ListNode node) {
        if (slow == null || fast == null || slow.next == null || fast.next == null
                || fast.next.next == null) return null;
        if (slow == fast && slow == node) return slow;
        if (slow == fast) return null;
        return loop(slow.next, fast.next.next, node);
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
//        l4.next = l2;

        LinkedListCycleII l = new LinkedListCycleII();
        l.detectCycle(l1);
    }




}
