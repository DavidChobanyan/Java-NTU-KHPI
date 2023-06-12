class DoublyLinkedList<E> {

    private class Node {
        E data;
        Node next;
        Node prev;
        Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node first = null;
    private Node last  = null;
    private int  count = 0;

    public void add(E elem) {
        Node newNode = new Node(elem, null);
        if (last == null) {
            first = newNode;
        }
        else {
            last.next = newNode;
            last.next.prev = last;
        }
        last = newNode;
        count++;
    }

    public void removeFirstOccurrence(E value) {
        // Окремо перевіряємо перший елемент
        if (first != null && first.data.equals(value)) {
            first = first.next;
            count--;
        }
        else {
            Node link = first;
            while (link.next != null) {
                if (link.next.data.equals(value)) {
                    link.next = link.next.next;
                    count--;
                }
                if (link.next == null) {
                    last = link;
                    break; // видалили останній елемент
                }
                link = link.next;
            }
        }
    }

    public final int size() {
        return count;
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
        s += "]\n";
        return s;
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list);
        // Видаляємо середній елемент:
        list.removeFirstOccurrence(3);
        System.out.println(list);
        // Видаляємо перший елемент:
        System.out.println(list);
        // Видаляємо останній елемент:
        list.removeFirstOccurrence(4);
        System.out.println(list);
    }
}