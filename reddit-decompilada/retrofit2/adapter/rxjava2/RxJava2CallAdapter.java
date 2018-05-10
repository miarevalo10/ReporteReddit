package retrofit2.adapter.rxjava2;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import java.lang.reflect.Type;
import retrofit2.Call;
import retrofit2.CallAdapter;

final class RxJava2CallAdapter<R> implements CallAdapter<R, Object> {
    private final Type f41633a;
    private final Scheduler f41634b;
    private final boolean f41635c;
    private final boolean f41636d;
    private final boolean f41637e;
    private final boolean f41638f;
    private final boolean f41639g;
    private final boolean f41640h;
    private final boolean f41641i;

    RxJava2CallAdapter(Type type, Scheduler scheduler, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.f41633a = type;
        this.f41634b = scheduler;
        this.f41635c = z;
        this.f41636d = z2;
        this.f41637e = z3;
        this.f41638f = z4;
        this.f41639g = z5;
        this.f41640h = z6;
        this.f41641i = z7;
    }

    public final Type mo7879a() {
        return this.f41633a;
    }

    public final Object mo7878a(Call<R> call) {
        Observable callEnqueueObservable;
        if (this.f41635c) {
            callEnqueueObservable = new CallEnqueueObservable(call);
        } else {
            callEnqueueObservable = new CallExecuteObservable(call);
        }
        call = this.f41636d != null ? new ResultObservable(callEnqueueObservable) : this.f41637e != null ? new BodyObservable(callEnqueueObservable) : callEnqueueObservable;
        if (this.f41634b != null) {
            call = call.subscribeOn(this.f41634b);
        }
        if (this.f41638f) {
            return call.toFlowable(BackpressureStrategy.e);
        }
        if (this.f41639g) {
            return call.singleOrError();
        }
        if (this.f41640h) {
            return call.singleElement();
        }
        return this.f41641i ? call.ignoreElements() : call;
    }
}
