package HeapSort;

import Heap.MaxHeap;
import SelectionSort.SortHelper;

public class HeapSort {
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

    public static void main (String[] args){
        int n = 10;
        Integer[] arr = SortHelper.generateRandomArray(n, 0, n);
        long startTime = System.nanoTime();
        heapSort1(arr);
        long endTime = System.nanoTime();
        System.out.println(endTime-startTime);
    }
}
