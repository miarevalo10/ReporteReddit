package okhttp3;

import java.nio.charset.Charset;
import okhttp3.internal.Util;

public final class Challenge {
    private final Charset charset;
    private final String realm;
    private final String scheme;

    public Challenge(String str, String str2) {
        this(str, str2, Util.ISO_8859_1);
    }

    private Challenge(String str, String str2, Charset charset) {
        if (str == null) {
            throw new NullPointerException("scheme == null");
        } else if (str2 == null) {
            throw new NullPointerException("realm == null");
        } else if (charset == null) {
            throw new NullPointerException("charset == null");
        } else {
            this.scheme = str;
            this.realm = str2;
            this.charset = charset;
        }
    }

    public final Challenge withCharset(Charset charset) {
        return new Challenge(this.scheme, this.realm, charset);
    }

    public final String scheme() {
        return this.scheme;
    }

    public final String realm() {
        return this.realm;
    }

    public final Charset charset() {
        return this.charset;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Challenge) {
            Challenge challenge = (Challenge) obj;
            if (challenge.scheme.equals(this.scheme) && challenge.realm.equals(this.realm) && challenge.charset.equals(this.charset) != null) {
                return true;
            }
        }
        return null;
    }

    public final int hashCode() {
        return (31 * (((899 + this.realm.hashCode()) * 31) + this.scheme.hashCode())) + this.charset.hashCode();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.scheme);
        stringBuilder.append(" realm=\"");
        stringBuilder.append(this.realm);
        stringBuilder.append("\" charset=\"");
        stringBuilder.append(this.charset);
        stringBuilder.append("\"");
        return stringBuilder.toString();
    }
}
