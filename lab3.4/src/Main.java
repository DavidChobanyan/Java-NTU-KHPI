class SinglyLinkedList<E extends Number> {

    private class Node {
        Number data;
        Node next;
        Node(Number data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node first = null;
    private Node last  = null;
    private int  count = 0;

    public void add(Number elem) {
        Node newNode = new Node(elem, null);
        if (last == null) {
            first = newNode;
        }
        else {
            last.next = newNode;
        }
        last = newNode;
        count++;
    }

    public final int size() {
        return count;
    }

    public int findZero(){
        Node link = first;
        int counter = 0;
        while (link != null) {
            if (link.data.doubleValue() == 0) {
                return counter;
            }
            link = link.next;
            counter++;
        }
        return -1;
    }
    public int countNegative(){
        Node link = first;
        int counter = 0;
        while (link != null) {
            if (link.data.doubleValue() < 0) {
                counter++;
            }
            link = link.next;
        }
        return counter;
    }

    public Number lastNegative(){
        Node link = first;
        Number negative = 0;
        while (link != null) {
            if (link.data.doubleValue() < 0) {
                negative = link.data;
            }
            link = link.next;
        }
        return negative;
    }
    @Override
    public String toString() {
        String s = "size = " + size() + "\n[";
        Node link = first;
        while (link != null) {
            s += link.data;
            link = link.next;
            if (link != null) {
                s += ", ";
            }
        }
        s += "]";
        return s;
    }

    public static void main(String[] args) {
        SinglyLinkedList<Number> list = new SinglyLinkedList<>();
        SinglyLinkedList<Number> list2 = new SinglyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(0);
        list.add(-2);
        list.add(-1);
        list.add(4);
        list2.add(1.15123153235);
        list2.add(3);
        list2.add(503);
        list2.add(-5);
        list2.add(-3.1461123);
        list2.add(-41);
        System.out.println(list);
        System.out.println("zero index: " + list.findZero());
        System.out.println("Negative amount: " + list.countNegative());
        System.out.println("Negative last: " + list.lastNegative());
        System.out.println();
        System.out.println(list2);
        System.out.println("zero index: " + list2.findZero());
        System.out.println("Negative amount: " + list2.countNegative());
        System.out.println("Negative last: " + list2.lastNegative());
    }
}