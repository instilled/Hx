package org.instilled.hx.op;

import static org.instilled.hx.op.Ops.acc;

import org.instilled.hx.core.Num;
import org.instilled.hx.op.impl.AbstractOp;
import org.instilled.hx.op.impl.StatefulOp;

public final class Algos
{
    /**
     * Generate an average computing dataflow with <code>x</code> as its
     * input. Updating <code>x</code> and calling
     * {@link Computation#eval()} will make the "data flow" exactly one
     * step.
     * 
     * @param x
     * 
     * @return An average computing dataflow graph.
     */
    public static Computation avg(Op x)
    {
        StatefulOp i = acc(0);
        StatefulOp avg = acc(0);

        // AVG_i+1 = (x_i+1 + i * AVG_i) / (i + 1)
        return avg.assign(//
                x.add(i.mul(avg)).div(i.addAndAssign(1)))//
                .compile();
    }

    public static Computation avg(Op x, Win win)
    {
        new WinOp(x)
        {
            public Num eval()
            {
                
                return null;
            }
        };

        return null;
    }

    public abstract static class WinOp extends AbstractOp
    {
        protected Op _in;

        public WinOp(Op in)
        {
            _in = in;
        }

        public Computation compile()
        {
            return new Computation(this);
        }
    }

    public static class Win
    {
        public static Win FIXED(int ticks)
        {
            return null;
        }

        public static Win REL(long millisec)
        {
            return null;
        }
    }
}
