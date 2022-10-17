package GFG;

public class ModifiedNumbersAndQueries {
    public static void main(String[] args) {
        System.out.println(sumOfAll(1, 6));
    }
    public static int sumOfAll(int l, int r) {
        int sum = 0;
        for (int i = l; i <= r; i++)
            sum += factorialSum(i);
        return sum;
    }
    public static int factorialSum(int a) {
        if (a == 1) return 1;
        int ans = 0;
        for (int i = 2; i * i <= a; i++)
            if (a % i == 0) {
                ans += i;
                while (a > 1 && a % i == 0) a /= i;
            }
        if (a > 1) ans += a;
        return ans;
    }
}
