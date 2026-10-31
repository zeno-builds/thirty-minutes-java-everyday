package linked_lists;

public class DLL {
    private Node head;
    private Node tail;

    //Insert at First
    public void insertAtFirst(int data){
        Node newNode = new Node(data);
        if(tail == null){
            head = tail = newNode;
        }else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        tail.next = head;
        head.prev = tail;
    }

    //Insert at Last
    public void insertAtLast(int data){
        Node newNode = new Node(data);
        if(tail == null){
            head = tail = newNode;
        }else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        head.prev = tail;
        tail.next = head;
    }

    //Insert at Position
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
        while(i < pos-1 && curr.next != head){
            curr = curr.next;
            i++;
        }

        if(i < pos-1){
            System.out.println("Invalid Position");
            return;
        }

        newNode.prev = curr;
        newNode.next = curr.next;
        curr.next.prev = newNode;
        curr.next = newNode;
        if(curr == tail){
            tail = newNode;
        }
    }

    //Display
    public void display(){
        if(head == null){
            System.out.println("Doubly Linked List is Empty");
            return;
        }

        Node curr = head;
        System.out.print("HEAD: ");
        do{
            System.out.print(curr.data+"->");
            curr = curr.next;
        }while(curr != head);

        System.out.println("HEAD");
    }
    
    public class Node{
        public int data;
        public Node next;
        public Node prev;

        //Constructor
        public Node(int data){
            this.data = data;
        }
    }
}
