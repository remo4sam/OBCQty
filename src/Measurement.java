public class Measurement {
    private final int value;
    private final UnitType unitType;

    public Measurement(int value, UnitType unitType) {
        this.value = value;
        this.unitType = unitType;
    }

    public Measurement convert(){
        Measurement convertedMeasurement;
        int FOOT_INCH_CONVERSION = 12;
        int YARD_INCH_CONVERSION = 3 * FOOT_INCH_CONVERSION;
        int MILE_INCH_CONVERSION = 1760 * YARD_INCH_CONVERSION;
        switch (this.unitType) {
            case FOOT:
                convertedMeasurement = new Measurement(this.value * FOOT_INCH_CONVERSION, UnitType.INCH);
                break;
            case YARD:
                convertedMeasurement = new Measurement(this.value * YARD_INCH_CONVERSION, UnitType.INCH);
                break;
            case MILE:
                convertedMeasurement = new Measurement(this.value * MILE_INCH_CONVERSION, UnitType.INCH);
                break;
            default:
                convertedMeasurement = this;
                break;
        }

        return convertedMeasurement;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Measurement measurement = (Measurement) o;
        Measurement measurementConverted = measurement.convert();
        Measurement thisConverted = this.convert();

        if (thisConverted.value != measurementConverted.value) return false;
        if (!thisConverted.unitType.equals(measurementConverted.unitType)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = value;
        result = 31 * result + unitType.hashCode();
        return result;
    }
}
