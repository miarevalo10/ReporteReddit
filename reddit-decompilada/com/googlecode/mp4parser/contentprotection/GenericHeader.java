package com.googlecode.mp4parser.contentprotection;

import com.googlecode.mp4parser.boxes.piff.ProtectionSpecificHeader;
import java.nio.ByteBuffer;
import java.util.UUID;

public class GenericHeader extends ProtectionSpecificHeader {
    public static UUID f15231b = UUID.fromString("00000000-0000-0000-0000-000000000000");
    ByteBuffer f15232c;

    static {
        ProtectionSpecificHeader.f8986a.put(f15231b, GenericHeader.class);
    }

    public final void mo2530a(ByteBuffer byteBuffer) {
        this.f15232c = byteBuffer;
    }

    public final ByteBuffer mo2529a() {
        return this.f15232c;
    }
}
