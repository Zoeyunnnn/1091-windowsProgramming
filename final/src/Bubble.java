/**--��w�ƧǪk--
 *  �H�`�I�Φ��A�q�Ĥ@�Ӹ`�I�ȶ}�l
 *  ������j�p�A�N���p�����ܫe��
 *  �p�����_
 * ----**/
public class Bubble {
    private Node startNode;
    static int count=0;

    public Bubble(){
        startNode = new Node();
    }

    //-----when add new Node-----//
    public void addNode(int x){
        Node newNode = new Node(x);
        Node tmpNode = startNode;
        if(tmpNode.getData()>x){
            newNode.setNextNode(startNode);
            startNode = newNode;
            count++;
        }else {
            boolean flag = true;
            while (tmpNode.getNextNode() != null) {
                Node preNode = tmpNode;
                tmpNode = tmpNode.getNextNode();
                if(tmpNode.getData()>x){       //��w�ƧǪk����
                    newNode.setNextNode(tmpNode);
                    preNode.setNextNode(newNode);
                    count++;
                    flag = false;
                    break;
                }
                count++;
            }
            if (flag)  tmpNode.setNextNode(newNode);
        }
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
        Node tmpNode = startNode.getNextNode();
        int i=0;
        String outString = i+"-> [";
        if (tmpNode == null) {
            return "Empty list";
        }else{
            outString += Integer.toString(tmpNode.getData());
            i++;
        }
        while (tmpNode.getNextNode() != null) {
            tmpNode = tmpNode.getNextNode();
            outString += "]\n"+i+"-> [" + Integer.toString(tmpNode.getData());
            i++;
        }
        outString += "]\n ";
        return outString;
    }
    public int showcount(){
        return count;
    }
}
