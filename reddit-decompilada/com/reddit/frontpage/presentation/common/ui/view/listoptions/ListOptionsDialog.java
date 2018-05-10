package com.reddit.frontpage.presentation.common.ui.view.listoptions;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.common.ui.view.RedditBottomSheetDialog;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014R\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001d"}, d2 = {"Lcom/reddit/frontpage/presentation/common/ui/view/listoptions/ListOptionsDialog;", "Lcom/reddit/frontpage/presentation/common/ui/view/RedditBottomSheetDialog;", "context", "Landroid/content/Context;", "options", "", "Lcom/reddit/frontpage/presentation/common/ui/view/listoptions/ListOptionAction;", "selectedPos", "", "titleHeaderEnabled", "", "(Landroid/content/Context;Ljava/util/List;IZ)V", "adapter", "Lcom/reddit/frontpage/presentation/common/ui/view/listoptions/ListOptionsDialogAdapter;", "getAdapter", "()Lcom/reddit/frontpage/presentation/common/ui/view/listoptions/ListOptionsDialogAdapter;", "setAdapter", "(Lcom/reddit/frontpage/presentation/common/ui/view/listoptions/ListOptionsDialogAdapter;)V", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "setRecyclerView", "(Landroid/support/v7/widget/RecyclerView;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ListOptionsDialog.kt */
public final class ListOptionsDialog extends RedditBottomSheetDialog {
    public static final Companion f39072f = new Companion();
    public RecyclerView f39073d;
    public ListOptionsDialogAdapter f39074e;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/reddit/frontpage/presentation/common/ui/view/listoptions/ListOptionsDialog$Companion;", "", "()V", "LIST_NONE_SELECTED", "", "LIST_NOT_SELECTABLE", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ListOptionsDialog.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public ListOptionsDialog(Context context, List<ListOptionAction> list) {
        this(context, (List) list, -1, 8);
    }

    public ListOptionsDialog(Context context, List<ListOptionAction> list, byte b) {
        this(context, (List) list, 0, 12);
    }

    public /* synthetic */ ListOptionsDialog(Context context, List list, int i, int i2) {
        if ((i2 & 4) != 0) {
            i = -1;
        }
        this(context, list, i, (boolean) 0);
    }

    public ListOptionsDialog(Context context, List<ListOptionAction> list, int i, boolean z) {
        Intrinsics.m26847b(context, "context");
        Intrinsics.m26847b(list, "options");
        super(context, z);
        this.f39074e = new ListOptionsDialogAdapter(list, this, i);
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C1761R.layout.bottomsheet_list_options);
        bundle = findViewById(C1761R.id.recycler_view);
        if (bundle == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.support.v7.widget.RecyclerView");
        }
        this.f39073d = (RecyclerView) bundle;
        bundle = this.f39073d;
        if (bundle == null) {
            Intrinsics.m26844a("recyclerView");
        }
        bundle.setLayoutManager(new LinearLayoutManager(getContext()));
        bundle = this.f39073d;
        if (bundle == null) {
            Intrinsics.m26844a("recyclerView");
        }
        bundle.setAdapter(this.f39074e);
    }
}
