package okhttp3.internal.http2;

import java.io.IOException;
import java.util.List;
import okio.BufferedSource;

public interface PushObserver {
    public static final PushObserver CANCEL = new C26241();

    class C26241 implements PushObserver {
        public final boolean onHeaders(int i, List<Header> list, boolean z) {
            return true;
        }

        public final boolean onRequest(int i, List<Header> list) {
            return true;
        }

        public final void onReset(int i, ErrorCode errorCode) {
        }

        C26241() {
        }

        public final boolean onData(int i, BufferedSource bufferedSource, int i2, boolean z) throws IOException {
            bufferedSource.mo6779i((long) i2);
            return true;
        }
    }

    boolean onData(int i, BufferedSource bufferedSource, int i2, boolean z) throws IOException;

    boolean onHeaders(int i, List<Header> list, boolean z);

    boolean onRequest(int i, List<Header> list);

    void onReset(int i, ErrorCode errorCode);
}
