package rx;

import rx.functions.Action1;
import rx.functions.Func1;
import rx.subscriptions.Subscriptions;

public class Completable {
    static final Completable f41291a = new Completable(new C31501());
    static final Completable f41292b = new Completable(new C31512());
    private final CompletableOnSubscribe f41293c;

    public interface CompletableOnSubscribe extends Action1<Object> {
    }

    public interface CompletableOperator extends Func1<Object, Object> {
    }

    static class C31501 implements CompletableOnSubscribe {
        C31501() {
        }

        public final /* bridge */ /* synthetic */ void mo7899a(Object obj) {
            Subscriptions.m43536a();
        }
    }

    static class C31512 implements CompletableOnSubscribe {
        C31512() {
        }

        public final /* bridge */ /* synthetic */ void mo7899a(Object obj) {
            Subscriptions.m43536a();
        }
    }

    private Completable(CompletableOnSubscribe completableOnSubscribe) {
        this.f41293c = completableOnSubscribe;
    }
}
