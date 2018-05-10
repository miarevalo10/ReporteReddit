package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

public interface Converter<F, T> {

    public static abstract class Factory {
        public Converter<ResponseBody, ?> mo7876a(Type type, Annotation[] annotationArr) {
            return null;
        }

        public Converter<?, RequestBody> mo7877b(Type type, Annotation[] annotationArr) {
            return null;
        }
    }

    T mo7875a(F f) throws IOException;
}
