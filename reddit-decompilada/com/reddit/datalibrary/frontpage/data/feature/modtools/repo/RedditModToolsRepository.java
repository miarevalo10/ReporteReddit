package com.reddit.datalibrary.frontpage.data.feature.modtools.repo;

import com.google.gson.Gson;
import com.reddit.common.rx.BackgroundThread;
import com.reddit.common.rx.Thread;
import com.reddit.datalibrary.frontpage.data.feature.modtools.datasource.RemoteModToolsDataSource;
import com.reddit.datalibrary.frontpage.data.feature.modtools.datasource.RemoteModToolsDataSource.DefaultImpls;
import com.reddit.datalibrary.frontpage.data.model.ApprovedSubmittersResponse;
import com.reddit.datalibrary.frontpage.data.model.BannedUsersResponse;
import com.reddit.datalibrary.frontpage.data.model.ModToolsPostResponse;
import com.reddit.datalibrary.frontpage.data.model.ModToolsUserModel;
import com.reddit.datalibrary.frontpage.data.model.ModeratorsResponse;
import com.reddit.datalibrary.frontpage.data.model.MutedUsersResponse;
import com.reddit.datalibrary.frontpage.data.model.SubredditRulesResponse;
import com.reddit.frontpage.domain.repository.ModToolsRepository;
import com.reddit.frontpage.presentation.modtools.ban.add.bottomsheet.BanInfoModel;
import com.reddit.frontpage.util.kotlin.SinglesKt;
import io.reactivex.Single;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Response;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001?B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016J&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001c\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\b2\u0006\u0010\u0015\u001a\u00020\u000bH\u0016J$\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0017\u001a\u00020\u000b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0019H\u0016J\u001c\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J&\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000bH\u0016J \u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\b2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u000bH\u0016J \u0010 \u001a\b\u0012\u0004\u0012\u00020!0\b2\u0006\u0010\"\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u000bH\u0016J \u0010#\u001a\b\u0012\u0004\u0012\u00020$0\b2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u000bH\u0016J \u0010%\u001a\b\u0012\u0004\u0012\u00020\u001e0\b2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u000bH\u0016J \u0010&\u001a\b\u0012\u0004\u0012\u00020'0\b2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0016\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J&\u0010*\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000bH\u0016J(\u0010+\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\b\u0010,\u001a\u0004\u0018\u00010\u000bH\u0016J$\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\b2\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020/H\u0016J$\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020/H\u0016J,\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\b2\u0006\u00102\u001a\u00020\u000b2\u0006\u00103\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u000bH\u0016J\u001e\u00105\u001a\b\u0012\u0004\u0012\u00020\u001e0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016J\u001e\u00106\u001a\b\u0012\u0004\u0012\u00020!0\b2\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016J\u001e\u00107\u001a\b\u0012\u0004\u0012\u00020$0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016J\u001e\u00108\u001a\b\u0012\u0004\u0012\u00020\u001e0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016J\u001e\u00109\u001a\b\u0012\u0004\u0012\u00020'0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016J$\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020/H\u0016J,\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020=H\u0016J$\u0010>\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020/H\u0016J$\u0010>\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/modtools/repo/RedditModToolsRepository;", "Lcom/reddit/frontpage/domain/repository/ModToolsRepository;", "backgroundThread", "Lcom/reddit/common/rx/BackgroundThread;", "remote", "Lcom/reddit/datalibrary/frontpage/data/feature/modtools/datasource/RemoteModToolsDataSource;", "(Lcom/reddit/common/rx/BackgroundThread;Lcom/reddit/datalibrary/frontpage/data/feature/modtools/datasource/RemoteModToolsDataSource;)V", "acceptModInvite", "Lio/reactivex/Single;", "Lcom/reddit/datalibrary/frontpage/data/model/ModToolsPostResponse;", "subredditName", "", "addApprovedSubmitter", "username", "banUser", "subredditId", "banModel", "Lcom/reddit/frontpage/presentation/modtools/ban/add/bottomsheet/BanInfoModel;", "blockUser", "Lretrofit2/Response;", "Lokhttp3/ResponseBody;", "accountId", "bulkModAction", "action", "ids", "", "declineModInvite", "editModerator", "permissions", "getAllModerators", "Lcom/reddit/datalibrary/frontpage/data/model/ModeratorsResponse;", "after", "getApprovedSubmitters", "Lcom/reddit/datalibrary/frontpage/data/model/ApprovedSubmittersResponse;", "subreddditName", "getBannedUsers", "Lcom/reddit/datalibrary/frontpage/data/model/BannedUsersResponse;", "getEditableModerators", "getMutedUsers", "Lcom/reddit/datalibrary/frontpage/data/model/MutedUsersResponse;", "getSubredditRules", "Lcom/reddit/datalibrary/frontpage/data/model/SubredditRulesResponse;", "inviteModerator", "muteUser", "modNote", "removeApprovedSubmitter", "user", "Lcom/reddit/datalibrary/frontpage/data/model/ModToolsUserModel;", "removeModerator", "report", "thingId", "reason", "siteReason", "searchAllModerators", "searchApprovedSubmitter", "searchBannedUser", "searchEditableModerators", "searchMutedUser", "unbanUser", "userId", "type", "Lcom/reddit/datalibrary/frontpage/data/feature/modtools/repo/RedditModToolsRepository$ModToolsActionType;", "unmuteUser", "ModToolsActionType", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RedditModToolsRepository.kt */
public final class RedditModToolsRepository implements ModToolsRepository {
    private final BackgroundThread f16100a;
    private final RemoteModToolsDataSource f16101b;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/modtools/repo/RedditModToolsRepository$ModToolsActionType;", "", "action", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getAction", "()Ljava/lang/String;", "toString", "TYPE_BAN", "TYPE_MUTE", "TYPE_CONTRIBUTOR", "TYPE_MODERATOR", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: RedditModToolsRepository.kt */
    public enum ModToolsActionType {
        ;
        
