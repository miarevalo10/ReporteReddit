package org.jcodec.movtool;

import java.io.File;
import java.nio.ByteBuffer;
import org.jcodec.codecs.prores.ProresFix;
import org.jcodec.containers.mp4.MP4Packet;

public class ReExport extends Remux {
    private ByteBuffer outBuf;

    protected MP4Packet processFrame(MP4Packet mP4Packet) {
        if (this.outBuf == null) {
            this.outBuf = ByteBuffer.allocate(mP4Packet.getData().remaining() * 2);
        }
        return new MP4Packet(mP4Packet, ProresFix.transcode(mP4Packet.getData(), this.outBuf));
    }

    public static void main(String[] strArr) throws Exception {
        if (strArr.length <= 0) {
            System.out.println("reexport <movie> <out>");
            return;
        }
        File file = new File(strArr[0]);
        strArr = Remux.hidFile(file);
        file.renameTo(strArr);
        try {
            new ReExport().remux(file, strArr, null, null);
        } catch (Throwable th) {
            th.printStackTrace();
            File parentFile = file.getParentFile();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(file.getName());
            stringBuilder.append(".error");
            file.renameTo(new File(parentFile, stringBuilder.toString()));
            strArr.renameTo(file);
        }
    }
}
