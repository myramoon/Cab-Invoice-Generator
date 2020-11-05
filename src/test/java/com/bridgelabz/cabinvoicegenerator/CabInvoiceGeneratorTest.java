package com.bridgelabz.cabinvoicegenerator;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;

public class CabInvoiceGeneratorTest {

    @Test
    public void givenUserIdAndNormalRideCategory_ShouldReturnInvoiceSummary() {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        User newUser = new User("abc");
        newUser.addRide(2.0 , 5 , "normal");
        newUser.addRide(0.5 , 5 , "normal");
        newUser.addRide(0.1 , 1 , "normal");
        ArrayList<Ride> rideListForId = cabInvoiceGenerator.getListOfRides(newUser);
        InvoiceSummary invoiceSummary = cabInvoiceGenerator.calculateFare(rideListForId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(3 , 40);
        Assert.assertEquals(expectedInvoiceSummary , invoiceSummary);
    }

    @Test
    public void givenUserIdAndPremiumRideCategory_ShouldReturnInvoiceSummary() {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        User newUser = new User("def");
        newUser.addRide(2.0 , 5 , "premium");
        newUser.addRide(0.5 , 5 , "premium");
        newUser.addRide(0.1 , 1 , "normal");
        ArrayList<Ride> rideListForId = cabInvoiceGenerator.getListOfRides(newUser);
        InvoiceSummary invoiceSummary = cabInvoiceGenerator.calculateFare(rideListForId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(3 , 65);
        Assert.assertEquals(expectedInvoiceSummary , invoiceSummary);
    }
}
