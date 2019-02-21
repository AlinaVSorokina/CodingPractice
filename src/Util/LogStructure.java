package Util;

public class LogStructure {

    private int[] log;
    private int head;
    private int N;

    public LogStructure(int N) {
        this.log = new int[N];
        this.head = 0;
        this.N = N;
    }

    public void record(int id){
        log[head] = id;
        head = getNext();
    }

    public int get(int i) {
        return log[getI(i)];
    }

    private int getI(int i) {
        if (i > head) {
            return N - i + head;
        } else {
            return head - i;
        }
    }

    private int getNext() {
        if (head == N - 1) return 0;
        return head + 1;
    }

}