        final String f10716e;

        private ModToolsActionType(String str) {
            Intrinsics.b(str, "action");
            this.f10716e = str;
        }

        public final String toString() {
            return this.f10716e;
        }
    }

    public RedditModToolsRepository(BackgroundThread backgroundThread, RemoteModToolsDataSource remoteModToolsDataSource) {
        Intrinsics.b(backgroundThread, "backgroundThread");
        Intrinsics.b(remoteModToolsDataSource, "remote");
        this.f16100a = backgroundThread;
        this.f16101b = remoteModToolsDataSource;
    }

    public final Single<BannedUsersResponse> m16066a(String str, String str2) {
        Intrinsics.b(str, "subredditName");
        return SinglesKt.a(this.f16101b.getBannedUsers(str, str2), (Thread) this.f16100a);
    }

    public final Single<Response<ResponseBody>> m16065a(String str, ModToolsUserModel modToolsUserModel) {
        Intrinsics.b(str, "subredditName");
        Intrinsics.b(modToolsUserModel, "user");
        return SinglesKt.a(this.f16101b.unbanUser(str, modToolsUserModel.getId(), ModToolsActionType.f10711a), (Thread) this.f16100a);
    }

    public final Single<Response<ResponseBody>> m16067a(String str, String str2, ModToolsActionType modToolsActionType) {
        Intrinsics.b(str, "subredditName");
        Intrinsics.b(str2, "userId");
        Intrinsics.b(modToolsActionType, "type");
        return SinglesKt.a(this.f16101b.unbanUser(str, str2, modToolsActionType), (Thread) this.f16100a);
    }

    public final Single<ModToolsPostResponse> m16068a(String str, String str2, BanInfoModel banInfoModel) {
        Intrinsics.b(str, "subredditId");
        Intrinsics.b(str2, "subredditName");
        Intrinsics.b(banInfoModel, "banModel");
        str = new HashMap();
        str.put("type", ModToolsActionType.f10711a.f10716e);
        str.put("name", banInfoModel.a);
        str.put("ban_reason", banInfoModel.b);
        str.put("note", banInfoModel.c);
        str.put("ban_message", banInfoModel.d);
        str.put("api_type", "json");
        return SinglesKt.a(this.f16101b.banUser(str2, (Map) str, banInfoModel.e), (Thread) this.f16100a);
    }

