package shuffle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 用1-49之间的49个Integer对象填充数组。
 * 然后，随机打乱列表，并从打乱的列表中选前6个值。
 */
public class ShuffleTest {
    
    public static void main(String[] args) {

        var numbers = new ArrayList<Integer>();

        for (int i = 1; i <= 49; i++)
            numbers.add(i);
        
        Collections.shuffle(numbers);
        List<Integer> winningCombination = numbers.subList(0, 6);
        Collections.sort(winningCombination);
        System.out.println(winningCombination);
    }
}
