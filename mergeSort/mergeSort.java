package mergeSort;

public class mergeSort {
    public static void mergeSort(int[] arr){

    }

    private static void _mergeSort(int[] arr, int l, int r){
        if (l>=r){
            return;
        }
        int mid = (l+r)/2;
        _mergeSort(arr, l, mid);
        _mergeSort(arr, mid+1, r);

        if (arr[mid]>arr[mid+1]){
            _merge(arr, l, mid ,r);
        }
    }

    private static void _merge(int[] arr, int l, int mid, int r){
        int[] aux = new int[r-l+1];
        //左侧游标
        int i = l;
        //右侧游标
        int j = mid+1;

        // k为要在arr中放入元素的位置
        for (int k = l; k <= r; k++) {
            // 先判断特殊情况，一边已经快全部被拿走了，另一边还没动
            if (i > mid) {
                // 说明左边的元素排完了，只能用右边地了
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {
                // 右边元素已经排完了，只能用左边的了
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l]< aux[j - l]) {
                // 左半边 < 右半边
                arr[k] = aux[i - l];
                i++;
            } else {
                // 右半边 < 左半边
                arr[k] = aux[j - l];
                j++;
            }
        }

    }

    public static void sort(int [] arr) {
        int n = arr.length;
        // 左逼右闭区间
        _mergeSort(arr, 0, n-1);
    }

    public static void main(String[] args) {
        int[] arr = {3, 6, 8, 4, 2, 9, 10, 7, 1, 5, 9, 21, 13};
        sort(arr);
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
    }

}
