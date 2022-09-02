/**--快速排序法--
 * 輸入陣列
 * 選擇一個基準點(這裡使用第一個值)
 * 將剩餘值與基準點比大小後分成兩個陣列
 * 接著對分好的兩個陣列再做一次如上方法
 * --**/
public class Quick {
    private int[] Array;

    public Quick(){

    }

    /**第一次輸入**/
    public void quicksort(int[] arr){
        Array = new int[arr.length];
        quicksort(arr, 0, arr.length-1);
    }

    /**快速排序法的遞迴方法**/
    public void quicksort(int[] arr, int left, int right){
        if (left > right) return;   //確保左邊必小於右邊

        int i=left,j=right,key=arr[left];   //i:左陣列起始，j:右陣列起始，key:基準點
        while (i != j){
            while (arr[j] > key && i<j) j--;    //在右陣列內找比基準點小的值
            while (arr[i] <= key && i<j) i++;   //在左陣列內找比基準點大的值
            if (i < j){     //如果左右之值未曾相遇，則代表找到，交換
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        arr[left] = arr[i];
        arr[i] = key;

        quicksort(arr, left, i-1);  //繼續處理左陣列
        quicksort(arr, i+1, right);     //繼續處理右陣列

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
