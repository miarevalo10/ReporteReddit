package com.reddit.frontpage.domain.repository;

import com.reddit.frontpage.domain.model.Karma;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/reddit/frontpage/domain/repository/KarmaRepository;", "", "getTopKarma", "Lio/reactivex/Single;", "", "Lcom/reddit/frontpage/domain/model/Karma;", "username", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: KarmaRepository.kt */
public interface KarmaRepository {
    Single<List<Karma>> m22406a(String str);
}
