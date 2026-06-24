package strategy;

/**
 * Context class for billing strategy.
 *
 * This class does NOT decide pricing logic.
 * It delegates calculation to the selected strategy.
 */
public class BillingContext {

    private BillingStrategy strategy;

    /**
     * Allows runtime switching of billing strategy.
     */
    public void setStrategy(BillingStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Executes billing using selected strategy.
     */
    public double executeBilling(double basePrice) {
        if (strategy == null) {
            throw new IllegalStateException("Billing strategy not set");
        }
        return strategy.calculate(basePrice);
    }
}
