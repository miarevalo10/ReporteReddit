package org.jcodec.codecs.h264.decode;

import org.jcodec.codecs.h264.H264Utils;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.tools.Debug;

public class CAVLCReader {
    public static int readTE(org.jcodec.common.io.BitReader r1, int r2) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: org.jcodec.codecs.h264.decode.CAVLCReader.readTE(org.jcodec.common.io.BitReader, int):int
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: jadx.core.utils.exceptions.DecodeException: Unknown instruction: not-int
	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:568)
	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:56)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:102)
	... 5 more
*/
        /*
        // Can't load method instructions.
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.codecs.h264.decode.CAVLCReader.readTE(org.jcodec.common.io.BitReader, int):int");
    }

    private CAVLCReader() {
    }

    public static int readNBit(BitReader bitReader, int i, String str) {
        Debug.trace(str, new Object[]{Integer.valueOf(bitReader.readNBit(i))});
        return bitReader.readNBit(i);
    }

    public static int readUE(BitReader bitReader) {
        int i = 0;
        while (bitReader.read1Bit() == 0 && i < 31) {
            i++;
        }
        if (i <= 0) {
            return 0;
        }
        return (int) (((long) ((1 << i) - 1)) + ((long) bitReader.readNBit(i)));
    }

    public static int readUE(BitReader bitReader, String str) {
        Debug.trace(str, Integer.valueOf(readUE(bitReader)));
        return readUE(bitReader);
    }

    public static int readSE(BitReader bitReader, String str) {
        Debug.trace(str, Integer.valueOf(H264Utils.golomb2Signed(readUE(bitReader))));
        return H264Utils.golomb2Signed(readUE(bitReader));
    }

    public static boolean readBool(BitReader bitReader, String str) {
        Debug.trace(str, Integer.valueOf(bitReader.read1Bit() == null ? null : 1));
        return bitReader.read1Bit() == null ? null : 1;
    }

    public static int readU(BitReader bitReader, int i, String str) {
        return readNBit(bitReader, i, str);
    }

    public static int readME(BitReader bitReader, String str) {
        return readUE(bitReader, str);
    }

    public static int readZeroBitCount(BitReader bitReader, String str) {
        int i = 0;
        while (bitReader.read1Bit() == 0 && i < 32) {
            i++;
        }
        Debug.trace(str, new Object[]{String.valueOf(i)});
        return i;
    }

    public static boolean moreRBSPData(BitReader bitReader) {
        if (bitReader.remaining() < 32 && bitReader.checkNBit(1) == 1) {
            if ((bitReader.checkNBit(24) << 9) == null) {
                return null;
            }
        }
        return true;
    }
}
