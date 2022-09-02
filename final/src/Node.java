public class Node {
    private int data;
    private Node nextNode;
    Node left,right;    //to BinaryTree.java

    public Node() {

    }

    public Node(int x) {
        data = x;
        left = null;
        right = null;
    }

    public void setNextNode(Node newNode) {     //���]�U�@�Ӹ`�I
        nextNode = newNode;
    }

    public void setData(int x){     //���]�Ӹ`�I����
        this.data = x;
    }

    public int getData() {  //���o�Ӹ`�I����
        return data;
    }

    public Node getNextNode() {     //���o�U�@�Ӹ`�I
        return nextNode;
    }
}