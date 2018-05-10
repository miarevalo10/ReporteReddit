package com.microsoft.thrifty.util;

import com.microsoft.thrifty.protocol.Protocol;
import java.io.IOException;
import java.net.ProtocolException;

public final class ProtocolUtil {
    public static void m8514a(Protocol protocol, byte b) throws IOException {
        int i = 0;
        switch (b) {
            case (byte) 2:
                protocol.mo2646f();
                return;
            case (byte) 3:
                protocol.mo2647g();
                return;
            case (byte) 4:
                protocol.mo2651k();
                return;
            case (byte) 6:
                protocol.mo2648h();
                return;
            case (byte) 8:
                protocol.mo2649i();
                return;
            case (byte) 10:
                protocol.mo2650j();
                return;
            case (byte) 11:
                protocol.mo2652l();
                return;
            case (byte) 12:
                break;
            case (byte) 13:
                b = protocol.mo2643c();
                while (i < b.f10042c) {
                    m8514a(protocol, b.f10040a);
                    m8514a(protocol, b.f10041b);
                    i++;
                }
                return;
            case (byte) 14:
                b = protocol.mo2645e();
                while (i < b.f10045b) {
                    m8514a(protocol, b.f10044a);
                    i++;
                }
                return;
            case (byte) 15:
                b = protocol.mo2644d();
                while (i < b.f10039b) {
                    m8514a(protocol, b.f10038a);
                    i++;
                }
                return;
            case (byte) 16:
                protocol.mo2649i();
                return;
            default:
                StringBuilder stringBuilder = new StringBuilder("Unrecognized TType value: ");
                stringBuilder.append(b);
                throw new ProtocolException(stringBuilder.toString());
        }
        while (true) {
            b = protocol.mo2642b();
            if (b.f10036b != (byte) 0) {
                m8514a(protocol, b.f10036b);
            } else {
                return;
            }
        }
    }
}
