package com.reddit.frontpage.redditauth_private.ui;

import android.content.Context;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.evernote.android.state.State;
import com.jakewharton.rxbinding2.widget.RxTextView;
import com.livefront.bridge.Bridge;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.events.v1.BaseEvent;
import com.reddit.frontpage.commons.analytics.events.v1.ScreenViewEvent;
import com.reddit.frontpage.commons.ui.BaseFragment;
import com.reddit.frontpage.redditauth_private.ui.AuthActivity.NavigationListener;
import com.reddit.frontpage.util.SchedulerProvider;
import com.reddit.frontpage.util.kotlin.KtTextWatcher;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.SubscribersKt;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.Regex;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000]\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f*\u0001\u000f\u0018\u0000 42\u00020\u0001:\u000245B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\nH\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\u0010\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\u0010\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u001cH\u0002J\u0010\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020#H\u0016J&\u0010$\u001a\u0004\u0018\u00010\u00172\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u0010+\u001a\u00020\u0019H\u0016J\u0010\u0010,\u001a\u00020\u00192\u0006\u0010-\u001a\u00020*H\u0016J\u001a\u0010.\u001a\u00020\u00192\u0006\u0010/\u001a\u00020\u00172\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u00100\u001a\u00020\u0019H\u0002J\b\u00101\u001a\u00020\u0019H\u0002J\b\u00102\u001a\u00020\u0019H\u0002J\b\u00103\u001a\u00020\u0019H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\b\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/reddit/frontpage/redditauth_private/ui/AuthenticatorFragment;", "Lcom/reddit/frontpage/commons/ui/BaseFragment;", "()V", "authActivity", "Lcom/reddit/frontpage/redditauth_private/ui/AuthActivity;", "getAuthActivity", "()Lcom/reddit/frontpage/redditauth_private/ui/AuthActivity;", "authActivity$delegate", "Lkotlin/Lazy;", "isBackup", "", "()Z", "setBackup", "(Z)V", "navigationListener", "com/reddit/frontpage/redditauth_private/ui/AuthenticatorFragment$navigationListener$1", "Lcom/reddit/frontpage/redditauth_private/ui/AuthenticatorFragment$navigationListener$1;", "onLoginListener", "Lcom/reddit/frontpage/redditauth_private/ui/LoginFragment$OnLoginListener;", "getOnLoginListener", "()Lcom/reddit/frontpage/redditauth_private/ui/LoginFragment$OnLoginListener;", "onLoginListener$delegate", "rootView", "Landroid/view/View;", "enableConfirmButton", "", "enable", "formatCode", "", "rawCode", "isValid", "login", "otpCode", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDetach", "onSaveInstanceState", "outState", "onViewCreated", "view", "processAuthCode", "setupAuthUI", "setupBackupUI", "toggleBackupAuth", "Companion", "ThreeDigitCodeFormatWatcher", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: AuthenticatorFragment.kt */
public final class AuthenticatorFragment extends BaseFragment {
    static final /* synthetic */ KProperty[] f37124a = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(AuthenticatorFragment.class), "onLoginListener", "getOnLoginListener()Lcom/reddit/frontpage/redditauth_private/ui/LoginFragment$OnLoginListener;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(AuthenticatorFragment.class), "authActivity", "getAuthActivity()Lcom/reddit/frontpage/redditauth_private/ui/AuthActivity;"))};
    public static final Companion f37125b = new Companion();
    private static final String f37126g = "com.reddit.arg.username";
    private static final String f37127h = "com.reddit.arg.password";
    private static final String f37128i = "second_factor_backup_code";
    private static final String f37129j = "second_factor_authenticator_app";
    private static final String f37130k = "second_factor_use_backup_code";
    private static final String f37131l = "second_factor_use_authenticator";
    private final Lazy f37132c = LazyKt.m26777a(new AuthenticatorFragment$onLoginListener$2(this));
    private final Lazy f37133d = LazyKt.m26777a(new AuthenticatorFragment$authActivity$2(this));
    private View f37134e;
    private final AuthenticatorFragment$navigationListener$1 f37135f = new AuthenticatorFragment$navigationListener$1(this);
    @State
    boolean isBackup;
    private HashMap f37136m;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004H\u0007R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/reddit/frontpage/redditauth_private/ui/AuthenticatorFragment$Companion;", "", "()V", "ARG_PASSWORD", "", "getARG_PASSWORD", "()Ljava/lang/String;", "ARG_USERNAME", "getARG_USERNAME", "CONTROL_NAME_AUTH", "getCONTROL_NAME_AUTH", "CONTROL_NAME_BACKUP", "getCONTROL_NAME_BACKUP", "SCREEN_NAME_AUTH", "getSCREEN_NAME_AUTH", "SCREEN_NAME_BACKUP", "getSCREEN_NAME_BACKUP", "newInstance", "Lcom/reddit/frontpage/redditauth_private/ui/AuthenticatorFragment;", "username", "password", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: AuthenticatorFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public static AuthenticatorFragment m23233a(String str, String str2) {
            Intrinsics.m26847b(str, "username");
            Intrinsics.m26847b(str2, "password");
            AuthenticatorFragment authenticatorFragment = new AuthenticatorFragment();
            Bundle bundle = new Bundle();
            Companion companion = AuthenticatorFragment.f37125b;
            bundle.putString(AuthenticatorFragment.f37126g, str);
            str = AuthenticatorFragment.f37125b;
            bundle.putString(AuthenticatorFragment.f37127h, str2);
            authenticatorFragment.setArguments(bundle);
            return authenticatorFragment;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J(\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002¨\u0006\u0015"}, d2 = {"Lcom/reddit/frontpage/redditauth_private/ui/AuthenticatorFragment$ThreeDigitCodeFormatWatcher;", "Lcom/reddit/frontpage/util/kotlin/KtTextWatcher;", "()V", "afterTextChanged", "", "editable", "Landroid/text/Editable;", "buildCorrectString", "", "digits", "", "dividerPosition", "", "divider", "", "isInputCorrect", "", "text", "totalSymbols", "dividerModulo", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: AuthenticatorFragment.kt */
    private static final class ThreeDigitCodeFormatWatcher implements KtTextWatcher {
        public static final Companion f28834a = new Companion();
        private static final int f28835b = 7;
        private static final int f28836c = 4;
        private static final int f28837d = (f28836c - 1);
        private static final char f28838e = ' ';

        @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/reddit/frontpage/redditauth_private/ui/AuthenticatorFragment$ThreeDigitCodeFormatWatcher$Companion;", "", "()V", "DIVIDER", "", "getDIVIDER", "()C", "DIVIDER_MODULO", "", "getDIVIDER_MODULO", "()I", "DIVIDER_POSITION", "getDIVIDER_POSITION", "TOTAL_SYMBOLS", "getTOTAL_SYMBOLS", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
        /* compiled from: AuthenticatorFragment.kt */
        public static final class Companion {
            private Companion() {
            }
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void afterTextChanged(android.text.Editable r9) {
            /*
            r8 = this;
            r0 = "editable";
            kotlin.jvm.internal.Intrinsics.m26847b(r9, r0);
            r0 = f28835b;
            r1 = f28836c;
            r2 = f28838e;
            r3 = r9.length();
            r4 = 0;
            r5 = 1;
            if (r3 > r0) goto L_0x001b;
        L_0x0019:
            r0 = r5;
            goto L_0x001c;
        L_0x001b:
            r0 = r4;
        L_0x001c:
            r3 = r9.length();
            r3 = r3 - r5;
            if (r3 < 0) goto L_0x004b;
        L_0x0023:
            r6 = r4;
        L_0x0024:
            if (r0 == 0) goto L_0x004b;
        L_0x0026:
            if (r6 <= 0) goto L_0x0039;
        L_0x0028:
            r7 = r6 + 1;
            r7 = r7 % r1;
            if (r7 != 0) goto L_0x0039;
        L_0x002d:
            if (r0 == 0) goto L_0x0037;
        L_0x002f:
            r0 = r9.charAt(r6);
            if (r2 != r0) goto L_0x0037;
        L_0x0035:
            r0 = r5;
            goto L_0x0046;
        L_0x0037:
            r0 = r4;
            goto L_0x0046;
        L_0x0039:
            if (r0 == 0) goto L_0x0037;
        L_0x003b:
            r0 = r9.charAt(r6);
            r0 = java.lang.Character.isDigit(r0);
            if (r0 == 0) goto L_0x0037;
        L_0x0045:
            goto L_0x0035;
        L_0x0046:
            if (r6 == r3) goto L_0x004b;
        L_0x0048:
            r6 = r6 + 1;
            goto L_0x0024;
        L_0x004b:
            if (r0 != 0) goto L_0x0085;
        L_0x004d:
            r0 = r9.length();
            r1 = r9;
            r1 = (java.lang.CharSequence) r1;
            r2 = new java.lang.StringBuilder;
            r2.<init>();
            r2 = (java.lang.Appendable) r2;
            r3 = r1.length();
            r5 = r4;
        L_0x0060:
            if (r5 >= r3) goto L_0x0072;
        L_0x0062:
            r6 = r1.charAt(r5);
            r7 = java.lang.Character.isDigit(r6);
            if (r7 == 0) goto L_0x006f;
        L_0x006c:
            r2.append(r6);
        L_0x006f:
            r5 = r5 + 1;
            goto L_0x0060;
        L_0x0072:
            r2 = (java.lang.CharSequence) r2;
            r1 = f28837d;
            r3 = f28838e;
            r1 = m29907a(r2, r1, r3);
            r1 = (java.lang.CharSequence) r1;
            r9.replace(r4, r0, r1);
        L_0x0085:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.reddit.frontpage.redditauth_private.ui.AuthenticatorFragment.ThreeDigitCodeFormatWatcher.afterTextChanged(android.text.Editable):void");
        }

        private static String m29907a(CharSequence charSequence, int i, char c) {
            StringBuilder stringBuilder = new StringBuilder();
            int i2 = 0;
            int i3 = 0;
            while (i2 < charSequence.length()) {
                int i4 = i3 + 1;
                stringBuilder.append(charSequence.charAt(i2));
                if (i3 > 0 && i3 < charSequence.length() - 1 && i4 % i == 0) {
                    stringBuilder.append(c);
                }
                i2++;
                i3 = i4;
            }
            Object stringBuilder2 = stringBuilder.toString();
            Intrinsics.m26843a(stringBuilder2, "formatted.toString()");
            return stringBuilder2;
        }
    }

    public static final AuthenticatorFragment m37477a(String str, String str2) {
        return Companion.m23233a(str, str2);
    }

    private final AuthActivity m37489g() {
        return (AuthActivity) this.f37133d.mo5678b();
    }

    public final View m37492a(int i) {
        if (this.f37136m == null) {
            this.f37136m = new HashMap();
        }
        View view = (View) this.f37136m.get(Integer.valueOf(i));
        if (view == null) {
            view = getView();
            if (view == null) {
                return null;
            }
            view = view.findViewById(i);
            this.f37136m.put(Integer.valueOf(i), view);
        }
        return view;
    }

    public final void onAttach(Context context) {
        Intrinsics.m26847b(context, "context");
        super.onAttach(context);
        m37489g().m42737a((NavigationListener) this.f37135f);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.m26847b(layoutInflater, "inflater");
        this.f37134e = layoutInflater.inflate(C1761R.layout.rdt_fragment_authenticator, viewGroup, false);
        Bridge.a(this, bundle);
        return this.f37134e;
    }

    public final void onViewCreated(View view, Bundle bundle) {
        Intrinsics.m26847b(view, "view");
        super.onViewCreated(view, bundle);
        Object obj = (TextView) m37492a(C1761R.id.toggle);
        Intrinsics.m26843a(obj, "toggle");
        ((View) obj).setOnClickListener(new AuthenticatorFragment$inlined$sam$OnClickListener$i$7f478c20((Function1) new AuthenticatorFragment$onViewCreated$1(this)));
        obj = (Button) m37492a(C1761R.id.confirm);
        Intrinsics.m26843a(obj, "confirm");
        ((View) obj).setOnClickListener(new AuthenticatorFragment$inlined$sam$OnClickListener$i$7f478c20((Function1) new AuthenticatorFragment$onViewCreated$2(this)));
        ((EditText) m37492a(C1761R.id.code)).addTextChangedListener((TextWatcher) new ThreeDigitCodeFormatWatcher());
        RxTextView.b((EditText) m37492a(C1761R.id.code)).observeOn(SchedulerProvider.m23887c()).subscribe((Consumer) new AuthenticatorFragment$onViewCreated$3(this));
        if (this.isBackup != null) {
            m37490h();
        } else {
            m37491i();
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        Intrinsics.m26847b(bundle, "outState");
        super.onSaveInstanceState(bundle);
        Bridge.b(this, bundle);
    }

    public final void onDetach() {
        super.onDetach();
        m37489g().mo7724d();
    }

    private final void m37490h() {
        Object obj = (TextView) m37492a(C1761R.id.title);
        Intrinsics.m26843a(obj, "title");
        obj.setText(getString(C1761R.string.auth_backup_title));
        obj = (TextView) m37492a(C1761R.id.toggle);
        Intrinsics.m26843a(obj, "toggle");
        obj.setText(getString(C1761R.string.use_auth_code));
        AppAnalytics.m21852a((BaseEvent) new ScreenViewEvent(f37128i));
    }

    private final void m37491i() {
        Object obj = (TextView) m37492a(C1761R.id.title);
        Intrinsics.m26843a(obj, "title");
        obj.setText(getString(C1761R.string.auth_title));
        obj = (TextView) m37492a(C1761R.id.toggle);
        Intrinsics.m26843a(obj, "toggle");
        obj.setText(getString(C1761R.string.use_backup_code));
        AppAnalytics.m21852a((BaseEvent) new ScreenViewEvent(f37129j));
    }

    private final void m37480a(boolean z) {
        String string = z ? getString(C1761R.string.check_code) : "";
        Object obj = (Button) m37492a(C1761R.id.confirm);
        Intrinsics.m26843a(obj, "confirm");
        obj.setText(string);
        Object obj2 = (Button) m37492a(C1761R.id.confirm);
        Intrinsics.m26843a(obj2, "confirm");
        obj2.setEnabled(z);
        obj2 = (ProgressBar) m37492a(C1761R.id.loader);
        Intrinsics.m26843a(obj2, "loader");
        obj2.setVisibility(z ? true : false);
    }

    public static final /* synthetic */ void m37479a(AuthenticatorFragment authenticatorFragment) {
        Object obj = (EditText) authenticatorFragment.m37492a(C1761R.id.code);
        Intrinsics.m26843a(obj, "code");
        obj.setError(null);
        if (authenticatorFragment.isBackup) {
            AppAnalytics.m21858b().m21824a(f37128i).m21826b(f37131l).m21825a();
            authenticatorFragment.m37491i();
            authenticatorFragment.isBackup = false;
            return;
        }
        AppAnalytics.m21858b().m21824a(f37129j).m21826b(f37130k).m21825a();
        authenticatorFragment.m37490h();
        authenticatorFragment.isBackup = true;
    }

    public static final /* synthetic */ void m37482b(AuthenticatorFragment authenticatorFragment) {
        boolean z;
        Object obj;
        int i;
        Bundle arguments;
        String string;
        Bundle arguments2;
        String string2;
        Single observeOn;
        Object obj2 = (EditText) authenticatorFragment.m37492a(C1761R.id.code);
        Intrinsics.m26843a(obj2, "code");
        String a = new Regex("\\s").m28146a(obj2.getText().toString(), "");
        CharSequence charSequence = a;
        if (charSequence != null) {
            if (charSequence.length() != 0) {
                z = false;
                if (!z) {
                    if (a.length() < 6) {
                        obj = (EditText) authenticatorFragment.m37492a(C1761R.id.code);
                        Intrinsics.m26843a(obj, "code");
                        obj.setError(null);
                        authenticatorFragment.m37480a(false);
                        i = 1;
                        if (i == 0) {
                            if (authenticatorFragment.isBackup) {
                                a = authenticatorFragment.getString(C1761R.string.backup_format, new Object[]{a});
                                Intrinsics.m26843a((Object) a, "getString(R.string.backup_format, rawCode)");
                            }
                            arguments = authenticatorFragment.getArguments();
                            if (arguments == null) {
                                Intrinsics.m26842a();
                            }
                            string = arguments.getString(f37126g);
                            arguments2 = authenticatorFragment.getArguments();
                            if (arguments2 == null) {
                                Intrinsics.m26842a();
                            }
                            string2 = arguments2.getString(f37127h);
                            observeOn = Single.fromCallable(new AuthenticatorFragment$login$1(authenticatorFragment, string, string2, a)).subscribeOn(SchedulerProvider.m23886b()).observeOn(SchedulerProvider.m23887c());
                            Intrinsics.m26843a((Object) observeOn, "Single.fromCallable<Cred…n(SchedulerProvider.ui())");
                            SubscribersKt.m26769a(observeOn, (Function1) new AuthenticatorFragment$login$3(authenticatorFragment), (Function1) new AuthenticatorFragment$login$2(authenticatorFragment, string, string2));
                        }
                    }
                }
                obj = (EditText) authenticatorFragment.m37492a(C1761R.id.code);
                Intrinsics.m26843a(obj, "code");
                obj.setError(authenticatorFragment.getString(C1761R.string.error_auth_code_length));
                i = false;
                if (i == 0) {
                    if (authenticatorFragment.isBackup) {
                        a = authenticatorFragment.getString(C1761R.string.backup_format, new Object[]{a});
                        Intrinsics.m26843a((Object) a, "getString(R.string.backup_format, rawCode)");
                    }
                    arguments = authenticatorFragment.getArguments();
                    if (arguments == null) {
                        Intrinsics.m26842a();
                    }
                    string = arguments.getString(f37126g);
                    arguments2 = authenticatorFragment.getArguments();
                    if (arguments2 == null) {
                        Intrinsics.m26842a();
                    }
                    string2 = arguments2.getString(f37127h);
                    observeOn = Single.fromCallable(new AuthenticatorFragment$login$1(authenticatorFragment, string, string2, a)).subscribeOn(SchedulerProvider.m23886b()).observeOn(SchedulerProvider.m23887c());
                    Intrinsics.m26843a((Object) observeOn, "Single.fromCallable<Cred…n(SchedulerProvider.ui())");
                    SubscribersKt.m26769a(observeOn, (Function1) new AuthenticatorFragment$login$3(authenticatorFragment), (Function1) new AuthenticatorFragment$login$2(authenticatorFragment, string, string2));
                }
            }
        }
        z = true;
        if (z) {
            if (a.length() < 6) {
                obj = (EditText) authenticatorFragment.m37492a(C1761R.id.code);
                Intrinsics.m26843a(obj, "code");
                obj.setError(null);
                authenticatorFragment.m37480a(false);
                i = 1;
                if (i == 0) {
                    if (authenticatorFragment.isBackup) {
                        a = authenticatorFragment.getString(C1761R.string.backup_format, new Object[]{a});
                        Intrinsics.m26843a((Object) a, "getString(R.string.backup_format, rawCode)");
                    }
                    arguments = authenticatorFragment.getArguments();
                    if (arguments == null) {
                        Intrinsics.m26842a();
                    }
                    string = arguments.getString(f37126g);
                    arguments2 = authenticatorFragment.getArguments();
                    if (arguments2 == null) {
                        Intrinsics.m26842a();
                    }
                    string2 = arguments2.getString(f37127h);
                    observeOn = Single.fromCallable(new AuthenticatorFragment$login$1(authenticatorFragment, string, string2, a)).subscribeOn(SchedulerProvider.m23886b()).observeOn(SchedulerProvider.m23887c());
                    Intrinsics.m26843a((Object) observeOn, "Single.fromCallable<Cred…n(SchedulerProvider.ui())");
                    SubscribersKt.m26769a(observeOn, (Function1) new AuthenticatorFragment$login$3(authenticatorFragment), (Function1) new AuthenticatorFragment$login$2(authenticatorFragment, string, string2));
                }
            }
        }
        obj = (EditText) authenticatorFragment.m37492a(C1761R.id.code);
        Intrinsics.m26843a(obj, "code");
        obj.setError(authenticatorFragment.getString(C1761R.string.error_auth_code_length));
        i = false;
        if (i == 0) {
            if (authenticatorFragment.isBackup) {
                a = authenticatorFragment.getString(C1761R.string.backup_format, new Object[]{a});
                Intrinsics.m26843a((Object) a, "getString(R.string.backup_format, rawCode)");
            }
            arguments = authenticatorFragment.getArguments();
            if (arguments == null) {
                Intrinsics.m26842a();
            }
            string = arguments.getString(f37126g);
            arguments2 = authenticatorFragment.getArguments();
            if (arguments2 == null) {
                Intrinsics.m26842a();
            }
            string2 = arguments2.getString(f37127h);
            observeOn = Single.fromCallable(new AuthenticatorFragment$login$1(authenticatorFragment, string, string2, a)).subscribeOn(SchedulerProvider.m23886b()).observeOn(SchedulerProvider.m23887c());
            Intrinsics.m26843a((Object) observeOn, "Single.fromCallable<Cred…n(SchedulerProvider.ui())");
            SubscribersKt.m26769a(observeOn, (Function1) new AuthenticatorFragment$login$3(authenticatorFragment), (Function1) new AuthenticatorFragment$login$2(authenticatorFragment, string, string2));
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        if (this.f37136m != null) {
            this.f37136m.clear();
        }
    }
}
