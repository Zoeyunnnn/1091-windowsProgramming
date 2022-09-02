import java.util.ArrayList;

public class BinaryTree {
    private Node root;
    private static int i = 0;
    private static ArrayList list = new ArrayList();

    public BinaryTree(int[] a){
        this.root = add(a);
    }

    private Node add(int[] a){
        Node tmpNode;
        int data = a[i];
        i++;
        list.add(data);
        tmpNode = new Node(data);
        tmpNode.left = add(a);
        tmpNode.right = add(a);
        return tmpNode;
    }

    public void preOrder(Node n){   //¤¤->¥ª->¥k
        if (n != null) {
            preOrder(n.left);
            preOrder(n.right);
        }
    }
    public void postOrder(Node n) {     //¥ª->¥k->¤¤
        if (n!=null) {
            postOrder(n.left);
            postOrder(n.right);
        }
    }
    public void inOrder(Node n) {       //¥ª->¤¤->¥k
        if (n != null) {
            inOrder(n.left);
            inOrder(n.right);
        }
    }
}
