package Question_set1;

import java.util.Arrays;

/*
5. Given a matrix of 2D array of n rows and m coloumns. Print this matrix in ZIG-ZAG fashion as shown in figure.

Example:
Input:
1 2 3
4 5 6
7 8 9
Output:
1 2 4 7 5 3 6 8 9
 */
public class Problem5 {
    public static int[] zigzag(int[][] arr) {
        int m = arr.length, n = arr[0].length;
        int row = 0, col = 0;
        int i = 0;
        int[] result = new int[m * n];
        boolean upward = true;
        while (row < m && col < n) {
            if (upward) {
                while (row > 0 && col < n - 1) {
                    result[i++] = arr[row][col];
                    row--;
                    col++;

                }
                result[i++] = arr[row][col];
                System.out.println(arr[row][col]);
                if (col == n - 1) {
                    row++;
                } else {
                    col++;
                }
            } else {
                if (col > 0 && row < m - 1) {
                    result[i++] = arr[row][col];
                    row++;
                    col--;
                }
                result[i++] = arr[row][col];
                if (row == n - 1) {
                    col++;
                } else {
                    row++;
                }
            }
            upward = !upward;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        Arrays.stream(Problem5.zigzag(arr)).mapToObj(x -> x + " ").forEach(System.out::print);

    }
}
