package Leet_Code;

public class GoalInterpreter {
    public static void main(String[] args) {
        System.out.println(interpret("(al)G(al)()()G"));
    }

    public static String interpret(String command) {
        StringBuilder res = new StringBuilder();
        int l = command.length();
        int i = 0;
        while (l > 0) {
            l--;
            switch (command.charAt(i)) {
                case 'G' -> {
                    res.append("G");
                    i++;
                }
                case '(' -> {
                    if (command.charAt(i + 1) == ')') {
                        res.append("o");
                        i++;
                    } else if (command.charAt(i + 1) == 'a') {
                        res.append("al");
                        i++;
                    }
                }
                default -> i++;
            }
        }
        return res.toString();
    }
}
