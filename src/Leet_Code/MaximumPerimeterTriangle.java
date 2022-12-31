package Leet_Code;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class MaximumPerimeterTriangle {

    /*
     * Complete the 'maximumPerimeterTriangle' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY sticks as parameter.
     */

    public static List<Integer> maximumPerimeterTriangle(List<Integer> sticks) {
    // Write your code here
        Collections.sort(sticks);
        List<Integer> res = new ArrayList<>();
        for(int i= sticks.size()-3; i>=0; i--){
            if(sticks.get(i) + sticks.get(i+1) > sticks.get(i+2)) {
                res.add(sticks.get(i)); res.add(sticks.get(i+1)); res.add(sticks.get(i+2));
                return res;
            }
        }
        res.add(-1);
        return res;
    }

}
 class Solution {
    public static void main(String[] args) throws IOException, NoSuchMethodException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> sticks = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.maximumPerimeterTriangle(sticks);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
