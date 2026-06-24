package strategy;

/**
 * Applies discount for registered members.
 */
public class MemberDiscountStrategy implements BillingStrategy {

    private static final double DISCOUNT_RATE = 0.85;

    @Override
    public double calculate(double basePrice) {
        return basePrice * DISCOUNT_RATE;
    }
}
