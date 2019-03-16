package HeapSort;

public class HeapSortPro {
    /**
     * 原地堆排序
     */
    public static void heapSort(Comparable[] arr){
        int n = arr.length;
        //先把堆进行最大堆化
        for (int i = (n-1)/2; i >= 0; i--){
            shiftDown(arr, n ,i);
        }

        for (int i = n-1; i>0; i--){
            //把最大的元素放到末尾，然后对0到i-1进行最大堆处理
            swap(arr, 0, i);
            //把上一步移动到0位置的元素进行最大堆处理
            shiftDown(arr ,i ,0);

        }
    }

    /**
     *
     * @param arr
     * @param n 元素个数
     * @param k 当前节点
     */
    private static void shiftDown(Comparable[] arr, int n, int k){
        //从零开始构造
        while (2*k+1<n){
            //左孩子
            int j = 2*k+1;
            //如果j+1不大于元素个数，代表有右孩子，且右孩子比左孩子大
            if(j+1<n && arr[j+1].compareTo(arr[j])>0){
                //选择右孩子为节点和父节点交换
                j++;
            }
            //父节点比孩子节点大,则不交换
            if (arr[k].compareTo(arr[j])>=0){
                break;
            }
            //交换
            swap(arr, k ,j);
            //把换后的子节点作为父节点继续验证
            k = j;
        }
    }

    private static void swap(Comparable[] arr, int j, int k){
        Comparable temp = arr[j];
        arr[j] = arr[k];
        arr[k] = arr[j];
    }
}
