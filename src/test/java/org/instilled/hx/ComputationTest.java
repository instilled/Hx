package org.instilled.hx;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.instilled.hx.op.Ops.num;

import org.instilled.hx.core.DoubleNum;
import org.instilled.hx.core.Num;
import org.instilled.hx.op.Algos;
import org.instilled.hx.op.Algos.Win;
import org.instilled.hx.op.Computation;
import org.junit.Test;

/**
 * 
 */
public class ComputationTest
{
    @Test
    public void testArithmeticsWork()
    {
        Computation comp;

        comp = num(2).add(2).compile();
        assertEquals(4d, comp.eval().value());

        comp = num(2).mul(3).compile();
        assertEquals(6d, comp.eval().value());

        comp = num(2).mul(3).add(1).compile();
        assertEquals(7d, comp.eval().value());

        comp = num(2).sub(1).mul(3).compile();
        assertEquals(3d, comp.eval().value());

        comp = num(2).add(4).div(2).compile();
        double expected = comp.eval().value();
        assertTrue(2.999 < expected && expected < 3.001);

        comp = num(2).add(1).mul(3).compile();
        assertEquals(9d, comp.eval().value());
    }

    @Test
    public void testNumberModificationWorks()
    {
        Computation comp;

        Num x = new DoubleNum(2);

        comp = num(x).add(2).compile();
        assertEquals(4d, comp.eval().value());

        x.set(3);
        assertEquals(5d, comp.eval().value());
    }

    @Test
    public void testStatefulOpWorks()
    {
        Num i = new DoubleNum(0);

        Computation comp = Algos.avg(num(i));

        i.set(1);
        assertEquals(1d, comp.eval().value(), 0.001);

        i.set(2);
        assertEquals(1.5, comp.eval().value(), 0.001);

        i.set(3);
        assertEquals(2d, comp.eval().value(), 0.001);

        i.set(4);
        assertEquals(2.5, comp.eval().value(), 0.001);
    }

    @Test
    public void testWindowedOpWorks()
    {
        Num i = new DoubleNum();

        Computation comp = Algos.avg(num(i), Win.FIXED(2));

        i.set(1);
        assertEquals(1d, comp.eval().value(), 0.001);

        i.set(2);
        assertEquals(1.5, comp.eval().value(), 0.001);

        i.set(3);
        assertEquals(2.5, comp.eval().value(), 0.001);

        i.set(4);
        assertEquals(3.5, comp.eval().value(), 0.001);
    }
}
