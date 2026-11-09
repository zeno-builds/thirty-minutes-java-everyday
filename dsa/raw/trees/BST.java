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
    
    //Search Function
    public int search(Node node, int key){
        if(node == null) return 0;
        if(node.data == key)  return 1;
        if(key < node.data) return search(node.left, key);
        else if(key > node.data) return search(node.right, key);
        return 0;
    }

    // Display Function
    public void inorder(Node root){
        if(root == null) return;

        inorder(root.left);
        System.out.printf("%d ", root.data);
        inorder(root.right);
    }

    //Preorder Function
    public void preorder(Node root){
        if(root == null) return;

        System.out.printf("%d ", root.data);
        inorder(root.left);
        inorder(root.right);
    }

    //Postorder Function
    public void postorder(Node root){
        if(root == null) return;

        postorder(root.left);
        postorder(root.right);
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
