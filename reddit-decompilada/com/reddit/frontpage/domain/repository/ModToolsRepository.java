package com.reddit.frontpage.domain.repository;

import com.reddit.datalibrary.frontpage.data.feature.modtools.repo.RedditModToolsRepository.ModToolsActionType;
import com.reddit.datalibrary.frontpage.data.model.ApprovedSubmittersResponse;
import com.reddit.datalibrary.frontpage.data.model.BannedUsersResponse;
import com.reddit.datalibrary.frontpage.data.model.ModToolsPostResponse;
import com.reddit.datalibrary.frontpage.data.model.ModToolsUserModel;
import com.reddit.datalibrary.frontpage.data.model.ModeratorsResponse;
import com.reddit.datalibrary.frontpage.data.model.MutedUsersResponse;
import com.reddit.datalibrary.frontpage.data.model.SubredditRulesResponse;
import com.reddit.frontpage.presentation.modtools.ban.add.bottomsheet.BanInfoModel;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import okhttp3.ResponseBody;
import retrofit2.Response;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u001e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H&J&\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH&J\u001c\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u00032\u0006\u0010\u0010\u001a\u00020\u0006H&J$\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0012\u001a\u00020\u00062\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0014H&J\u001c\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J&\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H&J\"\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00032\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0006H&J\"\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00032\u0006\u0010\u001d\u001a\u00020\u00062\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0006H&J\"\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00032\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0006H&J\"\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00190\u00032\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0006H&J\"\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u00032\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0006H&J\u0016\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J&\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H&J(\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010'\u001a\u0004\u0018\u00010\u0006H&J$\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u00032\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010)\u001a\u00020*H&J$\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010)\u001a\u00020*H&J,\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u00032\u0006\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u0006H&J\u001e\u00100\u001a\b\u0012\u0004\u0012\u00020\u00190\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H&J\u001e\u00101\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00032\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H&J\u001e\u00102\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H&J\u001e\u00103\u001a\b\u0012\u0004\u0012\u00020\u00190\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H&J\u001e\u00104\u001a\b\u0012\u0004\u0012\u00020\"0\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H&J$\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010)\u001a\u00020*H&J,\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u00062\u0006\u00107\u001a\u000208H&J$\u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010)\u001a\u00020*H&J$\u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u0006H&¨\u0006:"}, d2 = {"Lcom/reddit/frontpage/domain/repository/ModToolsRepository;", "", "acceptModInvite", "Lio/reactivex/Single;", "Lcom/reddit/datalibrary/frontpage/data/model/ModToolsPostResponse;", "subredditName", "", "addApprovedSubmitter", "username", "banUser", "subredditId", "banModel", "Lcom/reddit/frontpage/presentation/modtools/ban/add/bottomsheet/BanInfoModel;", "blockUser", "Lretrofit2/Response;", "Lokhttp3/ResponseBody;", "accountId", "bulkModAction", "action", "ids", "", "declineModInvite", "editModerator", "permissions", "getAllModerators", "Lcom/reddit/datalibrary/frontpage/data/model/ModeratorsResponse;", "after", "getApprovedSubmitters", "Lcom/reddit/datalibrary/frontpage/data/model/ApprovedSubmittersResponse;", "subreddditName", "getBannedUsers", "Lcom/reddit/datalibrary/frontpage/data/model/BannedUsersResponse;", "getEditableModerators", "getMutedUsers", "Lcom/reddit/datalibrary/frontpage/data/model/MutedUsersResponse;", "getSubredditRules", "Lcom/reddit/datalibrary/frontpage/data/model/SubredditRulesResponse;", "inviteModerator", "muteUser", "modNote", "removeApprovedSubmitter", "user", "Lcom/reddit/datalibrary/frontpage/data/model/ModToolsUserModel;", "removeModerator", "report", "thingId", "reason", "siteReason", "searchAllModerators", "searchApprovedSubmitter", "searchBannedUser", "searchEditableModerators", "searchMutedUser", "unbanUser", "userId", "type", "Lcom/reddit/datalibrary/frontpage/data/feature/modtools/repo/RedditModToolsRepository$ModToolsActionType;", "unmuteUser", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ModToolsRepository.kt */
public interface ModToolsRepository {

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    /* compiled from: ModToolsRepository.kt */
    public static final class DefaultImpls {
    }

    Single<SubredditRulesResponse> m22437a(String str);

    Single<Response<ResponseBody>> m22438a(String str, ModToolsUserModel modToolsUserModel);

    Single<BannedUsersResponse> m22439a(String str, String str2);

    Single<Response<ResponseBody>> m22440a(String str, String str2, ModToolsActionType modToolsActionType);

    Single<ModToolsPostResponse> m22441a(String str, String str2, BanInfoModel banInfoModel);

    Single<ModToolsPostResponse> m22442a(String str, String str2, String str3);

    Single<ModToolsPostResponse> m22443a(String str, List<String> list);

    Single<Response<ResponseBody>> m22444b(String str);

    Single<Response<ResponseBody>> m22445b(String str, ModToolsUserModel modToolsUserModel);

    Single<BannedUsersResponse> m22446b(String str, String str2);

    Single<ModToolsPostResponse> m22447b(String str, String str2, String str3);

    Single<ModToolsPostResponse> m22448c(String str);

    Single<Response<ResponseBody>> m22449c(String str, ModToolsUserModel modToolsUserModel);

    Single<ApprovedSubmittersResponse> m22450c(String str, String str2);

    Single<ModToolsPostResponse> m22451c(String str, String str2, String str3);

    Single<Response<ResponseBody>> m22452d(String str);

    Single<Response<ResponseBody>> m22453d(String str, ModToolsUserModel modToolsUserModel);

    Single<ModToolsPostResponse> m22454d(String str, String str2);

    Single<Response<ResponseBody>> m22455d(String str, String str2, String str3);

    Single<ApprovedSubmittersResponse> m22456e(String str, String str2);

    Single<MutedUsersResponse> m22457f(String str, String str2);

    Single<Response<ResponseBody>> m22458g(String str, String str2);

    Single<MutedUsersResponse> m22459h(String str, String str2);

    Single<ModeratorsResponse> m22460i(String str, String str2);

    Single<ModeratorsResponse> m22461j(String str, String str2);

    Single<ModeratorsResponse> m22462k(String str, String str2);

    Single<ModeratorsResponse> m22463l(String str, String str2);
}
