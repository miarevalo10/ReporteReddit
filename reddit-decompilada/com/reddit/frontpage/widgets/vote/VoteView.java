package com.reddit.frontpage.widgets.vote;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import com.reddit.datalibrary.frontpage.redditauth.account.AccountUtil;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.requests.models.Votable;
import com.reddit.datalibrary.frontpage.requests.models.Votable.AdAnalyticsInfo;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import com.reddit.frontpage.ui.alert.RedditAlertDialog;
import com.reddit.frontpage.ui.alert.RedditAlertDialog.Companion;
import com.reddit.frontpage.util.CountUtil;
import com.reddit.frontpage.util.VoteUtil;
import com.reddit.frontpage.util.kotlin.ViewGroupsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.Sdk21PropertiesKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001?B%\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB)\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0002\u0010\nJ*\u0010*\u001a\u00020+2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010,\u001a\u00020+H\u0002J\b\u0010-\u001a\u00020+H\u0014J\b\u0010.\u001a\u00020+H\u0002J\u0010\u0010/\u001a\u00020+2\u0006\u00100\u001a\u00020\u0007H\u0002J\u000e\u00101\u001a\u00020+2\u0006\u00102\u001a\u00020\u0007J\u0010\u00103\u001a\u00020+2\u0006\u00104\u001a\u00020\u0011H\u0016J\b\u00105\u001a\u00020+H\u0002J\u0018\u00106\u001a\u00020+2\u0006\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010$J\u0018\u00106\u001a\u00020+2\u0006\u0010:\u001a\u00020;2\b\u00109\u001a\u0004\u0018\u00010$J\b\u0010<\u001a\u00020+H\u0002J\b\u0010=\u001a\u00020+H\u0002J\b\u0010>\u001a\u00020+H\u0002R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u0012\u0010\u001f\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010 \u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\b\n\u0000\u0012\u0004\b!\u0010\"R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/reddit/frontpage/widgets/vote/VoteView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "downvoteView", "Landroid/widget/ImageView;", "downvotedColor", "hiddenScoreText", "", "hideScore", "", "isAccountSuspended", "neutralColor", "onVoteChangeListener", "Lcom/reddit/frontpage/widgets/vote/OnVoteChangeListener;", "getOnVoteChangeListener", "()Lcom/reddit/frontpage/widgets/vote/OnVoteChangeListener;", "setOnVoteChangeListener", "(Lcom/reddit/frontpage/widgets/vote/OnVoteChangeListener;)V", "score", "scoreModifier", "scoreView", "Landroid/widget/TextView;", "upvoteView", "upvotedColor", "userVoteState", "userVoteState$annotations", "()V", "votableAdInfo", "Lcom/reddit/datalibrary/frontpage/requests/models/Votable$AdAnalyticsInfo;", "votableCachedName", "votableDomain", "votableName", "votableType", "voteContext", "init", "", "onDownvoteClicked", "onFinishInflate", "onUpvoteClicked", "onVoteClicked", "direction", "setColor", "color", "setEnabled", "enabled", "setupVoteClickListeners", "update", "votable", "Lcom/reddit/datalibrary/frontpage/requests/models/Votable;", "adInfo", "model", "Lcom/reddit/frontpage/presentation/detail/CommentPresentationModel;", "updateButtonState", "updateDownvoteVisibility", "updateVoteCount", "VoteClickListener", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: VoteView.kt */
public final class VoteView extends LinearLayout {
    private OnVoteChangeListener f22260a;
    private ImageView f22261b;
    private TextView f22262c;
    private ImageView f22263d;
    private String f22264e;
    private String f22265f;
    private int f22266g;
    private int f22267h;
    private int f22268i;
    private int f22269j;
    private int f22270k;
    private String f22271l;
    private String f22272m;
    private String f22273n;
    private boolean f22274o;
    private int f22275p;
    private String f22276q;
    private boolean f22277r;
    private AdAnalyticsInfo f22278s;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/reddit/frontpage/widgets/vote/VoteView$VoteClickListener;", "Landroid/view/View$OnClickListener;", "direction", "", "(Lcom/reddit/frontpage/widgets/vote/VoteView;I)V", "controlName", "", "onClick", "", "view", "Landroid/view/View;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: VoteView.kt */
    private final class VoteClickListener implements OnClickListener {
        final /* synthetic */ VoteView f22256a;
        private final String f22257b;
        private final int f22258c;

        public VoteClickListener(VoteView voteView, int i) {
            this.f22256a = voteView;
            this.f22258c = i;
            i = new StringBuilder();
            i.append(VoteView.m24411f(voteView));
            i.append(this.f22258c == 1 ? "_upvote" : "_downvote");
            this.f22257b = i.toString();
        }

