package Question_set1;

import java.util.ArrayList;
import java.util.Scanner;

/*
9. Reverse the words in the given String1 from the first occurrence of String2 in String1 by maintaining white Spaces.
example: String1 = Input: This is a test String only String2 = st Output: This is a only String test
 */
public class Problem9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the String1 : ");
        String s1 = sc.nextLine();
        System.out.print("Enter the String2 : ");
        String s2 = sc.nextLine();
        String result = "";
        boolean flag = true;
        String[] arr = s1.split(" ");
        int count = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].contains(s2)) {
                flag = false;
            }
            if (flag) {
                result += arr[i] + " ";
            } else {
                result += arr[arr.length - count] + " ";
                count++;
            }
        }
        System.out.println(result.trim());
    }
}
