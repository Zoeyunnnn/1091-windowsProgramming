/**--選擇排序法--
 *  輸入一個陣列，找到最小值放到第一個位置
 *  再從剩下的值內再找出最小，放到第二個位置
 *  如此往復
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
    public int findMin(int[] x, int i){     //從剩餘未排序的值裡找到最小
        int j, min=i;
        for(j=i+1; j<x.length; j++){
            if (x[j]<x[min]) min=j;
        }
        return min;
    }
    public void swap(int[] x, int i, int j){    //將本次排序的(不包含已經排序過的值)最小移動到前面
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
