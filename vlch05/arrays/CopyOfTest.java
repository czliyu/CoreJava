package arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CopyOfTest {

    public static void main(String[] args) {
        int[] a = { 1, 2, 3};
        a = (int[]) goodCopyOf(a, 10); 
        System.out.println(Arrays.toString(a));

        String[] b = { "Tom", "Dick", "Harry" };
        b = (String[]) goodCopyOf(b, 10);
        System.out.println(Arrays.toString(b));

        System.out.println("The following call will generate an expection");
        b = (String[]) badCopyOf(b, 10);
    }

    /**
     * 
     * @param a
     * @param newLength
     * @return
     */
    public static Object[] badCopyOf(Object[] a, int newLength) {
        var newArray = new Object[newLength];

        System.arraycopy(a, 0, newArray, 0, Math.min(a.length, newLength));
        return newArray;
    }

    /**
     * 1、首先获得a数组的类对象
     * 2、确认它确实是一个数组
     * 3、使用Class类的getComponentType是Class的方法
     * @param a
     * @param newLength
     * @return
     */
    public static Object goodCopyOf(Object a, int newLength) {
        Class cl = a.getClass();
        if (!cl.isArray()) return null;
        Class componentType = cl.getComponentType(); // 确定数组正确的类型
        int length = Array.getLength(a);
        Object newArray = Array.newInstance(componentType, newLength); // 构造a类型的新数组
        System.arraycopy(a, 0, newArray, 0, Math.min(length, newLength));
        return newArray;
    }
}
