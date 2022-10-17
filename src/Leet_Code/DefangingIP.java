package Leet_Code;

import java.util.Arrays;

public class DefangingIP {
    public static void main(String[] args) {
        System.out.println(defangingIpAddress("1.12.1.1"));
    }

    public static String defangingIpAddress(String address) {
        String[] arr = address.split("\\.");
        StringBuilder res = new StringBuilder();
        for (String s: arr) res.append("[.]").append(s);
        res.delete(0,3);
        return res.toString();
    }
}

