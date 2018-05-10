package com.reddit.datalibrary.frontpage.requests.models.v2;

import com.raizlabs.android.dbflow.annotation.ColumnIgnore;
import com.raizlabs.android.dbflow.structure.BaseModel;
import com.raizlabs.android.dbflow.structure.cache.IMultiKeyCacheConverter;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import java.util.List;
import org.parceler.Parcel;

@Parcel
public class Multireddit extends BaseModel implements SessionDependent {
    public static final IMultiKeyCacheConverter<String> MULTI_CACHE_KEY_MODEL = new C22251();
    String _username;
    boolean can_edit;
    String icon_url;
    String key_color;
    String name;
    String path;
    @ColumnIgnore
    List<SubredditInfo> subreddits;

    static class C22251 implements IMultiKeyCacheConverter<String> {
        C22251() {
        }

        public final /* synthetic */ Object getCachingKey(Object[] objArr) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(objArr[0]);
            stringBuilder.append(":");
            stringBuilder.append(objArr[1]);
            return stringBuilder.toString();
        }
    }

    public void updateSessionInfo(Session session) {
        if (!session.isAnonymous()) {
            this._username = session.getUsername();
        }
    }

    public String getName() {
        return this.name;
    }

    public boolean isEditable() {
        return this.can_edit;
    }

    public String getPath() {
        return this.path;
    }

    public String getIconUrl() {
        return this.icon_url;
    }

    public String getKeyColor() {
        return this.key_color;
    }

    public List<SubredditInfo> getSubreddits() {
        return this.subreddits;
    }
}
