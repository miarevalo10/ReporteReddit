package com.reddit.datalibrary.social.data.datasource.cache;

import com.reddit.social.presentation.presentationobjects.UserData;
import io.reactivex.Observable;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\f\u0012\b\u0012\u00060\u0004j\u0002`\u00050\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J0\u0010\u0007\u001a\u001c\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\n0\tj\u0002`\u000b0\b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J$\u0010\f\u001a\u00020\r2\u001a\u0010\u000e\u001a\u0016\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\n0\tj\u0002`\u000bH&¨\u0006\u000f"}, d2 = {"Lcom/reddit/datalibrary/social/data/datasource/cache/ChatUserDataCacheContract;", "", "getNotCachedUsersId", "", "", "Lcom/reddit/datalibrary/social/network/UserId;", "usersId", "getUsersData", "Lio/reactivex/Observable;", "", "Lcom/reddit/social/presentation/presentationobjects/UserData;", "Lcom/reddit/datalibrary/social/data/datasource/cache/UserDataMap;", "putUsersData", "", "data", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ChatUserDataCacheContract.kt */
public interface ChatUserDataCacheContract {
    Set<String> getNotCachedUsersId(Set<String> set);

    Observable<Map<String, UserData>> getUsersData(Set<String> set);

    void putUsersData(Map<String, UserData> map);
}
