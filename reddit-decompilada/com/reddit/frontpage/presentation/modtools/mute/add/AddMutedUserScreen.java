package com.reddit.frontpage.presentation.modtools.mute.add;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnTextChanged;
import com.bluelinelabs.conductor.Controller;
import com.evernote.android.state.State;
import com.reddit.datalibrary.frontpage.data.model.MutedUser;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.builders.ModEventBuilder;
import com.reddit.frontpage.commons.analytics.builders.ModNoun;
import com.reddit.frontpage.di.component.DaggerAddMutedUserComponent;
import com.reddit.frontpage.di.module.AddMutedUserViewModule;
import com.reddit.frontpage.nav.Screens;
import com.reddit.frontpage.presentation.MvpBaseScreen;
import com.reddit.frontpage.presentation.modtools.ModAddUserTarget;
import com.reddit.frontpage.presentation.modtools.mute.add.AddMutedUserContract.View;
import com.reddit.frontpage.presentation.modtools.util.ModScreenMode;
import com.reddit.frontpage.util.Util;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\u0003\u0018\u0000 X2\u00020\u00012\u00020\u0002:\u0001XB\u0007\b\u0016¢\u0006\u0002\u0010\u0003B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010>\u001a\u00020?H\u0002J\b\u0010@\u001a\u00020AH\u0016J\b\u0010B\u001a\u00020AH\u0016J\b\u0010C\u001a\u00020DH\u0002J\u0018\u0010E\u001a\u00020?2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020IH\u0016J\u0018\u0010J\u001a\u00020K2\u0006\u0010H\u001a\u00020L2\u0006\u0010M\u001a\u00020NH\u0016J\u0010\u0010O\u001a\u00020?2\u0006\u0010P\u001a\u00020\bH\u0016J\u0010\u0010Q\u001a\u00020?2\u0006\u00108\u001a\u00020\bH\u0016J\u0010\u0010R\u001a\u00020D2\u0006\u0010S\u001a\u00020\u000eH\u0016J\u0010\u0010T\u001a\u00020?2\u0006\u0010U\u001a\u00020VH\u0007J\b\u0010W\u001a\u00020?H\u0002R\u001e\u0010\u0007\u001a\u00020\b8\u0016@\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\b8\u0016@\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\n\"\u0004\b\u001d\u0010\fR\u001e\u0010\u001e\u001a\u00020\b8\u0016@\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\n\"\u0004\b \u0010\fR\u001e\u0010!\u001a\u00020\b8\u0016@\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\n\"\u0004\b#\u0010\fR\u001e\u0010$\u001a\u00020%8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u000e\u0010*\u001a\u00020+X.¢\u0006\u0002\n\u0000R\u001e\u0010,\u001a\u00020\b8\u0016@\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\n\"\u0004\b.\u0010\fR\u001e\u0010/\u001a\u00020\b8\u0016@\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\n\"\u0004\b1\u0010\fR\u001e\u00102\u001a\u0002038\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001e\u00108\u001a\u00020\u00108\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0012\"\u0004\b:\u0010\u0014R\u001a\u0010;\u001a\u00020\bX.¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\n\"\u0004\b=\u0010\f¨\u0006Y"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/mute/add/AddMutedUserScreen;", "Lcom/reddit/frontpage/presentation/MvpBaseScreen;", "Lcom/reddit/frontpage/presentation/modtools/mute/add/AddMutedUserContract$View;", "()V", "bundle", "Landroid/os/Bundle;", "(Landroid/os/Bundle;)V", "commentId", "", "getCommentId", "()Ljava/lang/String;", "setCommentId", "(Ljava/lang/String;)V", "menuItem", "Landroid/view/MenuItem;", "modNote", "Landroid/widget/EditText;", "getModNote", "()Landroid/widget/EditText;", "setModNote", "(Landroid/widget/EditText;)V", "mutedUser", "Lcom/reddit/datalibrary/frontpage/data/model/MutedUser;", "getMutedUser", "()Lcom/reddit/datalibrary/frontpage/data/model/MutedUser;", "setMutedUser", "(Lcom/reddit/datalibrary/frontpage/data/model/MutedUser;)V", "postId", "getPostId", "setPostId", "postTitle", "getPostTitle", "setPostTitle", "postType", "getPostType", "setPostType", "presenter", "Lcom/reddit/frontpage/presentation/modtools/mute/add/AddMutedUserPresenter;", "getPresenter", "()Lcom/reddit/frontpage/presentation/modtools/mute/add/AddMutedUserPresenter;", "setPresenter", "(Lcom/reddit/frontpage/presentation/modtools/mute/add/AddMutedUserPresenter;)V", "screenMode", "Lcom/reddit/frontpage/presentation/modtools/util/ModScreenMode;", "subredditId", "getSubredditId", "setSubredditId", "subredditName", "getSubredditName", "setSubredditName", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "setTitle", "(Landroid/widget/TextView;)V", "username", "getUsername", "setUsername", "usernameString", "getUsernameString", "setUsernameString", "configureScreen", "", "getDefaultScreenPosition", "", "getLayoutId", "isFormValid", "", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onCreateView", "Landroid/view/View;", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onMuteUserError", "errorMessage", "onMuteUserSuccess", "onOptionsItemSelected", "item", "onUsernameTextChanged", "textChanged", "", "updateMenuButton", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: AddMutedUserScreen.kt */
public final class AddMutedUserScreen extends MvpBaseScreen implements View {
    public static final Companion f40107y = new Companion();
    private ModScreenMode f40108A;
    @State
    public String commentId;
    @BindView
    public EditText modNote;
    @State
    public String postId;
    @State
    public String postTitle;
    @State
    public String postType;
    @State
    public String subredditId;
    @State
    public String subredditName;
    @BindView
    public TextView title;
    @BindView
    public EditText username;
    public String f40109v;
    public MutedUser f40110w;
    @Inject
    public AddMutedUserPresenter f40111x;
    private MenuItem f40112z;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007J@\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0007¨\u0006\u000f"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/mute/add/AddMutedUserScreen$Companion;", "", "()V", "newInstance", "Lcom/reddit/frontpage/presentation/modtools/mute/add/AddMutedUserScreen;", "subredditId", "", "subredditName", "mutedUser", "Lcom/reddit/datalibrary/frontpage/data/model/MutedUser;", "username", "postId", "postType", "postTitle", "commentId", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: AddMutedUserScreen.kt */
    public static final class Companion {
        private Companion() {
        }

