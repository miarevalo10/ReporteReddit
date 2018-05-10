package com.googlecode.mp4parser.boxes.piff;

import com.coremedia.iso.Hex;
import com.googlecode.mp4parser.contentprotection.GenericHeader;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public abstract class ProtectionSpecificHeader {
    protected static Map<UUID, Class<? extends ProtectionSpecificHeader>> f8986a = new HashMap();

    public abstract ByteBuffer mo2529a();

    public abstract void mo2530a(ByteBuffer byteBuffer);

    public boolean equals(Object obj) {
        throw new RuntimeException("somebody called equals on me but that's not supposed to happen.");
    }

    public static ProtectionSpecificHeader m7695a(UUID uuid, ByteBuffer byteBuffer) {
        Class cls = (Class) f8986a.get(uuid);
        if (cls != null) {
            try {
                uuid = (ProtectionSpecificHeader) cls.newInstance();
            } catch (UUID uuid2) {
                throw new RuntimeException(uuid2);
            } catch (UUID uuid22) {
                throw new RuntimeException(uuid22);
            }
        }
        uuid22 = null;
        if (uuid22 == null) {
            uuid22 = new GenericHeader();
        }
        uuid22.mo2530a(byteBuffer);
        return uuid22;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ProtectionSpecificHeader");
        stringBuilder.append("{data=");
        ByteBuffer duplicate = mo2529a().duplicate();
        duplicate.rewind();
        byte[] bArr = new byte[duplicate.limit()];
        duplicate.get(bArr);
        stringBuilder.append(Hex.m3277a(bArr));
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
