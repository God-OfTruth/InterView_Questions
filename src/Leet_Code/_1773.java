package Leet_Code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class _1773 {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("phone", "silver", "pixel");
        List<String> list2 = Arrays.asList("computer", "silver", "lenovo");
        List<String> list3 = Arrays.asList("phone", "gold", "iphone");
        List<List<String>> lists = Arrays.asList(list1, list2, list3);

        System.out.println(countMatches(lists, "name", "pixel"));
    }

    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;
        for (List<String> l : items) {
            switch (ruleKey) {
                case "name" -> {
                    if (Objects.equals(l.get(2), ruleValue)) count++;
                }
                case "color" -> {
                    if (Objects.equals(l.get(1), ruleValue)) count++;
                }
                case "type" -> {
                    if (Objects.equals(l.get(0), ruleValue)) count++;
                }
                default -> throw new IllegalStateException("Unexpected value: " + ruleKey);
            }
        }
        return count;
    }
}
