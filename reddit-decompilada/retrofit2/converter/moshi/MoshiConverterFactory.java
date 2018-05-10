package retrofit2.converter.moshi;

import com.squareup.moshi.JsonQualifier;
import com.squareup.moshi.Moshi;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Converter.Factory;

public final class MoshiConverterFactory extends Factory {
    private final Moshi f41651a;
    private final boolean f41652b = false;
    private final boolean f41653c = false;
    private final boolean f41654d = false;

    public static MoshiConverterFactory m43798a(Moshi moshi) {
        if (moshi != null) {
            return new MoshiConverterFactory(moshi);
        }
        throw new NullPointerException("moshi == null");
    }

    private MoshiConverterFactory(Moshi moshi) {
        this.f41651a = moshi;
    }

    public final Converter<ResponseBody, ?> mo7876a(Type type, Annotation[] annotationArr) {
        type = this.f41651a.a(type, m43797a(annotationArr));
        if (this.f41652b != null) {
            type = type.lenient();
        }
        if (this.f41653c != null) {
            type = type.failOnUnknown();
        }
        if (this.f41654d != null) {
            type = type.serializeNulls();
        }
        return new MoshiResponseBodyConverter(type);
    }

    public final Converter<?, RequestBody> mo7877b(Type type, Annotation[] annotationArr) {
        type = this.f41651a.a(type, m43797a(annotationArr));
        if (this.f41652b != null) {
            type = type.lenient();
        }
        if (this.f41653c != null) {
            type = type.failOnUnknown();
        }
        if (this.f41654d != null) {
            type = type.serializeNulls();
        }
        return new MoshiRequestBodyConverter(type);
    }

    private static Set<? extends Annotation> m43797a(Annotation[] annotationArr) {
        Set set = null;
        for (Annotation annotation : annotationArr) {
            if (annotation.annotationType().isAnnotationPresent(JsonQualifier.class)) {
                if (set == null) {
                    set = new LinkedHashSet();
                }
                set.add(annotation);
            }
        }
        return set != null ? Collections.unmodifiableSet(set) : Collections.emptySet();
    }
}
