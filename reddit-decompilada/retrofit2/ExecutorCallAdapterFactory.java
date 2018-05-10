package retrofit2;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;
import retrofit2.CallAdapter.Factory;

final class ExecutorCallAdapterFactory extends Factory {
    final Executor f41585a;

    static final class ExecutorCallbackCall<T> implements Call<T> {
        final Executor f41583a;
        final Call<T> f41584b;

        public final /* synthetic */ Object clone() throws CloneNotSupportedException {
            return mo7887d();
        }

        ExecutorCallbackCall(Executor executor, Call<T> call) {
            this.f41583a = executor;
            this.f41584b = call;
        }

        public final void mo7884a(final Callback<T> callback) {
            Utils.m43343a((Object) callback, "callback == null");
            this.f41584b.mo7884a(new Callback<T>(this) {
                final /* synthetic */ ExecutorCallbackCall f41582b;

                public final void mo7882a(Call<T> call, final Response<T> response) {
                    this.f41582b.f41583a.execute(new Runnable(this) {
                        final /* synthetic */ C31011 f41206b;

                        public void run() {
                            if (this.f41206b.f41582b.f41584b.mo7886c()) {
                                callback.mo7881a(this.f41206b.f41582b, new IOException("Canceled"));
                            } else {
                                callback.mo7882a(this.f41206b.f41582b, response);
                            }
                        }
                    });
                }

                public final void mo7881a(Call<T> call, final Throwable th) {
                    this.f41582b.f41583a.execute(new Runnable(this) {
                        final /* synthetic */ C31011 f41208b;

                        public void run() {
                            callback.mo7881a(this.f41208b.f41582b, th);
                        }
                    });
                }
            });
        }

        public final Response<T> mo7883a() throws IOException {
            return this.f41584b.mo7883a();
        }

        public final void mo7885b() {
            this.f41584b.mo7885b();
        }

        public final boolean mo7886c() {
            return this.f41584b.mo7886c();
        }

        public final Call<T> mo7887d() {
            return new ExecutorCallbackCall(this.f41583a, this.f41584b.mo7887d());
        }
    }

    ExecutorCallAdapterFactory(Executor executor) {
        this.f41585a = executor;
    }

    public final CallAdapter<?, ?> mo7880a(Type type) {
        if (Utils.m43342a(type) != Call.class) {
            return null;
        }
        type = Utils.m43355e(type);
        return new CallAdapter<Object, Call<?>>(this) {
            final /* synthetic */ ExecutorCallAdapterFactory f41580b;

            public final Type mo7879a() {
                return type;
            }

            public final /* synthetic */ Object mo7878a(Call call) {
                return new ExecutorCallbackCall(this.f41580b.f41585a, call);
            }
        };
    }
}
