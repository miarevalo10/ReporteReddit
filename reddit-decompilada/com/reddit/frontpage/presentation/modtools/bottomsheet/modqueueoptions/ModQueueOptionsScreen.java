package com.reddit.frontpage.presentation.modtools.bottomsheet.modqueueoptions;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.reddit.datalibrary.frontpage.requests.models.v1.Thing;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.di.component.DaggerModQueueOptionsComponent;
import com.reddit.frontpage.di.module.ModQueueOptionsViewModule;
import com.reddit.frontpage.presentation.modtools.bottomsheet.modqueueoptions.ModQueueOptionsContract.View;
import com.reddit.frontpage.presentation.modtools.util.ModQueueAction;
import com.reddit.frontpage.ui.BaseScreen;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.kotlin.ContextsKt;
import com.reddit.frontpage.widgets.ModQueueBulkActionItem;
import io.reactivex.subjects.PublishSubject;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0016\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020#2\u0006\u0010+\u001a\u00020'J\u000e\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020.J\b\u0010/\u001a\u00020)H\u0002J\u000e\u00100\u001a\u00020)2\u0006\u0010*\u001a\u00020#J\u0010\u00101\u001a\u00020)2\u0006\u00102\u001a\u00020'H\u0016J\b\u00103\u001a\u00020)H\u0002R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R#\u0010\u001a\u001a\n \u001c*\u0004\u0018\u00010\u001b0\u001b8BX\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001eR\u001e\u0010!\u001a\u0012\u0012\u0004\u0012\u00020#0\"j\b\u0012\u0004\u0012\u00020#`$X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010%\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020'0&X\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/bottomsheet/modqueueoptions/ModQueueOptionsScreen;", "Landroid/widget/FrameLayout;", "Lcom/reddit/frontpage/presentation/modtools/bottomsheet/modqueueoptions/ModQueueOptionsContract$View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "numberCheckedSubject", "Lio/reactivex/subjects/PublishSubject;", "getNumberCheckedSubject", "()Lio/reactivex/subjects/PublishSubject;", "presenter", "Lcom/reddit/frontpage/presentation/modtools/bottomsheet/modqueueoptions/ModQueueOptionsPresenter;", "getPresenter", "()Lcom/reddit/frontpage/presentation/modtools/bottomsheet/modqueueoptions/ModQueueOptionsPresenter;", "setPresenter", "(Lcom/reddit/frontpage/presentation/modtools/bottomsheet/modqueueoptions/ModQueueOptionsPresenter;)V", "screen", "Lcom/reddit/frontpage/ui/BaseScreen;", "getScreen", "()Lcom/reddit/frontpage/ui/BaseScreen;", "setScreen", "(Lcom/reddit/frontpage/ui/BaseScreen;)V", "selectedCount", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getSelectedCount", "()Landroid/widget/TextView;", "selectedCount$delegate", "Lkotlin/Lazy;", "selectedModQueueThings", "Ljava/util/HashSet;", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/Thing;", "Lkotlin/collections/HashSet;", "selectedModQueueThingsLinkTypes", "", "", "addSelectedItem", "", "thing", "linkType", "attachModActionCompleteListener", "listener", "Lcom/reddit/frontpage/widgets/LinkFooterView$OnModActionCompletedListener;", "clearSelectedItems", "removeSelectedItem", "showError", "message", "updateSelectedNumber", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ModQueueOptionsScreen.kt */
public final class ModQueueOptionsScreen extends FrameLayout implements View {
    static final /* synthetic */ KProperty[] f28613a = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(ModQueueOptionsScreen.class), "selectedCount", "getSelectedCount()Landroid/widget/TextView;"))};
    public HashSet<Thing> f28614b;
    public Map<Thing, String> f28615c;
    @Inject
    public ModQueueOptionsPresenter f28616d;
    public BaseScreen f28617e;
    public final PublishSubject<Integer> f28618f;
    HashMap f28619g;
    private final Lazy f28620h;

    public ModQueueOptionsScreen(Context context) {
        this(context, null, 0, 6, null);
    }

    public ModQueueOptionsScreen(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    private final TextView getSelectedCount() {
        return (TextView) this.f28620h.mo5678b();
    }

    public final void mo4911a(String str) {
        Intrinsics.m26847b(str, "message");
    }

    public /* synthetic */ ModQueueOptionsScreen(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i2 & 2) != null) {
            attributeSet = null;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        this(context, attributeSet, i);
    }

    public ModQueueOptionsScreen(Context context, AttributeSet attributeSet, int i) {
        Intrinsics.m26847b(context, "context");
        super(context, attributeSet, i);
        this.f28614b = new HashSet();
        this.f28615c = (Map) new LinkedHashMap();
        this.f28620h = LazyKt.m26777a((Function0) new ModQueueOptionsScreen$selectedCount$2(this));
        Object create = PublishSubject.create();
        Intrinsics.m26843a(create, "PublishSubject.create<Int>()");
        this.f28618f = create;
        DaggerModQueueOptionsComponent.m29179a().m22126a(FrontpageApplication.m28875k()).m22127a(new ModQueueOptionsViewModule(this)).m22128a().mo4685a(this);
        create = FrameLayout.inflate(context, C1761R.layout.options_mod_queue_actions, this);
        setBackgroundColor(ContextsKt.m24075a(context, 17170445));
        Intrinsics.m26843a(create, "view");
        context = create.findViewById(C1761R.id.option_approve);
        if (context == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.widgets.ModQueueBulkActionItem");
        }
        ((ModQueueBulkActionItem) context).setOnClickListener((OnClickListener) new OnClickListener() {
            public final void onClick(android.view.View view) {
                this.getPresenter().onActon(ModQueueAction.f20917a, CollectionsKt___CollectionsKt.m41449n(this.f28614b), this.f28615c);
            }
        });
        context = create.findViewById(C1761R.id.option_remove);
        if (context == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.widgets.ModQueueBulkActionItem");
        }
        ((ModQueueBulkActionItem) context).setOnClickListener((OnClickListener) new OnClickListener() {
            public final void onClick(android.view.View view) {
                this.getPresenter().onActon(ModQueueAction.f20918b, CollectionsKt___CollectionsKt.m41449n(this.f28614b), this.f28615c);
            }
        });
        context = create.findViewById(C1761R.id.option_spam);
        if (context == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.widgets.ModQueueBulkActionItem");
        }
        ((ModQueueBulkActionItem) context).setOnClickListener((OnClickListener) new OnClickListener() {
            public final void onClick(android.view.View view) {
                this.getPresenter().onActon(ModQueueAction.f20919c, CollectionsKt___CollectionsKt.m41449n(this.f28614b), this.f28615c);
            }
        });
        context = create.findViewById(C1761R.id.clear);
        if (context == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.widget.Button");
        }
        ((Button) context).setOnClickListener((OnClickListener) new OnClickListener() {
            public final void onClick(android.view.View view) {
                ModQueueOptionsScreen.m29769c(this);
            }
        });
        context = this.f28616d;
        if (context == null) {
            Intrinsics.m26844a("presenter");
        }
        context.attach();
    }

    public final ModQueueOptionsPresenter getPresenter() {
        ModQueueOptionsPresenter modQueueOptionsPresenter = this.f28616d;
        if (modQueueOptionsPresenter == null) {
            Intrinsics.m26844a("presenter");
        }
        return modQueueOptionsPresenter;
    }

    public final void setPresenter(ModQueueOptionsPresenter modQueueOptionsPresenter) {
        Intrinsics.m26847b(modQueueOptionsPresenter, "<set-?>");
        this.f28616d = modQueueOptionsPresenter;
    }

    public final BaseScreen getScreen() {
        BaseScreen baseScreen = this.f28617e;
        if (baseScreen == null) {
            Intrinsics.m26844a("screen");
        }
        return baseScreen;
    }

    public final void setScreen(BaseScreen baseScreen) {
        Intrinsics.m26847b(baseScreen, "<set-?>");
        this.f28617e = baseScreen;
    }

    public final PublishSubject<Integer> getNumberCheckedSubject() {
        return this.f28618f;
    }

    public final void m29770a() {
        if (this.f28614b.size() == 0) {
            Object selectedCount = getSelectedCount();
            Intrinsics.m26843a(selectedCount, "selectedCount");
            selectedCount.setText("");
            return;
        }
        selectedCount = getSelectedCount();
        Intrinsics.m26843a(selectedCount, "selectedCount");
        selectedCount.setText(Util.m23959a((int) C1761R.plurals.fmt_num_items_selected, this.f28614b.size(), Integer.valueOf(this.f28614b.size())));
    }

    public static final /* synthetic */ void m29769c(ModQueueOptionsScreen modQueueOptionsScreen) {
        modQueueOptionsScreen.f28618f.onNext(Integer.valueOf(0));
        modQueueOptionsScreen.f28614b.clear();
        modQueueOptionsScreen.m29770a();
    }
}
