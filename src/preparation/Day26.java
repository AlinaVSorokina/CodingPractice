package preparation;

import Util.ListNode;

/**
 * Given a singly linked list and an integer k, remove the kth last element from the list.
 * k is guaranteed to be smaller than the length of the list.
 * The list is very long, so making more than one pass is prohibitively expensive.
 * Do this in constant space and in one pass.
 */
public class Day26 {
    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        ListNode a6 = new ListNode(6);
        ListNode a7 = new ListNode(7);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = a6;
        a6.next = a7;
        ListNode res = getKth(a1, 5);
        System.out.print(res.data);
    }

    public static ListNode getKth(ListNode head, int k) {
        ListNode pointer = head;
        for (int i = 0; i < k; i++) {
            pointer = pointer.next;
        }
        ListNode second = head;
        while (pointer != null) {
            pointer = pointer.next;
            second = second.next;
        }
        return second;
    }
}
