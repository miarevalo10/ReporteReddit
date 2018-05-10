package com.reddit.frontpage.ui.submit;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.evernote.android.state.State;
import com.reddit.datalibrary.frontpage.requests.models.v1.Thing;
import com.reddit.datalibrary.frontpage.requests.models.v2.LinkFlair;
import com.reddit.datalibrary.frontpage.requests.models.v2.ParcelerBundler;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.di.component.DaggerLinkFlairSelectComponent;
import com.reddit.frontpage.di.module.LinkFlairSelectViewModule;
import com.reddit.frontpage.presentation.flair.LinkFlairSelectContract.View;
import com.reddit.frontpage.presentation.flair.LinkFlairSelectPresenter;
import com.reddit.frontpage.ui.BaseScreen;
import com.reddit.frontpage.ui.alert.RedditAlertDialog;
import com.reddit.frontpage.util.RichTextUtil;
import com.reddit.frontpage.util.kotlin.ViewGroupsKt;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 B2\u00020\u00012\u00020\u0002:\u0003BCDB\u0007\b\u0016¢\u0006\u0002\u0010\u0003B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010.\u001a\u00020/2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u001d01H\u0016J\u0010\u00102\u001a\u00020/2\u0006\u00103\u001a\u000204H\u0014J\b\u00105\u001a\u00020/H\u0014J\b\u00106\u001a\u000207H\u0016J\b\u00108\u001a\u000207H\u0016J\u0018\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>H\u0016J\b\u0010?\u001a\u00020/H\u0016J\u0010\u0010@\u001a\u00020/2\u0006\u0010A\u001a\u00020\u001dH\u0016R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00060\u000bR\u00020\u0000X.¢\u0006\u0002\n\u0000R:\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\rj\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e`\u000f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000R\u001e\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR*\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d8\u0016@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010#\u001a\u00020\u000e8\u0016@\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R \u0010(\u001a\u0004\u0018\u00010)8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u0006E"}, d2 = {"Lcom/reddit/frontpage/ui/submit/LinkFlairSelectScreen;", "Lcom/reddit/frontpage/ui/BaseScreen;", "Lcom/reddit/frontpage/presentation/flair/LinkFlairSelectContract$View;", "()V", "bundle", "Landroid/os/Bundle;", "(Landroid/os/Bundle;)V", "clearView", "Landroid/widget/Button;", "doneView", "flairAdapter", "Lcom/reddit/frontpage/ui/submit/LinkFlairSelectScreen$FlairAdapter;", "flairEdits", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getFlairEdits", "()Ljava/util/HashMap;", "setFlairEdits", "(Ljava/util/HashMap;)V", "flairsView", "Landroid/support/v7/widget/RecyclerView;", "presenter", "Lcom/reddit/frontpage/presentation/flair/LinkFlairSelectPresenter;", "getPresenter", "()Lcom/reddit/frontpage/presentation/flair/LinkFlairSelectPresenter;", "setPresenter", "(Lcom/reddit/frontpage/presentation/flair/LinkFlairSelectPresenter;)V", "value", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/LinkFlair;", "selectedFlair", "getSelectedFlair", "()Lcom/reddit/datalibrary/frontpage/requests/models/v2/LinkFlair;", "setSelectedFlair", "(Lcom/reddit/datalibrary/frontpage/requests/models/v2/LinkFlair;)V", "subredditName", "getSubredditName", "()Ljava/lang/String;", "setSubredditName", "(Ljava/lang/String;)V", "thing", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/Thing;", "getThing", "()Lcom/reddit/datalibrary/frontpage/requests/models/v1/Thing;", "setThing", "(Lcom/reddit/datalibrary/frontpage/requests/models/v1/Thing;)V", "addFlairs", "", "flairs", "", "configureActionBar", "actionBar", "Landroid/support/v7/app/ActionBar;", "configureNavigation", "getDefaultScreenPosition", "", "getLayoutId", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onError", "showCustomFlairDialog", "editableFlair", "Companion", "FlairAdapter", "LinkFlairSelectedListener", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LinkFlairSelectScreen.kt */
public final class LinkFlairSelectScreen extends BaseScreen implements View {
    public static final Companion f39347w = new Companion();
    private FlairAdapter f39348A;
    @State(ParcelerBundler.class)
    HashMap<String, String> flairEdits = new HashMap();
    @State(ParcelerBundler.class)
    LinkFlair selectedFlair;
    @State(ParcelerBundler.class)
    public String subredditName;
    @State(ParcelerBundler.class)
    Thing thing;
    @Inject
    public LinkFlairSelectPresenter f39349v;
    private RecyclerView f39350x;
    private Button f39351y;
    private Button f39352z;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/reddit/frontpage/ui/submit/LinkFlairSelectScreen$Companion;", "", "()V", "MAX_FLAIR_TEXT_LENGTH", "", "newInstance", "Lcom/reddit/frontpage/ui/submit/LinkFlairSelectScreen;", "subredditName", "", "thing", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/Thing;", "selectedFlair", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/LinkFlair;", "selectedFlairEdit", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: LinkFlairSelectScreen.kt */
    public static final class Companion {
        private Companion() {
        }

        public static LinkFlairSelectScreen m23620a(String str, Thing thing, LinkFlair linkFlair, String str2) {
            Intrinsics.m26847b(str, "subredditName");
            LinkFlairSelectScreen linkFlairSelectScreen = new LinkFlairSelectScreen();
            Intrinsics.m26847b(str, "<set-?>");
            linkFlairSelectScreen.subredditName = str;
            if (thing != null) {
                linkFlairSelectScreen.thing = thing;
            }
            if (linkFlair != null) {
                linkFlairSelectScreen.m39555a(linkFlair);
                if (str2 != null) {
                    Map map = (Map) linkFlairSelectScreen.flairEdits;
                    Object id = linkFlair.getId();
                    Intrinsics.m26843a(id, "selectedFlair.id");
                    map.put(id, str2);
                }
            }
            return linkFlairSelectScreen;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\n"}, d2 = {"Lcom/reddit/frontpage/ui/submit/LinkFlairSelectScreen$LinkFlairSelectedListener;", "", "onLinkFlairSelected", "", "selectedLinkFlair", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/LinkFlair;", "selectedLinkFlairEdit", "", "thing", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/Thing;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: LinkFlairSelectScreen.kt */
    public interface LinkFlairSelectedListener {
        void mo7206a(LinkFlair linkFlair, String str, Thing thing);
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u0010\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u00030\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0004J\u0014\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bJ\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rH\u0016J \u0010\u0011\u001a\u00020\t2\u000e\u0010\u0012\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u0010\u001a\u00020\rH\u0016J \u0010\u0013\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\rH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/reddit/frontpage/ui/submit/LinkFlairSelectScreen$FlairAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/reddit/frontpage/ui/submit/LinkFlairSelectScreen$FlairAdapter$FlairViewHolder;", "Lcom/reddit/frontpage/ui/submit/LinkFlairSelectScreen;", "(Lcom/reddit/frontpage/ui/submit/LinkFlairSelectScreen;)V", "flairs", "", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/LinkFlair;", "addToList", "", "flairList", "", "getItemCount", "", "getItemId", "", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "FlairViewHolder", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: LinkFlairSelectScreen.kt */
    public final class FlairAdapter extends Adapter<FlairViewHolder> {
        final List<LinkFlair> f29310a = ((List) new ArrayList());
        final /* synthetic */ LinkFlairSelectScreen f29311b;

        @Metadata(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/reddit/frontpage/ui/submit/LinkFlairSelectScreen$FlairAdapter$FlairViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/reddit/frontpage/ui/submit/LinkFlairSelectScreen$FlairAdapter;Landroid/view/View;)V", "editButton", "Landroid/widget/Button;", "getEditButton", "()Landroid/widget/Button;", "flairTextView", "Landroid/widget/TextView;", "getFlairTextView", "()Landroid/widget/TextView;", "bind", "", "linkFlair", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/LinkFlair;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
        /* compiled from: LinkFlairSelectScreen.kt */
        public final class FlairViewHolder extends ViewHolder {
            final TextView f29307a;
            final Button f29308b;
            final /* synthetic */ FlairAdapter f29309p;

            public FlairViewHolder(FlairAdapter flairAdapter, android.view.View view) {
                Intrinsics.m26847b(view, "itemView");
                this.f29309p = flairAdapter;
                super(view);
                Object findViewById = view.findViewById(C1761R.id.flair_text);
                Intrinsics.m26843a(findViewById, "itemView.findViewById(R.id.flair_text)");
                this.f29307a = (TextView) findViewById;
                findViewById = view.findViewById(C1761R.id.edit);
                Intrinsics.m26843a(findViewById, "itemView.findViewById(R.id.edit)");
                this.f29308b = (Button) findViewById;
                view.setOnClickListener((OnClickListener) new OnClickListener() {
                    public final void onClick(android.view.View view) {
                        if (this.d() >= null && this.d() < this.f29309p.f29310a.size()) {
                            this.f29309p.f29311b.m39555a((LinkFlair) this.f29309p.f29310a.get(this.d()));
                        }
                    }
                });
                this.f29308b.setOnClickListener((OnClickListener) new OnClickListener() {
                    public final void onClick(android.view.View view) {
                        if (this.d() >= null && this.d() < this.f29309p.f29310a.size()) {
                            view = this.f29309p.f29311b;
                            LinkFlair linkFlair = (LinkFlair) this.f29309p.f29310a.get(this.d());
                            Intrinsics.m26847b(linkFlair, "editableFlair");
                            com.reddit.frontpage.ui.alert.RedditAlertDialog.Companion companion = RedditAlertDialog.f21112b;
                            Object am_ = view.am_();
                            if (am_ == null) {
                                Intrinsics.m26842a();
                            }
                            Intrinsics.m26843a(am_, "activity!!");
                            Context context = (Context) am_;
                            Activity am_2 = view.am_();
                            if (am_2 == null) {
                                Intrinsics.m26842a();
                            }
                            String string = am_2.getString(C1761R.string.title_custom_flair);
                            Intrinsics.m26843a((Object) string, "activity!!.getString(R.string.title_custom_flair)");
                            String text = linkFlair.getText();
                            Intrinsics.m26843a((Object) text, "editableFlair.text");
                            String str = (String) view.flairEdits.get(linkFlair.getId());
                            if (str == null) {
                                str = linkFlair.getText();
                            }
                            com.reddit.frontpage.ui.alert.RedditAlertDialog.Companion.m23285a(context, 64, string, text, str, (Function1) new LinkFlairSelectScreen$showCustomFlairDialog$1(view, linkFlair)).show();
                        }
                    }
                });
            }
        }

        public FlairAdapter(LinkFlairSelectScreen linkFlairSelectScreen) {
            this.f29311b = linkFlairSelectScreen;
            a(true);
        }

        public final /* synthetic */ ViewHolder m30393a(ViewGroup viewGroup, int i) {
            Intrinsics.m26847b(viewGroup, "parent");
            return (ViewHolder) new FlairViewHolder(this, ViewGroupsKt.m24100a(viewGroup, C1761R.layout.listitem_flair, false));
        }

        public final /* synthetic */ void m30394a(ViewHolder viewHolder, int i) {
            FlairViewHolder flairViewHolder = (FlairViewHolder) viewHolder;
            Intrinsics.m26847b(flairViewHolder, "holder");
            Object obj = (LinkFlair) this.f29310a.get(i);
            Intrinsics.m26847b(obj, "linkFlair");
            Object obj2 = flairViewHolder.c;
            Intrinsics.m26843a(obj2, "itemView");
            obj2.setActivated(Intrinsics.m26845a(obj, flairViewHolder.f29309p.f29311b.selectedFlair));
            String str = (String) flairViewHolder.f29309p.f29311b.flairEdits.get(obj.getId());
            if (str == null) {
                str = obj.getFlairRichText();
                Intrinsics.m26843a((Object) str, "linkFlair.flairRichText");
            }
            RichTextUtil.m23883a(str, flairViewHolder.f29307a);
            ViewsKt.m24106b((android.view.View) flairViewHolder.f29308b, obj.getTextEditable());
        }

        public final int m30391a() {
            return this.f29310a.size();
        }

        public final long m30392a(int i) {
            return (long) ((LinkFlair) this.f29310a.get(i)).hashCode();
        }
    }

    public static final LinkFlairSelectScreen m39550a(String str, Thing thing, LinkFlair linkFlair, String str2) {
        return Companion.m23620a(str, thing, linkFlair, str2);
    }

    public final int mo7141s() {
        return C1761R.layout.post_flair_select;
    }

    public final int mo7143u() {
        return 2;
    }

    public final String mo7244a() {
        String str = this.subredditName;
        if (str == null) {
            Intrinsics.m26844a("subredditName");
        }
        return str;
    }

    public final void m39555a(LinkFlair linkFlair) {
        this.selectedFlair = linkFlair;
        if (v_()) {
            FlairAdapter flairAdapter = this.f39348A;
            if (flairAdapter == null) {
                Intrinsics.m26844a("flairAdapter");
            }
            flairAdapter.e();
            Button button = this.f39351y;
            if (button == null) {
                Intrinsics.m26844a("clearView");
            }
            button.setEnabled(linkFlair != null ? true : null);
        }
    }

    public LinkFlairSelectScreen() {
        DaggerLinkFlairSelectComponent.m29164a().m22116a(FrontpageApplication.m28875k()).m22117a(new LinkFlairSelectViewModule(this)).m22118a().mo4677a(this);
    }

    public LinkFlairSelectScreen(Bundle bundle) {
        Intrinsics.m26847b(bundle, "bundle");
        super(bundle);
        DaggerLinkFlairSelectComponent.m29164a().m22116a(FrontpageApplication.m28875k()).m22117a(new LinkFlairSelectViewModule(this)).m22118a().mo4677a(this);
    }

    public final android.view.View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.m26847b(layoutInflater, "inflater");
        Intrinsics.m26847b(viewGroup, "container");
        Object a = super.mo7139a(layoutInflater, viewGroup);
        Object findViewById = this.K.findViewById(C1761R.id.recycler_view);
        Intrinsics.m26843a(findViewById, "rootView.findViewById(R.id.recycler_view)");
        this.f39350x = (RecyclerView) findViewById;
        findViewById = this.K.findViewById(C1761R.id.clear);
        Intrinsics.m26843a(findViewById, "rootView.findViewById(R.id.clear)");
        this.f39351y = (Button) findViewById;
        findViewById = this.K.findViewById(C1761R.id.done);
        Intrinsics.m26843a(findViewById, "rootView.findViewById(R.id.done)");
        this.f39352z = (Button) findViewById;
        this.f39348A = new FlairAdapter(this);
        viewGroup = this.f39350x;
        if (viewGroup == null) {
            Intrinsics.m26844a("flairsView");
        }
        FlairAdapter flairAdapter = this.f39348A;
        if (flairAdapter == null) {
            Intrinsics.m26844a("flairAdapter");
        }
        viewGroup.setAdapter(flairAdapter);
        boolean z = false;
        viewGroup.setLayoutManager(new LinearLayoutManager(am_(), 1, false));
        viewGroup = this.f39349v;
        if (viewGroup == null) {
            Intrinsics.m26844a("presenter");
        }
        viewGroup.attach();
        viewGroup = this.f39351y;
        if (viewGroup == null) {
            Intrinsics.m26844a("clearView");
        }
        if (this.selectedFlair != null) {
            z = true;
        }
        viewGroup.setEnabled(z);
        viewGroup.setOnClickListener(new LinkFlairSelectScreen$onCreateView$$inlined$apply$lambda$1(this));
        viewGroup = this.f39352z;
        if (viewGroup == null) {
            Intrinsics.m26844a("doneView");
        }
        viewGroup.setOnClickListener(new LinkFlairSelectScreen$onCreateView$3(this));
        Intrinsics.m26843a(a, "view");
        return a;
    }

    protected final void au() {
        Toolbar at = at();
        Activity am_ = am_();
        if (am_ == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.support.v7.app.AppCompatActivity");
        }
        AppCompatActivity appCompatActivity = (AppCompatActivity) am_;
        appCompatActivity.a(at);
        ActionBar b = appCompatActivity.b();
        if (b == null) {
            Intrinsics.m26842a();
        }
        b.a(true);
        b.b(true);
        Intrinsics.m26843a((Object) b, "activity.supportActionBa…meAsUpEnabled(true)\n    }");
        mo7185a(b);
    }

    protected final void mo7185a(ActionBar actionBar) {
        Intrinsics.m26847b(actionBar, "actionBar");
        actionBar.c(true);
        actionBar.a(C1761R.string.title_add_flair);
    }

    public final void mo7245a(List<? extends LinkFlair> list) {
        Intrinsics.m26847b(list, "flairs");
        FlairAdapter flairAdapter = this.f39348A;
        if (flairAdapter == null) {
            Intrinsics.m26844a("flairAdapter");
        }
        Intrinsics.m26847b(list, "flairList");
        flairAdapter.f29310a.addAll(list);
        flairAdapter.e();
    }

    public final void mo7246b() {
        m29351F();
    }
}
