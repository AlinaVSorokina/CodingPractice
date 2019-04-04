package preparation;

import Util.LogStructure;

/**
 * You run an e-commerce website and want to record the last N order ids in a log. Implement a data structure to accomplish this, with the following API:
 * record(order_id): adds the order_id to the log
 * get_last(i): gets the ith last element from the log. i is guaranteed to be smaller than or equal to N.
 * You should be as efficient with time and space as possible.
 */
public class Day16 {
    public static void main(String[] args) {
        LogStructure ls = new LogStructure(5);
        ls.record(1);
        ls.record(2);
        ls.record(3);
        ls.record(4);
        ls.record(5);
        ls.record(6);
        ls.record(7);
        System.out.println(ls.get(3));
    }
}
