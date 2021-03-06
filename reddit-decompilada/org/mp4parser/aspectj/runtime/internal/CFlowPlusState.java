package org.mp4parser.aspectj.runtime.internal;

import org.mp4parser.aspectj.runtime.CFlow;

public class CFlowPlusState extends CFlow {
    private Object[] state;

    public CFlowPlusState(Object[] objArr) {
        this.state = objArr;
    }

    public CFlowPlusState(Object[] objArr, Object obj) {
        super(obj);
        this.state = objArr;
    }

    public Object get(int i) {
        return this.state[i];
    }
}
