package dsa.raw.trees;

public class BST {
    private Node root;

    // Get Root Function
    public Node getRoot(){
        return root;
    }

    // Insert Function 
    public void insert(int data){
        root = insert(root, data);
    }

    public Node insert(Node root, int data){
        if(root == null) return new Node(data);

        if(data < root.data){
            root.left = insert(root.left, data);
        }else{
            root.right = insert(root.right, data);
        }

        return root;
    }   

    // Display Function
    public void inorder(Node root){
        if(root == null) return;

        inorder(root.left);
        inorder(root.right);
        System.out.printf("%d ", root.data);
    }

    public static class Node{
        public int data;
        public Node right;
        public Node left;

        //Constructor
        public Node(int data){
            this.data = data;
        }
    }
}
