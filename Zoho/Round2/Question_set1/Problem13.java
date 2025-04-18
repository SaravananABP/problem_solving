package Question_set1;

import java.util.Arrays;

/*
14. Sample Input – Alternate Sorting
Input: {1, 2, 3, 4, 5, 6, 7}
output: {7, 1, 6, 2, 5, 3, 4}
 */
public class Problem13 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int[] result = new int[arr.length];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                result[i] = arr[arr.length - 1 - count];
            } else {
                result[i] = arr[i - 1 - count];
                count++;
            }
        }
        Arrays.stream(result).mapToObj(x -> x + " ").forEach(System.out::print);
    }
}
