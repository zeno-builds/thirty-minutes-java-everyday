// Understanding Singly Linked Lists in Java

package linked_lists;

class SLL{
    //Instance Variables
    private Node head;
    private Node tail;

    //Insert at First
    public void insertAtFirst(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;

        if(tail == null){
            tail = head;
        }
    }

    //Insert at Last
    public void insertAtLast(int data){
        Node newNode = new Node(data);
        if(tail == null){
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    //Insert in Between
    public void insertAtPos(int data, int pos){
        Node newNode = new Node(data);

        if(pos < 1){
            System.out.println("Inavlid Index.");
            return;
        }

        if(pos == 1){
            if(head == null){
                head = tail = newNode;
            }else{
                newNode.next = head;
                head = newNode;

                if(tail == null){
                    tail = head;
                }
            }
            return;
        }

        if(head == null){
            System.out.println("Invalid Index.");
            return;
        } 

        Node curr = head;
        int i = 1;
        while(i < pos-1 && curr.next != null){
            curr = curr.next;
            i += 1;
        }

        if(i < pos-1){
            System.out.println("Invalid Index.");
            return;
        }

        newNode.next = curr.next;
        curr.next = newNode;

        if(curr == tail){
            tail = newNode;
        }
    }

    public void display(){
        Node curr = head;

        System.out.print("Linked List: ");
        while(curr != null){
            System.out.print(curr.data+"-> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    private class Node{
        private int data;
        private Node next;

        //Constructors
        Node(int data){
            this.data = data;
        }
    }
}

public class mySinglyLinkedList{
    public static void main(String args[]){
        SLL list = new SLL();
        list.insertAtFirst(10);
        list.insertAtFirst(20);
        list.insertAtLast(30);
        list.insertAtPos(40, 3);
        list.insertAtPos(50, 5);
        list.display();
    }
}
