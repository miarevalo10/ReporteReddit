package com.reddit.datalibrary.frontpage.data.feature.ads.repo;

import android.graphics.Bitmap;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest.Builder;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent.User;
import com.reddit.datalibrary.frontpage.data.feature.ads.AdContext;
import com.reddit.datalibrary.frontpage.data.feature.ads.SubredditAdMetadata;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import timber.log.Timber;

public class AdsRepository {
    public Map<String, List<NativeAdInfo<?>>> f10340a = new HashMap();
    public Map<String, List<NativeAdInfo<?>>> f10341b = new HashMap();
    public List<String> f10342c = new ArrayList();

    public static abstract class NativeAdInfo<T extends NativeAd> {
        public final T f10327a;
        public final float f10328b;
        public int f10329c = -1;
        public boolean f10330d;
        protected boolean f10331e;

        public abstract boolean mo2918a();

        public abstract void mo2919b();

        NativeAdInfo(T t, float f) {
            this.f10327a = t;
            this.f10328b = f;
        }

        public final boolean m8791c() {
            return this.f10331e;
        }
    }

    public interface NativeAdListener {
        void m8792a(NativeAppInstallAdInfo nativeAppInstallAdInfo);

        void m8793a(NativeContentAdInfo nativeContentAdInfo);
    }

    public class NativeAdLoader {
        public final AdContext f10332a;
        public boolean f10333b;
        public final /* synthetic */ AdsRepository f10334c;
        private final NativeAdListener f10335d;
        private AdLoader f10336e;
        private int f10337f = 0;
        private Builder f10338g;
        private int f10339h = 0;

        class C14901 extends AdListener {
            final /* synthetic */ NativeAdLoader f15772a;

            C14901(NativeAdLoader nativeAdLoader) {
                this.f15772a = nativeAdLoader;
            }

            public final void mo1258a(int i) {
                Timber.b("Ad failed to load. Error code: %d", new Object[]{Integer.valueOf(i)});
            }
        }

        class C17382 extends SimpleTarget<Bitmap> {
            final /* synthetic */ NativeAppInstallAd f19769a;
            final /* synthetic */ NativeAdLoader f19770b;

            C17382(NativeAdLoader nativeAdLoader, NativeAppInstallAd nativeAppInstallAd) {
                this.f19770b = nativeAdLoader;
                this.f19769a = nativeAppInstallAd;
            }

            public final /* synthetic */ void mo3858a(Object obj, Transition transition) {
                Bitmap bitmap = (Bitmap) obj;
                this.f19770b.m8799a(this.f19769a, ((float) bitmap.getWidth()) / ((float) bitmap.getHeight()));
            }
        }

        class C17393 extends SimpleTarget<Bitmap> {
            final /* synthetic */ NativeContentAd f19771a;
            final /* synthetic */ NativeAdLoader f19772b;

            C17393(NativeAdLoader nativeAdLoader, NativeContentAd nativeContentAd) {
                this.f19772b = nativeAdLoader;
                this.f19771a = nativeContentAd;
            }

            public final /* synthetic */ void mo3858a(Object obj, Transition transition) {
                Bitmap bitmap = (Bitmap) obj;
                this.f19772b.m8800a(this.f19771a, ((float) bitmap.getWidth()) / ((float) bitmap.getHeight()));
            }
        }

        public NativeAdLoader(AdsRepository adsRepository, AdContext adContext, NativeAdListener nativeAdListener) {
            this.f10334c = adsRepository;
            this.f10332a = adContext;
            this.f10335d = nativeAdListener;
        }

        public final void m8798a() {
            String str;
            boolean z = false;
            this.f10333b = false;
            FrontpageSettings a = FrontpageSettings.m9011a();
            if (Math.abs(System.currentTimeMillis() - a.f10758a.getLong("com.reddit.frontpage.ads_reset_timestamp", 0)) > 86400000) {
                Timber.b("Resetting ads", new Object[0]);
                a.f10758a.edit().putInt("com.reddit.frontpage.ads_seen", 0).putLong("com.reddit.frontpage.ads_reset_timestamp", System.currentTimeMillis()).apply();
            }
            this.f10339h = Math.max(25 / FrontpageSettings.m9011a().m9059t().m9367a().m9356c(), 1);
            Timber.b("Refreshed ads to request: %d", new Object[]{Integer.valueOf(this.f10339h)});
            String str2 = this.f10332a.f10316c;
            if (((List) this.f10334c.f10340a.get(str2)) == null) {
                this.f10334c.f10340a.put(str2, new ArrayList());
            }
            if (((List) this.f10334c.f10341b.get(str2)) == null) {
                this.f10334c.f10341b.put(str2, new ArrayList());
            }
            m8796b();
            if (this.f10336e == null) {
                AdLoader.Builder a2 = new AdLoader.Builder(FrontpageApplication.a, this.f10332a.f10314a).m4364a(new AdsRepository$NativeAdLoader$$Lambda$0(this)).m4365a(new AdsRepository$NativeAdLoader$$Lambda$1(this)).m4362a(new C14901(this));
                NativeAdOptions.Builder builder = new NativeAdOptions.Builder();
                builder.f5399e = 1;
                builder.f5395a = true;
                VideoOptions.Builder builder2 = new VideoOptions.Builder();
                builder2.f5387a = true;
                builder.f5398d = builder2.m4389b();
                this.f10336e = a2.m4363a(builder.m4406c()).m4367a();
            }
            Session session = this.f10332a.f10315b;
            SubredditAdMetadata subredditAdMetadata = this.f10332a.f10318e;
            boolean z2 = subredditAdMetadata != null && subredditAdMetadata.f10319a;
            if (subredditAdMetadata != null) {
                str = subredditAdMetadata.f10320b;
            } else {
                str = "all_ads";
            }
            Builder a3 = new Builder().m4392a("screen", this.f10332a.f10317d);
            String str3 = "subreddit_screen";
            if (subredditAdMetadata != null) {
                z = true;
            }
            this.f10338g = a3.m4392a(str3, Boolean.toString(z)).m4392a("nsfw", Boolean.toString(z2)).m4392a("compact", Boolean.toString(a.m9030c())).m4392a("whitelist_status", str).m4392a(User.VALUE_LOGGED_IN, Boolean.toString(true ^ session.isAnonymous())).m4392a("random_number", Integer.toString(session.f16288a.hashCode() % 100));
            m8797c();
        }

