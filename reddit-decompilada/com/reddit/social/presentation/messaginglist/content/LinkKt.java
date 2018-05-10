package com.reddit.social.presentation.messaginglist.content;

import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.target.Target;
import com.reddit.config.GlideApp;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import com.reddit.social.presentation.messaginglist.LinkEmbedsCache;
import com.reddit.social.presentation.messaginglist.MessageContentClickListener;
import com.reddit.social.presentation.messaginglist.MessageContentKt;
import com.reddit.social.presentation.presentationobjects.LinkContentMessageData;
import com.reddit.social.presentation.presentationobjects.LinkEmbedState;
import com.reddit.social.presentation.presentationobjects.LinkEmbedState.Error;
import com.reddit.social.presentation.presentationobjects.LinkEmbedState.Loaded;
import com.reddit.social.presentation.presentationobjects.LinkEmbedState.NotLoaded;
import io.reactivex.subjects.PublishSubject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.CustomLayoutPropertiesKt;
import org.jetbrains.anko.DimensionsKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a&\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002\u001a8\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u001a\u0010\t\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b\u0018\u00010\n\u001a&\u0010\u000e\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002\u001a\u001e\u0010\u000f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002\u001a\n\u0010\u0010\u001a\u00020\u0002*\u00020\u0011¨\u0006\u0012"}, d2 = {"bind", "", "Lcom/reddit/social/presentation/messaginglist/content/LinkContent;", "linkEmbed", "Lcom/reddit/social/presentation/messaginglist/LinkEmbed;", "message", "Lcom/reddit/social/presentation/presentationobjects/LinkContentMessageData;", "listener", "Lcom/reddit/social/presentation/messaginglist/MessageContentClickListener;", "linkEmbedLoaded", "Lio/reactivex/subjects/PublishSubject;", "Lkotlin/Pair;", "", "Lcom/reddit/social/presentation/presentationobjects/LinkEmbedState;", "bindLinkEmbed", "bindRawMessage", "linkContent", "Landroid/view/ViewGroup;", "app_standardRelease"}, k = 2, mv = {1, 1, 9})
/* compiled from: Link.kt */
public final class LinkKt {
    public static final void m24726a(LinkContent linkContent, LinkContentMessageData linkContentMessageData, MessageContentClickListener messageContentClickListener, PublishSubject<Pair<Long, LinkEmbedState>> publishSubject) {
        Intrinsics.m26847b(linkContent, "$receiver");
        Intrinsics.m26847b(linkContentMessageData, "message");
        LinkEmbedState linkEmbedState = (LinkEmbedState) LinkEmbedsCache.INSTANCE.getCACHE_LINK_EMBEDS().get(linkContentMessageData.f29941a.getUrl());
        if (linkEmbedState instanceof Loaded) {
            boolean z;
            View view;
            publishSubject = ((Loaded) linkEmbedState).f29944a;
            boolean z2 = true;
            if (publishSubject.f22379c == null && publishSubject.f22380d == null && publishSubject.f22381e == null) {
                if (publishSubject.f22382f == null) {
                    z = false;
                    if (z) {
                        m24725a(linkContent, linkContentMessageData, messageContentClickListener);
                        return;
                    }
                    ViewsKt.m24109d(linkContent.f29895c);
                    ViewsKt.m24107c(linkContent.f29896d);
                    linkContent.f29896d.setOnClickListener(new LinkKt$inlined$sam$OnClickListener$i$7f478c20(new LinkKt$bindLinkEmbed$1(linkContent, publishSubject)));
                    linkContent.f29896d.setOnLongClickListener((OnLongClickListener) new LinkKt$inlined$sam$OnLongClickListener$i$e2258e04(new LinkKt$bindLinkEmbed$2(messageContentClickListener, linkContentMessageData)));
                    linkContent.f29898f.setText((CharSequence) publishSubject.f22378b);
                    ViewsKt.m24106b((View) linkContent.f29899g, publishSubject.f22379c == null ? 1 : null);
                    linkContent.f29899g.setText((CharSequence) publishSubject.f22379c);
                    view = (View) linkContent.f29900h;
                    if (publishSubject.f22380d != null) {
                        z2 = false;
                    }
                    ViewsKt.m24106b(view, z2);
                    linkContent.f29900h.setText((CharSequence) publishSubject.f22380d);
                    linkContent.f29897e.setImageDrawable(null);
                    if (publishSubject.f22381e == null) {
                        Intrinsics.m26843a(GlideApp.a(linkContent.f29894b.getContext()).h().load(publishSubject.f22381e).transform(new RoundedCorners(DimensionsKt.m28408a(linkContent.f29897e.getContext(), C1761R.dimen.link_embed_favicon_radius))).into(new LinkKt$bindLinkEmbed$3(linkContent)), "GlideApp.with(linkView.c…()\n          }\n        })");
                    } else {
                        GlideApp.a(linkContent.f29894b.getContext()).a(linkContent.f29897e);
                        ViewsKt.m24109d((View) linkContent.f29897e);
                    }
                    linkContent.f29901i.setImageDrawable(null);
                    if (publishSubject.f22382f == null) {
                        Intrinsics.m26843a(GlideApp.a(linkContent.f29894b.getContext()).h().load(publishSubject.f22382f).into((Target) new LinkKt$bindLinkEmbed$4(linkContent)), "GlideApp.with(linkView.c…()\n          }\n        })");
                    }
                    ViewsKt.m24109d((View) linkContent.f29901i);
                    GlideApp.a(linkContent.f29894b.getContext()).a((View) linkContent.f29901i);
                    return;
                }
            }
            z = true;
            if (z) {
                m24725a(linkContent, linkContentMessageData, messageContentClickListener);
                return;
            }
            ViewsKt.m24109d(linkContent.f29895c);
            ViewsKt.m24107c(linkContent.f29896d);
            linkContent.f29896d.setOnClickListener(new LinkKt$inlined$sam$OnClickListener$i$7f478c20(new LinkKt$bindLinkEmbed$1(linkContent, publishSubject)));
            linkContent.f29896d.setOnLongClickListener((OnLongClickListener) new LinkKt$inlined$sam$OnLongClickListener$i$e2258e04(new LinkKt$bindLinkEmbed$2(messageContentClickListener, linkContentMessageData)));
            linkContent.f29898f.setText((CharSequence) publishSubject.f22378b);
            if (publishSubject.f22379c == null) {
            }
            ViewsKt.m24106b((View) linkContent.f29899g, publishSubject.f22379c == null ? 1 : null);
            linkContent.f29899g.setText((CharSequence) publishSubject.f22379c);
            view = (View) linkContent.f29900h;
            if (publishSubject.f22380d != null) {
                z2 = false;
            }
            ViewsKt.m24106b(view, z2);
            linkContent.f29900h.setText((CharSequence) publishSubject.f22380d);
            linkContent.f29897e.setImageDrawable(null);
            if (publishSubject.f22381e == null) {
                GlideApp.a(linkContent.f29894b.getContext()).a(linkContent.f29897e);
                ViewsKt.m24109d((View) linkContent.f29897e);
            } else {
                Intrinsics.m26843a(GlideApp.a(linkContent.f29894b.getContext()).h().load(publishSubject.f22381e).transform(new RoundedCorners(DimensionsKt.m28408a(linkContent.f29897e.getContext(), C1761R.dimen.link_embed_favicon_radius))).into(new LinkKt$bindLinkEmbed$3(linkContent)), "GlideApp.with(linkView.c…()\n          }\n        })");
            }
            linkContent.f29901i.setImageDrawable(null);
            if (publishSubject.f22382f == null) {
                ViewsKt.m24109d((View) linkContent.f29901i);
                GlideApp.a(linkContent.f29894b.getContext()).a((View) linkContent.f29901i);
                return;
            }
            Intrinsics.m26843a(GlideApp.a(linkContent.f29894b.getContext()).h().load(publishSubject.f22382f).into((Target) new LinkKt$bindLinkEmbed$4(linkContent)), "GlideApp.with(linkView.c…()\n          }\n        })");
        } else if (linkEmbedState instanceof Error) {
            m24725a(linkContent, linkContentMessageData, messageContentClickListener);
        } else {
            if ((linkEmbedState instanceof NotLoaded) || linkEmbedState == null) {
                m24725a(linkContent, linkContentMessageData, messageContentClickListener);
                LinkEmbedsCache.INSTANCE.loadLinkEmbed(linkContentMessageData, publishSubject);
            }
        }
    }

