package Leet_Code;

public class ClosestPrimeToNum {
    public static void main(String[] args) {
        System.out.println(NthTerm(1));
    }

    public static int NthTerm(int n) {
        if (n == 1) return 1;
        int t = getTopPrime(n);
        int s = getSmallPrime(n);
        return Math.min(Math.abs(t - n), Math.abs(s - n));
    }

    public static int getTopPrime(int n){
        while (true){
            if(isPrime(n)) return n;
            n++;
        }
    }

    public static int getSmallPrime(int n){
        while (true){
            if(isPrime(n)) return n;
            n--;
        }
    }
    public static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) if (n % i == 0) return false;
        return true;
    }
}
