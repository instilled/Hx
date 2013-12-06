package org.instilled.hx.core;

public class DoubleNum implements Num
{
    private double _val;

    public DoubleNum(double value)
    {
        _val = value;
    }

    public DoubleNum()
    {
        this(0);
    }

    public Num add(Num other)
    {
        return new DoubleNum(_val + other.value());
    }

    public Num sub(Num other)
    {
        return new DoubleNum(_val - other.value());
    }

    public Num mul(Num other)
    {
        return new DoubleNum(_val * other.value());
    }

    public Num div(Num other)
    {
        return new DoubleNum(_val / other.value());
    }

    public Num mod(Num other)
    {
        return new DoubleNum(_val % other.value());
    }

    public double value()
    {
        return _val;
    }

    public Num set(double i)
    {
        _val = i;
        return this;
    }

    public Num set(Num i)
    {
        _val = i.value();
        return this;
    }

    @Override
    public String toString()
    {
        return String.format("%s [id: %s, val: %f]", //
                getClass().getSimpleName(), //
                Integer.toHexString(hashCode()), //
                _val);
    }
}
