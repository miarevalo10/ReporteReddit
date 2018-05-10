package com.instabug.library.visualusersteps;

import com.instabug.library.Instabug;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.visualusersteps.C0781a.C0780a;
import java.io.File;
import java.util.LinkedList;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.schedulers.Schedulers;

/* compiled from: VisualUserSteps */
public class C0784c {
    public LinkedList<C0781a> f9937a = new LinkedList();
    int f9938b;

    /* compiled from: VisualUserSteps */
    class C14041 implements Action1<Boolean> {
        final /* synthetic */ C0784c f15553a;

        public final /* synthetic */ void m15463a(Object obj) {
        }

        C14041(C0784c c0784c) {
            this.f15553a = c0784c;
        }
    }

    C0784c() {
    }

    final C0781a m8383a() {
        if (this.f9937a.isEmpty()) {
            return null;
        }
        return (C0781a) this.f9937a.getLast();
    }

    final C0781a m8384b() {
        return (C0781a) this.f9937a.getFirst();
    }

    final void m8385c() {
        C0780a c0780a = ((C0781a) this.f9937a.getFirst()).f9918c;
        if (c0780a != null) {
            final String str = c0780a.f9914a;
            Observable.a(new Func0<Observable<Boolean>>(this) {
                final /* synthetic */ C0784c f15555b;

                public /* synthetic */ Object call() {
                    return Observable.b(Boolean.valueOf(C0784c.m8382a(str)));
                }
            }).b(Schedulers.d()).a(new C14041(this));
        }
        this.f9938b -= ((C0781a) this.f9937a.getFirst()).f9919d.size();
        this.f9937a.removeFirst();
    }

    static /* synthetic */ boolean m8382a(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(VisualUserStepsHelper.getVisualUserStepsDirectory(Instabug.getApplicationContext()));
        stringBuilder.append(File.separator);
        stringBuilder.append(str);
        File file = new File(stringBuilder.toString());
        if (file.exists() && file.delete()) {
            stringBuilder = new StringBuilder("VisualUserStep screenshot deleted! filename= ");
            stringBuilder.append(str);
            InstabugSDKLogger.m8360v(C0786d.class, stringBuilder.toString());
            return true;
        }
        stringBuilder = new StringBuilder("VisualUserStep screenshot doesn't deleted! filename= ");
        stringBuilder.append(str);
        stringBuilder.append("\n Something went wrong");
        InstabugSDKLogger.m8360v(C0786d.class, stringBuilder.toString());
        return null;
    }
}
