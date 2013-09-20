public class Unit {
    private final int unitSize;
    private final String unitType;

    public Unit(int unitSize, String unitType) {
        this.unitSize = unitSize;
        this.unitType = unitType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Unit unit = (Unit) o;

        if (unitSize != unit.unitSize) return false;
        if (!unitType.equals(unit.unitType)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = unitSize;
        result = 31 * result + unitType.hashCode();
        return result;
    }
}
