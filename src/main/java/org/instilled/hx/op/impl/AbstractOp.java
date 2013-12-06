package org.instilled.hx.op.impl;

import static org.instilled.hx.op.Ops.num;

import org.instilled.hx.core.Num;
import org.instilled.hx.op.Op;
import org.instilled.hx.op.Ops;

public abstract class AbstractOp implements Op
{
    public final Op add(double r)
    {
        return add(num(r));
    }

    public final Op add(Num r)
    {
        return add(num(r));
    }

    public final Op add(Op r)
    {
        return Ops.add(this, r);
    }

    public final Op sub(double r)
    {
        return sub(num(r));
    }

    public final Op sub(Num r)
    {
        return sub(num(r));
    }

    public final Op sub(Op r)
    {
        return Ops.sub(this, r);
    }

    public final Op mul(double r)
    {
        return mul(num(r));
    }

    public final Op mul(Num r)
    {
        return mul(num(r));
    }

    public final Op mul(Op r)
    {
        return Ops.mul(this, r);
    }

    public final Op div(double r)
    {
        return div(num(r));
    }

    public final Op div(Num r)
    {
        return div(num(r));
    }

    public final Op div(Op r)
    {
        return Ops.div(this, r);
    }
}
