package retrofit2.adapter.rxjava2;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import retrofit2.CallAdapter;
import retrofit2.CallAdapter.Factory;
import retrofit2.Response;
import retrofit2.Utils;

public final class RxJava2CallAdapterFactory extends Factory {
    private final Scheduler f41642a = null;
    private final boolean f41643b = false;

    public static RxJava2CallAdapterFactory m43788a() {
        return new RxJava2CallAdapterFactory();
    }

    private RxJava2CallAdapterFactory() {
    }

    public final CallAdapter<?, ?> mo7880a(Type type) {
        Class a = Utils.m43342a(type);
        if (a == Completable.class) {
            return new RxJava2CallAdapter(Void.class, this.f41642a, this.f41643b, false, true, false, false, false, true);
        }
        boolean z = a == Flowable.class;
        boolean z2 = a == Single.class;
        boolean z3 = a == Maybe.class;
        if (a != Observable.class && !z && !z2 && !z3) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            Type a2;
            boolean z4;
            boolean z5;
            type = Utils.m43344a(0, (ParameterizedType) type);
            a = Utils.m43342a(type);
            if (a == Response.class) {
                if (type instanceof ParameterizedType) {
                    a2 = Utils.m43344a(0, (ParameterizedType) type);
                    z4 = false;
                    z5 = z4;
                } else {
                    throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
                }
            } else if (a != Result.class) {
                a2 = type;
                z5 = true;
                z4 = false;
            } else if (type instanceof ParameterizedType) {
                a2 = Utils.m43344a(0, (ParameterizedType) type);
                z4 = true;
                z5 = false;
            } else {
                throw new IllegalStateException("Result must be parameterized as Result<Foo> or Result<? extends Foo>");
            }
            return new RxJava2CallAdapter(a2, this.f41642a, this.f41643b, z4, z5, z, z2, z3, false);
        }
        type = z ? "Flowable" : z2 ? "Single" : z3 ? "Maybe" : "Observable";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(type);
        stringBuilder.append(" return type must be parameterized as ");
        stringBuilder.append(type);
        stringBuilder.append("<Foo> or ");
        stringBuilder.append(type);
        stringBuilder.append("<? extends Foo>");
        throw new IllegalStateException(stringBuilder.toString());
    }
}
