// Understanding Singly Linked Lists in Java

package linked_lists;


public class TestSLL{
    public static void main(String args[]){
        SLL list = new SLL();
        list.insertAtFirst(10);
        list.insertAtFirst(20);
        list.insertAtLast(30);
        list.insertAtPos(40, 3);
        list.insertAtPos(50, 5);
        list.display();

        list.deleteAtFirst();
        list.deleteAtLast();
        list.display();

        list.insertAtFirst(77);
        list.insertAtFirst(17);
        list.insertAtLast(70);
        list.display();
        
        list.deleteAtPos(1);
        list.deleteAtPos(5);
        list.deleteAtPos(3);
        list.display();
    }
}
