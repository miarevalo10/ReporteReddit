package com.reddit.frontpage.util;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.v4.content.res.ResourcesCompat;
import android.widget.TextView;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J+\u0010\u000e\u001a\u00020\u000f2\b\b\u0001\u0010\u0010\u001a\u00020\u00042\u0012\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u0012\"\u00020\u0013H\u0007¢\u0006\u0002\u0010\u0014J\u0012\u0010\u0015\u001a\u00020\u000f2\b\b\u0001\u0010\u0010\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R*\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f0\u000bj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f`\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/reddit/frontpage/util/FontUtil;", "", "()V", "BENTON_SANS_MEDIUM", "", "BOLD", "DEFAULT", "MEDIUM", "REGULAR", "ROBOTO_MEDIUM", "fonts", "Ljava/util/HashMap;", "Landroid/graphics/Typeface;", "Lkotlin/collections/HashMap;", "applyFont", "", "fontName", "textViews", "", "Landroid/widget/TextView;", "(Ljava/lang/String;[Landroid/widget/TextView;)V", "loadFont", "FontName", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: FontUtil.kt */
public final class FontUtil {
    public static final FontUtil f21716a = new FontUtil();
    private static final HashMap<String, Typeface> f21717b = new HashMap();

    private FontUtil() {
    }

    public static final void m23704a(String str, TextView... textViewArr) {
        Intrinsics.m26847b(str, "fontName");
        Intrinsics.m26847b(textViewArr, "textViews");
        if (!f21717b.containsKey(str)) {
            Object obj = FrontpageApplication.f27402a;
            Intrinsics.m26843a(obj, "FrontpageApplication.instance");
            AssetManager assets = obj.getAssets();
            FrontpageApplication frontpageApplication = FrontpageApplication.f27402a;
            Typeface a;
            if (Intrinsics.m26845a((Object) str, (Object) "regular")) {
                a = ResourcesCompat.a(frontpageApplication, C1761R.font.rdt_regular);
                if (a != null) {
                    f21717b.put(str, a);
                }
            } else if (Intrinsics.m26845a((Object) str, (Object) "medium")) {
                a = ResourcesCompat.a(frontpageApplication, C1761R.font.rdt_medium);
                if (a != null) {
                    f21717b.put(str, a);
                }
            } else if (Intrinsics.m26845a((Object) str, (Object) "bold")) {
                a = ResourcesCompat.a(frontpageApplication, C1761R.font.rdt_bold);
                if (a != null) {
                    f21717b.put(str, a);
                }
            } else if (Intrinsics.m26845a((Object) str, (Object) "roboto-medium")) {
                f21717b.put(str, Typeface.createFromAsset(assets, "fonts/Roboto-Medium.ttf"));
            } else if (Intrinsics.m26845a((Object) str, (Object) "benton-sans-medium")) {
                f21717b.put(str, Typeface.createFromAsset(assets, "fonts/BentonSans-Medium.otf"));
            } else if (Intrinsics.m26845a((Object) str, (Object) "default")) {
                f21717b.put(str, Typeface.DEFAULT);
            }
        }
        Typeface typeface = (Typeface) f21717b.get(str);
        for (Object obj2 : (Object[]) textViewArr) {
            ((TextView) obj2).setTypeface(typeface);
        }
    }
}
