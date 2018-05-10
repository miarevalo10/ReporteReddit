package kotlin.text;

import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000bR\u0010\u0010\u0010\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lkotlin/text/Charsets;", "", "()V", "ISO_8859_1", "Ljava/nio/charset/Charset;", "US_ASCII", "UTF_16", "UTF_16BE", "UTF_16LE", "UTF_32", "UTF32", "()Ljava/nio/charset/Charset;", "UTF_32BE", "UTF32_BE", "UTF_32LE", "UTF32_LE", "UTF_8", "utf_32", "utf_32be", "utf_32le", "kotlin-stdlib"}, k = 1, mv = {1, 1, 9})
/* compiled from: Charsets.kt */
public final class Charsets {
    public static final Charset f26455a;
    public static final Charset f26456b;
    public static final Charset f26457c;
    public static final Charset f26458d;
    public static final Charset f26459e;
    public static final Charset f26460f;
    public static final Charsets f26461g = new Charsets();

    static {
        Object forName = Charset.forName("UTF-8");
        Intrinsics.m26843a(forName, "Charset.forName(\"UTF-8\")");
        f26455a = forName;
        forName = Charset.forName("UTF-16");
        Intrinsics.m26843a(forName, "Charset.forName(\"UTF-16\")");
        f26456b = forName;
        forName = Charset.forName("UTF-16BE");
        Intrinsics.m26843a(forName, "Charset.forName(\"UTF-16BE\")");
        f26457c = forName;
        forName = Charset.forName("UTF-16LE");
        Intrinsics.m26843a(forName, "Charset.forName(\"UTF-16LE\")");
        f26458d = forName;
        forName = Charset.forName("US-ASCII");
        Intrinsics.m26843a(forName, "Charset.forName(\"US-ASCII\")");
        f26459e = forName;
        forName = Charset.forName("ISO-8859-1");
        Intrinsics.m26843a(forName, "Charset.forName(\"ISO-8859-1\")");
        f26460f = forName;
    }

    private Charsets() {
    }
}
