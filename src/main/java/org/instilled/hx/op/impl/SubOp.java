package org.instilled.hx.op.impl;

import org.instilled.hx.core.Num;
import org.instilled.hx.op.Op;

public class SubOp extends ArithOp
{
    public SubOp(Op l, Op r)
    {
        super(l, r);
    }

    public Num eval()
    {
        return _l.eval().sub(_r.eval());
    }
}
