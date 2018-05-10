package com.reddit.frontpage.domain.usecase;

import com.reddit.datalibrary.frontpage.requests.models.config.AppConfiguration;
import com.reddit.datalibrary.frontpage.requests.models.config.AppConfiguration.AdsConfiguration;
import com.reddit.datalibrary.frontpage.requests.models.v1.Account;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002 \u0001\"\n\b\u0001\u0010\u0003 \u0000*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "P", "Lcom/reddit/frontpage/domain/usecase/AdsParams;", "call"}, k = 3, mv = {1, 1, 9})
/* compiled from: AdsUseCase.kt */
final class AdsUseCase$getAds$1<V> implements Callable<T> {
    final /* synthetic */ AdsUseCase f20268a;

    AdsUseCase$getAds$1(AdsUseCase adsUseCase) {
        this.f20268a = adsUseCase;
    }

    public final /* synthetic */ Object call() {
        boolean a;
        Account d;
        AppConfiguration t = this.f20268a.f20269a.t();
        boolean z = false;
        if (t != null) {
            AdsConfiguration a2 = t.a();
            if (a2 != null) {
                a = a2.a();
                if (a) {
                    Timber.b("Not showing ads. Not active.", new Object[0]);
                } else {
                    d = this.f20268a.f20270b.d();
                    if (d == null ? d.a() : false) {
                        z = true;
                    } else {
                        Timber.b("User is gold. Not showing ads.", new Object[0]);
                    }
                }
                return Boolean.valueOf(z);
            }
        }
        a = false;
        if (a) {
            d = this.f20268a.f20270b.d();
            if (d == null) {
            }
            if (d == null ? d.a() : false) {
                z = true;
            } else {
                Timber.b("User is gold. Not showing ads.", new Object[0]);
            }
        } else {
            Timber.b("Not showing ads. Not active.", new Object[0]);
        }
        return Boolean.valueOf(z);
    }
}
