package com.sendbird.android.shadow.okhttp3.internal.http2;

import com.sendbird.android.shadow.okio.BufferedSource;
import java.io.IOException;

public interface PushObserver {
    public static final PushObserver f23534a = new C24841();

    class C24841 implements PushObserver {
        public final boolean mo5353a() {
            return true;
        }

        public final boolean mo5355b() {
            return true;
        }

        public final void mo5356c() {
        }

        C24841() {
        }

        public final boolean mo5354a(BufferedSource bufferedSource, int i) throws IOException {
            bufferedSource.mo6568g((long) i);
            return true;
        }
    }

    boolean mo5353a();

    boolean mo5354a(BufferedSource bufferedSource, int i) throws IOException;

    boolean mo5355b();

    void mo5356c();
}
