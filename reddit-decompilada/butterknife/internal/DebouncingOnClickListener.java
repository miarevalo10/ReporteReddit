package butterknife.internal;

import android.view.View;
import android.view.View.OnClickListener;

public abstract class DebouncingOnClickListener implements OnClickListener {
    static boolean f2746a = true;
    private static final Runnable f2747b = new C02411();

    static class C02411 implements Runnable {
        C02411() {
        }

        public final void run() {
            DebouncingOnClickListener.f2746a = true;
        }
    }

    public abstract void m2432a();

    public final void onClick(View view) {
        if (f2746a) {
            f2746a = false;
            view.post(f2747b);
            m2432a();
        }
    }
}
