
public class StackUtill<T> {

    private Node<T> head;

    public StackUtill() {
        this.head = null;
    }

    public Node<T> getHead() {
        return head;
    }

    public void push(T x) {
        Node<T> temp = new Node<T>(x);
        temp.setNext(head);
        head = temp;
    }

    public T pop() {
        T x = head.getValue();
        head = head.getNext();
        return x;
    }

    public T top() {
        return head.getValue();
    }

    public boolean isEmpty() {
        return head == null;
    }


    public String toString() {

        if (this.isEmpty()) return "[]";
        StackUtill<T> temp = new StackUtill<T>();

        while (!this.isEmpty())
            temp.push(this.pop());

        String s = "[";

        while (!temp.isEmpty()) {
            s = s + temp.top() + ',';
            this.push(temp.pop());
        }

        s = s.substring(0, s.length() - 1) + "]";
        return s;
    }
}

