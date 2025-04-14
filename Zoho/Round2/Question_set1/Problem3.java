package Question_set1;

import java.util.Arrays;

/*
3.  Equilibrium index of an array is an index such that the sum of elements
    at lower indexes is equal to the sum of elements at higher indexes.
    For example, in an array A:
Example :
Input: A[] = {-7, 1, 5, 2, -4, 3, 0}
Output: 3
3 is an equilibrium index, because:
A[0] + A[1] + A[2] = A[4] + A[5] + A[6]
Input: A[] = {1, 2, 3}
Output: -1
 */
//total=left+right+a[i]
public class Problem3 {
    public static int Equilibrium(int[] arr){
        int left=0;
        int total= Arrays.stream(arr).sum();
        for (int i=0;i<arr.length;i++) {
            if(left==total-left-arr[i]){
                return i;
            }
            left+=arr[i];
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] a={2,0,1,1};
        System.out.println(Problem3.Equilibrium(a));
    }
}
