package CallTaxiBookingApplication.TaxiBoooking;

public class Booking {
    private static int nextId=0;
    private int bookingID;
    private int customerID;
    private char from;
    private char to;
    private int pickupTime;
    private int dropTime;
    private int amount;


    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public char getFrom() {
        return from;
    }

    public void setFrom(char from) {
        this.from = from;
    }

    public char getTo() {
        return to;
    }

    public void setTo(char to) {
        this.to = to;
    }

    public int getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(int pickupTime) {
        this.pickupTime = pickupTime;
    }

    public int getDropTime() {
        return dropTime;
    }

    public void setDropTime(int dropTime) {
        this.dropTime = dropTime;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    public Booking(){
    }
    public Booking(int customerID,char from,char to,int pickupTime){
        nextId++;
        this.bookingID=nextId;
        this.customerID=customerID;
        this.from=String.valueOf(from).toUpperCase().charAt(0);
        this.to=String.valueOf(to).toUpperCase().charAt(0);
        this.pickupTime=pickupTime;
        this.dropTime=pickupTime+(to-from);
        if(to>from) {
            this.amount = 100 + ((((to - from) * 15) - 5) * 10);
        }else {
            this.amount = 100 + (((from - to) * 15) - 5) * 10;
        }

    }

    @Override
    public String toString() {
        return String.format("%12d %13d %7s %5s %13d %10d %9d",customerID,customerID,from,to,pickupTime,dropTime,amount);
    }
}
