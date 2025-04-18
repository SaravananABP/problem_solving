package Question_set1;

import java.util.Scanner;

/*
13. Print the word with odd letters – PROGRAM
Sample Output-+4477
P     P
 R   R
  O O
   G
  R R
 A   A
M     M
 */
public class Problem12 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the string: ");
        String input=sc.next();
        int len=input.length();
        for (int i = 0; i < len; i++) {
            String result="";
            for (int j = 0; j < len; j++) {
                result+=(i==j)||(len-1==i+j)?input.charAt(i):" ";
            }
            System.out.println(result);
        }
    }
}
