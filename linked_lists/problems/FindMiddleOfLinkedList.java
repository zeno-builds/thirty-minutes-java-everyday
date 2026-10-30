package linked_lists.problems;
import linked_lists.SLL;

public class FindMiddleOfLinkedList {
    public static SLL.Node findMiddle(SLL list){
        SLL.Node slow = list.getHead();
        SLL.Node fast = list.getHead();

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
    public static void main(String args[]){
        SLL list = new SLL();

        list.insertAtFirst(10);
        list.insertAtFirst(20);
        list.insertAtLast(30);
        list.insertAtPos(40, 3);
        list.insertAtPos(50, 5);
        list.display();

        SLL.Node middle = findMiddle(list);
        System.out.println("Middle Node: "+middle.data);
    }
}
