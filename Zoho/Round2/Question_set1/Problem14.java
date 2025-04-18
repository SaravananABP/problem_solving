package Question_set1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
15.Given an array of values persons[], each represents the weight of the persons.
There will be infinite bikes available.
Given a value K which represents the maximum weight that a bike accommodates.
Along with that one more condition, a bike can carry two persons at a time.
You need to find out the least number of times, the bike trips are made.
Input
persons = [30, 50, 70, 60]
K = 100

output:
Minimum number of trips = 3
 */
public class Problem14 {
    public static int powerValue(int n) {
        int sum = 1;
        for (int i = 0; i < n; i++) {
            sum *= 2;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the person weight in separate by space: ");
        String per = sc.nextLine();
        List<Integer> person = new ArrayList<>();
        String[] perStr = per.split(" ");
        for (int i = 0; i < perStr.length; i++) {
            person.add(Integer.parseInt(perStr[i]));
        }
        System.out.print("Enter the bike weight :");
        int bike = sc.nextInt();

        int personLen = person.size();
        person.stream().sorted();
        int trip = 0, i = 0, j = personLen - 1;
        while (i <= j) {
            if (person.get(i) + person.get(j) <= bike) {
                i += 1;
            }
            j -= 1;
            trip += 1;
        }
        System.out.println("the least number of times, the bike trips are made : " + trip);
    }
}
