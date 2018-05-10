package retrofit2;

import java.lang.reflect.Type;
import retrofit2.CallAdapter.Factory;

final class DefaultCallAdapterFactory extends Factory {
    static final Factory f41578a = new DefaultCallAdapterFactory();

    DefaultCallAdapterFactory() {
    }

    public final CallAdapter<?, ?> mo7880a(Type type) {
        if (Utils.m43342a(type) != Call.class) {
            return null;
        }
        type = Utils.m43355e(type);
        return new CallAdapter<Object, Call<?>>(this) {
            final /* synthetic */ DefaultCallAdapterFactory f41577b;

            public final /* bridge */ /* synthetic */ Object mo7878a(Call call) {
                return call;
            }

            public final Type mo7879a() {
                return type;
            }
        };
    }
}
