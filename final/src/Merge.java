/**--合併排序法--
 *  將輸入的陣列大致對半分成兩個陣列
 *  再將分出的陣列各自再分成兩個
 *  如此往復，至不能分的時候開始比對大小做排序
 * ----**/
public class Merge {
    private int[] Array;

    public Merge(){

    }
    public void mergeSort(int[] arr){
        Array = new int[arr.length];
        mergeSort(arr, 0, arr.length-1);
    }
    /**將每一次傳入的陣列再分成兩個陣列**/
    public void mergeSort(int[] arr, int low, int high) {     //呼叫mergeSort方法時low為0, high為a.length-1
        int mid = (low + high) / 2;
        if (low <= mid && mid <= high) {       //分割為兩個陣列
            if(mid-low != 0 || high-mid != 0){
                mergeSort(arr, low, mid);
                mergeSort(arr, mid + 1, high);
                merge(arr, low, mid, high);
            }
        }
    }
    /**將陣列內的數字排序**/
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
