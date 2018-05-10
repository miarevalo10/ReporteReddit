package com.google.android.exoplayer2.upstream.cache;

import android.util.SparseArray;
import com.google.android.exoplayer2.upstream.cache.Cache.CacheException;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.AtomicFile;
import com.google.android.exoplayer2.util.ReusableBufferedOutputStream;
import com.google.android.exoplayer2.util.Util;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

class CachedContentIndex {
    final HashMap<String, CachedContent> f5202a;
    final SparseArray<String> f5203b;
    final AtomicFile f5204c;
    boolean f5205d;
    private final Cipher f5206e;
    private final SecretKeySpec f5207f;
    private final boolean f5208g;
    private ReusableBufferedOutputStream f5209h;

    public CachedContentIndex(File file, byte[] bArr, boolean z) {
        this.f5208g = z;
        if (bArr != null) {
            Assertions.m4184a(bArr.length);
            try {
                this.f5206e = m4172d();
                this.f5207f = new SecretKeySpec(bArr, "AES");
            } catch (File file2) {
                throw new IllegalStateException(file2);
            }
        }
        this.f5206e = null;
        this.f5207f = null;
        this.f5202a = new HashMap();
        this.f5203b = new SparseArray();
        this.f5204c = new AtomicFile(new File(file2, "cached_content_index.exi"));
    }

    public final void m4175a() throws CacheException {
        Closeable dataOutputStream;
        Throwable e;
        IOException e2;
        if (this.f5205d) {
            try {
                OutputStream a = this.f5204c.m4188a();
                if (this.f5209h == null) {
                    this.f5209h = new ReusableBufferedOutputStream(a);
                } else {
                    this.f5209h.m4281a(a);
                }
                dataOutputStream = new DataOutputStream(this.f5209h);
                try {
                    dataOutputStream.writeInt(1);
                    int i = (!this.f5208g || this.f5206e == null) ? 0 : 1;
                    dataOutputStream.writeInt(i);
                    if (i != 0) {
                        byte[] bArr = new byte[16];
                        new Random().nextBytes(bArr);
                        dataOutputStream.write(bArr);
                        this.f5206e.init(1, this.f5207f, new IvParameterSpec(bArr));
                        dataOutputStream.flush();
                        a = new DataOutputStream(new CipherOutputStream(this.f5209h, this.f5206e));
                    }
                    a.writeInt(this.f5202a.size());
                    i = 0;
                    for (CachedContent cachedContent : this.f5202a.values()) {
                        a.writeInt(cachedContent.f5198a);
                        a.writeUTF(cachedContent.f5199b);
                        a.writeLong(cachedContent.f5201d);
                        i += cachedContent.m4168a();
                    }
                    a.writeInt(i);
                    AtomicFile atomicFile = this.f5204c;
                    a.close();
                    atomicFile.f5215b.delete();
                    Util.m4308a(null);
                    this.f5205d = false;
                } catch (Throwable e3) {
                    throw new IllegalStateException(e3);
                } catch (IOException e4) {
                    e2 = e4;
                    try {
                        throw new CacheException(e2);
                    } catch (Throwable th) {
                        e3 = th;
                        Util.m4308a(dataOutputStream);
                        throw e3;
                    }
                }
            } catch (IOException e5) {
                IOException iOException = e5;
                dataOutputStream = null;
                e2 = iOException;
                throw new CacheException(e2);
            } catch (Throwable th2) {
                Throwable th3 = th2;
                dataOutputStream = null;
                e3 = th3;
                Util.m4308a(dataOutputStream);
                throw e3;
            }
        }
    }

    public final CachedContent m4173a(String str) {
        CachedContent cachedContent = (CachedContent) this.f5202a.get(str);
        return cachedContent == null ? m4174a(str, -1) : cachedContent;
    }

    public final CachedContent m4176b(String str) {
        return (CachedContent) this.f5202a.get(str);
    }

    public final int m4178c(String str) {
        return m4173a(str).f5198a;
    }

