public enum UnitType {
    FOOT(12), INCH(1), YARD(3 * 12), MILE(3 * 12 *1760);
    private int conversionFactor;

    UnitType(int conversionFactor) {

        this.conversionFactor = conversionFactor;
    }

    public Measurement convert(int value) {
        return new Measurement(value * this.conversionFactor, UnitType.INCH);
    }
}
