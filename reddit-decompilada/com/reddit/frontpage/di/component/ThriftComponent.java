package com.reddit.frontpage.di.component;

import com.reddit.frontpage.commons.analytics.AnalyticsDispatchJobService;
import com.reddit.frontpage.commons.analytics.output.ThriftOutput;
import javax.inject.Singleton;
import kotlin.Metadata;

@Singleton
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/reddit/frontpage/di/component/ThriftComponent;", "", "inject", "", "analyticsDispatchJob", "Lcom/reddit/frontpage/commons/analytics/AnalyticsDispatchJobService;", "thriftOutput", "Lcom/reddit/frontpage/commons/analytics/output/ThriftOutput;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ThriftComponent.kt */
public interface ThriftComponent {
    void mo4744a(AnalyticsDispatchJobService analyticsDispatchJobService);

    void mo4745a(ThriftOutput thriftOutput);
}
