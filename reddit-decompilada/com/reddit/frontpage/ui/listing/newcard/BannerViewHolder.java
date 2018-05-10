package com.reddit.frontpage.ui.listing.newcard;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewManager;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.ui.listing.adapter.ListingViewHolder;
import com.reddit.frontpage.util.kotlin.ContextsKt;
import com.reddit.frontpage.util.kotlin.TextViewsKt;
import com.reddit.frontpage.widgets.DrawableTextView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.AnkoContext;
import org.jetbrains.anko.AnkoContextImpl;
import org.jetbrains.anko.C$$Anko$Factories$Sdk21View;
import org.jetbrains.anko.C$$Anko$Factories$Sdk21ViewGroup;
import org.jetbrains.anko.CustomLayoutPropertiesKt;
import org.jetbrains.anko.CustomViewPropertiesKt;
import org.jetbrains.anko.DimensionsKt;
import org.jetbrains.anko.Sdk21PropertiesKt;
import org.jetbrains.anko._RelativeLayout;
import org.jetbrains.anko.internals.AnkoInternals;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B/\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\b\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/reddit/frontpage/ui/listing/newcard/BannerViewHolder;", "Lcom/reddit/frontpage/ui/listing/adapter/ListingViewHolder;", "itemView", "Landroid/view/View;", "votes", "Landroid/widget/TextView;", "title", "tag", "indicator", "(Landroid/view/View;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/view/View;)V", "bind", "", "banner", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Banner;", "getCategory", "", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: BannerViewHolder.kt */
public final class BannerViewHolder extends ListingViewHolder {
    public static final Companion f34369r = new Companion();
    public final TextView f34370a;
    public final TextView f34371b;
    public final TextView f34372p;
    public final View f34373q;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J/\u0010\u000f\u001a\u00020\u0010*\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00042\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\u0002\b\u0016H\u0002J\u0018\u0010\u0017\u001a\u00020\u0004*\u0004\u0018\u00010\u00182\b\b\u0003\u0010\u0019\u001a\u00020\u0004H\u0002R(\u0010\u0005\u001a\u00020\u0004*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00048B@BX\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/reddit/frontpage/ui/listing/newcard/BannerViewHolder$Companion;", "", "()V", "v", "", "textStyle", "Landroid/widget/TextView;", "getTextStyle", "(Landroid/widget/TextView;)I", "setTextStyle", "(Landroid/widget/TextView;I)V", "create", "Lcom/reddit/frontpage/ui/listing/newcard/BannerViewHolder;", "parent", "Landroid/view/ViewGroup;", "drawableTextView", "Lcom/reddit/frontpage/widgets/DrawableTextView;", "Landroid/view/ViewManager;", "theme", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "toColor", "", "defaultResId", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: BannerViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        private static int m23464b(java.lang.String r1) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = 2131099864; // 0x7f0600d8 float:1.7812093E38 double:1.0529032307E-314;
            if (r1 != 0) goto L_0x000a;
        L_0x0005:
            r1 = com.reddit.frontpage.util.Util.m23950a(r0);
            return r1;
        L_0x000a:
            r1 = android.graphics.Color.parseColor(r1);	 Catch:{ Exception -> 0x000f }
            goto L_0x0013;
        L_0x000f:
            r1 = com.reddit.frontpage.util.Util.m23950a(r0);
        L_0x0013:
            return r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.reddit.frontpage.ui.listing.newcard.BannerViewHolder.Companion.b(java.lang.String):int");
        }

        private static void m23465b(TextView textView) {
            textView.setTypeface(textView.getTypeface(), 1);
        }

