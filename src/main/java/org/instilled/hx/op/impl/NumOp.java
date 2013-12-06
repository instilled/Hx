package org.instilled.hx.op.impl;

import org.instilled.hx.core.Num;
import org.instilled.hx.op.Computation;
import org.instilled.hx.op.Op;
import org.instilled.hx.op.Ops;

public class NumOp implements Op
{
    private Num _num;

    public NumOp(Num num)
    {
        _num = num;
    }

    public Num eval()
    {
        return _num;
    }

    public Computation compile()
    {
        return new Computation(this);
    }

    public Op add(double r)
    {
        return add(Ops.num(r));
    }

    public Op add(Num r)
    {
        return add(Ops.num(r));
    }

    public Op add(Op r)
    {
        return Ops.add(this, r);
    }

    public Op sub(double r)
    {
        return sub(Ops.num(r));
    }

    public Op sub(Num r)
    {
        return sub(Ops.num(r));
    }

    public Op sub(Op r)
    {
        return Ops.sub(this, r);
    }

    public Op mul(double r)
    {
        return mul(Ops.num(r));
    }

    public Op mul(Num r)
    {
        return mul(Ops.num(r));
    }

    public Op mul(Op r)
    {
        return Ops.mul(this, r);
    }

    public Op div(double r)
    {
        return div(Ops.num(r));
    }

    public Op div(Num r)
    {
        return div(Ops.num(r));
    }

    public Op div(Op r)
    {
        return Ops.div(this, r);
    }

    @Override
    public String toString()
    {
        return String.format("%s [id: %s, val: %f]", //
                getClass().getSimpleName(), //
                Integer.toHexString(hashCode()), //
                _num.value());
    }
}
