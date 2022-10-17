package codechef;

import java.util.Scanner;

public class TheLeadGame {
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int player = 0;
        int lead = 0;
        while(n > 0){
            n--;
            int p1 = sc.nextInt();
            int p2 = sc.nextInt();
            if(p1 > p2) {
                int temp_lead = p1 - p2;
                if(temp_lead > lead){
                    lead = temp_lead;
                    player = 1;
                }
            }
            else{
                int temp_lead = p2 - p1;
                if(temp_lead > lead){
                    lead = temp_lead;
                    player = 2;
                }
            }
        }
        System.out.println(player + " " + lead);
    }
}
