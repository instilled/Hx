package org.instilled.hx.renderer;

import org.instilled.dotter.Dotter;
import org.instilled.dotter.dom.Dot;
import org.instilled.hx.op.Computation;
import org.instilled.hx.op.Op;
import org.instilled.hx.op.impl.ArithOp;
import org.instilled.hx.op.impl.StatefulOp.AssignOp;

public final class OpRenderer
{
    private static int edgeCnt = 0;

    public static Dot renderOp(String graphName, Op op)
    {
        return _renderOp(Dotter.graph(graphName), op);
    }

    private static Dot _renderOp(Dot dot, Op op)
    {
        if (op instanceof ArithOp)
        {
            ArithOp a = (ArithOp) op;

            _renderOp(dot, a.l());
            dot.edge(nodeId(a), nodeId(a.l())).attr("id",
                    edgeCnt++ + "");

            _renderOp(dot, a.r());
            dot.edge(nodeId(a), nodeId(a.r()));
        } else if (op instanceof AssignOp)
        {
            AssignOp a = (AssignOp) op;

            dot.node(nodeId(a)).attr("shape", "box");

            _renderOp(dot, a.to());
            dot.edge(nodeId(a), nodeId(a.to())).lineDashed().lineArrowTail();//

            _renderOp(dot, a.from());
            dot.edge(nodeId(a), nodeId(a.from()));
        } else if (op instanceof Computation)
        {
            Computation c = (Computation) op;

            // TODO dot needs support for subgraphs
            Op op1 = c.ops()[0];
            _renderOp(dot, op1);
        }

        return dot;
    }

    private static String nodeId(Op op)
    {
        return String.format("%s#%d", //
                op.getClass().getSimpleName(), //
                op.hashCode());

    }
}
