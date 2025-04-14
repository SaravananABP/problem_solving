package Question_set1;
/*
6. Remove the duplicates in the String.
Testcase 1:
Input: Java1234
Output: Javb1234 (Remove the second ‘a’ as it is duplicated)
Testcase 2:
Input: Python1223:
Output: Python1234 (Replace the second 2 with 3, and replace 3 with 4 as 3 is replaced for the duplicated 2)
Testcase 3:
Input: aBuzZ9900
Output: aBuzC9012
(Replace the second ‘Z’ with ‘C’ as ‘a’ and ‘B’ are already there in the String. Replace with capital C as the letter to be replaced is capital Z. The second 9 turns out to be zero and the zero turns out to ‘1’ and the second zero turns out to ‘2’)

 */

import java.util.HashSet;
import java.util.Scanner;

public class Problem6 {
    public static void main(String[] args) {
        // ascii value a->97 , z->122
//                     A->65 , Z->90
//                     0->48 , 9->57
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value: ");
        String input = sc.next();

//        String input = "aBuzC9012";
        StringBuilder result = new StringBuilder();
        HashSet<Character> hashSet = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {

            char currentLetter = input.charAt(i);
            while (hashSet.contains(currentLetter)) {
                int asciiNumber = (int) currentLetter;
                //is digit
                if (Character.isDigit(currentLetter)) {
                    currentLetter = (char) ('0' + (currentLetter - '0' + 1) % 10);
                } else if (Character.isUpperCase(currentLetter)) {
                    //is A-Z
                    currentLetter = (char) ('A' + (currentLetter - 'A' + 1) % 26);
                } else if ((65 <= asciiNumber) && (90 >= asciiNumber)) {
                    currentLetter = (char) (65 + (asciiNumber - 65 + 1) % 26);
                }
            }
            hashSet.add(currentLetter);
            result.append(currentLetter);
        }
        System.out.println(result);
    }
}
