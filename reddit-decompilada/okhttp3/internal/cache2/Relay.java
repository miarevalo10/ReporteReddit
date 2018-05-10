package okhttp3.internal.cache2;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

final class Relay {
    private static final long FILE_HEADER_SIZE = 32;
    static final ByteString PREFIX_CLEAN = ByteString.m28267a("OkHttp cache v1\n");
    static final ByteString PREFIX_DIRTY = ByteString.m28267a("OkHttp DIRTY :(\n");
    private static final int SOURCE_FILE = 2;
    private static final int SOURCE_UPSTREAM = 1;
    final Buffer buffer = new Buffer();
    final long bufferMaxSize;
    boolean complete;
    RandomAccessFile file;
    private final ByteString metadata;
    int sourceCount;
    Source upstream;
    final Buffer upstreamBuffer = new Buffer();
    long upstreamPos;
    Thread upstreamReader;

    class RelaySource implements Source {
        private FileOperator fileOperator = new FileOperator(Relay.this.file.getChannel());
        private long sourcePos;
        private final Timeout timeout = new Timeout();

        RelaySource() {
        }

        public long read(okio.Buffer r22, long r23) throws java.io.IOException {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.utils.BlockUtils.getBlockByInsn(BlockUtils.java:172)
	at jadx.core.dex.visitors.ssa.EliminatePhiNodes.replaceMerge(EliminatePhiNodes.java:90)
	at jadx.core.dex.visitors.ssa.EliminatePhiNodes.replaceMergeInstructions(EliminatePhiNodes.java:68)
	at jadx.core.dex.visitors.ssa.EliminatePhiNodes.visit(EliminatePhiNodes.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r21 = this;
            r1 = r21;
            r2 = r23;
            r4 = r1.fileOperator;
            if (r4 != 0) goto L_0x0010;
        L_0x0008:
            r2 = new java.lang.IllegalStateException;
            r3 = "closed";
            r2.<init>(r3);
            throw r2;
        L_0x0010:
            r4 = okhttp3.internal.cache2.Relay.this;
            monitor-enter(r4);
        L_0x0013:
            r5 = r1.sourcePos;	 Catch:{ all -> 0x013f }
            r7 = okhttp3.internal.cache2.Relay.this;	 Catch:{ all -> 0x013f }
            r7 = r7.upstreamPos;	 Catch:{ all -> 0x013f }
            r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1));	 Catch:{ all -> 0x013f }
            r6 = 2;	 Catch:{ all -> 0x013f }
            r9 = -1;	 Catch:{ all -> 0x013f }
            if (r5 != 0) goto L_0x0041;	 Catch:{ all -> 0x013f }
        L_0x0020:
            r5 = okhttp3.internal.cache2.Relay.this;	 Catch:{ all -> 0x013f }
            r5 = r5.complete;	 Catch:{ all -> 0x013f }
            if (r5 == 0) goto L_0x0028;	 Catch:{ all -> 0x013f }
        L_0x0026:
            monitor-exit(r4);	 Catch:{ all -> 0x013f }
            return r9;	 Catch:{ all -> 0x013f }
        L_0x0028:
            r5 = okhttp3.internal.cache2.Relay.this;	 Catch:{ all -> 0x013f }
            r5 = r5.upstreamReader;	 Catch:{ all -> 0x013f }
            if (r5 == 0) goto L_0x0036;	 Catch:{ all -> 0x013f }
        L_0x002e:
            r5 = r1.timeout;	 Catch:{ all -> 0x013f }
            r6 = okhttp3.internal.cache2.Relay.this;	 Catch:{ all -> 0x013f }
            r5.waitUntilNotified(r6);	 Catch:{ all -> 0x013f }
            goto L_0x0013;	 Catch:{ all -> 0x013f }
        L_0x0036:
            r5 = okhttp3.internal.cache2.Relay.this;	 Catch:{ all -> 0x013f }
            r11 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x013f }
            r5.upstreamReader = r11;	 Catch:{ all -> 0x013f }
            r5 = 1;	 Catch:{ all -> 0x013f }
            monitor-exit(r4);	 Catch:{ all -> 0x013f }
            goto L_0x0051;	 Catch:{ all -> 0x013f }
        L_0x0041:
            r5 = okhttp3.internal.cache2.Relay.this;	 Catch:{ all -> 0x013f }
            r5 = r5.buffer;	 Catch:{ all -> 0x013f }
            r11 = r5.f36201b;	 Catch:{ all -> 0x013f }
            r11 = r7 - r11;	 Catch:{ all -> 0x013f }
            r13 = r1.sourcePos;	 Catch:{ all -> 0x013f }
            r5 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1));	 Catch:{ all -> 0x013f }
            if (r5 >= 0) goto L_0x0122;	 Catch:{ all -> 0x013f }
        L_0x004f:
            monitor-exit(r4);	 Catch:{ all -> 0x013f }
            r5 = r6;
        L_0x0051:
            r11 = 32;
            if (r5 != r6) goto L_0x006f;
        L_0x0055:
            r4 = r1.sourcePos;
            r7 = r7 - r4;
            r2 = java.lang.Math.min(r2, r7);
            r13 = r1.fileOperator;
            r4 = r1.sourcePos;
            r14 = r11 + r4;
            r16 = r22;
            r17 = r2;
            r13.read(r14, r16, r17);
            r4 = r1.sourcePos;
            r4 = r4 + r2;
            r1.sourcePos = r4;
            return r2;
        L_0x006f:
            r4 = 0;
            r5 = okhttp3.internal.cache2.Relay.this;	 Catch:{ all -> 0x010e }
            r5 = r5.upstream;	 Catch:{ all -> 0x010e }
            r6 = okhttp3.internal.cache2.Relay.this;	 Catch:{ all -> 0x010e }
            r6 = r6.upstreamBuffer;	 Catch:{ all -> 0x010e }
            r13 = okhttp3.internal.cache2.Relay.this;	 Catch:{ all -> 0x010e }
            r13 = r13.bufferMaxSize;	 Catch:{ all -> 0x010e }
            r5 = r5.read(r6, r13);	 Catch:{ all -> 0x010e }
            r13 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1));	 Catch:{ all -> 0x010e }
            if (r13 != 0) goto L_0x009b;	 Catch:{ all -> 0x010e }
        L_0x0084:
            r2 = okhttp3.internal.cache2.Relay.this;	 Catch:{ all -> 0x010e }
            r2.commit(r7);	 Catch:{ all -> 0x010e }
            r2 = okhttp3.internal.cache2.Relay.this;
            monitor-enter(r2);
            r3 = okhttp3.internal.cache2.Relay.this;	 Catch:{ all -> 0x0097 }
            r3.upstreamReader = r4;	 Catch:{ all -> 0x0097 }
            r3 = okhttp3.internal.cache2.Relay.this;	 Catch:{ all -> 0x0097 }
            r3.notifyAll();	 Catch:{ all -> 0x0097 }
            monitor-exit(r2);	 Catch:{ all -> 0x0097 }
            return r9;	 Catch:{ all -> 0x0097 }
        L_0x0097:
            r0 = move-exception;	 Catch:{ all -> 0x0097 }
            r3 = r0;	 Catch:{ all -> 0x0097 }
            monitor-exit(r2);	 Catch:{ all -> 0x0097 }
            throw r3;
        L_0x009b:
            r2 = java.lang.Math.min(r5, r2);	 Catch:{ all -> 0x010e }
            r9 = okhttp3.internal.cache2.Relay.this;	 Catch:{ all -> 0x010e }
            r13 = r9.upstreamBuffer;	 Catch:{ all -> 0x010e }
            r15 = 0;	 Catch:{ all -> 0x010e }
            r14 = r22;	 Catch:{ all -> 0x010e }
            r17 = r2;	 Catch:{ all -> 0x010e }
            r13.m36485a(r14, r15, r17);	 Catch:{ all -> 0x010e }
            r9 = r1.sourcePos;	 Catch:{ all -> 0x010e }
            r9 = r9 + r2;	 Catch:{ all -> 0x010e }
            r1.sourcePos = r9;	 Catch:{ all -> 0x010e }
            r15 = r1.fileOperator;	 Catch:{ all -> 0x010e }
            r16 = r11 + r7;	 Catch:{ all -> 0x010e }
            r7 = okhttp3.internal.cache2.Relay.this;	 Catch:{ all -> 0x010e }
            r7 = r7.upstreamBuffer;	 Catch:{ all -> 0x010e }
            r18 = r7.m36541v();	 Catch:{ all -> 0x010e }
            r19 = r5;	 Catch:{ all -> 0x010e }
            r15.write(r16, r18, r19);	 Catch:{ all -> 0x010e }
            r7 = okhttp3.internal.cache2.Relay.this;	 Catch:{ all -> 0x010e }
            monitor-enter(r7);	 Catch:{ all -> 0x010e }
            r8 = okhttp3.internal.cache2.Relay.this;	 Catch:{ all -> 0x010a }
            r8 = r8.buffer;	 Catch:{ all -> 0x010a }
            r9 = okhttp3.internal.cache2.Relay.this;	 Catch:{ all -> 0x010a }
            r9 = r9.upstreamBuffer;	 Catch:{ all -> 0x010a }
            r8.write(r9, r5);	 Catch:{ all -> 0x010a }
            r8 = okhttp3.internal.cache2.Relay.this;	 Catch:{ all -> 0x010a }
            r8 = r8.buffer;	 Catch:{ all -> 0x010a }
            r8 = r8.f36201b;	 Catch:{ all -> 0x010a }
            r10 = okhttp3.internal.cache2.Relay.this;	 Catch:{ all -> 0x010a }
            r10 = r10.bufferMaxSize;	 Catch:{ all -> 0x010a }
            r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));	 Catch:{ all -> 0x010a }
            if (r8 <= 0) goto L_0x00f0;	 Catch:{ all -> 0x010a }
        L_0x00de:
            r8 = okhttp3.internal.cache2.Relay.this;	 Catch:{ all -> 0x010a }
            r8 = r8.buffer;	 Catch:{ all -> 0x010a }
            r9 = okhttp3.internal.cache2.Relay.this;	 Catch:{ all -> 0x010a }
            r9 = r9.buffer;	 Catch:{ all -> 0x010a }
            r9 = r9.f36201b;	 Catch:{ all -> 0x010a }
            r11 = okhttp3.internal.cache2.Relay.this;	 Catch:{ all -> 0x010a }
            r11 = r11.bufferMaxSize;	 Catch:{ all -> 0x010a }
            r9 = r9 - r11;	 Catch:{ all -> 0x010a }
            r8.mo6779i(r9);	 Catch:{ all -> 0x010a }
        L_0x00f0:
            r8 = okhttp3.internal.cache2.Relay.this;	 Catch:{ all -> 0x010a }
            r9 = r8.upstreamPos;	 Catch:{ all -> 0x010a }
            r9 = r9 + r5;	 Catch:{ all -> 0x010a }
            r8.upstreamPos = r9;	 Catch:{ all -> 0x010a }
            monitor-exit(r7);	 Catch:{ all -> 0x010a }
            r5 = okhttp3.internal.cache2.Relay.this;
            monitor-enter(r5);
            r6 = okhttp3.internal.cache2.Relay.this;	 Catch:{ all -> 0x0106 }
            r6.upstreamReader = r4;	 Catch:{ all -> 0x0106 }
            r4 = okhttp3.internal.cache2.Relay.this;	 Catch:{ all -> 0x0106 }
            r4.notifyAll();	 Catch:{ all -> 0x0106 }
            monitor-exit(r5);	 Catch:{ all -> 0x0106 }
            return r2;	 Catch:{ all -> 0x0106 }
        L_0x0106:
            r0 = move-exception;	 Catch:{ all -> 0x0106 }
            r2 = r0;	 Catch:{ all -> 0x0106 }
            monitor-exit(r5);	 Catch:{ all -> 0x0106 }
            throw r2;
        L_0x010a:
            r0 = move-exception;
            r2 = r0;
            monitor-exit(r7);	 Catch:{ all -> 0x010a }
            throw r2;	 Catch:{ all -> 0x010e }
        L_0x010e:
            r0 = move-exception;
            r2 = r0;
            r3 = okhttp3.internal.cache2.Relay.this;
            monitor-enter(r3);
            r5 = okhttp3.internal.cache2.Relay.this;	 Catch:{ all -> 0x011e }
            r5.upstreamReader = r4;	 Catch:{ all -> 0x011e }
            r4 = okhttp3.internal.cache2.Relay.this;	 Catch:{ all -> 0x011e }
            r4.notifyAll();	 Catch:{ all -> 0x011e }
            monitor-exit(r3);	 Catch:{ all -> 0x011e }
            throw r2;
        L_0x011e:
            r0 = move-exception;
            r2 = r0;
            monitor-exit(r3);	 Catch:{ all -> 0x011e }
            throw r2;
        L_0x0122:
            r5 = r1.sourcePos;	 Catch:{ all -> 0x013f }
            r7 = r7 - r5;	 Catch:{ all -> 0x013f }
            r2 = java.lang.Math.min(r2, r7);	 Catch:{ all -> 0x013f }
            r5 = okhttp3.internal.cache2.Relay.this;	 Catch:{ all -> 0x013f }
            r13 = r5.buffer;	 Catch:{ all -> 0x013f }
            r5 = r1.sourcePos;	 Catch:{ all -> 0x013f }
            r15 = r5 - r11;	 Catch:{ all -> 0x013f }
            r14 = r22;	 Catch:{ all -> 0x013f }
            r17 = r2;	 Catch:{ all -> 0x013f }
            r13.m36485a(r14, r15, r17);	 Catch:{ all -> 0x013f }
            r5 = r1.sourcePos;	 Catch:{ all -> 0x013f }
            r5 = r5 + r2;	 Catch:{ all -> 0x013f }
            r1.sourcePos = r5;	 Catch:{ all -> 0x013f }
            monitor-exit(r4);	 Catch:{ all -> 0x013f }
            return r2;	 Catch:{ all -> 0x013f }
        L_0x013f:
            r0 = move-exception;	 Catch:{ all -> 0x013f }
            r2 = r0;	 Catch:{ all -> 0x013f }
            monitor-exit(r4);	 Catch:{ all -> 0x013f }
            throw r2;
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache2.Relay.RelaySource.read(okio.Buffer, long):long");
        }

        public Timeout timeout() {
            return this.timeout;
        }

        public void close() throws IOException {
            if (this.fileOperator != null) {
                Closeable closeable = null;
                this.fileOperator = null;
                synchronized (Relay.this) {
                    Relay relay = Relay.this;
                    relay.sourceCount--;
                    if (Relay.this.sourceCount == 0) {
                        RandomAccessFile randomAccessFile = Relay.this.file;
                        Relay.this.file = null;
                        closeable = randomAccessFile;
                    }
                }
                if (closeable != null) {
                    Util.closeQuietly(closeable);
                }
            }
        }
    }

    private Relay(RandomAccessFile randomAccessFile, Source source, long j, ByteString byteString, long j2) {
        this.file = randomAccessFile;
        this.upstream = source;
        this.complete = source == null ? true : null;
        this.upstreamPos = j;
        this.metadata = byteString;
        this.bufferMaxSize = j2;
    }

    public static Relay edit(File file, Source source, ByteString byteString, long j) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        File relay = new Relay(randomAccessFile, source, 0, byteString, j);
        randomAccessFile.setLength(null);
        relay.writeHeader(PREFIX_DIRTY, -1, -1);
        return relay;
    }

    public static Relay read(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        file = new FileOperator(randomAccessFile.getChannel());
        Buffer buffer = new Buffer();
        file.read(0, buffer, FILE_HEADER_SIZE);
        if (buffer.mo6768d((long) PREFIX_CLEAN.mo6166h()).equals(PREFIX_CLEAN)) {
            long j = buffer.mo6780j();
            long j2 = buffer.mo6780j();
            buffer = new Buffer();
            file.read(FILE_HEADER_SIZE + j, buffer, j2);
            return new Relay(randomAccessFile, null, j, buffer.m36534o(), 0);
        }
        throw new IOException("unreadable cache file");
    }

    private void writeHeader(ByteString byteString, long j, long j2) throws IOException {
        Buffer buffer = new Buffer();
        buffer.m36486a(byteString);
        buffer.m36524j(j);
        buffer.m36524j(j2);
        if (buffer.f36201b != FILE_HEADER_SIZE) {
            throw new IllegalArgumentException();
        }
        new FileOperator(this.file.getChannel()).write(0, buffer, FILE_HEADER_SIZE);
    }

    private void writeMetadata(long j) throws IOException {
        Buffer buffer = new Buffer();
        buffer.m36486a(this.metadata);
        new FileOperator(this.file.getChannel()).write(FILE_HEADER_SIZE + j, buffer, (long) this.metadata.mo6166h());
    }

    final void commit(long j) throws IOException {
        writeMetadata(j);
        this.file.getChannel().force(false);
        writeHeader(PREFIX_CLEAN, j, (long) this.metadata.mo6166h());
        this.file.getChannel().force(false);
        synchronized (this) {
            this.complete = 1;
        }
        Util.closeQuietly(this.upstream);
        this.upstream = 0;
    }

    final boolean isClosed() {
        return this.file == null;
    }

    public final ByteString metadata() {
        return this.metadata;
    }

    public final Source newSource() {
        synchronized (this) {
            if (this.file == null) {
                return null;
            }
            this.sourceCount++;
            return new RelaySource();
        }
    }
}
