package CallTaxiBookingApplication.TaxiBoooking;

import java.util.ArrayList;
import java.util.List;

public class Taxi {
    private List<Booking> bookings;
    private int id;
    private char currentPosition;
    private int freeTime;
    private int totalEarnings;
    public Taxi(){
    }
    public Taxi(int id){
        this.id=id;
        this.currentPosition='A';
        this.bookings=new ArrayList<>();
        this.totalEarnings=0;
        this.freeTime=0;
    }

    public List<Booking> getBookings() {
        return this.bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(char currentPosition) {
        this.currentPosition = currentPosition;
    }

    public int getFreeTime() {
        return freeTime;
    }

    public void setFreeTime(int freeTime) {
        this.freeTime = freeTime;
    }

    public int getTotalEarnings() {
        return totalEarnings;
    }

    public void setTotalEarnings(int totalEarnings) {
        this.totalEarnings = totalEarnings;
    }

    @Override
    public String toString() {
        return "Taxi{" +
                "bookings=" + bookings +
                ", id=" + id +
                ", currentPosition=" + currentPosition +
                ", freeTime=" + freeTime +
                ", totalEarnings=" + totalEarnings +
                '}';
    }
}
