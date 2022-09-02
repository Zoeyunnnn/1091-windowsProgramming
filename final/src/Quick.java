/**--�ֳt�ƧǪk--
 * ��J�}�C
 * ��ܤ@�Ӱ���I(�o�̨ϥβĤ@�ӭ�)
 * �N�Ѿl�ȻP����I��j�p�������Ӱ}�C
 * ���۹���n����Ӱ}�C�A���@���p�W��k
 * --**/
public class Quick {
    private int[] Array;

    public Quick(){

    }

    /**�Ĥ@����J**/
    public void quicksort(int[] arr){
        Array = new int[arr.length];
        quicksort(arr, 0, arr.length-1);
    }

    /**�ֳt�ƧǪk�����j��k**/
    public void quicksort(int[] arr, int left, int right){
        if (left > right) return;   //�T�O���䥲�p��k��

        int i=left,j=right,key=arr[left];   //i:���}�C�_�l�Aj:�k�}�C�_�l�Akey:����I
        while (i != j){
            while (arr[j] > key && i<j) j--;    //�b�k�}�C��������I�p����
            while (arr[i] <= key && i<j) i++;   //�b���}�C��������I�j����
            if (i < j){     //�p�G���k���ȥ����۹J�A�h�N����A�洫
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        arr[left] = arr[i];
        arr[i] = key;

        quicksort(arr, left, i-1);  //�~��B�z���}�C
        quicksort(arr, i+1, right);     //�~��B�z�k�}�C

        Array = arr;
    }

    public String showList(){
        String outString="";
        for (int i=0;i<Array.length;i++){
            outString += i+"-> [ " + Integer.toString(Array[i])+" ]\n";
        }
        return outString;
    }
}
