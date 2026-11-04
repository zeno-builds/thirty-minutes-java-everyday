package dsa.raw.linked_lists;

public class DLL {
    private Node head;

    public Node getHead(){
        return head;
    }

    public Node getTail(){
        if(head == null){
            return null;
        }

        Node curr = head;
        while(curr.next != null){
            curr = curr.next;
        }

        return curr;
    }

    //Insert at First
    public void insertAtFirst(int data){
        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }
    
    //Insert at Last
    public void insertAtLast(int data){
        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
            return;
        }

        Node curr = head;
        while(curr.next != null){
            curr = curr.next;
        }

        curr.next = newNode;
        newNode.prev = curr;
    }

    //Insert At Position
    public void insertAtPos(int data, int pos){
        if(pos < 1){
            System.out.println("Invalid Position");
            return;
        }

        if(pos == 1){
            insertAtFirst(data);
            return;
        }

        if(head == null){
            System.out.println("Invalid Position");
            return;
        }

        Node newNode = new Node(data);
        Node curr = head;
        int i = 1;
        while(i < pos-1 && curr.next != null){
            curr = curr.next;
            i++;
        }

        if(i < pos-1 || curr == null){
            System.out.println("Invalid Position");
            return;
        }

        newNode.next = curr.next;
        if(curr.next != null){
            curr.next.prev = newNode;
        }
        curr.next = newNode;
        newNode.prev = curr;
    }

    //Delete at First
    public void deleteAtFirst(){
        if(head == null){
            System.out.println("Doubly List is Empty");
            return;
        }

        head = head.next;
        if(head != null){
            head.prev = null;
        }
    }

    //Delete at Last
    public void deleteAtLast(){
        if(head == null){
            System.out.println("Doubly List is Empty");
            return;
        }

        if(head.next == null){
            head = null;
            return;
        }

        Node curr = head;
        while(curr.next.next != null){
            curr = curr.next;
        }

        curr.next.prev = null;
        curr.next = null;
    }

    //Delete at Position
    public void deleteAtPosition(int pos){
        if(pos < 1){
            System.out.println("Invalid Position");
            return;
        }

        if(pos == 1){
            deleteAtFirst();
            return;
        }

        if(head == null){
            System.out.println("Doubly List is Empty");
            return;
        }

        Node curr = head;
        int i = 1;
        while(i < pos-1 && curr != null){
            curr = curr.next;
            i++;
        }

        if(curr == null || curr.next == null){
            System.out.println("Invalid Position");
            return;
        }

        Node del = curr.next;
        curr.next = del.next;

        if(del.next != null){
            del.next.prev = curr;
        }
        del.prev = null;
        del.next = null;
    }

    //Display
    public void display(){
        if(head == null){
            System.out.println("Doubly List is Empty");
            return;
        }

        Node curr = head;

        System.out.print("Doubly Linked List: null<->");
        while(curr != null){
            System.out.printf("%d<->", curr.data);
            curr = curr.next;
        }

        System.out.println("null");
    }

    //Reverse Display
    public void reverseDisplay(){
        if(head == null){
            System.out.println("Doubly List is Empty");
            return;
        }

        Node curr = getTail();

        System.out.print("Doubly Linked List Reverse: null<->");
        while(curr != null){
            System.out.printf("%d<->", curr.data);
            curr = curr.prev;
        } 

        System.out.println("null");
    }

    public class Node{
        public int data;
        public Node next;
        public Node prev;
        
        public Node(int data){
            this.data = data;
        }
    }
}
