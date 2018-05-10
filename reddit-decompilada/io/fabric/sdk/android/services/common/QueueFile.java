package io.fabric.sdk.android.services.common;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.WritableByteChannel;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QueueFile implements Closeable {
    private static final Logger f24778b = Logger.getLogger(QueueFile.class.getName());
    int f24779a;
    private final RandomAccessFile f24780c;
    private int f24781d;
    private Element f24782e;
    private Element f24783f;
    private final byte[] f24784g = new byte[16];

    static class Element {
        static final Element f24772a = new Element(0, 0);
        final int f24773b;
        final int f24774c;

        Element(int i, int i2) {
            this.f24773b = i;
            this.f24774c = i2;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(getClass().getSimpleName());
            stringBuilder.append("[position = ");
            stringBuilder.append(this.f24773b);
            stringBuilder.append(", length = ");
            stringBuilder.append(this.f24774c);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    private final class ElementInputStream extends InputStream {
        final /* synthetic */ QueueFile f24775a;
        private int f24776b;
        private int f24777c;

        private ElementInputStream(QueueFile queueFile, Element element) {
            this.f24775a = queueFile;
            this.f24776b = queueFile.m26351b(element.f24773b + 4);
            this.f24777c = element.f24774c;
        }

        public final int read(byte[] bArr, int i, int i2) throws IOException {
            QueueFile.m26353b((Object) bArr, "buffer");
            if ((i | i2) >= 0) {
                if (i2 <= bArr.length - i) {
                    if (this.f24777c <= 0) {
                        return -1;
                    }
                    if (i2 > this.f24777c) {
                        i2 = this.f24777c;
                    }
                    this.f24775a.m26347a(this.f24776b, bArr, i, i2);
                    this.f24776b = this.f24775a.m26351b(this.f24776b + i2);
                    this.f24777c -= i2;
                    return i2;
                }
            }
            throw new ArrayIndexOutOfBoundsException();
        }

        public final int read() throws IOException {
            if (this.f24777c == 0) {
                return -1;
            }
            this.f24775a.f24780c.seek((long) this.f24776b);
            int read = this.f24775a.f24780c.read();
            this.f24776b = this.f24775a.m26351b(this.f24776b + 1);
            this.f24777c--;
            return read;
        }
    }

    public interface ElementReader {
        void read(InputStream inputStream, int i) throws IOException;
    }

    public QueueFile(File file) throws IOException {
        if (!file.exists()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(file.getPath());
            stringBuilder.append(".tmp");
            File file2 = new File(stringBuilder.toString());
            RandomAccessFile a = m26343a(file2);
            try {
                a.setLength(4096);
                a.seek(0);
                byte[] bArr = new byte[16];
                m26350a(bArr, 4096, 0, 0, 0);
                a.write(bArr);
                if (!file2.renameTo(file)) {
                    throw new IOException("Rename failed!");
                }
            } finally {
                a.close();
            }
        }
        this.f24780c = m26343a(file);
        this.f24780c.seek(0);
        this.f24780c.readFully(this.f24784g);
        this.f24779a = m26352b(this.f24784g, 0);
        if (((long) this.f24779a) > this.f24780c.length()) {
            StringBuilder stringBuilder2 = new StringBuilder("File is truncated. Expected length: ");
            stringBuilder2.append(this.f24779a);
            stringBuilder2.append(", Actual length: ");
            stringBuilder2.append(this.f24780c.length());
            throw new IOException(stringBuilder2.toString());
        }
        this.f24781d = m26352b(this.f24784g, 4);
        int b = m26352b(this.f24784g, 8);
        int b2 = m26352b(this.f24784g, 12);
        this.f24782e = m26341a(b);
        this.f24783f = m26341a(b2);
    }

    private static void m26349a(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) (i2 >> 24);
        bArr[i + 1] = (byte) (i2 >> 16);
        bArr[i + 2] = (byte) (i2 >> 8);
        bArr[i + 3] = (byte) i2;
    }

    private static void m26350a(byte[] bArr, int... iArr) {
        int i = 0;
        int i2 = 0;
        while (i < 4) {
            m26349a(bArr, i2, iArr[i]);
            i2 += 4;
            i++;
        }
    }

    private static int m26352b(byte[] bArr, int i) {
        return ((((bArr[i] & 255) << 24) + ((bArr[i + 1] & 255) << 16)) + ((bArr[i + 2] & 255) << 8)) + (bArr[i + 3] & 255);
    }

    private void m26345a(int i, int i2, int i3, int i4) throws IOException {
        m26350a(this.f24784g, i, i2, i3, i4);
        this.f24780c.seek(0);
        this.f24780c.write(this.f24784g);
    }

    private Element m26341a(int i) throws IOException {
        if (i == 0) {
            return Element.f24772a;
        }
        this.f24780c.seek((long) i);
        return new Element(i, this.f24780c.readInt());
    }

    private static RandomAccessFile m26343a(File file) throws FileNotFoundException {
        return new RandomAccessFile(file, "rwd");
    }

    private int m26351b(int i) {
        return i < this.f24779a ? i : (16 + i) - this.f24779a;
    }

    private void m26346a(int i, byte[] bArr, int i2) throws IOException {
        i = m26351b(i);
        if (i + i2 <= this.f24779a) {
            this.f24780c.seek((long) i);
            this.f24780c.write(bArr, 0, i2);
            return;
        }
        int i3 = this.f24779a - i;
        this.f24780c.seek((long) i);
        this.f24780c.write(bArr, 0, i3);
        this.f24780c.seek(16);
        this.f24780c.write(bArr, 0 + i3, i2 - i3);
    }

    private void m26347a(int i, byte[] bArr, int i2, int i3) throws IOException {
        i = m26351b(i);
        if (i + i3 <= this.f24779a) {
            this.f24780c.seek((long) i);
            this.f24780c.readFully(bArr, i2, i3);
            return;
        }
        int i4 = this.f24779a - i;
        this.f24780c.seek((long) i);
        this.f24780c.readFully(bArr, i2, i4);
        this.f24780c.seek(16);
        this.f24780c.readFully(bArr, i2 + i4, i3 - i4);
    }

    public final synchronized void m26359a(byte[] bArr, int i) throws IOException {
        m26353b((Object) bArr, "buffer");
        if ((0 | i) >= 0) {
            if (i <= bArr.length - 0) {
                int i2;
                m26354c(i);
                boolean b = m26360b();
                if (b) {
                    i2 = 16;
                } else {
                    i2 = m26351b((this.f24783f.f24773b + 4) + this.f24783f.f24774c);
                }
                Element element = new Element(i2, i);
                m26349a(this.f24784g, 0, i);
                m26346a(element.f24773b, this.f24784g, 4);
                m26346a(element.f24773b + 4, bArr, i);
                m26345a(this.f24779a, this.f24781d + 1, b ? element.f24773b : this.f24782e.f24773b, element.f24773b);
                this.f24783f = element;
                this.f24781d++;
                if (b) {
                    this.f24782e = this.f24783f;
                }
            }
        }
        throw new IndexOutOfBoundsException();
    }

    public final int m26357a() {
        if (this.f24781d == 0) {
            return 16;
        }
        if (this.f24783f.f24773b >= this.f24782e.f24773b) {
            return (((this.f24783f.f24773b - this.f24782e.f24773b) + 4) + this.f24783f.f24774c) + 16;
        }
        return (((this.f24783f.f24773b + 4) + this.f24783f.f24774c) + this.f24779a) - this.f24782e.f24773b;
    }

    public final synchronized boolean m26360b() {
        return this.f24781d == 0;
    }

    private void m26356d(int i) throws IOException {
        this.f24780c.setLength((long) i);
        this.f24780c.getChannel().force(true);
    }

    public final synchronized void m26358a(ElementReader elementReader) throws IOException {
        int i = this.f24782e.f24773b;
        for (int i2 = 0; i2 < this.f24781d; i2++) {
            Element a = m26341a(i);
            elementReader.read(new ElementInputStream(a), a.f24774c);
            i = m26351b((a.f24773b + 4) + a.f24774c);
        }
    }

    private static <T> T m26353b(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public final synchronized void m26361c() throws IOException {
        if (m26360b()) {
            throw new NoSuchElementException();
        } else if (this.f24781d == 1) {
            m26355d();
        } else {
            int b = m26351b((this.f24782e.f24773b + 4) + this.f24782e.f24774c);
            m26347a(b, this.f24784g, 0, 4);
            int b2 = m26352b(this.f24784g, 0);
            m26345a(this.f24779a, this.f24781d - 1, b, this.f24783f.f24773b);
            this.f24781d--;
            this.f24782e = new Element(b, b2);
        }
    }

    private synchronized void m26355d() throws IOException {
        m26345a(4096, 0, 0, 0);
        this.f24781d = 0;
        this.f24782e = Element.f24772a;
        this.f24783f = Element.f24772a;
        if (this.f24779a > 4096) {
            m26356d(4096);
        }
        this.f24779a = 4096;
    }

    public synchronized void close() throws IOException {
        this.f24780c.close();
    }

    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName());
        stringBuilder.append('[');
        stringBuilder.append("fileLength=");
        stringBuilder.append(this.f24779a);
        stringBuilder.append(", size=");
        stringBuilder.append(this.f24781d);
        stringBuilder.append(", first=");
        stringBuilder.append(this.f24782e);
        stringBuilder.append(", last=");
        stringBuilder.append(this.f24783f);
        stringBuilder.append(", element lengths=[");
        try {
            m26358a(new ElementReader(this) {
                boolean f31001a = true;
                final /* synthetic */ QueueFile f31003c;

                public void read(InputStream inputStream, int i) throws IOException {
                    if (this.f31001a != null) {
                        this.f31001a = null;
                    } else {
                        stringBuilder.append(", ");
                    }
                    stringBuilder.append(i);
                }
            });
        } catch (Throwable e) {
            f24778b.log(Level.WARNING, "read error", e);
        }
        stringBuilder.append("]]");
        return stringBuilder.toString();
    }

    private void m26354c(int i) throws IOException {
        i += 4;
        int a = this.f24779a - m26357a();
        if (a < i) {
            int i2 = this.f24779a;
            do {
                a += i2;
                i2 <<= 1;
            } while (a < i);
            m26356d(i2);
            i = m26351b((this.f24783f.f24773b + 4) + this.f24783f.f24774c);
            if (i < this.f24782e.f24773b) {
                WritableByteChannel channel = this.f24780c.getChannel();
                channel.position((long) this.f24779a);
                long j = (long) (i - 4);
                if (channel.transferTo(16, j, channel) != j) {
                    throw new AssertionError("Copied insufficient number of bytes!");
                }
            }
            if (this.f24783f.f24773b < this.f24782e.f24773b) {
                i = (this.f24779a + this.f24783f.f24773b) - 16;
                m26345a(i2, this.f24781d, this.f24782e.f24773b, i);
                this.f24783f = new Element(i, this.f24783f.f24774c);
            } else {
                m26345a(i2, this.f24781d, this.f24782e.f24773b, this.f24783f.f24773b);
            }
            this.f24779a = i2;
        }
    }
}
