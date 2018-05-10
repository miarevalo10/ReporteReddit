package net.hockeyapp.android.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

public class SimpleMultipartEntity {
    private static final char[] f26613d = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    File f26614a;
    OutputStream f26615b;
    String f26616c;
    private boolean f26617e = false;
    private boolean f26618f = false;

    public SimpleMultipartEntity(File file) {
        int i = 0;
        this.f26614a = file;
        try {
            this.f26615b = new FileOutputStream(this.f26614a);
        } catch (Throwable e) {
            HockeyLog.m28206a("Failed to open temp file", e);
        }
        file = new StringBuilder();
        Random random = new Random();
        while (i < 30) {
            file.append(f26613d[random.nextInt(f26613d.length)]);
            i++;
        }
        this.f26616c = file.toString();
    }

    public final void m28227a() throws IOException {
        if (!this.f26618f) {
            OutputStream outputStream = this.f26615b;
            StringBuilder stringBuilder = new StringBuilder("--");
            stringBuilder.append(this.f26616c);
            stringBuilder.append("\r\n");
            outputStream.write(stringBuilder.toString().getBytes());
        }
        this.f26618f = true;
    }

    public final void m28230b() {
        if (!this.f26617e) {
            try {
                OutputStream outputStream = this.f26615b;
                StringBuilder stringBuilder = new StringBuilder("\r\n--");
                stringBuilder.append(this.f26616c);
                stringBuilder.append("--\r\n");
                outputStream.write(stringBuilder.toString().getBytes());
                this.f26615b.flush();
                this.f26615b.close();
                this.f26615b = null;
            } catch (Throwable e) {
                HockeyLog.m28206a("Failed to close temp file", e);
            }
            this.f26617e = true;
        }
    }

    public final void m28229a(java.lang.String r4, java.lang.String r5, java.io.InputStream r6, java.lang.String r7, boolean r8) throws java.io.IOException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r3.m28227a();
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x008e }
        r1 = "Content-Type: ";	 Catch:{ all -> 0x008e }
        r0.<init>(r1);	 Catch:{ all -> 0x008e }
        r0.append(r7);	 Catch:{ all -> 0x008e }
        r7 = "\r\n";	 Catch:{ all -> 0x008e }
        r0.append(r7);	 Catch:{ all -> 0x008e }
        r7 = r0.toString();	 Catch:{ all -> 0x008e }
        r0 = r3.f26615b;	 Catch:{ all -> 0x008e }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x008e }
        r2 = "Content-Disposition: form-data; name=\"";	 Catch:{ all -> 0x008e }
        r1.<init>(r2);	 Catch:{ all -> 0x008e }
        r1.append(r4);	 Catch:{ all -> 0x008e }
        r4 = "\"; filename=\"";	 Catch:{ all -> 0x008e }
        r1.append(r4);	 Catch:{ all -> 0x008e }
        r1.append(r5);	 Catch:{ all -> 0x008e }
        r4 = "\"\r\n";	 Catch:{ all -> 0x008e }
        r1.append(r4);	 Catch:{ all -> 0x008e }
        r4 = r1.toString();	 Catch:{ all -> 0x008e }
        r4 = r4.getBytes();	 Catch:{ all -> 0x008e }
        r0.write(r4);	 Catch:{ all -> 0x008e }
        r4 = r3.f26615b;	 Catch:{ all -> 0x008e }
        r5 = r7.getBytes();	 Catch:{ all -> 0x008e }
        r4.write(r5);	 Catch:{ all -> 0x008e }
        r4 = r3.f26615b;	 Catch:{ all -> 0x008e }
        r5 = "Content-Transfer-Encoding: binary\r\n\r\n";	 Catch:{ all -> 0x008e }
        r5 = r5.getBytes();	 Catch:{ all -> 0x008e }
        r4.write(r5);	 Catch:{ all -> 0x008e }
        r4 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;	 Catch:{ all -> 0x008e }
        r4 = new byte[r4];	 Catch:{ all -> 0x008e }
    L_0x0052:
        r5 = r6.read(r4);	 Catch:{ all -> 0x008e }
        r7 = -1;	 Catch:{ all -> 0x008e }
        if (r5 == r7) goto L_0x0060;	 Catch:{ all -> 0x008e }
    L_0x0059:
        r7 = r3.f26615b;	 Catch:{ all -> 0x008e }
        r0 = 0;	 Catch:{ all -> 0x008e }
        r7.write(r4, r0, r5);	 Catch:{ all -> 0x008e }
        goto L_0x0052;	 Catch:{ all -> 0x008e }
    L_0x0060:
        r4 = r3.f26615b;	 Catch:{ all -> 0x008e }
        r4.flush();	 Catch:{ all -> 0x008e }
        if (r8 == 0) goto L_0x006b;	 Catch:{ all -> 0x008e }
    L_0x0067:
        r3.m28230b();	 Catch:{ all -> 0x008e }
        goto L_0x0089;	 Catch:{ all -> 0x008e }
    L_0x006b:
        r4 = r3.f26615b;	 Catch:{ all -> 0x008e }
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x008e }
        r7 = "\r\n--";	 Catch:{ all -> 0x008e }
        r5.<init>(r7);	 Catch:{ all -> 0x008e }
        r7 = r3.f26616c;	 Catch:{ all -> 0x008e }
        r5.append(r7);	 Catch:{ all -> 0x008e }
        r7 = "\r\n";	 Catch:{ all -> 0x008e }
        r5.append(r7);	 Catch:{ all -> 0x008e }
        r5 = r5.toString();	 Catch:{ all -> 0x008e }
        r5 = r5.getBytes();	 Catch:{ all -> 0x008e }
        r4.write(r5);	 Catch:{ all -> 0x008e }
    L_0x0089:
        r6.close();	 Catch:{ IOException -> 0x008d }
        return;
    L_0x008d:
        return;
    L_0x008e:
        r4 = move-exception;
        r6.close();	 Catch:{ IOException -> 0x0092 }
    L_0x0092:
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: net.hockeyapp.android.utils.SimpleMultipartEntity.a(java.lang.String, java.lang.String, java.io.InputStream, java.lang.String, boolean):void");
    }

    public final void m28228a(OutputStream outputStream) throws IOException {
        m28230b();
        FileInputStream fileInputStream = new FileInputStream(this.f26614a);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        outputStream = new byte[4096];
        while (true) {
            int read = fileInputStream.read(outputStream);
            if (read != -1) {
                bufferedOutputStream.write(outputStream, 0, read);
            } else {
                fileInputStream.close();
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
                this.f26614a.delete();
                this.f26614a = null;
                return;
            }
        }
    }
}
