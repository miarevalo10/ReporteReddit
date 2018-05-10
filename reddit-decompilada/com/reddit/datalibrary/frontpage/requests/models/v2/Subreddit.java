package com.reddit.datalibrary.frontpage.requests.models.v2;

import com.raizlabs.android.dbflow.structure.cache.IMultiKeyCacheConverter;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.frontpage.util.Util;
import org.parceler.Parcel;

@Parcel
public class Subreddit extends SubredditInfo implements DeserializationPostProcessable, Identifiable, SessionDependent {
    public static final IMultiKeyCacheConverter<String> MULTI_CACHE_KEY_MODEL = new C22261();
    String _username;
    boolean user_favorite;
    boolean user_is_moderator;
    boolean user_is_subscriber;

    static class C22261 implements IMultiKeyCacheConverter<String> {
        C22261() {
        }

        public final /* synthetic */ Object getCachingKey(Object[] objArr) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(objArr[0]);
            stringBuilder.append(":");
            stringBuilder.append(objArr[1]);
            return stringBuilder.toString();
        }
    }

    public void postDeserialization() {
        this._id = Util.m24024f(this.id);
    }

    public void updateSessionInfo(Session session) {
        if (!session.isAnonymous()) {
            this._username = session.getUsername();
        }
    }

    public long getDatabaseId() {
        return this._id;
    }

    public boolean isUserSubreddit() {
        return getSubredditType().equals("user");
    }

    public boolean isUserSubscribed() {
        return this.user_is_subscriber;
    }

    public boolean isUserModerator() {
        return this.user_is_moderator;
    }

    public boolean isUserFavorite() {
        return this.user_favorite;
    }

    public void setUserFavorite(boolean z) {
        this.user_favorite = z;
    }

    public long getUniqueID() {
        return this._id;
    }
}
