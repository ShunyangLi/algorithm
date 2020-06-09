import java.util.HashMap;
import java.util.Map;

public class IntersectionofTwoLinkedLists {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode head = null;
        ListNode curr = headA;
        Map<ListNode, Integer> map = new HashMap<>();

        while (curr != null) {
            map.put(curr, curr.val);
            curr = curr.next;
        }

        curr = headB;
        while (curr != null) {
            if (map.containsKey(curr)) {
                head = curr;
                break;
            }
            curr = curr.next;
        }

        return head;
    }

}
