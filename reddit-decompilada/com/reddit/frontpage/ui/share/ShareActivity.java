package com.reddit.frontpage.ui.share;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.BaseActivity;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.IntentUtil;
import com.reddit.frontpage.util.ShareType;
import com.reddit.frontpage.util.ShareType.Companion;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.rxkotlin.SubscribersKt;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J!\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0002\b\bH\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\"\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0014J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\u001a\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015¨\u0006\u0016"}, d2 = {"Lcom/reddit/frontpage/ui/share/ShareActivity;", "Lcom/reddit/frontpage/BaseActivity;", "()V", "forwardShareAndFinish", "", "addIntentExtras", "Lkotlin/Function1;", "Landroid/content/Intent;", "Lkotlin/ExtensionFunctionType;", "getLayoutId", "", "onActivityResult", "requestCode", "resultCode", "data", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onShareFailed", "intent", "error", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ShareActivity.kt */
public final class ShareActivity extends BaseActivity {
    private HashMap f40837d;

    public final View mo7727a(int i) {
        if (this.f40837d == null) {
            this.f40837d = new HashMap();
        }
        View view = (View) this.f40837d.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        view = findViewById(i);
        this.f40837d.put(Integer.valueOf(i), view);
        return view;
    }

    public final int mo7724d() {
        return C1761R.layout.activity_start;
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bundle = ShareType.f21798f;
        Object intent = getIntent();
        Intrinsics.m26843a(intent, "intent");
        if (Companion.m23902a(intent) != null) {
            intent = SessionManager.b();
            Intrinsics.m26843a(intent, "SessionManager.getInstance()");
            if (intent.c().isAnonymous() != null) {
                SessionManager.b().a(this, true);
                return;
            }
            if (VERSION.SDK_INT >= 21) {
                intent = getWindow();
                Intrinsics.m26843a(intent, "window");
                intent.setEnterTransition(null);
                intent = getWindow();
                Intrinsics.m26843a(intent, "window");
                intent.setExitTransition(null);
            }
            if (getIntent().hasExtra("android.intent.extra.STREAM") != null) {
                Single observeOn = Single.fromCallable((Callable) new ShareActivity$onCreate$1(this)).subscribeOn(Schedulers.m26771b()).observeOn(AndroidSchedulers.m26509a());
                Intrinsics.m26843a((Object) observeOn, "Single.fromCallable {\n  …dSchedulers.mainThread())");
                SubscribersKt.m26769a(observeOn, (Function1) new ShareActivity$onCreate$2(this), (Function1) new ShareActivity$onCreate$3(this));
                return;
            }
            m42747a((Function1) new ShareActivity$onCreate$4(this));
            return;
        }
        Intent intent2 = getIntent();
        Intrinsics.m26843a((Object) intent2, "intent");
        m42749a(intent2, null);
    }

    private final void m42747a(Function1<? super Intent, Unit> function1) {
        Intent a = IntentUtil.m23751a((Context) this, true);
        Object intent = getIntent();
        Intrinsics.m26843a(intent, "intent");
        a.setAction(intent.getAction());
        intent = getIntent();
        Intrinsics.m26843a(intent, "intent");
        a.setType(intent.getType());
        a.addFlags(33554432);
        function1.mo6492a(a);
        startActivity(a);
        finish();
    }

    protected final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 42 && i2 != -1) {
            finish();
        }
    }

    public final void m42749a(Intent intent, Throwable th) {
        Intrinsics.m26847b(intent, "intent");
        Object makeText = Toast.makeText(this, C1761R.string.error_message_share_to_reddit, 0);
        makeText.show();
        Intrinsics.m26843a(makeText, "Toast\n        .makeText(…         show()\n        }");
        StringBuilder stringBuilder = new StringBuilder("Unable to process share intent. Action=");
        stringBuilder.append(intent.getAction());
        stringBuilder.append(" MimeType=");
        stringBuilder.append(intent.getType());
        intent = stringBuilder.toString();
        if (th != null) {
            Timber.c(th, intent, new Object[0]);
        } else {
            Timber.e(intent, new Object[0]);
        }
        finish();
    }
}
