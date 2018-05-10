package com.googlecode.mp4parser;

import com.coremedia.iso.BoxParser;
import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.Container;
import com.googlecode.mp4parser.util.CastUtils;
import com.googlecode.mp4parser.util.LazyList;
import com.googlecode.mp4parser.util.Logger;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class BasicContainer implements Container, Closeable, Iterator<Box> {
    private static final Box EOF = new C16211("eof ");
    private static Logger LOG = Logger.m7708a(BasicContainer.class);
    protected BoxParser boxParser;
    private List<Box> boxes = new ArrayList();
    protected DataSource dataSource;
    long endPosition = 0;
    Box lookahead = null;
    long parsePosition = 0;
    long startPosition = 0;

    class C16211 extends AbstractBox {
        protected void _parseDetails(ByteBuffer byteBuffer) {
        }

        protected void getContent(ByteBuffer byteBuffer) {
        }

        protected long getContentSize() {
            return 0;
        }

        C16211(String str) {
            super(str);
        }
    }

    public List<Box> getBoxes() {
        if (this.dataSource == null || this.lookahead == EOF) {
            return this.boxes;
        }
        return new LazyList(this.boxes, this);
    }

    public void setBoxes(List<Box> list) {
        this.boxes = new ArrayList(list);
        this.lookahead = EOF;
        this.dataSource = null;
    }

    protected long getContainerSize() {
        long j = 0;
        for (int i = 0; i < getBoxes().size(); i++) {
            j += ((Box) this.boxes.get(i)).getSize();
        }
        return j;
    }

    public <T extends Box> List<T> getBoxes(Class<T> cls) {
        List boxes = getBoxes();
        List<T> list = null;
        Object obj = null;
        for (int i = 0; i < boxes.size(); i++) {
            Box box = (Box) boxes.get(i);
            if (cls.isInstance(box)) {
                if (obj == null) {
                    obj = box;
                } else {
                    if (list == null) {
                        list = new ArrayList(2);
                        list.add(obj);
                    }
                    list.add(box);
                }
            }
        }
        if (list != null) {
            return list;
        }
        if (obj != null) {
            return Collections.singletonList(obj);
        }
        return Collections.emptyList();
    }

    public <T extends Box> List<T> getBoxes(Class<T> cls, boolean z) {
        List<T> arrayList = new ArrayList(2);
        List boxes = getBoxes();
        for (int i = 0; i < boxes.size(); i++) {
            Box box = (Box) boxes.get(i);
            if (cls.isInstance(box)) {
                arrayList.add(box);
            }
            if (z && (box instanceof Container)) {
                arrayList.addAll(((Container) box).getBoxes(cls, z));
            }
        }
        return arrayList;
    }

    public void addBox(Box box) {
        if (box != null) {
            this.boxes = new ArrayList(getBoxes());
            box.setParent(this);
            this.boxes.add(box);
        }
    }

    public void initContainer(DataSource dataSource, long j, BoxParser boxParser) throws IOException {
        this.dataSource = dataSource;
        long position = dataSource.position();
        this.startPosition = position;
        this.parsePosition = position;
        dataSource.position(dataSource.position() + j);
        this.endPosition = dataSource.position();
        this.boxParser = boxParser;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }

    public boolean hasNext() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r3 = this;
        r0 = r3.lookahead;
        r1 = EOF;
        r2 = 0;
        if (r0 != r1) goto L_0x0008;
    L_0x0007:
        return r2;
    L_0x0008:
        r0 = r3.lookahead;
        r1 = 1;
        if (r0 == 0) goto L_0x000e;
    L_0x000d:
        return r1;
    L_0x000e:
        r0 = r3.next();	 Catch:{ NoSuchElementException -> 0x0015 }
        r3.lookahead = r0;	 Catch:{ NoSuchElementException -> 0x0015 }
        return r1;
    L_0x0015:
        r0 = EOF;
        r3.lookahead = r0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.googlecode.mp4parser.BasicContainer.hasNext():boolean");
    }

    public com.coremedia.iso.boxes.Box next() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r4 = this;
        r0 = r4.lookahead;
        if (r0 == 0) goto L_0x0010;
    L_0x0004:
        r0 = r4.lookahead;
        r1 = EOF;
        if (r0 == r1) goto L_0x0010;
    L_0x000a:
        r0 = r4.lookahead;
        r1 = 0;
        r4.lookahead = r1;
        return r0;
    L_0x0010:
        r0 = r4.dataSource;
        if (r0 == 0) goto L_0x0048;
    L_0x0014:
        r0 = r4.parsePosition;
        r2 = r4.endPosition;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 < 0) goto L_0x001d;
    L_0x001c:
        goto L_0x0048;
    L_0x001d:
        r0 = r4.dataSource;	 Catch:{ EOFException -> 0x0042, IOException -> 0x003c }
        monitor-enter(r0);	 Catch:{ EOFException -> 0x0042, IOException -> 0x003c }
        r1 = r4.dataSource;	 Catch:{ all -> 0x0039 }
        r2 = r4.parsePosition;	 Catch:{ all -> 0x0039 }
        r1.position(r2);	 Catch:{ all -> 0x0039 }
        r1 = r4.boxParser;	 Catch:{ all -> 0x0039 }
        r2 = r4.dataSource;	 Catch:{ all -> 0x0039 }
        r1 = r1.mo1040a(r2, r4);	 Catch:{ all -> 0x0039 }
        r2 = r4.dataSource;	 Catch:{ all -> 0x0039 }
        r2 = r2.position();	 Catch:{ all -> 0x0039 }
        r4.parsePosition = r2;	 Catch:{ all -> 0x0039 }
        monitor-exit(r0);	 Catch:{ all -> 0x0039 }
        return r1;	 Catch:{ all -> 0x0039 }
    L_0x0039:
        r1 = move-exception;	 Catch:{ all -> 0x0039 }
        monitor-exit(r0);	 Catch:{ all -> 0x0039 }
        throw r1;	 Catch:{ EOFException -> 0x0042, IOException -> 0x003c }
    L_0x003c:
        r0 = new java.util.NoSuchElementException;
        r0.<init>();
        throw r0;
    L_0x0042:
        r0 = new java.util.NoSuchElementException;
        r0.<init>();
        throw r0;
    L_0x0048:
        r0 = EOF;
        r4.lookahead = r0;
        r0 = new java.util.NoSuchElementException;
        r0.<init>();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.googlecode.mp4parser.BasicContainer.next():com.coremedia.iso.boxes.Box");
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName());
        stringBuilder.append("[");
        for (int i = 0; i < this.boxes.size(); i++) {
            if (i > 0) {
                stringBuilder.append(";");
            }
            stringBuilder.append(((Box) this.boxes.get(i)).toString());
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public final void writeContainer(WritableByteChannel writableByteChannel) throws IOException {
        for (Box box : getBoxes()) {
            box.getBox(writableByteChannel);
        }
    }

    public ByteBuffer getByteBuffer(long j, long j2) throws IOException {
        long j3 = j2;
        if (this.dataSource != null) {
            ByteBuffer map;
            synchronized (r1.dataSource) {
                try {
                    map = r1.dataSource.map(r1.startPosition + j, j3);
                } catch (Throwable th) {
                    Throwable th2 = th;
                }
            }
            return map;
        }
        ByteBuffer allocate = ByteBuffer.allocate(CastUtils.m7705a(j2));
        j3 = j + j3;
        long j4 = 0;
        for (Box box : r1.boxes) {
            long size = box.getSize() + j4;
            if (size > j && j4 < j3) {
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                WritableByteChannel newChannel = Channels.newChannel(byteArrayOutputStream);
                box.getBox(newChannel);
                newChannel.close();
                int i = (j4 > j ? 1 : (j4 == j ? 0 : -1));
                if (i >= 0 && size <= j3) {
                    allocate.put(byteArrayOutputStream.toByteArray());
                } else if (i < 0 && size > j3) {
                    j4 = j - j4;
                    allocate.put(byteArrayOutputStream.toByteArray(), CastUtils.m7705a(j4), CastUtils.m7705a((box.getSize() - j4) - (size - j3)));
                } else if (i < 0 && size <= j3) {
                    j4 = j - j4;
                    allocate.put(byteArrayOutputStream.toByteArray(), CastUtils.m7705a(j4), CastUtils.m7705a(box.getSize() - j4));
                } else if (i >= 0 && size > j3) {
                    allocate.put(byteArrayOutputStream.toByteArray(), 0, CastUtils.m7705a(box.getSize() - (size - j3)));
                }
            }
            j4 = size;
        }
        return (ByteBuffer) allocate.rewind();
    }

    public void close() throws IOException {
        this.dataSource.close();
    }
}
