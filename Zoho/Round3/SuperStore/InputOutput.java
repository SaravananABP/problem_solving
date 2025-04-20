package SuperStore;

import java.util.Scanner;

public class InputOutput {
    public static String space="          ";
    static Scanner sc=new Scanner(System.in);
    public static void option(String val){
        int count=1;
        for(String s:val.split("\\.\\.")){
            System.out.println(space+count+". "+s);
            count++;
        }
    }
    public static void title(String val){
        String before="-----------------";
        System.out.println(space+before+space+val+space+before+space);
    }
    public static void endLine(){
        System.out.println("*".repeat(20));
    }
    public static void inputField(String s){

    }
    public static int intInput(String s){
        System.out.printf("     Enter the value of %s : ", s);
        return sc.nextInt();
    }
    public static String strInput(String s){
        System.out.printf("     Enter the value of %s : ", s);
        return sc.next();
    }
    public static Long longInput(String s){
        System.out.printf("     Enter the value of %s : ", s);
        return sc.nextLong();
    }
    public static boolean boolInput(){
        return sc.nextBoolean();
    }
    public static void status(String str){
        System.out.println(" status : "+str);
    }
}
