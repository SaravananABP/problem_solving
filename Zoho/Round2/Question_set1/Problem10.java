package Question_set1;

/*
10. calculate Maximum number of chocolates can eat and Number of wrappers left in hand.
Money: Total money one has to spend.
Price: price per chocolate.
wrappers: minimum number of wrappers for exchange choco: number of chocolate for wrappers.
Max visit: Maximum number of times one can visit the shop.(if zero consider it infinite)
example: input: Money:40 Price:1 wrappers:3 choco:1 Max visit:1
Output: total chocolate can eat: 53 wrappers left in hand:14
 */
public class Problem10 {
    public static void main(String[] args) {
        int Money = 40, Price = 1, wrappers = 3, choco = 1, visit = 1;
        int eaten = Money / Price;
        int totalWrapper = eaten / choco;
        if (totalWrapper >= wrappers) {
            for (int i = 0; i < visit; i++) {
                eaten += (totalWrapper / wrappers);
                totalWrapper = (totalWrapper / wrappers) + ((totalWrapper / wrappers) % wrappers) * choco;
            }
        }
        System.out.println("total chocolate can eat:" + eaten);
        System.out.println("wrappers left in hand:" + totalWrapper);
    }
}
