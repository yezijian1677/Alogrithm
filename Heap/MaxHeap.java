package Heap;

public class MaxHeap<Item extends Comparable> {

    /**
     * 最大堆中的数据
     */
    protected Item[] data;

    /**
     * 元素的数量
     */
    protected int count;

    /**
     * 最大堆的容量
     */
    protected int capacity;

    public MaxHeap(int capacity) {
        // 不能直接声明泛型数组，只能先声明再强制转换
        this.data = (Item[]) new Comparable[capacity];
        count = 0;
        this.capacity = capacity;
    }

    /**
     * 返回堆中元素个数
     * @return
     */
    public int getSize(){
        return count;
    }

    /**
     * 堆是否为空
     */
    public boolean isEmpty() {
        return count == 0;
    }


    /**
     * 交换堆中索引为i和j的两个元素
     */
    private void swap(int i, int j) {
        Item t = data[i];
        data[i] = data[j];
        data[j] = t;
    }


    /**
     * 向上调整最大堆
     * @param k
     */
    private void shiftUp(int k){
        /**
         * 找到k索引的父索引 并且比较大小，如果k索引的值大于父索引，交换位置
         */
        while (k>1&&data[k/2].compareTo(data[k])<0){
            swap(k/2, k);
            //再往上层遍历
            k/=2;
        }
    }

    /**
     * 向下调整最大堆
     * 把移上来的最后一个元素下移到合适位置
     */
    private void shiftDown(int k){
        // 当当前k节点有子节点的时候(有左孩子不一定有右孩子，但有右孩子一定有左孩子。因为生成堆得时候是从左向右地)
        // 等于号别漏
        while (2*k<=count){
            //获取孩子下标
            int j =2*k;

            // 存在右孩子并且右孩子大于左孩子，那么右孩子有父节点交换

            if (j+1<=count && data[j+1].compareTo(data[j])>0){
                j++;
            }
            // 父节点比两个子节点的较大值还大，那么不需要交换
            if (data[k].compareTo(data[j]) >= 0) {
                break;
            }
            // 父节点小于孩子节点的较大值，那么就和较大值的子节点交换
            swap(k, j);
            // 把换后的子节点作为父节点，接着往下走
            k = j;

        }
    }

    /**
     * 插入元素
     */
    public void insert(Item item) {
        // 防止后面的++count越界
        assert (count + 1 <= capacity);
        // 插入新元素，元素数加1,之所以用++count而不用count++是因为数组下标从1开始
        data[++count] = item;
        // 把新加入的元素向上浮动到合适位置
        shiftUp(count);
    }

    /**
     * 弹出最大值(根节点的对象)
     */
    public Item popMax() {
        // 保证堆不为空
        assert (count > 0);
        // 最大元素为第一个元素
        Item max = data[1];
        // 移出最大元素后，需要把最下面的元素移到上面去
        swap(1, count);
        // 少了最后一个元素
        count--;
        // 将换上去(到最上面了,根元素，下标为1)的最后一个元素下移
        shiftDown(1);
        return max;
    }

    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<>(10);
        for (int i = 0; i < 9; i++) {
            maxHeap.insert((int) (Math.random() * i));
        }
        System.out.println(maxHeap.getSize());
        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.popMax() + " ");
        }
        System.out.println();
    }



}
