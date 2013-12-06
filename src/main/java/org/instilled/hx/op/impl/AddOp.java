package org.instilled.hx.op.impl;

import org.instilled.hx.core.Num;
import org.instilled.hx.op.Op;

public class AddOp extends ArithOp
{
    public AddOp(Op l, Op r)
    {
        super(l, r);
    }

    public Num eval()
    {
        return _l.eval().add(_r.eval());
    }
}
