package com.reddit.frontpage.presentation.listing.ui.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.reddit.config.GlideApp;
import com.reddit.datalibrary.frontpage.requests.images.ImageProgressLoadListener;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.animation.SnooProgressDrawable;
import com.reddit.frontpage.presentation.listing.model.LinkPresentationModel;
import com.reddit.frontpage.presentation.listing.util.Size;
import com.reddit.frontpage.ui.listener.Consumer;
import com.reddit.frontpage.ui.listing.newcard.LinkFlairView;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import com.reddit.frontpage.widgets.LinkTitleView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 &2\u00020\u0001:\u0001&B\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020#H\u0014J\u0010\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u0006H\u0014R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0016\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/ui/viewholder/ImageCardLinkViewHolder;", "Lcom/reddit/frontpage/presentation/listing/ui/viewholder/LinkViewHolder;", "itemView", "Landroid/view/View;", "lastClickPositionListener", "Lcom/reddit/frontpage/ui/listener/Consumer;", "", "(Landroid/view/View;Lcom/reddit/frontpage/ui/listener/Consumer;)V", "domainView", "Landroid/widget/TextView;", "flairView", "Lcom/reddit/frontpage/ui/listing/newcard/LinkFlairView;", "previewSize", "Lcom/reddit/frontpage/presentation/listing/util/Size;", "previewView", "Landroid/widget/ImageView;", "progressDrawable", "Lcom/reddit/frontpage/animation/SnooProgressDrawable;", "getProgressDrawable", "()Lcom/reddit/frontpage/animation/SnooProgressDrawable;", "progressDrawable$delegate", "Lkotlin/Lazy;", "screenHeight", "screenWidth", "titleView", "Lcom/reddit/frontpage/widgets/LinkTitleView;", "bindImage", "", "previewImage", "Lcom/reddit/frontpage/domain/model/ImageResolution;", "bindLink", "link", "Lcom/reddit/frontpage/presentation/listing/model/LinkPresentationModel;", "updateLinkFlairVisibility", "visible", "", "updateReadStatus", "alpha", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ImageCardLinkViewHolder.kt */
public final class ImageCardLinkViewHolder extends LinkViewHolder {
    static final /* synthetic */ KProperty[] f36905a = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(ImageCardLinkViewHolder.class), "progressDrawable", "getProgressDrawable()Lcom/reddit/frontpage/animation/SnooProgressDrawable;"))};
    public static final Companion f36906b = new Companion();
    private final TextView f36907A;
    private final int f36908B;
    private final int f36909C;
    private final Size f36910D;
    private final Lazy f36911E;
    private final LinkTitleView f36912x;
    private final LinkFlairView f36913y;
    private final ImageView f36914z;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0007¨\u0006\n"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/ui/viewholder/ImageCardLinkViewHolder$Companion;", "", "()V", "create", "Lcom/reddit/frontpage/presentation/listing/ui/viewholder/ImageCardLinkViewHolder;", "parent", "Landroid/view/ViewGroup;", "lastClickPositionListener", "Lcom/reddit/frontpage/ui/listener/Consumer;", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ImageCardLinkViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public static ImageCardLinkViewHolder m23050a(ViewGroup viewGroup, Consumer<Integer> consumer) {
            Intrinsics.m26847b(viewGroup, "parent");
            Intrinsics.m26847b(consumer, "lastClickPositionListener");
            Object inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C1761R.layout.item_image_card_link, viewGroup, false);
            Intrinsics.m26843a(inflate, "view");
            return new ImageCardLinkViewHolder(inflate, consumer);
        }
    }

    public static final ImageCardLinkViewHolder m37291a(ViewGroup viewGroup, Consumer<Integer> consumer) {
        return Companion.m23050a(viewGroup, consumer);
    }

    private final SnooProgressDrawable m37292v() {
        return (SnooProgressDrawable) this.f36911E.mo5678b();
    }

    private ImageCardLinkViewHolder(View view, final Consumer<Integer> consumer) {
        super(view);
        Object obj = (LinkTitleView) view.findViewById(C1761R.id.link_title);
        Intrinsics.m26843a(obj, "itemView.link_title");
        this.f36912x = obj;
        obj = (LinkFlairView) view.findViewById(C1761R.id.link_flair);
        Intrinsics.m26843a(obj, "itemView.link_flair");
        this.f36913y = obj;
        obj = (RelativeLayout) view.findViewById(C1761R.id.preview_container);
        Intrinsics.m26843a(obj, "itemView.preview_container");
        obj = (ImageView) ((View) obj).findViewById(C1761R.id.link_preview);
        Intrinsics.m26843a(obj, "itemView.preview_container.link_preview");
        this.f36914z = obj;
        obj = (RelativeLayout) view.findViewById(C1761R.id.preview_container);
        Intrinsics.m26843a(obj, "itemView.preview_container");
        obj = (TextView) ((View) obj).findViewById(C1761R.id.link_domain);
        Intrinsics.m26843a(obj, "itemView.preview_container.link_domain");
        this.f36907A = obj;
        obj = Util.m24014d(view.getContext());
        Intrinsics.m26843a(obj, "Util.toActivity(itemView.context)");
        obj = obj.getWindow();
        Intrinsics.m26843a(obj, "Util.toActivity(itemView.context).window");
        obj = obj.getDecorView();
        Intrinsics.m26843a(obj, "Util.toActivity(itemView.context).window.decorView");
        this.f36908B = obj.getWidth();
        obj = Util.m24014d(view.getContext());
        Intrinsics.m26843a(obj, "Util.toActivity(itemView.context)");
        obj = obj.getWindow();
        Intrinsics.m26843a(obj, "Util.toActivity(itemView.context).window");
        obj = obj.getDecorView();
        Intrinsics.m26843a(obj, "Util.toActivity(itemView.context).window.decorView");
        this.f36909C = obj.getHeight();
        this.f36910D = new Size(this.f36908B, this.f36909C);
        this.f36911E = LazyKt.m26777a(new ImageCardLinkViewHolder$progressDrawable$2(view));
        this.f36914z.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                view = this.f34045r;
                if (view != null) {
                    Consumer consumer = consumer;
                    if (consumer != null) {
                        consumer.mo4813a(Integer.valueOf(this.d()));
                    }
                    view.mo4828a(this.m34773O());
                }
            }
        });
    }

    public final void mo6963a(LinkPresentationModel linkPresentationModel) {
        Object text;
        Intrinsics.m26847b(linkPresentationModel, "link");
        super.mo6963a(linkPresentationModel);
        this.f36912x.m35294a(linkPresentationModel);
        this.f36913y.m23475a(linkPresentationModel);
        TextView textView = this.f36907A;
        String str = linkPresentationModel.f33964Q;
        if (str == null) {
            str = linkPresentationModel.getDomain();
        }
        textView.setText(str);
        View view = textView;
        boolean z = true;
        if (linkPresentationModel.f33962O) {
            text = textView.getText();
            Intrinsics.m26843a(text, "text");
            if (text.length() > 0) {
                ViewsKt.m24106b(view, z);
                linkPresentationModel = linkPresentationModel.f33954G;
                linkPresentationModel = linkPresentationModel == null ? linkPresentationModel.m29675a(this.f36910D) : null;
                if (linkPresentationModel != null) {
                    this.f36914z.setVisibility(8);
                }
                this.f36914z.getLayoutParams().width = this.f36908B;
                this.f36914z.getLayoutParams().height = (int) (((1.0f * ((float) this.f36908B)) * ((float) linkPresentationModel.getHeight())) / ((float) linkPresentationModel.getWidth()));
                this.f36914z.setVisibility(0);
                text = this.c;
                Intrinsics.m26843a(text, "itemView");
                GlideApp.a(text.getContext()).b(linkPresentationModel.getUrl()).diskCacheStrategy(DiskCacheStrategy.a).transition(DrawableTransitionOptions.b()).placeholder(m37292v()).listener(ImageProgressLoadListener.a(m37292v(), linkPresentationModel.getUrl())).into(this.f36914z).g().f();
                return;
            }
        }
        z = false;
        ViewsKt.m24106b(view, z);
        linkPresentationModel = linkPresentationModel.f33954G;
        if (linkPresentationModel == null) {
        }
        if (linkPresentationModel != null) {
            this.f36914z.getLayoutParams().width = this.f36908B;
            this.f36914z.getLayoutParams().height = (int) (((1.0f * ((float) this.f36908B)) * ((float) linkPresentationModel.getHeight())) / ((float) linkPresentationModel.getWidth()));
            this.f36914z.setVisibility(0);
            text = this.c;
            Intrinsics.m26843a(text, "itemView");
            GlideApp.a(text.getContext()).b(linkPresentationModel.getUrl()).diskCacheStrategy(DiskCacheStrategy.a).transition(DrawableTransitionOptions.b()).placeholder(m37292v()).listener(ImageProgressLoadListener.a(m37292v(), linkPresentationModel.getUrl())).into(this.f36914z).g().f();
            return;
        }
        this.f36914z.setVisibility(8);
    }

    protected final void mo6967b(boolean z) {
        this.f36913y.setShowLinkFlair(z);
    }

    protected final void mo6962a(int i) {
        this.f36912x.setTextColor(this.f36912x.getTextColors().withAlpha(i));
    }
}
