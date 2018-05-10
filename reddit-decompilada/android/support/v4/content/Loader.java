package android.support.v4.content;

import android.content.Context;
import android.support.v4.util.DebugUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class Loader<D> {
    public int f1186f;
    public OnLoadCompleteListener<D> f1187g;
    public OnLoadCanceledListener<D> f1188h;
    Context f1189i;
    protected boolean f1190j = false;
    public boolean f1191k = false;
    protected boolean f1192l = true;
    protected boolean f1193m = false;
    protected boolean f1194n = false;

    public interface OnLoadCanceledListener<D> {
        void mo251d();
    }

    public interface OnLoadCompleteListener<D> {
        void mo250a(Loader<D> loader, D d);
    }

    protected void mo262a() {
    }

    protected boolean mo264b() {
        return false;
    }

    protected void mo3403f() {
    }

    protected void mo3793j() {
    }

    protected void mo3794l() {
    }

    public Loader(Context context) {
        this.f1189i = context.getApplicationContext();
    }

    public void mo3792b(D d) {
        if (this.f1187g != null) {
            this.f1187g.mo250a(this, d);
        }
    }

    public final void m732a(OnLoadCompleteListener<D> onLoadCompleteListener) {
        if (this.f1187g == null) {
            throw new IllegalStateException("No listener register");
        } else if (this.f1187g != onLoadCompleteListener) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else {
            this.f1187g = null;
        }
    }

    public final void m731a(OnLoadCanceledListener<D> onLoadCanceledListener) {
        if (this.f1188h == null) {
            throw new IllegalStateException("No listener register");
        } else if (this.f1188h != onLoadCanceledListener) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else {
            this.f1188h = null;
        }
    }

    public final void m736e() {
        this.f1190j = true;
        this.f1192l = false;
        this.f1191k = false;
        mo3403f();
    }

    public final boolean m738g() {
        return mo264b();
    }

    public final void m739h() {
        mo262a();
    }

    public final void m740i() {
        this.f1190j = false;
        mo3793j();
    }

    public final void m742k() {
        mo3794l();
        this.f1192l = true;
        this.f1190j = false;
        this.f1191k = false;
        this.f1193m = false;
        this.f1194n = false;
    }

    public static String m729c(D d) {
        StringBuilder stringBuilder = new StringBuilder(64);
        DebugUtils.m1011a(d, stringBuilder);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        DebugUtils.m1011a(this, stringBuilder);
        stringBuilder.append(" id=");
        stringBuilder.append(this.f1186f);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void mo263a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.f1186f);
        printWriter.print(" mListener=");
        printWriter.println(this.f1187g);
        if (!(this.f1190j == null && this.f1193m == null && this.f1194n == null)) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f1190j);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.f1193m);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.f1194n);
        }
        if (this.f1191k != null || this.f1192l != null) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.f1191k);
            printWriter.print(" mReset=");
            printWriter.println(this.f1192l);
        }
    }
}
