package CallTaxiBookingApplication;

import CallTaxiBookingApplication.TaxiBoooking.Booking;
import CallTaxiBookingApplication.TaxiBoooking.Taxi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
2. Call Taxi Booking Application
Description:
Design a taxi booking application where customers can book taxis available at certain points in a linear route.

Problem Assumptions:
Taxi Count: Assume 4 taxis for simplicity, but it should scale to any number of taxis.
Points on Route: A, B, C, D, E, F (each 15 km apart)
Travel Time Between Points: 60 minutes
Charges:
Minimum Rs.100 for the first 5 km
Rs.10 per km thereafter
Initial Taxi Position: All taxis are stationed at A.
Booking Rules:
When a customer books a taxi:
A free taxi at the pickup point is allocated.
If no free taxi is available, the nearest taxi is allocated.
If two taxis are free at the same point, the one with lower earnings is allocated.
Taxis only charge from the pickup point to the drop point.
If no taxi is available, the booking is rejected.
Modules:
Call Taxi Booking

Sample Inputs and Outputs:

Input 1:

Customer ID: 1
Pickup Point: A
Drop Point: B
Pickup Time: 9
Output 1:

Taxi can be allotted.
Taxi-1 is allotted.
Input 2:

Customer ID: 2
Pickup Point: B
Drop Point: D
Pickup Time: 9
Output 2:

Taxi can be allotted.
Taxi-2 is allotted.
Input 3:

Customer ID: 3
Pickup Point: B
Drop Point: C
Pickup Time: 12
Output 3:

Taxi can be allotted.
Taxi-1 is allotted.
Display Taxi Details

Output Example:

Taxi-1    Total Earnings: Rs. 400
BookingID   CustomerID   From   To   PickupTime   DropTime   Amount
1           1            A      B    9           10         200
3           3            B      C    12          13         200

Taxi-2    Total Earnings: Rs. 350
BookingID   CustomerID   From   To   PickupTime   DropTime   Amount
2           2            B      D    9           11         350
 */
public class Main {
    static HashMap<Integer, Taxi> dict = new HashMap<>();

    public static void createBooking(Booking booking) {
        List<Integer> equal = new ArrayList<>();
        ArrayList<Integer> lesser = new ArrayList<>();
        ArrayList<Integer> greater=new ArrayList<>();
        for (int i : dict.keySet()) {
            if (dict.get(i).getFreeTime() == booking.getPickupTime()) {
                equal.add( i);
            } else if (dict.get(i).getFreeTime() < booking.getPickupTime()) {
                lesser.add(i);
            }else{
                greater.add(i);
            }
        }
        if(booking.getFrom()- booking.getTo()!=0) {
            if (!equal.isEmpty()) {
                int minAmt = dict.get(equal.get(0)).getTotalEarnings(),index=equal.get(0);
                for (int i : equal) {
                    if (dict.get(i).getTotalEarnings() < minAmt) {
                        minAmt = dict.get(i).getTotalEarnings();
                        index=i;
                    }
                }
                Taxi taxi = dict.get(index);
                Booking booking1 = new Booking(booking.getCustomerID(), booking.getFrom(), booking.getTo(), booking.getPickupTime());
                taxi.setFreeTime(booking1.getDropTime());
                taxi.setCurrentPosition(booking1.getTo());
                taxi.setTotalEarnings(taxi.getTotalEarnings() + booking1.getAmount());
                List<Booking> bookings = taxi.getBookings();
                bookings.add(booking1);
                taxi.setBookings(bookings);
                dict.put(index,taxi);
                System.out.println("Taxi can be allotted.");
                System.out.println("Taxi-" + index + " is allotted.");
            } else if (!lesser.isEmpty()) {
                int minDis = dict.get(lesser.get(0)).getCurrentPosition(),index=lesser.get(0);
                for (int i:greater){
                    if(dict.get(i).getCurrentPosition()-booking.getPickupTime()<minDis){
                        minDis=dict.get(i).getCurrentPosition();
                        index=i;
                    }
                }
                for (int i : lesser) {
                    if (booking.getPickupTime() - dict.get(i).getCurrentPosition() < minDis) {
                        minDis = dict.get(i).getCurrentPosition();
                        index=i;
                    }
                }

                Taxi taxi = dict.get(index);
                Booking booking1 = new Booking(booking.getCustomerID(), booking.getFrom(), booking.getTo(), booking.getPickupTime());
                taxi.setFreeTime(booking.getDropTime());
                taxi.setCurrentPosition(booking1.getTo());
                taxi.setTotalEarnings(taxi.getTotalEarnings() + booking1.getAmount());
                List<Booking> bookings = taxi.getBookings();
                bookings.add(booking1);
                taxi.setBookings(bookings);
                dict.put(index,taxi);
                System.out.println("Taxi can be allotted.");
                System.out.println("Taxi-" + index + " is allotted.");

            }
        } else {
            System.out.println("Taxi can be allotted.");
        }

    }
    public static void getAllHistory(){
        for (int i: dict.keySet()){
            if(dict.get(i).getTotalEarnings()!=0) {
                System.out.println("Taxi-"+i+"    Total Earnings: Rs. "+dict.get(i).getTotalEarnings());
                System.out.println("BookingID   CustomerID   From   To   PickupTime   DropTime   Amount");
                for(Booking b:dict.get(i).getBookings()){
                    InputOutput.printPrity(b,dict.get(i).getId());
                }
//                System.out.println(dict.get(i).toString());
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 2; i++) {
            dict.put(i, new Taxi(i));
        }
        InputOutput.title("welcome");
        boolean flag = true;
        while (flag) {
            InputOutput.option("Book a taxi..getAllTaxi..exit");
            int choice = InputOutput.intInput("choice");
            switch (choice) {
                case 1:
                    int customerId = InputOutput.intInput("Customer ID");
                    char pickup = InputOutput.strInput("Pickup Point").toUpperCase().charAt(0);
                    char drop = InputOutput.strInput("Drop Point").toUpperCase().charAt(0);
                    int pickupTime = InputOutput.intInput("Pickup Time");
                    Booking booking = new Booking(customerId, pickup, drop, pickupTime);
                    createBooking(booking);
                    break;
                case 2:
                    getAllHistory();
                    break;
                case 3:
                    flag=false;
                    break;


            }
        }
    }
}
