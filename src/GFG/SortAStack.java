package GFG;

import org.jetbrains.annotations.NotNull;

import java.util.Stack;

public class SortAStack {
    public static void main(String[] args) {
        Stack<Integer> arr = new Stack<>();
        arr.push(2);
        arr.push(1);
        arr.push(4);
        arr.push(3);

        Stack<Integer> res = sortRecursion(arr);
        System.out.println(res);

    }

    private static Stack<Integer> sort(@NotNull Stack<Integer> s) {
        if (s.isEmpty()) return null;
        s.sort((o1, o2) -> {
            if (o1 > o2) return -1;
            else if (o2 > o1) return 1;
            return 0;
        });
        return s;
    }

    private static Stack<Integer> sortRecursion(@NotNull Stack<Integer> s) {
        if (s.isEmpty()) return null;
        int temp = s.pop();
        sortRecursion(s);
        stackPush(s, temp);
        return s;
    }
    private static void stackPush(@NotNull Stack<Integer> arr, int x){
        if (arr.isEmpty() || x < arr.peek()){
            arr.push(x);
            return;
        }
        int temp = arr.pop();
        stackPush(arr, x);
        arr.push(temp);
    }
}
