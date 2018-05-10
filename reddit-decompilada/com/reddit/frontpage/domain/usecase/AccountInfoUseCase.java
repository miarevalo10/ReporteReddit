package com.reddit.frontpage.domain.usecase;

import com.reddit.datalibrary.frontpage.data.model.Account;
import com.reddit.frontpage.domain.repository.AccountRepository;
import io.reactivex.Single;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.hockeyapp.android.UpdateFragment;

@Singleton
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u000f\u0010\u0011B\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0014J\f\u0010\f\u001a\u00020\r*\u00020\u000eH\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/reddit/frontpage/domain/usecase/AccountInfoUseCase;", "Lcom/reddit/frontpage/domain/usecase/SingleUseCase;", "Lcom/reddit/frontpage/domain/usecase/AccountInfoUseCase$AccountInfo;", "Lcom/reddit/frontpage/domain/usecase/AccountInfoUseCase$AccountInfoUseCaseParams;", "accountRepository", "Lcom/reddit/frontpage/domain/repository/AccountRepository;", "(Lcom/reddit/frontpage/domain/repository/AccountRepository;)V", "getAccountRepository", "()Lcom/reddit/frontpage/domain/repository/AccountRepository;", "build", "Lio/reactivex/Single;", "params", "getAvatar", "Lcom/reddit/frontpage/domain/usecase/AccountInfoUseCase$Avatar;", "Lcom/reddit/datalibrary/frontpage/data/model/Account;", "AccountInfo", "AccountInfoUseCaseParams", "Avatar", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: AccountInfoUseCase.kt */
public final class AccountInfoUseCase extends SingleUseCase<AccountInfo, AccountInfoUseCaseParams> {
    private final AccountRepository f27961a;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/reddit/frontpage/domain/usecase/AccountInfoUseCase$AccountInfo;", "", "account", "Lcom/reddit/datalibrary/frontpage/data/model/Account;", "avatar", "Lcom/reddit/frontpage/domain/usecase/AccountInfoUseCase$Avatar;", "(Lcom/reddit/datalibrary/frontpage/data/model/Account;Lcom/reddit/frontpage/domain/usecase/AccountInfoUseCase$Avatar;)V", "getAccount", "()Lcom/reddit/datalibrary/frontpage/data/model/Account;", "getAvatar", "()Lcom/reddit/frontpage/domain/usecase/AccountInfoUseCase$Avatar;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: AccountInfoUseCase.kt */
    public static final class AccountInfo {
        public final Account f20264a;
        public final Avatar f20265b;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof AccountInfo) {
                    AccountInfo accountInfo = (AccountInfo) obj;
                    if (Intrinsics.m26845a(this.f20264a, accountInfo.f20264a) && Intrinsics.m26845a(this.f20265b, accountInfo.f20265b)) {
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            Account account = this.f20264a;
            int i = 0;
            int hashCode = (account != null ? account.hashCode() : 0) * 31;
            Avatar avatar = this.f20265b;
            if (avatar != null) {
                i = avatar.hashCode();
            }
            return hashCode + i;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("AccountInfo(account=");
            stringBuilder.append(this.f20264a);
            stringBuilder.append(", avatar=");
            stringBuilder.append(this.f20265b);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public AccountInfo(Account account, Avatar avatar) {
            Intrinsics.m26847b(account, "account");
            Intrinsics.m26847b(avatar, "avatar");
            this.f20264a = account;
            this.f20265b = avatar;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/domain/usecase/AccountInfoUseCase$Avatar;", "", "()V", "AnonymousAvatar", "RealAvatar", "Lcom/reddit/frontpage/domain/usecase/AccountInfoUseCase$Avatar$RealAvatar;", "Lcom/reddit/frontpage/domain/usecase/AccountInfoUseCase$Avatar$AnonymousAvatar;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: AccountInfoUseCase.kt */
    public static abstract class Avatar {

        @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/reddit/frontpage/domain/usecase/AccountInfoUseCase$Avatar$AnonymousAvatar;", "Lcom/reddit/frontpage/domain/usecase/AccountInfoUseCase$Avatar;", "()V", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
        /* compiled from: AccountInfoUseCase.kt */
        public static final class AnonymousAvatar extends Avatar {
            public static final AnonymousAvatar f27958a = new AnonymousAvatar();

            private AnonymousAvatar() {
                super();
            }
        }

        @Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/reddit/frontpage/domain/usecase/AccountInfoUseCase$Avatar$RealAvatar;", "Lcom/reddit/frontpage/domain/usecase/AccountInfoUseCase$Avatar;", "url", "", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
        /* compiled from: AccountInfoUseCase.kt */
        public static final class RealAvatar extends Avatar {
            public final String f27959a;

            public final boolean equals(Object obj) {
                if (this != obj) {
                    if (obj instanceof RealAvatar) {
                        if (Intrinsics.m26845a(this.f27959a, ((RealAvatar) obj).f27959a)) {
                        }
                    }
                    return false;
                }
                return true;
            }

            public final int hashCode() {
                String str = this.f27959a;
                return str != null ? str.hashCode() : 0;
            }

            public final String toString() {
                StringBuilder stringBuilder = new StringBuilder("RealAvatar(url=");
                stringBuilder.append(this.f27959a);
                stringBuilder.append(")");
                return stringBuilder.toString();
            }

            public RealAvatar(String str) {
                Intrinsics.m26847b(str, UpdateFragment.FRAGMENT_URL);
                super();
                this.f27959a = str;
            }
        }

        private Avatar() {
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/reddit/frontpage/domain/usecase/AccountInfoUseCase$AccountInfoUseCaseParams;", "Lcom/reddit/frontpage/domain/usecase/Params;", "username", "", "(Ljava/lang/String;)V", "getUsername", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: AccountInfoUseCase.kt */
    public static final class AccountInfoUseCaseParams implements Params {
        final String f27957a;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof AccountInfoUseCaseParams) {
                    if (Intrinsics.m26845a(this.f27957a, ((AccountInfoUseCaseParams) obj).f27957a)) {
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            String str = this.f27957a;
            return str != null ? str.hashCode() : 0;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("AccountInfoUseCaseParams(username=");
            stringBuilder.append(this.f27957a);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public AccountInfoUseCaseParams(String str) {
            Intrinsics.m26847b(str, "username");
            this.f27957a = str;
        }
    }

    public final /* synthetic */ Single mo4760a(Params params) {
        AccountInfoUseCaseParams accountInfoUseCaseParams = (AccountInfoUseCaseParams) params;
        Intrinsics.m26847b(accountInfoUseCaseParams, "params");
        Object map = this.f27961a.m22394a(accountInfoUseCaseParams.f27957a).map(new AccountInfoUseCase$build$1(this));
        Intrinsics.m26843a(map, "accountRepository.getAcc…tar\n          )\n        }");
        return map;
    }

    @Inject
    public AccountInfoUseCase(AccountRepository accountRepository) {
        Intrinsics.m26847b(accountRepository, "accountRepository");
        this.f27961a = accountRepository;
    }

    public static final /* synthetic */ Avatar m29307a(Account account) {
        Object obj = null;
        if ((((CharSequence) account.getIconUrl()).length() == 0 ? 1 : null) == null) {
            if (account.getUsername().length() == 0) {
                obj = 1;
            }
            if (obj == null) {
                return new RealAvatar(account.getIconUrl());
            }
        }
        return (Avatar) AnonymousAvatar.f27958a;
    }
}
