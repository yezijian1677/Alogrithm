package BinarySearch;

public class BinarySearch<T extends Comparable> {
    public T binarySearch(T arr[], int target){
        int len = arr.length;
        int l = 0;
        int r = len-1;

        while (l<=r){
            int mid = l+(r-l)/2;
            if (arr[mid].compareTo(target)==0){
                return arr[mid];
            }
            if (arr[mid].compareTo(target)>0){
                r = mid-1;
            }else {
                l = mid+1;
            }
        }
        return -1;
    }
}
