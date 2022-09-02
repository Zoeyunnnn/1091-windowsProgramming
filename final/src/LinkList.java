public class LinkList {
    private Node startNode;

    public LinkList() {
        startNode = new Node();
    }

    //-----when add new Node-----//
    public void addNode(int x) {
        Node newNode = new Node(x);
        Node tmpNode = startNode;
        while (tmpNode.getNextNode() != null) {
            tmpNode = tmpNode.getNextNode();
        }
        tmpNode.setNextNode(newNode);
    }

    //-----when delete a Node-----//
    public void deleteNode(int x){
        Node newNode = new Node(x);
        Node tmpNode = startNode;
        while (tmpNode.getNextNode() != null){
            Node preNode = tmpNode;
            tmpNode = tmpNode.getNextNode();
            if (tmpNode.getData() == x){
                preNode.setNextNode(tmpNode.getNextNode());
            }
        }
    }

    //-----print string after info sorting-----//
    public String showList() {
        Node tmpNode = startNode;
        String outString = "";
        if (tmpNode == null) {
            return "Empty list";
        }else{
            outString = " "+Integer.toString(tmpNode.getData());
        }

        while (tmpNode.getNextNode() != null) {
            tmpNode = tmpNode.getNextNode();
            outString += " => " + Integer.toString(tmpNode.getData());
        }
        outString += " \n ";
        return outString;
    }
}
