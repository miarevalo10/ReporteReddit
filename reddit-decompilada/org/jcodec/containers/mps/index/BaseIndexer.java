package org.jcodec.containers.mps.index;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.jcodec.codecs.mjpeg.JpegConst;
import org.jcodec.common.ArrayUtil;
import org.jcodec.common.IntArrayList;
import org.jcodec.common.LongArrayList;
import org.jcodec.common.RunLength.Integer;
import org.jcodec.common.logging.Logger;
import org.jcodec.common.tools.MathUtil;
import org.jcodec.containers.mps.MPSDemuxer.PESPacket;
import org.jcodec.containers.mps.MPSUtils.PESReader;
import org.jcodec.containers.mps.index.MPSIndex.MPSStreamIndex;

public abstract class BaseIndexer extends PESReader {
    private Map<Integer, BaseAnalyser> analyzers = new HashMap();
    private Integer streams = new Integer();
    private LongArrayList tokens = new LongArrayList();

    protected abstract class BaseAnalyser {
        protected IntArrayList dur = new IntArrayList(250000);
        protected IntArrayList pts = new IntArrayList(250000);

        public abstract void finishAnalyse();

        public abstract void pkt(ByteBuffer byteBuffer, PESPacket pESPacket);

        public abstract MPSStreamIndex serialize(int i);

        protected BaseAnalyser() {
        }

        public int estimateSize() {
            return (this.pts.size() << 2) + 4;
        }
    }

    private class GenericAnalyser extends BaseAnalyser {
        final /* synthetic */ BaseIndexer f33289a;
        private IntArrayList f33290b;
        private int f33291c;
        private long f33292d;

        public void finishAnalyse() {
        }

        private GenericAnalyser(BaseIndexer baseIndexer) {
            this.f33289a = baseIndexer;
            super();
            this.f33290b = new IntArrayList(250000);
        }

        public void pkt(ByteBuffer byteBuffer, PESPacket pESPacket) {
            this.f33290b.add(byteBuffer.remaining());
            if (pESPacket.pts == -1) {
                pESPacket.pts = this.f33292d + ((long) this.f33291c);
            } else {
                this.f33291c = (int) (pESPacket.pts - this.f33292d);
                this.f33292d = pESPacket.pts;
            }
            this.pts.add((int) pESPacket.pts);
            this.dur.add(this.f33291c);
        }

        public MPSStreamIndex serialize(int i) {
            return new MPSStreamIndex(i, this.f33290b.toArray(), this.pts.toArray(), this.dur.toArray(), new int[0]);
        }

        public int estimateSize() {
            return (super.estimateSize() + (this.f33290b.size() << 2)) + 32;
        }
    }

    private class MPEGVideoAnalyser extends BaseAnalyser {
        final /* synthetic */ BaseIndexer f33293a;
        private int f33294b;
        private long f33295c;
        private IntArrayList f33296d;
        private IntArrayList f33297e;
        private int f33298f;
        private boolean f33299g;
        private Frame f33300h;
        private List<Frame> f33301i;
        private long f33302j;
        private Frame f33303k;

        class C22121 implements Comparator<Frame> {
            final /* synthetic */ MPEGVideoAnalyser f26827a;

            C22121(MPEGVideoAnalyser mPEGVideoAnalyser) {
                this.f26827a = mPEGVideoAnalyser;
            }

            public /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                Frame frame = (Frame) obj;
                Frame frame2 = (Frame) obj2;
                if (frame.f26831d > frame2.f26831d) {
                    return 1;
                }
                return frame.f26831d == frame2.f26831d ? null : -1;
            }
        }

        private class Frame {
            long f26828a;
            int f26829b;
            int f26830c;
            int f26831d;
            final /* synthetic */ MPEGVideoAnalyser f26832e;

            private Frame(MPEGVideoAnalyser mPEGVideoAnalyser) {
                this.f26832e = mPEGVideoAnalyser;
            }
        }

        private MPEGVideoAnalyser(BaseIndexer baseIndexer) {
            this.f33293a = baseIndexer;
            super();
            this.f33294b = -1;
            this.f33296d = new IntArrayList(250000);
            this.f33297e = new IntArrayList(20000);
            this.f33301i = new ArrayList();
            this.f33302j = -1;
        }

