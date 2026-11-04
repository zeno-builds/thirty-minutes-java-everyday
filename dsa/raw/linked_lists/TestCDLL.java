package dsa.raw.linked_lists;

public class TestCDLL {
    public static void main(String args[]){
        CDLL list = new CDLL();

        list.insertAtFirst(10);
        list.insertAtFirst(20);
        list.insertAtLast(30);
        list.insertAtPos(40, 3);
        list.insertAtPos(50, 5);
        list.display();

    }
}
