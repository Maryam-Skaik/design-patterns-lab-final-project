package adapter;

/**
 * Target interface used by the modern system.
 *
 * The system depends on this interface, not the legacy implementation.
 */
public interface PaymentProcessor {

    /**
     * Processes a payment using modern system contract.
     */
    void pay(double amount);
}