        public final void onClick(View view) {
            Intrinsics.m26847b(view, "view");
            AppAnalytics.m21858b().m21823a(view).m21826b(this.f22257b).m21828d(this.f22256a.f22271l).m21830f(this.f22256a.f22273n).m21829e(this.f22256a.f22276q).m21825a();
            view = this.f22256a.getOnVoteChangeListener();
            if (view == null || view.mo4894a() != null) {
                VoteView.m24404a(this.f22256a, this.f22258c);
                view = this.f22256a.getOnVoteChangeListener();
                if (view != null) {
                    view.mo4893a(this.f22256a.f22271l, this.f22256a.f22269j, this.f22256a.f22278s);
                }
            }
        }
    }

    public VoteView(Context context) {
        this(context, null, 0, 6, null);
    }

    public VoteView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public static final /* synthetic */ String m24411f(VoteView voteView) {
        voteView = voteView.f22264e;
        if (voteView == null) {
            Intrinsics.m26844a("voteContext");
        }
        return voteView;
    }

    public static final /* synthetic */ TextView m24412g(VoteView voteView) {
        voteView = voteView.f22262c;
        if (voteView == null) {
            Intrinsics.m26844a("scoreView");
        }
        return voteView;
    }

    public static final /* synthetic */ ImageView m24413h(VoteView voteView) {
        voteView = voteView.f22263d;
        if (voteView == null) {
            Intrinsics.m26844a("downvoteView");
        }
        return voteView;
    }

    public final OnVoteChangeListener getOnVoteChangeListener() {
        return this.f22260a;
    }

    public final void setOnVoteChangeListener(OnVoteChangeListener onVoteChangeListener) {
        this.f22260a = onVoteChangeListener;
    }