        public static AddMutedUserScreen m23140a(String str, String str2) {
            Intrinsics.m26847b(str, "subredditId");
            Intrinsics.m26847b(str2, "subredditName");
            AddMutedUserScreen addMutedUserScreen = new AddMutedUserScreen();
            addMutedUserScreen.m40838d(str);
            addMutedUserScreen.mo7241c(str2);
            addMutedUserScreen.f40108A = ModScreenMode.f20921a;
            addMutedUserScreen.m40840e("");
            addMutedUserScreen.m40841f("");
            return addMutedUserScreen;
        }

        public static AddMutedUserScreen m23141a(String str, String str2, MutedUser mutedUser) {
            Intrinsics.m26847b(str, "subredditId");
            Intrinsics.m26847b(str2, "subredditName");
            Intrinsics.m26847b(mutedUser, "mutedUser");
            AddMutedUserScreen addMutedUserScreen = new AddMutedUserScreen();
            addMutedUserScreen.m40838d(str);
            addMutedUserScreen.mo7241c(str2);
            Intrinsics.m26847b(mutedUser, "<set-?>");
            addMutedUserScreen.f40110w = mutedUser;
            addMutedUserScreen.f40108A = ModScreenMode.f20922b;
            addMutedUserScreen.m40840e("");
            addMutedUserScreen.m40841f("");
            return addMutedUserScreen;
        }

