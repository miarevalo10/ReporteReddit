package org.jcodec.movtool.streaming.tracks;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.jcodec.common.NIOUtils;
import org.jcodec.common.SeekableByteChannel;

public class FilePool implements ByteChannelPool {
    private List<SeekableByteChannel> allChannels = Collections.synchronizedList(new ArrayList());
    private BlockingQueue<SeekableByteChannel> channels;
    private File file;
    private int max;

    public class PoolChannel extends SeekableByteChannelWrapper {
        public PoolChannel(SeekableByteChannel seekableByteChannel) throws IOException {
            super(seekableByteChannel);
            seekableByteChannel.position(0);
        }

        public boolean isOpen() {
            return this.src != null;
        }

        public void close() throws java.io.IOException {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r2 = this;
            r0 = r2.src;
            r1 = 0;
            r2.src = r1;
        L_0x0005:
            r1 = org.jcodec.movtool.streaming.tracks.FilePool.this;	 Catch:{ InterruptedException -> 0x0005 }
            r1 = r1.channels;	 Catch:{ InterruptedException -> 0x0005 }
            r1.put(r0);	 Catch:{ InterruptedException -> 0x0005 }
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jcodec.movtool.streaming.tracks.FilePool.PoolChannel.close():void");
        }
    }

    public FilePool(File file, int i) {
        this.file = file;
        this.max = i;
        this.channels = new LinkedBlockingQueue();
    }

    public org.jcodec.common.SeekableByteChannel getChannel() throws java.io.IOException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.channels;
        r0 = r0.poll();
        r0 = (org.jcodec.common.SeekableByteChannel) r0;
        if (r0 != 0) goto L_0x0028;
    L_0x000a:
        r0 = r2.allChannels;
        r0 = r0.size();
        r1 = r2.max;
        if (r0 >= r1) goto L_0x0020;
    L_0x0014:
        r0 = r2.file;
        r0 = r2.newChannel(r0);
        r1 = r2.allChannels;
        r1.add(r0);
        goto L_0x0028;
    L_0x0020:
        r0 = r2.channels;	 Catch:{ InterruptedException -> 0x0020 }
        r0 = r0.take();	 Catch:{ InterruptedException -> 0x0020 }
        r0 = (org.jcodec.common.SeekableByteChannel) r0;	 Catch:{ InterruptedException -> 0x0020 }
    L_0x0028:
        r1 = new org.jcodec.movtool.streaming.tracks.FilePool$PoolChannel;
        r1.<init>(r0);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.movtool.streaming.tracks.FilePool.getChannel():org.jcodec.common.SeekableByteChannel");
    }

    protected SeekableByteChannel newChannel(File file) throws FileNotFoundException {
        return NIOUtils.readableFileChannel(file);
    }

    public void close() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
    L_0x0000:
        r0 = r2.allChannels;
        r0 = r0.isEmpty();
        if (r0 != 0) goto L_0x0017;
    L_0x0008:
        r0 = r2.allChannels;
        r1 = 0;
        r0 = r0.remove(r1);
        r0 = (org.jcodec.common.SeekableByteChannel) r0;
        if (r0 == 0) goto L_0x0000;
    L_0x0013:
        r0.close();	 Catch:{ IOException -> 0x0000 }
        goto L_0x0000;
    L_0x0017:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.movtool.streaming.tracks.FilePool.close():void");
    }
}
