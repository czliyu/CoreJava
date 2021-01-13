package linkedList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * 具体使用列表
 * 创建了两个列表，将它们合并在一起，
 * 然后从第二个列表中每隔一个元素删除一个元素
 * 最后测试RemoveAll方法
 */
public class LinkedListTest {
    
    public static void main(String[] args) {

        var a = new LinkedList<String>();
        a.add("Amy");
        a.add("Carl");
        a.add("Erica");

        var b = new LinkedList<String>();
        b.add("Bob");
        b.add("Doug");
        b.add("Frances");
        b.add("Gloria");

        // merge the words from b to a
        // 返回一个实现了ListIterator接口的迭代器, 有add(E e)方法 添加元素
        ListIterator<String> aIter = a.listIterator();
        Iterator<String> bIter = b.iterator(); // 迭代器

        while (bIter.hasNext()) {
            if (aIter.hasNext()) aIter.next();
            aIter.add(bIter.next());
        }

        System.out.println(a);

        // remove every second word from b

        bIter = b.iterator();
        while(bIter.hasNext()) {
            bIter.next(); // skip first element
            if (bIter.hasNext()) {
                bIter.next(); // skip next element
                bIter.remove();
            }
        }

        System.out.println(b);

        // remove all words in b from a
        a.removeAll(b);
        System.out.println(a);
    }
}
