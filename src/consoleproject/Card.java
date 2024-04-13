package consoleproject;

public class Card {
    private Customer customer;
    private String holderName;
    private String PAN;
    private long PIN;
    private long CVV;

    public Card(Customer customer, String holderName, String PAN, long PIN, long CVV) {
        this.customer = customer;
        this.holderName = holderName;
        this.PAN = PAN;
        this.PIN = PIN;
        this.CVV = CVV;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getPAN() {
        return PAN;
    }

    public void setPAN(String PAN) {
        this.PAN = PAN;
    }

    public long getPIN() {
        return PIN;
    }

    public void setPIN(long PIN) {
        this.PIN = PIN;
    }

    public long getCVV() {
        return CVV;
    }

    public void setCVV(long CVV) {
        this.CVV = CVV;
    }



}
