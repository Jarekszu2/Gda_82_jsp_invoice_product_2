package packModel;

public enum  TaxType {
    PRODUCT(0.23),
    SERVICE(0.08);

    private double value;

    TaxType(double value) {
        this.value = value;
    }
}
