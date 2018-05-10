package com.reddit.datalibrary.social.data.datasource.cache;

import com.sendbird.android.BaseMessage;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H&¨\u0006\u000e"}, d2 = {"Lcom/reddit/datalibrary/social/data/datasource/cache/FailedMessagesCacheContract;", "", "add", "", "channelUrl", "", "message", "Lcom/sendbird/android/BaseMessage;", "get", "", "has", "", "remove", "requestId", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: FailedMessagesCacheContract.kt */
public interface FailedMessagesCacheContract {
    void add(String str, BaseMessage baseMessage);

    List<BaseMessage> get(String str);

    boolean has(String str);

    void remove(String str, String str2);
}
