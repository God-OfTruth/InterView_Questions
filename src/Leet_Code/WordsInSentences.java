package Leet_Code;

public class WordsInSentences {
    public static void main(String[] args) {
        System.out.println(mostWordsFound(new String[]{"Hello My", "Whats app is There"}));
    }
    public static int mostWordsFound(String[] sentences) {
        int max = 0;
        for(String str: sentences){
            int l = str.split(" ").length;
            if(l > max) max = l;
        }
        return max;
    }
}
