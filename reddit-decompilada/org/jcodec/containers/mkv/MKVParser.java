package org.jcodec.containers.mkv;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.jcodec.common.SeekableByteChannel;
import org.jcodec.containers.mkv.boxes.EbmlBase;
import org.jcodec.containers.mkv.boxes.EbmlBin;
import org.jcodec.containers.mkv.boxes.EbmlMaster;
import org.jcodec.containers.mkv.boxes.EbmlVoid;
import org.jcodec.containers.mkv.util.EbmlUtil;

public class MKVParser {
    private SeekableByteChannel channel;
    private LinkedList<EbmlMaster> trace = new LinkedList();

    private void openElem(EbmlBase ebmlBase) {
    }

    public MKVParser(SeekableByteChannel seekableByteChannel) {
        this.channel = seekableByteChannel;
    }

    public List<EbmlMaster> parse() throws IOException {
        List<EbmlMaster> arrayList = new ArrayList();
        while (true) {
            EbmlBase nextElement = nextElement();
            if (nextElement == null) {
                break;
            }
            if (!isKnownType(nextElement.id)) {
                PrintStream printStream = System.err;
                StringBuilder stringBuilder = new StringBuilder("Unspecified header: ");
                stringBuilder.append(EbmlUtil.toHexString(nextElement.id));
                stringBuilder.append(" at ");
                stringBuilder.append(nextElement.offset);
                printStream.println(stringBuilder.toString());
            }
            while (!possibleChild((EbmlMaster) this.trace.peekFirst(), nextElement)) {
                closeElem((EbmlMaster) this.trace.removeFirst(), arrayList);
            }
            openElem(nextElement);
            if (nextElement instanceof EbmlMaster) {
                this.trace.push((EbmlMaster) nextElement);
            } else if (nextElement instanceof EbmlBin) {
                EbmlBin ebmlBin = (EbmlBin) nextElement;
                EbmlMaster ebmlMaster = (EbmlMaster) this.trace.peekFirst();
                if (ebmlMaster.dataOffset + ((long) ebmlMaster.dataLen) < nextElement.dataOffset + ((long) nextElement.dataLen)) {
                    this.channel.position(ebmlMaster.dataOffset + ((long) ebmlMaster.dataLen));
                } else {
                    try {
                        ebmlBin.read(this.channel);
                    } catch (Throwable e) {
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(nextElement.type);
                        stringBuilder2.append(" 0x");
                        stringBuilder2.append(EbmlUtil.toHexString(ebmlBin.id));
                        stringBuilder2.append(" size: ");
                        stringBuilder2.append(Long.toHexString((long) ebmlBin.dataLen));
                        stringBuilder2.append(" offset: 0x");
                        stringBuilder2.append(Long.toHexString(nextElement.offset));
                        throw new RuntimeException(stringBuilder2.toString(), e);
                    }
                }
                ((EbmlMaster) this.trace.peekFirst()).add(nextElement);
            } else if (nextElement instanceof EbmlVoid) {
                ((EbmlVoid) nextElement).skip(this.channel);
            } else {
                throw new RuntimeException("Currently there are no elements that are neither Master nor Binary, should never actually get here");
            }
        }
        while (this.trace.peekFirst() != null) {
            closeElem((EbmlMaster) this.trace.removeFirst(), arrayList);
        }
        return arrayList;
    }

    private boolean possibleChild(EbmlMaster ebmlMaster, EbmlBase ebmlBase) {
        if (ebmlMaster == null || !MKVType.Cluster.equals(ebmlMaster.type) || ebmlBase == null || MKVType.Cluster.equals(ebmlBase.type) || MKVType.Info.equals(ebmlBase.type) || MKVType.SeekHead.equals(ebmlBase.type) || MKVType.Tracks.equals(ebmlBase.type) || MKVType.Cues.equals(ebmlBase.type) || MKVType.Attachments.equals(ebmlBase.type) || MKVType.Tags.equals(ebmlBase.type) || MKVType.Chapters.equals(ebmlBase.type)) {
            return MKVType.possibleChild(ebmlMaster, ebmlBase);
        }
        return true;
    }

    private void closeElem(EbmlMaster ebmlMaster, List<EbmlMaster> list) {
        if (this.trace.peekFirst() == null) {
            list.add(ebmlMaster);
        } else {
            ((EbmlMaster) this.trace.peekFirst()).add(ebmlMaster);
        }
    }

    private EbmlBase nextElement() throws IOException {
        long position = this.channel.position();
        if (position >= this.channel.size()) {
            return null;
        }
        byte[] readEbmlId;
        long readEbmlInt;
        EbmlBase createById;
        while (true) {
            readEbmlId = readEbmlId(this.channel);
            if (readEbmlId != null || isKnownType(readEbmlId) || position >= this.channel.size()) {
                readEbmlInt = readEbmlInt(this.channel);
                createById = MKVType.createById(readEbmlId, position);
                createById.offset = position;
                createById.typeSizeLength = (int) (this.channel.position() - position);
                createById.dataOffset = this.channel.position();
                createById.dataLen = (int) readEbmlInt;
            } else {
                position++;
                this.channel.position(position);
            }
        }
        readEbmlInt = readEbmlInt(this.channel);
        createById = MKVType.createById(readEbmlId, position);
        createById.offset = position;
        createById.typeSizeLength = (int) (this.channel.position() - position);
        createById.dataOffset = this.channel.position();
        createById.dataLen = (int) readEbmlInt;
        return createById;
    }

    public boolean isKnownType(byte[] bArr) {
        if (this.trace.isEmpty() || !MKVType.Cluster.equals(((EbmlMaster) this.trace.peekFirst()).type)) {
            return MKVType.isSpecifiedHeader(bArr);
        }
        return 1;
    }

    public static byte[] readEbmlId(SeekableByteChannel seekableByteChannel) throws IOException {
        if (seekableByteChannel.position() == seekableByteChannel.size()) {
            return null;
        }
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.limit(1);
        seekableByteChannel.read(allocate);
        allocate.flip();
        int computeLength = EbmlUtil.computeLength(allocate.get());
        if (computeLength == 0) {
            return null;
        }
        if (computeLength > 1) {
            allocate.limit(computeLength);
            seekableByteChannel.read(allocate);
        }
        allocate.flip();
        seekableByteChannel = ByteBuffer.allocate(allocate.remaining());
        seekableByteChannel.put(allocate);
        return seekableByteChannel.array();
    }

    public static long readEbmlInt(SeekableByteChannel seekableByteChannel) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.limit(1);
        seekableByteChannel.read(allocate);
        allocate.flip();
        byte b = allocate.get();
        int computeLength = EbmlUtil.computeLength(b);
        if (computeLength == 0) {
            throw new RuntimeException("Invalid ebml integer size.");
        }
        allocate.limit(computeLength);
        seekableByteChannel.read(allocate);
        allocate.position(1);
        long j = (long) ((255 >>> computeLength) & b);
        for (computeLength--; computeLength > 0; computeLength--) {
            j = (j << 8) | ((long) (allocate.get() & 255));
        }
        return j;
    }
}
