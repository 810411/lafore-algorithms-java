package Recursion;

// Возведение в степень x^y, через рекурсию за O(logN)
public class PowerApp {
    public static void main(String[] args) {
        System.out.println(pow(2, 3));
        System.out.println(pow(10, 5));
        System.out.println(pow(5, 10));
    }

    private static long pow(int x, int y) {
        if (y == 1)
            return x;

        long res = pow(x * x, y / 2);

        if (y % 2 != 0)
            res *= x;

        return res;
    }
}
