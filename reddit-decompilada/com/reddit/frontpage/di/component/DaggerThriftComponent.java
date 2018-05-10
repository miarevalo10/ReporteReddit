package com.reddit.frontpage.di.component;

import android.content.Context;
import com.firebase.jobdispatcher.FirebaseJobDispatcher;
import com.firebase.jobdispatcher.GooglePlayDriver;
import com.reddit.common.rx.BackgroundThread;
import com.reddit.data.events.datasource.local.DatabaseEventDataSource_Factory;
import com.reddit.data.events.datasource.local.LocalEventDataSource;
import com.reddit.data.events.datasource.remote.RemoteEventDataSource;
import com.reddit.frontpage.commons.analytics.AnalyticsDispatchJobService;
import com.reddit.frontpage.commons.analytics.AnalyticsDispatchJobService_MembersInjector;
import com.reddit.frontpage.commons.analytics.output.ThriftOutput;
import com.reddit.frontpage.commons.analytics.output.ThriftOutput_MembersInjector;
import com.reddit.frontpage.di.module.ApplicationModule;
import com.reddit.frontpage.di.module.ApplicationModule_ContextFactory;
import com.reddit.frontpage.di.module.NetworkModule;
import com.reddit.frontpage.di.module.NetworkModule_AnalyticsRetrofitClientFactory;
import com.reddit.frontpage.di.module.NetworkModule_OkHttpClientFactory;
import com.reddit.frontpage.di.module.NetworkModule_ProvideMoshiFactory;
import com.reddit.frontpage.di.module.RxModule;
import com.reddit.frontpage.di.module.RxModule_BackgroundThreadFactory;
import com.reddit.frontpage.di.module.ThriftModule;
import com.reddit.frontpage.di.module.ThriftModule_ProvideGooglePlayDriverFactory;
import com.reddit.frontpage.di.module.ThriftModule_ProvideJobDispatcherFactory;
import com.reddit.frontpage.di.module.ThriftModule_ProvideRemoteEventDataSourceFactory;
import com.squareup.moshi.Moshi;
import dagger.internal.DoubleCheck;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public final class DaggerThriftComponent implements ThriftComponent {
    private Provider<Context> f27912a;
    private Provider<GooglePlayDriver> f27913b;
    private Provider<FirebaseJobDispatcher> f27914c;
    private Provider<Moshi> f27915d;
    private DatabaseEventDataSource_Factory f27916e;
    private Provider<LocalEventDataSource> f27917f;
    private Provider<BackgroundThread> f27918g;
    private Provider<OkHttpClient> f27919h;
    private Provider<Retrofit> f27920i;
    private Provider<RemoteEventDataSource> f27921j;

    public static final class Builder {
        public ApplicationModule f20215a;
        public ThriftModule f20216b;
        public NetworkModule f20217c;
        public RxModule f20218d;

        private Builder() {
        }
    }

    private DaggerThriftComponent(Builder builder) {
        this.f27912a = DoubleCheck.m31842a(ApplicationModule_ContextFactory.m34462a(builder.f20215a));
        this.f27913b = DoubleCheck.m31842a(ThriftModule_ProvideGooglePlayDriverFactory.m34534a(builder.f20216b, this.f27912a));
        this.f27914c = DoubleCheck.m31842a(ThriftModule_ProvideJobDispatcherFactory.m34535a(builder.f20216b, this.f27913b));
        this.f27915d = DoubleCheck.m31842a(NetworkModule_ProvideMoshiFactory.m34510a(builder.f20217c));
        this.f27916e = DatabaseEventDataSource_Factory.a(this.f27915d);
        this.f27917f = DoubleCheck.m31842a(this.f27916e);
        this.f27918g = DoubleCheck.m31842a(RxModule_BackgroundThreadFactory.m34527a(builder.f20218d));
        this.f27919h = DoubleCheck.m31842a(NetworkModule_OkHttpClientFactory.m34509a(builder.f20217c));
        this.f27920i = DoubleCheck.m31842a(NetworkModule_AnalyticsRetrofitClientFactory.m34506a(builder.f20217c, this.f27919h));
        this.f27921j = DoubleCheck.m31842a(ThriftModule_ProvideRemoteEventDataSourceFactory.m34536a(builder.f20216b, this.f27920i));
    }

    public static Builder m29286a() {
        return new Builder();
    }

    public final void mo4745a(ThriftOutput thriftOutput) {
        ThriftOutput_MembersInjector.m28975a(thriftOutput, (FirebaseJobDispatcher) this.f27914c.get());
        ThriftOutput_MembersInjector.m28977a(thriftOutput, (LocalEventDataSource) this.f27917f.get());
        ThriftOutput_MembersInjector.m28976a(thriftOutput, (BackgroundThread) this.f27918g.get());
    }

    public final void mo4744a(AnalyticsDispatchJobService analyticsDispatchJobService) {
        AnalyticsDispatchJobService_MembersInjector.m28906a(analyticsDispatchJobService, (BackgroundThread) this.f27918g.get());
        AnalyticsDispatchJobService_MembersInjector.m28907a(analyticsDispatchJobService, (LocalEventDataSource) this.f27917f.get());
        AnalyticsDispatchJobService_MembersInjector.m28908a(analyticsDispatchJobService, (RemoteEventDataSource) this.f27921j.get());
    }
}
