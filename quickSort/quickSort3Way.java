package quickSort;

import InsertSort.InsertSort;

public class quickSort3Way {
    //从0到n进行快速排序
    private static void _quickSort(int[] arr, int l, int r){
        if (l>=r){
            return;
        }
        if(r-l<=12){
            InsertSort.InsertSort(arr);
        }
        /**
         * 开始三路快速排序
         * lt 从 l开始，标识小于v的值最后一个位置
         * gt从r+1开始，标识于大于v的最后一个位置
         * i当前所指
         */
       int lt = l;
       int gt = r+1;
       int i = l+1;
       int v = arr[l];
       while (i<gt){
           if (arr[i]<v){
               swap(arr , i, lt+1);
               lt++;
               i++;
           }
           else if (arr[i]>v){
               swap(arr, i, gt-1);
               gt--;
           } else {
               i++;
           }

       }
       swap(arr, l , lt);


        _quickSort(arr, l, lt-1);
        _quickSort(arr, gt, r);

    }


    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void quickSort(int[] arr){
        int n = arr.length;
        _quickSort(arr, 0, n-1);
    }


    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int[] arr = {1,2,3,4,5,6,8,7,9};
        quickSort(arr);
        long endTime = System.nanoTime();
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println((endTime-startTime)/Math.pow(10,9)+"s");
    }
}
