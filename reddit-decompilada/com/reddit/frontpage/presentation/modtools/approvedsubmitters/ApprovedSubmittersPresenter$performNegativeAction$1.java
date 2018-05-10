package com.reddit.frontpage.presentation.modtools.approvedsubmitters;

import com.reddit.frontpage.C1761R;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import okhttp3.ResponseBody;
import retrofit2.Response;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "Lretrofit2/Response;", "Lokhttp3/ResponseBody;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: ApprovedSubmittersPresenter.kt */
final class ApprovedSubmittersPresenter$performNegativeAction$1<T> implements Consumer<Response<ResponseBody>> {
    final /* synthetic */ ApprovedSubmittersPresenter f28550a;

    ApprovedSubmittersPresenter$performNegativeAction$1(ApprovedSubmittersPresenter approvedSubmittersPresenter) {
        this.f28550a = approvedSubmittersPresenter;
    }

    public final /* synthetic */ void accept(Object obj) {
        this.f28550a.f36965a.mo7390c();
        this.f28550a.f36965a.mo7387b(this.f28550a.f36965a.mo7386b().f20859b.getUsername(), C1761R.string.mod_tools_action_removed_success);
    }
}
