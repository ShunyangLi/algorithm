import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MinStack {
    /** initialize your data structure here. */
    private List<Integer> list;
    private int lens;

    public MinStack() {
        this.list = new LinkedList<>();
        this.lens = 0;
    }

    public void push(int x) {
        this.list.add(x);
        this.lens ++;
    }

    public void pop() {
        if (this.list.size() > 0) {
            this.lens --;
            this.list.remove(this.lens);
        }
    }

    public int top() {
        if (this.list.size() > 0) {
            return this.list.get(this.lens - 1);
        }
        return -1;
    }

    public int getMin() {
        return Collections.min(this.list);
    }

    public static void main(String[] args) {
        MinStack m = new MinStack();
        m.push(-2);
        m.push(0);
        m.push(-3);
        System.out.println(m.getMin());
        m.pop();
        System.out.println(m.top());   // return 0
        System.out.println(m.getMin()); // return -2
    }
}
