public class Measurement {
    private final int value;
    private final UnitType unitType;

    public Measurement(int value, UnitType unitType) {
        this.value = value;
        this.unitType = unitType;
    }

    public Measurement convert(){
        if(this.unitType == UnitType.INCH)
            return this;
        else{
            int FOOT_INCH_CONVERSION = 12;
            return new Measurement(this.value * FOOT_INCH_CONVERSION, UnitType.INCH);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Measurement measurement = (Measurement) o;

        if (value != measurement.value) return false;
        if (!unitType.equals(measurement.unitType)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = value;
        result = 31 * result + unitType.hashCode();
        return result;
    }
}
