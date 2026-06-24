package template;

/**
 * Concrete implementation of Check-Out workflow.
 *
 * Defines specific behavior for guest check-out process.
 */
public class CheckOutWorkflow extends HotelWorkflow {

    @Override
    protected void authenticateGuest() {
        System.out.println("Verifying guest for check-out...");
    }

    @Override
    protected void prepareResources() {
        System.out.println("Preparing invoice and cleaning schedule...");
    }

    @Override
    protected void performMainAction() {
        System.out.println("Processing check-out and returning key...");
    }

    @Override
    protected void finalizeWorkflow() {
        System.out.println("Closing billing and room record...");
    }

    @Override
    protected void sendNotification() {
        System.out.println("Check-out completed notification sent.");
    }
}
