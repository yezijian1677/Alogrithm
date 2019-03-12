package InsertSort;

public class InsertSort {
    public static void InsertSort(int[] arr){
        int len = arr.length;
        for (int i = 1; i < len; i++){
            for (int j = i; j >0 ; j--){
                if (arr[j]<arr[j-1]){
                    swap(arr, j, j-1);
                } else {
                    break;
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 6, 8, 4, 2, 9, 10, 7, 1, 5, 9, 21, 13};
        InsertSort(arr);
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
