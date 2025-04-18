package Question_set1;

import java.util.Scanner;

/*
11. Sample Input-
2
Hacker
Rank
Sample Output-
Hce akr
Rn ak
 */
public class Problem11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String input = sc.nextLine();
        String even = "", odd = "";
        for (int i = 0; i < input.length(); i++) {
            if (i % 2 == 0) {
                even += input.charAt(i);
            } else {
                odd += input.charAt(i);
            }
        }
        System.out.println(even + " " + odd);
    }
}
