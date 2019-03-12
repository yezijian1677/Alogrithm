package SelectionSort;

public class SelectionSort {
    /**
     * 选择排序， 每次选择最小的一个与未排序的第一个交换
     * @param arr
     */
    public static void selectSort(int[] arr){
        int len = arr.length;
        for (int i = 0; i < len; i++){
            int minIndex = i;
            for (int j = i+1; j < len; j++){
                if (arr[j]<arr[minIndex]){
                   minIndex = j;
                }
            }
            swap(arr , i ,minIndex);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 6, 8, 4, 2, 9, 10, 7, 1, 5};
        selectSort(arr);
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
