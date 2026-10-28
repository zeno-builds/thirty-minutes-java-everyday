// Understanding Singly Linked Lists in Java

class SLL{
    private Node head;
    private Node tail;

    private int size;

    public SLL(){
        this.size = 0;
    }

    // Insert At Beginning
    public void insertAtFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;

        if(tail == null){
            tail = head;
        }

        size += 1;
    }

    //Display Function
    public void display(){
        Node temp = head;

        while(temp != null){
            System.out.print(temp.val + "-> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    private class Node{
        private int val;
        private Node next;

        public Node(int val){
            this.val = val;
        }

        public Node(int val, Node next){
            this.val = val;
            this.next = next;
        }
    }
}

public class mySinglyLinkedList{
    public static void main(String args[]){
        SLL list = new SLL();
        list.insertAtFirst(10);
        list.insertAtFirst(20);
        list.insertAtFirst(30);
        list.insertAtFirst(40);
        list.insertAtFirst(50);
        list.display();
    }
}
