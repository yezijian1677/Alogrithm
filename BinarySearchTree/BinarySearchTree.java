package BinarySearchTree;

public class BinarySearchTree<Key extends Comparable<Key>, Value> {
    /**
     * 节点
     */
    private class Node{
        Key key;
        Value value;

        Node left;

        Node rigth;

        Node(Key key, Value value){
            this.key = key;
            this.value = value;
            this.left = null;
            this.rigth = null;
        }

        Node(Node node) {
            // key是唯一地，不能重复
            this.key = node.key;
            this.value = node.value;
            this.left = node.left;
            this.rigth = node.rigth;
        }

    }

    /**
     * 根节点
     */
    private Node root;
    /**
     * 节点数
     */
    private int count;

    public BinarySearchTree(){
        root = null;
        count = 0;
    }

    public int getSize(){
        return count;
    }

    public boolean isEmpty(){
        return count==0;
    }

    public void insert(Key key, Value value){
        root = insert(root, key, value);
    }
    public boolean contain(Key key) {
        return contain(root, key);
    }
    public Value search(Key key) {
        return search(root, key);
    }

    private Node insert(Node node, Key key, Value value){
        if (node == null){
            count++;
            return new Node(key, value);
        }

        if (key.compareTo(node.key)<0){
            node.left = insert(node.left, key, value);
        }else if (key.compareTo(node.key)>0){
            node.rigth = insert(node.rigth, key, value);
        } else {
            node.value = value;
        }

        return node;
    }

    /**
     * 被递归调用来判断是否包含指定key的函数
     */
    private boolean contain(Node node, Key key) {
        // 递归退出条件.最后到达树底，下面没节点了(NULL),返回false
        if (node == null) {
            return false;
        }
        if (key.compareTo(node.key) > 0) {
            // 大于就在右边找
            return contain(node.rigth, key);
        } else if (key.compareTo(node.key) < 0) {
            // 小于就在左边找
            return contain(node.left, key);
        } else {
            // 等于就返回true,代表找到含有这个key地节点了
            return true;
        }
    }

    /**
     * 在以node为根的二叉搜索树种查找key对应的value
     */
    private Value search(Node node, Key key) {
        // 递归退出条件.最后到达树底，返回NULL
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) > 0) {
            // 大于就在右边找
            return search(node.rigth, key);
        } else if (key.compareTo(node.key) < 0) {
            // 小于就在左边找
            return search(node.left, key);
        } else {
            // 等于就返回true,代表找到含有这个key地节点了,返回Value的地址
            return node.value;
        }
    }




}
