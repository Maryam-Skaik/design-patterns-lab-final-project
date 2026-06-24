package adapter;

/**
 * Legacy payment system (existing external system).
 *
 * This class cannot be modified.
 * It uses an incompatible interface.
 */
public class LegacyPaymentSystem {

    /**
     * Old payment method with different naming and contract.
     */
    public void makePayment(double amountInUSD) {
        System.out.println("Legacy system processing payment: $" + amountInUSD);
    }
}
