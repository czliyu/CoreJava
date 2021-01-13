package priorityQueue;

import java.time.LocalDate;
import java.util.PriorityQueue;

/**
 * 优先队列中的元素可以按照任意的顺序插入
 * 但会按照有序的顺序进行检索
 * 无论如何调用remove方法，总会获得当前优先队列中最小的元素。
 */
public class PriorityQueueTest {
    
    public static void main(String[] args) {

        var pq = new PriorityQueue<LocalDate>();

        pq.add(LocalDate.of(1906, 12, 9));
        pq.add(LocalDate.of(1815, 12, 10));
        pq.add(LocalDate.of(1903, 12, 3));
        pq.add(LocalDate.of(1910, 6, 22));

        System.out.println("Iterating over elements ...");

        for (LocalDate date : pq)
            System.out.println(date);

        System.out.println("Removing elements ...");
        while (!pq.isEmpty())
            System.out.println(pq.remove());
    }
}
