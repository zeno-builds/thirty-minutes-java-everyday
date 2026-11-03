package dsa.raw.linked_lists.problems;
import dsa.raw.linked_lists.CDLL;

public class ReverseACDLL {
    public static void reverseList(CDLL list){
        if (list.getHead() == null || list.getHead() == list.getTail()) {
            return;
        }

        CDLL.Node curr = list.getHead();

        do {
            // Store the original next node
            CDLL.Node temp = curr.next;

            // Swap next and prev
            curr.next = curr.prev;
            curr.prev = temp;

            // Move using the original next reference
            curr = temp;

        } while (curr != list.getHead());

        // Update head and tail
        CDLL.Node oldHead = list.getHead();
        CDLL.Node oldTail = list.getTail();

        list.setHead(oldTail);
        list.setTail(oldHead);
    }
    public static void main(String args[]){
        CDLL list = new CDLL();

        list.insertAtFirst(10);
        list.insertAtFirst(20);
        list.insertAtLast(30);
        list.insertAtPos(40, 3);
        list.insertAtPos(50, 5);

        System.out.println("Before Reversing: ");
        list.display();

        reverseList(list);
        System.out.println("After Reversing: ");
        list.display();
    }
}
