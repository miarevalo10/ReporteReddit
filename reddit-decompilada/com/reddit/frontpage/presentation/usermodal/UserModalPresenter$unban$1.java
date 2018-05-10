package com.reddit.frontpage.presentation.usermodal;

import com.reddit.frontpage.C1761R;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import okhttp3.ResponseBody;
import retrofit2.Response;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "result", "Lretrofit2/Response;", "Lokhttp3/ResponseBody;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: UserModalPresenter.kt */
final class UserModalPresenter$unban$1<T> implements Consumer<Response<ResponseBody>> {
    final /* synthetic */ UserModalPresenter f28811a;

    UserModalPresenter$unban$1(UserModalPresenter userModalPresenter) {
        this.f28811a = userModalPresenter;
    }

    public final /* synthetic */ void accept(Object obj) {
        this.f28811a.f34178a.mo4934a(UserModalAction.f20987b, C1761R.string.mod_tools_action_unban_success);
    }
}
