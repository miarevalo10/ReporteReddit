package pl.droidsonroids.gif;

import java.io.IOException;

public class GifIOException extends IOException {
    public final GifError f41191a;
    private final String f41192b;

    public String getMessage() {
        if (this.f41192b == null) {
            return this.f41191a.m43248a();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f41191a.m43248a());
        stringBuilder.append(": ");
        stringBuilder.append(this.f41192b);
        return stringBuilder.toString();
    }

    private GifIOException(int i, String str) {
        this.f41191a = GifError.m43247a(i);
        this.f41192b = str;
    }
}
