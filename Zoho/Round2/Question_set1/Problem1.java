package Question_set1;

import java.util.Arrays;
import java.util.Scanner;

/*
1. Replace every element with the greatest element on right side
Given an array of integers, replace every element with the next
greatest element (greatest element on the right side) in the array.
Since there is no element next to the last element, replace it with -1.
 For example,
    if the array is {16, 17, 4, 3, 5, 2},
    then it should be modified to {17, 5, 5, 5, 2, -1}.

 */
public class Problem1 {
    public int[] inputData() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the no.of.element : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the element " + i + " : ");
            arr[i] = sc.nextInt();
        }


        return arr;
    }

    public void print_array(int[] arr) {
        Arrays.stream(arr).mapToObj(x -> x + " ").forEach(System.out::print);
    }

    public int[] operation(int[] arr) {
        int len = arr.length;
        int[] result = new int[len];
        int max = 0;
        for (int i = 0; i < len - 1; i++) {
            max = arr[i + 1];
            result[i] = max;
            for (int j = i + 1; j < len; j++) {
                if (max < arr[j]) {
                    max = arr[j];
                    result[i] = max;
                }
            }
        }

        return result;
    }

    public static void main(String args[]) {
        Problem1 problem1 = new Problem1();
        int[] input = problem1.inputData();
        System.out.println("Array input elements : ");
        problem1.print_array(input);
        int[] result = problem1.operation(input);
        System.out.println("\nFinal Output : ");
//        last element be -1 so
        result[result.length - 1] = -1;
        problem1.print_array(result);


    }
}