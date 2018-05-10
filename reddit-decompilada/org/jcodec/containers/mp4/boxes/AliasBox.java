package org.jcodec.containers.mp4.boxes;

import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.jcodec.common.JCodecUtil;
import org.jcodec.common.NIOUtils;

public class AliasBox extends FullBox {
    public static final int AbsolutePath = 2;
    public static final int AppleRemoteAccessDialup = 10;
    public static final int AppleShareServerName = 4;
    public static final int AppleShareUserName = 5;
    public static final int AppleShareZoneName = 3;
    public static final int DirectoryIDs = 1;
    public static final int DirectoryName = 0;
    public static final int DriverName = 6;
    public static final int RevisedAppleShare = 9;
    public static final int UFT16VolumeName = 15;
    public static final int UNIXAbsolutePath = 18;
    public static final int UTF16AbsolutePath = 14;
    public static final int VolumeMountPoint = 19;
    private static Set<Integer> utf16;
    private int createdLocalDate;
    private String creatorName;
    private List<ExtraField> extra;
    private String fileName;
    private int fileNumber;
    private String fileTypeName;
    private short fsId;
    private short kind;
    private short nlvlFrom;
    private short nlvlTo;
    private int parentDirId;
    private short recordSize;
    private String type;
    private short version;
    private int volumeAttributes;
    private int volumeCreateDate;
    private String volumeName;
    private short volumeSignature;
    private short volumeType;

    public static class ExtraField {
        byte[] data;
        int len;
        short type;

        public ExtraField(short s, int i, byte[] bArr) {
            this.type = s;
            this.len = i;
            this.data = bArr;
        }

