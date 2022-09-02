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

    public void setNextNode(Node newNode) {     //重設下一個節點
        nextNode = newNode;
    }

    public void setData(int x){     //重設該節點的值
        this.data = x;
    }

    public int getData() {  //取得該節點的值
        return data;
    }

    public Node getNextNode() {     //取得下一個節點
        return nextNode;
    }
}