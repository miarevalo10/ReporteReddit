package com.reddit.frontpage.presentation.listing.ui.view;

import android.support.v7.widget.PopupMenu.OnMenuItemClickListener;
import android.view.View.OnClickListener;
import com.reddit.frontpage.presentation.listing.model.LinkPresentationModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0016\u0010\t\u001a\u00020\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0010H&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0012H&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u000eH&¨\u0006\u0015"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/ui/view/LinkHeader;", "", "addRunnableToOverflowClickListener", "", "listener", "Ljava/lang/Runnable;", "bindLink", "link", "Lcom/reddit/frontpage/presentation/listing/model/LinkPresentationModel;", "setClickListener", "action", "Lkotlin/Function0;", "setDisplaySubredditName", "showDisplaySubredditName", "", "setDomainClickListener", "Landroid/view/View$OnClickListener;", "setOnMenuItemClickListener", "Landroid/support/v7/widget/PopupMenu$OnMenuItemClickListener;", "setShowOverflow", "showOverflow", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LinkHeader.kt */
public interface LinkHeader {
    void a_(LinkPresentationModel linkPresentationModel);

    void setClickListener(Function0<Unit> function0);

    void setDisplaySubredditName(boolean z);

    void setDomainClickListener(OnClickListener onClickListener);

    void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener);

    void setShowOverflow(boolean z);
}
