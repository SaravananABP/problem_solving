package Question_set1;

import java.util.ArrayList;
import java.util.List;

/*
8. Q2. Print all possible subsets of the given array whose sum equal to given N.
example: Input: {1, 2, 3, 4, 5} N=6 Output: {1, 2, 3}, {1, 5}, {2, 4}
 */
public class Problem8 {
    public static int powerOfValue(int n) {
        int sum = 1;
        for (int i = 0; i < n; i++) {
            sum *= 2;
        }
//        System.out.println(sum);
        return sum;
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5};
        int n = 6;
        for (int i = 0; i < powerOfValue(input.length); i++) {
            int sum = 0;
            List<Integer> result = new ArrayList<>();
            for (int j = 0; j < input.length; j++) {
                if ((i & powerOfValue(j)) > 0) {
                    result.add(input[j]);
                    sum += input[j];
                }
            }
            if (sum == n) {
                System.out.println(result);
            }
        }
    }
}
