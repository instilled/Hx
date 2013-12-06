package org.instilled.hx.op;

import org.instilled.hx.core.Num;

public interface Op
{
    Num eval();

    Computation compile();

    Op add(double r);

    Op add(Num r);

    Op add(Op r);

    Op sub(double r);

    Op sub(Num r);

    Op sub(Op r);

    Op mul(double r);

    Op mul(Num r);

    Op mul(Op r);

    Op div(double r);

    Op div(Num r);

    Op div(Op r);
}
