/**--�X�ֱƧǪk--
 *  �N��J���}�C�j�P��b������Ӱ}�C
 *  �A�N���X���}�C�U�ۦA�������
 *  �p�����_�A�ܤ�������ɭԶ}�l���j�p���Ƨ�
 * ----**/
public class Merge {
    private int[] Array;

    public Merge(){

    }
    public void mergeSort(int[] arr){
        Array = new int[arr.length];
        mergeSort(arr, 0, arr.length-1);
    }
    /**�N�C�@���ǤJ���}�C�A������Ӱ}�C**/
    public void mergeSort(int[] arr, int low, int high) {     //�I�smergeSort��k��low��0, high��a.length-1
        int mid = (low + high) / 2;
        if (low <= mid && mid <= high) {       //���ά���Ӱ}�C
            if(mid-low != 0 || high-mid != 0){
                mergeSort(arr, low, mid);
                mergeSort(arr, mid + 1, high);
                merge(arr, low, mid, high);
            }
        }
    }
    /**�N�}�C�����Ʀr�Ƨ�**/
    public void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0,index=0;
        while (temp.length != 0 && k<temp.length) {
            if (i <= mid && j<= high){
                if (a[i] < a[j])   temp[k++] = a[i++];
                else   temp[k++] = a[j++];
            }else if (i > mid) {
                temp[k++] = a[j++];
            }else if (j > high) {
                temp[k++] = a[i++];
            }
        }
        for (int m=low; m <= high; m++) {
            a[m] = temp[index];
            index++;
        }
        Array = a;
    }

    public String showList(){
        String outString="";
        for (int i=0;i<Array.length;i++){
            outString += i+"-> [ " + Integer.toString(Array[i])+" ]\n";
        }
        return outString;
    }
}
