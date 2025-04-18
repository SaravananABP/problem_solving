package Question_set1;
/*
16. Assume there exists infinite grid, you’re given initial position x, y. Inputs will be movements either L or R or U or D. After n inputs, you need to give the current position.
•	Input:
•	4 5 //initial position x, y
•	9 //number of movements
•	U L R R D D U L R //7 movements
•	Output:
5 5
 */
public class Problem15 {


    public static int[] U(int[] val){
        int x=val[0];
        int y=val[1];
        int[] currentMove=new int[2];
        currentMove[0]=x-1;
        currentMove[1]=y;
        return currentMove;
    }
    public static int[] D(int[] val){
        int x=val[0];
        int y=val[1];
        int[] currentMove=new int[2];
        currentMove[0]=x+1;
        currentMove[1]=y;
        return currentMove;
    }
    public static int[] R(int[] val){
        int x=val[0];
        int y=val[1];
        int[] currentMove=new int[2];
        currentMove[0]=x;
        currentMove[1]=y-1;
        return currentMove;
    }
    public static int[] L(int[] val){
        int x=val[0];
        int y=val[1];
        int[] currentMove=new int[2];
        currentMove[0]=x;
        currentMove[1]=y+1;
        return currentMove;
    }

    public static void main(String[] args) {
        int x=4, y=5,move=9;

        String movements="U L R R D D U L R U U";
        String[] arr=movements.split(" ");
        int[] val=new int[2];
        val[0]=x;
        val[1]=y;
        for (String i:arr) {
            switch (i){
                case "U":{
                    x-=1;
                    break;
                }
                case "D":{
                    x+=1;
                    break;
                }case "R":{
                    y-=1;
                    break;
                }case "L":{
                    y+=1;
                    break;
                }
            }
        }
        System.out.println(x+" "+y);
    }
}
