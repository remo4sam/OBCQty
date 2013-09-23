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
    public void shouldConvertFeetToInches(){
        assertThat(oneFoot.convert(), is(new Measurement(12, UnitType.INCH)));
    }

    @Test
    public void oneFootShouldEqualsTwelveInches(){
        assertThat(oneFoot,is(new Measurement(12,UnitType.INCH)));
    }

    @Test
    public void oneYardShouldEqualsThreeFeet(){
        assertThat(new Measurement(1, UnitType.YARD),is(new Measurement(3,UnitType.FOOT)));
    }
}
