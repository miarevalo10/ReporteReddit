package com.reddit.frontpage;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import androidx.animation.AnimatorKt;
import androidx.content.res.TypedArrayKt;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import com.reddit.frontpage.presentation.theme.ThemeOption;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010*\u001a\u00020\u0010H\u0014J\u0012\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0014J\u0012\u0010/\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0014J\b\u00100\u001a\u00020,H\u0014J\b\u00101\u001a\u00020,H\u0014J\u001f\u00102\u001a\u00020,2\b\u00103\u001a\u0004\u0018\u00010\b2\b\b\u0002\u00104\u001a\u00020\u0010¢\u0006\u0002\u00105J\u000e\u00106\u001a\u00020,2\u0006\u00107\u001a\u00020\u0010R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R+\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8D@DX\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR+\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u00108D@DX\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\u001fR\u0011\u0010 \u001a\u00020\u00108G¢\u0006\u0006\u001a\u0004\b!\u0010\u0012R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020\u00108DX\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u0012¨\u00068"}, d2 = {"Lcom/reddit/frontpage/RedditThemedActivity;", "Landroid/support/v7/app/AppCompatActivity;", "()V", "currentTheme", "Lcom/reddit/frontpage/presentation/theme/ThemeOption;", "getCurrentTheme", "()Lcom/reddit/frontpage/presentation/theme/ThemeOption;", "<set-?>", "", "defaultStatusBarColor", "getDefaultStatusBarColor", "()I", "setDefaultStatusBarColor", "(I)V", "defaultStatusBarColor$delegate", "Lkotlin/properties/ReadWriteProperty;", "", "isDefaultStatusBarLight", "()Z", "setDefaultStatusBarLight", "(Z)V", "isDefaultStatusBarLight$delegate", "lastSetStatusBarColor", "getLastSetStatusBarColor", "()Ljava/lang/Integer;", "setLastSetStatusBarColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "lastSetTheme", "getLastSetTheme", "setLastSetTheme", "(Lcom/reddit/frontpage/presentation/theme/ThemeOption;)V", "shouldColorSystemBars", "getShouldColorSystemBars", "statusBarColorAnimator", "Landroid/animation/Animator;", "getStatusBarColorAnimator", "()Landroid/animation/Animator;", "setStatusBarColorAnimator", "(Landroid/animation/Animator;)V", "useAutoNight", "getUseAutoNight", "hasStaticTheme", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onPostCreate", "onResume", "onStop", "setStatusBarColor", "color", "animate", "(Ljava/lang/Integer;Z)V", "updateTheme", "recreateIfChanged", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RedditThemedActivity.kt */
public abstract class RedditThemedActivity extends AppCompatActivity {
    static final /* synthetic */ KProperty[] f40546e = new KProperty[]{Reflection.m26854a(new MutablePropertyReference1Impl(Reflection.m26850a(RedditThemedActivity.class), "defaultStatusBarColor", "getDefaultStatusBarColor()I")), Reflection.m26854a(new MutablePropertyReference1Impl(Reflection.m26850a(RedditThemedActivity.class), "isDefaultStatusBarLight", "isDefaultStatusBarLight()Z"))};
    private final ReadWriteProperty f40547a = Delegates.m26877a();
    private final ReadWriteProperty f40548b;
    private Integer f40549c;
    private HashMap f40550d;
    public ThemeOption f40551f;
    Animator f40552g;

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] f19888a;

        static {
            int[] iArr = new int[ThemeOption.values().length];
            f19888a = iArr;
            iArr[ThemeOption.f20981c.ordinal()] = 1;
            f19888a[ThemeOption.f20980b.ordinal()] = 2;
            f19888a[ThemeOption.f20982d.ordinal()] = 3;
            f19888a[ThemeOption.f20983e.ordinal()] = 4;
            f19888a[ThemeOption.f20984f.ordinal()] = 5;
        }
    }

    private boolean mo7724d() {
        return ((Boolean) this.f40548b.getValue(this, f40546e[1])).booleanValue();
    }

    public View mo7727a(int i) {
        if (this.f40550d == null) {
            this.f40550d = new HashMap();
        }
        View view = (View) this.f40550d.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        view = findViewById(i);
        this.f40550d.put(Integer.valueOf(i), view);
        return view;
    }

    protected boolean mo7780i() {
        return false;
    }

    public RedditThemedActivity() {
        Delegates delegates = Delegates.f25296a;
        delegates = Delegates.f25296a;
        this.f40548b = Delegates.m26877a();
    }

    public void onCreate(Bundle bundle) {
        m41959b(false);
        int i = 1;
        Object obtainStyledAttributes = obtainStyledAttributes(new int[]{C1761R.attr.isDarkTheme});
        Intrinsics.m26843a(obtainStyledAttributes, "obtainStyledAttributes(i…ayOf(R.attr.isDarkTheme))");
        boolean a = TypedArrayKt.a(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        AppCompatDelegate c = c();
        if (a) {
            i = 2;
        }
        c.d(i);
        super.onCreate(bundle);
    }

    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        if (m41961k() != null) {
            m41956a((Integer) null, false);
            bundle = getWindow().peekDecorView();
            if (bundle != null) {
                boolean d = mo7724d();
                int systemUiVisibility = bundle.getSystemUiVisibility();
                bundle.setSystemUiVisibility(d ? systemUiVisibility | 16 : systemUiVisibility & -17);
            }
        }
    }

    public final void m41959b(boolean z) {
        if (!mo7780i()) {
            FrontpageSettings a = FrontpageSettings.a();
            boolean d = a.d();
            Object c = a.c(true);
            if (d && c != ThemeOption.f20981c) {
                Timber.d("App Theme: Discrepancy found legacy nightMode = %s but theme = %s", new Object[]{Boolean.valueOf(d), c});
                a.b(false);
            } else if (!d && c == ThemeOption.f20981c) {
                Timber.d("App Theme: Discrepancy found legacy nightMode = %s but theme = %s", new Object[]{Boolean.valueOf(d), c});
                a.b(true);
            }
            if ((Intrinsics.m26845a(c, this.f40551f) ^ 1) != 0) {
                if (z) {
                    recreate();
                } else {
                    Timber.b("App Theme: %s loaded", new Object[]{c.name()});
                    this.f40551f = c;
                    if (c != null) {
                        switch (WhenMappings.f19888a[c.ordinal()]) {
                            case true:
                                z = true;
                                break;
                            case true:
                                z = true;
                                break;
                            case true:
                                z = true;
                                break;
                            case true:
                                z = true;
                                break;
                            case true:
                                z = true;
                                break;
                            default:
                                break;
                        }
                    }
                    z = true;
                    setTheme(z);
                }
            }
            z = false;
            if (z && m41961k()) {
                this.f40547a.setValue(this, f40546e[0], Integer.valueOf(ResourcesUtil.m22740i(this, 16843857)));
                Object obtainStyledAttributes = obtainStyledAttributes(new int[]{C1761R.attr.isDarkTheme});
                Intrinsics.m26843a(obtainStyledAttributes, "obtainStyledAttributes(i…ayOf(R.attr.isDarkTheme))");
                boolean a2 = TypedArrayKt.a(obtainStyledAttributes) ^ true;
                obtainStyledAttributes.recycle();
                this.f40548b.setValue(this, f40546e[1], Boolean.valueOf(a2));
                return;
            }
        }
        z = true;
        if (z) {
        }
    }

    private void m41956a(Integer num, boolean z) {
        if (m41961k()) {
            int intValue;
            int i = 0;
            if (num != null) {
                intValue = num.intValue();
            } else {
                intValue = ((Number) this.f40547a.getValue(this, f40546e[0])).intValue();
            }
            Integer num2 = this.f40549c;
            if (num2 != null) {
                if (intValue == num2.intValue()) {
                    return;
                }
            }
            Animator animator = this.f40552g;
            if (animator != null) {
                animator.cancel();
            }
            if (z) {
                Function1 function1 = (Function1) new RedditThemedActivity$setStatusBarColor$onAnimationFinished$1(this);
                int[] iArr = new int[2];
                Object window = getWindow();
                Intrinsics.m26843a(window, "window");
                iArr[0] = window.getStatusBarColor();
                iArr[1] = intValue;
                ValueAnimator ofArgb = ValueAnimator.ofArgb(iArr);
                ofArgb.setDuration((long) getResources().getInteger(17694720));
                Animator animator2 = ofArgb;
                AnimatorKt.a(animator2, function1, function1);
                ofArgb.addUpdateListener(new RedditThemedActivity$setStatusBarColor$$inlined$apply$lambda$1(this, function1));
                ofArgb.start();
                this.f40552g = animator2;
            } else {
                Object window2 = getWindow();
                Intrinsics.m26843a(window2, "window");
                window2.setStatusBarColor(intValue);
            }
            this.f40549c = Integer.valueOf(intValue);
            z = getWindow().peekDecorView();
            if (num == null && mo7724d() != null) {
                i = 1;
            }
            num = z.getSystemUiVisibility();
            z.setSystemUiVisibility(i != 0 ? num | 8192 : num & -8193);
        }
    }

    protected void onResume() {
        RedditThemedActivity redditThemedActivity = this;
        Object resources = getResources();
        Intrinsics.m26843a(resources, "resources");
        int i = resources.getConfiguration().uiMode & 48;
        Object obtainStyledAttributes = obtainStyledAttributes(new int[]{C1761R.attr.isDarkTheme});
        Intrinsics.m26843a(obtainStyledAttributes, "obtainStyledAttributes(i…ayOf(R.attr.isDarkTheme))");
        boolean a = TypedArrayKt.a(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        int i2 = a ? 32 : 16;
        if (i != i2) {
            Object resources2 = getResources();
            Intrinsics.m26843a(resources2, "resources");
            Configuration configuration = new Configuration(resources2.getConfiguration());
            configuration.uiMode = i2 | (configuration.uiMode & -49);
            Resources resources3 = getResources();
            Object resources4 = getResources();
            Intrinsics.m26843a(resources4, "resources");
            resources3.updateConfiguration(configuration, resources4.getDisplayMetrics());
        }
        super.onResume();
        if (FrontpageSettings.a().e()) {
            m41959b(true);
        }
    }

    protected void onStop() {
        Animator animator = this.f40552g;
        if (animator != null) {
            animator.end();
        }
        super.onStop();
    }

    @SuppressLint({"ResourceType"})
    public final boolean m41961k() {
        if (getResources().getBoolean(C1761R.bool.color_system_bars)) {
            Object obtainStyledAttributes = obtainStyledAttributes(new int[]{16843857, 16843858});
            Intrinsics.m26843a(obtainStyledAttributes, "obtainStyledAttributes(i…vigationBarColor\n      ))");
            boolean z = obtainStyledAttributes.hasValue(0) && obtainStyledAttributes.hasValue(1);
            obtainStyledAttributes.recycle();
            if (z) {
                return true;
            }
        }
        return false;
    }
}
