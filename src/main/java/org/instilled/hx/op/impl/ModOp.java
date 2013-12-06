package org.instilled.hx.op.impl;

import org.instilled.hx.core.Num;
import org.instilled.hx.op.Op;

public class ModOp extends ArithOp
{
    protected ModOp(Op l, Op r)
    {
        super(l, r);
    }

    public Num eval()
    {
        return _l.eval().mod(_r.eval());
    }
}
