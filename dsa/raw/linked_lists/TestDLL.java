package dsa.raw.linked_lists;

public class TestDLL {
    public static void main(String args[]){
        DLL list = new DLL();

        list.insertAtPos(80, 0);
        list.insertAtPos(80, 1);
        list.insertAtPos(70,  1);
        list.insertAtPos(77,  3);
        list.insertAtPos(97,  2);
        list.insertAtFirst(45);
        list.insertAtLast(55);

        list.display();

        
        list.deleteAtPosition(6);
        list.deleteAtFirst();
        list.deleteAtLast();

        list.display();
        list.reverseDisplay();
    }
}
