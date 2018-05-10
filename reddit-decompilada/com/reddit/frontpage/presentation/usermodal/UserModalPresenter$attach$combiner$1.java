package com.reddit.frontpage.presentation.usermodal;

import com.reddit.datalibrary.frontpage.data.model.Account;
import com.reddit.datalibrary.frontpage.data.model.BannedUsersResponse;
import com.reddit.datalibrary.frontpage.data.model.MutedUsersResponse;
import com.reddit.frontpage.presentation.usermodal.UserModalPresenter.UserModalInfo;
import io.reactivex.functions.Function3;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "Lcom/reddit/frontpage/presentation/usermodal/UserModalPresenter$UserModalInfo;", "account", "Lcom/reddit/datalibrary/frontpage/data/model/Account;", "bannedUsers", "Lcom/reddit/datalibrary/frontpage/data/model/BannedUsersResponse;", "mutedUsers", "Lcom/reddit/datalibrary/frontpage/data/model/MutedUsersResponse;", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: UserModalPresenter.kt */
final class UserModalPresenter$attach$combiner$1<T1, T2, T3, R> implements Function3<Account, BannedUsersResponse, MutedUsersResponse, UserModalInfo> {
    final /* synthetic */ UserModalPresenter f28810a;

    UserModalPresenter$attach$combiner$1(UserModalPresenter userModalPresenter) {
        this.f28810a = userModalPresenter;
    }

    public final /* synthetic */ Object mo4932a(Object obj, Object obj2, Object obj3) {
        Account account = (Account) obj;
        BannedUsersResponse bannedUsersResponse = (BannedUsersResponse) obj2;
        MutedUsersResponse mutedUsersResponse = (MutedUsersResponse) obj3;
        Intrinsics.m26847b(account, "account");
        Intrinsics.m26847b(bannedUsersResponse, "bannedUsers");
        Intrinsics.m26847b(mutedUsersResponse, "mutedUsers");
        Iterable<Object> bannedUserIds = bannedUsersResponse.getBannedUserIds();
        int i = 0;
        if (!((bannedUserIds instanceof Collection) && ((Collection) bannedUserIds).isEmpty())) {
            for (Object a : bannedUserIds) {
                if (Intrinsics.m26845a(a, UserModalPresenter.m34878a(account.getId()))) {
                    obj2 = null;
                    break;
                }
            }
        }
        obj2 = 1;
        obj2 ^= 1;
        Iterable<Object> mutedUserIds = mutedUsersResponse.getMutedUserIds();
        if (!((mutedUserIds instanceof Collection) && ((Collection) mutedUserIds).isEmpty())) {
            for (Object a2 : mutedUserIds) {
                if (Intrinsics.m26845a(a2, UserModalPresenter.m34878a(account.getId()))) {
                    break;
                }
            }
        }
        i = 1;
        return new UserModalInfo(account, obj2, i ^ 1);
    }
}
