package Leet_Code;

import java.util.ArrayList;

public class JewelsAndStones {
    public static void main(String[] args) {
        System.out.println(numJewelsInStones("aA", "aAAbbbb"));
    }
    public static int numJewelsInStones(String jewels, String stones) {
        ArrayList<Character> j = new ArrayList<>();
        for (char c: jewels.toCharArray()) j.add(c);
        int count = 0;
        for(char c: stones.toCharArray()) if (j.contains(c)) count++;
        return count;
    }
}
