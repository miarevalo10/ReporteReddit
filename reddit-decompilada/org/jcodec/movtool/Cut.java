package org.jcodec.movtool;

import java.io.File;
import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.List;
import org.jcodec.common.NIOUtils;
import org.jcodec.common.SeekableByteChannel;
import org.jcodec.containers.mp4.MP4Util;
import org.jcodec.containers.mp4.boxes.Box;
import org.jcodec.containers.mp4.boxes.Edit;
import org.jcodec.containers.mp4.boxes.MovieBox;
import org.jcodec.containers.mp4.boxes.TrakBox;

public class Cut {

    public static class Slice {
        private double inSec;
        private double outSec;

        public Slice(double d, double d2) {
            this.inSec = d;
            this.outSec = d2;
        }
    }

    public static void main(java.lang.String[] r13) throws java.lang.Exception {
        /* JADX: method processing error */
/*
Error: java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:410)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.fixIterableType(LoopRegionVisitor.java:308)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.checkIterableForEach(LoopRegionVisitor.java:249)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.processLoopRegion(LoopRegionVisitor.java:68)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.enterRegion(LoopRegionVisitor.java:52)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:56)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:18)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.visit(LoopRegionVisitor.java:46)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = r13.length;
        if (r0 > 0) goto L_0x000e;
    L_0x0003:
        r0 = java.lang.System.out;
        r1 = "Syntax: cut [-command arg]...[-command arg] [-self] <movie file>\n\tCreates a reference movie out of the file and applies a set of changes specified by the commands to it.";
        r0.println(r1);
        r0 = -1;
        java.lang.System.exit(r0);
    L_0x000e:
        r0 = new java.util.ArrayList;
        r0.<init>();
        r1 = new java.util.ArrayList;
        r1.<init>();
        r2 = 0;
        r3 = 1;
        r4 = r2;
        r5 = r4;
    L_0x001c:
        r6 = "-cut";
        r7 = r13[r4];
        r6 = r6.equals(r7);
        r7 = 0;
        if (r6 == 0) goto L_0x0057;
    L_0x0027:
        r6 = r4 + 1;
        r6 = r13[r6];
        r8 = ":";
        r6 = org.jcodec.common.StringUtils.split(r6, r8);
        r8 = new org.jcodec.movtool.Cut$Slice;
        r9 = r6[r2];
        r9 = java.lang.Integer.parseInt(r9);
        r9 = (double) r9;
        r11 = r6[r3];
        r11 = java.lang.Integer.parseInt(r11);
        r11 = (double) r11;
        r8.<init>(r9, r11);
        r0.add(r8);
        r8 = 2;
        r9 = r6.length;
        if (r9 <= r8) goto L_0x0051;
    L_0x004b:
        r6 = r6[r8];
        r1.add(r6);
        goto L_0x0054;
    L_0x0051:
        r1.add(r7);
    L_0x0054:
        r4 = r4 + 2;
        goto L_0x001c;
    L_0x0057:
        r6 = "-self";
        r8 = r13[r4];
        r6 = r6.equals(r8);
        if (r6 == 0) goto L_0x0065;
    L_0x0061:
        r4 = r4 + 1;
        r5 = r3;
        goto L_0x001c;
    L_0x0065:
        r2 = new java.io.File;
        r13 = r13[r4];
        r2.<init>(r13);
        r13 = new java.util.ArrayList;
        r13.<init>();
        r3 = org.jcodec.common.NIOUtils.readableFileChannel(r2);	 Catch:{ all -> 0x012c }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x012a }
        r6 = "file://";	 Catch:{ all -> 0x012a }
        r4.<init>(r6);	 Catch:{ all -> 0x012a }
        r6 = r2.getCanonicalPath();	 Catch:{ all -> 0x012a }
        r4.append(r6);	 Catch:{ all -> 0x012a }
        r4 = r4.toString();	 Catch:{ all -> 0x012a }
        r4 = org.jcodec.containers.mp4.MP4Util.createRefMovie(r3, r4);	 Catch:{ all -> 0x012a }
        if (r5 != 0) goto L_0x00c4;	 Catch:{ all -> 0x012a }
    L_0x008d:
        r5 = new java.io.File;	 Catch:{ all -> 0x012a }
        r6 = r2.getParentFile();	 Catch:{ all -> 0x012a }
        r8 = new java.lang.StringBuilder;	 Catch:{ all -> 0x012a }
        r8.<init>();	 Catch:{ all -> 0x012a }
        r9 = r2.getName();	 Catch:{ all -> 0x012a }
        r9 = org.jcodec.common.JCodecUtil.removeExtension(r9);	 Catch:{ all -> 0x012a }
        r8.append(r9);	 Catch:{ all -> 0x012a }
        r9 = ".ref.mov";	 Catch:{ all -> 0x012a }
        r8.append(r9);	 Catch:{ all -> 0x012a }
        r8 = r8.toString();	 Catch:{ all -> 0x012a }
        r5.<init>(r6, r8);	 Catch:{ all -> 0x012a }
        r5 = org.jcodec.common.NIOUtils.writableFileChannel(r5);	 Catch:{ all -> 0x012a }
        r6 = new org.jcodec.movtool.Cut;	 Catch:{ all -> 0x00c1 }
        r6.<init>();	 Catch:{ all -> 0x00c1 }
        r0 = r6.cut(r4, r0);	 Catch:{ all -> 0x00c1 }
        org.jcodec.containers.mp4.MP4Util.writeMovie(r5, r4);	 Catch:{ all -> 0x00c1 }
    L_0x00bf:
        r7 = r5;
        goto L_0x0104;
    L_0x00c1:
        r0 = move-exception;
        r7 = r5;
        goto L_0x012e;
    L_0x00c4:
        r5 = new java.io.File;	 Catch:{ all -> 0x012a }
        r6 = r2.getParentFile();	 Catch:{ all -> 0x012a }
        r8 = new java.lang.StringBuilder;	 Catch:{ all -> 0x012a }
        r8.<init>();	 Catch:{ all -> 0x012a }
        r9 = r2.getName();	 Catch:{ all -> 0x012a }
        r9 = org.jcodec.common.JCodecUtil.removeExtension(r9);	 Catch:{ all -> 0x012a }
        r8.append(r9);	 Catch:{ all -> 0x012a }
        r9 = ".self.mov";	 Catch:{ all -> 0x012a }
        r8.append(r9);	 Catch:{ all -> 0x012a }
        r8 = r8.toString();	 Catch:{ all -> 0x012a }
        r5.<init>(r6, r8);	 Catch:{ all -> 0x012a }
        r5 = org.jcodec.common.NIOUtils.writableFileChannel(r5);	 Catch:{ all -> 0x012a }
        r6 = new org.jcodec.movtool.Cut;	 Catch:{ all -> 0x00c1 }
        r6.<init>();	 Catch:{ all -> 0x00c1 }
        r0 = r6.cut(r4, r0);	 Catch:{ all -> 0x00c1 }
        r6 = new org.jcodec.movtool.Strip;	 Catch:{ all -> 0x00c1 }
        r6.<init>();	 Catch:{ all -> 0x00c1 }
        r6.strip(r4);	 Catch:{ all -> 0x00c1 }
        r6 = new org.jcodec.movtool.Flattern;	 Catch:{ all -> 0x00c1 }
        r6.<init>();	 Catch:{ all -> 0x00c1 }
        r6.flattern(r4, r5);	 Catch:{ all -> 0x00c1 }
        goto L_0x00bf;
    L_0x0104:
        r2 = r2.getParentFile();	 Catch:{ all -> 0x012a }
        saveSlices(r0, r1, r2);	 Catch:{ all -> 0x012a }
        if (r3 == 0) goto L_0x0110;
    L_0x010d:
        r3.close();
    L_0x0110:
        if (r7 == 0) goto L_0x0115;
    L_0x0112:
        r7.close();
    L_0x0115:
        r13 = r13.iterator();
    L_0x0119:
        r0 = r13.hasNext();
        if (r0 == 0) goto L_0x0129;
    L_0x011f:
        r0 = r13.next();
        r0 = (org.jcodec.common.SeekableByteChannel) r0;
        r0.close();
        goto L_0x0119;
    L_0x0129:
        return;
    L_0x012a:
        r0 = move-exception;
        goto L_0x012e;
    L_0x012c:
        r0 = move-exception;
        r3 = r7;
    L_0x012e:
        if (r3 == 0) goto L_0x0133;
    L_0x0130:
        r3.close();
    L_0x0133:
        if (r7 == 0) goto L_0x0138;
    L_0x0135:
        r7.close();
    L_0x0138:
        r13 = r13.iterator();
    L_0x013c:
        r1 = r13.hasNext();
        if (r1 == 0) goto L_0x014c;
    L_0x0142:
        r1 = r13.next();
        r1 = (org.jcodec.common.SeekableByteChannel) r1;
        r1.close();
        goto L_0x013c;
    L_0x014c:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.movtool.Cut.main(java.lang.String[]):void");
    }

    private static void saveSlices(List<MovieBox> list, List<String> list2, File file) throws IOException {
        for (int i = 0; i < list.size(); i++) {
            if (list2.get(i) != null) {
                ReadableByteChannel readableByteChannel = null;
                try {
                    ReadableByteChannel writableFileChannel = NIOUtils.writableFileChannel(new File(file, (String) list2.get(i)));
                    try {
                        MP4Util.writeMovie((SeekableByteChannel) writableFileChannel, (MovieBox) list.get(i));
                        NIOUtils.closeQuietly(writableFileChannel);
                    } catch (Throwable th) {
                        list = th;
                        readableByteChannel = writableFileChannel;
                    }
                } catch (Throwable th2) {
                    list = th2;
                }
            }
        }
        return;
        NIOUtils.closeQuietly(readableByteChannel);
        throw list;
    }

    public List<MovieBox> cut(MovieBox movieBox, List<Slice> list) {
        Cut cut = this;
        Box box = movieBox;
        TrakBox videoTrack = movieBox.getVideoTrack();
        if (!(videoTrack == null || videoTrack.getTimescale() == movieBox.getTimescale())) {
            box.fixTimescale(videoTrack.getTimescale());
        }
        int i = 0;
        for (TrakBox trakBox : movieBox.getTracks()) {
            Util.forceEditList(box, trakBox);
            List edits = trakBox.getEdits();
            for (Slice slice : list) {
                List list2 = edits;
                Box box2 = box;
                TrakBox trakBox2 = trakBox;
                split(list2, slice.inSec, box2, trakBox2);
                split(list2, slice.outSec, box2, trakBox2);
            }
        }
        List arrayList = new ArrayList();
        for (Slice slice2 : list) {
            MovieBox movieBox2 = (MovieBox) MP4Util.cloneBox(box, 16777216);
            for (TrakBox trakBox3 : movieBox2.getTracks()) {
                selectInner(trakBox3.getEdits(), slice2, box, trakBox3);
            }
            arrayList.add(movieBox2);
        }
        long j = 0;
        TrakBox[] tracks = movieBox.getTracks();
        int length = tracks.length;
        while (i < length) {
            trakBox2 = tracks[i];
            selectOuter(trakBox2.getEdits(), list, box, trakBox2);
            trakBox2.setEdits(trakBox2.getEdits());
            j = Math.max(j, trakBox2.getDuration());
            i++;
        }
        box.setDuration(j);
        return arrayList;
    }

    private void selectOuter(List<Edit> list, List<Slice> list2, MovieBox movieBox, TrakBox trakBox) {
        trakBox = new long[list2.size()];
        long[] jArr = new long[list2.size()];
        for (int i = 0; i < list2.size(); i++) {
            trakBox[i] = (long) (((Slice) list2.get(i)).inSec * ((double) movieBox.getTimescale()));
            jArr[i] = (long) (((Slice) list2.get(i)).outSec * ((double) movieBox.getTimescale()));
        }
        list2 = 0;
        list = list.listIterator();
        while (list.hasNext()) {
            Edit edit = (Edit) list.next();
            int i2 = 0;
            while (i2 < trakBox.length) {
                if (edit.getDuration() + list2 > trakBox[i2] && list2 < jArr[i2]) {
                    list.remove();
                }
                i2++;
            }
            list2 += edit.getDuration();
        }
    }

    private void selectInner(List<Edit> list, Slice slice, MovieBox movieBox, TrakBox trakBox) {
        long timescale = (long) (((double) movieBox.getTimescale()) * slice.inSec);
        slice = (long) (((double) movieBox.getTimescale()) * slice.outSec);
        list = list.listIterator();
        long j = 0;
        while (list.hasNext() != null) {
            Edit edit = (Edit) list.next();
            if (edit.getDuration() + j <= timescale || j >= slice) {
                list.remove();
            }
            j += edit.getDuration();
        }
    }

    private void split(List<Edit> list, double d, MovieBox movieBox, TrakBox trakBox) {
        Util.split(movieBox, trakBox, (long) (d * ((double) movieBox.getTimescale())));
    }
}
