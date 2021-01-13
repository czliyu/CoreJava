package forkJoin;

public class ForkJoinTest {

    public static void main(String[] args) {
        final int SIZE = 10000000;

        var numbers = new double[SIZE];
        for (int i = 0; i < SIZE; i++) numbers[i] = Math.random();
    }
}