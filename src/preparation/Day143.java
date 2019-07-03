package preparation;

import Util.ListNode;

/**
 * Created by alina on 27.06.19.
 */
public class Day143 {
    public static void main(String[] args) {
        int[] input = {9, 12, 3, 5, 14, 10, 10};

        int[] result = semiSort(input, 14);

        System.out.print("");
    }

    public static int[] semiSort(int[] input, int number) {
        ListNode numNodeFirst = new ListNode(number);
        ListNode numNodeLast = numNodeFirst;
        ListNode head = numNodeFirst;

        for (int i = 0; i < input.length; i++) {
            ListNode node = new ListNode(input[i]);
            if (input[i] < number) {
                node.next = head;
                head = node;
            } else if (input[i] == number) {
                node.next = numNodeLast.next;
                numNodeLast.next = node;
                numNodeLast = node;
            } else {
                node.next = numNodeLast.next;
                numNodeLast.next = node;
            }
        }
        if (numNodeFirst.next != null) {
            numNodeFirst.next = numNodeFirst.next.next;
        }

        int[] result = new int[input.length];
        int i = 0;
        while (head != null) {
            result[i] = head.data;
            i++;
            head = head.next;
        }

        return result;
    }
}
