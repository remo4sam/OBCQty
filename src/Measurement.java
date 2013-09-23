public class Measurement {
    private final int value;
    private final UnitType unitType;

    public Measurement(int value, UnitType unitType) {
        this.value = value;
        this.unitType = unitType;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Measurement measurement = (Measurement) o;
        Measurement measurementConverted = measurement.unitType.convert(measurement.value);
        Measurement thisConverted = unitType.convert(this.value);

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

    public Measurement add(Measurement measurement) throws MeasurementTypeException {
        Measurement measurementConverted = measurement.unitType.convert(measurement.value);
        Measurement thisConverted = unitType.convert(this.value);

        if(thisConverted.unitType != measurementConverted.unitType)
            throw new MeasurementTypeException("Types do not match");

        return new Measurement(thisConverted.value + measurementConverted.value,thisConverted.unitType);
    }
}
