/**--��ܱƧǪk--
 *  ��J�@�Ӱ}�C�A���̤p�ȩ��Ĥ@�Ӧ�m
 *  �A�q�ѤU���Ȥ��A��X�̤p�A���ĤG�Ӧ�m
 *  �p�����_
 * ----**/
public class Selection {
    private int[] arr;
    public Selection(){

    }

    public void Selectsort(int[] x) {
        int i;
        for (i=0;i<x.length-1;i++){
            int min = findMin(x,i);
            swap(x,i,min);
        }
        arr = new int[x.length];
        arr = x;
    }
    public int findMin(int[] x, int i){     //�q�Ѿl���ƧǪ��ȸ̧��̤p
        int j, min=i;
        for(j=i+1; j<x.length; j++){
            if (x[j]<x[min]) min=j;
        }
        return min;
    }
    public void swap(int[] x, int i, int j){    //�N�����ƧǪ�(���]�t�w�g�ƧǹL����)�̤p���ʨ�e��
        int tmp = x[i];
        x[i] = x[j];
        x[j] = tmp;
    }
    public String showList(){
        String outString="";
        for (int i=0;i<arr.length;i++){
            outString += i+"-> [ " + Integer.toString(arr[i])+" ]\n";
        }
        return outString;
    }
}