        public void pkt(ByteBuffer byteBuffer, PESPacket pESPacket) {
            MPEGVideoAnalyser mPEGVideoAnalyser = this;
            PESPacket pESPacket2 = pESPacket;
            while (byteBuffer.hasRemaining()) {
                int i = byteBuffer.get() & 255;
                mPEGVideoAnalyser.f33295c++;
                mPEGVideoAnalyser.f33294b = (mPEGVideoAnalyser.f33294b << 8) | i;
                long j = -1;
                if (mPEGVideoAnalyser.f33302j != -1) {
                    long j2 = mPEGVideoAnalyser.f33295c - mPEGVideoAnalyser.f33302j;
                    if (j2 == 5) {
                        mPEGVideoAnalyser.f33300h.f26831d = i << 2;
                    } else if (j2 == 6) {
                        int i2 = (i >> 3) & 7;
                        Frame frame = mPEGVideoAnalyser.f33300h;
                        frame.f26831d = (i >> 6) | frame.f26831d;
                        if (i2 == 1) {
                            mPEGVideoAnalyser.f33297e.add(mPEGVideoAnalyser.f33298f - 1);
                            if (mPEGVideoAnalyser.f33301i.size() > 0) {
                                m33887a();
                            }
                        }
                    }
                }
                if ((mPEGVideoAnalyser.f33294b & -256) == 256) {
                    if (mPEGVideoAnalyser.f33299g && (mPEGVideoAnalyser.f33294b == 256 || mPEGVideoAnalyser.f33294b > 431)) {
                        mPEGVideoAnalyser.f33300h.f26829b = (int) ((mPEGVideoAnalyser.f33295c - 4) - mPEGVideoAnalyser.f33300h.f26828a);
                        mPEGVideoAnalyser.f33301i.add(mPEGVideoAnalyser.f33300h);
                        mPEGVideoAnalyser.f33300h = null;
                        mPEGVideoAnalyser.f33299g = false;
                    } else if (!mPEGVideoAnalyser.f33299g && mPEGVideoAnalyser.f33294b > 256 && mPEGVideoAnalyser.f33294b <= 431) {
                        mPEGVideoAnalyser.f33299g = true;
                    }
                    if (mPEGVideoAnalyser.f33300h == null && (mPEGVideoAnalyser.f33294b == 435 || mPEGVideoAnalyser.f33294b == 440 || mPEGVideoAnalyser.f33294b == 256)) {
                        Frame frame2 = new Frame();
                        frame2.f26830c = (int) pESPacket2.pts;
                        frame2.f26828a = mPEGVideoAnalyser.f33295c - 4;
                        Logger.info(String.format("FRAME[%d]: %012x, %d", new Object[]{Integer.valueOf(mPEGVideoAnalyser.f33298f), Long.valueOf((pESPacket2.pos + ((long) byteBuffer.position())) - 4), Long.valueOf(pESPacket2.pts)}));
                        mPEGVideoAnalyser.f33298f++;
                        mPEGVideoAnalyser.f33300h = frame2;
                    }
                    if (mPEGVideoAnalyser.f33300h != null && mPEGVideoAnalyser.f33300h.f26830c == -1 && mPEGVideoAnalyser.f33294b == 256) {
                        mPEGVideoAnalyser.f33300h.f26830c = (int) pESPacket2.pts;
                    }
                    if (mPEGVideoAnalyser.f33294b == 256) {
                        j = mPEGVideoAnalyser.f33295c - 4;
                    }
                    mPEGVideoAnalyser.f33302j = j;
                }
            }
        }

        private void m33887a() {
            int i;
            Frame[] frameArr = (Frame[]) this.f33301i.toArray(new Frame[0]);
            Arrays.sort(frameArr, new C22121(this));
            for (i = 0; i < 3; i++) {
                int i2 = -1;
                int i3 = i2;
                int i4 = i3;
                int i5 = i4;
                for (int i6 = 0; i6 < frameArr.length; i6++) {
                    if (!(frameArr[i6].f26830c != -1 || i2 == -1 || i3 == -1)) {
                        frameArr[i6].f26830c = ((i2 - i3) / MathUtil.abs(i4 - i5)) + i2;
                    }
                    if (frameArr[i6].f26830c != -1) {
                        int i7 = frameArr[i6].f26830c;
                        i3 = i2;
                        i2 = i7;
                        i5 = i4;
                        i4 = frameArr[i6].f26831d;
                    }
                }
                ArrayUtil.reverse(frameArr);
            }
            if (this.f33303k != null) {
                this.dur.add(frameArr[0].f26830c - this.f33303k.f26830c);
            }
            for (i = 1; i < frameArr.length; i++) {
                this.dur.add(frameArr[i].f26830c - frameArr[i - 1].f26830c);
            }
            this.f33303k = frameArr[frameArr.length - 1];
            for (Frame frame : this.f33301i) {
                this.f33296d.add(frame.f26829b);
                this.pts.add(frame.f26830c);
            }
            this.f33301i.clear();
        }

        public void finishAnalyse() {
            if (this.f33300h != null) {
                this.f33300h.f26829b = (int) (this.f33295c - this.f33300h.f26828a);
                this.f33301i.add(this.f33300h);
                m33887a();
            }
        }

        public MPSStreamIndex serialize(int i) {
            return new MPSStreamIndex(i, this.f33296d.toArray(), this.pts.toArray(), this.dur.toArray(), this.f33297e.toArray());
        }
    }

    public int estimateSize() {
        int size = ((this.tokens.size() << 3) + this.streams.estimateSize()) + 128;
        for (Integer num : this.analyzers.keySet()) {
            size += ((BaseAnalyser) this.analyzers.get(num)).estimateSize();
        }
        return size;
    }

    protected BaseAnalyser getAnalyser(int i) {
        if (((BaseAnalyser) this.analyzers.get(Integer.valueOf(i))) == null) {
            Object genericAnalyser = (i < JpegConst.APP0 || i > JpegConst.APPF) ? new GenericAnalyser() : new MPEGVideoAnalyser();
            this.analyzers.put(Integer.valueOf(i), genericAnalyser);
        }
        return (BaseAnalyser) this.analyzers.get(Integer.valueOf(i));
    }

    public MPSIndex serialize() {
        List arrayList = new ArrayList();
        for (Entry entry : this.analyzers.entrySet()) {
            arrayList.add(((BaseAnalyser) entry.getValue()).serialize(((Integer) entry.getKey()).intValue()));
        }
        return new MPSIndex(this.tokens.toArray(), this.streams, (MPSStreamIndex[]) arrayList.toArray(new MPSStreamIndex[0]));
    }

    protected void savePESMeta(int i, long j) {
        this.tokens.add(j);
        this.streams.add(i);
    }

    void finishAnalyse() {
        super.finishRead();
        for (BaseAnalyser finishAnalyse : this.analyzers.values()) {
            finishAnalyse.finishAnalyse();
        }
    }
}
