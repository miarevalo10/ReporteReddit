package org.jcodec.audio;

import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.jcodec.audio.Audio.DummyFilter;

public class FilterGraph implements AudioFilter {
    private FilterSocket[] sockets;

    public static class Factory {
        private List<FilterSocket> sockets = new ArrayList();

        protected Factory(AudioFilter audioFilter) {
            if (audioFilter.getDelay() != 0) {
                this.sockets.add(new FilterSocket(new DummyFilter(audioFilter.getNInputs())));
                addLevel(audioFilter);
                return;
            }
            this.sockets.add(new FilterSocket(audioFilter));
        }

        public Factory addLevel(AudioFilter... audioFilterArr) {
            FilterSocket filterSocket = new FilterSocket(audioFilterArr);
            filterSocket.allocateBuffers(4096);
            this.sockets.add(filterSocket);
            return this;
        }

        public Factory addLevel(AudioFilter audioFilter, int i) {
            i = new AudioFilter[i];
            Arrays.fill(i, audioFilter);
            return addLevel(i);
        }

        public Factory addLevelSpan(AudioFilter audioFilter) {
            int totalOutputs = ((FilterSocket) this.sockets.get(this.sockets.size() - 1)).getTotalOutputs();
            if (totalOutputs % audioFilter.getNInputs() == 0) {
                return addLevel(audioFilter, totalOutputs / audioFilter.getNInputs());
            }
            StringBuilder stringBuilder = new StringBuilder("Can't fill ");
            stringBuilder.append(totalOutputs);
            stringBuilder.append(" with multiple of ");
            stringBuilder.append(audioFilter.getNInputs());
            throw new IllegalArgumentException(stringBuilder.toString());
        }

        public FilterGraph create() {
            return new FilterGraph((FilterSocket[]) this.sockets.toArray(new FilterSocket[0]));
        }
    }

    public static Factory addLevel(AudioFilter audioFilter) {
        return new Factory(audioFilter);
    }

    private FilterGraph(FilterSocket[] filterSocketArr) {
        this.sockets = filterSocketArr;
    }

    public void filter(FloatBuffer[] floatBufferArr, long[] jArr, FloatBuffer[] floatBufferArr2) {
        this.sockets[0].setBuffers(floatBufferArr, jArr);
        floatBufferArr = null;
        while (floatBufferArr < this.sockets.length) {
            jArr = floatBufferArr < this.sockets.length + -1 ? this.sockets[floatBufferArr + 1].getBuffers() : floatBufferArr2;
            this.sockets[floatBufferArr].filter(jArr);
            if (floatBufferArr > null) {
                this.sockets[floatBufferArr].rotate();
            }
            if (floatBufferArr < this.sockets.length - 1) {
                for (FloatBuffer flip : jArr) {
                    flip.flip();
                }
            }
            floatBufferArr++;
        }
    }

    public int getDelay() {
        return this.sockets[0].getFilters()[0].getDelay();
    }

    public int getNInputs() {
        return this.sockets[0].getTotalInputs();
    }

    public int getNOutputs() {
        return this.sockets[this.sockets.length - 1].getTotalOutputs();
    }
}
