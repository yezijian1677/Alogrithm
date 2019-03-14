package quickSort;

public class quickSortNearlyOrder {
    //从0到n进行快速排序
    private static void _quickSort(int[] arr, int l, int r){
        if (l>=r){
            return;
        }
        int partial = partial(arr, l, r);
        _quickSort(arr, l, partial-1);
        _quickSort(arr, partial+1, r);

    }

    private static int partial(int[] arr, int l, int r){
        swap(arr, l , (int)Math.random()*(r-l+1)+l);
        //让第一个元素作为参照
        int v = arr[l];
        //设置j从l开始
        int j = l;
        //从l+1开始遍历
        for (int i = l+1; i <= r; i++){
            //如果参照的值大于现在指的值，就把当前值和j后面大于v的值交换，并且j++
            if (v>arr[i]){
                swap(arr, j+1, i);
                j++;
            }
        }
        //最后交换头和j所在的位置
        swap(arr, l ,j);

        return j;
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
        System.out.println(endTime-startTime);
    }
}
