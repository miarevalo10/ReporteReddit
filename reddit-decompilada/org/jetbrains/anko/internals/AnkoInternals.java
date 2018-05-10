package org.jetbrains.anko.internals;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewManager;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.AnkoContext;
import org.jetbrains.anko.AnkoContextImpl;
import org.jetbrains.anko.AnkoException;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002UVB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0005\u001a\u00020\u0006\"\b\b\u0000\u0010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u0002H\u0007¢\u0006\u0002\u0010\fJ%\u0010\u0005\u001a\u00020\u0006\"\b\b\u0000\u0010\u0007*\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u0002H\u0007¢\u0006\u0002\u0010\u000fJ%\u0010\u0005\u001a\u00020\u0006\"\b\b\u0000\u0010\u0007*\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u0002H\u0007¢\u0006\u0002\u0010\u0012J\"\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\b2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u0016JI\u0010\u0017\u001a\u00020\u0018\"\u0004\b\u0000\u0010\u00072\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00070\u001a2\u001c\u0010\u001b\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001d0\u001cH\u0007¢\u0006\u0002\u0010\u001eJ3\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00182\u001c\u0010\u001b\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001d0\u001cH\u0003¢\u0006\u0002\u0010!J\u000e\u0010\"\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011J-\u0010#\u001a\u0002H\u0007\"\b\b\u0000\u0010\u0007*\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H\u00070\u001aH\u0007¢\u0006\u0002\u0010%JC\u0010&\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\u001a2\u001c\u0010\u001b\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001d0\u001cH\u0007¢\u0006\u0002\u0010'JK\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\n2\u000e\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\u001a2\u0006\u0010*\u001a\u00020+2\u001c\u0010\u001b\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001d0\u001cH\u0007¢\u0006\u0002\u0010,JE\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010/\u001a\n\u0012\u0006\b\u0001\u0012\u0002000\u001a2\u001c\u0010\u001b\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001d0\u001cH\u0007¢\u0006\u0002\u00101JC\u00102\u001a\u0002032\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010/\u001a\n\u0012\u0006\b\u0001\u0012\u0002000\u001a2\u001c\u0010\u001b\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001d0\u001cH\u0007¢\u0006\u0002\u00104J\u0006\u00105\u001a\u000206J\u0001\u00107\u001a\u0002032\u0006\u0010\r\u001a\u00020\u000e2\b\u00108\u001a\u0004\u0018\u0001092\u000e\u0010:\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010;2\b\u0010<\u001a\u0004\u0018\u00010\u00042\b\u0010=\u001a\u0004\u0018\u00010>2\b\u0010?\u001a\u0004\u0018\u0001032\b\u0010@\u001a\u0004\u0018\u00010+2\b\u0010A\u001a\u0004\u0018\u00010+2\b\u0010B\u001a\u0004\u0018\u00010C2\b\u0010D\u001a\u0004\u0018\u0001032\b\u0010E\u001a\u0004\u0018\u0001032\b\u0010F\u001a\u0004\u0018\u00010+H\u0007¢\u0006\u0002\u0010GJ0\u0010H\u001a\u0002H\u0007\"\u0004\b\u0000\u0010\u00072\u0006\u0010I\u001a\u00020J2\u0012\u0010K\u001a\u000e\u0012\u0004\u0012\u00020J\u0012\u0004\u0012\u0002H\u00070\u0016H\b¢\u0006\u0002\u0010LJ\u0016\u0010M\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010N\u001a\u00020+JO\u0010O\u001a\b\u0012\u0004\u0012\u0002H\u00070P\"\u0004\b\u0000\u0010\u0007*\u0002H\u00072\u0006\u0010\r\u001a\u00020\u000e2\u001d\u0010Q\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070P\u0012\u0004\u0012\u00020\u00060\u0016¢\u0006\u0002\bR2\b\b\u0002\u0010S\u001a\u000203H\b¢\u0006\u0002\u0010TR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006W"}, d2 = {"Lorg/jetbrains/anko/internals/AnkoInternals;", "", "()V", "NO_GETTER", "", "addView", "", "T", "Landroid/view/View;", "activity", "Landroid/app/Activity;", "view", "(Landroid/app/Activity;Landroid/view/View;)V", "ctx", "Landroid/content/Context;", "(Landroid/content/Context;Landroid/view/View;)V", "manager", "Landroid/view/ViewManager;", "(Landroid/view/ViewManager;Landroid/view/View;)V", "applyRecursively", "v", "style", "Lkotlin/Function1;", "createIntent", "Landroid/content/Intent;", "clazz", "Ljava/lang/Class;", "params", "", "Lkotlin/Pair;", "(Landroid/content/Context;Ljava/lang/Class;[Lkotlin/Pair;)Landroid/content/Intent;", "fillIntentArguments", "intent", "(Landroid/content/Intent;[Lkotlin/Pair;)V", "getContext", "initiateView", "viewClass", "(Landroid/content/Context;Ljava/lang/Class;)Landroid/view/View;", "internalStartActivity", "(Landroid/content/Context;Ljava/lang/Class;[Lkotlin/Pair;)V", "internalStartActivityForResult", "act", "requestCode", "", "(Landroid/app/Activity;Ljava/lang/Class;I[Lkotlin/Pair;)V", "internalStartService", "Landroid/content/ComponentName;", "service", "Landroid/app/Service;", "(Landroid/content/Context;Ljava/lang/Class;[Lkotlin/Pair;)Landroid/content/ComponentName;", "internalStopService", "", "(Landroid/content/Context;Ljava/lang/Class;[Lkotlin/Pair;)Z", "noGetter", "", "testConfiguration", "screenSize", "Lorg/jetbrains/anko/ScreenSize;", "density", "Lkotlin/ranges/ClosedRange;", "language", "orientation", "Lorg/jetbrains/anko/Orientation;", "long", "fromSdk", "sdk", "uiMode", "Lorg/jetbrains/anko/UiMode;", "nightMode", "rightToLeft", "smallestWidth", "(Landroid/content/Context;Lorg/jetbrains/anko/ScreenSize;Lkotlin/ranges/ClosedRange;Ljava/lang/String;Lorg/jetbrains/anko/Orientation;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Lorg/jetbrains/anko/UiMode;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;)Z", "useCursor", "cursor", "Landroid/database/Cursor;", "f", "(Landroid/database/Cursor;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "wrapContextIfNeeded", "theme", "createAnkoContext", "Lorg/jetbrains/anko/AnkoContext;", "init", "Lkotlin/ExtensionFunctionType;", "setContentView", "(Ljava/lang/Object;Landroid/content/Context;Lkotlin/jvm/functions/Function1;Z)Lorg/jetbrains/anko/AnkoContext;", "AnkoContextThemeWrapper", "InternalConfiguration", "commons_release"}, k = 1, mv = {1, 1, 5})
/* compiled from: Internals.kt */
public final class AnkoInternals {
    public static final AnkoInternals f26942a = null;

    public static Context m28419a(Context context) {
        Intrinsics.m26847b(context, "ctx");
        return context;
    }

    static {
        AnkoInternals ankoInternals = new AnkoInternals();
    }

    private AnkoInternals() {
        f26942a = this;
    }

    public static <T extends View> void m28424a(ViewManager viewManager, T t) {
        Intrinsics.m26847b(viewManager, "manager");
        Intrinsics.m26847b(t, "view");
        if (viewManager instanceof ViewGroup) {
            ((ViewGroup) viewManager).addView(t);
        } else if (viewManager instanceof AnkoContext) {
            viewManager.addView(t, null);
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(viewManager);
            stringBuilder.append(" is the wrong parent");
            throw ((Throwable) new AnkoException(stringBuilder.toString()));
        }
    }

    public static Context m28420a(ViewManager viewManager) {
        Intrinsics.m26847b(viewManager, "manager");
        if (viewManager instanceof ViewGroup) {
            Object context = ((ViewGroup) viewManager).getContext();
            Intrinsics.m26843a(context, "manager.context");
            return context;
        } else if (viewManager instanceof AnkoContext) {
            return ((AnkoContext) viewManager).mo6314a();
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(viewManager);
            stringBuilder.append(" is the wrong parent");
            throw new AnkoException(stringBuilder.toString());
        }
    }

    public static final void m28422a(Context context, Class<? extends Activity> cls, Pair<String, ? extends Object>[] pairArr) {
        Intrinsics.m26847b(context, "ctx");
        Intrinsics.m26847b(cls, "activity");
        Intrinsics.m26847b(pairArr, "params");
        Intrinsics.m26847b(context, "ctx");
        Intrinsics.m26847b(cls, "clazz");
        Intrinsics.m26847b(pairArr, "params");
        Intent intent = new Intent(context, cls);
        if (((((Object[]) pairArr).length == null ? 1 : null) ^ 1) != null) {
            m28423a(intent, (Pair[]) pairArr);
        }
        context.startActivity(intent);
    }

    private static final void m28423a(Intent intent, Pair<String, ? extends Object>[] pairArr) {
        Object[] objArr = (Object[]) pairArr;
        for (Object obj : objArr) {
            Pair pair = (Pair) obj;
            Object obj2 = pair.f25268b;
            if (Intrinsics.m26845a(obj2, null)) {
                intent.putExtra((String) pair.f25267a, null);
            } else if (obj2 instanceof Integer) {
                intent.putExtra((String) pair.f25267a, ((Number) obj2).intValue());
            } else if (obj2 instanceof Long) {
                intent.putExtra((String) pair.f25267a, ((Number) obj2).longValue());
            } else if (obj2 instanceof CharSequence) {
                intent.putExtra((String) pair.f25267a, (CharSequence) obj2);
            } else if (obj2 instanceof String) {
                intent.putExtra((String) pair.f25267a, (String) obj2);
            } else if (obj2 instanceof Float) {
                intent.putExtra((String) pair.f25267a, ((Number) obj2).floatValue());
            } else if (obj2 instanceof Double) {
                intent.putExtra((String) pair.f25267a, ((Number) obj2).doubleValue());
            } else if (obj2 instanceof Character) {
                intent.putExtra((String) pair.f25267a, ((Character) obj2).charValue());
            } else if (obj2 instanceof Short) {
                intent.putExtra((String) pair.f25267a, ((Number) obj2).shortValue());
            } else if (obj2 instanceof Boolean) {
                intent.putExtra((String) pair.f25267a, ((Boolean) obj2).booleanValue());
            } else if (obj2 instanceof Serializable) {
                intent.putExtra((String) pair.f25267a, (Serializable) obj2);
            } else if (obj2 instanceof Bundle) {
                intent.putExtra((String) pair.f25267a, (Bundle) obj2);
            } else if (obj2 instanceof Parcelable) {
                intent.putExtra((String) pair.f25267a, (Parcelable) obj2);
            } else if (obj2 instanceof Object[]) {
                Object[] objArr2 = (Object[]) obj2;
                if (objArr2 instanceof CharSequence[]) {
                    intent.putExtra((String) pair.f25267a, (Serializable) obj2);
                } else if (objArr2 instanceof String[]) {
                    intent.putExtra((String) pair.f25267a, (Serializable) obj2);
                } else if (objArr2 instanceof Parcelable[]) {
                    intent.putExtra((String) pair.f25267a, (Serializable) obj2);
                } else {
                    pairArr = new StringBuilder("Intent extra ");
                    pairArr.append((String) pair.f25267a);
                    pairArr.append(" has wrong type ");
                    pairArr.append(objArr2.getClass().getName());
                    throw ((Throwable) new AnkoException(pairArr.toString()));
                }
            } else if (obj2 instanceof int[]) {
                intent.putExtra((String) pair.f25267a, (int[]) obj2);
            } else if (obj2 instanceof long[]) {
                intent.putExtra((String) pair.f25267a, (long[]) obj2);
            } else if (obj2 instanceof float[]) {
                intent.putExtra((String) pair.f25267a, (float[]) obj2);
            } else if (obj2 instanceof double[]) {
                intent.putExtra((String) pair.f25267a, (double[]) obj2);
            } else if (obj2 instanceof char[]) {
                intent.putExtra((String) pair.f25267a, (char[]) obj2);
            } else if (obj2 instanceof short[]) {
                intent.putExtra((String) pair.f25267a, (short[]) obj2);
            } else if (obj2 instanceof boolean[]) {
                intent.putExtra((String) pair.f25267a, (boolean[]) obj2);
            } else {
                pairArr = new StringBuilder("Intent extra ");
                pairArr.append((String) pair.f25267a);
                pairArr.append(" has wrong type ");
                pairArr.append(obj2.getClass().getName());
                throw ((Throwable) new AnkoException(pairArr.toString()));
            }
        }
    }

    public static <T extends View> void m28421a(Context context, T t) {
        Intrinsics.m26847b(context, "ctx");
        Intrinsics.m26847b(t, "view");
        m28424a((ViewManager) new AnkoContextImpl(context, context), (View) t);
    }
}
