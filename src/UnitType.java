public enum UnitType {
    INCH(1),FOOT(12,INCH) , YARD(3 * 12,INCH), MILE(3 * 12 *1760,INCH),
    TEASPOON(1), TABLESPOON(3,TEASPOON),OUNCE(2*3,TEASPOON),CUP(8*2*3,TEASPOON);
    private int conversionFactor;
    private UnitType conversionBase;

    UnitType(int conversionFactor,UnitType conversionBase) {

        this.conversionFactor = conversionFactor;
        this.conversionBase = conversionBase;
    }

     UnitType(int conversionFactor) {
         this.conversionFactor = conversionFactor;
         this.conversionBase=this;
     }

    public Measurement convert(int value) {
        return new Measurement(value * this.conversionFactor, this.conversionBase);
    }
}
                                               