        private void m8796b() {
            List list = (List) this.f10334c.f10341b.get(this.f10332a.f10316c);
            Iterator it = ((List) this.f10334c.f10340a.get(this.f10332a.f10316c)).iterator();
            while (it.hasNext()) {
                NativeAdInfo nativeAdInfo = (NativeAdInfo) it.next();
                if (nativeAdInfo.m8791c()) {
                    it.remove();
                } else {
                    if (nativeAdInfo instanceof NativeAppInstallAdInfo) {
                        this.f10335d.m8792a((NativeAppInstallAdInfo) nativeAdInfo);
                    } else {
                        this.f10335d.m8793a((NativeContentAdInfo) nativeAdInfo);
                    }
                    this.f10339h--;
                    it.remove();
                    list.add(nativeAdInfo);
                }
            }
        }

        final void m8799a(NativeAppInstallAd nativeAppInstallAd, float f) {
            if (!this.f10333b) {
                NativeAppInstallAdInfo nativeAppInstallAdInfo = new NativeAppInstallAdInfo(nativeAppInstallAd, f);
                AdsRepository.m8802a(this.f10334c, this.f10332a.f10316c, nativeAppInstallAdInfo);
                this.f10335d.m8792a(nativeAppInstallAdInfo);
                m8797c();
            }
        }

        final void m8800a(NativeContentAd nativeContentAd, float f) {
            if (!this.f10333b) {
                NativeContentAdInfo nativeContentAdInfo = new NativeContentAdInfo(nativeContentAd, f);
                AdsRepository.m8802a(this.f10334c, this.f10332a.f10316c, nativeContentAdInfo);
                this.f10335d.m8793a(nativeContentAdInfo);
                m8797c();
            }
        }

        private void m8797c() {
            if (this.f10339h > 0) {
                if (!this.f10336e.m4370a()) {
                    PublisherAdRequest a = this.f10338g.m4392a("placement", Integer.toString(this.f10337f + 1)).m4393a();
                    this.f10339h--;
                    this.f10337f++;
                    this.f10336e.m4368a(a);
                    AppAnalytics.a(this.f10332a.f10317d);
                }
            }
        }
    }

    public static class NativeAppInstallAdInfo extends NativeAdInfo<NativeAppInstallAd> {
        NativeAppInstallAdInfo(NativeAppInstallAd nativeAppInstallAd, float f) {
            super(nativeAppInstallAd, f);
        }

        public final boolean mo2918a() {
            return ((NativeAppInstallAd) this.f10327a).mo3555j().m4384b();
        }

        public final void mo2919b() {
            ((NativeAppInstallAd) this.f10327a).mo3556k();
            this.e = true;
        }
    }

    public static class NativeContentAdInfo extends NativeAdInfo<NativeContentAd> {
        NativeContentAdInfo(NativeContentAd nativeContentAd, float f) {
            super(nativeContentAd, f);
        }

        public final boolean mo2918a() {
            return ((NativeContentAd) this.f10327a).mo3563h().m4384b();
        }

        public final void mo2919b() {
            ((NativeContentAd) this.f10327a).mo3564i();
            this.e = true;
        }
    }

    public final void m8804a(String str) {
        Timber.b("Marking ad loader destroyed", new Object[0]);
        this.f10342c.add(str);
    }

    static /* synthetic */ void m8802a(AdsRepository adsRepository, String str, NativeAdInfo nativeAdInfo) {
        List list = (List) adsRepository.f10341b.get(str);
        if (list == null) {
            list = new ArrayList();
            adsRepository.f10341b.put(str, list);
        }
        list.add(nativeAdInfo);
    }
}
