package quickSort;

public class quickSortRepeat {
    //从0到n进行快速排序
    private static void _quickSort(int[] arr, int l, int r){
        if (l>=r){
            return;
        }
        int partial = partial(arr, l, r);
        _quickSort(arr, l, partial-1);
        _quickSort(arr, partial+1, r);

    }

    /**
     * 双路法解决重复序列的排序
     * i指向小于元素v的下一个值
     * j指向大于v元素的上一个值
     * @param arr
     * @param l
     * @param r
     * @return
     */
    private static int partial(int[] arr, int l, int r){
        swap(arr, l , (int)Math.random()*(r-l+1)+l);
        //让第一个元素作为参照
        int v = arr[l];
        //设置j从l开始
        int i = l+1;
        int j = r;

        while (true){
            while (i<=r&&arr[i]<v){
                i++;
            }
            while (j>=l&&arr[j]>v){
                j--;
            }
           if (i>j){
               break;
           }
           swap(arr, i, j);
           i++;
           j--;
        }
        swap(arr, l, j);

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
        System.out.println((endTime-startTime)/Math.pow(10,9)+"s");
    }
}
