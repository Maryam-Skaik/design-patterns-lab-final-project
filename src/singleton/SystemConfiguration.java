package singleton;

/**
 * Singleton Pattern (System Configuration Manager)
 *
 * Ensures a single global instance for storing
 * system-wide configuration data.
 *
 * Used across the entire SHMS application.
 */
public class SystemConfiguration {

    // The single instance (lazy initialization)
    private static SystemConfiguration instance;

    // Configuration data
    private String hotelName;
    private double taxRate;
    private String currency;

    /**
     * Private constructor prevents external instantiation.
     */
    private SystemConfiguration() {
        // Default system settings (can be loaded from file later)
        this.hotelName = "SHMS Hotel";
        this.taxRate = 0.10;
        this.currency = "USD";
    }

    /**
     * Global access point to the single instance.
     */
    public static synchronized SystemConfiguration getInstance() {
        if (instance == null) {
            instance = new SystemConfiguration();
        }
        return instance;
    }

    // ---------------- Getters & Setters ----------------

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    // ---------------- Utility ----------------

    @Override
    public String toString() {
        return "SystemConfiguration{" +
                "hotelName='" + hotelName + '\'' +
                ", taxRate=" + taxRate +
                ", currency='" + currency + '\'' +
                '}';
    }
}
