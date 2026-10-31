package linked_lists;

public class TestDLL {
    public static void main(String args[]){
        DLL list = new DLL();

        list.insertAtFirst(10);
        list.insertAtFirst(20);
        list.insertAtLast(30);
        list.insertAtPos(40, 3);
        list.insertAtPos(50, 5);
        list.display();

    }
}
