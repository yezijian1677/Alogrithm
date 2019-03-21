package IndexMaxHeap;

public class IndexMaxHeap<Item extends Comparable> {
    //data
    protected Item[] data;
    //index of array
    protected int[] indexes;
    //data nums
    protected int count;
    //data size
    protected int capacity;


    IndexMaxHeap(int capacity){
        data = (Item[])new Comparable[capacity+1];
        indexes = new int[capacity+1];
        count = 0;
        this.capacity = capacity;
    }

    public int getSize(){
        return count;
    }

    public boolean isEmpty(){
        return count==0;
    }

    //Insert into IndexMaxHeap a new data, index = i, val = item
    public void insert(Item item, int i){
        assert (count+1<=capacity);

        assert (i+1>=1&&i+1<=capacity);

        i+=1;

        data[i] = item;
        indexes[++count] = i;
        shiftUp(count);
    }

    Item popMax(){
        assert (count>0);
        Item max = data[indexes[1]];
        swapIndexes(1, count);
        count--;
        shiftDown(1);
        return max;
    }

    int popMaxIndex(){
        assert (count>0);
        int maxIndex = indexes[1];
        swapIndexes(1, count);
        count--;
        shiftDown(1);
        return maxIndex-1;
    }

    public Item getMax(){
        assert (count>0);
        return data[indexes[1]];
    }

    public int getMaxIndex(){
        assert (count>0);
        return indexes[1];
    }

    public void update(int i, Item newItem){
        i++;
        data[i]=newItem;
        for (int j = 1; j<=count; j++){
            if (indexes[j]==i){
                shiftUp(j);
                shiftDown(j);
                return;
            }
        }
    }


    private void swapIndexes(int i, int j){
        int t = indexes[i];
        indexes[i] = indexes[j];
        indexes[j] = t;
    }
    private void shiftUp(int k){
        while (k>1 && data[indexes[k/2]].compareTo(data[indexes[k]])>0){
            swapIndexes(k/2, k);
            k/=2;
        }
    }

    private void shiftDown(int k){
        while (2*k<=count){
            int j = 2*k;
            if (j+1<=count&&data[indexes[j+1]].compareTo(data[indexes[j]])>0){
                j++;
            }
            if (data[indexes[k]].compareTo(data[indexes[j]])>=0){
                break;
            }
            swapIndexes(k ,j);

            k = j;
        }
    }
}
