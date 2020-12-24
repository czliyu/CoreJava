import java.util.*;

/**
 * 输入与输出
 */
public class InputTest {
    
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("What is your name? ");
        String name = in.nextLine();

        System.out.println("How old are you");
        int age = in.nextInt();

        System.out.println("Hello, " + name + ". Next year, you'll be " + (age + 1));
        System.out.printf("Hello, %s, Next year, you'll be %d", name, age);
    }
}
