import java.math.BigInteger;
import java.util.Scanner;

/**
 * 大数
 * 基本的整数和浮点数精度不能满足需求，那么可以使用java.math 包中的
 * BigInteger和BigDecimal,这两个类可以处理包含任意长度数字序列的数值。
 */
public class BigIntegerTest {
    
    public static void main(String[] args) {
        Scanner = new Scanner(System.in);

        System.out.print("How many numbers do you need to draw?");
        int k = in.nextInt();

        System.out.print("What is the highest number you can draw");
        int n = in.nextInt();

        /**
         * n*(n-1)*(n-2)*...*(n-k+1)/(1*2*3*...*k)
         */
        BigInteger lotteryOdds = BigInteger.valueOf(1);

        for (int i = 1; i <= k; i++) {
            lotteryOdds = lotteryOdds.multiply(BigInteger.valueOf(n-i+1)).divide(BigInteger.valueOf(i));
        }
        System.out.println("Your odds are 1 in " + lotteryOdds + ". Good luck");
    }

}