    public final void m4180d(String str) {
        CachedContent cachedContent = (CachedContent) this.f5202a.remove(str);
        if (cachedContent != null) {
            Assertions.m4186b(cachedContent.f5200c.isEmpty());
            this.f5203b.remove(cachedContent.f5198a);
            this.f5205d = true;
        }
    }

    public final void m4177b() {
        LinkedList linkedList = new LinkedList();
        for (CachedContent cachedContent : this.f5202a.values()) {
            if (cachedContent.f5200c.isEmpty()) {
                linkedList.add(cachedContent.f5199b);
            }
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            m4180d((String) it.next());
        }
    }

    final boolean m4179c() {
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
        r8 = this;
        r0 = 0;
        r1 = 0;
        r2 = new java.io.BufferedInputStream;	 Catch:{ FileNotFoundException -> 0x00b6, IOException -> 0x00a2 }
        r3 = r8.f5204c;	 Catch:{ FileNotFoundException -> 0x00b6, IOException -> 0x00a2 }
        r4 = r3.f5215b;	 Catch:{ FileNotFoundException -> 0x00b6, IOException -> 0x00a2 }
        r4 = r4.exists();	 Catch:{ FileNotFoundException -> 0x00b6, IOException -> 0x00a2 }
        if (r4 == 0) goto L_0x001a;	 Catch:{ FileNotFoundException -> 0x00b6, IOException -> 0x00a2 }
    L_0x000e:
        r4 = r3.f5214a;	 Catch:{ FileNotFoundException -> 0x00b6, IOException -> 0x00a2 }
        r4.delete();	 Catch:{ FileNotFoundException -> 0x00b6, IOException -> 0x00a2 }
        r4 = r3.f5215b;	 Catch:{ FileNotFoundException -> 0x00b6, IOException -> 0x00a2 }
        r5 = r3.f5214a;	 Catch:{ FileNotFoundException -> 0x00b6, IOException -> 0x00a2 }
        r4.renameTo(r5);	 Catch:{ FileNotFoundException -> 0x00b6, IOException -> 0x00a2 }
    L_0x001a:
        r4 = new java.io.FileInputStream;	 Catch:{ FileNotFoundException -> 0x00b6, IOException -> 0x00a2 }
        r3 = r3.f5214a;	 Catch:{ FileNotFoundException -> 0x00b6, IOException -> 0x00a2 }
        r4.<init>(r3);	 Catch:{ FileNotFoundException -> 0x00b6, IOException -> 0x00a2 }
        r2.<init>(r4);	 Catch:{ FileNotFoundException -> 0x00b6, IOException -> 0x00a2 }
        r3 = new java.io.DataInputStream;	 Catch:{ FileNotFoundException -> 0x00b6, IOException -> 0x00a2 }
        r3.<init>(r2);	 Catch:{ FileNotFoundException -> 0x00b6, IOException -> 0x00a2 }
        r1 = r3.readInt();	 Catch:{ FileNotFoundException -> 0x009e, IOException -> 0x009b, all -> 0x0098 }
        r4 = 1;
        if (r1 == r4) goto L_0x0034;
    L_0x0030:
        com.google.android.exoplayer2.util.Util.m4308a(r3);
        return r0;
    L_0x0034:
        r1 = r3.readInt();	 Catch:{ FileNotFoundException -> 0x009e, IOException -> 0x009b, all -> 0x0098 }
        r1 = r1 & r4;	 Catch:{ FileNotFoundException -> 0x009e, IOException -> 0x009b, all -> 0x0098 }
        if (r1 == 0) goto L_0x006b;	 Catch:{ FileNotFoundException -> 0x009e, IOException -> 0x009b, all -> 0x0098 }
    L_0x003b:
        r1 = r8.f5206e;	 Catch:{ FileNotFoundException -> 0x009e, IOException -> 0x009b, all -> 0x0098 }
        if (r1 != 0) goto L_0x0043;
    L_0x003f:
        com.google.android.exoplayer2.util.Util.m4308a(r3);
        return r0;
    L_0x0043:
        r1 = 16;
        r1 = new byte[r1];	 Catch:{ FileNotFoundException -> 0x009e, IOException -> 0x009b, all -> 0x0098 }
        r3.readFully(r1);	 Catch:{ FileNotFoundException -> 0x009e, IOException -> 0x009b, all -> 0x0098 }
        r5 = new javax.crypto.spec.IvParameterSpec;	 Catch:{ FileNotFoundException -> 0x009e, IOException -> 0x009b, all -> 0x0098 }
        r5.<init>(r1);	 Catch:{ FileNotFoundException -> 0x009e, IOException -> 0x009b, all -> 0x0098 }
        r1 = r8.f5206e;	 Catch:{ InvalidKeyException -> 0x0064, InvalidKeyException -> 0x0064 }
        r6 = 2;	 Catch:{ InvalidKeyException -> 0x0064, InvalidKeyException -> 0x0064 }
        r7 = r8.f5207f;	 Catch:{ InvalidKeyException -> 0x0064, InvalidKeyException -> 0x0064 }
        r1.init(r6, r7, r5);	 Catch:{ InvalidKeyException -> 0x0064, InvalidKeyException -> 0x0064 }
        r1 = new java.io.DataInputStream;	 Catch:{ FileNotFoundException -> 0x009e, IOException -> 0x009b, all -> 0x0098 }
        r5 = new javax.crypto.CipherInputStream;	 Catch:{ FileNotFoundException -> 0x009e, IOException -> 0x009b, all -> 0x0098 }
        r6 = r8.f5206e;	 Catch:{ FileNotFoundException -> 0x009e, IOException -> 0x009b, all -> 0x0098 }
        r5.<init>(r2, r6);	 Catch:{ FileNotFoundException -> 0x009e, IOException -> 0x009b, all -> 0x0098 }
        r1.<init>(r5);	 Catch:{ FileNotFoundException -> 0x009e, IOException -> 0x009b, all -> 0x0098 }
        goto L_0x0072;	 Catch:{ FileNotFoundException -> 0x009e, IOException -> 0x009b, all -> 0x0098 }
    L_0x0064:
        r1 = move-exception;	 Catch:{ FileNotFoundException -> 0x009e, IOException -> 0x009b, all -> 0x0098 }
        r2 = new java.lang.IllegalStateException;	 Catch:{ FileNotFoundException -> 0x009e, IOException -> 0x009b, all -> 0x0098 }
        r2.<init>(r1);	 Catch:{ FileNotFoundException -> 0x009e, IOException -> 0x009b, all -> 0x0098 }
        throw r2;	 Catch:{ FileNotFoundException -> 0x009e, IOException -> 0x009b, all -> 0x0098 }
    L_0x006b:
        r1 = r8.f5206e;	 Catch:{ FileNotFoundException -> 0x009e, IOException -> 0x009b, all -> 0x0098 }
        if (r1 == 0) goto L_0x0071;	 Catch:{ FileNotFoundException -> 0x009e, IOException -> 0x009b, all -> 0x0098 }
    L_0x006f:
        r8.f5205d = r4;	 Catch:{ FileNotFoundException -> 0x009e, IOException -> 0x009b, all -> 0x0098 }
    L_0x0071:
        r1 = r3;
    L_0x0072:
        r2 = r1.readInt();	 Catch:{ FileNotFoundException -> 0x00b6, IOException -> 0x00a2 }
        r3 = r0;	 Catch:{ FileNotFoundException -> 0x00b6, IOException -> 0x00a2 }
        r5 = r3;	 Catch:{ FileNotFoundException -> 0x00b6, IOException -> 0x00a2 }
    L_0x0078:
        if (r3 >= r2) goto L_0x008a;	 Catch:{ FileNotFoundException -> 0x00b6, IOException -> 0x00a2 }
    L_0x007a:
        r6 = new com.google.android.exoplayer2.upstream.cache.CachedContent;	 Catch:{ FileNotFoundException -> 0x00b6, IOException -> 0x00a2 }
        r6.<init>(r1);	 Catch:{ FileNotFoundException -> 0x00b6, IOException -> 0x00a2 }
        r8.m4171a(r6);	 Catch:{ FileNotFoundException -> 0x00b6, IOException -> 0x00a2 }
        r6 = r6.m4168a();	 Catch:{ FileNotFoundException -> 0x00b6, IOException -> 0x00a2 }
        r5 = r5 + r6;	 Catch:{ FileNotFoundException -> 0x00b6, IOException -> 0x00a2 }
        r3 = r3 + 1;	 Catch:{ FileNotFoundException -> 0x00b6, IOException -> 0x00a2 }
        goto L_0x0078;	 Catch:{ FileNotFoundException -> 0x00b6, IOException -> 0x00a2 }
    L_0x008a:
        r2 = r1.readInt();	 Catch:{ FileNotFoundException -> 0x00b6, IOException -> 0x00a2 }
        if (r2 == r5) goto L_0x0094;
    L_0x0090:
        com.google.android.exoplayer2.util.Util.m4308a(r1);
        return r0;
    L_0x0094:
        com.google.android.exoplayer2.util.Util.m4308a(r1);
        return r4;
    L_0x0098:
        r0 = move-exception;
        r1 = r3;
        goto L_0x00b0;
    L_0x009b:
        r2 = move-exception;
        r1 = r3;
        goto L_0x00a3;
    L_0x009e:
        r1 = r3;
        goto L_0x00b6;
    L_0x00a0:
        r0 = move-exception;
        goto L_0x00b0;
    L_0x00a2:
        r2 = move-exception;
    L_0x00a3:
        r3 = "CachedContentIndex";	 Catch:{ all -> 0x00a0 }
        r4 = "Error reading cache content index file.";	 Catch:{ all -> 0x00a0 }
        android.util.Log.e(r3, r4, r2);	 Catch:{ all -> 0x00a0 }
        if (r1 == 0) goto L_0x00af;
    L_0x00ac:
        com.google.android.exoplayer2.util.Util.m4308a(r1);
    L_0x00af:
        return r0;
    L_0x00b0:
        if (r1 == 0) goto L_0x00b5;
    L_0x00b2:
        com.google.android.exoplayer2.util.Util.m4308a(r1);
    L_0x00b5:
        throw r0;
    L_0x00b6:
        if (r1 == 0) goto L_0x00bb;
    L_0x00b8:
        com.google.android.exoplayer2.util.Util.m4308a(r1);
    L_0x00bb:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.upstream.cache.CachedContentIndex.c():boolean");
    }

