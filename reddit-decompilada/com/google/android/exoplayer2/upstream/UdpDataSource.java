package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;

public final class UdpDataSource implements DataSource {
    private final TransferListener<? super UdpDataSource> f13696a;
    private final int f13697b;
    private final byte[] f13698c;
    private final DatagramPacket f13699d;
    private Uri f13700e;
    private DatagramSocket f13701f;
    private MulticastSocket f13702g;
    private InetAddress f13703h;
    private InetSocketAddress f13704i;
    private boolean f13705j;
    private int f13706k;

    public static final class UdpDataSourceException extends IOException {
        public UdpDataSourceException(IOException iOException) {
            super(iOException);
        }
    }

    public final long mo1435a(DataSpec dataSpec) throws UdpDataSourceException {
        this.f13700e = dataSpec.f5167a;
        dataSpec = this.f13700e.getHost();
        int port = this.f13700e.getPort();
        try {
            this.f13703h = InetAddress.getByName(dataSpec);
            this.f13704i = new InetSocketAddress(this.f13703h, port);
            if (this.f13703h.isMulticastAddress() != null) {
                this.f13702g = new MulticastSocket(this.f13704i);
                this.f13702g.joinGroup(this.f13703h);
                this.f13701f = this.f13702g;
            } else {
                this.f13701f = new DatagramSocket(this.f13704i);
            }
            try {
                this.f13701f.setSoTimeout(this.f13697b);
                this.f13705j = true;
                if (this.f13696a != null) {
                    this.f13696a.mo1473b();
                }
                return -1;
            } catch (DataSpec dataSpec2) {
                throw new UdpDataSourceException(dataSpec2);
            }
        } catch (DataSpec dataSpec22) {
            throw new UdpDataSourceException(dataSpec22);
        }
    }

    public final int mo1434a(byte[] bArr, int i, int i2) throws UdpDataSourceException {
        if (i2 == 0) {
            return null;
        }
        if (this.f13706k == 0) {
            try {
                this.f13701f.receive(this.f13699d);
                this.f13706k = this.f13699d.getLength();
                if (this.f13696a != null) {
                    this.f13696a.mo1472a(this.f13706k);
                }
            } catch (byte[] bArr2) {
                throw new UdpDataSourceException(bArr2);
            }
        }
        int length = this.f13699d.getLength() - this.f13706k;
        i2 = Math.min(this.f13706k, i2);
        System.arraycopy(this.f13698c, length, bArr2, i, i2);
        this.f13706k -= i2;
        return i2;
    }

    public final Uri mo1437b() {
        return this.f13700e;
    }

    public final void mo1436a() {
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
        r3 = this;
        r0 = 0;
        r3.f13700e = r0;
        r1 = r3.f13702g;
        if (r1 == 0) goto L_0x0010;
    L_0x0007:
        r1 = r3.f13702g;	 Catch:{ IOException -> 0x000e }
        r2 = r3.f13703h;	 Catch:{ IOException -> 0x000e }
        r1.leaveGroup(r2);	 Catch:{ IOException -> 0x000e }
    L_0x000e:
        r3.f13702g = r0;
    L_0x0010:
        r1 = r3.f13701f;
        if (r1 == 0) goto L_0x001b;
    L_0x0014:
        r1 = r3.f13701f;
        r1.close();
        r3.f13701f = r0;
    L_0x001b:
        r3.f13703h = r0;
        r3.f13704i = r0;
        r0 = 0;
        r3.f13706k = r0;
        r1 = r3.f13705j;
        if (r1 == 0) goto L_0x0031;
    L_0x0026:
        r3.f13705j = r0;
        r0 = r3.f13696a;
        if (r0 == 0) goto L_0x0031;
    L_0x002c:
        r0 = r3.f13696a;
        r0.mo1474c();
    L_0x0031:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.upstream.UdpDataSource.a():void");
    }
}
