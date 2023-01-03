package leet_code;

public class ShuffleString {
    public static void main(String[] args) {
        System.out.println(restoreString("codeleet", new int[] {4,5,6,7,0,2,1,3}));
    }

    public static String restoreString(String s, int[] indices) {
        StringBuilder res = new StringBuilder();
        for (int i: indices){
            System.out.println(s.charAt(i)+" "+i);
            res.append(s.charAt(i));
            System.out.println(res);
        }
        return res.toString();
    }
}
