package com.instabug.library.tracking;

import com.instabug.library.model.C0740d;
import com.instabug.library.model.C0740d.C0739a;
import com.instabug.library.util.InstabugDateFormatter;
import java.util.ArrayList;

/* compiled from: InstabugTrackingStepsProvider */
public class C0761d {
    private static C0761d f9883c;
    public ArrayList<C0740d> f9884a = new ArrayList(100);
    public String f9885b = "";

    private C0761d() {
    }

    public static C0761d m8330a() {
        if (f9883c == null) {
            f9883c = new C0761d();
        }
        return f9883c;
    }

    public final void m8334a(String str, C0739a c0739a) {
        this.f9885b = str;
        m8337b();
        this.f9884a.add(C0761d.m8332b(str, c0739a));
    }

    public final void m8335a(String str, String str2, C0739a c0739a) {
        this.f9885b = str;
        m8337b();
        this.f9884a.add(C0761d.m8333b(str, str2, c0739a));
    }

    public final void m8336a(String str, String str2, String str3, C0739a c0739a) {
        this.f9885b = str;
        str = C0761d.m8333b(str, str2, c0739a);
        str.f9835g = str3;
        m8337b();
        this.f9884a.add(str);
    }

    final void m8337b() {
        if (this.f9884a.size() == 100) {
            this.f9884a.remove(0);
        }
    }

    private static C0740d m8333b(String str, String str2, C0739a c0739a) {
        str = C0761d.m8332b(str, c0739a);
        str.f9831c = str2;
        return str;
    }

    private static C0740d m8332b(String str, C0739a c0739a) {
        C0740d c0740d = new C0740d();
        c0740d.f9829a = InstabugDateFormatter.getCurrentUTCTimeStampInMiliSeconds();
        c0740d.f9834f = c0739a;
        c0740d.f9830b = str;
        return c0740d;
    }

    public static String m8331a(C0740d c0740d) {
        StringBuilder stringBuilder = new StringBuilder();
        switch (c0740d.f9834f) {
            case TAP:
                stringBuilder.append("In activity ");
                stringBuilder.append(c0740d.f9830b);
                stringBuilder.append(": ");
                if (c0740d.f9832d != null) {
                    stringBuilder.append("View(");
                    stringBuilder.append(c0740d.f9832d);
                    stringBuilder.append(")");
                } else {
                    stringBuilder.append("View");
                }
                stringBuilder.append(" of type ");
                stringBuilder.append(c0740d.f9833e);
                stringBuilder.append(" received a click event");
                break;
            case SHAKE:
                stringBuilder.append("In activity ");
                stringBuilder.append(c0740d.f9830b);
                stringBuilder.append(": the user shook the phone");
                break;
            case APPLICATION_CREATED:
                stringBuilder.append(c0740d.f9830b);
                stringBuilder.append(" was created.");
                break;
            case ACTIVITY_CREATED:
                stringBuilder.append(c0740d.f9830b);
                stringBuilder.append(" was created.");
                break;
            case ACTIVITY_STARTED:
                stringBuilder.append(c0740d.f9830b);
                stringBuilder.append(" was started.");
                break;
            case ACTIVITY_RESUMED:
                stringBuilder.append(c0740d.f9830b);
                stringBuilder.append(" was resumed.");
                break;
            case ACTIVITY_PAUSED:
                stringBuilder.append(c0740d.f9830b);
                stringBuilder.append(" was paused.");
                break;
            case ACTIVITY_STOPPED:
                stringBuilder.append(c0740d.f9830b);
                stringBuilder.append(" was stopped.");
                break;
            case ACTIVITY_DESTROYED:
                stringBuilder.append(c0740d.f9830b);
                stringBuilder.append(" was destroyed.");
                break;
            case OPEN_DIALOG:
                stringBuilder.append("In container ");
                stringBuilder.append(c0740d.f9831c);
                stringBuilder.append(": dialog ");
                stringBuilder.append(c0740d.f9830b);
                stringBuilder.append(" was displayed.");
                break;
            case FRAGMENT_ATTACHED:
                stringBuilder.append("In activity ");
                stringBuilder.append(c0740d.f9831c);
                stringBuilder.append(": fragment ");
                stringBuilder.append(c0740d.f9830b);
                stringBuilder.append(" was attached.");
                break;
            case FRAGMENT_VIEW_CREATED:
                stringBuilder.append("In activity ");
                stringBuilder.append(c0740d.f9831c);
                stringBuilder.append(": fragment ");
                stringBuilder.append(c0740d.f9830b);
                stringBuilder.append(" was created.");
                break;
            case FRAGMENT_STARTED:
                stringBuilder.append("In activity ");
                stringBuilder.append(c0740d.f9831c);
                stringBuilder.append(": fragment ");
                stringBuilder.append(c0740d.f9830b);
                stringBuilder.append(" was started.");
                break;
            case FRAGMENT_RESUMED:
                stringBuilder.append("In activity ");
                stringBuilder.append(c0740d.f9831c);
                stringBuilder.append(": fragment ");
                stringBuilder.append(c0740d.f9830b);
                stringBuilder.append(" was resumed.");
                break;
            case FRAGMENT_PAUSED:
                stringBuilder.append("In activity ");
                stringBuilder.append(c0740d.f9831c);
                stringBuilder.append(": fragment ");
                stringBuilder.append(c0740d.f9830b);
                stringBuilder.append(" was paused.");
                break;
            case FRAGMENT_STOPPED:
                stringBuilder.append("In activity ");
                stringBuilder.append(c0740d.f9831c);
                stringBuilder.append(": fragment ");
                stringBuilder.append(c0740d.f9830b);
                stringBuilder.append(" was stopped.");
                break;
            case FRAGMENT_DETACHED:
                stringBuilder.append("In activity ");
                stringBuilder.append(c0740d.f9831c);
                stringBuilder.append(": fragment ");
                stringBuilder.append(c0740d.f9830b);
                stringBuilder.append(" was detached.");
                break;
            case FRAGMENT_VISIBILITY_CHANGED:
                stringBuilder.append("In activity ");
                stringBuilder.append(c0740d.f9831c);
                stringBuilder.append(": visibility of fragment ");
                stringBuilder.append(c0740d.f9830b);
                stringBuilder.append(" changed, ");
                stringBuilder.append(c0740d.f9835g);
                stringBuilder.append(".");
                break;
            default:
                break;
        }
        return stringBuilder.toString();
    }
}
