package gfg;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicatesStr {
    public static void main(String[] args) {
        System.out.println(removeDuplicates("geeksforgeeks"));
    }
    static String removeDuplicates(String str) {
        Set<Character> ch = new LinkedHashSet<>();
        for (char i: str.toCharArray())
            ch.add(i);
        StringBuilder builder = new StringBuilder();
        for (char i: ch)
            builder.append(i);
        return builder.toString();
    }
}
