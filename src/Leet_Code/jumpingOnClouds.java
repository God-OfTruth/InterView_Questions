package Leet_Code;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'jumpingOnClouds' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY c as parameter.
     */

    public static int jumpingOnClouds(List<Integer> c) {
        int jumps = 0;
        int i=0;
        while(i < c.size()-3){
            i+=(c.get(i+2)==0) ? 2:1;
            jumps++;
        }
        jumps++;
        return jumps;

    }

    public static List<Integer> maximumPerimeterTriangle(List<Integer> sticks) throws NoSuchMethodException {
        throw new NoSuchMethodException("Method needs to checked or implemented");
    }
}

