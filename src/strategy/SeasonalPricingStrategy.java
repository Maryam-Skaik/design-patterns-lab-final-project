package strategy;

/**
 * Seasonal pricing increases or adjusts price
 * during high-demand periods.
 */
public class SeasonalPricingStrategy implements BillingStrategy {

    private static final double SEASONAL_RATE = 1.20;

    @Override
    public double calculate(double basePrice) {
        return basePrice * SEASONAL_RATE;
    }
}
