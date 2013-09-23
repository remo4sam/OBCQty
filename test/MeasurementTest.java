import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

public class MeasurementTest {

    private Measurement oneFoot;

    @Before
    public void setUp(){
        oneFoot = new Measurement(1, UnitType.FOOT);
    }

    @Test
    public void twoUnitsOfSameTypeAndValueShouldBeEqual(){
        assertThat(oneFoot, is(new Measurement(1, UnitType.FOOT)));
    }

    @Test
    public void twoUnitsOfSameTypeAndDifferentValueShouldNotBeEqual(){
        assertThat(oneFoot, is(not(new Measurement(2, UnitType.FOOT))));
    }

    @Test
    public void twoUnitsOfDifferentTypeAndSameValueShouldNotBeEqual(){
        assertThat(oneFoot, is(not(new Measurement(1, UnitType.INCH))));
    }

    @Test
    public void twoUnitsOfDifferentTypeAndDifferentValueShouldNotBeEqual(){
        assertThat(oneFoot, is(not(new Measurement(2, UnitType.INCH))));
    }

    @Test
    public void oneFootShouldEqualsTwelveInches(){
        assertThat(oneFoot,is(new Measurement(12,UnitType.INCH)));
    }

    @Test
    public void oneYardShouldEqualsThreeFeet(){
        assertThat(new Measurement(1, UnitType.YARD),is(new Measurement(3,UnitType.FOOT)));
    }

    @Test
    public void threeFeetShouldEqualOneYard(){
        assertThat(new Measurement(3, UnitType.FOOT),is(new Measurement(1,UnitType.YARD)));
    }

    @Test
    public void oneMileShouldEqual1760Yards(){
        assertThat(new Measurement(1, UnitType.MILE), is(new Measurement(1760,UnitType.YARD)));
    }
    @Test
    public void oneTableSpoonEqualsThreeTeaSpoons(){
        assertThat(new Measurement(1,UnitType.TABLESPOON),is(new Measurement(3,UnitType.TEASPOON)));
    }

    @Test
    public void oneOunceEqualsTwoTableSpoons(){
        assertThat(new Measurement(1,UnitType.OUNCE),is(new Measurement(2,UnitType.TABLESPOON)));
    }

    @Test
    public void oneCupEqualsEightOunces(){
        assertThat(new Measurement(1,UnitType.CUP),is(new Measurement(8,UnitType.OUNCE)));
    }

    @Test
    public void oneCupNotEqualsOneFoot(){
        assertThat(new Measurement(1,UnitType.CUP),is(not(new Measurement(1,UnitType.FOOT))));
    }

    @Test
    public void sumOfOneFootAndThreeInchesIsFifteenInches() throws MeasurementTypeException{
        assertThat(oneFoot.add(new Measurement(3,UnitType.INCH)),is(new Measurement(15, UnitType.INCH)));
    }

    @Test(expected = MeasurementTypeException.class)
    public void sumOfOneFootAndOneCupThrowsATypeException() throws MeasurementTypeException{
        oneFoot.add(new Measurement(1,UnitType.CUP));
    }


}
