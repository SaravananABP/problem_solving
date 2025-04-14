package Question_set1;

import java.util.Arrays;
import java.util.Scanner;

/*
7. Print whether the version is upgraded, downgraded or not changed according to the input given.
example: Input : Version1 4.8.2 Version2 4.8.4 Output: upgraded,
        Input : Version1 4.0.2 Version2 4.8.4 Output: downgraded

 */
public class Problem7 {
    public String check_version(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        if (v1.length <= v2.length) {
            for (int i = 0; i < v1.length; i++) {
                if (Integer.parseInt(v1[i]) < Integer.parseInt(v2[i])) {
                    return "upgraded";
                }
            }
        }
        return "downgraded";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Version1 : ");
        String version1 = sc.nextLine();
        System.out.print("Version2 : ");
        String version2 = sc.nextLine();
        Problem7 problem7 = new Problem7();
        String result = problem7.check_version(version1, version2);
        System.out.println(result);
    }
}