        public static AddMutedUserScreen m23142a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
            Intrinsics.m26847b(str, "subredditId");
            Intrinsics.m26847b(str2, "subredditName");
            Intrinsics.m26847b(str3, "username");
            Intrinsics.m26847b(str4, "postId");
            Intrinsics.m26847b(str5, "postType");
            Intrinsics.m26847b(str6, "postTitle");
            Intrinsics.m26847b(str7, "commentId");
            AddMutedUserScreen addMutedUserScreen = new AddMutedUserScreen();
            addMutedUserScreen.m40838d(str);
            addMutedUserScreen.mo7241c(str2);
            Intrinsics.m26847b(str3, "<set-?>");
            addMutedUserScreen.f40109v = str3;
            addMutedUserScreen.f40108A = ModScreenMode.f20923c;
            addMutedUserScreen.m40840e(str4);
            Intrinsics.m26847b(str5, "<set-?>");
            addMutedUserScreen.postType = str5;
            Intrinsics.m26847b(str6, "<set-?>");
            addMutedUserScreen.postTitle = str6;
            addMutedUserScreen.m40841f(str7);
            return addMutedUserScreen;
        }
    }

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] f20914a;

        static {
            int[] iArr = new int[ModScreenMode.values().length];
            f20914a = iArr;
            iArr[ModScreenMode.f20921a.ordinal()] = 1;
            f20914a[ModScreenMode.f20922b.ordinal()] = 2;
            f20914a[ModScreenMode.f20923c.ordinal()] = 3;
        }
    }

    public static final AddMutedUserScreen m40824a(String str, String str2) {
        return Companion.m23140a(str, str2);
    }

    public static final AddMutedUserScreen m40825a(String str, String str2, MutedUser mutedUser) {
        return Companion.m23141a(str, str2, mutedUser);
    }

    public static final AddMutedUserScreen m40826a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        return Companion.m23142a(str, str2, str3, str4, str5, str6, str7);
    }

    public final int mo7141s() {
        return C1761R.layout.screen_add_muted_user;
    }

    public final int mo7143u() {
        return 2;
    }

    public AddMutedUserScreen() {
        super();
        DaggerAddMutedUserComponent.m28998a().m22054a(FrontpageApplication.m28875k()).m22055a(new AddMutedUserViewModule(this)).m22053a().mo4583a(this);
    }

    public AddMutedUserScreen(Bundle bundle) {
        Intrinsics.m26847b(bundle, "bundle");
        super(bundle);
        DaggerAddMutedUserComponent.m28998a().m22054a(FrontpageApplication.m28875k()).m22055a(new AddMutedUserViewModule(this)).m22053a().mo4583a(this);
    }

    @OnTextChanged
    public final void onUsernameTextChanged(CharSequence charSequence) {
        Intrinsics.m26847b(charSequence, "textChanged");
        Object obj = this.f40108A;
        if (obj == null) {
            Intrinsics.m26844a("screenMode");
        }
        if (Intrinsics.m26845a(obj, ModScreenMode.f20921a) != null) {
            charSequence = this.f40112z;
            if (charSequence == null) {
                Intrinsics.m26844a("menuItem");
            }
            EditText editText = this.username;
            if (editText == null) {
                Intrinsics.m26844a("username");
            }
            Object text = editText.getText();
            Intrinsics.m26843a(text, "username.text");
            charSequence.setEnabled(StringsKt__StringsKt.m42456b((CharSequence) text).length() > 0);
        }
    }

    public final String mo7401b() {
        String str = this.subredditName;
        if (str == null) {
            Intrinsics.m26844a("subredditName");
        }
        return str;
    }

    public final void mo7241c(String str) {
        Intrinsics.m26847b(str, "<set-?>");
        this.subredditName = str;
    }

    public final String mo7399a() {
        String str = this.subredditId;
        if (str == null) {
            Intrinsics.m26844a("subredditId");
        }
        return str;
    }

    public final void m40838d(String str) {
        Intrinsics.m26847b(str, "<set-?>");
        this.subredditId = str;
    }

    public final String mo7403c() {
        String str = this.postId;
        if (str == null) {
            Intrinsics.m26844a("postId");
        }
        return str;
    }

    public final void m40840e(String str) {
        Intrinsics.m26847b(str, "<set-?>");
        this.postId = str;
    }

    public final String mo7404d() {
        String str = this.postType;
        if (str == null) {
            Intrinsics.m26844a("postType");
        }
        return str;
    }

    public final String mo7405e() {
        String str = this.postTitle;
        if (str == null) {
            Intrinsics.m26844a("postTitle");
        }
        return str;
    }

    public final String S_() {
        String str = this.commentId;
        if (str == null) {
            Intrinsics.m26844a("commentId");
        }
        return str;
    }

    public final void m40841f(String str) {
        Intrinsics.m26847b(str, "<set-?>");
        this.commentId = str;
    }

    public final android.view.View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.m26847b(layoutInflater, "inflater");
        Intrinsics.m26847b(viewGroup, "container");
        super.mo7139a(layoutInflater, viewGroup);
        n();
        layoutInflater = this.f40108A;
        if (layoutInflater == null) {
            Intrinsics.m26844a("screenMode");
        }
        switch (WhenMappings.f20914a[layoutInflater.ordinal()]) {
            case 1:
                layoutInflater = this.title;
                if (layoutInflater == null) {
                    Intrinsics.m26844a("title");
                }
                layoutInflater.setText(Util.m24027f((int) C1761R.string.mod_tools_add_muted_user));
                break;
            case 2:
                layoutInflater = this.title;
                if (layoutInflater == null) {
                    Intrinsics.m26844a("title");
                }
                layoutInflater.setText(Util.m24027f((int) C1761R.string.mod_tools_edit_muted_user));
                layoutInflater = this.username;
                if (layoutInflater == null) {
                    Intrinsics.m26844a("username");
                }
                MutedUser mutedUser = this.f40110w;
                if (mutedUser == null) {
                    Intrinsics.m26844a("mutedUser");
                }
                layoutInflater.setText(mutedUser.getUsername());
                layoutInflater = this.username;
                if (layoutInflater == null) {
                    Intrinsics.m26844a("username");
                }
                layoutInflater.setFocusable(false);
                layoutInflater = this.modNote;
                if (layoutInflater == null) {
                    Intrinsics.m26844a("modNote");
                }
                viewGroup = this.f40110w;
                if (viewGroup == null) {
                    Intrinsics.m26844a("mutedUser");
                }
                layoutInflater.setText(viewGroup.getReason());
                layoutInflater = this.modNote;
                if (layoutInflater == null) {
                    Intrinsics.m26844a("modNote");
                }
                viewGroup = this.modNote;
                if (viewGroup == null) {
                    Intrinsics.m26844a("modNote");
                }
                layoutInflater.setSelection(viewGroup.getText().length());
                break;
            case 3:
                layoutInflater = this.username;
                if (layoutInflater == null) {
                    Intrinsics.m26844a("username");
                }
                String str = this.f40109v;
                if (str == null) {
                    Intrinsics.m26844a("usernameString");
                }
                layoutInflater.setText(str);
                layoutInflater = this.username;
                if (layoutInflater == null) {
                    Intrinsics.m26844a("username");
                }
                layoutInflater.setFocusable(false);
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        Object obj = this.K;
        Intrinsics.m26843a(obj, "rootView");
        return obj;
    }

    public final void m40830a(Menu menu, MenuInflater menuInflater) {
        Intrinsics.m26847b(menu, "menu");
        Intrinsics.m26847b(menuInflater, "inflater");
        super.a(menu, menuInflater);
        menuInflater.inflate(C1761R.menu.menu_modtools_add_user, menu);
        Object findItem = menu.findItem(C1761R.id.action_modtools_add);
        Intrinsics.m26843a(findItem, "menu.findItem(R.id.action_modtools_add)");
        this.f40112z = findItem;
        findItem = this.f40108A;
        if (findItem == null) {
            Intrinsics.m26844a("screenMode");
        }
        if ((Intrinsics.m26845a(findItem, ModScreenMode.f20921a) ^ 1) != null) {
            menu = this.f40112z;
            if (menu == null) {
                Intrinsics.m26844a("menuItem");
            }
            menu.setTitle(C1761R.string.action_modtools_save);
            menu = this.f40112z;
            if (menu == null) {
                Intrinsics.m26844a("menuItem");
            }
            menu.setEnabled(true);
        }
    }

    public final boolean mo7201a(MenuItem menuItem) {
        Intrinsics.m26847b(menuItem, "item");
        if (menuItem.getItemId() != C1761R.id.action_modtools_add) {
            return super.mo7201a(menuItem);
        }
        String str;
        ModEventBuilder modEventBuilder = (ModEventBuilder) ((ModEventBuilder) AppAnalytics.m21880q().m21888a(ModEventBuilder.f27453d)).m21892b(ModEventBuilder.f27450a);
        Object obj = this.f40108A;
        if (obj == null) {
            Intrinsics.m26844a("screenMode");
        }
        if (Intrinsics.m26845a(obj, ModScreenMode.f20921a)) {
            str = ModNoun.f20063v.f20068M;
        } else {
            str = ModNoun.f20058q.f20068M;
        }
        ((ModEventBuilder) ((ModEventBuilder) modEventBuilder.m21895c(str)).m21889a(mo7399a(), mo7401b())).m21891a();
        menuItem = this.f40111x;
        if (menuItem == null) {
            Intrinsics.m26844a("presenter");
        }
        EditText editText = this.username;
        if (editText == null) {
            Intrinsics.m26844a("username");
        }
        obj = editText.getText();
        Intrinsics.m26843a(obj, "username.text");
        str = StringsKt__StringsKt.m42456b((CharSequence) obj).toString();
        EditText editText2 = this.modNote;
        if (editText2 == null) {
            Intrinsics.m26844a("modNote");
        }
        menuItem.m34812a(str, editText2.getText().toString());
        return true;
    }

    public final void mo7400a(String str) {
        Intrinsics.m26847b(str, "username");
        m29351F();
        Controller k = k();
        if (k == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.modtools.ModAddUserTarget");
        }
        ((ModAddUserTarget) k).mo7384a(str, C1761R.string.mod_tools_action_mute_success);
    }

    public final void mo7402b(String str) {
        Intrinsics.m26847b(str, "errorMessage");
        str = Screens.m22629a(this, str, -1);
        if (str != null) {
            str.a();
        }
    }
}
