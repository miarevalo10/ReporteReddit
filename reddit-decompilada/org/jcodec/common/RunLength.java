package org.jcodec.common;

import java.nio.ByteBuffer;

public abstract class RunLength {
    protected IntArrayList counts = new IntArrayList();

    public static class Integer extends RunLength {
        private static final int MIN_VALUE = Integer.MIN_VALUE;
        private int count = 0;
        private int lastValue = MIN_VALUE;
        private IntArrayList values = new IntArrayList();

        protected int recSize() {
            return 5;
        }

        public void add(int i) {
            if (this.lastValue == MIN_VALUE || this.lastValue != i) {
                if (this.lastValue != MIN_VALUE) {
                    this.values.add(this.lastValue);
                    this.counts.add(this.count);
                    this.count = 0;
                }
                this.lastValue = i;
            }
            this.count++;
        }

        public int[] getValues() {
            finish();
            return this.values.toArray();
        }

        protected void finish() {
            if (this.lastValue != MIN_VALUE) {
                this.values.add(this.lastValue);
                this.counts.add(this.count);
                this.lastValue = MIN_VALUE;
                this.count = 0;
            }
        }

        public void serialize(ByteBuffer byteBuffer) {
            ByteBuffer duplicate = byteBuffer.duplicate();
            int[] counts = getCounts();
            int[] values = getValues();
            NIOUtils.skip(byteBuffer, 4);
            int i = 0;
            int i2 = 0;
            while (i < counts.length) {
                int i3 = counts[i];
                while (i3 >= 256) {
                    byteBuffer.put((byte) -1);
                    byteBuffer.putInt(values[i]);
                    i2++;
                    i3 -= 256;
                }
                byteBuffer.put((byte) (i3 - 1));
                byteBuffer.putInt(values[i]);
                i++;
                i2++;
            }
            duplicate.putInt(i2);
        }

        public static Integer parse(ByteBuffer byteBuffer) {
            Integer integer = new Integer();
            int i = byteBuffer.getInt();
            for (int i2 = 0; i2 < i; i2++) {
                int i3 = (byteBuffer.get() & 255) + 1;
                int i4 = byteBuffer.getInt();
                integer.counts.add(i3);
                integer.values.add(i4);
            }
            return integer;
        }

        public int[] flattern() {
            int[] counts = getCounts();
            int i = 0;
            int i2 = i;
            while (i < counts.length) {
                i2 += counts[i];
                i++;
            }
            int[] values = getValues();
            int[] iArr = new int[i2];
            int i3 = 0;
            int i4 = i3;
            while (i3 < counts.length) {
                int i5 = i4;
                i4 = 0;
                while (i4 < counts[i3]) {
                    iArr[i5] = values[i3];
                    i4++;
                    i5++;
                }
                i3++;
                i4 = i5;
            }
            return iArr;
        }
    }

    public static class Long extends RunLength {
        private static final long MIN_VALUE = Long.MIN_VALUE;
        private int count = 0;
        private long lastValue = MIN_VALUE;
        private LongArrayList values = new LongArrayList();

        protected int recSize() {
            return 9;
        }

        public void add(long j) {
            if (this.lastValue == MIN_VALUE || this.lastValue != j) {
                if (this.lastValue != MIN_VALUE) {
                    this.values.add(this.lastValue);
                    this.counts.add(this.count);
                    this.count = 0;
                }
                this.lastValue = j;
            }
            this.count++;
        }

        public int[] getCounts() {
            finish();
            return this.counts.toArray();
        }

        public long[] getValues() {
            finish();
            return this.values.toArray();
        }

        protected void finish() {
            if (this.lastValue != MIN_VALUE) {
                this.values.add(this.lastValue);
                this.counts.add(this.count);
                this.lastValue = MIN_VALUE;
                this.count = 0;
            }
        }

        public void serialize(ByteBuffer byteBuffer) {
            ByteBuffer duplicate = byteBuffer.duplicate();
            int[] counts = getCounts();
            long[] values = getValues();
            NIOUtils.skip(byteBuffer, 4);
            int i = 0;
            int i2 = 0;
            while (i < counts.length) {
                int i3 = counts[i];
                while (i3 >= 256) {
                    byteBuffer.put((byte) -1);
                    byteBuffer.putLong(values[i]);
                    i2++;
                    i3 -= 256;
                }
                byteBuffer.put((byte) (i3 - 1));
                byteBuffer.putLong(values[i]);
                i++;
                i2++;
            }
            duplicate.putInt(i2);
        }

        public static Long parse(ByteBuffer byteBuffer) {
            Long longR = new Long();
            int i = byteBuffer.getInt();
            for (int i2 = 0; i2 < i; i2++) {
                int i3 = (byteBuffer.get() & 255) + 1;
                long j = byteBuffer.getLong();
                longR.counts.add(i3);
                longR.values.add(j);
            }
            return longR;
        }

        public long[] flattern() {
            int[] counts = getCounts();
            int i = 0;
            int i2 = i;
            while (i < counts.length) {
                i2 += counts[i];
                i++;
            }
            long[] values = getValues();
            long[] jArr = new long[i2];
            int i3 = 0;
            int i4 = i3;
            while (i3 < counts.length) {
                int i5 = i4;
                i4 = 0;
                while (i4 < counts[i3]) {
                    jArr[i5] = values[i3];
                    i4++;
                    i5++;
                }
                i3++;
                i4 = i5;
            }
            return jArr;
        }
    }

    protected abstract void finish();

    protected abstract int recSize();

    public int estimateSize() {
        int[] counts = getCounts();
        int i = 0;
        int i2 = 0;
        while (i < counts.length) {
            for (int i3 = counts[i]; i3 >= 256; i3 -= 256) {
                i2++;
            }
            i++;
            i2++;
        }
        return (i2 * recSize()) + 4;
    }

    public int[] getCounts() {
        finish();
        return this.counts.toArray();
    }
}
