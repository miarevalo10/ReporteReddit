package okio;

import java.util.AbstractList;
import java.util.RandomAccess;

public final class Options extends AbstractList<ByteString> implements RandomAccess {
    final ByteString[] f26669a;

    private Options(ByteString[] byteStringArr) {
        this.f26669a = byteStringArr;
    }

    public static Options m28302a(ByteString... byteStringArr) {
        return new Options((ByteString[]) byteStringArr.clone());
    }

    public final int size() {
        return this.f26669a.length;
    }

    public final /* bridge */ /* synthetic */ Object get(int i) {
        return this.f26669a[i];
    }
}
