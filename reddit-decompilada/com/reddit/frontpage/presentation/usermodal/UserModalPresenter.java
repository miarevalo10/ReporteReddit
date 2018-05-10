package com.reddit.frontpage.presentation.usermodal;

import com.reddit.common.rx.PostExecutionThread;
import com.reddit.datalibrary.frontpage.data.model.Account;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.domain.repository.AccountRepository;
import com.reddit.frontpage.domain.repository.ModToolsRepository;
import com.reddit.frontpage.presentation.common.BasePresenter;
import com.reddit.frontpage.presentation.common.DisposablePresenter;
import com.reddit.frontpage.presentation.usermodal.UserModalContract.View;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.kotlin.SinglesKt;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001)B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\u0015\u001a\u00020\u0016H\u0016J \u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J(\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u0019H\u0002J(\u0010$\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0018\u0010%\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u00192\u0006\u0010&\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u0019H\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006*"}, d2 = {"Lcom/reddit/frontpage/presentation/usermodal/UserModalPresenter;", "Lcom/reddit/frontpage/presentation/common/DisposablePresenter;", "Lcom/reddit/frontpage/presentation/common/BasePresenter;", "Lcom/reddit/frontpage/presentation/usermodal/UserModalContract$Presenter;", "view", "Lcom/reddit/frontpage/presentation/usermodal/UserModalContract$View;", "repository", "Lcom/reddit/frontpage/domain/repository/ModToolsRepository;", "scheduler", "Lcom/reddit/common/rx/PostExecutionThread;", "accountRepository", "Lcom/reddit/frontpage/domain/repository/AccountRepository;", "(Lcom/reddit/frontpage/presentation/usermodal/UserModalContract$View;Lcom/reddit/frontpage/domain/repository/ModToolsRepository;Lcom/reddit/common/rx/PostExecutionThread;Lcom/reddit/frontpage/domain/repository/AccountRepository;)V", "getAccountRepository", "()Lcom/reddit/frontpage/domain/repository/AccountRepository;", "getRepository", "()Lcom/reddit/frontpage/domain/repository/ModToolsRepository;", "getScheduler", "()Lcom/reddit/common/rx/PostExecutionThread;", "getView", "()Lcom/reddit/frontpage/presentation/usermodal/UserModalContract$View;", "attach", "", "banForComment", "username", "", "comment", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/Comment;", "targetScreen", "Lcom/reddit/frontpage/nav/Screen;", "banForPost", "link", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Link;", "commentId", "getAccountId", "id", "mute", "unban", "type", "Lcom/reddit/datalibrary/frontpage/data/feature/modtools/repo/RedditModToolsRepository$ModToolsActionType;", "unmute", "UserModalInfo", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: UserModalPresenter.kt */
public final class UserModalPresenter extends DisposablePresenter implements BasePresenter {
    final View f34178a;
    final ModToolsRepository f34179b;
    final PostExecutionThread f34180c;
    private final AccountRepository f34181d;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/reddit/frontpage/presentation/usermodal/UserModalPresenter$UserModalInfo;", "", "account", "Lcom/reddit/datalibrary/frontpage/data/model/Account;", "isBanned", "", "isMuted", "(Lcom/reddit/datalibrary/frontpage/data/model/Account;ZZ)V", "getAccount", "()Lcom/reddit/datalibrary/frontpage/data/model/Account;", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "getSubreddit", "Lcom/reddit/datalibrary/frontpage/data/model/UserSubreddit;", "hashCode", "", "toString", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: UserModalPresenter.kt */
    public static final class UserModalInfo {
        final Account f20992a;
        final boolean f20993b;
        final boolean f20994c;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof UserModalInfo) {
                UserModalInfo userModalInfo = (UserModalInfo) obj;
                if (Intrinsics.m26845a(this.f20992a, userModalInfo.f20992a)) {
                    if (this.f20993b == userModalInfo.f20993b) {
                        if (this.f20994c == userModalInfo.f20994c) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        public final int hashCode() {
            Account account = this.f20992a;
            int hashCode = (account != null ? account.hashCode() : 0) * 31;
            int i = this.f20993b;
            if (i != 0) {
                i = 1;
            }
            hashCode = (hashCode + i) * 31;
            i = this.f20994c;
            if (i != 0) {
                i = 1;
            }
            return hashCode + i;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("UserModalInfo(account=");
            stringBuilder.append(this.f20992a);
            stringBuilder.append(", isBanned=");
            stringBuilder.append(this.f20993b);
            stringBuilder.append(", isMuted=");
            stringBuilder.append(this.f20994c);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public UserModalInfo(Account account, boolean z, boolean z2) {
            Intrinsics.m26847b(account, "account");
            this.f20992a = account;
            this.f20993b = z;
            this.f20994c = z2;
        }
    }

    @Inject
    public UserModalPresenter(View view, ModToolsRepository modToolsRepository, PostExecutionThread postExecutionThread, AccountRepository accountRepository) {
        Intrinsics.m26847b(view, "view");
        Intrinsics.m26847b(modToolsRepository, "repository");
        Intrinsics.m26847b(postExecutionThread, "scheduler");
        Intrinsics.m26847b(accountRepository, "accountRepository");
        this.f34178a = view;
        this.f34179b = modToolsRepository;
        this.f34180c = postExecutionThread;
        this.f34181d = accountRepository;
    }

    public final void attach() {
        if (this.f34178a.mo4937b().getSubreddit() == null) {
            View view = this.f34178a;
            String f = Util.m24027f((int) C1761R.string.error_network_error);
            Intrinsics.m26843a((Object) f, "Util.getString(R.string.error_network_error)");
            view.mo4936a(f);
            return;
        }
        Single a = this.f34181d.m22394a(this.f34178a.mo4933a());
        ModToolsRepository modToolsRepository = this.f34179b;
        Object subreddit = this.f34178a.mo4937b().getSubreddit();
        if (subreddit == null) {
            Intrinsics.m26842a();
        }
        Intrinsics.m26843a(subreddit, "view.link.subreddit!!");
        Single a2 = modToolsRepository.m22439a((String) subreddit, null);
        ModToolsRepository modToolsRepository2 = this.f34179b;
        Object subreddit2 = this.f34178a.mo4937b().getSubreddit();
        if (subreddit2 == null) {
            Intrinsics.m26842a();
        }
        Intrinsics.m26843a(subreddit2, "view.link.subreddit!!");
        Object zip = Single.zip(a, a2, modToolsRepository2.m22457f(subreddit2, null), new UserModalPresenter$attach$combiner$1(this));
        Intrinsics.m26843a(zip, "Single.zip(account, bann…rs, mutedUsers, combiner)");
        zip = SinglesKt.m24094b(zip, this.f34180c).subscribe(new UserModalPresenter$attach$1(this), new UserModalPresenter$attach$2(this));
        Intrinsics.m26843a(zip, "Single.zip(account, bann…rk_error))\n            })");
        handleDispose(zip);
    }

    static String m34878a(String str) {
        StringBuilder stringBuilder = new StringBuilder("t2_");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }
}
