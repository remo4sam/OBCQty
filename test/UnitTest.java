import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

public class UnitTest {

    private Unit oneFoot;
    private Unit oneInch;

    @Before
    public void setUp(){
        oneFoot = new Unit(1, "foot");
    }

    @Test
    public void twoUnitsOfSameTypeAndValueShouldBeEqual(){
        assertThat(oneFoot, is(new Unit(1, "foot")));
    }

    @Test
    public void twoUnitsOfSameTypeAndDifferentValueShouldNotBeEqual(){
        assertThat(oneFoot, is(not(new Unit(2, "foot"))));
    }

    @Test
    public void twoUnitsOfDifferentTypeAndSameValueShouldNotBeEqual(){
        assertThat(oneFoot, is(not(new Unit(1, "inch"))));
    }

    @Test
    public void twoUnitsOfDifferentTypeAndDifferentValueShouldNotBeEqual(){
        assertThat(oneFoot, is(not(new Unit(2, "inch"))));
    }
}
