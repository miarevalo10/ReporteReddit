package org.jcodec.movtool.streaming;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Comparator;

public interface VirtualPacket {
    public static final Comparator<? super VirtualPacket> byPts = new C22151();

    static class C22151 implements Comparator<VirtualPacket> {
        C22151() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            VirtualPacket virtualPacket = (VirtualPacket) obj;
            VirtualPacket virtualPacket2 = (VirtualPacket) obj2;
            if (virtualPacket == null && virtualPacket2 == null) {
                return 0;
            }
            if (virtualPacket == null) {
                return -1;
            }
            if (virtualPacket2 != null) {
                if (virtualPacket.getPts() < virtualPacket2.getPts()) {
                    return -1;
                }
                if (virtualPacket.getPts() == virtualPacket2.getPts()) {
                    return 0;
                }
            }
            return 1;
        }
    }

    ByteBuffer getData() throws IOException;

    int getDataLen() throws IOException;

    double getDuration();

    int getFrameNo();

    double getPts();

    boolean isKeyframe();
}
