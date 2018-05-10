package com.reddit.datalibrary.social.data.datasource.remote;

import com.sendbird.android.GroupChannel;
import com.sendbird.android.GroupChannel.GroupChannelHideHandler;
import com.sendbird.android.SendBirdException;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lio/reactivex/Observable;", "", "kotlin.jvm.PlatformType", "groupChannel", "Lcom/sendbird/android/GroupChannel;", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatRemoteDataSource.kt */
final class ChatRemoteDataSource$hideChannel$1<T, R> implements Function<T, ObservableSource<? extends R>> {
    public static final ChatRemoteDataSource$hideChannel$1 f27295a = new ChatRemoteDataSource$hideChannel$1();

    ChatRemoteDataSource$hideChannel$1() {
    }

    public final /* synthetic */ Object apply(Object obj) {
        final GroupChannel groupChannel = (GroupChannel) obj;
        Intrinsics.m26847b(groupChannel, "groupChannel");
        return Observable.create(new ObservableOnSubscribe<T>() {
            public final void mo4493a(final ObservableEmitter<Boolean> observableEmitter) {
                Intrinsics.m26847b(observableEmitter, "emitter");
                groupChannel.m30970a((GroupChannelHideHandler) new GroupChannelHideHandler() {
                    public final void mo4492a(SendBirdException sendBirdException) {
                        if (sendBirdException != null) {
                            Object obj = observableEmitter;
                            Intrinsics.m26843a(obj, "emitter");
                            if (!obj.mo5627b()) {
                                observableEmitter.mo5642a((Throwable) sendBirdException);
                            }
                            return;
                        }
                        observableEmitter.mo5641a((Object) Boolean.valueOf(true));
                        observableEmitter.aA_();
                    }
                });
            }
        });
    }
}
