package HeapSort;

import Heap.MaxHeap;
import SelectionSort.SortHelper;

public class HeapSort {
    /**
     * 插入式构造最大堆 复杂度为O(nlgn)
     * @param arr
     */
    public static void heapSort1(Comparable[] arr){
        int n = arr.length;
        MaxHeap<Comparable> maxHeap = new MaxHeap<>(n);
        for (int i = 0; i < n; i++){
            maxHeap.insert(arr[i]);
        }
        while (!maxHeap.isEmpty()){
            System.out.print(maxHeap.popMax()+" ");
        }
        System.out.println();
    }

    /**
     * 按照数组顺序输入，然后内部形成最大堆 构造最大堆的复杂度为O(n)
     * @param arr
     */
    public static void heapSort2(Comparable[] arr){
        MaxHeap<Comparable> maxHeap = new MaxHeap<>(arr);
        while (!maxHeap.isEmpty()){
            System.out.print(maxHeap.popMax()+" ");
        }
        System.out.println();
    }

    public static void main (String[] args){
        int n = 10;
        Integer[] arr = SortHelper.generateRandomArray(n, 0, n);
        long startTime = System.nanoTime();
        heapSort1(arr);

        heapSort2(arr);
        long endTime = System.nanoTime();
        System.out.println(endTime-startTime);
    }
}
