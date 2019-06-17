package programming;

class Node {

    Integer value;
    Node next;

    Node(Integer value) {
        this.value = value;
    }

    Integer getValue() {
        return value;
    }

    Node getNext() {
        return next;
    }

    void setValue(Integer value) {
        this.value = value;
    }

    void setNext(Node next) {
        this.next = next;
    }

    boolean isOdd() {
        return value % 2 != 0;
    }

    boolean isEven() {
        return value % 2 == 0;
    }

    boolean sameNode(Node node) {
        return this == node;
    }

}