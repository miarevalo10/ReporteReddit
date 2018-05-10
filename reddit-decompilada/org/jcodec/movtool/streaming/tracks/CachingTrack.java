package org.jcodec.movtool.streaming.tracks;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.jcodec.movtool.streaming.CodecMeta;
import org.jcodec.movtool.streaming.VirtualPacket;
import org.jcodec.movtool.streaming.VirtualTrack;
import org.jcodec.movtool.streaming.VirtualTrack.VirtualEdit;

public class CachingTrack implements VirtualTrack {
    private List<CachingPacket> cachedPackets = Collections.synchronizedList(new ArrayList());
    private ScheduledFuture<?> policyFuture;
    private VirtualTrack src;

    public class CachingPacket extends VirtualPacketWrapper {
        private ByteBuffer cache;

        public CachingPacket(VirtualPacket virtualPacket) {
            super(virtualPacket);
        }

        public synchronized void wipe() {
            if (CachingTrack.this.cachedPackets.indexOf(this) == 0) {
                CachingTrack.this.cachedPackets.remove(0);
                this.cache = null;
            }
        }

        public synchronized ByteBuffer getData() throws IOException {
            CachingTrack.this.cachedPackets.remove(this);
            if (this.cache == null) {
                this.cache = this.src.getData();
            }
            CachingTrack.this.cachedPackets.add(this);
            if (this.cache == null) {
                return null;
            }
            return this.cache.duplicate();
        }
    }

    public CachingTrack(VirtualTrack virtualTrack, final int i, ScheduledExecutorService scheduledExecutorService) {
        if (i <= 0) {
            throw new IllegalArgumentException("Caching track with less then 1 entry.");
        }
        this.src = virtualTrack;
        this.policyFuture = scheduledExecutorService.scheduleAtFixedRate(new Runnable(this) {
            final /* synthetic */ CachingTrack f26839b;

            public void run() {
                while (this.f26839b.cachedPackets.size() > i) {
                    ((CachingPacket) this.f26839b.cachedPackets.get(0)).wipe();
                }
            }
        }, 200, 200, TimeUnit.MILLISECONDS);
    }

    public CodecMeta getCodecMeta() {
        return this.src.getCodecMeta();
    }

    public VirtualPacket nextPacket() throws IOException {
        VirtualPacket nextPacket = this.src.nextPacket();
        if (nextPacket == null) {
            return null;
        }
        return new CachingPacket(nextPacket);
    }

    public void close() throws IOException {
        if (this.policyFuture != null) {
            this.policyFuture.cancel(false);
        }
        this.cachedPackets.clear();
        this.src.close();
    }

    public VirtualEdit[] getEdits() {
        return this.src.getEdits();
    }

    public int getPreferredTimescale() {
        return this.src.getPreferredTimescale();
    }
}
