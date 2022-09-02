/**--���J�ƧǪk--
 *  �H�`�I�Φ�
 *  ���J�@�ӭȮɱq���`�I�}�l�����
 *  ���}�C���ŦX�p->�j����m
 *  �N�s�ȴ��J
 * ----**/
public class Insertion {
    private Node startNode;

    public Insertion(){
        startNode = new Node();
    }

    //-----when add new Node-----//
    public void addNode(int x){
        Node newNode = new Node(x);
        Node tmpNode = startNode;
        boolean flag = true;
        while (tmpNode.getNextNode() != null) { //�C���q���`�I�}�l
            Node preNode = tmpNode;
            tmpNode = tmpNode.getNextNode();
            if (tmpNode.getData()>x){       //��J���s�`�I�Ʀr���p�h���J
                newNode.setNextNode(tmpNode);
                preNode.setNextNode(newNode);
                flag = false;
                break;
            }
        }
        if (flag)  tmpNode.setNextNode(newNode);
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
}
