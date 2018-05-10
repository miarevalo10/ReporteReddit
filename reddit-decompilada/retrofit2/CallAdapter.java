package retrofit2;

import java.lang.reflect.Type;

public interface CallAdapter<R, T> {

    public static abstract class Factory {
        public abstract CallAdapter<?, ?> mo7880a(Type type);
    }

    T mo7878a(Call<R> call);

    Type mo7879a();
}
