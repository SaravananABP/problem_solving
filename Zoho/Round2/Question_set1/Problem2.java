package Question_set1;

import java.util.Arrays;
import java.util.Scanner;
/*
2. Given a Boolean matrix mat[M][N] of size M X N, modify it such that if a matrix cell mat[i][j] is 1 then make its adjacent cells as 0.
Input:
1 0 1
0 1 0
1 1 1
Output:
0 0 0
0 0 0
1 0 1
Explanation:
For the cell mat[0][0] which is 1, its adjacent cells (mat[0][1] and mat[1][0]) are modified to 0.
For the cell mat[1][1] which is 1, its adjacent cells (mat[0][1], mat[1][0], mat[1][2], and mat[2][1]) are modified to 0.
The modification is not applied to the cell mat[2][2] as it doesn't have all four adjacent cells.
 */
public class Problem2 {
    public int[][] aboveValue(int[][] arr,int i,int j){

        if( i>0 ){
            arr[i-1][j]=0;
        }
        return arr;
    }
    public int[][] belowValue(int[][] arr,int i,int j){
        if( i<arr.length-1 ){
            arr[i+1][j]=0;
        }
        return arr;
    }
    public int[][] leftValue(int[][] arr,int i,int j){

        if( j>0 ){
            arr[i][j-1]=0;
        }
        return arr;
    }
    public int[][] rightValue(int[][] arr,int i,int j){
        if( j<arr.length-1 ){
            arr[i][j-1]=0;
        }
        return arr;
    }
    public int[][] input_data(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no.of rows    : ");
        int rows = sc.nextInt();
        System.out.print("Enter no.of columns : ");
        int columns = sc.nextInt();
        int[][] arr = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Element inset in position ["+i+"] ["+j+"] : ");
                arr[i][j]=sc.nextInt();
            }
        }
        return arr;
    }
    public static void main(String args[]) {
        Problem2 problem2=new Problem2();
        int[][] input_arr=problem2.input_data();
        // Deep copy of the original array
        int rows=input_arr.length;
        int columns=input_arr[0].length;
        int[][] result = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            result[i] = Arrays.copyOf(input_arr[i], columns);
        }
        for (int i = 0; i < input_arr.length; i++) {
            for (int j = 0; j < input_arr[0].length; j++) {
                if(input_arr[i][j]==1){
                    if(i>0)result[i-1][j]=0; //above
                    if(i<input_arr.length-1)result[i+1][j]=0; //below
                    if(j>0)result[i][j-1]=0;//left
                    if(j<input_arr[0].length-1)result[i][j+1]=0; //right
                }
            }

        }
        for (int i = 0; i < input_arr.length; i++) {
            for (int j = 0; j < input_arr[0].length; j++) {
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }

    }
}




