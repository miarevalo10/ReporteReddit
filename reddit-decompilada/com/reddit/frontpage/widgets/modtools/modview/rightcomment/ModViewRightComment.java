package com.reddit.frontpage.widgets.modtools.modview.rightcomment;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.reddit.common.ThingType;
import com.reddit.common.ThingUtil;
import com.reddit.datalibrary.frontpage.data.feature.settings.InternalSettings;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.requests.models.v1.Comment;
import com.reddit.datalibrary.frontpage.requests.models.v1.Subreddit;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.builders.ModEventBuilder;
import com.reddit.frontpage.commons.analytics.builders.ModNoun;
import com.reddit.frontpage.di.component.DaggerModQueueRightCommentComponent;
import com.reddit.frontpage.di.module.ModQueueRightCommentViewModule;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.nav.Screens;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import com.reddit.frontpage.presentation.common.ui.view.listoptions.ListOptionAction;
import com.reddit.frontpage.presentation.common.ui.view.listoptions.ListOptionsDialog;
import com.reddit.frontpage.presentation.common.ui.view.listoptions.ListOptionsDialogAdapter;
import com.reddit.frontpage.util.ModCacheComments;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.widgets.LinkFooterView.OnModActionCompletedListener;
import com.reddit.frontpage.widgets.modtools.modview.ModViewBase;
import com.reddit.frontpage.widgets.modtools.modview.rightcomment.ModQueueRightCommentContract.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010$\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\b\u0010%\u001a\u00020\u001fH\u0016J\b\u0010&\u001a\u00020\u001fH\u0016J\u000e\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020)J\u0006\u0010*\u001a\u00020\u001fR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006+"}, d2 = {"Lcom/reddit/frontpage/widgets/modtools/modview/rightcomment/ModViewRightComment;", "Lcom/reddit/frontpage/widgets/modtools/modview/ModViewBase;", "Lcom/reddit/frontpage/widgets/modtools/modview/rightcomment/ModQueueRightCommentContract$View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "distinguishDialog", "Lcom/reddit/frontpage/presentation/common/ui/view/listoptions/ListOptionsDialog;", "distinguishView", "Landroid/widget/ImageView;", "getDistinguishView", "()Landroid/widget/ImageView;", "distinguishView$delegate", "Lkotlin/Lazy;", "modActionCompleteListener", "Lcom/reddit/frontpage/widgets/LinkFooterView$OnModActionCompletedListener;", "getModActionCompleteListener", "()Lcom/reddit/frontpage/widgets/LinkFooterView$OnModActionCompletedListener;", "setModActionCompleteListener", "(Lcom/reddit/frontpage/widgets/LinkFooterView$OnModActionCompletedListener;)V", "presenter", "Lcom/reddit/frontpage/widgets/modtools/modview/rightcomment/ModViewRightCommentPresenter;", "getPresenter", "()Lcom/reddit/frontpage/widgets/modtools/modview/rightcomment/ModViewRightCommentPresenter;", "setPresenter", "(Lcom/reddit/frontpage/widgets/modtools/modview/rightcomment/ModViewRightCommentPresenter;)V", "distinguishComment", "", "subreddit", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/Subreddit;", "distinguish", "", "distinguishStickyComment", "onModError", "onModSuccess", "setCommentCache", "modCache", "Lcom/reddit/frontpage/util/ModCacheComments;", "setupDistinguishView", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ModViewRightComment.kt */
public final class ModViewRightComment extends ModViewBase implements View {
    static final /* synthetic */ KProperty[] f34541d = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(ModViewRightComment.class), "distinguishView", "getDistinguishView()Landroid/widget/ImageView;"))};
    @Inject
    public ModViewRightCommentPresenter f34542e;
    public OnModActionCompletedListener f34543f;
    private final Lazy f34544g;
    private ListOptionsDialog f34545h;
    private HashMap f34546i;

    public ModViewRightComment(Context context) {
        this(context, null, 0, 6, null);
    }

    public ModViewRightComment(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    private final ImageView getDistinguishView() {
        return (ImageView) this.f34544g.mo5678b();
    }

    public final android.view.View mo5068a(int i) {
        if (this.f34546i == null) {
            this.f34546i = new HashMap();
        }
        android.view.View view = (android.view.View) this.f34546i.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        view = findViewById(i);
        this.f34546i.put(Integer.valueOf(i), view);
        return view;
    }

    public /* synthetic */ ModViewRightComment(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i2 & 2) != null) {
            attributeSet = null;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        this(context, attributeSet, i);
    }

    public ModViewRightComment(Context context, AttributeSet attributeSet, int i) {
        Intrinsics.m26847b(context, "context");
        super(context, attributeSet, i);
        this.f34544g = LazyKt.m26777a((Function0) new ModViewRightComment$distinguishView$2(this));
        DaggerModQueueRightCommentComponent.m29181a().m22131a(FrontpageApplication.m28875k()).m22132a(new ModQueueRightCommentViewModule(this)).m22133a().mo4686a(this);
        android.view.View.inflate(context, C1761R.layout.mod_view_right_comment, this);
    }

    public final ModViewRightCommentPresenter getPresenter() {
        ModViewRightCommentPresenter modViewRightCommentPresenter = this.f34542e;
        if (modViewRightCommentPresenter == null) {
            Intrinsics.m26844a("presenter");
        }
        return modViewRightCommentPresenter;
    }

    public final void setPresenter(ModViewRightCommentPresenter modViewRightCommentPresenter) {
        Intrinsics.m26847b(modViewRightCommentPresenter, "<set-?>");
        this.f34542e = modViewRightCommentPresenter;
    }

    public final OnModActionCompletedListener getModActionCompleteListener() {
        OnModActionCompletedListener onModActionCompletedListener = this.f34543f;
        if (onModActionCompletedListener == null) {
            Intrinsics.m26844a("modActionCompleteListener");
        }
        return onModActionCompletedListener;
    }

    public final void setModActionCompleteListener(OnModActionCompletedListener onModActionCompletedListener) {
        Intrinsics.m26847b(onModActionCompletedListener, "<set-?>");
        this.f34543f = onModActionCompletedListener;
    }

    public final void setCommentCache(ModCacheComments modCacheComments) {
        Intrinsics.m26847b(modCacheComments, "modCache");
        ModViewRightCommentPresenter modViewRightCommentPresenter = this.f34542e;
        if (modViewRightCommentPresenter == null) {
            Intrinsics.m26844a("presenter");
        }
        Intrinsics.m26847b(modCacheComments, "<set-?>");
        modViewRightCommentPresenter.f34547a = modCacheComments;
        setModCache(modCacheComments);
        m35319c();
    }

    private void m35319c() {
        if (getComment() != null) {
            Object b = SessionManager.b();
            Intrinsics.m26843a(b, "SessionManager.getInstance()");
            b = b.d().getName();
            Comment comment = getComment();
            if (comment == null) {
                Intrinsics.m26842a();
            }
            if (Intrinsics.m26845a(b, comment.c())) {
                boolean z;
                Object f;
                Comment comment2;
                Object a;
                ListOptionsDialog listOptionsDialog;
                ListOptionsDialogAdapter listOptionsDialogAdapter;
                ListOptionsDialog listOptionsDialog2;
                ListOptionsDialogAdapter listOptionsDialogAdapter2;
                Context context;
                getDistinguishView().setVisibility(0);
                ImageView distinguishView = getDistinguishView();
                Context context2 = getContext();
                Intrinsics.m26843a((Object) context2, "context");
                Drawable drawable = getDistinguishView().getDrawable();
                Intrinsics.m26843a((Object) drawable, "distinguishView.drawable");
                distinguishView.setImageDrawable(ResourcesUtil.m22733e(context2, drawable));
                List arrayList = new ArrayList();
                ModCacheComments modCache = getModCache();
                Comment comment3 = getComment();
                String str = null;
                String name = comment3 != null ? comment3.getName() : null;
                Comment comment4 = getComment();
                if (comment4 == null) {
                    Intrinsics.m26842a();
                }
                boolean distinguishState = modCache.getDistinguishState(name, comment4.l());
                ModCacheComments modCache2 = getModCache();
                comment4 = getComment();
                String name2 = comment4 != null ? comment4.getName() : null;
                Comment comment5 = getComment();
                if (comment5 == null) {
                    Intrinsics.m26842a();
                }
                boolean stickyState = modCache2.getStickyState(name2, comment5.k());
                ModCacheComments modCache3 = getModCache();
                comment5 = getComment();
                if (comment5 != null) {
                    str = comment5.getName();
                }
                comment5 = getComment();
                if (comment5 == null) {
                    Intrinsics.m26842a();
                }
                if (modCache3.getDistinguishState(str, comment5.m())) {
                    Comment comment6 = getComment();
                    if (comment6 == null) {
                        Intrinsics.m26842a();
                    }
                    if (comment6.m()) {
                        z = true;
                        if (distinguishState) {
                            f = Util.m24027f((int) C1761R.string.action_distinguish_comment);
                        } else {
                            f = Util.m24027f((int) C1761R.string.action_undistinguish_comment);
                        }
                        Intrinsics.m26843a(f, "distTitle");
                        arrayList.add(new ListOptionAction(f, Integer.valueOf(C1761R.drawable.ic_icon_distinguish), new ModViewRightComment$setupDistinguishView$distAction$1(this, distinguishState, stickyState)));
                        comment2 = getComment();
                        if (comment2 == null) {
                            Intrinsics.m26842a();
                        }
                        a = comment2.a();
                        Intrinsics.m26843a(a, "comment!!.parentId");
                        if (Intrinsics.m26845a(ThingUtil.a(a), ThingType.c)) {
                            a = new ModViewRightComment$setupDistinguishView$1(stickyState).m37853a();
                            Intrinsics.m26843a(a, "getStickyTitle()");
                            arrayList.add(new ListOptionAction(a, Integer.valueOf(C1761R.drawable.ic_icon_pin), new ModViewRightComment$setupDistinguishView$stickyAction$1(this, stickyState)));
                        }
                        if (InternalSettings.a().o()) {
                            if (z) {
                                a = Util.m24027f((int) C1761R.string.action_distinguish_as_admin);
                            } else {
                                a = Util.m24027f((int) C1761R.string.action_undistinguish_as_admin);
                            }
                            Intrinsics.m26843a(a, "distinguishAsAdminTitle");
                            arrayList.add(new ListOptionAction(a, Integer.valueOf(C1761R.drawable.ind_admin), new C2907x412d4058(this, z)));
                        }
                        if (this.f34545h == null) {
                            listOptionsDialog = this.f34545h;
                            if (listOptionsDialog != null) {
                                listOptionsDialogAdapter = listOptionsDialog.f39074e;
                                if (listOptionsDialogAdapter != null) {
                                    Intrinsics.m26847b(arrayList, "<set-?>");
                                    listOptionsDialogAdapter.f28087a = arrayList;
                                }
                            }
                            listOptionsDialog2 = this.f34545h;
                            if (listOptionsDialog2 != null) {
                                listOptionsDialogAdapter2 = listOptionsDialog2.f39074e;
                                if (listOptionsDialogAdapter2 != null) {
                                    listOptionsDialogAdapter2.e();
                                }
                            }
                            return;
                        }
                        context = getContext();
                        Intrinsics.m26843a((Object) context, "context");
                        this.f34545h = new ListOptionsDialog(context, arrayList, 0, 12);
                        getDistinguishView().setOnClickListener(new ModViewRightComment$setupDistinguishView$2(this));
                        return;
                    }
                }
                z = false;
                if (distinguishState) {
                    f = Util.m24027f((int) C1761R.string.action_distinguish_comment);
                } else {
                    f = Util.m24027f((int) C1761R.string.action_undistinguish_comment);
                }
                Intrinsics.m26843a(f, "distTitle");
                arrayList.add(new ListOptionAction(f, Integer.valueOf(C1761R.drawable.ic_icon_distinguish), new ModViewRightComment$setupDistinguishView$distAction$1(this, distinguishState, stickyState)));
                comment2 = getComment();
                if (comment2 == null) {
                    Intrinsics.m26842a();
                }
                a = comment2.a();
                Intrinsics.m26843a(a, "comment!!.parentId");
                if (Intrinsics.m26845a(ThingUtil.a(a), ThingType.c)) {
                    a = new ModViewRightComment$setupDistinguishView$1(stickyState).m37853a();
                    Intrinsics.m26843a(a, "getStickyTitle()");
                    arrayList.add(new ListOptionAction(a, Integer.valueOf(C1761R.drawable.ic_icon_pin), new ModViewRightComment$setupDistinguishView$stickyAction$1(this, stickyState)));
                }
                if (InternalSettings.a().o()) {
                    if (z) {
                        a = Util.m24027f((int) C1761R.string.action_distinguish_as_admin);
                    } else {
                        a = Util.m24027f((int) C1761R.string.action_undistinguish_as_admin);
                    }
                    Intrinsics.m26843a(a, "distinguishAsAdminTitle");
                    arrayList.add(new ListOptionAction(a, Integer.valueOf(C1761R.drawable.ind_admin), new C2907x412d4058(this, z)));
                }
                if (this.f34545h == null) {
                    context = getContext();
                    Intrinsics.m26843a((Object) context, "context");
                    this.f34545h = new ListOptionsDialog(context, arrayList, 0, 12);
                    getDistinguishView().setOnClickListener(new ModViewRightComment$setupDistinguishView$2(this));
                    return;
                }
                listOptionsDialog = this.f34545h;
                if (listOptionsDialog != null) {
                    listOptionsDialogAdapter = listOptionsDialog.f39074e;
                    if (listOptionsDialogAdapter != null) {
                        Intrinsics.m26847b(arrayList, "<set-?>");
                        listOptionsDialogAdapter.f28087a = arrayList;
                    }
                }
                listOptionsDialog2 = this.f34545h;
                if (listOptionsDialog2 != null) {
                    listOptionsDialogAdapter2 = listOptionsDialog2.f39074e;
                    if (listOptionsDialogAdapter2 != null) {
                        listOptionsDialogAdapter2.e();
                    }
                }
                return;
            }
            getDistinguishView().setVisibility(8);
        }
    }

    public final void mo6538a() {
        m35319c();
        OnModActionCompletedListener onModActionCompletedListener = this.f34543f;
        if (onModActionCompletedListener == null) {
            Intrinsics.m26844a("modActionCompleteListener");
        }
        onModActionCompletedListener.mo4891a();
        ListOptionsDialog listOptionsDialog = this.f34545h;
        if (listOptionsDialog != null) {
            listOptionsDialog.dismiss();
        }
    }

    public final void mo6539b() {
        ListOptionsDialog listOptionsDialog = this.f34545h;
        if (listOptionsDialog != null) {
            listOptionsDialog.dismiss();
        }
        Screen a = Routing.m22617a(getContext());
        if (a != null) {
            Screens.m22628a(a, (int) C1761R.string.error_distinguish_comment_failure).a();
        }
    }

    public static final /* synthetic */ void m35318a(ModViewRightComment modViewRightComment, Subreddit subreddit, boolean z) {
        if (modViewRightComment.getLink() != null && modViewRightComment.getComment() != null) {
            ModEventBuilder modEventBuilder = (ModEventBuilder) ((ModEventBuilder) AppAnalytics.m21880q().m21888a("modmode")).m21892b(ModEventBuilder.f27450a);
            if (z) {
                z = ModNoun.f20054m.f20068M;
            } else {
                z = ModNoun.f20056o.f20068M;
            }
            ModEventBuilder modEventBuilder2 = (ModEventBuilder) modEventBuilder.m21895c(z);
            String name = subreddit.getName();
            Object b = subreddit.b();
            Intrinsics.m26843a(b, "subreddit.displayName");
            ModEventBuilder modEventBuilder3 = (ModEventBuilder) modEventBuilder2.m21889a(name, b);
            z = modViewRightComment.getLink();
            if (!z) {
                Intrinsics.m26842a();
            }
            z = z.getName();
            name = String.valueOf(Util.m23952a(modViewRightComment.getLink()));
            Link link = modViewRightComment.getLink();
            if (link == null) {
                Intrinsics.m26842a();
            }
            Object title = link.getTitle();
            Intrinsics.m26843a(title, "link!!.title");
            modEventBuilder3 = (ModEventBuilder) modEventBuilder3.m21890a(z, name, title);
            z = modViewRightComment.getComment();
            if (!z) {
                Intrinsics.m26842a();
            }
            z = z.getName();
            modViewRightComment = modViewRightComment.getComment();
            if (modViewRightComment == null) {
                Intrinsics.m26842a();
            }
            Object j = modViewRightComment.j();
            Intrinsics.m26843a(j, "comment!!.linkId");
            ((ModEventBuilder) modEventBuilder3.m21893b(z, j)).m21891a();
        }
    }

    public static final /* synthetic */ void m35317a(ModViewRightComment modViewRightComment, Subreddit subreddit) {
        if (modViewRightComment.getLink() != null && modViewRightComment.getComment() != null) {
            ModEventBuilder modEventBuilder = (ModEventBuilder) ((ModEventBuilder) ((ModEventBuilder) AppAnalytics.m21880q().m21888a("modmode")).m21892b(ModEventBuilder.f27450a)).m21895c(ModNoun.f20055n.f20068M);
            String name = subreddit.getName();
            Object b = subreddit.b();
            Intrinsics.m26843a(b, "subreddit.displayName");
            ModEventBuilder modEventBuilder2 = (ModEventBuilder) modEventBuilder.m21889a(name, b);
            Link link = modViewRightComment.getLink();
            if (link == null) {
                Intrinsics.m26842a();
            }
            String name2 = link.getName();
            name = String.valueOf(Util.m23952a(modViewRightComment.getLink()));
            Link link2 = modViewRightComment.getLink();
            if (link2 == null) {
                Intrinsics.m26842a();
            }
            Object title = link2.getTitle();
            Intrinsics.m26843a(title, "link!!.title");
            modEventBuilder2 = (ModEventBuilder) modEventBuilder2.m21890a(name2, name, title);
            Comment comment = modViewRightComment.getComment();
            if (comment == null) {
                Intrinsics.m26842a();
            }
            name2 = comment.getName();
            modViewRightComment = modViewRightComment.getComment();
            if (modViewRightComment == null) {
                Intrinsics.m26842a();
            }
            Object j = modViewRightComment.j();
            Intrinsics.m26843a(j, "comment!!.linkId");
            ((ModEventBuilder) modEventBuilder2.m21893b(name2, j)).m21891a();
        }
    }
}
