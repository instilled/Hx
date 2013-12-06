package org.instilled.hx.core;

public interface Num
{
    Num add(Num other);

    Num sub(Num other);

    Num mul(Num other);

    Num div(Num other);

    Num mod(Num other);

    double value();

    Num set(double val);

    Num set(Num eval);
}
