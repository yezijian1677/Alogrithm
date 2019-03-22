package IndexMaxHeap;

public class IndexMaxHeapOpt<Item extends Comparable> {
    //data
    protected Item[] data;
    //index of array
    protected int[] indexes;
    //reverse of index
    protected int[] rev;
    //data nums
    protected int count;
    //data size
    protected int capacity;


    IndexMaxHeapOpt(int capacity){
        data = (Item[])new Comparable[capacity+1];
        indexes = new int[capacity+1];
        rev = new int[capacity+1];
        count = 0;
        for (int i = 0; i <= capacity; i++) {
            rev[i] = 0;
        }
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
        count++;

        indexes[count] = i;
        rev[i] = count;

        shiftUp(count);
    }

    Item popMax(){
        assert (count>0);
        Item max = data[indexes[1]];
        swapIndexes(1, count);
        // 这个元素相当于删除了，所以指向0，因为各个数组的下标都是从0开始地
        rev[indexes[count]] = 0;
        count--;
        shiftDown(1);
        return max;
    }

    int popMaxIndex(){
        assert (count>0);
        int maxIndex = indexes[1];
        swapIndexes(1, count);
        rev[indexes[count]] = 0;
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
        // 有了reverses之后更新数据就方便多了
        int j = rev[i];
        shiftUp(j);
        shiftDown(j);
    }


    private void swapIndexes(int i, int j){
        int t = indexes[i];
        indexes[i] = indexes[j];
        indexes[j] = t;

        rev[indexes[i]] = i;
        rev[indexes[j]] = j;
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