        public static BannerViewHolder m23461a(ViewGroup viewGroup) {
            Intrinsics.m26847b(viewGroup, "parent");
            Object context = viewGroup.getContext();
            Intrinsics.m26843a(context, "parent.context");
            AnkoInternals ankoInternals = AnkoInternals.f26942a;
            AnkoContext ankoContextImpl = new AnkoContextImpl(context, context);
            ViewManager viewManager = ankoContextImpl;
            C$$Anko$Factories$Sdk21ViewGroup c$$Anko$Factories$Sdk21ViewGroup = C$$Anko$Factories$Sdk21ViewGroup.f26917a;
            Function1 b = C$$Anko$Factories$Sdk21ViewGroup.m28395b();
            AnkoInternals ankoInternals2 = AnkoInternals.f26942a;
            ankoInternals2 = AnkoInternals.f26942a;
            View view = (View) b.mo6492a(AnkoInternals.m28419a(AnkoInternals.m28420a(viewManager)));
            _RelativeLayout org_jetbrains_anko__RelativeLayout = (_RelativeLayout) view;
            View view2 = org_jetbrains_anko__RelativeLayout;
            view2.setLayoutParams(new LayoutParams(CustomLayoutPropertiesKt.m28400a(), CustomLayoutPropertiesKt.m28401b()));
            Object context2 = org_jetbrains_anko__RelativeLayout.getContext();
            Intrinsics.m26843a(context2, "context");
            Sdk21PropertiesKt.m28409a(view2, ContextsKt.m24075a(context2, C1761R.color.rdt_orangered));
            CustomViewPropertiesKt.m28405b(view2, DimensionsKt.m28408a(view2.getContext(), C1761R.dimen.double_pad));
            CustomViewPropertiesKt.m28406c(view2, DimensionsKt.m28408a(view2.getContext(), C1761R.dimen.single_pad));
            Companion companion = BannerViewHolder.f34369r;
            ViewManager viewManager2 = org_jetbrains_anko__RelativeLayout;
            View a = m23462a(viewManager2, BannerViewHolder$Companion$create$view$1$1$1.f37293a);
            LayoutParams layoutParams = new LayoutParams(CustomLayoutPropertiesKt.m28401b(), CustomLayoutPropertiesKt.m28401b());
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            a.setLayoutParams(layoutParams);
            TextView textView = (TextView) a;
            companion = BannerViewHolder.f34369r;
            a = m23462a(viewManager2, BannerViewHolder$Companion$create$view$1$1$3.f37294a);
            LayoutParams layoutParams2 = new LayoutParams(CustomLayoutPropertiesKt.m28401b(), CustomLayoutPropertiesKt.m28401b());
            layoutParams2.addRule(1, C1761R.id.banner_indicator);
            layoutParams2.addRule(4, C1761R.id.banner_indicator);
            layoutParams2.leftMargin = DimensionsKt.m28408a(view2.getContext(), C1761R.dimen.single_pad);
            a.setLayoutParams(layoutParams2);
            TextView textView2 = (TextView) a;
            C$$Anko$Factories$Sdk21View c$$Anko$Factories$Sdk21View = C$$Anko$Factories$Sdk21View.f26891a;
            Function1 b2 = C$$Anko$Factories$Sdk21View.m28393b();
            AnkoInternals ankoInternals3 = AnkoInternals.f26942a;
            ankoInternals3 = AnkoInternals.f26942a;
            a = (View) b2.mo6492a(AnkoInternals.m28419a(AnkoInternals.m28420a(viewManager2)));
            TextView textView3 = (TextView) a;
            TextViewsKt.m24095a(textView3, (int) C1761R.style.TextAppearance.RedditBase.Title);
            Object context3 = textView3.getContext();
            Intrinsics.m26843a(context3, "context");
            Sdk21PropertiesKt.m28412a(textView3, ContextsKt.m24075a(context3, C1761R.color.rdt_white));
            Companion companion2 = BannerViewHolder.f34369r;
            m23465b(textView3);
            textView3.setIncludeFontPadding(false);
            AnkoInternals ankoInternals4 = AnkoInternals.f26942a;
            AnkoInternals.m28424a(viewManager2, a);
            View view3 = textView3;
            LayoutParams layoutParams3 = new LayoutParams(CustomLayoutPropertiesKt.m28401b(), CustomLayoutPropertiesKt.m28401b());
            layoutParams3.addRule(9);
            layoutParams3.addRule(3, C1761R.id.banner_indicator);
            layoutParams3.addRule(0, C1761R.id.indicator);
            view3.setLayoutParams(layoutParams3);
            TextView textView4 = (TextView) view3;
            C$$Anko$Factories$Sdk21View c$$Anko$Factories$Sdk21View2 = C$$Anko$Factories$Sdk21View.f26891a;
            Function1 a2 = C$$Anko$Factories$Sdk21View.m28392a();
            AnkoInternals ankoInternals5 = AnkoInternals.f26942a;
            ankoInternals5 = AnkoInternals.f26942a;
            view3 = (View) a2.mo6492a(AnkoInternals.m28419a(AnkoInternals.m28420a(viewManager2)));
            ImageView imageView = (ImageView) view3;
            imageView.setId(C1761R.id.indicator);
            Sdk21PropertiesKt.m28410a(imageView, (int) C1761R.drawable.nav_arrowforward_white);
            AnkoInternals ankoInternals6 = AnkoInternals.f26942a;
            AnkoInternals.m28424a(viewManager2, view3);
            View view4 = imageView;
            LayoutParams layoutParams4 = new LayoutParams(CustomLayoutPropertiesKt.m28401b(), CustomLayoutPropertiesKt.m28401b());
            layoutParams4.addRule(11);
            layoutParams4.addRule(15);
            layoutParams4.leftMargin = DimensionsKt.m28408a(view2.getContext(), C1761R.dimen.double_pad);
            view4.setLayoutParams(layoutParams4);
            AnkoInternals ankoInternals7 = AnkoInternals.f26942a;
            AnkoInternals.m28424a(viewManager, view);
            View b3 = ankoContextImpl.mo6315b();
            if (textView4 == null) {
                Intrinsics.m26842a();
            }
            if (view4 == null) {
                Intrinsics.m26842a();
            }
            return new BannerViewHolder(b3, textView2, textView4, textView, view4);
        }

        private static /* synthetic */ DrawableTextView m23462a(ViewManager viewManager, Function1 function1) {
            AnkoInternals ankoInternals = AnkoInternals.f26942a;
            ankoInternals = AnkoInternals.f26942a;
            View drawableTextView = new DrawableTextView(AnkoInternals.m28419a(AnkoInternals.m28420a(viewManager)));
            function1.mo6492a(drawableTextView);
            function1 = AnkoInternals.f26942a;
            AnkoInternals.m28424a(viewManager, drawableTextView);
            return (DrawableTextView) drawableTextView;
        }
    }

    public static final BannerViewHolder m35106a(ViewGroup viewGroup) {
        return Companion.m23461a(viewGroup);
    }

    public final int mo6480Q() {
        return 3;
    }

    private BannerViewHolder(View view, TextView textView, TextView textView2, TextView textView3, View view2) {
        super(view);
        this.f34370a = textView;
        this.f34371b = textView2;
        this.f34372p = textView3;
        this.f34373q = view2;
    }
}
