package com.reddit.frontpage.presentation.navdrawer;

import android.content.Context;
import android.content.res.ColorStateList;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.reddit.config.GlideApp;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.domain.usecase.AccountInfoUseCase.Avatar;
import com.reddit.frontpage.domain.usecase.AccountInfoUseCase.Avatar.AnonymousAvatar;
import com.reddit.frontpage.domain.usecase.AccountInfoUseCase.Avatar.RealAvatar;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import com.reddit.frontpage.presentation.navdrawer.RedditNavHeaderContract.View;
import com.reddit.frontpage.presentation.profile.user.model.UserAccountPresentationModel;
import com.reddit.frontpage.util.AvatarUtilKt;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.kotlin.TextViewsKt;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import com.reddit.frontpage.widgets.profile.AccountStatsView;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016J\b\u0010\u0015\u001a\u00020\u000bH\u0016¨\u0006\u0016"}, d2 = {"Lcom/reddit/frontpage/presentation/navdrawer/RedditNavHeaderView;", "Landroid/support/constraint/ConstraintLayout;", "Lcom/reddit/frontpage/presentation/navdrawer/RedditNavHeaderContract$View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "setAccount", "", "account", "Lcom/reddit/frontpage/presentation/profile/user/model/UserAccountPresentationModel;", "setAvatar", "avatar", "Lcom/reddit/frontpage/domain/usecase/AccountInfoUseCase$Avatar;", "setUsername", "username", "", "showSignUpMessage", "showUserProfile", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RedditNavHeaderView.kt */
public final class RedditNavHeaderView extends ConstraintLayout implements View {
    private HashMap f28705h;

    public RedditNavHeaderView(Context context) {
        this(context, null, 0, 6, null);
    }

    public RedditNavHeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    private android.view.View m29819a(int i) {
        if (this.f28705h == null) {
            this.f28705h = new HashMap();
        }
        android.view.View view = (android.view.View) this.f28705h.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        view = findViewById(i);
        this.f28705h.put(Integer.valueOf(i), view);
        return view;
    }

    public /* synthetic */ RedditNavHeaderView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i2 & 2) != null) {
            attributeSet = null;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        this(context, attributeSet, i);
    }

    public RedditNavHeaderView(Context context, AttributeSet attributeSet, int i) {
        Intrinsics.m26847b(context, "context");
        super(context, attributeSet, i);
        ConstraintLayout.inflate(context, C1761R.layout.merge_activity_main_drawer_profile_header, this);
        Object obj = (Button) m29819a(C1761R.id.nav_user_name);
        Intrinsics.m26843a(obj, "nav_user_name");
        TextView textView = (TextView) obj;
        ColorStateList h = ResourcesUtil.m22738h(context, (int) C1761R.attr.rdt_nav_icon_color);
        if (h == null) {
            Intrinsics.m26842a();
        }
        TextViewsKt.m24096a(textView, h);
    }

    public final void setAccount(UserAccountPresentationModel userAccountPresentationModel) {
        Intrinsics.m26847b(userAccountPresentationModel, "account");
        ((AccountStatsView) m29819a(C1761R.id.nav_user_stats_view)).m30526a(userAccountPresentationModel);
    }

    public final void setUsername(String str) {
        Intrinsics.m26847b(str, "username");
        Object obj = (Button) m29819a(C1761R.id.nav_user_name);
        Intrinsics.m26843a(obj, "nav_user_name");
        obj.setText(Util.m23960a((int) C1761R.string.fmt_u_name, str));
    }

    public final void setAvatar(Avatar avatar) {
        Intrinsics.m26847b(avatar, "avatar");
        if (avatar instanceof RealAvatar) {
            Object obj = (ImageView) m29819a(C1761R.id.nav_drawer_avatar);
            Intrinsics.m26843a(obj, "nav_drawer_avatar");
            AvatarUtilKt.m23659a(obj, ((RealAvatar) avatar).f27959a, null, null);
            return;
        }
        if (Intrinsics.m26845a((Object) avatar, AnonymousAvatar.f27958a) != null) {
            Intrinsics.m26843a(GlideApp.a(getContext()).b(Integer.valueOf(C1761R.drawable.ic_icon_redditor)).into((ImageView) m29819a(C1761R.id.nav_drawer_avatar)), "GlideApp.with(context)\n … .into(nav_drawer_avatar)");
        }
    }

    public final void U_() {
        Object obj = (Button) m29819a(C1761R.id.nav_user_name);
        Intrinsics.m26843a(obj, "nav_user_name");
        ViewsKt.m24107c((android.view.View) obj);
        obj = (AccountStatsView) m29819a(C1761R.id.nav_user_stats_view);
        Intrinsics.m26843a(obj, "nav_user_stats_view");
        ViewsKt.m24107c((android.view.View) obj);
        obj = (TextView) m29819a(C1761R.id.nav_sign_up_description);
        Intrinsics.m26843a(obj, "nav_sign_up_description");
        ViewsKt.m24109d((android.view.View) obj);
    }

    public final void mo4916b() {
        Object obj = (Button) m29819a(C1761R.id.nav_user_name);
        Intrinsics.m26843a(obj, "nav_user_name");
        ViewsKt.m24109d((android.view.View) obj);
        obj = (AccountStatsView) m29819a(C1761R.id.nav_user_stats_view);
        Intrinsics.m26843a(obj, "nav_user_stats_view");
        ViewsKt.m24109d((android.view.View) obj);
        obj = (TextView) m29819a(C1761R.id.nav_sign_up_description);
        Intrinsics.m26843a(obj, "nav_sign_up_description");
        ViewsKt.m24107c((android.view.View) obj);
        ImageView imageView = (ImageView) m29819a(C1761R.id.nav_drawer_avatar);
        Context context = getContext();
        Intrinsics.m26843a((Object) context, "context");
        imageView.setImageDrawable(ResourcesUtil.m22734f(context, (int) C1761R.drawable.ic_icon_redditor));
    }
}
