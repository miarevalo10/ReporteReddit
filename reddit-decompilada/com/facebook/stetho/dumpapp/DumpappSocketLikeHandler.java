package com.facebook.stetho.dumpapp;

import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.server.SocketLike;
import com.facebook.stetho.server.SocketLikeHandler;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class DumpappSocketLikeHandler implements SocketLikeHandler {
    public static final byte[] PROTOCOL_MAGIC = new byte[]{(byte) 68, (byte) 85, (byte) 77, (byte) 80};
    public static final int PROTOCOL_VERSION = 1;
    private final Dumper mDumper;

    public DumpappSocketLikeHandler(Dumper dumper) {
        this.mDumper = dumper;
    }

    public void onAccepted(SocketLike socketLike) throws IOException {
        InputStream dataInputStream = new DataInputStream(socketLike.getInput());
        establishConversation(dataInputStream);
        Framer framer = new Framer(dataInputStream, socketLike.getOutput());
        dump(this.mDumper, framer, readArgs(framer));
    }

    static void dump(com.facebook.stetho.dumpapp.Dumper r3, com.facebook.stetho.dumpapp.Framer r4, java.lang.String[] r5) throws java.io.IOException {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = r4.getStdin();	 Catch:{ DumpappOutputBrokenException -> 0x0014 }
        r1 = r4.getStdout();	 Catch:{ DumpappOutputBrokenException -> 0x0014 }
        r2 = r4.getStderr();	 Catch:{ DumpappOutputBrokenException -> 0x0014 }
        r3 = r3.dump(r0, r1, r2, r5);	 Catch:{ DumpappOutputBrokenException -> 0x0014 }
        r4.writeExitCode(r3);	 Catch:{ DumpappOutputBrokenException -> 0x0014 }
        return;
    L_0x0014:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.stetho.dumpapp.DumpappSocketLikeHandler.dump(com.facebook.stetho.dumpapp.Dumper, com.facebook.stetho.dumpapp.Framer, java.lang.String[]):void");
    }

    private void establishConversation(DataInputStream dataInputStream) throws IOException {
        byte[] bArr = new byte[4];
        dataInputStream.readFully(bArr);
        if (Arrays.equals(PROTOCOL_MAGIC, bArr)) {
            dataInputStream = dataInputStream.readInt();
            if (dataInputStream != 1) {
                StringBuilder stringBuilder = new StringBuilder("Expected version=1; got=");
                stringBuilder.append(dataInputStream);
                throw logAndThrowProtocolException(stringBuilder.toString());
            }
            return;
        }
        throw logAndThrowProtocolException("Incompatible protocol, are you using an old dumpapp script?");
    }

    private static IOException logAndThrowProtocolException(String str) throws IOException {
        LogUtil.m3447w(str);
        throw new IOException(str);
    }

    private String[] readArgs(Framer framer) throws IOException {
        String[] strArr;
        synchronized (framer) {
            byte readFrameType = framer.readFrameType();
            if (readFrameType != Framer.ENTER_FRAME_PREFIX) {
                StringBuilder stringBuilder = new StringBuilder("Expected enter frame, got: ");
                stringBuilder.append(readFrameType);
                throw new DumpappFramingException(stringBuilder.toString());
            }
            int readInt = framer.readInt();
            strArr = new String[readInt];
            for (int i = 0; i < readInt; i++) {
                strArr[i] = framer.readString();
            }
        }
        return strArr;
    }
}
