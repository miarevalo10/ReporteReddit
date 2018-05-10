package org.jcodec.codecs.h264.encode;

import org.jcodec.common.tools.MathUtil;

public class H264FixedRateControl implements RateControl {
    private static final int INIT_QP = 26;
    private int balance;
    private int curQp = 26;
    private int perMb;

    public int getInitQp() {
        return 26;
    }

    public H264FixedRateControl(int i) {
        this.perMb = i;
    }

    public int getQpDelta() {
        int i = 2;
        if (this.balance >= 0) {
            i = this.balance > this.perMb ? this.balance > (this.perMb << 2) ? -2 : -1 : 0;
        } else if (this.balance >= (-(this.perMb >> 1))) {
            i = 1;
        }
        int i2 = this.curQp;
        this.curQp = MathUtil.clip(this.curQp + i, 12, 30);
        return this.curQp - i2;
    }

    public boolean accept(int i) {
        this.balance += this.perMb - i;
        return true;
    }

    public void reset() {
        this.balance = 0;
        this.curQp = 26;
    }

    public int calcFrameSize(int i) {
        return ((256 + ((this.perMb + 9) * i)) >> 3) + (i >> 6);
    }

    public void setRate(int i) {
        this.perMb = i;
    }
}
