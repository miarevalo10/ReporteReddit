package org.jetbrains.anko;

import android.content.Context;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.functions.Function1;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000ª\u0001\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\bR\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u001d\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\bR\u001d\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00130\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\bR\u001d\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00160\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\bR\u001d\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00190\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\bR\u001d\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001c0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\bR\u001d\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001f0\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\bR\u001d\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\"0\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\bR\u001d\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020%0\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\bR\u001d\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020(0\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\bR\u001d\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020+0\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\bR\u001d\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020.0\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\bR\u001d\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002010\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\bR\u001d\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002040\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\bR\u001d\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002070\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\bR\u001d\u00109\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020:0\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\bR\u001d\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020=0\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\b¨\u0006?"}, d2 = {"org/jetbrains/anko/$$Anko$Factories$Sdk21ViewGroup", "", "()V", "ABSOLUTE_LAYOUT", "Lkotlin/Function1;", "Landroid/content/Context;", "Lorg/jetbrains/anko/_AbsoluteLayout;", "getABSOLUTE_LAYOUT", "()Lkotlin/jvm/functions/Function1;", "ACTION_MENU_VIEW", "Lorg/jetbrains/anko/_ActionMenuView;", "getACTION_MENU_VIEW", "APP_WIDGET_HOST_VIEW", "Lorg/jetbrains/anko/_AppWidgetHostView;", "getAPP_WIDGET_HOST_VIEW", "FRAME_LAYOUT", "Lorg/jetbrains/anko/_FrameLayout;", "getFRAME_LAYOUT", "GALLERY", "Lorg/jetbrains/anko/_Gallery;", "getGALLERY", "GRID_LAYOUT", "Lorg/jetbrains/anko/_GridLayout;", "getGRID_LAYOUT", "GRID_VIEW", "Lorg/jetbrains/anko/_GridView;", "getGRID_VIEW", "HORIZONTAL_SCROLL_VIEW", "Lorg/jetbrains/anko/_HorizontalScrollView;", "getHORIZONTAL_SCROLL_VIEW", "IMAGE_SWITCHER", "Lorg/jetbrains/anko/_ImageSwitcher;", "getIMAGE_SWITCHER", "LINEAR_LAYOUT", "Lorg/jetbrains/anko/_LinearLayout;", "getLINEAR_LAYOUT", "RADIO_GROUP", "Lorg/jetbrains/anko/_RadioGroup;", "getRADIO_GROUP", "RELATIVE_LAYOUT", "Lorg/jetbrains/anko/_RelativeLayout;", "getRELATIVE_LAYOUT", "SCROLL_VIEW", "Lorg/jetbrains/anko/_ScrollView;", "getSCROLL_VIEW", "TABLE_LAYOUT", "Lorg/jetbrains/anko/_TableLayout;", "getTABLE_LAYOUT", "TABLE_ROW", "Lorg/jetbrains/anko/_TableRow;", "getTABLE_ROW", "TEXT_SWITCHER", "Lorg/jetbrains/anko/_TextSwitcher;", "getTEXT_SWITCHER", "TOOLBAR", "Lorg/jetbrains/anko/_Toolbar;", "getTOOLBAR", "VIEW_ANIMATOR", "Lorg/jetbrains/anko/_ViewAnimator;", "getVIEW_ANIMATOR", "VIEW_SWITCHER", "Lorg/jetbrains/anko/_ViewSwitcher;", "getVIEW_SWITCHER", "anko-sdk21_release"}, k = 1, mv = {1, 1, 5})
@PublishedApi
/* compiled from: Views.kt */
public final class C$$Anko$Factories$Sdk21ViewGroup {
    public static final C$$Anko$Factories$Sdk21ViewGroup f26917a = null;
    private static final Function1<Context, _AppWidgetHostView> f26918b = null;
    private static final Function1<Context, _AbsoluteLayout> f26919c = null;
    private static final Function1<Context, _ActionMenuView> f26920d = null;
    private static final Function1<Context, _FrameLayout> f26921e = null;
    private static final Function1<Context, _Gallery> f26922f = null;
    private static final Function1<Context, _GridLayout> f26923g = null;
    private static final Function1<Context, _GridView> f26924h = null;
    private static final Function1<Context, _HorizontalScrollView> f26925i = null;
    private static final Function1<Context, _ImageSwitcher> f26926j = null;
    private static final Function1<Context, _LinearLayout> f26927k = null;
    private static final Function1<Context, _RadioGroup> f26928l = null;
    private static final Function1<Context, _RelativeLayout> f26929m = null;
    private static final Function1<Context, _ScrollView> f26930n = null;
    private static final Function1<Context, _TableLayout> f26931o = null;
    private static final Function1<Context, _TableRow> f26932p = null;
    private static final Function1<Context, _TextSwitcher> f26933q = null;
    private static final Function1<Context, _Toolbar> f26934r = null;
    private static final Function1<Context, _ViewAnimator> f26935s = null;
    private static final Function1<Context, _ViewSwitcher> f26936t = null;

