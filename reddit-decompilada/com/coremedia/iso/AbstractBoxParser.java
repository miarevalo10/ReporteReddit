package com.coremedia.iso;

import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.Container;
import com.googlecode.mp4parser.DataSource;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.logging.Logger;

public abstract class AbstractBoxParser implements BoxParser {
    private static Logger f12677b = Logger.getLogger(AbstractBoxParser.class.getName());
    ThreadLocal<ByteBuffer> f12678a = new C02841(this);

    class C02841 extends ThreadLocal<ByteBuffer> {
        final /* synthetic */ AbstractBoxParser f3716a;

        C02841(AbstractBoxParser abstractBoxParser) {
            this.f3716a = abstractBoxParser;
        }

        protected /* synthetic */ Object initialValue() {
            return ByteBuffer.allocate(32);
        }
    }

    public abstract Box mo3275a(String str, byte[] bArr, String str2);

    public final Box mo1040a(DataSource dataSource, Container container) throws IOException {
        long position = dataSource.position();
        ((ByteBuffer) this.f12678a.get()).rewind().limit(8);
        int read;
        do {
            read = dataSource.read((ByteBuffer) this.f12678a.get());
            if (read == 8) {
                ((ByteBuffer) this.f12678a.get()).rewind();
                position = IsoTypeReader.m3280a((ByteBuffer) this.f12678a.get());
                if (position >= 8 || position <= 1) {
                    byte[] bArr;
                    long j;
                    String k = IsoTypeReader.m3291k((ByteBuffer) this.f12678a.get());
                    if (position == 1) {
                        ((ByteBuffer) this.f12678a.get()).limit(16);
                        dataSource.read((ByteBuffer) this.f12678a.get());
                        ((ByteBuffer) this.f12678a.get()).position(8);
                        position = IsoTypeReader.m3286f((ByteBuffer) this.f12678a.get()) - 16;
                    } else {
                        position = position == 0 ? dataSource.size() - dataSource.position() : position - 8;
                    }
                    if ("uuid".equals(k)) {
                        ((ByteBuffer) this.f12678a.get()).limit(((ByteBuffer) this.f12678a.get()).limit() + 16);
                        dataSource.read((ByteBuffer) this.f12678a.get());
                        bArr = new byte[16];
                        for (int position2 = ((ByteBuffer) this.f12678a.get()).position() - 16; position2 < ((ByteBuffer) this.f12678a.get()).position(); position2++) {
                            bArr[position2 - (((ByteBuffer) this.f12678a.get()).position() - 16)] = ((ByteBuffer) this.f12678a.get()).get(position2);
                        }
                        j = position - 16;
                    } else {
                        j = position;
                        bArr = null;
                    }
                    Box a = mo3275a(k, bArr, container instanceof Box ? ((Box) container).getType() : "");
                    a.setParent(container);
                    ((ByteBuffer) this.f12678a.get()).rewind();
                    a.parse(dataSource, (ByteBuffer) this.f12678a.get(), j, this);
                    return a;
                }
                dataSource = f12677b;
                container = new StringBuilder("Plausibility check failed: size < 8 (size = ");
                container.append(position);
                container.append("). Stop parsing!");
                dataSource.severe(container.toString());
                return null;
            }
        } while (read >= 0);
        dataSource.position(position);
        throw new EOFException();
    }
}
