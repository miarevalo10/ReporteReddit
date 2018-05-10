package com.reddit.datalibrary.social.data.session;

import android.text.TextUtils;
import com.reddit.datalibrary.frontpage.requests.models.v2.SendBirdAccessTokenData;
import com.reddit.frontpage.util.SessionUtil;
import com.sendbird.android.SendBird;
import com.sendbird.android.SendBird.ConnectHandler;
import com.sendbird.android.SendBirdException;
import com.sendbird.android.User;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0014\u0010\u0002\u001a\u0010\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u00040\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "e", "Lio/reactivex/ObservableEmitter;", "", "kotlin.jvm.PlatformType", "subscribe"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatConnectionManager.kt */
final class ChatConnectionManager$sendBirdConnectObservable$1<T> implements ObservableOnSubscribe<T> {
    final /* synthetic */ ChatConnectionManager f27391a;
    final /* synthetic */ String f27392b;

    ChatConnectionManager$sendBirdConnectObservable$1(ChatConnectionManager chatConnectionManager, String str) {
        this.f27391a = chatConnectionManager;
        this.f27392b = str;
    }

    public final void mo4493a(final ObservableEmitter<String> observableEmitter) {
        Intrinsics.m26847b(observableEmitter, "e");
        final String d = SessionUtil.m23898d();
        if (TextUtils.isEmpty(d)) {
            if (!observableEmitter.mo5627b()) {
                observableEmitter.mo5642a((Throwable) new IllegalStateException("Current user is not signed in."));
            }
            Timber.e("Current user is not signed in.", new Object[0]);
            return;
        }
        SendBirdAccessTokenData b = this.f27391a.f19861c;
        if (b == null) {
            Intrinsics.m26842a();
        }
        String str = b.sb_access_token;
        StringBuilder stringBuilder = new StringBuilder("https://");
        stringBuilder.append(this.f27392b);
        String stringBuilder2 = stringBuilder.toString();
        StringBuilder stringBuilder3 = new StringBuilder("wss://");
        stringBuilder3.append(this.f27392b);
        SendBird.m24973a(d, str, stringBuilder2, stringBuilder3.toString(), new ConnectHandler() {
            public final void mo4559a(User user, SendBirdException sendBirdException) {
                if (sendBirdException == null) {
                    if (user != null) {
                        observableEmitter.mo5641a((Object) user.m25021d());
                        observableEmitter.aA_();
                        return;
                    }
                }
                Object obj = observableEmitter;
                Intrinsics.m26843a(obj, "e");
                if (obj.mo5627b() == null) {
                    user = observableEmitter;
                    if (sendBirdException != null) {
                        sendBirdException = sendBirdException;
                    } else {
                        StringBuilder stringBuilder = new StringBuilder("User ");
                        stringBuilder.append(d);
                        stringBuilder.append(" is null , but it shouldn't be possible!");
                        sendBirdException = new IllegalStateException(stringBuilder.toString());
                    }
                    user.mo5642a((Throwable) sendBirdException);
                }
            }
        });
    }
}
