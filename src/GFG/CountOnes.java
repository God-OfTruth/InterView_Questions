package GFG;

public class CountOnes {
    public static void main(String[] args) {
        System.out.println(setBits(6));
    }
    static int setBits(int N) {
        int c = 0;
        for (char i: Integer.toBinaryString(N).toCharArray()){
            if (i == '1') c++;
        }
        return c;
    }
}
