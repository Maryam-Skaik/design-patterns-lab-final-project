package template;

/**
 * Concrete implementation of Check-In workflow.
 *
 * Defines specific behavior for guest check-in process.
 */
public class CheckInWorkflow extends HotelWorkflow {

    @Override
    protected void authenticateGuest() {
        System.out.println("Checking guest identity for check-in...");
    }

    @Override
    protected void prepareResources() {
        System.out.println("Preparing room for guest...");
    }

    @Override
    protected void performMainAction() {
        System.out.println("Assigning room and completing check-in...");
    }

    @Override
    protected void finalizeWorkflow() {
        System.out.println("Finalizing check-in process...");
    }

    @Override
    protected void sendNotification() {
        System.out.println("Check-in completed notification sent.");
    }
}
