package org.jcodec.movtool;

import com.coremedia.iso.boxes.FreeBox;
import com.coremedia.iso.boxes.MovieBox;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.jcodec.common.NIOUtils;
import org.jcodec.containers.mp4.MP4Util;
import org.jcodec.containers.mp4.MP4Util.Atom;

public class Undo {
    public static void main(String[] strArr) throws IOException {
        if (strArr.length <= 0) {
            System.err.println("Syntax: qt-undo [-l] <movie>");
            System.err.println("\t-l\t\tList all the previous versions of this movie.");
            System.exit(-1);
        }
        Undo undo = new Undo();
        if ("-l".equals(strArr[0])) {
            strArr = undo.list(strArr[1]);
            PrintStream printStream = System.out;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(strArr.size() - 1);
            stringBuilder.append(" versions.");
            printStream.println(stringBuilder.toString());
            return;
        }
        undo.undo(strArr[0]);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void undo(java.lang.String r7) throws java.io.IOException {
        /*
        r6 = this;
        r0 = r6.list(r7);
        r1 = r0.size();
        r2 = 2;
        if (r1 >= r2) goto L_0x0013;
    L_0x000b:
        r7 = java.lang.System.err;
        r0 = "Nowhere to rollback.";
        r7.println(r0);
        return;
    L_0x0013:
        r1 = 0;
        r3 = new java.io.RandomAccessFile;	 Catch:{ all -> 0x0060 }
        r4 = new java.io.File;	 Catch:{ all -> 0x0060 }
        r4.<init>(r7);	 Catch:{ all -> 0x0060 }
        r7 = "rw";
        r3.<init>(r4, r7);	 Catch:{ all -> 0x0060 }
        r7 = r0.size();	 Catch:{ all -> 0x005e }
        r7 = r7 - r2;
        r7 = r0.get(r7);	 Catch:{ all -> 0x005e }
        r7 = (org.jcodec.containers.mp4.MP4Util.Atom) r7;	 Catch:{ all -> 0x005e }
        r1 = r7.getOffset();	 Catch:{ all -> 0x005e }
        r4 = 4;
        r1 = r1 + r4;
        r3.seek(r1);	 Catch:{ all -> 0x005e }
        r7 = 4;
        r1 = new byte[r7];	 Catch:{ all -> 0x005e }
        r1 = {109, 111, 111, 118};	 Catch:{ all -> 0x005e }
        r3.write(r1);	 Catch:{ all -> 0x005e }
        r1 = r0.size();	 Catch:{ all -> 0x005e }
        r1 = r1 + -1;
        r0 = r0.get(r1);	 Catch:{ all -> 0x005e }
        r0 = (org.jcodec.containers.mp4.MP4Util.Atom) r0;	 Catch:{ all -> 0x005e }
        r0 = r0.getOffset();	 Catch:{ all -> 0x005e }
        r0 = r0 + r4;
        r3.seek(r0);	 Catch:{ all -> 0x005e }
        r7 = new byte[r7];	 Catch:{ all -> 0x005e }
        r7 = {102, 114, 101, 101};	 Catch:{ all -> 0x005e }
        r3.write(r7);	 Catch:{ all -> 0x005e }
        r3.close();
        return;
    L_0x005e:
        r7 = move-exception;
        goto L_0x0062;
    L_0x0060:
        r7 = move-exception;
        r3 = r1;
    L_0x0062:
        r3.close();
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.movtool.Undo.undo(java.lang.String):void");
    }

    private List<Atom> list(String str) throws IOException {
        Throwable th;
        List arrayList = new ArrayList();
        try {
            str = NIOUtils.readableFileChannel(new File(str));
            try {
                for (Atom atom : MP4Util.getRootAtoms(str)) {
                    if (FreeBox.TYPE.equals(atom.getHeader().getFourcc()) && isMoov(str, atom)) {
                        arrayList.add(atom);
                    }
                    if (MovieBox.TYPE.equals(atom.getHeader().getFourcc())) {
                        arrayList.add(atom);
                        break;
                    }
                }
                str.close();
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                str.close();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            str = null;
            str.close();
            throw th;
        }
    }

    private boolean isMoov(org.jcodec.common.SeekableByteChannel r6, org.jcodec.containers.mp4.MP4Util.Atom r7) throws java.io.IOException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = r7.getOffset();
        r2 = r7.getHeader();
        r2 = r2.headerSize();
        r0 = r0 + r2;
        r6.position(r0);
        r0 = 0;
        r1 = r7.getHeader();	 Catch:{ Throwable -> 0x004a }
        r1 = r1.getSize();	 Catch:{ Throwable -> 0x004a }
        r1 = (int) r1;	 Catch:{ Throwable -> 0x004a }
        r6 = org.jcodec.common.NIOUtils.fetchFrom(r6, r1);	 Catch:{ Throwable -> 0x004a }
        r1 = new org.jcodec.containers.mp4.boxes.Header;	 Catch:{ Throwable -> 0x004a }
        r2 = "moov";	 Catch:{ Throwable -> 0x004a }
        r7 = r7.getHeader();	 Catch:{ Throwable -> 0x004a }
        r3 = r7.getSize();	 Catch:{ Throwable -> 0x004a }
        r1.<init>(r2, r3);	 Catch:{ Throwable -> 0x004a }
        r7 = org.jcodec.containers.mp4.boxes.BoxFactory.getDefault();	 Catch:{ Throwable -> 0x004a }
        r6 = org.jcodec.containers.mp4.boxes.NodeBox.parseBox(r6, r1, r7);	 Catch:{ Throwable -> 0x004a }
        r7 = r6 instanceof org.jcodec.containers.mp4.boxes.MovieBox;	 Catch:{ Throwable -> 0x004a }
        if (r7 == 0) goto L_0x0049;	 Catch:{ Throwable -> 0x004a }
    L_0x0039:
        r6 = (org.jcodec.containers.mp4.boxes.NodeBox) r6;	 Catch:{ Throwable -> 0x004a }
        r7 = "mvhd";	 Catch:{ Throwable -> 0x004a }
        r7 = new java.lang.String[]{r7};	 Catch:{ Throwable -> 0x004a }
        r6 = org.jcodec.containers.mp4.boxes.Box.findFirst(r6, r7);	 Catch:{ Throwable -> 0x004a }
        if (r6 == 0) goto L_0x0049;
    L_0x0047:
        r6 = 1;
        return r6;
    L_0x0049:
        return r0;
    L_0x004a:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.movtool.Undo.isMoov(org.jcodec.common.SeekableByteChannel, org.jcodec.containers.mp4.MP4Util$Atom):boolean");
    }
}
