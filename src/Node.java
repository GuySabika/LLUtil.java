import java.util.ArrayList;
import java.util.Scanner;

public class Node<T> {
    private static Scanner in = new Scanner(System.in);
    private T value;
    private Node<T> next;

    public Node(T value) {
        this.value = value;
        this.next = null;
    }

    public Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }

    public T getValue() {
        return this.value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public boolean hasNext() {
        return this.next != null;
    }

    public void removeNextNode() {
        if (this.next.next != null) {
            this.next = this.next.next;
        } else {
            this.next = null;
        }

    }

    public void addNode(T value) {
        if (!hasNext()) {
            this.next = new Node<>(value);
        } else {
            Node<T> newOne = new Node<>(value);
            newOne.setNext(this.next);
            this.setNext(newOne);
        }
    }

    public Node<T> sameValues(Node<T> list1, Node<T> list2) {
        Node<T> pointer1 = list1;
        Node<T> pointer2 = list2;
        ArrayList<T> arr = new ArrayList<>() {
        };
        while (pointer2 != null) {
            while (pointer1 != null) {
                if (pointer1.getValue() == pointer2.getValue())
                    arr.add(pointer1.getValue());
                pointer1 = pointer1.getNext();
            }
            pointer2 = pointer2.getNext();
            pointer1 = list1;
        }

        for (int i = 0; i < arr.size(); i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                if (arr.get(i) == arr.get(j)) {
                    arr.remove(i);
                }
            }
        }
        Node<T> Values = new Node<T>(arr.get(0));
        for (int i = 1; i < arr.size(); i++) {
            Values.addNode(arr.get(i));
        }
        return Values;
    }

    public Node<Integer> numberNode(Node<Integer> list, int num) {
        Node<Integer> pointer = list;
        pointer = pointer.getNext();
        boolean number = false;
        while (pointer != list) {
            if (num == pointer.next.getValue())
                if (number) {
                    pointer.removeNextNode();
                }
            number = true;
            pointer = pointer.getNext();
        }
        if (!number) {
            list.addNode(num);
        }
        return list;
    }

    public void endlessNode() {
        Node<T> pointer = this;
        while (pointer.hasNext()) {
            pointer = pointer.getNext();
        }
        pointer.setNext(this);
    }

    public int countValues(Node<T> list) {
        Node<T> pointer = list;
        int count = 0;
        while (pointer == list) {
            pointer = pointer.getNext();
        }
        return count;
    }

    public Node<T> inputNode() {
        System.out.println("enter a number for the list");
        int num = in.nextInt();
        Node pointer = null;
        ArrayList<Integer> list = new ArrayList<>();
        while (num != -1) {
            list.add(num);
            System.out.println("enter a number for the list: enter -1 to exit loop");
            num = in.nextInt();
        }
        Node pointer1 = new Node(list.get(0));
        pointer = pointer1;
        for (int i = 1; i < list.size(); i++) {
            pointer.setNext(new Node(list.get(i)));
            pointer = pointer.getNext();
        }
        return pointer1;
    }


    public String abcOrder(Node<String> list) {
        String[] abc = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        int last_a = 0;
        int a = 0;
        while (list.hasNext()) {
            for (int i = a + 1; i < abc.length; i++) {
                if (abc[i].compareTo(list.getValue() + "") <= 1) {
                    a = i;
                }
            }
            if (last_a == a)
                return list.getValue();
            last_a = a;
            list = list.getNext();
        }
        return null;
    }
}