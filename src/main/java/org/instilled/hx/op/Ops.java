package org.instilled.hx.op;

import org.instilled.hx.core.DoubleNum;
import org.instilled.hx.core.Num;
import org.instilled.hx.op.impl.AddOp;
import org.instilled.hx.op.impl.DivOp;
import org.instilled.hx.op.impl.MulOp;
import org.instilled.hx.op.impl.NumOp;
import org.instilled.hx.op.impl.StatefulOp;
import org.instilled.hx.op.impl.SubOp;

public class Ops
{
    private Ops()
    {
        // private constructor
    }

    public static Op num(double i)
    {
        return num(new DoubleNum(i));
    }

    public static Op num(Num i)
    {
        return new NumOp(i);
    }

    public static StatefulOp acc(double i)
    {
        return new StatefulOp(new DoubleNum(i));
    }

    public static Op add(Op l, double r)
    {
        return new AddOp(l, num(r));
    }

    public static Op add(Op l, Op r)
    {
        return new AddOp(l, r);
    }

    public static Op sub(Op l, Op r)
    {
        return new SubOp(l, r);
    }

    public static Op mul(Op l, Op r)
    {
        return new MulOp(l, r);
    }

    public static Op div(Op l, Op r)
    {
        return new DivOp(l, r);
    }
}