    public final Single<BannedUsersResponse> m16073b(String str, String str2) {
        Intrinsics.b(str, "subredditName");
        Intrinsics.b(str2, "username");
        return SinglesKt.a(this.f16101b.searchBannedUser(str, str2), (Thread) this.f16100a);
    }

    public final Single<ApprovedSubmittersResponse> m16077c(String str, String str2) {
        Intrinsics.b(str, "subreddditName");
        return SinglesKt.a(this.f16101b.getApprovedSubmitters(str, str2), (Thread) this.f16100a);
    }

    public final Single<Response<ResponseBody>> m16072b(String str, ModToolsUserModel modToolsUserModel) {
        Intrinsics.b(str, "subreddditName");
        Intrinsics.b(modToolsUserModel, "user");
        return SinglesKt.a(this.f16101b.removeApprovedSubmitter(str, modToolsUserModel.getId(), ModToolsActionType.f10713c), (Thread) this.f16100a);
    }

    public final Single<ModToolsPostResponse> m16081d(String str, String str2) {
        Intrinsics.b(str, "subredditName");
        Intrinsics.b(str2, "username");
        return SinglesKt.a(DefaultImpls.addApprovedSubmitter$default(this.f16101b, str, str2, ModToolsActionType.f10713c, null, 8, null), (Thread) this.f16100a);
    }

    public final Single<ApprovedSubmittersResponse> m16083e(String str, String str2) {
        Intrinsics.b(str, "subreddditName");
        Intrinsics.b(str2, "username");
        return SinglesKt.a(this.f16101b.searchApprovedSubmitters(str, str2), (Thread) this.f16100a);
    }

    public final Single<MutedUsersResponse> m16084f(String str, String str2) {
        Intrinsics.b(str, "subredditName");
        return SinglesKt.a(this.f16101b.getMutedUsers(str, str2), (Thread) this.f16100a);
    }

    public final Single<Response<ResponseBody>> m16076c(String str, ModToolsUserModel modToolsUserModel) {
        Intrinsics.b(str, "subredditName");
        Intrinsics.b(modToolsUserModel, "user");
        return SinglesKt.a(this.f16101b.unmuteUser(str, modToolsUserModel.getId(), ModToolsActionType.f10712b), (Thread) this.f16100a);
    }

    public final Single<Response<ResponseBody>> m16085g(String str, String str2) {
        Intrinsics.b(str, "subredditName");
        Intrinsics.b(str2, "userId");
        return SinglesKt.a(this.f16101b.unmuteUser(str, str2, ModToolsActionType.f10712b), (Thread) this.f16100a);
    }

    public final Single<ModToolsPostResponse> m16069a(String str, String str2, String str3) {
        Intrinsics.b(str, "subredditName");
        Intrinsics.b(str2, "username");
        return SinglesKt.a(DefaultImpls.muteUser$default(this.f16101b, str, str2, str3, ModToolsActionType.f10712b, null, 16, null), (Thread) this.f16100a);
    }

    public final Single<MutedUsersResponse> m16086h(String str, String str2) {
        Intrinsics.b(str, "subredditName");
        Intrinsics.b(str2, "username");
        return SinglesKt.a(this.f16101b.searchMutedUser(str, str2), (Thread) this.f16100a);
    }

    public final Single<SubredditRulesResponse> m16064a(String str) {
        Intrinsics.b(str, "subredditName");
        return SinglesKt.a(this.f16101b.getSubredditRules(str), this.f16100a);
    }

    public final Single<ModeratorsResponse> m16087i(String str, String str2) {
        Intrinsics.b(str, "subredditName");
        return SinglesKt.a(this.f16101b.getAllModerators(str, str2), (Thread) this.f16100a);
    }

    public final Single<ModeratorsResponse> m16088j(String str, String str2) {
        Intrinsics.b(str, "subredditName");
        return SinglesKt.a(this.f16101b.getEditableModerators(str, str2), (Thread) this.f16100a);
    }

