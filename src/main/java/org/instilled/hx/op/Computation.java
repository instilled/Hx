package org.instilled.hx.op;

import org.instilled.hx.core.Num;

public class Computation implements Op
{
    private Op[] _ops;

    public Computation(Op... ops)
    {
        _ops = ops;
    }

    public Op[] ops()
    {
        return _ops;
    }

    public Num eval()
    {
        Num n = _ops[0].eval();
        for (int i = 1; i < _ops.length; i++)
        {
            _ops[i].eval();
        }

        return n;
    }

    public Computation compile()
    {
        throw new IllegalStateException("Not implemented");
    }

    public Op add(double r)
    {
        throw new IllegalStateException("Not implemented");
    }

    public Op add(Num r)
    {
        throw new IllegalStateException("Not implemented");
    }

    public Op add(Op r)
    {
        throw new IllegalStateException("Not implemented");
    }

    public Op sub(double r)
    {
        throw new IllegalStateException("Not implemented");
    }

    public Op sub(Num r)
    {
        throw new IllegalStateException("Not implemented");
    }

    public Op sub(Op r)
    {
        throw new IllegalStateException("Not implemented");
    }

    public Op mul(double r)
    {
        throw new IllegalStateException("Not implemented");
    }

    public Op mul(Num r)
    {
        throw new IllegalStateException("Not implemented");
    }

    public Op mul(Op r)
    {
        throw new IllegalStateException("Not implemented");
    }

    public Op div(double r)
    {
        throw new IllegalStateException("Not implemented");
    }

    public Op div(Num r)
    {
        throw new IllegalStateException("Not implemented");
    }

    public Op div(Op r)
    {
        throw new IllegalStateException("Not implemented");
    }
}
