package okhttp3;

import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;

public final class FormBody extends RequestBody {
    private static final MediaType CONTENT_TYPE = MediaType.parse(HttpRequest.CONTENT_TYPE_FORM);
    private final List<String> encodedNames;
    private final List<String> encodedValues;

    public static final class Builder {
        private final Charset charset;
        private final List<String> names;
        private final List<String> values;

        public Builder() {
            this(null);
        }

        public Builder(Charset charset) {
            this.names = new ArrayList();
            this.values = new ArrayList();
            this.charset = charset;
        }

        public final Builder add(String str, String str2) {
            this.names.add(HttpUrl.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.charset));
            this.values.add(HttpUrl.canonicalize(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.charset));
            return this;
        }

        public final Builder addEncoded(String str, String str2) {
            this.names.add(HttpUrl.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.charset));
            this.values.add(HttpUrl.canonicalize(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.charset));
            return this;
        }

        public final FormBody build() {
            return new FormBody(this.names, this.values);
        }
    }

    FormBody(List<String> list, List<String> list2) {
        this.encodedNames = Util.immutableList((List) list);
        this.encodedValues = Util.immutableList((List) list2);
    }

    public final int size() {
        return this.encodedNames.size();
    }

    public final String encodedName(int i) {
        return (String) this.encodedNames.get(i);
    }

    public final String name(int i) {
        return HttpUrl.percentDecode(encodedName(i), true);
    }

    public final String encodedValue(int i) {
        return (String) this.encodedValues.get(i);
    }

    public final String value(int i) {
        return HttpUrl.percentDecode(encodedValue(i), true);
    }

    public final MediaType contentType() {
        return CONTENT_TYPE;
    }

    public final long contentLength() {
        return writeOrCountBytes(null, true);
    }

    public final void writeTo(BufferedSink bufferedSink) throws IOException {
        writeOrCountBytes(bufferedSink, false);
    }

    private long writeOrCountBytes(BufferedSink bufferedSink, boolean z) {
        if (z) {
            bufferedSink = new Buffer();
        } else {
            bufferedSink = bufferedSink.mo6754a();
        }
        int size = this.encodedNames.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                bufferedSink.m36493b(38);
            }
            bufferedSink.m36482a((String) this.encodedNames.get(i));
            bufferedSink.m36493b(61);
            bufferedSink.m36482a((String) this.encodedValues.get(i));
        }
        if (!z) {
            return 0;
        }
        long j = bufferedSink.f36201b;
        bufferedSink.m36539t();
        return j;
    }
}