    static {
        C$$Anko$Factories$Sdk21ViewGroup c$$Anko$Factories$Sdk21ViewGroup = new C$$Anko$Factories$Sdk21ViewGroup();
    }

    private C$$Anko$Factories$Sdk21ViewGroup() {
        f26917a = this;
        f26918b = C$$Anko$Factories$Sdk21ViewGroup$APP_WIDGET_HOST_VIEW$1.f39036a;
        f26919c = C$$Anko$Factories$Sdk21ViewGroup$ABSOLUTE_LAYOUT$1.f39034a;
        f26920d = C$$Anko$Factories$Sdk21ViewGroup$ACTION_MENU_VIEW$1.f39035a;
        f26921e = C$$Anko$Factories$Sdk21ViewGroup$FRAME_LAYOUT$1.f39037a;
        f26922f = C$$Anko$Factories$Sdk21ViewGroup$GALLERY$1.f39038a;
        f26923g = C$$Anko$Factories$Sdk21ViewGroup$GRID_LAYOUT$1.f39039a;
        f26924h = C$$Anko$Factories$Sdk21ViewGroup$GRID_VIEW$1.f39040a;
        f26925i = C$$Anko$Factories$Sdk21ViewGroup$HORIZONTAL_SCROLL_VIEW$1.f39041a;
        f26926j = C$$Anko$Factories$Sdk21ViewGroup$IMAGE_SWITCHER$1.f39042a;
        f26927k = C$$Anko$Factories$Sdk21ViewGroup$LINEAR_LAYOUT$1.f39043a;
        f26928l = C$$Anko$Factories$Sdk21ViewGroup$RADIO_GROUP$1.f39044a;
        f26929m = C$$Anko$Factories$Sdk21ViewGroup$RELATIVE_LAYOUT$1.f39045a;
        f26930n = C$$Anko$Factories$Sdk21ViewGroup$SCROLL_VIEW$1.f39046a;
        f26931o = C$$Anko$Factories$Sdk21ViewGroup$TABLE_LAYOUT$1.f39047a;
        f26932p = C$$Anko$Factories$Sdk21ViewGroup$TABLE_ROW$1.f39048a;
        f26933q = C$$Anko$Factories$Sdk21ViewGroup$TEXT_SWITCHER$1.f39049a;
        f26934r = C$$Anko$Factories$Sdk21ViewGroup$TOOLBAR$1.f39050a;
        f26935s = C$$Anko$Factories$Sdk21ViewGroup$VIEW_ANIMATOR$1.f39051a;
        f26936t = C$$Anko$Factories$Sdk21ViewGroup$VIEW_SWITCHER$1.f39052a;
    }

    public static Function1<Context, _LinearLayout> m28394a() {
        return f26927k;
    }

    public static Function1<Context, _RelativeLayout> m28395b() {
        return f26929m;
    }
}
