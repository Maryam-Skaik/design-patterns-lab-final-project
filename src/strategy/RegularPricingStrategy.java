package strategy;

/**
 * Default pricing strategy.
 *
 * No discounts or modifications applied.
 */
public class RegularPricingStrategy implements BillingStrategy {

    @Override
    public double calculate(double basePrice) {
        return basePrice;
    }
}
