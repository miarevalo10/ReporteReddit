package com.google.android.gms.internal;

public abstract class zzfek<MessageType extends zzfek<MessageType, BuilderType>, BuilderType extends zzfel<MessageType, BuilderType>> implements zzfhe {
    private static boolean f18035a = false;
    protected int f18036f = 0;

    public final byte[] mo3500h() {
        try {
            byte[] bArr = new byte[mo4040c()];
            zzffg a = zzffg.m13767a(bArr);
            mo4039a(a);
            a.m13822j();
            return bArr;
        } catch (Throwable e) {
            String str = "byte array";
            String name = getClass().getName();
            StringBuilder stringBuilder = new StringBuilder((62 + String.valueOf(name).length()) + String.valueOf(str).length());
            stringBuilder.append("Serializing ");
            stringBuilder.append(name);
            stringBuilder.append(" to a ");
            stringBuilder.append(str);
            stringBuilder.append(" threw an IOException (should never happen).");
            throw new RuntimeException(stringBuilder.toString(), e);
        }
    }

    public final zzfes mo3499g() {
        try {
            zzfex c = zzfes.m5951c(mo4040c());
            mo4039a(c.f7383a);
            c.f7383a.m13822j();
            return new zzfez(c.f7384b);
        } catch (Throwable e) {
            String str = "ByteString";
            String name = getClass().getName();
            StringBuilder stringBuilder = new StringBuilder((62 + String.valueOf(name).length()) + String.valueOf(str).length());
            stringBuilder.append("Serializing ");
            stringBuilder.append(name);
            stringBuilder.append(" to a ");
            stringBuilder.append(str);
            stringBuilder.append(" threw an IOException (should never happen).");
            throw new RuntimeException(stringBuilder.toString(), e);
        }
    }
}