    public final Single<ModeratorsResponse> m16089k(String str, String str2) {
        Intrinsics.b(str, "subredditName");
        Intrinsics.b(str2, "username");
        return SinglesKt.a(this.f16101b.searchAllModerators(str, str2), (Thread) this.f16100a);
    }

    public final Single<ModeratorsResponse> m16090l(String str, String str2) {
        Intrinsics.b(str, "subredditName");
        Intrinsics.b(str2, "username");
        return SinglesKt.a(this.f16101b.searchEditableModerators(str, str2), (Thread) this.f16100a);
    }

    public final Single<Response<ResponseBody>> m16080d(String str, ModToolsUserModel modToolsUserModel) {
        Intrinsics.b(str, "subredditName");
        Intrinsics.b(modToolsUserModel, "user");
        return SinglesKt.a(this.f16101b.removeModerator(str, MapsKt.a(new Pair[]{TuplesKt.a("id", modToolsUserModel.getId()), TuplesKt.a("type", ModToolsActionType.f10714d.f10716e)})), (Thread) this.f16100a);
    }

    public final Single<ModToolsPostResponse> m16074b(String str, String str2, String str3) {
        Intrinsics.b(str, "subredditName");
        Intrinsics.b(str2, "username");
        Intrinsics.b(str3, "permissions");
        return SinglesKt.a(this.f16101b.inviteModerator(str, MapsKt.a(new Pair[]{TuplesKt.a("name", str2), TuplesKt.a("type", ModToolsActionType.f10714d.f10716e), TuplesKt.a("permissions", str3), TuplesKt.a("api_type", "json")})), (Thread) this.f16100a);
    }

    public final Single<ModToolsPostResponse> m16078c(String str, String str2, String str3) {
        Intrinsics.b(str, "subredditName");
        Intrinsics.b(str2, "username");
        Intrinsics.b(str3, "permissions");
        return SinglesKt.a(this.f16101b.editModerator(str, MapsKt.a(new Pair[]{TuplesKt.a("name", str2), TuplesKt.a("type", ModToolsActionType.f10714d.f10716e), TuplesKt.a("permissions", str3), TuplesKt.a("api_type", "json")})), (Thread) this.f16100a);
    }

    public final Single<ModToolsPostResponse> m16070a(String str, List<String> list) {
        Intrinsics.b(str, "action");
        Intrinsics.b(list, "ids");
        StringBuilder stringBuilder = new StringBuilder("{\"ids\":");
        stringBuilder.append(new Gson().m7487b(list));
        stringBuilder.append("}");
        list = RequestBody.create(MediaType.parse("application/json"), stringBuilder.toString());
        RemoteModToolsDataSource remoteModToolsDataSource = this.f16101b;
        Intrinsics.a(list, "body");
        return SinglesKt.a(remoteModToolsDataSource.bulkModActions(str, list), (Thread) this.f16100a);
    }

    public final Single<Response<ResponseBody>> m16082d(String str, String str2, String str3) {
        Intrinsics.b(str, "thingId");
        Intrinsics.b(str2, "reason");
        Intrinsics.b(str3, "siteReason");
        return SinglesKt.a(this.f16101b.report(str, str2, str3), (Thread) this.f16100a);
    }

    public final Single<Response<ResponseBody>> m16071b(String str) {
        Intrinsics.b(str, "accountId");
        return SinglesKt.a(this.f16101b.blockUser(str), this.f16100a);
    }

    public final Single<ModToolsPostResponse> m16075c(String str) {
        Intrinsics.b(str, "subredditName");
        return SinglesKt.a(this.f16101b.acceptModInvite(str, MapsKt.a(TuplesKt.a("api_type", "json"))), this.f16100a);
    }

    public final Single<Response<ResponseBody>> m16079d(String str) {
        Intrinsics.b(str, "subredditName");
        return SinglesKt.a(this.f16101b.declineModInvite(str, MapsKt.a(TuplesKt.a("api_type", "json"))), this.f16100a);
    }
}