    public static final LinkContent m24724a(ViewGroup viewGroup) {
        Intrinsics.m26847b(viewGroup, "$receiver");
        Object context = viewGroup.getContext();
        Intrinsics.m26843a(context, "context");
        LinkContentView linkContentView = new LinkContentView(context);
        linkContentView.setLayoutParams(new LayoutParams(CustomLayoutPropertiesKt.m28400a(), CustomLayoutPropertiesKt.m28401b()));
        return new LinkContent(linkContentView, linkContentView.getRawMessage(), linkContentView.getLinkEmbed(), linkContentView.getFavicon(), linkContentView.getSiteName(), linkContentView.getTitle(), linkContentView.getDescription(), linkContentView.getImage());
    }

    private static final void m24725a(LinkContent linkContent, LinkContentMessageData linkContentMessageData, MessageContentClickListener messageContentClickListener) {
        ViewsKt.m24109d(linkContent.f29896d);
        ViewsKt.m24107c(linkContent.f29895c);
        linkContent.f29895c.setText(linkContentMessageData.f29941a.getUrl());
        MessageContentKt.m24710a((View) linkContent.f29895c, linkContentMessageData.f29942b.f22437j);
        TextKt.m24735a(linkContent.f29895c, new LinkKt$bindRawMessage$1(messageContentClickListener, linkContentMessageData));
    }
}
