package com.reddit.social.widgets;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.ui.sorting.SnoomojiPreviewDialog.OnSendListener;
import com.reddit.frontpage.util.Util;
import com.reddit.social.util.ChatUtilKt;
import com.reddit.social.widgets.WidgetKeyboard.Medium;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0003\u000f\u0010\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0016J\b\u0010\u000e\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/reddit/social/widgets/SnoomojiMedium;", "Lcom/reddit/social/widgets/WidgetKeyboard$Medium;", "sendListener", "Lcom/reddit/frontpage/ui/sorting/SnoomojiPreviewDialog$OnSendListener;", "(Lcom/reddit/frontpage/ui/sorting/SnoomojiPreviewDialog$OnSendListener;)V", "getSendListener", "()Lcom/reddit/frontpage/ui/sorting/SnoomojiPreviewDialog$OnSendListener;", "activeIcon", "", "content", "Landroid/view/View;", "context", "Landroid/content/Context;", "screenWidth", "icon", "SnoomojiAdapter", "SnoomojiGifViewHolder", "SnoomojiImageViewHolder", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: SnoomojiMedium.kt */
public final class SnoomojiMedium implements Medium {
    private final OnSendListener f29985a;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0015\u001a\u00020\fH\u0016J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\fH\u0016J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\fH\u0016J\u001a\u0010\u001b\u001a\u00020\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\fH\u0016R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/reddit/social/widgets/SnoomojiMedium$SnoomojiAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "snoomojiIcons", "", "snoomojiIds", "", "", "sendListener", "Lcom/reddit/frontpage/ui/sorting/SnoomojiPreviewDialog$OnSendListener;", "([I[Ljava/lang/String;Lcom/reddit/frontpage/ui/sorting/SnoomojiPreviewDialog$OnSendListener;)V", "TYPE_GIF", "", "TYPE_IMAGE", "getSendListener", "()Lcom/reddit/frontpage/ui/sorting/SnoomojiPreviewDialog$OnSendListener;", "getSnoomojiIcons", "()[I", "getSnoomojiIds", "()[Ljava/lang/String;", "[Ljava/lang/String;", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: SnoomojiMedium.kt */
    public static final class SnoomojiAdapter extends Adapter<ViewHolder> {
        final int[] f29978a;
        final String[] f29979b;
        final OnSendListener f29980c;
        private final int f29981f;
        private final int f29982g = 1;

        public SnoomojiAdapter(int[] iArr, String[] strArr, OnSendListener onSendListener) {
            Intrinsics.m26847b(iArr, "snoomojiIcons");
            Intrinsics.m26847b(strArr, "snoomojiIds");
            Intrinsics.m26847b(onSendListener, "sendListener");
            this.f29978a = iArr;
            this.f29979b = strArr;
            this.f29980c = onSendListener;
        }

        public final ViewHolder m30904a(ViewGroup viewGroup, int i) {
            if (i == this.f29981f) {
                if (viewGroup == null) {
                    Intrinsics.m26842a();
                }
                Object inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C1761R.layout.snoomoji_image_item, viewGroup, false);
                Intrinsics.m26843a(inflate, "itemView");
                return (ViewHolder) new SnoomojiImageViewHolder(inflate);
            }
            if (viewGroup == null) {
                Intrinsics.m26842a();
            }
            inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C1761R.layout.snoomoji_gif_item, viewGroup, false);
            Intrinsics.m26843a(inflate, "itemView");
            return (ViewHolder) new SnoomojiGifViewHolder(inflate);
        }

        public final int m30903a() {
            return this.f29978a.length;
        }

        public final void m30905a(ViewHolder viewHolder, int i) {
            Intrinsics.m26847b(viewHolder, "holder");
            if (m30906b(i) == this.f29981f) {
                ((SnoomojiImageViewHolder) viewHolder).f29984a.setImageDrawable(Util.m24032h(this.f29978a[i]));
            } else {
                GifImageView gifImageView = ((SnoomojiGifViewHolder) viewHolder).f29983a;
                Object obj = viewHolder.c;
                Intrinsics.m26843a(obj, "holder.itemView");
                obj = obj.getContext();
                Intrinsics.m26843a(obj, "holder.itemView.context");
                gifImageView.setImageDrawable(new GifDrawable(obj.getResources(), this.f29978a[i]));
            }
            viewHolder.c.setOnClickListener(new SnoomojiMedium$SnoomojiAdapter$onBindViewHolder$1(this, i, viewHolder));
        }

        public final int m30906b(int i) {
            return ChatUtilKt.m24755a(i) != 0 ? this.f29982g : this.f29981f;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/reddit/social/widgets/SnoomojiMedium$SnoomojiGifViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "videoPlayer", "Lpl/droidsonroids/gif/GifImageView;", "getVideoPlayer", "()Lpl/droidsonroids/gif/GifImageView;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: SnoomojiMedium.kt */
    public static final class SnoomojiGifViewHolder extends ViewHolder {
        final GifImageView f29983a;

        public SnoomojiGifViewHolder(View view) {
            Intrinsics.m26847b(view, "itemView");
            super(view);
            Object findViewById = view.findViewById(C1761R.id.video_player);
            Intrinsics.m26843a(findViewById, "itemView.findViewById(R.id.video_player)");
            this.f29983a = (GifImageView) findViewById;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/reddit/social/widgets/SnoomojiMedium$SnoomojiImageViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "imageView", "Landroid/widget/ImageView;", "getImageView", "()Landroid/widget/ImageView;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: SnoomojiMedium.kt */
    public static final class SnoomojiImageViewHolder extends ViewHolder {
        final ImageView f29984a;

        public SnoomojiImageViewHolder(View view) {
            Intrinsics.m26847b(view, "itemView");
            super(view);
            Object findViewById = view.findViewById(C1761R.id.image);
            Intrinsics.m26843a(findViewById, "itemView.findViewById(R.id.image)");
            this.f29984a = (ImageView) findViewById;
        }
    }

    public SnoomojiMedium(OnSendListener onSendListener) {
        Intrinsics.m26847b(onSendListener, "sendListener");
        this.f29985a = onSendListener;
    }

    public final View mo5207a(Context context, int i) {
        Intrinsics.m26847b(context, "context");
        Object inflate = LayoutInflater.from(context).inflate(C1761R.layout.snoomoji_content, null, false);
        Intrinsics.m26843a(inflate, "view");
        View findViewById = inflate.findViewById(C1761R.id.recycler_view);
        if (findViewById == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.support.v7.widget.RecyclerView");
        }
        RecyclerView recyclerView = (RecyclerView) findViewById;
        Object a = Util.m23992a();
        Object e = Util.m24023e((int) C1761R.array.snoomoji_ids);
        Intrinsics.m26843a(a, "snoomojiIcons");
        Intrinsics.m26843a(e, "snoomojiIds");
        recyclerView.setAdapter(new SnoomojiAdapter(a, e, this.f29985a));
        recyclerView.setLayoutManager(new GridLayoutManager(context, i / (Util.m24012d((int) C1761R.dimen.snoomoji_icon_dimen) + (2 * Util.m24012d((int) C1761R.dimen.single_pad)))));
        return inflate;
    }
}
