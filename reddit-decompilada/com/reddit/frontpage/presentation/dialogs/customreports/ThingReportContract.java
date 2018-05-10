package com.reddit.frontpage.presentation.dialogs.customreports;

import android.content.Context;
import com.google.gson.Gson;
import com.reddit.datalibrary.frontpage.redditauth.api.errors.GenericError;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.nav.Screens;
import com.reddit.frontpage.presentation.common.BasePresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.HttpException;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lcom/reddit/frontpage/presentation/dialogs/customreports/ThingReportContract;", "", "ErrorType", "Presenter", "View", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ThingReportContract.kt */
public interface ThingReportContract {

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/reddit/frontpage/presentation/dialogs/customreports/ThingReportContract$ErrorType;", "", "(Ljava/lang/String;I)V", "BLOCK", "REPORT", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ThingReportContract.kt */
    private enum ErrorType {
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J \u0010\u0012\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/reddit/frontpage/presentation/dialogs/customreports/ThingReportContract$View;", "", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "screen", "Lcom/reddit/frontpage/nav/Screen;", "getScreen", "()Lcom/reddit/frontpage/nav/Screen;", "onReportError", "", "error", "", "onUserBlockError", "onUserBlocked", "username", "", "showError", "dafaultMessage", "", "type", "Lcom/reddit/frontpage/presentation/dialogs/customreports/ThingReportContract$ErrorType;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ThingReportContract.kt */
    public interface View {

        @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
        /* compiled from: ThingReportContract.kt */
        public static final class DefaultImpls {
            public static void m22822a(View view, String str) {
                Intrinsics.m26847b(str, "username");
                view = Screens.m22629a(view.mo6458e(), view.aa_().getString(C1761R.string.fmt_blocked_user, new Object[]{str}), 0);
                if (view != null) {
                    view.a();
                }
            }

            public static void m22823a(View view, Throwable th) {
                Intrinsics.m26847b(th, "error");
                m22824a(view, th, C1761R.string.error_report_user, ErrorType.f20530b);
            }

            public static void m22825b(View view, Throwable th) {
                Intrinsics.m26847b(th, "error");
                m22824a(view, th, C1761R.string.error_block_user, ErrorType.f20529a);
            }

            private static void m22824a(View view, Throwable th, int i, ErrorType errorType) {
                if (th instanceof HttpException) {
                    i = new Gson();
                    th = ((HttpException) th).a().c();
                    th = ((GenericError) i.a(th != null ? th.string() : null, GenericError.class)).a;
                } else {
                    th = view.aa_().getString(i);
                    Intrinsics.m26843a((Object) th, "context.getString(dafaultMessage)");
                }
                if (!(Intrinsics.m26845a((Object) errorType, ErrorType.f20529a) == 0 || Intrinsics.m26845a((Object) r2, view.aa_().getString(C1761R.string.error_not_found)) == 0)) {
                    th = view.aa_().getString(C1761R.string.error_user_doesn_not_exist);
                    Intrinsics.m26843a((Object) th, "context.getString(R.stri…ror_user_doesn_not_exist)");
                }
                view = Screens.m22629a(view.mo6458e(), (CharSequence) th, 0);
                if (view != null) {
                    view.a();
                }
            }
        }

        void mo4814a(Throwable th);

        Context aa_();

        void mo4815b(String str);

        void mo4816b(Throwable th);

        Screen mo6458e();
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J0\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fH&¨\u0006\r"}, d2 = {"Lcom/reddit/frontpage/presentation/dialogs/customreports/ThingReportContract$Presenter;", "Lcom/reddit/frontpage/presentation/common/BasePresenter;", "findAndBlockUser", "", "username", "", "reportLink", "thing", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/Thing;", "reason", "siteReason", "onLinkReported", "Lkotlin/Function0;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    public interface Presenter extends BasePresenter {
    }
}
