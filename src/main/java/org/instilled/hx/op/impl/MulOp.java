package org.instilled.hx.op.impl;

import org.instilled.hx.core.Num;
import org.instilled.hx.op.Op;

public class MulOp extends ArithOp
{
    public MulOp(Op l, Op r)
    {
        super(l, r);
    }

    public Num eval()
    {
        return _l.eval().mul(_r.eval());
    }
}
