package org.jcodec.movtool;

import com.coremedia.iso.boxes.fragment.MovieExtendsBox;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.util.LinkedList;
import java.util.List;
import org.jcodec.common.Assert;
import org.jcodec.common.NIOUtils;
import org.jcodec.common.SeekableByteChannel;
import org.jcodec.common.Tuple;
import org.jcodec.common.Tuple.Mapper;
import org.jcodec.common.Tuple._2;
import org.jcodec.containers.mp4.MP4Util;
import org.jcodec.containers.mp4.MP4Util.Atom;
import org.jcodec.containers.mp4.boxes.Box;
import org.jcodec.containers.mp4.boxes.BoxFactory;
import org.jcodec.containers.mp4.boxes.Header;
import org.jcodec.containers.mp4.boxes.MovieBox;
import org.jcodec.containers.mp4.boxes.MovieFragmentBox;
import org.jcodec.containers.mp4.boxes.NodeBox;

public class InplaceMP4Editor {

    class C26541 implements Mapper<Atom, Long> {
        final /* synthetic */ InplaceMP4Editor f33309a;

        C26541(InplaceMP4Editor inplaceMP4Editor) {
            this.f33309a = inplaceMP4Editor;
        }

        public /* synthetic */ Object map(Object obj) {
            return Long.valueOf(((Atom) obj).getOffset());
        }
    }

    public boolean modify(File file, MP4Edit mP4Edit) throws IOException {
        ReadableByteChannel rwFileChannel;
        try {
            rwFileChannel = NIOUtils.rwFileChannel(file);
            try {
                MP4Edit<_2> doTheFix = doTheFix(rwFileChannel, mP4Edit);
                if (doTheFix == null) {
                    NIOUtils.closeQuietly(rwFileChannel);
                    return null;
                }
                for (_2 _2 : doTheFix) {
                    replaceBox(rwFileChannel, (Atom) _2.v0, (ByteBuffer) _2.v1);
                }
                NIOUtils.closeQuietly(rwFileChannel);
                return true;
            } catch (Throwable th) {
                mP4Edit = th;
                NIOUtils.closeQuietly(rwFileChannel);
                throw mP4Edit;
            }
        } catch (Throwable th2) {
            mP4Edit = th2;
            rwFileChannel = null;
            NIOUtils.closeQuietly(rwFileChannel);
            throw mP4Edit;
        }
    }

    public boolean copy(File file, File file2, MP4Edit mP4Edit) throws IOException {
        ReadableByteChannel readableFileChannel;
        ReadableByteChannel writableFileChannel;
        try {
            readableFileChannel = NIOUtils.readableFileChannel(file);
            try {
                writableFileChannel = NIOUtils.writableFileChannel(file2);
            } catch (Throwable th) {
                mP4Edit = th;
                writableFileChannel = null;
                NIOUtils.closeQuietly(readableFileChannel);
                NIOUtils.closeQuietly(writableFileChannel);
                throw mP4Edit;
            }
            try {
                mP4Edit = doTheFix(readableFileChannel, mP4Edit);
                if (mP4Edit == null) {
                    NIOUtils.closeQuietly(readableFileChannel);
                    NIOUtils.closeQuietly(writableFileChannel);
                    return null;
                }
                mP4Edit = Tuple.asMap(Tuple._2map0(mP4Edit, new C26541(this)));
                for (Atom atom : MP4Util.getRootAtoms(readableFileChannel)) {
                    ByteBuffer byteBuffer = (ByteBuffer) mP4Edit.get(Long.valueOf(atom.getOffset()));
                    if (byteBuffer != null) {
                        writableFileChannel.write(byteBuffer);
                    } else {
                        atom.copy(readableFileChannel, writableFileChannel);
                    }
                }
                NIOUtils.closeQuietly(readableFileChannel);
                NIOUtils.closeQuietly(writableFileChannel);
                return true;
            } catch (Throwable th2) {
                mP4Edit = th2;
                NIOUtils.closeQuietly(readableFileChannel);
                NIOUtils.closeQuietly(writableFileChannel);
                throw mP4Edit;
            }
        } catch (Throwable th3) {
            mP4Edit = th3;
            readableFileChannel = null;
            writableFileChannel = readableFileChannel;
            NIOUtils.closeQuietly(readableFileChannel);
            NIOUtils.closeQuietly(writableFileChannel);
            throw mP4Edit;
        }
    }

    public boolean replace(File file, MP4Edit mP4Edit) throws IOException {
        File parentFile = file.getParentFile();
        StringBuilder stringBuilder = new StringBuilder(".");
        stringBuilder.append(file.getName());
        File file2 = new File(parentFile, stringBuilder.toString());
        if (copy(file, file2, mP4Edit) == null) {
            return null;
        }
        file2.renameTo(file);
        return true;
    }

