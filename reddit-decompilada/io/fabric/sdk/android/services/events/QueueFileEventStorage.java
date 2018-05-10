package io.fabric.sdk.android.services.events;

import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.QueueFile;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueFileEventStorage implements EventsStorage {
    private final Context f31013a;
    private final File f31014b;
    private final String f31015c;
    private final File f31016d;
    private QueueFile f31017e = new QueueFile(this.f31016d);
    private File f31018f = new File(this.f31014b, this.f31015c);

    public QueueFileEventStorage(Context context, File file, String str, String str2) throws IOException {
        this.f31013a = context;
        this.f31014b = file;
        this.f31015c = str2;
        this.f31016d = new File(this.f31014b, str);
        if (this.f31018f.exists() == null) {
            this.f31018f.mkdirs();
        }
    }

    public final void mo5593a(byte[] bArr) throws IOException {
        this.f31017e.m26359a(bArr, bArr.length);
    }

    public final int mo5590a() {
        return this.f31017e.m26357a();
    }

    public final void mo5591a(String str) throws IOException {
        Closeable fileInputStream;
        Throwable th;
        this.f31017e.close();
        File file = this.f31016d;
        File file2 = new File(this.f31018f, str);
        Closeable closeable = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                Closeable a = mo6602a(file2);
                try {
                    CommonUtils.m26296a((InputStream) fileInputStream, (OutputStream) a, new byte[1024]);
                    CommonUtils.m26294a(fileInputStream, "Failed to close file input stream");
                    CommonUtils.m26294a(a, "Failed to close output stream");
                    file.delete();
                    this.f31017e = new QueueFile(this.f31016d);
                } catch (String str2) {
                    Closeable closeable2 = a;
                    th = str2;
                    closeable = closeable2;
                    CommonUtils.m26294a(fileInputStream, "Failed to close file input stream");
                    CommonUtils.m26294a(closeable, "Failed to close output stream");
                    file.delete();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                CommonUtils.m26294a(fileInputStream, "Failed to close file input stream");
                CommonUtils.m26294a(closeable, "Failed to close output stream");
                file.delete();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            CommonUtils.m26294a(fileInputStream, "Failed to close file input stream");
            CommonUtils.m26294a(closeable, "Failed to close output stream");
            file.delete();
            throw th;
        }
    }

    public OutputStream mo6602a(File file) throws IOException {
        return new FileOutputStream(file);
    }

    public final List<File> mo5596c() {
        List<File> arrayList = new ArrayList();
        for (Object add : this.f31018f.listFiles()) {
            arrayList.add(add);
            if (arrayList.size() > 0) {
                break;
            }
        }
        return arrayList;
    }

    public final void mo5592a(List<File> list) {
        for (File file : list) {
            CommonUtils.m26292a(this.f31013a, String.format("deleting sent analytics file %s", new Object[]{file.getName()}));
            file.delete();
        }
    }

    public final List<File> mo5597d() {
        return Arrays.asList(this.f31018f.listFiles());
    }

    public final void mo5598e() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = r1.f31017e;	 Catch:{ IOException -> 0x0005 }
        r0.close();	 Catch:{ IOException -> 0x0005 }
    L_0x0005:
        r0 = r1.f31016d;
        r0.delete();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.fabric.sdk.android.services.events.QueueFileEventStorage.e():void");
    }

    public final boolean mo5595b() {
        return this.f31017e.m26360b();
    }

    public final boolean mo5594a(int i, int i2) {
        return (this.f31017e.m26357a() + 4) + i <= i2;
    }
}
