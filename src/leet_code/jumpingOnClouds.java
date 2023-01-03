package leet_code;

import java.util.List;

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
}

