import javax.swing.*;

public class RotateList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        ListNode curr = head;

        int length = length(curr);
        k = length - (k % length);
        if(k == length) return head;

        ListNode rota = find_rota(curr, k);
        ListNode temp = rota;

        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head;
        head = rota;


        return head;
    }

    public ListNode find_rota(ListNode curr, int k) {
        while (k > 1) {
            curr = curr.next;
            k --;
        }

        ListNode node = curr.next;
        curr.next = null;
        return node;

    }

    public int length(ListNode node) {
        int length = 0;
        while (node != null) {
            node = node.next;
            length ++;
        }

        return length;
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
//        ListNode l4 = new ListNode(4);
//        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
//        l3.next = l4;
//        l4.next = l5;

        RotateList r = new RotateList();
        r.rotateRight(l1, 2);
    }
}