    public /* synthetic */ VoteView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i2 & 2) != null) {
            attributeSet = null;
        }
        if ((i2 & 4) != 0) {
            i = C1761R.attr.voteViewStyle;
        }
        this(context, attributeSet, i);
    }

    public VoteView(Context context, AttributeSet attributeSet, int i) {
        Intrinsics.m26847b(context, "context");
        super(context, attributeSet, i);
        m24403a(context, attributeSet, i, 0);
    }

    @TargetApi(21)
    public VoteView(Context context, AttributeSet attributeSet, int i, int i2) {
        Intrinsics.m26847b(context, "context");
        super(context, attributeSet, i, i2);
        m24403a(context, attributeSet, i, i2);
    }

    private final void m24403a(Context context, AttributeSet attributeSet, int i, int i2) {
        setOrientation(0);
        setClipToPadding(false);
        setClickable(true);
        ViewGroupsKt.m24100a(this, C1761R.layout.merge_vote_view, true);
        attributeSet = context.obtainStyledAttributes(attributeSet, C1761R.styleable.VoteView, i, i2);
        try {
            Object string = attributeSet.getString(1);
            Intrinsics.m26843a(string, "a.getString(R.styleable.VoteView_voteContext)");
            this.f22264e = string;
            string = attributeSet.getString(0);
            Intrinsics.m26843a(string, "a.getString(R.styleable.VoteView_hiddenScoreText)");
            this.f22265f = string;
            if (isInEditMode() == null && AccountUtil.a(SessionManager.b()) != null) {
                this.f22277r = true;
            }
            this.f22266g = ContextCompat.c(context, C1761R.color.rdt_orangered);
            this.f22267h = ContextCompat.c(context, C1761R.color.rdt_periwinkle);
            this.f22268i = ResourcesUtil.m22740i(context, C1761R.attr.rdt_action_text_color);
            Object findViewById = findViewById(C1761R.id.vote_view_upvote);
            Intrinsics.m26843a(findViewById, "findViewById(R.id.vote_view_upvote)");
            this.f22261b = (ImageView) findViewById;
            findViewById = findViewById(C1761R.id.vote_view_score);
            Intrinsics.m26843a(findViewById, "findViewById(R.id.vote_view_score)");
            this.f22262c = (TextView) findViewById;
            findViewById = findViewById(C1761R.id.vote_view_downvote);
            Intrinsics.m26843a(findViewById, "findViewById(R.id.vote_view_downvote)");
            this.f22263d = (ImageView) findViewById;
            context = new VoteClickListener(this, 1);
            attributeSet = new VoteClickListener(this, -1);
            i = this.f22263d;
            if (i == 0) {
                Intrinsics.m26844a("downvoteView");
            }
            i.setOnClickListener((OnClickListener) attributeSet);
            setOnClickListener((OnClickListener) context);
        } finally {
            attributeSet.recycle();
        }
    }

    public final void setColor(int i) {
        TextView textView = this.f22262c;
        if (textView == null) {
            Intrinsics.m26844a("scoreView");
        }
        textView.setTextColor(i);
    }

    protected final void onFinishInflate() {
        super.onFinishInflate();
        post(new VoteView$onFinishInflate$1(this));
    }

    public final void setEnabled(boolean z) {
        super.setEnabled(z);
        setAlpha(z ? 1.0f : 0.5f);
        m24408c();
        ImageView imageView = this.f22263d;
        if (imageView == null) {
            Intrinsics.m26844a("downvoteView");
        }
        imageView.setEnabled(z);
    }

    public final void m24414a(Votable votable, AdAnalyticsInfo adAnalyticsInfo) {
        Intrinsics.m26847b(votable, "votable");
        this.f22274o = votable.isScoreHidden();
        this.f22275p = votable.getScore();
        this.f22271l = votable.getName();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(votable.getName());
        stringBuilder.append(Operation.DIVISION);
        stringBuilder.append(votable.getInstanceId());
        this.f22272m = stringBuilder.toString();
        this.f22273n = votable.getDomain();
        this.f22276q = votable.getVotableType();
        this.f22278s = adAnalyticsInfo;
        adAnalyticsInfo = VoteUtil.m24064a(this.f22272m);
        int i = 0;
        this.f22270k = adAnalyticsInfo != null ? adAnalyticsInfo.intValue() : 0;
        this.f22269j = this.f22270k != 0 ? this.f22270k : votable.getVoteDirection();
        if (this.f22270k == null && this.f22269j == 1 && adAnalyticsInfo != null) {
            this.f22270k = -this.f22269j;
            this.f22269j = 0;
        } else if (this.f22270k == this.f22269j) {
            if (this.f22270k <= null) {
                i = this.f22269j + this.f22269j;
            }
            this.f22270k = i;
        }
        m24402a();
        m24406b();
    }

    private final void m24402a() {
        if (!this.f22274o) {
            if (this.f22275p != 0 || this.f22269j != 0) {
                int i = this.f22275p + this.f22270k;
                TextView textView = this.f22262c;
                if (textView == null) {
                    Intrinsics.m26844a("scoreView");
                }
                textView.setText(CountUtil.m23674a((long) i));
                return;
            }
        }
        TextView textView2 = this.f22262c;
        if (textView2 == null) {
            Intrinsics.m26844a("scoreView");
        }
        String str = this.f22265f;
        if (str == null) {
            Intrinsics.m26844a("hiddenScoreText");
        }
        textView2.setText(str);
    }

    private final void m24406b() {
        int i;
        boolean z = false;
        boolean z2 = this.f22269j == 1;
        if (this.f22269j == -1) {
            z = true;
        }
        if (z2) {
            i = this.f22266g;
        } else if (z) {
            i = this.f22267h;
        } else {
            i = this.f22268i;
        }
        ImageView imageView = this.f22261b;
        if (imageView == null) {
            Intrinsics.m26844a("upvoteView");
        }
        imageView.setSelected(z2);
        TextView textView = this.f22262c;
        if (textView == null) {
            Intrinsics.m26844a("scoreView");
        }
        Sdk21PropertiesKt.m28412a(textView, i);
        ImageView imageView2 = this.f22263d;
        if (imageView2 == null) {
            Intrinsics.m26844a("downvoteView");
        }
        imageView2.setSelected(z);
        m24408c();
    }

    private final void m24408c() {
        int i = 1;
        int i2 = 0;
        int i3 = this.f22269j == -1 ? 1 : 0;
        if (!isEnabled()) {
            if (i3 == 0) {
                i = 0;
            }
        }
        ImageView imageView = this.f22263d;
        if (imageView == null) {
            Intrinsics.m26844a("downvoteView");
        }
        if (i == 0) {
            i2 = 8;
        }
        imageView.setVisibility(i2);
    }

    public static final /* synthetic */ void m24404a(VoteView voteView, int i) {
        if (voteView.isEnabled()) {
            if (voteView.f22277r) {
                i = RedditAlertDialog.f21112b;
                Context context = voteView.getContext();
                Intrinsics.m26843a((Object) context, "context");
                Companion.m23289a(context).m23323a();
                return;
            }
            if (i != -1) {
                if (i == 1) {
                    switch (voteView.f22269j) {
                        case -1:
                            voteView.f22269j = 1;
                            voteView.f22270k += 2;
                            break;
                        case 0:
                            voteView.f22269j = 1;
                            voteView.f22270k++;
                            break;
                        case 1:
                            voteView.f22269j = 0;
                            voteView.f22270k--;
                            break;
                        default:
                            break;
                    }
                }
            } else {
                switch (voteView.f22269j) {
                    case -1:
                        voteView.f22269j = 0;
                        voteView.f22270k++;
                        break;
                    case 0:
                        voteView.f22269j = -1;
                        voteView.f22270k--;
                        break;
                    case 1:
                        voteView.f22269j = -1;
                        voteView.f22270k -= 2;
                        break;
                    default:
                        break;
                }
            }
            VoteUtil.m24066a(voteView.f22272m, Integer.valueOf(voteView.f22269j));
            voteView.m24406b();
            voteView.m24402a();
        }
    }
}
