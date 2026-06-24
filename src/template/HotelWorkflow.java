package template;

/**
 * Template Method Pattern (Abstract Class)
 *
 * Defines the skeleton of a hotel workflow.
 * The execution order is fixed and cannot be changed.
 *
 * Subclasses implement specific steps.
 */
public abstract class HotelWorkflow {

    /**
     * Template Method (final to prevent modification)
     *
     * Defines the fixed workflow execution order.
     */
    public final void executeWorkflow() {

        authenticateGuest();
        prepareResources();
        performMainAction();
        finalizeWorkflow();
        sendNotification();
    }

    protected abstract void authenticateGuest();

    protected abstract void prepareResources();

    protected abstract void performMainAction();

    protected abstract void finalizeWorkflow();

    /**
     * Common step shared across all workflows.
     */
    protected void sendNotification() {
        System.out.println("Sending default workflow notification...");
    }
}
