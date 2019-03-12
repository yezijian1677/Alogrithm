package SelectionSort;

import java.lang.reflect.Method;

public class SortHelper {
    public SortHelper(){}

    public static Integer[] generateRandomArray(int n, int rangeL, int rangeR) {
        assert (rangeL < rangeR);

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * (rangeR - rangeL + 1) + rangeL);
        }
        return arr;
    }

    /**
     * 打印arr数组的全部内容
     */
    public static void printArray(Object[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /**
     * 测试sortClassName所对应的排序算法arr数组所得到结果的正确性和算法运行时间
     *
     * @param sortClassName 排序类的类名称，可使用反射获取这个类的实例
     * @param arr           待排序数组
     */
    public static void testSort(String sortClassName, Comparable[] arr) {
        try {
            // 通过Java的反射机制，通过排序的类名，运行排序函数
            Class sortClass = Class.forName(sortClassName);
            // 通过排序函数的Class对象获得排序方法.name表示排序类中的排序方法名。第二个参数表示sort函数的入参必须是可比较地
            Method sortMethod = sortClass.getMethod("sort", new Class[]{Comparable[].class});
            // 排序参数只有一个。是可比较数组arr
            Object[] params = new Object[]{arr};

            long startTime = System.currentTimeMillis();
            // 调用排序函数
            sortMethod.invoke(null, params);
            long endTime = System.currentTimeMillis();

            assert isSorted(arr);

            System.out.println(sortClass.getSimpleName() + " : " + (endTime - startTime) + "ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean isSorted(Comparable[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return  true;
    }
}
