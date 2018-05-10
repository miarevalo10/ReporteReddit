package okhttp3.internal.http2;

import com.instabug.library.model.NetworkLog;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;

final class Hpack {
    static final Map<ByteString, Integer> NAME_TO_FIRST_INDEX = nameToFirstIndex();
    private static final int PREFIX_4_BITS = 15;
    private static final int PREFIX_5_BITS = 31;
    private static final int PREFIX_6_BITS = 63;
    private static final int PREFIX_7_BITS = 127;
    static final Header[] STATIC_HEADER_TABLE = new Header[]{new Header(Header.TARGET_AUTHORITY, ""), new Header(Header.TARGET_METHOD, HttpRequest.METHOD_GET), new Header(Header.TARGET_METHOD, HttpRequest.METHOD_POST), new Header(Header.TARGET_PATH, Operation.DIVISION), new Header(Header.TARGET_PATH, "/index.html"), new Header(Header.TARGET_SCHEME, "http"), new Header(Header.TARGET_SCHEME, "https"), new Header(Header.RESPONSE_STATUS, "200"), new Header(Header.RESPONSE_STATUS, "204"), new Header(Header.RESPONSE_STATUS, "206"), new Header(Header.RESPONSE_STATUS, "304"), new Header(Header.RESPONSE_STATUS, "400"), new Header(Header.RESPONSE_STATUS, "404"), new Header(Header.RESPONSE_STATUS, "500"), new Header("accept-charset", ""), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", ""), new Header("accept-ranges", ""), new Header("accept", ""), new Header("access-control-allow-origin", ""), new Header("age", ""), new Header("allow", ""), new Header("authorization", ""), new Header("cache-control", ""), new Header("content-disposition", ""), new Header("content-encoding", ""), new Header("content-language", ""), new Header("content-length", ""), new Header("content-location", ""), new Header("content-range", ""), new Header(NetworkLog.CONTENT_TYPE, ""), new Header("cookie", ""), new Header("date", ""), new Header("etag", ""), new Header("expect", ""), new Header("expires", ""), new Header("from", ""), new Header("host", ""), new Header("if-match", ""), new Header("if-modified-since", ""), new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header("last-modified", ""), new Header("link", ""), new Header("location", ""), new Header("max-forwards", ""), new Header("proxy-authenticate", ""), new Header("proxy-authorization", ""), new Header("range", ""), new Header("referer", ""), new Header("refresh", ""), new Header("retry-after", ""), new Header("server", ""), new Header("set-cookie", ""), new Header("strict-transport-security", ""), new Header("transfer-encoding", ""), new Header("user-agent", ""), new Header("vary", ""), new Header("via", ""), new Header("www-authenticate", "")};

    static final class Reader {
        Header[] dynamicTable;
        int dynamicTableByteCount;
        int headerCount;
        private final List<Header> headerList;
        private final int headerTableSizeSetting;
        private int maxDynamicTableByteCount;
        int nextHeaderIndex;
        private final BufferedSource source;

        Reader(int i, Source source) {
            this(i, i, source);
        }

        Reader(int i, int i2, Source source) {
            this.headerList = new ArrayList();
            this.dynamicTable = new Header[8];
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
            this.headerTableSizeSetting = i;
            this.maxDynamicTableByteCount = i2;
            this.source = Okio.m28289a(source);
        }

        final int maxDynamicTableByteCount() {
            return this.maxDynamicTableByteCount;
        }

        private void adjustDynamicTableByteCount() {
            if (this.maxDynamicTableByteCount < this.dynamicTableByteCount) {
                if (this.maxDynamicTableByteCount == 0) {
                    clearDynamicTable();
                    return;
                }
                evictToRecoverBytes(this.dynamicTableByteCount - this.maxDynamicTableByteCount);
            }
        }

        private void clearDynamicTable() {
            Arrays.fill(this.dynamicTable, null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private int evictToRecoverBytes(int i) {
            int i2 = 0;
            if (i > 0) {
                for (int length = this.dynamicTable.length - 1; length >= this.nextHeaderIndex && i > 0; length--) {
                    i -= this.dynamicTable[length].hpackSize;
                    this.dynamicTableByteCount -= this.dynamicTable[length].hpackSize;
                    this.headerCount--;
                    i2++;
                }
                System.arraycopy(this.dynamicTable, this.nextHeaderIndex + 1, this.dynamicTable, (this.nextHeaderIndex + 1) + i2, this.headerCount);
                this.nextHeaderIndex += i2;
            }
            return i2;
        }

        final void readHeaders() throws IOException {
            while (!this.source.mo6769d()) {
                int g = this.source.mo6773g() & 255;
                if (g == 128) {
                    throw new IOException("index == 0");
                } else if ((g & 128) == 128) {
                    readIndexedHeader(readInt(g, Hpack.PREFIX_7_BITS) - 1);
                } else if (g == 64) {
                    readLiteralHeaderWithIncrementalIndexingNewName();
                } else if ((g & 64) == 64) {
                    readLiteralHeaderWithIncrementalIndexingIndexedName(readInt(g, 63) - 1);
                } else if ((g & 32) == 32) {
                    this.maxDynamicTableByteCount = readInt(g, 31);
                    if (this.maxDynamicTableByteCount >= 0) {
                        if (this.maxDynamicTableByteCount <= this.headerTableSizeSetting) {
                            adjustDynamicTableByteCount();
                        }
                    }
                    StringBuilder stringBuilder = new StringBuilder("Invalid dynamic table size update ");
                    stringBuilder.append(this.maxDynamicTableByteCount);
                    throw new IOException(stringBuilder.toString());
                } else {
                    if (g != 16) {
                        if (g != 0) {
                            readLiteralHeaderWithoutIndexingIndexedName(readInt(g, 15) - 1);
                        }
                    }
                    readLiteralHeaderWithoutIndexingNewName();
                }
            }
        }

        public final List<Header> getAndResetHeaderList() {
            List arrayList = new ArrayList(this.headerList);
            this.headerList.clear();
            return arrayList;
        }

        private void readIndexedHeader(int i) throws IOException {
            if (isStaticHeader(i)) {
                this.headerList.add(Hpack.STATIC_HEADER_TABLE[i]);
                return;
            }
            int dynamicTableIndex = dynamicTableIndex(i - Hpack.STATIC_HEADER_TABLE.length);
            if (dynamicTableIndex >= 0) {
                if (dynamicTableIndex <= this.dynamicTable.length - 1) {
                    this.headerList.add(this.dynamicTable[dynamicTableIndex]);
                    return;
                }
            }
            StringBuilder stringBuilder = new StringBuilder("Header index too large ");
            stringBuilder.append(i + 1);
            throw new IOException(stringBuilder.toString());
        }

        private int dynamicTableIndex(int i) {
            return (this.nextHeaderIndex + 1) + i;
        }

        private void readLiteralHeaderWithoutIndexingIndexedName(int i) throws IOException {
            this.headerList.add(new Header(getName(i), readByteString()));
        }

        private void readLiteralHeaderWithoutIndexingNewName() throws IOException {
            this.headerList.add(new Header(Hpack.checkLowercase(readByteString()), readByteString()));
        }

        private void readLiteralHeaderWithIncrementalIndexingIndexedName(int i) throws IOException {
            insertIntoDynamicTable(-1, new Header(getName(i), readByteString()));
        }

        private void readLiteralHeaderWithIncrementalIndexingNewName() throws IOException {
            insertIntoDynamicTable(-1, new Header(Hpack.checkLowercase(readByteString()), readByteString()));
        }

        private ByteString getName(int i) {
            if (isStaticHeader(i)) {
                return Hpack.STATIC_HEADER_TABLE[i].name;
            }
            return this.dynamicTable[dynamicTableIndex(i - Hpack.STATIC_HEADER_TABLE.length)].name;
        }

        private boolean isStaticHeader(int i) {
            return i >= 0 && i <= Hpack.STATIC_HEADER_TABLE.length - 1;
        }

        private void insertIntoDynamicTable(int i, Header header) {
            this.headerList.add(header);
            int i2 = header.hpackSize;
            if (i != -1) {
                i2 -= this.dynamicTable[dynamicTableIndex(i)].hpackSize;
            }
            if (i2 > this.maxDynamicTableByteCount) {
                clearDynamicTable();
                return;
            }
            int evictToRecoverBytes = evictToRecoverBytes((this.dynamicTableByteCount + i2) - this.maxDynamicTableByteCount);
            if (i == -1) {
                if (this.headerCount + 1 > this.dynamicTable.length) {
                    i = new Header[(this.dynamicTable.length * 2)];
                    System.arraycopy(this.dynamicTable, 0, i, this.dynamicTable.length, this.dynamicTable.length);
                    this.nextHeaderIndex = this.dynamicTable.length - 1;
                    this.dynamicTable = i;
                }
                i = this.nextHeaderIndex;
                this.nextHeaderIndex = i - 1;
                this.dynamicTable[i] = header;
                this.headerCount++;
            } else {
                this.dynamicTable[i + (dynamicTableIndex(i) + evictToRecoverBytes)] = header;
            }
            this.dynamicTableByteCount += i2;
        }

        private int readByte() throws IOException {
            return this.source.mo6773g() & 255;
        }

        final int readInt(int i, int i2) throws IOException {
            i &= i2;
            if (i < i2) {
                return i;
            }
            i = 0;
            while (true) {
                int readByte = readByte();
                if ((readByte & 128) == 0) {
                    return i2 + (readByte << i);
                }
                i2 += (readByte & Hpack.PREFIX_7_BITS) << i;
                i += 7;
            }
        }

        final ByteString readByteString() throws IOException {
            int readByte = readByte();
            Object obj = (readByte & 128) == 128 ? 1 : null;
            readByte = readInt(readByte, Hpack.PREFIX_7_BITS);
            if (obj != null) {
                return ByteString.m28269a(Huffman.get().decode(this.source.mo6777h((long) readByte)));
            }
            return this.source.mo6768d((long) readByte);
        }
    }

    static final class Writer {
        private static final int SETTINGS_HEADER_TABLE_SIZE = 4096;
        private static final int SETTINGS_HEADER_TABLE_SIZE_LIMIT = 16384;
        Header[] dynamicTable;
        int dynamicTableByteCount;
        private boolean emitDynamicTableSizeUpdate;
        int headerCount;
        int headerTableSizeSetting;
        int maxDynamicTableByteCount;
        int nextHeaderIndex;
        private final Buffer out;
        private int smallestHeaderTableSizeSetting;
        private final boolean useCompression;

        Writer(Buffer buffer) {
            this(4096, true, buffer);
        }

        Writer(int i, boolean z, Buffer buffer) {
            this.smallestHeaderTableSizeSetting = RedditJobManager.f10810d;
            this.dynamicTable = new Header[8];
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
            this.headerTableSizeSetting = i;
            this.maxDynamicTableByteCount = i;
            this.useCompression = z;
            this.out = buffer;
        }

        private void clearDynamicTable() {
            Arrays.fill(this.dynamicTable, null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private int evictToRecoverBytes(int i) {
            int i2 = 0;
            if (i > 0) {
                for (int length = this.dynamicTable.length - 1; length >= this.nextHeaderIndex && i > 0; length--) {
                    i -= this.dynamicTable[length].hpackSize;
                    this.dynamicTableByteCount -= this.dynamicTable[length].hpackSize;
                    this.headerCount--;
                    i2++;
                }
                System.arraycopy(this.dynamicTable, this.nextHeaderIndex + 1, this.dynamicTable, (this.nextHeaderIndex + 1) + i2, this.headerCount);
                Arrays.fill(this.dynamicTable, this.nextHeaderIndex + 1, (this.nextHeaderIndex + 1) + i2, null);
                this.nextHeaderIndex += i2;
            }
            return i2;
        }

        private void insertIntoDynamicTable(Header header) {
            int i = header.hpackSize;
            if (i > this.maxDynamicTableByteCount) {
                clearDynamicTable();
                return;
            }
            evictToRecoverBytes((this.dynamicTableByteCount + i) - this.maxDynamicTableByteCount);
            if (this.headerCount + 1 > this.dynamicTable.length) {
                Object obj = new Header[(this.dynamicTable.length * 2)];
                System.arraycopy(this.dynamicTable, 0, obj, this.dynamicTable.length, this.dynamicTable.length);
                this.nextHeaderIndex = this.dynamicTable.length - 1;
                this.dynamicTable = obj;
            }
            int i2 = this.nextHeaderIndex;
            this.nextHeaderIndex = i2 - 1;
            this.dynamicTable[i2] = header;
            this.headerCount++;
            this.dynamicTableByteCount += i;
        }

        final void writeHeaders(List<Header> list) throws IOException {
            if (this.emitDynamicTableSizeUpdate) {
                if (this.smallestHeaderTableSizeSetting < this.maxDynamicTableByteCount) {
                    writeInt(this.smallestHeaderTableSizeSetting, 31, 32);
                }
                this.emitDynamicTableSizeUpdate = false;
                this.smallestHeaderTableSizeSetting = RedditJobManager.f10810d;
                writeInt(this.maxDynamicTableByteCount, 31, 32);
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                int intValue;
                int i2;
                int length;
                int i3;
                ByteString byteString;
                Header header = (Header) list.get(i);
                ByteString g = header.name.mo6165g();
                ByteString byteString2 = header.value;
                Integer num = (Integer) Hpack.NAME_TO_FIRST_INDEX.get(g);
                if (num != null) {
                    intValue = num.intValue() + 1;
                    if (intValue > 1 && intValue < 8) {
                        if (!Util.equal(Hpack.STATIC_HEADER_TABLE[intValue - 1].value, byteString2)) {
                            if (Util.equal(Hpack.STATIC_HEADER_TABLE[intValue].value, byteString2)) {
                                i2 = intValue;
                                intValue++;
                                if (intValue == -1) {
                                    length = this.dynamicTable.length;
                                    for (i3 = this.nextHeaderIndex + 1; i3 < length; i3++) {
                                        if (Util.equal(this.dynamicTable[i3].name, g)) {
                                            if (!Util.equal(this.dynamicTable[i3].value, byteString2)) {
                                                intValue = Hpack.STATIC_HEADER_TABLE.length + (i3 - this.nextHeaderIndex);
                                                break;
                                            } else if (i2 != -1) {
                                                i2 = (i3 - this.nextHeaderIndex) + Hpack.STATIC_HEADER_TABLE.length;
                                            }
                                        }
                                    }
                                }
                                if (intValue == -1) {
                                    writeInt(intValue, Hpack.PREFIX_7_BITS, 128);
                                } else if (i2 == -1) {
                                    this.out.m36493b(64);
                                    writeByteString(g);
                                    writeByteString(byteString2);
                                    insertIntoDynamicTable(header);
                                } else {
                                    byteString = Header.PSEUDO_PREFIX;
                                    if (g.mo6157a(0, byteString, 0, byteString.mo6166h()) || Header.TARGET_AUTHORITY.equals(g)) {
                                        writeInt(i2, 63, 64);
                                        writeByteString(byteString2);
                                        insertIntoDynamicTable(header);
                                    } else {
                                        writeInt(i2, 15, 0);
                                        writeByteString(byteString2);
                                    }
                                }
                            }
                        }
                    }
                    i2 = intValue;
                    intValue = -1;
                    if (intValue == -1) {
                        length = this.dynamicTable.length;
                        for (i3 = this.nextHeaderIndex + 1; i3 < length; i3++) {
                            if (Util.equal(this.dynamicTable[i3].name, g)) {
                                if (!Util.equal(this.dynamicTable[i3].value, byteString2)) {
                                    intValue = Hpack.STATIC_HEADER_TABLE.length + (i3 - this.nextHeaderIndex);
                                    break;
                                } else if (i2 != -1) {
                                    i2 = (i3 - this.nextHeaderIndex) + Hpack.STATIC_HEADER_TABLE.length;
                                }
                            }
                        }
                    }
                    if (intValue == -1) {
                        writeInt(intValue, Hpack.PREFIX_7_BITS, 128);
                    } else if (i2 == -1) {
                        byteString = Header.PSEUDO_PREFIX;
                        if (g.mo6157a(0, byteString, 0, byteString.mo6166h())) {
                        }
                        writeInt(i2, 63, 64);
                        writeByteString(byteString2);
                        insertIntoDynamicTable(header);
                    } else {
                        this.out.m36493b(64);
                        writeByteString(g);
                        writeByteString(byteString2);
                        insertIntoDynamicTable(header);
                    }
                } else {
                    intValue = -1;
                }
                i2 = intValue;
                if (intValue == -1) {
                    length = this.dynamicTable.length;
                    for (i3 = this.nextHeaderIndex + 1; i3 < length; i3++) {
                        if (Util.equal(this.dynamicTable[i3].name, g)) {
                            if (!Util.equal(this.dynamicTable[i3].value, byteString2)) {
                                intValue = Hpack.STATIC_HEADER_TABLE.length + (i3 - this.nextHeaderIndex);
                                break;
                            } else if (i2 != -1) {
                                i2 = (i3 - this.nextHeaderIndex) + Hpack.STATIC_HEADER_TABLE.length;
                            }
                        }
                    }
                }
                if (intValue == -1) {
                    writeInt(intValue, Hpack.PREFIX_7_BITS, 128);
                } else if (i2 == -1) {
                    this.out.m36493b(64);
                    writeByteString(g);
                    writeByteString(byteString2);
                    insertIntoDynamicTable(header);
                } else {
                    byteString = Header.PSEUDO_PREFIX;
                    if (g.mo6157a(0, byteString, 0, byteString.mo6166h())) {
                    }
                    writeInt(i2, 63, 64);
                    writeByteString(byteString2);
                    insertIntoDynamicTable(header);
                }
            }
        }

        final void writeInt(int i, int i2, int i3) {
            if (i < i2) {
                this.out.m36493b(i | i3);
                return;
            }
            this.out.m36493b(i3 | i2);
            i -= i2;
            while (i >= 128) {
                this.out.m36493b(128 | (i & Hpack.PREFIX_7_BITS));
                i >>>= 7;
            }
            this.out.m36493b(i);
        }

        final void writeByteString(ByteString byteString) throws IOException {
            if (!this.useCompression || Huffman.get().encodedLength(byteString) >= byteString.mo6166h()) {
                writeInt(byteString.mo6166h(), Hpack.PREFIX_7_BITS, 0);
                this.out.m36486a(byteString);
                return;
            }
            Object buffer = new Buffer();
            Huffman.get().encode(byteString, buffer);
            byteString = buffer.m36534o();
            writeInt(byteString.mo6166h(), Hpack.PREFIX_7_BITS, 128);
            this.out.m36486a(byteString);
        }

        final void setHeaderTableSizeSetting(int i) {
            this.headerTableSizeSetting = i;
            i = Math.min(i, SETTINGS_HEADER_TABLE_SIZE_LIMIT);
            if (this.maxDynamicTableByteCount != i) {
                if (i < this.maxDynamicTableByteCount) {
                    this.smallestHeaderTableSizeSetting = Math.min(this.smallestHeaderTableSizeSetting, i);
                }
                this.emitDynamicTableSizeUpdate = true;
                this.maxDynamicTableByteCount = i;
                adjustDynamicTableByteCount();
            }
        }

        private void adjustDynamicTableByteCount() {
            if (this.maxDynamicTableByteCount < this.dynamicTableByteCount) {
                if (this.maxDynamicTableByteCount == 0) {
                    clearDynamicTable();
                    return;
                }
                evictToRecoverBytes(this.dynamicTableByteCount - this.maxDynamicTableByteCount);
            }
        }
    }

    private Hpack() {
    }

    private static Map<ByteString, Integer> nameToFirstIndex() {
        Map linkedHashMap = new LinkedHashMap(STATIC_HEADER_TABLE.length);
        for (int i = 0; i < STATIC_HEADER_TABLE.length; i++) {
            if (!linkedHashMap.containsKey(STATIC_HEADER_TABLE[i].name)) {
                linkedHashMap.put(STATIC_HEADER_TABLE[i].name, Integer.valueOf(i));
            }
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    static ByteString checkLowercase(ByteString byteString) throws IOException {
        int h = byteString.mo6166h();
        int i = 0;
        while (i < h) {
            byte a = byteString.mo6153a(i);
            if (a < (byte) 65 || a > (byte) 90) {
                i++;
            } else {
                StringBuilder stringBuilder = new StringBuilder("PROTOCOL_ERROR response malformed: mixed case name: ");
                stringBuilder.append(byteString.mo6154a());
                throw new IOException(stringBuilder.toString());
            }
        }
        return byteString;
    }
}
