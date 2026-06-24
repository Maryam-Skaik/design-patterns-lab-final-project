package strategy;

/**
 * Strategy interface for billing calculation.
 *
 * Each pricing strategy implements its own logic.
 * This allows runtime switching of billing behavior.
 */
public interface BillingStrategy {

    /**
     * Calculates final price based on base amount.
     */
    double calculate(double basePrice);
}
