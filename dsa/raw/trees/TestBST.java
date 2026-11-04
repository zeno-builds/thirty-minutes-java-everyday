package dsa.raw.trees;

public class TestBST {
    public static void main(String args[]){
        BST tree = new BST();
        
        tree.insert(50);
        tree.insert(20);
        tree.insert(40);
        tree.insert(10);
        tree.insert(30);

        tree.inorder(tree.getRoot());
    }
}
