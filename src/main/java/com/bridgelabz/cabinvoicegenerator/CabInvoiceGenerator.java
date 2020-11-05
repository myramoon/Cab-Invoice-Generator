package com.bridgelabz.cabinvoicegenerator;
import java.util.ArrayList;

public class CabInvoiceGenerator {

    private static final double MINIMUM_COST_PER_KM_NORMAL = 10.0;
    private static final int COST_PER_MINUTE_NORMAL = 1;
    private static final double MINIMUM_FARE_NORMAL = 5;
    private static final double MINIMUM_COST_PER_KM_PREMIUM = 15.0;
    private static final int COST_PER_MINUTE_PREMIUM = 2;
    private static final double MINIMUM_FARE_PREMIUM = 20;


    public double calculateFare(double distance, int time , String rideCategory) {  //calculates fare for given distance and time for which the journey lasted
        if(rideCategory.equals("normal")) {
            double totalFare = distance * MINIMUM_COST_PER_KM_NORMAL + time * COST_PER_MINUTE_NORMAL;
            return Math.max(totalFare, MINIMUM_FARE_NORMAL);
        }
        else {
            double totalFare = distance * MINIMUM_COST_PER_KM_PREMIUM + time * COST_PER_MINUTE_PREMIUM;
            return Math.max(totalFare, MINIMUM_FARE_PREMIUM);
        }
    }

    public InvoiceSummary calculateFare(ArrayList<Ride> rides) { //calls calculateFare method for multiple rides and generates invoice summary
        double totalFare = 0;
        for (Ride ride : rides)
            totalFare += this.calculateFare(ride.distance , ride.time , ride.rideCategory);
        return new InvoiceSummary(rides.size(), totalFare);
    }

    public ArrayList<Ride> getListOfRides(User user) { //returns ride list of a userid
        return user.getRideList();
    }
}
