package com.reddit.frontpage.di.module;

import com.reddit.common.rx.BackgroundThread;
import com.reddit.common.rx.IoThread;
import com.reddit.common.rx.PostExecutionThread;
import com.reddit.common.rx.UiThread;
import javax.inject.Singleton;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/di/module/RxModule;", "", "()V", "backgroundThread", "Lcom/reddit/common/rx/BackgroundThread;", "postExecutionThread", "Lcom/reddit/common/rx/PostExecutionThread;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RxModule.kt */
public final class RxModule {
    @Singleton
    public static PostExecutionThread m22366a() {
        return new UiThread();
    }

    @Singleton
    public static BackgroundThread m22367b() {
        return new IoThread();
    }
}
