package org.instilled.hx.op.impl;

import org.instilled.hx.core.Num;
import org.instilled.hx.op.Op;

public class DivOp extends ArithOp
{
    public DivOp(Op l, Op r)
    {
        super(l, r);
    }

    public Num eval()
    {
        return _l.eval().div(_r.eval());
    }
}
