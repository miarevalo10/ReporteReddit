package com.google.android.exoplayer2.upstream;

import android.text.TextUtils;
import com.google.android.exoplayer2.util.Predicate;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface HttpDataSource extends DataSource {
    public static final Predicate<String> f13678a = new C11431();

    public static class HttpDataSourceException extends IOException {
        public final int f5178a;
        public final DataSpec f5179b;

        public HttpDataSourceException(String str, DataSpec dataSpec) {
            super(str);
            this.f5179b = dataSpec;
            this.f5178a = 1;
        }

        public HttpDataSourceException(IOException iOException, DataSpec dataSpec, int i) {
            super(iOException);
            this.f5179b = dataSpec;
            this.f5178a = i;
        }

        public HttpDataSourceException(String str, IOException iOException, DataSpec dataSpec) {
            super(str, iOException);
            this.f5179b = dataSpec;
            this.f5178a = 1;
        }
    }

    public static final class RequestProperties {
        private final Map<String, String> f5180a = new HashMap();
        private Map<String, String> f5181b;

        public final synchronized Map<String, String> m4151a() {
            if (this.f5181b == null) {
                this.f5181b = Collections.unmodifiableMap(new HashMap(this.f5180a));
            }
            return this.f5181b;
        }
    }

    static class C11431 implements Predicate<String> {
        C11431() {
        }

        public final /* synthetic */ boolean mo1476a(Object obj) {
            obj = Util.m4323d((String) obj);
            return (TextUtils.isEmpty(obj) || ((obj.contains("text") && !obj.contains("text/vtt")) || obj.contains("html") || obj.contains("xml") != null)) ? null : true;
        }
    }

    public interface Factory extends com.google.android.exoplayer2.upstream.DataSource.Factory {
    }

    public static final class InvalidContentTypeException extends HttpDataSourceException {
        public final String f13675c;

        public InvalidContentTypeException(String str, DataSpec dataSpec) {
            StringBuilder stringBuilder = new StringBuilder("Invalid content type: ");
            stringBuilder.append(str);
            super(stringBuilder.toString(), dataSpec);
            this.f13675c = str;
        }
    }

    public static final class InvalidResponseCodeException extends HttpDataSourceException {
        public final int f13676c;
        public final Map<String, List<String>> f13677d;

        public InvalidResponseCodeException(int i, Map<String, List<String>> map, DataSpec dataSpec) {
            StringBuilder stringBuilder = new StringBuilder("Response code: ");
            stringBuilder.append(i);
            super(stringBuilder.toString(), dataSpec);
            this.f13676c = i;
            this.f13677d = map;
        }
    }

    public static abstract class BaseFactory implements Factory {
        private final RequestProperties f17070a = new RequestProperties();

        protected abstract HttpDataSource mo3932a(RequestProperties requestProperties);

        public final /* bridge */ /* synthetic */ DataSource mo1475a() {
            return mo3932a(this.f17070a);
        }
    }
}
