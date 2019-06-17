package programming;

import java.util.ArrayList;
import java.util.List;

class OneWayLinkedList {

    Node head = null;
    Node tail = null;
    int size;
    private Node head1;

    void add(int value) {
        Node newNode = new Node(value);

        if (size == 0) {
            this.head = newNode;
        } else {
            this.tail.next = newNode;
        }

        this.tail = newNode;
        this.size++;
    }

    void removeHead() {
        final Node next = head.next;
        head.value = null;
        head.next = null;
        head = next;
        if (next == null)
            tail = null;
        size--;
    }

    OneWayLinkedList sortOddEvenUsingNewList() {
        List<Integer> tempEvenNumbersList = new ArrayList<>();
        OneWayLinkedList newList = new OneWayLinkedList();

        Node node = head;
        while (node != null) {

            if (node.isEven()) {
                tempEvenNumbersList.add(node.getValue());
            } else {
                newList.add(node.getValue());
            }
            node = node.next;
        }

        for (Integer value : tempEvenNumbersList) {
            newList.add(value);
        }

        return newList;
    }

    OneWayLinkedList sortOddEvenByRefReplacement() {
        Node head = this.head;
        Node tail = this.tail;

        Node currentElement = head;
        Node next = currentElement.next;
        Node nextNext = next.next;

        for (int i = 0; i < size; i++) {
            while (nextNext != null) {
                if (currentElement.sameNode(head)) {
                    if (next.isEven() && nextNext.isOdd()) {
                        currentElement.next = nextNext;
                        next.next = nextNext.next;
                        nextNext.next = next;
                    }

                    if (currentElement.isEven() && next.isOdd()) {
                        this.head = next;
                        this.head.next = currentElement;
                        currentElement.next = nextNext;
                    }
                } else if (nextNext.sameNode(tail)) {
                    if (next.isEven() && nextNext.isOdd()) {
                        currentElement.next = nextNext;
                        nextNext.next = next;
                        next.next = null;
                        this.tail = next;
                        tail = next;
                    }
                } else if (next.isEven() && nextNext.isOdd()) {
                    currentElement.next = nextNext;
                    next.next = nextNext.next;
                    nextNext.next = next;
                }

                currentElement = currentElement.next;
                next = currentElement.next;
                nextNext = next.next;

                //Debug print to find out how many iterations algorithm is going through
                //printOut();
            }

            currentElement = head;
            next = currentElement.next;
            nextNext = next.next;
        }

        return this;
    }

    OneWayLinkedList sortOddEvenByRefReplacement2() {
        if (size < 2) {
            return this;
        }

        Node evenHead = null;
        Node evenTail = null;

        Node oddTail = null;
        Node oddHead = null;

        Node current = head;

        while (current != null) {
            if (current.isEven()) {
                if (evenHead == null) {
                    evenHead = evenTail = current;
                } else {
                    evenTail.next = current;
                    evenTail = current;
                }
            } else {
                if (oddHead == null) {
                    oddHead = oddTail = current;
                } else {
                    oddTail.next = current;
                    oddTail = current;
                }
            }
//            printOut();
            current = current.next;
        }

        oddTail.next = evenHead;
        evenTail.next = null;
        head = oddHead;

        return this;
    }

    void printOut() {
        System.out.print(" All list elements: ");
        Node currentElement = this.head;
        while (currentElement != null) {
            System.out.print(currentElement.value + " ");
            currentElement = currentElement.next;
        }
        System.out.println();
    }

    void fill(int countOfElementToCreate) {
        for (int i = 1; i <= countOfElementToCreate; i++) {
            this.add(i);
        }
    }
}