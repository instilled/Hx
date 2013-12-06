package org.instilled.hx.op.impl;

import static org.instilled.hx.op.Ops.num;

import org.instilled.hx.core.Num;
import org.instilled.hx.op.Computation;
import org.instilled.hx.op.Op;
import org.instilled.hx.op.Ops;

public abstract class ArithOp implements Op
{
    protected Op _l;
    protected Op _r;

    protected ArithOp(Op l, Op r)
    {
        _l = l;
        _r = r;
    }

    public Op l()
    {
        return _l;
    }

    public Op r()
    {
        return _r;
    }

    public Computation compile()
    {
        return new Computation(this);
    }

    // public final Op addAndSet(double r)
    // {
    // if (!(this instanceof StatefulOp))
    // {
    // throw new IllegalStateException(String.format(
    // "addAndSet not supported for class %s", getClass()
    // .getSimpleName()));
    // }
    //
    // StatefulOp op = (StatefulOp) this;
    // Op res = add(this, num(r));
    // return op.set(res);
    // }

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