    private void m4171a(CachedContent cachedContent) {
        this.f5202a.put(cachedContent.f5199b, cachedContent);
        this.f5203b.put(cachedContent.f5198a, cachedContent.f5199b);
    }

    final CachedContent m4174a(String str, long j) {
        int i;
        SparseArray sparseArray = this.f5203b;
        int size = sparseArray.size();
        if (size == 0) {
            i = 0;
        } else {
            i = sparseArray.keyAt(size - 1) + 1;
        }
        if (i < 0) {
            i = 0;
            while (i < size && i == sparseArray.keyAt(i)) {
                i++;
            }
        }
        CachedContent cachedContent = new CachedContent(i, str, j);
        m4171a(cachedContent);
        this.f5205d = true;
        return cachedContent;
    }

    private static javax.crypto.Cipher m4172d() throws javax.crypto.NoSuchPaddingException, java.security.NoSuchAlgorithmException {
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
        r0 = com.google.android.exoplayer2.util.Util.f5283a;
        r1 = 18;
        if (r0 != r1) goto L_0x000f;
    L_0x0006:
        r0 = "AES/CBC/PKCS5PADDING";	 Catch:{ Throwable -> 0x000f }
        r1 = "BC";	 Catch:{ Throwable -> 0x000f }
        r0 = javax.crypto.Cipher.getInstance(r0, r1);	 Catch:{ Throwable -> 0x000f }
        return r0;
    L_0x000f:
        r0 = "AES/CBC/PKCS5PADDING";
        r0 = javax.crypto.Cipher.getInstance(r0);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.upstream.cache.CachedContentIndex.d():javax.crypto.Cipher");
    }
}
