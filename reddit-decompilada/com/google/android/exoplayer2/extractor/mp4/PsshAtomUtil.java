package com.google.android.exoplayer2.extractor.mp4;

import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.nio.ByteBuffer;
import java.util.UUID;

public final class PsshAtomUtil {
    public static byte[] m3815a(UUID uuid, byte[] bArr) {
        int length = 32 + bArr.length;
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.putInt(length);
        allocate.putInt(Atom.f4344U);
        allocate.putInt(0);
        allocate.putLong(uuid.getMostSignificantBits());
        allocate.putLong(uuid.getLeastSignificantBits());
        allocate.putInt(bArr.length);
        allocate.put(bArr);
        return allocate.array();
    }

    public static UUID m3814a(byte[] bArr) {
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr);
        if (parsableByteArray.f5258c >= 32) {
            parsableByteArray.m4249c(0);
            if (parsableByteArray.m4259j() == parsableByteArray.m4246b() + 4) {
                if (parsableByteArray.m4259j() == Atom.f4344U) {
                    int a = Atom.m3787a(parsableByteArray.m4259j());
                    if (a > 1) {
                        StringBuilder stringBuilder = new StringBuilder("Unsupported pssh version: ");
                        stringBuilder.append(a);
                        Log.w("PsshAtomUtil", stringBuilder.toString());
                    } else {
                        UUID uuid = new UUID(parsableByteArray.m4261l(), parsableByteArray.m4261l());
                        if (a == 1) {
                            parsableByteArray.m4251d(16 * parsableByteArray.m4263n());
                        }
                        a = parsableByteArray.m4263n();
                        if (a == parsableByteArray.m4246b()) {
                            Object obj = new byte[a];
                            parsableByteArray.m4245a(obj, 0, a);
                            bArr = Pair.create(uuid, obj);
                            if (bArr != null) {
                                return null;
                            }
                            return (UUID) bArr.first;
                        }
                    }
                }
            }
        }
        bArr = null;
        if (bArr != null) {
            return (UUID) bArr.first;
        }
        return null;
    }
}
