package org.jcodec.codecs.common.biari;

public class Context {
    private int mps;
    private int stateIdx;

    public Context(int i, int i2) {
        this.stateIdx = i;
        this.mps = i2;
    }

    public int getState() {
        return this.stateIdx;
    }

    public int getMps() {
        return this.mps;
    }

    public void setMps(int i) {
        this.mps = i;
    }

    public void setState(int i) {
        this.stateIdx = i;
    }
}
