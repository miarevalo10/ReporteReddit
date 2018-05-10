package android.support.v4.util;

import android.util.Log;
import java.io.Writer;

public class LogWriter extends Writer {
    private final String f1388a;
    private StringBuilder f1389b = new StringBuilder(128);

    public LogWriter(String str) {
        this.f1388a = str;
    }

    public void close() {
        m1012a();
    }

    public void flush() {
        m1012a();
    }

    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == '\n') {
                m1012a();
            } else {
                this.f1389b.append(c);
            }
        }
    }

    private void m1012a() {
        if (this.f1389b.length() > 0) {
            Log.d(this.f1388a, this.f1389b.toString());
            this.f1389b.delete(0, this.f1389b.length());
        }
    }
}
