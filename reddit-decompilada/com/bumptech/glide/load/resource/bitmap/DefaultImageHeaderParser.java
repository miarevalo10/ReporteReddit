package com.bumptech.glide.load.resource.bitmap;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParser.ImageType;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

public final class DefaultImageHeaderParser implements ImageHeaderParser {
    static final byte[] f12596a = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));
    private static final int[] f12597b = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    private static final class RandomAccessReader {
        final ByteBuffer f3514a;

        RandomAccessReader(byte[] bArr, int i) {
            this.f3514a = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i);
        }

        final int m3020a(int i) {
            return m3019a(i, 4) ? this.f3514a.getInt(i) : -1;
        }

        final short m3021b(int i) {
            return m3019a(i, 2) ? this.f3514a.getShort(i) : (short) -1;
        }

        private boolean m3019a(int i, int i2) {
            return this.f3514a.remaining() - i >= i2;
        }
    }

    private interface Reader {
        int mo982a() throws IOException;

        int mo983a(byte[] bArr, int i) throws IOException;

        long mo984a(long j) throws IOException;

        short mo985b() throws IOException;

        int mo986c() throws IOException;
    }

    private static final class ByteBufferReader implements Reader {
        private final ByteBuffer f12594a;

        ByteBufferReader(ByteBuffer byteBuffer) {
            this.f12594a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        public final int mo982a() throws IOException {
            return ((mo986c() << 8) & 65280) | (mo986c() & 255);
        }

        public final short mo985b() throws IOException {
            return (short) (mo986c() & 255);
        }

        public final long mo984a(long j) throws IOException {
            j = (int) Math.min((long) this.f12594a.remaining(), j);
            this.f12594a.position(this.f12594a.position() + j);
            return (long) j;
        }

        public final int mo983a(byte[] bArr, int i) throws IOException {
            i = Math.min(i, this.f12594a.remaining());
            if (i == 0) {
                return -1;
            }
            this.f12594a.get(bArr, 0, i);
            return i;
        }

        public final int mo986c() throws IOException {
            if (this.f12594a.remaining() <= 0) {
                return -1;
            }
            return this.f12594a.get();
        }
    }

    private static final class StreamReader implements Reader {
        private final InputStream f12595a;

        StreamReader(InputStream inputStream) {
            this.f12595a = inputStream;
        }

        public final int mo982a() throws IOException {
            return ((this.f12595a.read() << 8) & 65280) | (this.f12595a.read() & 255);
        }

        public final short mo985b() throws IOException {
            return (short) (this.f12595a.read() & 255);
        }

        public final long mo984a(long j) throws IOException {
            if (j < 0) {
                return 0;
            }
            long j2 = j;
            while (j2 > 0) {
                long skip = this.f12595a.skip(j2);
                if (skip <= 0) {
                    if (this.f12595a.read() == -1) {
                        break;
                    }
                    j2--;
                } else {
                    j2 -= skip;
                }
            }
            return j - j2;
        }

        public final int mo983a(byte[] bArr, int i) throws IOException {
            int i2 = i;
            while (i2 > 0) {
                int read = this.f12595a.read(bArr, i - i2, i2);
                if (read == -1) {
                    break;
                }
                i2 -= read;
            }
            return i - i2;
        }

        public final int mo986c() throws IOException {
            return this.f12595a.read();
        }
    }

    public final ImageType mo988a(InputStream inputStream) throws IOException {
        return m11593a(new StreamReader((InputStream) Preconditions.m3217a((Object) inputStream)));
    }

    public final ImageType mo989a(ByteBuffer byteBuffer) throws IOException {
        return m11593a(new ByteBufferReader((ByteBuffer) Preconditions.m3217a((Object) byteBuffer)));
    }

    public final int mo987a(InputStream inputStream, ArrayPool arrayPool) throws IOException {
        return m11592a(new StreamReader((InputStream) Preconditions.m3217a((Object) inputStream)), (ArrayPool) Preconditions.m3217a((Object) arrayPool));
    }

    private static ImageType m11593a(Reader reader) throws IOException {
        int a = reader.mo982a();
        if (a == 65496) {
            return ImageType.JPEG;
        }
        a = ((a << 16) & -65536) | (reader.mo982a() & 65535);
        if (a == -1991225785) {
            reader.mo984a(21);
            return reader.mo986c() >= 3 ? ImageType.PNG_A : ImageType.PNG;
        } else if ((a >> 8) == 4671814) {
            return ImageType.GIF;
        } else {
            if (a != 1380533830) {
                return ImageType.UNKNOWN;
            }
            reader.mo984a(4);
            if ((((reader.mo982a() << 16) & -65536) | (reader.mo982a() & 65535)) != 1464156752) {
                return ImageType.UNKNOWN;
            }
            a = ((reader.mo982a() << 16) & -65536) | (reader.mo982a() & 65535);
            if ((a & -256) != 1448097792) {
                return ImageType.UNKNOWN;
            }
            a &= 255;
            if (a == 88) {
                reader.mo984a(4);
                return (reader.mo986c() & 16) != null ? ImageType.WEBP_A : ImageType.WEBP;
            } else if (a != 76) {
                return ImageType.WEBP;
            } else {
                reader.mo984a(4);
                return (reader.mo986c() & 8) != null ? ImageType.WEBP_A : ImageType.WEBP;
            }
        }
    }

    private static int m11592a(Reader reader, ArrayPool arrayPool) throws IOException {
        Object obj;
        int i;
        int a = reader.mo982a();
        if (!((a & 65496) == 65496 || a == 19789)) {
            if (a != 18761) {
                obj = null;
                i = -1;
                if (obj != null) {
                    if (Log.isLoggable("DfltImageHeaderParser", 3) != null) {
                        arrayPool = new StringBuilder("Parser doesn't handle magic number: ");
                        arrayPool.append(a);
                        Log.d("DfltImageHeaderParser", arrayPool.toString());
                    }
                    return -1;
                }
                a = m11595b(reader);
                if (a != -1) {
                    if (Log.isLoggable("DfltImageHeaderParser", 3) != null) {
                        Log.d("DfltImageHeaderParser", "Failed to parse exif segment length, or exif segment not found");
                    }
                    return -1;
                }
                obj = (byte[]) arrayPool.mo946a(a, byte[].class);
                try {
                    reader = reader.mo983a(obj, a);
                    if (reader == a) {
                        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            StringBuilder stringBuilder = new StringBuilder("Unable to read exif segment data, length: ");
                            stringBuilder.append(a);
                            stringBuilder.append(", actually read: ");
                            stringBuilder.append(reader);
                            Log.d("DfltImageHeaderParser", stringBuilder.toString());
                        }
                    } else if (m11594a((byte[]) obj, a) != null) {
                        i = m11591a(new RandomAccessReader(obj, a));
                    } else if (Log.isLoggable("DfltImageHeaderParser", 3) != null) {
                        Log.d("DfltImageHeaderParser", "Missing jpeg exif preamble");
                    }
                    arrayPool.mo950a(obj);
                    return i;
                } catch (Throwable th) {
                    arrayPool.mo950a(obj);
                }
            }
        }
        obj = 1;
        i = -1;
        if (obj != null) {
            a = m11595b(reader);
            if (a != -1) {
                obj = (byte[]) arrayPool.mo946a(a, byte[].class);
                reader = reader.mo983a(obj, a);
                if (reader == a) {
                    if (m11594a((byte[]) obj, a) != null) {
                        i = m11591a(new RandomAccessReader(obj, a));
                    } else if (Log.isLoggable("DfltImageHeaderParser", 3) != null) {
                        Log.d("DfltImageHeaderParser", "Missing jpeg exif preamble");
                    }
                } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    StringBuilder stringBuilder2 = new StringBuilder("Unable to read exif segment data, length: ");
                    stringBuilder2.append(a);
                    stringBuilder2.append(", actually read: ");
                    stringBuilder2.append(reader);
                    Log.d("DfltImageHeaderParser", stringBuilder2.toString());
                }
                arrayPool.mo950a(obj);
                return i;
            }
            if (Log.isLoggable("DfltImageHeaderParser", 3) != null) {
                Log.d("DfltImageHeaderParser", "Failed to parse exif segment length, or exif segment not found");
            }
            return -1;
        }
        if (Log.isLoggable("DfltImageHeaderParser", 3) != null) {
            arrayPool = new StringBuilder("Parser doesn't handle magic number: ");
            arrayPool.append(a);
            Log.d("DfltImageHeaderParser", arrayPool.toString());
        }
        return -1;
    }

    private static boolean m11594a(byte[] bArr, int i) {
        i = (bArr == null || i <= f12596a.length) ? 0 : 1;
        if (i == 0) {
            return i;
        }
        for (int i2 = 0; i2 < f12596a.length; i2++) {
            if (bArr[i2] != f12596a[i2]) {
                return 0;
            }
        }
        return i;
    }

    private static int m11595b(Reader reader) throws IOException {
        long a;
        long j;
        do {
            short b = reader.mo985b();
            if (b != (short) 255) {
                if (Log.isLoggable("DfltImageHeaderParser", 3) != null) {
                    StringBuilder stringBuilder = new StringBuilder("Unknown segmentId=");
                    stringBuilder.append(b);
                    Log.d("DfltImageHeaderParser", stringBuilder.toString());
                }
                return -1;
            }
            b = reader.mo985b();
            if (b == (short) 218) {
                return -1;
            }
            if (b == (short) 217) {
                if (Log.isLoggable("DfltImageHeaderParser", 3) != null) {
                    Log.d("DfltImageHeaderParser", "Found MARKER_EOI in exif segment");
                }
                return -1;
            }
            int a2 = reader.mo982a() - 2;
            if (b == (short) 225) {
                return a2;
            }
            j = (long) a2;
            a = reader.mo984a(j);
        } while (a == j);
        if (Log.isLoggable("DfltImageHeaderParser", 3) != null) {
            StringBuilder stringBuilder2 = new StringBuilder("Unable to skip enough data, type: ");
            stringBuilder2.append(b);
            stringBuilder2.append(", wanted to skip: ");
            stringBuilder2.append(a2);
            stringBuilder2.append(", but actually skipped: ");
            stringBuilder2.append(a);
            Log.d("DfltImageHeaderParser", stringBuilder2.toString());
        }
        return -1;
    }

    private static int m11591a(RandomAccessReader randomAccessReader) {
        ByteOrder byteOrder;
        short b = randomAccessReader.m3021b(6);
        if (b == (short) 18761) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        } else if (b != (short) 19789) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                StringBuilder stringBuilder = new StringBuilder("Unknown endianness = ");
                stringBuilder.append(b);
                Log.d("DfltImageHeaderParser", stringBuilder.toString());
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.BIG_ENDIAN;
        }
        randomAccessReader.f3514a.order(byteOrder);
        int a = randomAccessReader.m3020a(10) + 6;
        short b2 = randomAccessReader.m3021b(a);
        for (short s = (short) 0; s < b2; s++) {
            int i = (a + 2) + (12 * s);
            short b3 = randomAccessReader.m3021b(i);
            if (b3 == (short) 274) {
                StringBuilder stringBuilder2;
                short b4 = randomAccessReader.m3021b(i + 2);
                if (b4 > (short) 0) {
                    if (b4 <= (short) 12) {
                        int a2 = randomAccessReader.m3020a(i + 4);
                        if (a2 >= 0) {
                            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                StringBuilder stringBuilder3 = new StringBuilder("Got tagIndex=");
                                stringBuilder3.append(s);
                                stringBuilder3.append(" tagType=");
                                stringBuilder3.append(b3);
                                stringBuilder3.append(" formatCode=");
                                stringBuilder3.append(b4);
                                stringBuilder3.append(" componentCount=");
                                stringBuilder3.append(a2);
                                Log.d("DfltImageHeaderParser", stringBuilder3.toString());
                            }
                            a2 += f12597b[b4];
                            if (a2 <= 4) {
                                i += 8;
                                if (i >= 0) {
                                    if (i <= randomAccessReader.f3514a.remaining()) {
                                        if (a2 >= 0) {
                                            if (a2 + i <= randomAccessReader.f3514a.remaining()) {
                                                return randomAccessReader.m3021b(i);
                                            }
                                        }
                                        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                            stringBuilder2 = new StringBuilder("Illegal number of bytes for TI tag data tagType=");
                                            stringBuilder2.append(b3);
                                            Log.d("DfltImageHeaderParser", stringBuilder2.toString());
                                        }
                                    }
                                }
                                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    StringBuilder stringBuilder4 = new StringBuilder("Illegal tagValueOffset=");
                                    stringBuilder4.append(i);
                                    stringBuilder4.append(" tagType=");
                                    stringBuilder4.append(b3);
                                    Log.d("DfltImageHeaderParser", stringBuilder4.toString());
                                }
                            } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                stringBuilder2 = new StringBuilder("Got byte count > 4, not orientation, continuing, formatCode=");
                                stringBuilder2.append(b4);
                                Log.d("DfltImageHeaderParser", stringBuilder2.toString());
                            }
                        } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            Log.d("DfltImageHeaderParser", "Negative tiff component count");
                        }
                    }
                }
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    stringBuilder2 = new StringBuilder("Got invalid format code = ");
                    stringBuilder2.append(b4);
                    Log.d("DfltImageHeaderParser", stringBuilder2.toString());
                }
            }
        }
        return -1;
    }
}
