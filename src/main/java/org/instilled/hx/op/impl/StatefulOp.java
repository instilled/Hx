package org.instilled.hx.op.impl;

import org.instilled.hx.core.Num;
import org.instilled.hx.op.Computation;
import org.instilled.hx.op.Op;
import org.instilled.hx.op.Ops;

public class StatefulOp implements Op
{
    private Num _i;

    public StatefulOp(Num init)
    {
        _i = init;
    }

    public Num eval()
    {
        return _i;
    }

    public Computation compile()
    {
        return null;
    }

    public Op add(double r)
    {
        return add(Ops.num(r));
    }

    public Op add(Num r)
    {
        return add(Ops.num(r));
    }

    public Op add(Op r)
    {
        return Ops.add(this, r);
    }

    public Op addAndAssign(double r)
    {
        return addAndAssign(Ops.num(r));
    }

    public Op addAndAssign(Op r)
    {
        return AssignOp.assign(this, Ops.add(this, r));
    }

    public Op sub(double r)
    {
        return sub(Ops.num(r));
    }

    public Op sub(Num r)
    {
        return sub(Ops.num(r));
    }

    public Op sub(Op r)
    {
        return AssignOp.assign(this, Ops.sub(this, r));
    }

    public Op mul(double r)
    {
        return mul(Ops.num(r));
    }

    public Op mul(Num r)
    {
        return mul(Ops.num(r));
    }

    public Op mul(Op r)
    {
        return Ops.mul(this, r);
    }

    public Op mulAndAssign(Op r)
    {
        return AssignOp.assign(this, Ops.mul(this, r));
    }

    public Op div(double r)
    {
        return div(Ops.num(r));
    }

    public Op div(Num r)
    {
        return div(Ops.num(r));
    }

    public Op div(Op r)
    {
        return AssignOp.assign(this, Ops.div(this, r));
    }

    public Op assign(Op from)
    {
        return AssignOp.assign(this, from);
    }

    public static class AssignOp implements Op
    {
        private StatefulOp _to;
        private Op _from;

        public static Op assign(StatefulOp to, Op from)
        {
            return new AssignOp(to, from);
        }

        private AssignOp(StatefulOp to, Op from)
        {
            _to = to;
            _from = from;
        }

        public Num eval()
        {
            return _to._i.set(_from.eval());
        }

        public Computation compile()
        {
            return new Computation(this);
        }

        public Op add(double r)
        {
            return add(Ops.num(r));
        }

        public Op add(Num r)
        {
            return add(Ops.num(r));
        }

        public Op add(Op r)
        {
            return new AssignOp(_to, Ops.add(_to, r));
        }

        public Op sub(double r)
        {
            return sub(Ops.num(r));
        }

        public Op sub(Num r)
        {
            return sub(Ops.num(r));
        }

        public Op sub(Op r)
        {
            return new AssignOp(_to, Ops.sub(_to, r));
        }

        public Op mul(double r)
        {
            return mul(Ops.num(r));
        }

        public Op mul(Num r)
        {
            return mul(Ops.num(r));
        }

        public Op mul(Op r)
        {
            return new AssignOp(_to, Ops.mul(_to, r));
        }

        public Op div(double r)
        {
            return div(Ops.num(r));
        }

        public Op div(Num r)
        {
            return div(Ops.num(r));
        }

        public Op div(Op r)
        {
            return new AssignOp(_to, Ops.div(_to, r));

        }

        public Op from()
        {
            return _from;
        }

        public Op to()
        {
            return _to;
        }
    }
}
