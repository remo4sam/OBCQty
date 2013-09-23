public enum UnitType {
    FOOT, INCH, YARD, MILE;

    public Measurement convert(int value) {
        Measurement convertedMeasurement;
        int FOOT_INCH_CONVERSION = 12;
        int YARD_INCH_CONVERSION = 3 * FOOT_INCH_CONVERSION;
        int MILE_INCH_CONVERSION = 1760 * YARD_INCH_CONVERSION;
        switch (this) {
            case FOOT:
                convertedMeasurement = new Measurement(value * FOOT_INCH_CONVERSION, UnitType.INCH);
                break;
            case YARD:
                convertedMeasurement = new Measurement(value * YARD_INCH_CONVERSION, UnitType.INCH);
                break;
            case MILE:
                convertedMeasurement = new Measurement(value * MILE_INCH_CONVERSION, UnitType.INCH);
                break;
            default:
                convertedMeasurement = new Measurement(value, UnitType.INCH);
                break;
        }

        return convertedMeasurement;
    }
}
