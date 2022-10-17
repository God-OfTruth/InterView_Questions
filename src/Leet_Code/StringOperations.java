package Leet_Code;

public class StringOperations {
    public static void main(String[] args) {
        System.out.println(finalValueAfterOperations(new String[]{"--X","X++","X++"}));
    }
    public static int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for(String s: operations){
            switch (s) {
                case "--X" -> --x;
                case "X--" -> x--;
                case "++X" -> ++x;
                case "X++" -> x++;
            }
        }
        return x;
    }
}
