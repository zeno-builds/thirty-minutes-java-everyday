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

    //Insert at Position
    public void insertAtPos(int data, int pos){
        Node newNode = new Node(data);

        if(pos < 1){
            System.out.println("Inavlid Position");
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
            System.out.println("Invalid Position");
            return;
        } 

        Node curr = head;
        int i = 1;
        while(i < pos-1 && curr.next != null){
            curr = curr.next;
            i++;
        }

        if(i < pos-1){
            System.out.println("Invalid Position");
            return;
        }

        newNode.next = curr.next;
        curr.next = newNode;

        if(curr == tail){
            tail = newNode;
        }
    }

    //Delete at First
    public void deleteAtFirst(){
        if(head == null){
            System.out.println("Linked List is Empty");
            return;
        } 

        if(head == tail){
            head = tail = null;
            return;
        }

        Node temp = head;
        head = head.next;
        temp.next = null;
        temp = null;
    }

    //Delete at Last 
    public void deleteAtLast(){
        if(head == null){
            System.out.println("Linked List is Empty");
            return;
        } 

        if(head == tail){
            head = tail = null;
            return;
        }

        Node curr = head;
        while(curr.next != tail){
            curr = curr.next;
        }

        tail = curr;
        curr.next = null;
    }

    //Delete at Position
    public void deleteAtPos(int pos){
        if(pos < 1){
            System.out.println("Invalid Position");
            return;
        }


        if(head == null){
            System.out.println("Linked List is Empty");
            return;
        }

        if(pos == 1){
            if(head == tail){
                head = tail = null;
            }else{
                Node temp = head;
                head = head.next;
                temp.next = null;
                temp = null;
            }
            return;
        }

        Node curr = head;
        int i = 1;
        while(i < pos-1 && curr.next != null){ //or curr != tail
            curr = curr.next;
            i++;
        }

        if(i < pos-1 || curr.next == null){
            System.out.println("Invalid Position");
            return;
        }

        Node del = curr.next;
        if(tail == del){
            tail = curr;
        }
        curr.next = del.next;
        del.next = null;
        del = null;
    }

    //Display
    public void display(){
        if(head == null){
            System.out.println("Linked List is Empty");
            return;
        } 

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

public class MySinglyLinkedList{
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
