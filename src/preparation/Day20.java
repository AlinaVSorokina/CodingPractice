package preparation;

import Util.ListNode;

/**For example, given A = 3 -> 7 -> 8 -> 10 and B = 99 -> 1 -> 8 -> 10, return the node with value 8.
 * In this example, assume nodes with the same value are the exact same node objects.
 * Do this in O(M + N) time (where M and N are the lengths of the lists) and constant space.
 */
public class Day20 {
    public static void main(String[] args) {
        //todo
    }

    public static ListNode getCommonPoint(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) return null;
        int firstLength = 1;
        ListNode head1 = list1;
        while (head1.next != null) {
            firstLength++;
            head1 = head1.next;
        }
        int secondLength = 1;
        ListNode head2 = list2;
        while (head2.next != null) {
            secondLength++;
            head2 = head2.next;
        }
        head1 = list1;
        head2 = list2;
        if (secondLength > firstLength) {
            int diff = secondLength - firstLength;
            for (int i = diff; i > 0; i--) {
                head2 = head2.next;
            }
        }
        if (secondLength < firstLength) {
            int diff = firstLength - secondLength;
            for (int i = diff; i > 0; i--) {
                head1 = head1.next;
            }
        }
        while (head1 != null) {
            if (head1.next == head2.next) return head1.next;
        }
        return null;
    }
}
