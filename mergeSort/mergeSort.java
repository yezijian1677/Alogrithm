package mergeSort;

import java.util.Arrays;

public class mergeSort {
    public mergeSort(){

    }

    private static void merge(Comparable[] arr, int left, int middle, int right) {
        // 声明辅助数组,注意copyOfRange是左闭右开区间
        Comparable[] aux = Arrays.copyOfRange(arr, left, right + 1);
        // 开始合并
        // 左侧游标
        int i = left;
        // 右侧游标
        int j = middle + 1;
        // k为要在arr中放入元素的位置
        for (int k = left; k <= right; k++) {
            // 先判断特殊情况，一边已经快全部被拿走了，另一边还没动
            if (i > middle) {
                // 说明左边的元素排完了，只能用右边地了
                arr[k] = aux[j - left];
                j++;
            } else if (j > right) {
                // 右边元素已经排完了，只能用左边的了
                arr[k] = aux[i - left];
                i++;
            } else if (aux[i - left].compareTo(aux[j - left]) < 0) {
                // 左半边 < 右半边
                arr[k] = aux[i - left];
                i++;
            } else {
                // 右半边 < 左半边
                arr[k] = aux[j - left];
                j++;
            }
        }

    }



    private static void _merge(Comparable[] arr, int l, int r){
        if (l >= r) {
            return;
        }

        int mid = (l+r)/2;

        _merge(arr, l, mid);
        _merge(arr, mid+1, r);

        if (arr[mid].compareTo(arr[mid+1])>0){
            merge(arr, l, mid, r);
        }
    }

    public static void mergeSort(Comparable[] arr){
        int len = arr.length;
        _merge(arr, 0, len-1);
    }

    public static void main(String[] args) {
        Comparable[] arr = {8,7,6,1,2,4,5,3,9};
        mergeSort(arr);
        for (Comparable i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
    }


}
