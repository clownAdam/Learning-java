package cn.clown;

/**
 * 使用插入排序将 数组 arr 按照从小到大排序
 * @author clown
 */
public class Demo {
    public static void main(String[] args) {
        int[] arr = {2, 58, 1, 4, 69, 14, 23, 70};
        //排序前
        printArr(arr);
        //插入排序
        sort(arr);
        //排序后
        printArr(arr);
    }
    public static void printArr(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"\t");
        }
        System.out.println();
    }
    public static void sort(int[] arr){
        for(int i = 1 ; i < arr.length; i++){
            for(int j = i ; j > 0 && arr[j] < arr[j-1];j--){
                swap(arr,j,j-1);
            }
        }
    }
    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
