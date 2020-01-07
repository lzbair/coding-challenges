package io.training;

import org.junit.Assert;
import org.junit.Test;

public class PrisonBreakTest {

    @Test
    public void case_zero() {
        PrisonBreak prisonBreak = new PrisonBreak(Prison.unit(3, 3));
        int escape = prisonBreak.escape(new int[]{1, 3}, new int[]{});
        Assert.assertEquals(2, escape);
    }

    @Test
    public void case_one() {
        PrisonBreak prisonBreak = new PrisonBreak(Prison.unit(2, 2));
        int escape = prisonBreak.escape(new int[]{1}, new int[]{2});
        Assert.assertEquals(4, escape);
    }

    @Test
    public void case_two() {
        PrisonBreak prisonBreak = new PrisonBreak(Prison.unit(2, 3));
        int escape = prisonBreak.escape(new int[]{1, 2, 3}, new int[]{1, 2});
        Assert.assertEquals(12, escape);
    }


    @Test(expected = NullPointerException.class)
    public void case_error() {
        PrisonBreak prisonBreak = new PrisonBreak(Prison.unit(3, 3));
        int escape = prisonBreak.escape(null, null);
        Assert.assertEquals(2, escape);
    }
}
