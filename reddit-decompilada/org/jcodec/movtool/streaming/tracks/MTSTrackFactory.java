package org.jcodec.movtool.streaming.tracks;

import com.google.android.gms.auth.api.credentials.CredentialsApi;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.List;
import org.jcodec.common.Assert;
import org.jcodec.common.NIOUtils;
import org.jcodec.common.SeekableByteChannel;
import org.jcodec.containers.mps.MPSUtils;
import org.jcodec.movtool.streaming.VirtualPacket;
import org.jcodec.movtool.streaming.tracks.MPSTrackFactory.Stream;

public class MTSTrackFactory {
    private List<MTSProgram> programs = new ArrayList();

    public class MTSProgram extends MPSTrackFactory {
        private int targetGuid;

        public class MTSStream extends Stream {
            public MTSStream(int i) {
                super(i);
            }

            protected ByteBuffer readPes(SeekableByteChannel seekableByteChannel, long j, int i, int i2, int i3) throws IOException {
                seekableByteChannel.position(j * 188);
                ByteBuffer fetchFrom = NIOUtils.fetchFrom((ReadableByteChannel) seekableByteChannel, i * 188);
                ByteBuffer duplicate = fetchFrom.duplicate();
                while (fetchFrom.hasRemaining() != 0) {
                    i = NIOUtils.read(fetchFrom, 188);
                    Assert.assertEquals(71, i.get() & 255);
                    if (((((i.get() & 255) << 8) | (i.get() & 255)) & 8191) == MTSProgram.this.targetGuid) {
                        if (((i.get() & 255) & 32) != 0) {
                            NIOUtils.skip(i, i.get() & 255);
                        }
                        duplicate.put(i);
                    }
                }
                duplicate.flip();
                MPSUtils.readPESHeader(duplicate, null);
                duplicate.limit(duplicate.position() + i2);
                return duplicate;
            }
        }

        public MTSProgram(ByteBuffer byteBuffer, FilePool filePool) throws IOException {
            super(byteBuffer, filePool);
        }

        protected void readIndex(ByteBuffer byteBuffer) throws IOException {
            this.targetGuid = byteBuffer.getShort() & 65535;
            super.readIndex(byteBuffer);
        }

        protected Stream createStream(int i) {
            return new MTSStream(i);
        }
    }

    public MTSTrackFactory(ByteBuffer byteBuffer, FilePool filePool) throws IOException {
        while (byteBuffer.remaining() >= 6) {
            this.programs.add(new MTSProgram(NIOUtils.read(byteBuffer, byteBuffer.getInt() - 4), filePool));
        }
    }

    public List<Stream> getVideoStreams() {
        List<Stream> arrayList = new ArrayList();
        for (MTSProgram videoStreams : this.programs) {
            arrayList.addAll(videoStreams.getVideoStreams());
        }
        return arrayList;
    }

    public List<Stream> getAudioStreams() {
        List<Stream> arrayList = new ArrayList();
        for (MTSProgram audioStreams : this.programs) {
            arrayList.addAll(audioStreams.getAudioStreams());
        }
        return arrayList;
    }

    public List<Stream> getStreams() {
        List<Stream> arrayList = new ArrayList();
        for (MTSProgram streams : this.programs) {
            arrayList.addAll(streams.getStreams());
        }
        return arrayList;
    }

    public static void main(String[] strArr) throws IOException {
        int i = 0;
        Stream stream = (Stream) new MTSTrackFactory(NIOUtils.fetchFrom(new File(strArr[1])), new FilePool(new File(strArr[0]), 10)).getVideoStreams().get(0);
        strArr = NIOUtils.writableFileChannel(new File(strArr[2]));
        List<VirtualPacket> arrayList = new ArrayList();
        while (i < CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE) {
            arrayList.add(stream.nextPacket());
            i++;
        }
        for (VirtualPacket data : arrayList) {
            strArr.write(data.getData());
        }
        strArr.close();
    }
}
