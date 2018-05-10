package org.jcodec.audio;

import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.nio.FloatBuffer;
import java.util.Arrays;

public class FilterSocket {
    private FloatBuffer[] buffers;
    private int[] delays;
    private AudioFilter[] filters;
    private long[] positions;
    private int totalInputs;
    private int totalOutputs;

    public FilterSocket(AudioFilter... audioFilterArr) {
        int i;
        this.totalInputs = 0;
        this.totalOutputs = 0;
        for (i = 0; i < audioFilterArr.length; i++) {
            this.totalInputs += audioFilterArr[i].getNInputs();
            this.totalOutputs += audioFilterArr[i].getNOutputs();
        }
        this.buffers = new FloatBuffer[this.totalInputs];
        this.positions = new long[this.totalInputs];
        this.delays = new int[this.totalInputs];
        i = 0;
        int i2 = i;
        while (i < audioFilterArr.length) {
            int i3 = i2;
            i2 = 0;
            while (i2 < audioFilterArr[i].getNInputs()) {
                this.delays[i3] = audioFilterArr[i].getDelay();
                i2++;
                i3++;
            }
            i++;
            i2 = i3;
        }
        this.filters = audioFilterArr;
    }

    public void allocateBuffers(int i) {
        for (int i2 = 0; i2 < this.totalInputs; i2++) {
            this.buffers[i2] = FloatBuffer.allocate((this.delays[i2] * 2) + i);
            this.buffers[i2].position(this.delays[i2]);
        }
    }

    FilterSocket(AudioFilter audioFilter, FloatBuffer[] floatBufferArr, long[] jArr) {
        this.filters = new AudioFilter[]{audioFilter};
        this.buffers = floatBufferArr;
        this.positions = jArr;
        this.delays = new int[]{audioFilter.getDelay()};
        this.totalInputs = audioFilter.getNInputs();
        this.totalOutputs = audioFilter.getNOutputs();
    }

    public void filter(FloatBuffer[] floatBufferArr) {
        if (floatBufferArr.length != this.totalOutputs) {
            StringBuilder stringBuilder = new StringBuilder("Can not output to provided filter socket inputs != outputs (");
            stringBuilder.append(floatBufferArr.length);
            stringBuilder.append(Operation.NOT_EQUALS);
            stringBuilder.append(this.totalOutputs);
            stringBuilder.append(")");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        int i = 0;
        int i2 = 0;
        int i3 = i2;
        while (i < this.filters.length) {
            this.filters[i].filter((FloatBuffer[]) Arrays.copyOfRange(this.buffers, i2, this.filters[i].getNInputs() + i2), Arrays.copyOfRange(this.positions, i2, this.filters[i].getNInputs() + i2), (FloatBuffer[]) Arrays.copyOfRange(floatBufferArr, i3, this.filters[i].getNOutputs() + i3));
            i2 += this.filters[i].getNInputs();
            i3 += this.filters[i].getNOutputs();
            i++;
        }
    }

    FloatBuffer[] getBuffers() {
        return this.buffers;
    }

    public void rotate() {
        for (int i = 0; i < this.buffers.length; i++) {
            long[] jArr = this.positions;
            jArr[i] = jArr[i] + ((long) this.buffers[i].position());
            Audio.rotate(this.buffers[i]);
        }
    }

    public void setBuffers(FloatBuffer[] floatBufferArr, long[] jArr) {
        if (floatBufferArr.length != this.totalInputs) {
            throw new IllegalArgumentException("Number of input buffers provided is less then the number of filter inputs.");
        } else if (jArr.length != this.totalInputs) {
            throw new IllegalArgumentException("Number of input buffer positions provided is less then the number of filter inputs.");
        } else {
            this.buffers = floatBufferArr;
            this.positions = jArr;
        }
    }

    public int getTotalInputs() {
        return this.totalInputs;
    }

    public int getTotalOutputs() {
        return this.totalOutputs;
    }

    AudioFilter[] getFilters() {
        return this.filters;
    }

    public long[] getPositions() {
        return this.positions;
    }
}