    private List<_2<Atom, ByteBuffer>> doTheFix(SeekableByteChannel seekableByteChannel, MP4Edit mP4Edit) throws IOException {
        Atom moov = getMoov(seekableByteChannel);
        Assert.assertNotNull(moov);
        ByteBuffer fetchBox = fetchBox(seekableByteChannel, moov);
        MovieBox movieBox = (MovieBox) parseBox(fetchBox);
        List<_2<Atom, ByteBuffer>> linkedList = new LinkedList();
        if (Box.findFirst(movieBox, MovieExtendsBox.TYPE) != null) {
            List<_2> linkedList2 = new LinkedList();
            for (Atom atom : getFragments(seekableByteChannel)) {
                ByteBuffer fetchBox2 = fetchBox(seekableByteChannel, atom);
                linkedList.add(Tuple._2(atom, fetchBox2));
                MovieFragmentBox movieFragmentBox = (MovieFragmentBox) parseBox(fetchBox2);
                movieFragmentBox.setMovie(movieBox);
                linkedList2.add(Tuple._2(fetchBox2, movieFragmentBox));
            }
            mP4Edit.apply(movieBox, (MovieFragmentBox[]) Tuple._2_project1(linkedList2).toArray(new MovieFragmentBox[0]));
            for (_2 _2 : linkedList2) {
                if (rewriteBox((ByteBuffer) _2.v0, (Box) _2.v1) == null) {
                    return null;
                }
            }
        }
        mP4Edit.apply(movieBox);
        if (rewriteBox(fetchBox, movieBox) == null) {
            return null;
        }
        linkedList.add(Tuple._2(moov, fetchBox));
        return linkedList;
    }

    private void replaceBox(SeekableByteChannel seekableByteChannel, Atom atom, ByteBuffer byteBuffer) throws IOException {
        seekableByteChannel.position(atom.getOffset());
        seekableByteChannel.write(byteBuffer);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean rewriteBox(java.nio.ByteBuffer r3, org.jcodec.containers.mp4.boxes.Box r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = 0;
        r3.clear();	 Catch:{ BufferOverflowException -> 0x002b }
        r4.write(r3);	 Catch:{ BufferOverflowException -> 0x002b }
        r4 = r3.hasRemaining();	 Catch:{ BufferOverflowException -> 0x002b }
        if (r4 == 0) goto L_0x0026;	 Catch:{ BufferOverflowException -> 0x002b }
    L_0x000d:
        r4 = r3.remaining();	 Catch:{ BufferOverflowException -> 0x002b }
        r1 = 8;	 Catch:{ BufferOverflowException -> 0x002b }
        if (r4 >= r1) goto L_0x0016;	 Catch:{ BufferOverflowException -> 0x002b }
    L_0x0015:
        return r0;	 Catch:{ BufferOverflowException -> 0x002b }
    L_0x0016:
        r4 = r3.remaining();	 Catch:{ BufferOverflowException -> 0x002b }
        r3.putInt(r4);	 Catch:{ BufferOverflowException -> 0x002b }
        r4 = 4;	 Catch:{ BufferOverflowException -> 0x002b }
        r4 = new byte[r4];	 Catch:{ BufferOverflowException -> 0x002b }
        r4 = {102, 114, 101, 101};	 Catch:{ BufferOverflowException -> 0x002b }
        r3.put(r4);	 Catch:{ BufferOverflowException -> 0x002b }
    L_0x0026:
        r3.flip();	 Catch:{ BufferOverflowException -> 0x002b }
        r3 = 1;
        return r3;
    L_0x002b:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.movtool.InplaceMP4Editor.rewriteBox(java.nio.ByteBuffer, org.jcodec.containers.mp4.boxes.Box):boolean");
    }

    private ByteBuffer fetchBox(SeekableByteChannel seekableByteChannel, Atom atom) throws IOException {
        seekableByteChannel.position(atom.getOffset());
        return NIOUtils.fetchFrom((ReadableByteChannel) seekableByteChannel, (int) atom.getHeader().getSize());
    }

    private Box parseBox(ByteBuffer byteBuffer) {
        return NodeBox.parseBox(byteBuffer, Header.read(byteBuffer), BoxFactory.getDefault());
    }

    private Atom getMoov(SeekableByteChannel seekableByteChannel) throws IOException {
        for (Atom atom : MP4Util.getRootAtoms(seekableByteChannel)) {
            if (com.coremedia.iso.boxes.MovieBox.TYPE.equals(atom.getHeader().getFourcc())) {
                return atom;
            }
        }
        return null;
    }

    private List<Atom> getFragments(SeekableByteChannel seekableByteChannel) throws IOException {
        List<Atom> linkedList = new LinkedList();
        for (Atom atom : MP4Util.getRootAtoms(seekableByteChannel)) {
            if (com.coremedia.iso.boxes.fragment.MovieFragmentBox.TYPE.equals(atom.getHeader().getFourcc())) {
                linkedList.add(atom);
            }
        }
        return linkedList;
    }
}
