package main;

import adapter.LegacyPaymentSystem;
import adapter.PaymentAdapter;
import adapter.PaymentProcessor;

import builder.ConcreteBookingBuilder;
import factory.DeluxeRoomFactory;
import factory.RoomFactory;

import model.Booking;
import model.Room;

import observer.*;
import singleton.SystemConfiguration;

import strategy.*;

import template.CheckInWorkflow;
import template.CheckOutWorkflow;
import template.HotelWorkflow;

/**
 * Main entry point for Smart Hospitality Management System (SHMS).
 *
 * This class demonstrates the full system flow:
 * - Configuration loading (Singleton)
 * - Room creation (Factory)
 * - Booking construction (Builder)
 * - Notifications (Observer)
 * - Billing (Strategy)
 * - Workflow execution (Template Method)
 * - Payment processing (Adapter)
 */
public class Main {

    public static void main(String[] args) {

        // -------------------------------
        // 1. System Configuration (Singleton)
        // -------------------------------
        SystemConfiguration config = SystemConfiguration.getInstance();
        System.out.println(config);

        config.setHotelName("Grand SHMS Hotel");
        config.setTaxRate(0.15);

        // -------------------------------
        // 2. Room Creation (Factory Method)
        // -------------------------------
        RoomFactory roomFactory = new DeluxeRoomFactory();
        Room room = roomFactory.createRoom(101);

        System.out.println("\nRoom Created:");
        System.out.println(room);

        // -------------------------------
        // 3. Booking Construction (Builder)
        // -------------------------------
        Booking booking = new ConcreteBookingBuilder()
                .setGuestName("Maryam")
                .setRoom(room)
                .addBreakfast(true)
                .addAirportPickup(true)
                .addRoomUpgrade(false)
                .build();

        System.out.println("\nBooking Created:");
        System.out.println(booking);

        // -------------------------------
        // 4. Notifications (Observer Pattern)
        // -------------------------------
        NotificationService notificationService = new NotificationService();

        notificationService.addObserver(new GuestObserver("Maryam"));
        notificationService.addObserver(new StaffObserver());
        notificationService.addObserver(new ManagerObserver());

        notificationService.notifyObservers(
                new NotificationEvent(
                        EventType.BOOKING_CONFIRMED,
                        "Booking successfully created for Maryam"
                )
        );

        // -------------------------------
        // 5. Workflow Execution (Template Method)
        // -------------------------------
        System.out.println("\n--- CHECK-IN WORKFLOW ---");
        HotelWorkflow checkIn = new CheckInWorkflow();
        checkIn.executeWorkflow();

        System.out.println("\n--- CHECK-OUT WORKFLOW ---");
        HotelWorkflow checkOut = new CheckOutWorkflow();
        checkOut.executeWorkflow();

        // -------------------------------
        // 6. Billing (Strategy Pattern)
        // -------------------------------
        BillingContext billing = new BillingContext();
        billing.setStrategy(new MemberDiscountStrategy());

        double basePrice = room.getPricePerNight();
        double finalPrice = billing.executeBilling(basePrice);

        System.out.println("\nBilling:");
        System.out.println("Base Price: " + basePrice);
        System.out.println("Final Price: " + finalPrice);

        // -------------------------------
        // 7. Payment Processing (Adapter Pattern)
        // -------------------------------
        PaymentProcessor paymentProcessor =
                new PaymentAdapter(new LegacyPaymentSystem());

        paymentProcessor.pay(finalPrice);

        // -------------------------------
        // Final Output
        // -------------------------------
        System.out.println("\nSystem execution completed successfully.");
    }
}
