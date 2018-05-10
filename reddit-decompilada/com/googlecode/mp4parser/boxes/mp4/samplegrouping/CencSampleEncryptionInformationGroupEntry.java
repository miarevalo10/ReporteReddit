package com.googlecode.mp4parser.boxes.mp4.samplegrouping;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.util.UUIDConverter;
import java.nio.ByteBuffer;
import java.util.UUID;

public class CencSampleEncryptionInformationGroupEntry extends GroupEntry {
    private boolean f15215a;
    private byte f15216b;
    private UUID f15217c;

    public final String mo2526a() {
        return "seig";
    }

    public final void mo2527a(ByteBuffer byteBuffer) {
        boolean z = true;
        if (IsoTypeReader.m3282b(byteBuffer) != 1) {
            z = false;
        }
        this.f15215a = z;
        this.f15216b = (byte) IsoTypeReader.m3284d(byteBuffer);
        byte[] bArr = new byte[16];
        byteBuffer.get(bArr);
        this.f15217c = UUIDConverter.m7723a(bArr);
    }

    public final ByteBuffer mo2528b() {
        ByteBuffer allocate = ByteBuffer.allocate(20);
        IsoTypeWriter.m3295a(allocate, this.f15215a);
        if (this.f15215a) {
            IsoTypeWriter.m3303c(allocate, this.f15216b);
            allocate.put(UUIDConverter.m7724a(this.f15217c));
        } else {
            allocate.put(new byte[17]);
        }
        allocate.rewind();
        return allocate;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("CencSampleEncryptionInformationGroupEntry{isEncrypted=");
        stringBuilder.append(this.f15215a);
        stringBuilder.append(", ivSize=");
        stringBuilder.append(this.f15216b);
        stringBuilder.append(", kid=");
        stringBuilder.append(this.f15217c);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                CencSampleEncryptionInformationGroupEntry cencSampleEncryptionInformationGroupEntry = (CencSampleEncryptionInformationGroupEntry) obj;
                if (this.f15215a != cencSampleEncryptionInformationGroupEntry.f15215a || this.f15216b != cencSampleEncryptionInformationGroupEntry.f15216b) {
                    return false;
                }
                if (this.f15217c == null) {
                    return cencSampleEncryptionInformationGroupEntry.f15217c == null;
                } else {
                    if (this.f15217c.equals(cencSampleEncryptionInformationGroupEntry.f15217c) == null) {
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        return (31 * (((this.f15215a ? 7 : 19) * 31) + this.f15216b)) + (this.f15217c != null ? this.f15217c.hashCode() : 0);
    }
}
