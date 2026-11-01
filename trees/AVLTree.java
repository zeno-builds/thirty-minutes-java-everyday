package trees;

public class AVLTree {
    private Node root;

    public Node getRoot(){
        return root;
    }

    //Insert
    //OOPs concept: Method overloading is spotted for insert function.
    public void insert(int data){
        root = insert(root, data);
    }


    public Node insert(Node parent, int data){
        if(parent == null){
            return new Node(data);
        }

        if(data < parent.data){
            parent.left = insert(parent.left, data);
        }else if(data > parent.data){
            parent.right = insert(parent.right, data);
        }else{
            return parent;
        }

        return isBalanced(parent);
    }

    //Is Balanced Function: Checks whether a tree is balanced or not, if its unbalanced, it balances it.
    public Node isBalanced(Node node){
        if(node == null) return null;

        int bf_node = balanceFactor(node);

        if(bf_node > 1){
            if(balanceFactor(node.left) >= 0){
                node = rightRotate(node);
            }else{
                node.left = leftRotate(node.left);
                node = rightRotate(node);
            }
        }else if(bf_node < -1){
            if(balanceFactor(node.right) <= 0){
                node = leftRotate(node);
            }else{
                node.right = rightRotate(node.right);
                node = leftRotate(node);
            }
        }

        return node;
    }

    //Balance Factor of the Tree : Left Height - Right Height => (Height(Left) + 1) - (Height(Right) + 1), As +1 get cancelled we negate them in actual implementation.
    public int balanceFactor(Node node){
        return height(node.left) - height(node.right);
    }

    //Height of the Tree
    public int height(Node node){
        if(node == null) return -1;

        int right_ht = height(node.right) + 1;
        int left_ht = height(node.left) + 1;

        if(right_ht > left_ht) return right_ht;
        else return left_ht;
    }

    //Rotations
    //Left Rotate (RR Case)
    public Node leftRotate(Node node){
        Node newRoot = node.right;
        node.right = newRoot.left;
        newRoot.left = node;

        return newRoot;
    }

    //Right Rotate (LL Case)
    public Node rightRotate(Node node){
        Node newRoot = node.left;
        node.left = newRoot.right;
        newRoot.right = node;

        return newRoot;
    }

    //Display Methods
    //Inorder: Left->Root->Right
    public void inorder(Node node){
        if(node == null){
            return;
        }

        inorder(node.left);
        System.out.printf("%d ", node.data);
        inorder(node.right);
    }

    //Postorder: Left->Right->Root
    public void postorder(Node node){
        if(node == null){
            return;
        }

        postorder(node.left);
        postorder(node.right);
        System.out.printf("%d ", node.data);
    }

    //Preorder: Root->Left->Right
    public void preorder(Node node){
        if(node == null){
            return;
        }

        System.out.printf("%d ", node.data);
        preorder(node.left);
        preorder(node.right);
    }

    public static class Node{
        public int data;
        public Node right;
        public Node left;

        public Node(int data){
            this.data = data;
        }
    }
}


/*
    MISTAKES:

    1. Weight of a Tree: It is essential when we have conflicts of 2 rotations and want to choose between them.
    Conflict: The one with the more weight is rotated.
    public int weight(Node node){
        if(node == null) return 0;

        return 1 + weight(node.right) + weight(node.left);
    }

    Inside isBalanced function: 

    int wt_left = weight(node.left);
    int wt_right = weight(node.right);

    // if(bf_node > 1 && (wt_left > wt_right)){
        //     node = rightRotate(node);
        // }else if(bf_node > 1 && (wt_left < wt_right)){
        //     node.left = leftRotate(node.left);
        //     node = rightRotate(node);
        // }else if(bf_node < -1 && (wt_right > wt_left)){
        //     node = leftRotate(node);
        // }else if(bf_node < -1 && (wt_right < wt_left)){
        //     node.right = rightRotate(node.right);
        //     node = leftRotate(node);
        // }

    So my implementation were based on weights, but that was a wrong approach, Go through the readme file AVLTree.readme to understand more on this. 


    2. Improved my balanced function to nodewise instead of entire tree(rootwise).
    //Is Balanced Function: Checks whether a tree is balanced or not, if its unbalanced, it balances it.
    public void isBalanced(Node node){
        int bf_node = balanceFactor(node);

        if(bf_node > 1){
            if(balanceFactor(node.left) >= 0){
                node = rightRotate(node);
            }else{
                node.left = leftRotate(node.left);
                node = rightRotate(node);
            }
        }else if(bf_node < 1){
            if(balanceFactor(node.right) <= 0){
                node = leftRotate(node);
            }else{
                node.right = rightRotate(node.right);
                node = leftRotate(node);
            }
        }

        isBalanced(node.right);
        isBalanced(node.left);
    }

    Again, more on the readme file, to understand what my thought process was and why it went wrong.

*/