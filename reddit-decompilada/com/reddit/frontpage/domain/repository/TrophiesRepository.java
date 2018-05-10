package com.reddit.frontpage.domain.repository;

import com.reddit.frontpage.domain.model.Trophy;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/reddit/frontpage/domain/repository/TrophiesRepository;", "", "getTrophies", "Lio/reactivex/Single;", "", "Lcom/reddit/frontpage/domain/model/Trophy;", "username", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: TrophiesRepository.kt */
public interface TrophiesRepository {
    Single<List<Trophy>> m22509a(String str);
}
