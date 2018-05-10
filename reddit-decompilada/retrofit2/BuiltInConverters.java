package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter.Factory;
import retrofit2.http.Streaming;

final class BuiltInConverters extends Factory {

    static final class BufferingResponseBodyConverter implements Converter<ResponseBody, ResponseBody> {
        static final BufferingResponseBodyConverter f41571a = new BufferingResponseBodyConverter();

        BufferingResponseBodyConverter() {
        }

        private static ResponseBody m43732a(ResponseBody responseBody) throws IOException {
            try {
                ResponseBody a = Utils.m43347a(responseBody);
                return a;
            } finally {
                responseBody.close();
            }
        }
    }

    static final class RequestBodyConverter implements Converter<RequestBody, RequestBody> {
        static final RequestBodyConverter f41572a = new RequestBodyConverter();

        RequestBodyConverter() {
        }

        public final /* bridge */ /* synthetic */ Object mo7875a(Object obj) throws IOException {
            return (RequestBody) obj;
        }
    }

    static final class StreamingResponseBodyConverter implements Converter<ResponseBody, ResponseBody> {
        static final StreamingResponseBodyConverter f41573a = new StreamingResponseBodyConverter();

        StreamingResponseBodyConverter() {
        }

        public final /* bridge */ /* synthetic */ Object mo7875a(Object obj) throws IOException {
            return (ResponseBody) obj;
        }
    }

    static final class ToStringConverter implements Converter<Object, String> {
        static final ToStringConverter f41574a = new ToStringConverter();

        ToStringConverter() {
        }

        public final /* synthetic */ Object mo7875a(Object obj) throws IOException {
            return obj.toString();
        }
    }

    static final class VoidResponseBodyConverter implements Converter<ResponseBody, Void> {
        static final VoidResponseBodyConverter f41575a = new VoidResponseBodyConverter();

        VoidResponseBodyConverter() {
        }

        public final /* synthetic */ Object mo7875a(Object obj) throws IOException {
            ((ResponseBody) obj).close();
            return null;
        }
    }

    BuiltInConverters() {
    }

    public final Converter<ResponseBody, ?> mo7876a(Type type, Annotation[] annotationArr) {
        if (type != ResponseBody.class) {
            return type == Void.class ? VoidResponseBodyConverter.f41575a : null;
        } else {
            if (Utils.m43350a(annotationArr, Streaming.class) != null) {
                return StreamingResponseBodyConverter.f41573a;
            }
            return BufferingResponseBodyConverter.f41571a;
        }
    }

    public final Converter<?, RequestBody> mo7877b(Type type, Annotation[] annotationArr) {
        return RequestBody.class.isAssignableFrom(Utils.m43342a(type)) != null ? RequestBodyConverter.f41572a : null;
    }
}
