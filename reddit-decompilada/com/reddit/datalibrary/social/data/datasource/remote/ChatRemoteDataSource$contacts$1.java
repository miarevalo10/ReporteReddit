package com.reddit.datalibrary.social.data.datasource.remote;

import com.reddit.datalibrary.social.model.Contact;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "", "Lcom/reddit/datalibrary/social/model/Contact;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatRemoteDataSource.kt */
final class ChatRemoteDataSource$contacts$1<T> implements Consumer<List<? extends Contact>> {
    final /* synthetic */ ChatRemoteDataSource f27265a;

    ChatRemoteDataSource$contacts$1(ChatRemoteDataSource chatRemoteDataSource) {
        this.f27265a = chatRemoteDataSource;
    }

    public final /* synthetic */ void accept(Object obj) {
        this.f27265a.f33478r = (List) obj;
    }
}