        public java.lang.String toString() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r6 = this;
            r0 = new java.lang.String;	 Catch:{ UnsupportedEncodingException -> 0x0020 }
            r1 = r6.data;	 Catch:{ UnsupportedEncodingException -> 0x0020 }
            r2 = 0;	 Catch:{ UnsupportedEncodingException -> 0x0020 }
            r3 = r6.len;	 Catch:{ UnsupportedEncodingException -> 0x0020 }
            r4 = org.jcodec.containers.mp4.boxes.AliasBox.utf16;	 Catch:{ UnsupportedEncodingException -> 0x0020 }
            r5 = r6.type;	 Catch:{ UnsupportedEncodingException -> 0x0020 }
            r5 = java.lang.Short.valueOf(r5);	 Catch:{ UnsupportedEncodingException -> 0x0020 }
            r4 = r4.contains(r5);	 Catch:{ UnsupportedEncodingException -> 0x0020 }
            if (r4 == 0) goto L_0x001a;	 Catch:{ UnsupportedEncodingException -> 0x0020 }
        L_0x0017:
            r4 = "UTF-16";	 Catch:{ UnsupportedEncodingException -> 0x0020 }
            goto L_0x001c;	 Catch:{ UnsupportedEncodingException -> 0x0020 }
        L_0x001a:
            r4 = "UTF-8";	 Catch:{ UnsupportedEncodingException -> 0x0020 }
        L_0x001c:
            r0.<init>(r1, r2, r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x0020 }
            return r0;
        L_0x0020:
            r0 = 0;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jcodec.containers.mp4.boxes.AliasBox.ExtraField.toString():java.lang.String");
        }
    }

    public static String fourcc() {
        return "alis";
    }

    static {
        Set hashSet = new HashSet();
        utf16 = hashSet;
        hashSet.add(Integer.valueOf(14));
        utf16.add(Integer.valueOf(15));
    }

    public AliasBox() {
        super(new Header(fourcc(), 0));
    }

    public AliasBox(Header header) {
        super(header);
    }

    public void parse(ByteBuffer byteBuffer) {
        super.parse(byteBuffer);
        if ((this.flags & 1) == 0) {
            this.type = NIOUtils.readString(byteBuffer, 4);
            this.recordSize = byteBuffer.getShort();
            this.version = byteBuffer.getShort();
            this.kind = byteBuffer.getShort();
            this.volumeName = NIOUtils.readPascalString(byteBuffer, 27);
            this.volumeCreateDate = byteBuffer.getInt();
            this.volumeSignature = byteBuffer.getShort();
            this.volumeType = byteBuffer.getShort();
            this.parentDirId = byteBuffer.getInt();
            this.fileName = NIOUtils.readPascalString(byteBuffer, 63);
            this.fileNumber = byteBuffer.getInt();
            this.createdLocalDate = byteBuffer.getInt();
            this.fileTypeName = NIOUtils.readString(byteBuffer, 4);
            this.creatorName = NIOUtils.readString(byteBuffer, 4);
            this.nlvlFrom = byteBuffer.getShort();
            this.nlvlTo = byteBuffer.getShort();
            this.volumeAttributes = byteBuffer.getInt();
            this.fsId = byteBuffer.getShort();
            NIOUtils.skip(byteBuffer, 10);
            this.extra = new ArrayList();
            while (true) {
                short s = byteBuffer.getShort();
                if (s == (short) -1) {
                    break;
                }
                short s2 = byteBuffer.getShort();
                byte[] toArray = NIOUtils.toArray(NIOUtils.read(byteBuffer, (s2 + 1) & -2));
                if (toArray == null) {
                    break;
                }
                this.extra.add(new ExtraField(s, s2, toArray));
            }
        }
    }

    protected void doWrite(ByteBuffer byteBuffer) {
        super.doWrite(byteBuffer);
        if ((this.flags & 1) == 0) {
            byteBuffer.put(JCodecUtil.asciiString(this.type), 0, 4);
            byteBuffer.putShort(this.recordSize);
            byteBuffer.putShort(this.version);
            byteBuffer.putShort(this.kind);
            NIOUtils.writePascalString(byteBuffer, this.volumeName, 27);
            byteBuffer.putInt(this.volumeCreateDate);
            byteBuffer.putShort(this.volumeSignature);
            byteBuffer.putShort(this.volumeType);
            byteBuffer.putInt(this.parentDirId);
            NIOUtils.writePascalString(byteBuffer, this.fileName, 63);
            byteBuffer.putInt(this.fileNumber);
            byteBuffer.putInt(this.createdLocalDate);
            byteBuffer.put(JCodecUtil.asciiString(this.fileTypeName), 0, 4);
            byteBuffer.put(JCodecUtil.asciiString(this.creatorName), 0, 4);
            byteBuffer.putShort(this.nlvlFrom);
            byteBuffer.putShort(this.nlvlTo);
            byteBuffer.putInt(this.volumeAttributes);
            byteBuffer.putShort(this.fsId);
            byteBuffer.put(new byte[10]);
            for (ExtraField extraField : this.extra) {
                byteBuffer.putShort(extraField.type);
                byteBuffer.putShort((short) extraField.len);
                byteBuffer.put(extraField.data);
            }
            byteBuffer.putShort((short) -1);
            byteBuffer.putShort((short) 0);
        }
    }

    public int getRecordSize() {
        return this.recordSize;
    }

    public String getFileName() {
        return this.fileName;
    }

    public List<ExtraField> getExtra() {
        return this.extra;
    }

    public ExtraField getExtra(int i) {
        for (ExtraField extraField : this.extra) {
            if (extraField.type == i) {
                return extraField;
            }
        }
        return 0;
    }

    public boolean isSelfRef() {
        return (this.flags & 1) != 0;
    }

    public static AliasBox createSelfRef() {
        AliasBox aliasBox = new AliasBox();
        aliasBox.setFlags(1);
        return aliasBox;
    }

    public String getUnixPath() {
        ExtraField extra = getExtra(18);
        if (extra == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(Operation.DIVISION);
        stringBuilder.append(extra.toString());
        return stringBuilder.toString();
    }
}
