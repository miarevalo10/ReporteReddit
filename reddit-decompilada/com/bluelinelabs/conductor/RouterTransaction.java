package com.bluelinelabs.conductor;

import android.os.Bundle;
import com.bluelinelabs.conductor.internal.TransactionIndexer;

public class RouterTransaction {
    private static int f3143g = -1;
    public final Controller f3144a;
    String f3145b;
    ControllerChangeHandler f3146c;
    ControllerChangeHandler f3147d;
    boolean f3148e;
    int f3149f = f3143g;

    public static RouterTransaction m2744a(Controller controller) {
        return new RouterTransaction(controller);
    }

    private RouterTransaction(Controller controller) {
        this.f3144a = controller;
    }

    RouterTransaction(Bundle bundle) {
        this.f3144a = Controller.m2617a(bundle.getBundle("RouterTransaction.controller.bundle"));
        this.f3146c = ControllerChangeHandler.m2679c(bundle.getBundle("RouterTransaction.pushControllerChangeHandler"));
        this.f3147d = ControllerChangeHandler.m2679c(bundle.getBundle("RouterTransaction.popControllerChangeHandler"));
        this.f3145b = bundle.getString("RouterTransaction.tag");
        this.f3149f = bundle.getInt("RouterTransaction.transactionIndex");
        this.f3148e = bundle.getBoolean("RouterTransaction.attachedToRouter");
    }

    public final Controller m2745a() {
        return this.f3144a;
    }

    public final RouterTransaction m2747a(String str) {
        if (this.f3148e) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(getClass().getSimpleName());
            stringBuilder.append("s can not be modified after being added to a Router.");
            throw new RuntimeException(stringBuilder.toString());
        }
        this.f3145b = str;
        return this;
    }

    public final ControllerChangeHandler m2749b() {
        ControllerChangeHandler controllerChangeHandler = this.f3144a.f3104o;
        return controllerChangeHandler == null ? this.f3146c : controllerChangeHandler;
    }

    public final RouterTransaction m2746a(ControllerChangeHandler controllerChangeHandler) {
        if (this.f3148e) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(getClass().getSimpleName());
            stringBuilder.append("s can not be modified after being added to a Router.");
            throw new RuntimeException(stringBuilder.toString());
        }
        this.f3146c = controllerChangeHandler;
        return this;
    }

    public final ControllerChangeHandler m2751c() {
        ControllerChangeHandler controllerChangeHandler = this.f3144a.f3105p;
        return controllerChangeHandler == null ? this.f3147d : controllerChangeHandler;
    }

    public final RouterTransaction m2750b(ControllerChangeHandler controllerChangeHandler) {
        if (this.f3148e) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(getClass().getSimpleName());
            stringBuilder.append("s can not be modified after being added to a Router.");
            throw new RuntimeException(stringBuilder.toString());
        }
        this.f3147d = controllerChangeHandler;
        return this;
    }

    final void m2748a(TransactionIndexer transactionIndexer) {
        if (transactionIndexer == null) {
            throw new RuntimeException();
        } else if (this.f3149f == f3143g && transactionIndexer != null) {
            int i = transactionIndexer.f3176a + 1;
            transactionIndexer.f3176a = i;
            this.f3149f = i;
        }
    }
}
