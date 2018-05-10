package com.reddit.frontpage.presentation.modtools.modlist.add;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import com.bluelinelabs.conductor.Controller;
import com.evernote.android.state.State;
import com.reddit.datalibrary.frontpage.data.model.Moderator;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.builders.ModEventBuilder;
import com.reddit.frontpage.commons.analytics.builders.ModNoun;
import com.reddit.frontpage.di.component.DaggerAddModeratorComponent;
import com.reddit.frontpage.di.module.AddModeratorViewModule;
import com.reddit.frontpage.nav.Screens;
import com.reddit.frontpage.presentation.MvpBaseScreen;
import com.reddit.frontpage.presentation.modtools.ModAddUserTarget;
import com.reddit.frontpage.presentation.modtools.modlist.ModeratorListTarget;
import com.reddit.frontpage.presentation.modtools.modlist.add.AddModeratorContract.View;
import com.reddit.frontpage.presentation.modtools.util.ModScreenMode;
import com.reddit.frontpage.util.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\r\n\u0002\b\u0007\u0018\u0000 g2\u00020\u00012\u00020\u0002:\u0001gB\u0007\b\u0016¢\u0006\u0002\u0010\u0003B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010D\u001a\u00020EH\u0002J\b\u0010F\u001a\u00020GH\u0016J\b\u0010H\u001a\u00020GH\u0016J\b\u0010I\u001a\u00020-H\u0002J\b\u0010J\u001a\u00020KH\u0002J\b\u0010L\u001a\u00020KH\u0002J\u0018\u0010M\u001a\u00020E2\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020QH\u0016J\u0018\u0010R\u001a\u00020S2\u0006\u0010P\u001a\u00020T2\u0006\u0010U\u001a\u00020VH\u0016J\u0010\u0010W\u001a\u00020E2\u0006\u0010;\u001a\u00020-H\u0016J\u0010\u0010X\u001a\u00020E2\u0006\u0010Y\u001a\u00020-H\u0016J\b\u0010Z\u001a\u00020EH\u0007J\b\u0010[\u001a\u00020EH\u0007J\u0010\u0010\\\u001a\u00020E2\u0006\u0010;\u001a\u00020-H\u0016J\u0010\u0010]\u001a\u00020K2\u0006\u0010^\u001a\u00020\u001aH\u0016J\u0010\u0010_\u001a\u00020E2\u0006\u0010`\u001a\u00020aH\u0007J\b\u0010b\u001a\u00020EH\u0002J\u0010\u0010c\u001a\u00020E2\u0006\u0010d\u001a\u00020KH\u0002J\b\u0010e\u001a\u00020EH\u0002J\b\u0010f\u001a\u00020EH\u0002R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u00020\b8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001e\u0010\u0010\u001a\u00020\b8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001e\u0010\u0013\u001a\u00020\b8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR\u001e\u0010\u0016\u001a\u00020\b8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\n\"\u0004\b\u0018\u0010\fR\u000e\u0010\u0019\u001a\u00020\u001aX.¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u00020\u001cX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u00020\b8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\n\"\u0004\b#\u0010\fR\u001e\u0010$\u001a\u00020%8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u000e\u0010*\u001a\u00020+X.¢\u0006\u0002\n\u0000R\u001e\u0010,\u001a\u00020-8\u0016@\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001e\u00102\u001a\u00020-8\u0016@\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010/\"\u0004\b4\u00101R\u001e\u00105\u001a\u0002068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001e\u0010;\u001a\u00020<8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001e\u0010A\u001a\u00020\b8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\n\"\u0004\bC\u0010\f¨\u0006h"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/modlist/add/AddModeratorScreen;", "Lcom/reddit/frontpage/presentation/MvpBaseScreen;", "Lcom/reddit/frontpage/presentation/modtools/modlist/add/AddModeratorContract$View;", "()V", "bundle", "Landroid/os/Bundle;", "(Landroid/os/Bundle;)V", "accessPermission", "Landroid/widget/CheckBox;", "getAccessPermission", "()Landroid/widget/CheckBox;", "setAccessPermission", "(Landroid/widget/CheckBox;)V", "configPermission", "getConfigPermission", "setConfigPermission", "flairPermission", "getFlairPermission", "setFlairPermission", "fullPermission", "getFullPermission", "setFullPermission", "mailPermission", "getMailPermission", "setMailPermission", "menuItem", "Landroid/view/MenuItem;", "moderator", "Lcom/reddit/datalibrary/frontpage/data/model/Moderator;", "getModerator", "()Lcom/reddit/datalibrary/frontpage/data/model/Moderator;", "setModerator", "(Lcom/reddit/datalibrary/frontpage/data/model/Moderator;)V", "postsPermission", "getPostsPermission", "setPostsPermission", "presenter", "Lcom/reddit/frontpage/presentation/modtools/modlist/add/AddModeratorPresenter;", "getPresenter", "()Lcom/reddit/frontpage/presentation/modtools/modlist/add/AddModeratorPresenter;", "setPresenter", "(Lcom/reddit/frontpage/presentation/modtools/modlist/add/AddModeratorPresenter;)V", "screenMode", "Lcom/reddit/frontpage/presentation/modtools/util/ModScreenMode;", "subredditId", "", "getSubredditId", "()Ljava/lang/String;", "setSubredditId", "(Ljava/lang/String;)V", "subredditName", "getSubredditName", "setSubredditName", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "setTitle", "(Landroid/widget/TextView;)V", "username", "Landroid/widget/EditText;", "getUsername", "()Landroid/widget/EditText;", "setUsername", "(Landroid/widget/EditText;)V", "wikiPermission", "getWikiPermission", "setWikiPermission", "configureScreen", "", "getDefaultScreenPosition", "", "getLayoutId", "getPermissionString", "isFormValid", "", "isPermissionSelected", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onCreateView", "Landroid/view/View;", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onEditPermissionsSuccess", "onError", "errorMessage", "onFullPermissionClicked", "onGranularPermissionClicked", "onInviteSuccess", "onOptionsItemSelected", "item", "onUsernameTextChanged", "textChanged", "", "sendPermissionEvent", "setAllPermissions", "isChecked", "setPermissions", "updateMenuButton", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: AddModeratorScreen.kt */
public final class AddModeratorScreen extends MvpBaseScreen implements View {
    public static final Companion f40099x = new Companion();
    @BindView
    public CheckBox accessPermission;
    @BindView
    public CheckBox configPermission;
    @BindView
    public CheckBox flairPermission;
    @BindView
    public CheckBox fullPermission;
    @BindView
    public CheckBox mailPermission;
    @BindView
    public CheckBox postsPermission;
    @State
    public String subredditId;
    @State
    public String subredditName;
    @BindView
    public TextView title;
    @BindView
    public EditText username;
    public Moderator f40100v;
    @Inject
    public AddModeratorPresenter f40101w;
    @BindView
    public CheckBox wikiPermission;
    private MenuItem f40102y;
    private ModScreenMode f40103z;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/modlist/add/AddModeratorScreen$Companion;", "", "()V", "newInstance", "Lcom/reddit/frontpage/presentation/modtools/modlist/add/AddModeratorScreen;", "subredditId", "", "subredditName", "moderator", "Lcom/reddit/datalibrary/frontpage/data/model/Moderator;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: AddModeratorScreen.kt */
    public static final class Companion {
        private Companion() {
        }

        public static AddModeratorScreen m23124a(String str, String str2) {
            Intrinsics.m26847b(str, "subredditId");
            Intrinsics.m26847b(str2, "subredditName");
            AddModeratorScreen addModeratorScreen = new AddModeratorScreen();
            addModeratorScreen.m40809d(str);
            addModeratorScreen.m40810e(str2);
            addModeratorScreen.f40103z = ModScreenMode.f20921a;
            return addModeratorScreen;
        }

        public static AddModeratorScreen m23125a(String str, String str2, Moderator moderator) {
            Intrinsics.m26847b(str, "subredditId");
            Intrinsics.m26847b(str2, "subredditName");
            Intrinsics.m26847b(moderator, "moderator");
            AddModeratorScreen addModeratorScreen = new AddModeratorScreen();
            addModeratorScreen.m40809d(str);
            addModeratorScreen.m40810e(str2);
            Intrinsics.m26847b(moderator, "<set-?>");
            addModeratorScreen.f40100v = moderator;
            addModeratorScreen.f40103z = ModScreenMode.f20922b;
            return addModeratorScreen;
        }
    }

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] f20907a;

        static {
            int[] iArr = new int[ModScreenMode.values().length];
            f20907a = iArr;
            iArr[ModScreenMode.f20921a.ordinal()] = 1;
            f20907a[ModScreenMode.f20922b.ordinal()] = 2;
            f20907a[ModScreenMode.f20923c.ordinal()] = 3;
        }
    }

    public static final AddModeratorScreen m40796a(String str, String str2) {
        return Companion.m23124a(str, str2);
    }

    public static final AddModeratorScreen m40797a(String str, String str2, Moderator moderator) {
        return Companion.m23125a(str, str2, moderator);
    }

    public final int mo7141s() {
        return C1761R.layout.screen_add_moderator;
    }

    public final int mo7143u() {
        return 2;
    }

    public AddModeratorScreen() {
        super();
        DaggerAddModeratorComponent.m28996a().m22049a(FrontpageApplication.m28875k()).m22050a(new AddModeratorViewModule(this)).m22048a().mo4582a(this);
    }

    public AddModeratorScreen(Bundle bundle) {
        Intrinsics.m26847b(bundle, "bundle");
        super(bundle);
        DaggerAddModeratorComponent.m28996a().m22049a(FrontpageApplication.m28875k()).m22050a(new AddModeratorViewModule(this)).m22048a().mo4582a(this);
    }

    @OnTextChanged
    public final void onUsernameTextChanged(CharSequence charSequence) {
        Intrinsics.m26847b(charSequence, "textChanged");
        Object obj = this.f40103z;
        if (obj == null) {
            Intrinsics.m26844a("screenMode");
        }
        if (Intrinsics.m26845a(obj, ModScreenMode.f20921a) != null) {
            m40800x();
        }
    }

    @OnClick
    public final void onFullPermissionClicked() {
        m40795O();
        CheckBox checkBox = this.fullPermission;
        if (checkBox == null) {
            Intrinsics.m26844a("fullPermission");
        }
        boolean isChecked = checkBox.isChecked();
        CheckBox[] checkBoxArr = new CheckBox[7];
        CheckBox checkBox2 = this.fullPermission;
        if (checkBox2 == null) {
            Intrinsics.m26844a("fullPermission");
        }
        int i = 0;
        checkBoxArr[0] = checkBox2;
        checkBox2 = this.accessPermission;
        if (checkBox2 == null) {
            Intrinsics.m26844a("accessPermission");
        }
        checkBoxArr[1] = checkBox2;
        CheckBox checkBox3 = this.mailPermission;
        if (checkBox3 == null) {
            Intrinsics.m26844a("mailPermission");
        }
        checkBoxArr[2] = checkBox3;
        checkBox3 = this.configPermission;
        if (checkBox3 == null) {
            Intrinsics.m26844a("configPermission");
        }
        checkBoxArr[3] = checkBox3;
        checkBox3 = this.postsPermission;
        if (checkBox3 == null) {
            Intrinsics.m26844a("postsPermission");
        }
        checkBoxArr[4] = checkBox3;
        checkBox3 = this.flairPermission;
        if (checkBox3 == null) {
            Intrinsics.m26844a("flairPermission");
        }
        checkBoxArr[5] = checkBox3;
        checkBox3 = this.wikiPermission;
        if (checkBox3 == null) {
            Intrinsics.m26844a("wikiPermission");
        }
        checkBoxArr[6] = checkBox3;
        while (i < 7) {
            checkBoxArr[i].setChecked(isChecked);
            i++;
        }
        m40800x();
    }

    @OnClick
    public final void onGranularPermissionClicked() {
        m40795O();
        CheckBox checkBox = this.fullPermission;
        if (checkBox == null) {
            Intrinsics.m26844a("fullPermission");
        }
        Boolean[] boolArr = new Boolean[6];
        CheckBox checkBox2 = this.accessPermission;
        if (checkBox2 == null) {
            Intrinsics.m26844a("accessPermission");
        }
        boolean z = false;
        boolArr[0] = Boolean.valueOf(checkBox2.isChecked());
        checkBox2 = this.mailPermission;
        if (checkBox2 == null) {
            Intrinsics.m26844a("mailPermission");
        }
        boolArr[1] = Boolean.valueOf(checkBox2.isChecked());
        CheckBox checkBox3 = this.configPermission;
        if (checkBox3 == null) {
            Intrinsics.m26844a("configPermission");
        }
        boolArr[2] = Boolean.valueOf(checkBox3.isChecked());
        checkBox3 = this.postsPermission;
        if (checkBox3 == null) {
            Intrinsics.m26844a("postsPermission");
        }
        boolArr[3] = Boolean.valueOf(checkBox3.isChecked());
        checkBox3 = this.flairPermission;
        if (checkBox3 == null) {
            Intrinsics.m26844a("flairPermission");
        }
        boolArr[4] = Boolean.valueOf(checkBox3.isChecked());
        checkBox3 = this.wikiPermission;
        if (checkBox3 == null) {
            Intrinsics.m26844a("wikiPermission");
        }
        boolArr[5] = Boolean.valueOf(checkBox3.isChecked());
        for (int i = 0; i < 6; i++) {
            if (!boolArr[i].booleanValue()) {
                break;
            }
        }
        z = true;
        checkBox.setChecked(z);
        m40800x();
    }

    private String m40799w() {
        String str = this.subredditId;
        if (str == null) {
            Intrinsics.m26844a("subredditId");
        }
        return str;
    }

    public final void m40809d(String str) {
        Intrinsics.m26847b(str, "<set-?>");
        this.subredditId = str;
    }

    public final String mo7392a() {
        String str = this.subredditName;
        if (str == null) {
            Intrinsics.m26844a("subredditName");
        }
        return str;
    }

    public final void m40810e(String str) {
        Intrinsics.m26847b(str, "<set-?>");
        this.subredditName = str;
    }

    public final android.view.View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.m26847b(layoutInflater, "inflater");
        Intrinsics.m26847b(viewGroup, "container");
        super.mo7139a(layoutInflater, viewGroup);
        n();
        layoutInflater = this.f40103z;
        if (layoutInflater == null) {
            Intrinsics.m26844a("screenMode");
        }
        switch (WhenMappings.f20907a[layoutInflater.ordinal()]) {
            case 1:
                layoutInflater = this.title;
                if (layoutInflater == null) {
                    Intrinsics.m26844a("title");
                }
                layoutInflater.setText(Util.m24027f((int) C1761R.string.mod_tools_add_moderator));
                break;
            case 2:
                layoutInflater = this.title;
                if (layoutInflater == null) {
                    Intrinsics.m26844a("title");
                }
                layoutInflater.setText(Util.m24027f((int) C1761R.string.mod_tools_edit_permissions));
                layoutInflater = this.username;
                if (layoutInflater == null) {
                    Intrinsics.m26844a("username");
                }
                viewGroup = this.f40100v;
                if (viewGroup == null) {
                    Intrinsics.m26844a("moderator");
                }
                layoutInflater.setText(viewGroup.getUsername());
                layoutInflater = this.username;
                if (layoutInflater == null) {
                    Intrinsics.m26844a("username");
                }
                layoutInflater.setFocusable(null);
                layoutInflater = this.fullPermission;
                if (layoutInflater == null) {
                    Intrinsics.m26844a("fullPermission");
                }
                viewGroup = this.f40100v;
                if (viewGroup == null) {
                    Intrinsics.m26844a("moderator");
                }
                layoutInflater.setChecked(viewGroup.getModPermissions().getAll());
                layoutInflater = this.accessPermission;
                if (layoutInflater == null) {
                    Intrinsics.m26844a("accessPermission");
                }
                viewGroup = this.f40100v;
                if (viewGroup == null) {
                    Intrinsics.m26844a("moderator");
                }
                layoutInflater.setChecked(viewGroup.getModPermissions().getAccess());
                layoutInflater = this.configPermission;
                if (layoutInflater == null) {
                    Intrinsics.m26844a("configPermission");
                }
                viewGroup = this.f40100v;
                if (viewGroup == null) {
                    Intrinsics.m26844a("moderator");
                }
                layoutInflater.setChecked(viewGroup.getModPermissions().getConfig());
                layoutInflater = this.flairPermission;
                if (layoutInflater == null) {
                    Intrinsics.m26844a("flairPermission");
                }
                viewGroup = this.f40100v;
                if (viewGroup == null) {
                    Intrinsics.m26844a("moderator");
                }
                layoutInflater.setChecked(viewGroup.getModPermissions().getFlair());
                layoutInflater = this.mailPermission;
                if (layoutInflater == null) {
                    Intrinsics.m26844a("mailPermission");
                }
                viewGroup = this.f40100v;
                if (viewGroup == null) {
                    Intrinsics.m26844a("moderator");
                }
                layoutInflater.setChecked(viewGroup.getModPermissions().getMail());
                layoutInflater = this.postsPermission;
                if (layoutInflater == null) {
                    Intrinsics.m26844a("postsPermission");
                }
                viewGroup = this.f40100v;
                if (viewGroup == null) {
                    Intrinsics.m26844a("moderator");
                }
                layoutInflater.setChecked(viewGroup.getModPermissions().getPosts());
                layoutInflater = this.wikiPermission;
                if (layoutInflater == null) {
                    Intrinsics.m26844a("wikiPermission");
                }
                viewGroup = this.f40100v;
                if (viewGroup == null) {
                    Intrinsics.m26844a("moderator");
                }
                layoutInflater.setChecked(viewGroup.getModPermissions().getWiki());
                break;
            case 3:
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        Object obj = this.K;
        Intrinsics.m26843a(obj, "rootView");
        return obj;
    }

    public final void m40804a(Menu menu, MenuInflater menuInflater) {
        Intrinsics.m26847b(menu, "menu");
        Intrinsics.m26847b(menuInflater, "inflater");
        super.a(menu, menuInflater);
        menuInflater.inflate(C1761R.menu.menu_invite_moderator, menu);
        Object findItem = menu.findItem(C1761R.id.action_modtools_invite);
        Intrinsics.m26843a(findItem, "menu.findItem(R.id.action_modtools_invite)");
        this.f40102y = findItem;
        findItem = this.f40103z;
        if (findItem == null) {
            Intrinsics.m26844a("screenMode");
        }
        if (Intrinsics.m26845a(findItem, ModScreenMode.f20922b) != null) {
            menu = this.f40102y;
            if (menu == null) {
                Intrinsics.m26844a("menuItem");
            }
            menu.setTitle(C1761R.string.action_modtools_save);
            menu = this.f40102y;
            if (menu == null) {
                Intrinsics.m26844a("menuItem");
            }
            menu.setEnabled(true);
        }
    }

    public final boolean mo7201a(MenuItem menuItem) {
        Intrinsics.m26847b(menuItem, "item");
        if (menuItem.getItemId() != C1761R.id.action_modtools_invite) {
            return super.mo7201a(menuItem);
        }
        String str;
        ModEventBuilder modEventBuilder = (ModEventBuilder) ((ModEventBuilder) AppAnalytics.m21880q().m21888a(ModEventBuilder.f27455f)).m21892b(ModEventBuilder.f27451b);
        Object obj = this.f40103z;
        if (obj == null) {
            Intrinsics.m26844a("screenMode");
        }
        if (Intrinsics.m26845a(obj, ModScreenMode.f20921a)) {
            str = ModNoun.f20032D.f20068M;
        } else {
            str = ModNoun.f20058q.f20068M;
        }
        ((ModEventBuilder) ((ModEventBuilder) modEventBuilder.m21895c(str)).m21889a(m40799w(), mo7392a())).m21891a();
        Object obj2 = this.f40103z;
        if (obj2 == null) {
            Intrinsics.m26844a("screenMode");
        }
        EditText editText;
        if (Intrinsics.m26845a(obj2, ModScreenMode.f20921a) != null) {
            menuItem = this.f40101w;
            if (menuItem == null) {
                Intrinsics.m26844a("presenter");
            }
            editText = this.username;
            if (editText == null) {
                Intrinsics.m26844a("username");
            }
            obj = editText.getText();
            Intrinsics.m26843a(obj, "username.text");
            menuItem.m34800a(StringsKt__StringsKt.m42456b((CharSequence) obj).toString(), m40801y());
        } else {
            menuItem = this.f40101w;
            if (menuItem == null) {
                Intrinsics.m26844a("presenter");
            }
            editText = this.username;
            if (editText == null) {
                Intrinsics.m26844a("username");
            }
            obj = editText.getText();
            Intrinsics.m26843a(obj, "username.text");
            menuItem.m34801b(StringsKt__StringsKt.m42456b((CharSequence) obj).toString(), m40801y());
        }
        return true;
    }

    private final void m40800x() {
        MenuItem menuItem = this.f40102y;
        if (menuItem == null) {
            Intrinsics.m26844a("menuItem");
        }
        EditText editText = this.username;
        if (editText == null) {
            Intrinsics.m26844a("username");
        }
        Object text = editText.getText();
        Intrinsics.m26843a(text, "username.text");
        boolean z = false;
        if ((StringsKt__StringsKt.m42456b((CharSequence) text).length() > 0 ? 1 : false) != 0) {
            int i;
            CheckBox[] checkBoxArr = new CheckBox[7];
            CheckBox checkBox = this.fullPermission;
            if (checkBox == null) {
                Intrinsics.m26844a("fullPermission");
            }
            checkBoxArr[0] = checkBox;
            checkBox = this.accessPermission;
            if (checkBox == null) {
                Intrinsics.m26844a("accessPermission");
            }
            checkBoxArr[1] = checkBox;
            CheckBox checkBox2 = this.mailPermission;
            if (checkBox2 == null) {
                Intrinsics.m26844a("mailPermission");
            }
            checkBoxArr[2] = checkBox2;
            checkBox2 = this.configPermission;
            if (checkBox2 == null) {
                Intrinsics.m26844a("configPermission");
            }
            checkBoxArr[3] = checkBox2;
            checkBox2 = this.postsPermission;
            if (checkBox2 == null) {
                Intrinsics.m26844a("postsPermission");
            }
            checkBoxArr[4] = checkBox2;
            checkBox2 = this.flairPermission;
            if (checkBox2 == null) {
                Intrinsics.m26844a("flairPermission");
            }
            checkBoxArr[5] = checkBox2;
            checkBox2 = this.wikiPermission;
            if (checkBox2 == null) {
                Intrinsics.m26844a("wikiPermission");
            }
            checkBoxArr[6] = checkBox2;
            for (int i2 = 0; i2 < 7; i2++) {
                if (checkBoxArr[i2].isChecked()) {
                    i = 1;
                    break;
                }
            }
            i = false;
            if (i != 0) {
                z = true;
            }
        }
        menuItem.setEnabled(z);
    }

    public final void mo7393a(String str) {
        Intrinsics.m26847b(str, "username");
        m29351F();
        Controller k = k();
        if (k == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.modtools.ModAddUserTarget");
        }
        ((ModAddUserTarget) k).mo7384a(str, C1761R.string.mod_tools_action_invited_success);
    }

    public final void mo7394b(String str) {
        Intrinsics.m26847b(str, "username");
        m29351F();
        Controller k = k();
        if (k == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.modtools.modlist.ModeratorListTarget");
        }
        ((ModeratorListTarget) k).mo7675a(str);
    }

    public final void mo7241c(String str) {
        Intrinsics.m26847b(str, "errorMessage");
        str = Screens.m22629a(this, str, -1);
        if (str != null) {
            str.a();
        }
    }

    private final String m40801y() {
        Pair[] pairArr = new Pair[7];
        String str = "all";
        CheckBox checkBox = this.fullPermission;
        if (checkBox == null) {
            Intrinsics.m26844a("fullPermission");
        }
        pairArr[0] = TuplesKt.m26780a(str, checkBox);
        String str2 = "access";
        CheckBox checkBox2 = this.accessPermission;
        if (checkBox2 == null) {
            Intrinsics.m26844a("accessPermission");
        }
        pairArr[1] = TuplesKt.m26780a(str2, checkBox2);
        str2 = "config";
        checkBox2 = this.configPermission;
        if (checkBox2 == null) {
            Intrinsics.m26844a("configPermission");
        }
        pairArr[2] = TuplesKt.m26780a(str2, checkBox2);
        str2 = "flair";
        checkBox2 = this.flairPermission;
        if (checkBox2 == null) {
            Intrinsics.m26844a("flairPermission");
        }
        pairArr[3] = TuplesKt.m26780a(str2, checkBox2);
        str2 = "mail";
        checkBox2 = this.mailPermission;
        if (checkBox2 == null) {
            Intrinsics.m26844a("mailPermission");
        }
        pairArr[4] = TuplesKt.m26780a(str2, checkBox2);
        str2 = "posts";
        checkBox2 = this.postsPermission;
        if (checkBox2 == null) {
            Intrinsics.m26844a("postsPermission");
        }
        pairArr[5] = TuplesKt.m26780a(str2, checkBox2);
        str2 = "wiki";
        checkBox2 = this.wikiPermission;
        if (checkBox2 == null) {
            Intrinsics.m26844a("wikiPermission");
        }
        pairArr[6] = TuplesKt.m26780a(str2, checkBox2);
        Map a = MapsKt__MapsKt.m36121a(pairArr);
        Map linkedHashMap = new LinkedHashMap(MapsKt__MapsKt.m36115a(a.size()));
        for (Entry entry : a.entrySet()) {
            linkedHashMap.put(entry.getKey(), Boolean.valueOf(((CheckBox) entry.getValue()).isChecked()));
        }
        Iterable<Entry> entrySet = linkedHashMap.entrySet();
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(entrySet));
        for (Entry entry2 : entrySet) {
            char c = ((Boolean) entry2.getValue()).booleanValue() ? '+' : '-';
            str2 = (String) entry2.getKey();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(String.valueOf(c));
            stringBuilder.append(str2);
            arrayList.add(stringBuilder.toString());
        }
        return CollectionsKt___CollectionsKt.m41412a((Iterable) (List) arrayList, (CharSequence) ",", null, null, 0, null, null, 62);
    }

    private final void m40795O() {
        ((ModEventBuilder) ((ModEventBuilder) ((ModEventBuilder) ((ModEventBuilder) AppAnalytics.m21880q().m21888a(ModEventBuilder.f27455f)).m21892b(ModEventBuilder.f27450a)).m21895c(ModNoun.f20034F.f20068M)).m21889a(m40799w(), mo7392a())).m21891a();
    }
}
