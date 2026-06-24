package adapter;

/**
 * Adapter Pattern implementation.
 *
 * This class adapts the LegacyPaymentSystem
 * to the modern PaymentProcessor interface.
 */
public class PaymentAdapter implements PaymentProcessor {

    private final LegacyPaymentSystem legacySystem;

    public PaymentAdapter(LegacyPaymentSystem legacySystem) {
        this.legacySystem = legacySystem;
    }

    @Override
    public void pay(double amount) {
        // Translation layer between new system and legacy system
        legacySystem.makePayment(amount);
    }
}
