package programming;

public class Lab3 {

    public static void main(String[] args) {

        OneWayLinkedList list = new OneWayLinkedList();
        list.fill(9);

        System.out.println(" - - - - - Before sort - - - - -");
        list.printOut();

        System.out.println(" Head element value: " + list.head.getValue());
        System.out.println(" Tail element value: " + list.tail.getValue());
        System.out.println(" Size: " + list.size);

        System.out.print(" >>> Sorted by creating new List: ");
        list.sortOddEvenUsingNewList()
                .printOut();

//        System.out.print(" >>> Sorted by replacing Nodes references: ");
//        list.sortOddEvenByRefReplacement()
//                .printOut();

        System.out.print(" >>> Sorted by replacing Nodes references optimized method: ");
        list.sortOddEvenByRefReplacement2()
                .printOut();
    }
}
