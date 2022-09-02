/**--插入排序法--
 *  以節點形式
 *  插入一個值時從首節點開始做比對
 *  找到陣列中符合小->大的位置
 *  將新值插入
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
        while (tmpNode.getNextNode() != null) { //每次從首節點開始
            Node preNode = tmpNode;
            tmpNode = tmpNode.getNextNode();
            if (tmpNode.getData()>x){       //輸入的新節點數字較小則插入
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
