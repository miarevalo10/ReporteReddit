package com.instabug.bug.screenshot.viewhierarchy;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.instabug.library.C0593R;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import rx.Observable;
import rx.functions.Func0;

/* compiled from: ViewHierarchyInspector */
public class C0484c {

    /* compiled from: ViewHierarchyInspector */
    public enum C0483a {
        STARTED,
        FAILED,
        COMPLETED
    }

    public static Observable<C0482b> m7787a(final C0482b c0482b) {
        return Observable.a(new Func0<Observable<C0482b>>() {
            public final /* synthetic */ Object call() {
                return Observable.b(C0484c.m7791d(c0482b));
            }
        });
    }

    private static java.lang.String m7785a(android.content.Context r1, int r2) throws org.json.JSONException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = -1;
        if (r2 != r0) goto L_0x0008;
    L_0x0003:
        r1 = java.lang.String.valueOf(r2);
        return r1;
    L_0x0008:
        if (r1 == 0) goto L_0x0023;
    L_0x000a:
        r0 = r1.getResources();	 Catch:{ NotFoundException -> 0x0028 }
        if (r0 == 0) goto L_0x0023;	 Catch:{ NotFoundException -> 0x0028 }
    L_0x0010:
        r0 = r1.getResources();	 Catch:{ NotFoundException -> 0x0028 }
        r0 = r0.getResourceEntryName(r2);	 Catch:{ NotFoundException -> 0x0028 }
        if (r0 == 0) goto L_0x0023;	 Catch:{ NotFoundException -> 0x0028 }
    L_0x001a:
        r1 = r1.getResources();	 Catch:{ NotFoundException -> 0x0028 }
        r1 = r1.getResourceEntryName(r2);	 Catch:{ NotFoundException -> 0x0028 }
        return r1;	 Catch:{ NotFoundException -> 0x0028 }
    L_0x0023:
        r1 = java.lang.String.valueOf(r2);	 Catch:{ NotFoundException -> 0x0028 }
        return r1;
    L_0x0028:
        r1 = java.lang.String.valueOf(r2);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.bug.screenshot.viewhierarchy.c.a(android.content.Context, int):java.lang.String");
    }

    private static void m7788a(Context context, LayoutParams layoutParams, JSONObject jSONObject) throws JSONException {
        jSONObject.put("margin_top", layoutParams.topMargin).put("margin_bottom", layoutParams.bottomMargin).put("margin_left", layoutParams.leftMargin).put("margin_right", layoutParams.rightMargin);
        layoutParams = layoutParams.getRules();
        for (int i = 0; i < layoutParams.length; i++) {
            Object a;
            String str;
            if (layoutParams[i] > null) {
                a = C0484c.m7785a(context, layoutParams[i]);
            } else {
                a = String.valueOf(layoutParams[i]);
            }
            switch (i) {
                case 0:
                    str = "leftOf";
                    break;
                case 1:
                    str = "rightOf";
                    break;
                case 2:
                    str = "above";
                    break;
                case 3:
                    str = "below";
                    break;
                case 4:
                    str = "alignBaseline";
                    break;
                case 5:
                    str = "alignLeft";
                    break;
                case 6:
                    str = "alignTop";
                    break;
                case 7:
                    str = "alignRight";
                    break;
                case 8:
                    str = "alignBottom";
                    break;
                case 9:
                    str = "alignParentLeft";
                    break;
                case 10:
                    str = "alignParentTop";
                    break;
                case 11:
                    str = "alignParentRight";
                    break;
                case 12:
                    str = "alignParentBottom";
                    break;
                case 13:
                    str = "centerInParent";
                    break;
                case 14:
                    str = "centerHorizontal";
                    break;
                case 15:
                    str = "centerVertical";
                    break;
                case 16:
                    str = "startOf";
                    break;
                case 18:
                    str = "alignStart";
                    break;
                case 19:
                    str = "alignEnd";
                    break;
                case 20:
                    str = "alignParentStart";
                    break;
                case 21:
                    str = "alignParentEnd";
                    break;
                default:
                    str = "notIdentified";
                    break;
            }
            jSONObject.put(str, a);
        }
    }

    static JSONObject m7786a(Activity activity, int i) throws JSONException {
        return new JSONObject().put("w", activity.getWindow().getDecorView().getWidth() / i).put("h", activity.getWindow().getDecorView().getHeight() / i);
    }

    public static List<C0482b> m7789b(C0482b c0482b) {
        List arrayList = new ArrayList();
        if (c0482b != null) {
            arrayList.add(c0482b);
            if (c0482b.f9125h) {
                c0482b = c0482b.f9124g.iterator();
                while (c0482b.hasNext()) {
                    arrayList.addAll(C0484c.m7789b((C0482b) c0482b.next()));
                }
            }
        }
        return arrayList;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.instabug.bug.screenshot.viewhierarchy.C0482b m7791d(com.instabug.bug.screenshot.viewhierarchy.C0482b r10) {
        /*
        r0 = r10.f9131n;
        r0 = r0.getVisibility();
        if (r0 != 0) goto L_0x03af;
    L_0x0008:
        r0 = r10.f9131n;	 Catch:{ JSONException -> 0x0381 }
        r0 = r0.getClass();	 Catch:{ JSONException -> 0x0381 }
        r0 = r0.getSimpleName();	 Catch:{ JSONException -> 0x0381 }
        r10.f9120c = r0;	 Catch:{ JSONException -> 0x0381 }
        r0 = r10.f9131n;	 Catch:{ JSONException -> 0x0381 }
        r1 = r0.getClass();	 Catch:{ JSONException -> 0x0381 }
        r1 = r1.getSimpleName();	 Catch:{ JSONException -> 0x0381 }
        r2 = -1;
        r3 = r1.hashCode();	 Catch:{ JSONException -> 0x0381 }
        r4 = 11;
        r5 = 17;
        r6 = 2;
        r7 = 1;
        r8 = 0;
        switch(r3) {
            case -1495589242: goto L_0x0118;
            case -1406842887: goto L_0x010d;
            case -1346021293: goto L_0x0103;
            case -1125439882: goto L_0x00f8;
            case -957993568: goto L_0x00ed;
            case -938935918: goto L_0x00e2;
            case -937446323: goto L_0x00d8;
            case -830787764: goto L_0x00ce;
            case -443652810: goto L_0x00c4;
            case 382765867: goto L_0x00b9;
            case 776382189: goto L_0x00ae;
            case 799298502: goto L_0x00a2;
            case 1125864064: goto L_0x0097;
            case 1127291599: goto L_0x008c;
            case 1283054733: goto L_0x0080;
            case 1310765783: goto L_0x0075;
            case 1410352259: goto L_0x0069;
            case 1413872058: goto L_0x005d;
            case 1666676343: goto L_0x0051;
            case 1713715320: goto L_0x0046;
            case 2001146706: goto L_0x003b;
            case 2059813682: goto L_0x002f;
            default: goto L_0x002d;
        };	 Catch:{ JSONException -> 0x0381 }
    L_0x002d:
        goto L_0x0122;
    L_0x002f:
        r3 = "ScrollView";
        r1 = r1.equals(r3);	 Catch:{ JSONException -> 0x0381 }
        if (r1 == 0) goto L_0x0122;
    L_0x0037:
        r2 = 12;
        goto L_0x0122;
    L_0x003b:
        r3 = "Button";
        r1 = r1.equals(r3);	 Catch:{ JSONException -> 0x0381 }
        if (r1 == 0) goto L_0x0122;
    L_0x0043:
        r2 = 5;
        goto L_0x0122;
    L_0x0046:
        r3 = "TableLayout";
        r1 = r1.equals(r3);	 Catch:{ JSONException -> 0x0381 }
        if (r1 == 0) goto L_0x0122;
    L_0x004e:
        r2 = 3;
        goto L_0x0122;
    L_0x0051:
        r3 = "EditText";
        r1 = r1.equals(r3);	 Catch:{ JSONException -> 0x0381 }
        if (r1 == 0) goto L_0x0122;
    L_0x0059:
        r2 = 8;
        goto L_0x0122;
    L_0x005d:
        r3 = "AutoCompleteTextView";
        r1 = r1.equals(r3);	 Catch:{ JSONException -> 0x0381 }
        if (r1 == 0) goto L_0x0122;
    L_0x0065:
        r2 = 10;
        goto L_0x0122;
    L_0x0069:
        r3 = "ListView";
        r1 = r1.equals(r3);	 Catch:{ JSONException -> 0x0381 }
        if (r1 == 0) goto L_0x0122;
    L_0x0071:
        r2 = 15;
        goto L_0x0122;
    L_0x0075:
        r3 = "FrameLayout";
        r1 = r1.equals(r3);	 Catch:{ JSONException -> 0x0381 }
        if (r1 == 0) goto L_0x0122;
    L_0x007d:
        r2 = r6;
        goto L_0x0122;
    L_0x0080:
        r3 = "SearchView";
        r1 = r1.equals(r3);	 Catch:{ JSONException -> 0x0381 }
        if (r1 == 0) goto L_0x0122;
    L_0x0088:
        r2 = 20;
        goto L_0x0122;
    L_0x008c:
        r3 = "LinearLayout";
        r1 = r1.equals(r3);	 Catch:{ JSONException -> 0x0381 }
        if (r1 == 0) goto L_0x0122;
    L_0x0094:
        r2 = r8;
        goto L_0x0122;
    L_0x0097:
        r3 = "ImageView";
        r1 = r1.equals(r3);	 Catch:{ JSONException -> 0x0381 }
        if (r1 == 0) goto L_0x0122;
    L_0x009f:
        r2 = 7;
        goto L_0x0122;
    L_0x00a2:
        r3 = "ToggleButton";
        r1 = r1.equals(r3);	 Catch:{ JSONException -> 0x0381 }
        if (r1 == 0) goto L_0x0122;
    L_0x00aa:
        r2 = 21;
        goto L_0x0122;
    L_0x00ae:
        r3 = "RadioButton";
        r1 = r1.equals(r3);	 Catch:{ JSONException -> 0x0381 }
        if (r1 == 0) goto L_0x0122;
    L_0x00b6:
        r2 = r5;
        goto L_0x0122;
    L_0x00b9:
        r3 = "GridView";
        r1 = r1.equals(r3);	 Catch:{ JSONException -> 0x0381 }
        if (r1 == 0) goto L_0x0122;
    L_0x00c1:
        r2 = 14;
        goto L_0x0122;
    L_0x00c4:
        r3 = "RelativeLayout";
        r1 = r1.equals(r3);	 Catch:{ JSONException -> 0x0381 }
        if (r1 == 0) goto L_0x0122;
    L_0x00cc:
        r2 = r7;
        goto L_0x0122;
    L_0x00ce:
        r3 = "TableRow";
        r1 = r1.equals(r3);	 Catch:{ JSONException -> 0x0381 }
        if (r1 == 0) goto L_0x0122;
    L_0x00d6:
        r2 = 4;
        goto L_0x0122;
    L_0x00d8:
        r3 = "ImageButton";
        r1 = r1.equals(r3);	 Catch:{ JSONException -> 0x0381 }
        if (r1 == 0) goto L_0x0122;
    L_0x00e0:
        r2 = 6;
        goto L_0x0122;
    L_0x00e2:
        r3 = "TextView";
        r1 = r1.equals(r3);	 Catch:{ JSONException -> 0x0381 }
        if (r1 == 0) goto L_0x0122;
    L_0x00ea:
        r2 = 9;
        goto L_0x0122;
    L_0x00ed:
        r3 = "VideoView";
        r1 = r1.equals(r3);	 Catch:{ JSONException -> 0x0381 }
        if (r1 == 0) goto L_0x0122;
    L_0x00f5:
        r2 = 18;
        goto L_0x0122;
    L_0x00f8:
        r3 = "HorizontalScrollView";
        r1 = r1.equals(r3);	 Catch:{ JSONException -> 0x0381 }
        if (r1 == 0) goto L_0x0122;
    L_0x0100:
        r2 = 13;
        goto L_0x0122;
    L_0x0103:
        r3 = "MultiAutoCompleteTextView";
        r1 = r1.equals(r3);	 Catch:{ JSONException -> 0x0381 }
        if (r1 == 0) goto L_0x0122;
    L_0x010b:
        r2 = r4;
        goto L_0x0122;
    L_0x010d:
        r3 = "WebView";
        r1 = r1.equals(r3);	 Catch:{ JSONException -> 0x0381 }
        if (r1 == 0) goto L_0x0122;
    L_0x0115:
        r2 = 19;
        goto L_0x0122;
    L_0x0118:
        r3 = "ProgressBar";
        r1 = r1.equals(r3);	 Catch:{ JSONException -> 0x0381 }
        if (r1 == 0) goto L_0x0122;
    L_0x0120:
        r2 = 16;
    L_0x0122:
        switch(r2) {
            case 0: goto L_0x0167;
            case 1: goto L_0x0164;
            case 2: goto L_0x0161;
            case 3: goto L_0x015e;
            case 4: goto L_0x015b;
            case 5: goto L_0x0158;
            case 6: goto L_0x0155;
            case 7: goto L_0x0152;
            case 8: goto L_0x014f;
            case 9: goto L_0x014c;
            case 10: goto L_0x0149;
            case 11: goto L_0x0146;
            case 12: goto L_0x0143;
            case 13: goto L_0x0140;
            case 14: goto L_0x013d;
            case 15: goto L_0x013a;
            case 16: goto L_0x0137;
            case 17: goto L_0x0134;
            case 18: goto L_0x0131;
            case 19: goto L_0x012e;
            case 20: goto L_0x012b;
            case 21: goto L_0x0128;
            default: goto L_0x0125;
        };	 Catch:{ JSONException -> 0x0381 }
    L_0x0125:
        r0 = "default";
        goto L_0x0174;
    L_0x0128:
        r0 = "ToggleButton";
        goto L_0x0174;
    L_0x012b:
        r0 = "SearchView";
        goto L_0x0174;
    L_0x012e:
        r0 = "WebView";
        goto L_0x0174;
    L_0x0131:
        r0 = "VideoView";
        goto L_0x0174;
    L_0x0134:
        r0 = "RadioButton";
        goto L_0x0174;
    L_0x0137:
        r0 = "ProgressBar";
        goto L_0x0174;
    L_0x013a:
        r0 = "ListView";
        goto L_0x0174;
    L_0x013d:
        r0 = "GridView";
        goto L_0x0174;
    L_0x0140:
        r0 = "HorizontalScrollView";
        goto L_0x0174;
    L_0x0143:
        r0 = "ScrollView";
        goto L_0x0174;
    L_0x0146:
        r0 = "MultiAutoCompleteTextView";
        goto L_0x0174;
    L_0x0149:
        r0 = "AutoCompleteTextView";
        goto L_0x0174;
    L_0x014c:
        r0 = "TextView";
        goto L_0x0174;
    L_0x014f:
        r0 = "EditText";
        goto L_0x0174;
    L_0x0152:
        r0 = "ImageView";
        goto L_0x0174;
    L_0x0155:
        r0 = "ImageButton";
        goto L_0x0174;
    L_0x0158:
        r0 = "Button";
        goto L_0x0174;
    L_0x015b:
        r0 = "TableRow";
        goto L_0x0174;
    L_0x015e:
        r0 = "TableLayout";
        goto L_0x0174;
    L_0x0161:
        r0 = "FrameLayout";
        goto L_0x0174;
    L_0x0164:
        r0 = "RelativeLayout";
        goto L_0x0174;
    L_0x0167:
        r0 = (android.widget.LinearLayout) r0;	 Catch:{ JSONException -> 0x0381 }
        r0 = r0.getOrientation();	 Catch:{ JSONException -> 0x0381 }
        if (r0 != 0) goto L_0x0172;
    L_0x016f:
        r0 = "HorizontalLinearLayout";
        goto L_0x0174;
    L_0x0172:
        r0 = "VerticalLinearLayout";
    L_0x0174:
        r10.f9119b = r0;	 Catch:{ JSONException -> 0x0381 }
        r0 = r10.f9131n;	 Catch:{ JSONException -> 0x0381 }
        r1 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0381 }
        r1.<init>();	 Catch:{ JSONException -> 0x0381 }
        r2 = "resource_id";
        r3 = r0.getContext();	 Catch:{ JSONException -> 0x0381 }
        r9 = r0.getId();	 Catch:{ JSONException -> 0x0381 }
        r3 = com.instabug.bug.screenshot.viewhierarchy.C0484c.m7785a(r3, r9);	 Catch:{ JSONException -> 0x0381 }
        r2 = r1.put(r2, r3);	 Catch:{ JSONException -> 0x0381 }
        r3 = "height";
        r9 = r0.getHeight();	 Catch:{ JSONException -> 0x0381 }
        r2 = r2.put(r3, r9);	 Catch:{ JSONException -> 0x0381 }
        r3 = "width";
        r9 = r0.getWidth();	 Catch:{ JSONException -> 0x0381 }
        r2 = r2.put(r3, r9);	 Catch:{ JSONException -> 0x0381 }
        r3 = "padding_top";
        r9 = r0.getPaddingTop();	 Catch:{ JSONException -> 0x0381 }
        r2 = r2.put(r3, r9);	 Catch:{ JSONException -> 0x0381 }
        r3 = "padding_bottom";
        r9 = r0.getPaddingBottom();	 Catch:{ JSONException -> 0x0381 }
        r2 = r2.put(r3, r9);	 Catch:{ JSONException -> 0x0381 }
        r3 = "padding_right";
        r9 = r0.getPaddingRight();	 Catch:{ JSONException -> 0x0381 }
        r2 = r2.put(r3, r9);	 Catch:{ JSONException -> 0x0381 }
        r3 = "padding_left";
        r9 = r0.getPaddingLeft();	 Catch:{ JSONException -> 0x0381 }
        r2 = r2.put(r3, r9);	 Catch:{ JSONException -> 0x0381 }
        r3 = "visibility";
        r9 = r0.getVisibility();	 Catch:{ JSONException -> 0x0381 }
        r2.put(r3, r9);	 Catch:{ JSONException -> 0x0381 }
        r2 = android.os.Build.VERSION.SDK_INT;	 Catch:{ JSONException -> 0x0381 }
        if (r2 < r5) goto L_0x01eb;
    L_0x01d8:
        r2 = "padding_end";
        r3 = r0.getPaddingEnd();	 Catch:{ JSONException -> 0x0381 }
        r2 = r1.put(r2, r3);	 Catch:{ JSONException -> 0x0381 }
        r3 = "padding_start";
        r5 = r0.getPaddingStart();	 Catch:{ JSONException -> 0x0381 }
        r2.put(r3, r5);	 Catch:{ JSONException -> 0x0381 }
    L_0x01eb:
        r2 = android.os.Build.VERSION.SDK_INT;	 Catch:{ JSONException -> 0x0381 }
        if (r2 < r4) goto L_0x0204;
    L_0x01ef:
        r2 = "x";
        r3 = r0.getX();	 Catch:{ JSONException -> 0x0381 }
        r3 = (double) r3;	 Catch:{ JSONException -> 0x0381 }
        r2 = r1.put(r2, r3);	 Catch:{ JSONException -> 0x0381 }
        r3 = "y";
        r4 = r0.getY();	 Catch:{ JSONException -> 0x0381 }
        r4 = (double) r4;	 Catch:{ JSONException -> 0x0381 }
        r2.put(r3, r4);	 Catch:{ JSONException -> 0x0381 }
    L_0x0204:
        r2 = r0.getLayoutParams();	 Catch:{ JSONException -> 0x0381 }
        r2 = r2 instanceof android.widget.LinearLayout.LayoutParams;	 Catch:{ JSONException -> 0x0381 }
        if (r2 == 0) goto L_0x023a;
    L_0x020c:
        r0 = r0.getLayoutParams();	 Catch:{ JSONException -> 0x0381 }
        r0 = (android.widget.LinearLayout.LayoutParams) r0;	 Catch:{ JSONException -> 0x0381 }
        r2 = "gravity";
        r3 = r0.gravity;	 Catch:{ JSONException -> 0x0381 }
        r2 = r1.put(r2, r3);	 Catch:{ JSONException -> 0x0381 }
        r3 = "margin_top";
        r4 = r0.topMargin;	 Catch:{ JSONException -> 0x0381 }
        r2 = r2.put(r3, r4);	 Catch:{ JSONException -> 0x0381 }
        r3 = "margin_bottom";
        r4 = r0.bottomMargin;	 Catch:{ JSONException -> 0x0381 }
        r2 = r2.put(r3, r4);	 Catch:{ JSONException -> 0x0381 }
        r3 = "margin_left";
        r4 = r0.leftMargin;	 Catch:{ JSONException -> 0x0381 }
        r2 = r2.put(r3, r4);	 Catch:{ JSONException -> 0x0381 }
        r3 = "margin_right";
        r0 = r0.rightMargin;	 Catch:{ JSONException -> 0x0381 }
        r2.put(r3, r0);	 Catch:{ JSONException -> 0x0381 }
        goto L_0x0285;
    L_0x023a:
        r2 = r0.getLayoutParams();	 Catch:{ JSONException -> 0x0381 }
        r2 = r2 instanceof android.widget.FrameLayout.LayoutParams;	 Catch:{ JSONException -> 0x0381 }
        if (r2 == 0) goto L_0x0270;
    L_0x0242:
        r0 = r0.getLayoutParams();	 Catch:{ JSONException -> 0x0381 }
        r0 = (android.widget.FrameLayout.LayoutParams) r0;	 Catch:{ JSONException -> 0x0381 }
        r2 = "gravity";
        r3 = r0.gravity;	 Catch:{ JSONException -> 0x0381 }
        r2 = r1.put(r2, r3);	 Catch:{ JSONException -> 0x0381 }
        r3 = "margin_top";
        r4 = r0.topMargin;	 Catch:{ JSONException -> 0x0381 }
        r2 = r2.put(r3, r4);	 Catch:{ JSONException -> 0x0381 }
        r3 = "margin_bottom";
        r4 = r0.bottomMargin;	 Catch:{ JSONException -> 0x0381 }
        r2 = r2.put(r3, r4);	 Catch:{ JSONException -> 0x0381 }
        r3 = "margin_left";
        r4 = r0.leftMargin;	 Catch:{ JSONException -> 0x0381 }
        r2 = r2.put(r3, r4);	 Catch:{ JSONException -> 0x0381 }
        r3 = "margin_right";
        r0 = r0.rightMargin;	 Catch:{ JSONException -> 0x0381 }
        r2.put(r3, r0);	 Catch:{ JSONException -> 0x0381 }
        goto L_0x0285;
    L_0x0270:
        r2 = r0.getLayoutParams();	 Catch:{ JSONException -> 0x0381 }
        r2 = r2 instanceof android.widget.RelativeLayout.LayoutParams;	 Catch:{ JSONException -> 0x0381 }
        if (r2 == 0) goto L_0x0285;
    L_0x0278:
        r2 = r0.getContext();	 Catch:{ JSONException -> 0x0381 }
        r0 = r0.getLayoutParams();	 Catch:{ JSONException -> 0x0381 }
        r0 = (android.widget.RelativeLayout.LayoutParams) r0;	 Catch:{ JSONException -> 0x0381 }
        com.instabug.bug.screenshot.viewhierarchy.C0484c.m7788a(r2, r0, r1);	 Catch:{ JSONException -> 0x0381 }
    L_0x0285:
        r10.f9121d = r1;	 Catch:{ JSONException -> 0x0381 }
        r0 = r10.f9131n;	 Catch:{ JSONException -> 0x0381 }
        r1 = new int[r6];	 Catch:{ JSONException -> 0x0381 }
        r0.getLocationOnScreen(r1);	 Catch:{ JSONException -> 0x0381 }
        r2 = new android.graphics.Rect;	 Catch:{ JSONException -> 0x0381 }
        r3 = r1[r8];	 Catch:{ JSONException -> 0x0381 }
        r4 = r1[r7];	 Catch:{ JSONException -> 0x0381 }
        r5 = r1[r8];	 Catch:{ JSONException -> 0x0381 }
        r6 = r0.getWidth();	 Catch:{ JSONException -> 0x0381 }
        r5 = r5 + r6;
        r1 = r1[r7];	 Catch:{ JSONException -> 0x0381 }
        r0 = r0.getHeight();	 Catch:{ JSONException -> 0x0381 }
        r1 = r1 + r0;
        r2.<init>(r3, r4, r5, r1);	 Catch:{ JSONException -> 0x0381 }
        r10.f9129l = r2;	 Catch:{ JSONException -> 0x0381 }
        r0 = r10.f9126i;	 Catch:{ JSONException -> 0x0381 }
        if (r0 == 0) goto L_0x02af;
    L_0x02ab:
        r0 = r10.f9129l;	 Catch:{ JSONException -> 0x0381 }
        goto L_0x0331;
    L_0x02af:
        r0 = new android.graphics.Rect;	 Catch:{ JSONException -> 0x0381 }
        r1 = r10.f9129l;	 Catch:{ JSONException -> 0x0381 }
        r1 = r1.left;	 Catch:{ JSONException -> 0x0381 }
        r2 = r10.f9129l;	 Catch:{ JSONException -> 0x0381 }
        r2 = r2.top;	 Catch:{ JSONException -> 0x0381 }
        r3 = r10.f9129l;	 Catch:{ JSONException -> 0x0381 }
        r3 = r3.right;	 Catch:{ JSONException -> 0x0381 }
        r4 = r10.f9129l;	 Catch:{ JSONException -> 0x0381 }
        r4 = r4.bottom;	 Catch:{ JSONException -> 0x0381 }
        r0.<init>(r1, r2, r3, r4);	 Catch:{ JSONException -> 0x0381 }
        r1 = new android.graphics.Rect;	 Catch:{ JSONException -> 0x0381 }
        r2 = r10.f9123f;	 Catch:{ JSONException -> 0x0381 }
        r3 = r2.f9130m;	 Catch:{ JSONException -> 0x0381 }
        r3 = r3.left;	 Catch:{ JSONException -> 0x0381 }
        r4 = r2.f9131n;	 Catch:{ JSONException -> 0x0381 }
        r4 = r4.getPaddingLeft();	 Catch:{ JSONException -> 0x0381 }
        r2 = r2.f9129l;	 Catch:{ JSONException -> 0x0381 }
        r2 = r2.left;	 Catch:{ JSONException -> 0x0381 }
        if (r4 != 0) goto L_0x02d9;
    L_0x02d8:
        goto L_0x02dc;
    L_0x02d9:
        r2 = r2 + r4;
        if (r3 <= r2) goto L_0x02dd;
    L_0x02dc:
        r2 = r3;
    L_0x02dd:
        r3 = r10.f9123f;	 Catch:{ JSONException -> 0x0381 }
        r4 = r3.f9130m;	 Catch:{ JSONException -> 0x0381 }
        r4 = r4.top;	 Catch:{ JSONException -> 0x0381 }
        r5 = r3.f9131n;	 Catch:{ JSONException -> 0x0381 }
        r5 = r5.getPaddingTop();	 Catch:{ JSONException -> 0x0381 }
        r3 = r3.f9129l;	 Catch:{ JSONException -> 0x0381 }
        r3 = r3.top;	 Catch:{ JSONException -> 0x0381 }
        if (r5 != 0) goto L_0x02f0;
    L_0x02ef:
        goto L_0x02f3;
    L_0x02f0:
        r3 = r3 + r5;
        if (r4 <= r3) goto L_0x02f4;
    L_0x02f3:
        r3 = r4;
    L_0x02f4:
        r4 = r10.f9123f;	 Catch:{ JSONException -> 0x0381 }
        r5 = r4.f9130m;	 Catch:{ JSONException -> 0x0381 }
        r5 = r5.right;	 Catch:{ JSONException -> 0x0381 }
        r6 = r4.f9131n;	 Catch:{ JSONException -> 0x0381 }
        r6 = r6.getPaddingRight();	 Catch:{ JSONException -> 0x0381 }
        r4 = r4.f9129l;	 Catch:{ JSONException -> 0x0381 }
        r4 = r4.right;	 Catch:{ JSONException -> 0x0381 }
        if (r6 != 0) goto L_0x0307;
    L_0x0306:
        goto L_0x030a;
    L_0x0307:
        r4 = r4 - r6;
        if (r5 >= r4) goto L_0x030b;
    L_0x030a:
        r4 = r5;
    L_0x030b:
        r5 = r10.f9123f;	 Catch:{ JSONException -> 0x0381 }
        r6 = r5.f9130m;	 Catch:{ JSONException -> 0x0381 }
        r6 = r6.bottom;	 Catch:{ JSONException -> 0x0381 }
        r9 = r5.f9131n;	 Catch:{ JSONException -> 0x0381 }
        r9 = r9.getPaddingBottom();	 Catch:{ JSONException -> 0x0381 }
        r5 = r5.f9129l;	 Catch:{ JSONException -> 0x0381 }
        r5 = r5.bottom;	 Catch:{ JSONException -> 0x0381 }
        if (r9 != 0) goto L_0x031e;
    L_0x031d:
        goto L_0x0321;
    L_0x031e:
        r5 = r5 - r9;
        if (r6 >= r5) goto L_0x0322;
    L_0x0321:
        r5 = r6;
    L_0x0322:
        r1.<init>(r2, r3, r4, r5);	 Catch:{ JSONException -> 0x0381 }
        r1 = r0.intersect(r1);	 Catch:{ JSONException -> 0x0381 }
        if (r1 == 0) goto L_0x032c;
    L_0x032b:
        goto L_0x0331;
    L_0x032c:
        r0 = new android.graphics.Rect;	 Catch:{ JSONException -> 0x0381 }
        r0.<init>(r8, r8, r8, r8);	 Catch:{ JSONException -> 0x0381 }
    L_0x0331:
        r10.f9130m = r0;	 Catch:{ JSONException -> 0x0381 }
        r0 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0381 }
        r0.<init>();	 Catch:{ JSONException -> 0x0381 }
        r1 = "x";
        r2 = r10.f9130m;	 Catch:{ JSONException -> 0x0381 }
        r2 = r2.left;	 Catch:{ JSONException -> 0x0381 }
        r3 = r10.f9132o;	 Catch:{ JSONException -> 0x0381 }
        r2 = r2 / r3;
        r0 = r0.put(r1, r2);	 Catch:{ JSONException -> 0x0381 }
        r1 = "y";
        r2 = r10.f9130m;	 Catch:{ JSONException -> 0x0381 }
        r2 = r2.top;	 Catch:{ JSONException -> 0x0381 }
        r3 = r10.f9132o;	 Catch:{ JSONException -> 0x0381 }
        r2 = r2 / r3;
        r0 = r0.put(r1, r2);	 Catch:{ JSONException -> 0x0381 }
        r1 = "w";
        r2 = r10.f9130m;	 Catch:{ JSONException -> 0x0381 }
        r2 = r2.width();	 Catch:{ JSONException -> 0x0381 }
        r3 = r10.f9132o;	 Catch:{ JSONException -> 0x0381 }
        r2 = r2 / r3;
        r0 = r0.put(r1, r2);	 Catch:{ JSONException -> 0x0381 }
        r1 = "h";
        r2 = r10.f9130m;	 Catch:{ JSONException -> 0x0381 }
        r2 = r2.height();	 Catch:{ JSONException -> 0x0381 }
        r3 = r10.f9132o;	 Catch:{ JSONException -> 0x0381 }
        r2 = r2 / r3;
        r0 = r0.put(r1, r2);	 Catch:{ JSONException -> 0x0381 }
        r10.f9122e = r0;	 Catch:{ JSONException -> 0x0381 }
        r0 = r10.f9131n;	 Catch:{ JSONException -> 0x0381 }
        r0 = r0 instanceof android.view.ViewGroup;	 Catch:{ JSONException -> 0x0381 }
        if (r0 == 0) goto L_0x037e;
    L_0x0378:
        r10.f9125h = r7;	 Catch:{ JSONException -> 0x0381 }
        com.instabug.bug.screenshot.viewhierarchy.C0484c.m7792e(r10);	 Catch:{ JSONException -> 0x0381 }
        goto L_0x03af;
    L_0x037e:
        r10.f9125h = r8;	 Catch:{ JSONException -> 0x0381 }
        goto L_0x03af;
    L_0x0381:
        r0 = move-exception;
        r1 = com.instabug.bug.screenshot.viewhierarchy.C0481a.class;
        r2 = new java.lang.StringBuilder;
        r3 = "inspect view hierarchy got error: ";
        r2.<init>(r3);
        r3 = r0.getMessage();
        r2.append(r3);
        r3 = ",View hierarchy id:";
        r2.append(r3);
        r3 = r10.f9118a;
        r2.append(r3);
        r3 = ", time in MS: ";
        r2.append(r3);
        r3 = java.lang.System.currentTimeMillis();
        r2.append(r3);
        r2 = r2.toString();
        com.instabug.library.util.InstabugSDKLogger.m8358e(r1, r2, r0);
    L_0x03af:
        return r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.bug.screenshot.viewhierarchy.c.d(com.instabug.bug.screenshot.viewhierarchy.b):com.instabug.bug.screenshot.viewhierarchy.b");
    }

    private static void m7792e(C0482b c0482b) throws JSONException {
        if (c0482b.f9131n instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) c0482b.f9131n;
            int i = 0;
            while (i < viewGroup.getChildCount()) {
                if (!(viewGroup.getChildAt(i).getId() == C0593R.id.instabug_extra_screenshot_button || viewGroup.getChildAt(i).getId() == C0593R.id.instabug_floating_button)) {
                    C0482b c0482b2 = new C0482b();
                    c0482b2.f9126i = false;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(c0482b.f9118a);
                    stringBuilder.append(Operation.MINUS);
                    stringBuilder.append(i);
                    c0482b2.f9118a = stringBuilder.toString();
                    c0482b2.f9131n = viewGroup.getChildAt(i);
                    c0482b2.f9123f = c0482b;
                    c0482b2.f9132o = c0482b.f9132o;
                    c0482b.m7784a(C0484c.m7791d(c0482b2));
                }
                i++;
            }
        }
    }
}
