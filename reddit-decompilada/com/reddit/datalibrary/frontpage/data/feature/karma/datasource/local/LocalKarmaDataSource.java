package com.reddit.datalibrary.frontpage.data.feature.karma.datasource.local;

import com.reddit.frontpage.domain.model.Karma;
import io.reactivex.Maybe;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J$\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&¨\u0006\f"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/karma/datasource/local/LocalKarmaDataSource;", "", "getTopKarma", "Lio/reactivex/Maybe;", "", "Lcom/reddit/frontpage/domain/model/Karma;", "username", "", "saveTopKarma", "Lio/reactivex/Single;", "", "karma", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LocalKarmaDataSource.kt */
public interface LocalKarmaDataSource {
    Maybe<List<Karma>> mo2927a(String str);

    Single<Boolean> mo2928a(String str, List<Karma> list);
}
