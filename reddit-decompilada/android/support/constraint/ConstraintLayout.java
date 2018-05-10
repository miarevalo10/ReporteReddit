package android.support.constraint;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build.VERSION;
import android.support.constraint.solver.widgets.ConstraintWidget;
import android.support.constraint.solver.widgets.ConstraintWidgetContainer;
import android.support.constraint.solver.widgets.Guideline;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import java.util.ArrayList;
import java.util.HashMap;

public class ConstraintLayout extends ViewGroup {
    SparseArray<View> f107a = new SparseArray();
    ConstraintWidgetContainer f108b = new ConstraintWidgetContainer();
    HashMap<String, Integer> f109c = new HashMap();
    int f110d = -1;
    int f111e = -1;
    int f112f = 0;
    int f113g = 0;
    private ArrayList<ConstraintHelper> f114h = new ArrayList(4);
    private final ArrayList<ConstraintWidget> f115i = new ArrayList(100);
    private int f116j = 0;
    private int f117k = 0;
    private int f118l = RedditJobManager.f10810d;
    private int f119m = RedditJobManager.f10810d;
    private boolean f120n = true;
    private int f121o = 3;
    private ConstraintSet f122p = null;
    private String f123q;
    private int f124r = -1;
    private int f125s = -1;
    private int f126t = -1;

    public static class LayoutParams extends MarginLayoutParams {
        public float f55A = 0.5f;
        public String f56B = null;
        float f57C = 0.0f;
        int f58D = 1;
        public float f59E = 0.0f;
        public float f60F = 0.0f;
        public int f61G = 0;
        public int f62H = 0;
        public int f63I = 0;
        public int f64J = 0;
        public int f65K = 0;
        public int f66L = 0;
        public int f67M = 0;
        public int f68N = 0;
        public float f69O = 1.0f;
        public float f70P = 1.0f;
        public int f71Q = -1;
        public int f72R = -1;
        public int f73S = -1;
        public boolean f74T = false;
        public boolean f75U = false;
        boolean f76V = true;
        boolean f77W = true;
        boolean f78X = false;
        boolean f79Y = false;
        boolean f80Z = false;
        public int f81a = -1;
        boolean aa = false;
        int ab = -1;
        int ac = -1;
        int ad = -1;
        int ae = -1;
        int af = -1;
        int ag = -1;
        float ah = 0.5f;
        int ai;
        int aj;
        float ak;
        ConstraintWidget al = new ConstraintWidget();
        public boolean am = false;
        public int f82b = -1;
        public float f83c = -1.0f;
        public int f84d = -1;
        public int f85e = -1;
        public int f86f = -1;
        public int f87g = -1;
        public int f88h = -1;
        public int f89i = -1;
        public int f90j = -1;
        public int f91k = -1;
        public int f92l = -1;
        public int f93m = -1;
        public int f94n = 0;
        public float f95o = 0.0f;
        public int f96p = -1;
        public int f97q = -1;
        public int f98r = -1;
        public int f99s = -1;
        public int f100t = -1;
        public int f101u = -1;
        public int f102v = -1;
        public int f103w = -1;
        public int f104x = -1;
        public int f105y = -1;
        public float f106z = 0.5f;

        private static class Table {
            public static final SparseIntArray f54a;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                f54a = sparseIntArray;
                sparseIntArray.append(C0004R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
                f54a.append(C0004R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
                f54a.append(C0004R.styleable.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
                f54a.append(C0004R.styleable.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
                f54a.append(C0004R.styleable.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
                f54a.append(C0004R.styleable.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
                f54a.append(C0004R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
                f54a.append(C0004R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
                f54a.append(C0004R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
                f54a.append(C0004R.styleable.ConstraintLayout_Layout_layout_constraintCircle, 2);
                f54a.append(C0004R.styleable.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
                f54a.append(C0004R.styleable.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
                f54a.append(C0004R.styleable.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
                f54a.append(C0004R.styleable.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
                f54a.append(C0004R.styleable.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
                f54a.append(C0004R.styleable.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
                f54a.append(C0004R.styleable.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
                f54a.append(C0004R.styleable.ConstraintLayout_Layout_android_orientation, 1);
                f54a.append(C0004R.styleable.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
                f54a.append(C0004R.styleable.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
                f54a.append(C0004R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
                f54a.append(C0004R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
                f54a.append(C0004R.styleable.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
                f54a.append(C0004R.styleable.ConstraintLayout_Layout_layout_goneMarginTop, 22);
                f54a.append(C0004R.styleable.ConstraintLayout_Layout_layout_goneMarginRight, 23);
                f54a.append(C0004R.styleable.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
                f54a.append(C0004R.styleable.ConstraintLayout_Layout_layout_goneMarginStart, 25);
                f54a.append(C0004R.styleable.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
                f54a.append(C0004R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
                f54a.append(C0004R.styleable.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
                f54a.append(C0004R.styleable.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
                f54a.append(C0004R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
                f54a.append(C0004R.styleable.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
                f54a.append(C0004R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
                f54a.append(C0004R.styleable.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
                f54a.append(C0004R.styleable.ConstraintLayout_Layout_layout_constrainedWidth, 27);
                f54a.append(C0004R.styleable.ConstraintLayout_Layout_layout_constrainedHeight, 28);
                f54a.append(C0004R.styleable.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
                f54a.append(C0004R.styleable.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
                f54a.append(C0004R.styleable.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
                f54a.append(C0004R.styleable.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
                f54a.append(C0004R.styleable.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
                f54a.append(C0004R.styleable.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
                f54a.append(C0004R.styleable.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
                f54a.append(C0004R.styleable.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
                f54a.append(C0004R.styleable.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
                f54a.append(C0004R.styleable.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
                f54a.append(C0004R.styleable.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
                f54a.append(C0004R.styleable.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
                f54a.append(C0004R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
            }
        }

        public LayoutParams(android.content.Context r10, android.util.AttributeSet r11) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r9 = this;
            r9.<init>(r10, r11);
            r0 = -1;
            r9.f81a = r0;
            r9.f82b = r0;
            r1 = -1082130432; // 0xffffffffbf800000 float:-1.0 double:NaN;
            r9.f83c = r1;
            r9.f84d = r0;
            r9.f85e = r0;
            r9.f86f = r0;
            r9.f87g = r0;
            r9.f88h = r0;
            r9.f89i = r0;
            r9.f90j = r0;
            r9.f91k = r0;
            r9.f92l = r0;
            r9.f93m = r0;
            r1 = 0;
            r9.f94n = r1;
            r2 = 0;
            r9.f95o = r2;
            r9.f96p = r0;
            r9.f97q = r0;
            r9.f98r = r0;
            r9.f99s = r0;
            r9.f100t = r0;
            r9.f101u = r0;
            r9.f102v = r0;
            r9.f103w = r0;
            r9.f104x = r0;
            r9.f105y = r0;
            r3 = 1056964608; // 0x3f000000 float:0.5 double:5.222099017E-315;
            r9.f106z = r3;
            r9.f55A = r3;
            r4 = 0;
            r9.f56B = r4;
            r9.f57C = r2;
            r4 = 1;
            r9.f58D = r4;
            r9.f59E = r2;
            r9.f60F = r2;
            r9.f61G = r1;
            r9.f62H = r1;
            r9.f63I = r1;
            r9.f64J = r1;
            r9.f65K = r1;
            r9.f66L = r1;
            r9.f67M = r1;
            r9.f68N = r1;
            r5 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
            r9.f69O = r5;
            r9.f70P = r5;
            r9.f71Q = r0;
            r9.f72R = r0;
            r9.f73S = r0;
            r9.f74T = r1;
            r9.f75U = r1;
            r9.f76V = r4;
            r9.f77W = r4;
            r9.f78X = r1;
            r9.f79Y = r1;
            r9.f80Z = r1;
            r9.aa = r1;
            r9.ab = r0;
            r9.ac = r0;
            r9.ad = r0;
            r9.ae = r0;
            r9.af = r0;
            r9.ag = r0;
            r9.ah = r3;
            r3 = new android.support.constraint.solver.widgets.ConstraintWidget;
            r3.<init>();
            r9.al = r3;
            r9.am = r1;
            r3 = android.support.constraint.C0004R.styleable.ConstraintLayout_Layout;
            r10 = r10.obtainStyledAttributes(r11, r3);
            r11 = r10.getIndexCount();
            r3 = r1;
        L_0x009a:
            if (r3 >= r11) goto L_0x03e4;
        L_0x009c:
            r5 = r10.getIndex(r3);
            r6 = android.support.constraint.ConstraintLayout.LayoutParams.Table.f54a;
            r6 = r6.get(r5);
            r7 = -2;
            switch(r6) {
                case 0: goto L_0x03e0;
                case 1: goto L_0x03d8;
                case 2: goto L_0x03c5;
                case 3: goto L_0x03bc;
                case 4: goto L_0x03a3;
                case 5: goto L_0x039a;
                case 6: goto L_0x0391;
                case 7: goto L_0x0388;
                case 8: goto L_0x0375;
                case 9: goto L_0x0362;
                case 10: goto L_0x034e;
                case 11: goto L_0x033a;
                case 12: goto L_0x0326;
                case 13: goto L_0x0312;
                case 14: goto L_0x02fe;
                case 15: goto L_0x02ea;
                case 16: goto L_0x02d6;
                case 17: goto L_0x02c2;
                case 18: goto L_0x02ae;
                case 19: goto L_0x029a;
                case 20: goto L_0x0286;
                case 21: goto L_0x027c;
                case 22: goto L_0x0272;
                case 23: goto L_0x0268;
                case 24: goto L_0x025e;
                case 25: goto L_0x0254;
                case 26: goto L_0x024a;
                case 27: goto L_0x0240;
                case 28: goto L_0x0236;
                case 29: goto L_0x022c;
                case 30: goto L_0x0222;
                case 31: goto L_0x020f;
                case 32: goto L_0x01fc;
                case 33: goto L_0x01e6;
                case 34: goto L_0x01d0;
                case 35: goto L_0x01c2;
                case 36: goto L_0x01ac;
                case 37: goto L_0x0196;
                case 38: goto L_0x0188;
                default: goto L_0x00aa;
            };
        L_0x00aa:
            switch(r6) {
                case 44: goto L_0x00e3;
                case 45: goto L_0x00db;
                case 46: goto L_0x00d3;
                case 47: goto L_0x00cb;
                case 48: goto L_0x00c3;
                case 49: goto L_0x00b9;
                case 50: goto L_0x00af;
                default: goto L_0x00ad;
            };
        L_0x00ad:
            goto L_0x03e0;
        L_0x00af:
            r6 = r9.f72R;
            r5 = r10.getDimensionPixelOffset(r5, r6);
            r9.f72R = r5;
            goto L_0x03e0;
        L_0x00b9:
            r6 = r9.f71Q;
            r5 = r10.getDimensionPixelOffset(r5, r6);
            r9.f71Q = r5;
            goto L_0x03e0;
        L_0x00c3:
            r5 = r10.getInt(r5, r1);
            r9.f62H = r5;
            goto L_0x03e0;
        L_0x00cb:
            r5 = r10.getInt(r5, r1);
            r9.f61G = r5;
            goto L_0x03e0;
        L_0x00d3:
            r5 = r10.getFloat(r5, r2);
            r9.f60F = r5;
            goto L_0x03e0;
        L_0x00db:
            r5 = r10.getFloat(r5, r2);
            r9.f59E = r5;
            goto L_0x03e0;
        L_0x00e3:
            r5 = r10.getString(r5);
            r9.f56B = r5;
            r5 = 2143289344; // 0x7fc00000 float:NaN double:1.058925634E-314;
            r9.f57C = r5;
            r9.f58D = r0;
            r5 = r9.f56B;
            if (r5 == 0) goto L_0x03e0;
        L_0x00f3:
            r5 = r9.f56B;
            r5 = r5.length();
            r6 = r9.f56B;
            r7 = 44;
            r6 = r6.indexOf(r7);
            if (r6 <= 0) goto L_0x0125;
        L_0x0103:
            r7 = r5 + -1;
            if (r6 >= r7) goto L_0x0125;
        L_0x0107:
            r7 = r9.f56B;
            r7 = r7.substring(r1, r6);
            r8 = "W";
            r8 = r7.equalsIgnoreCase(r8);
            if (r8 == 0) goto L_0x0118;
        L_0x0115:
            r9.f58D = r1;
            goto L_0x0122;
        L_0x0118:
            r8 = "H";
            r7 = r7.equalsIgnoreCase(r8);
            if (r7 == 0) goto L_0x0122;
        L_0x0120:
            r9.f58D = r4;
        L_0x0122:
            r6 = r6 + 1;
            goto L_0x0126;
        L_0x0125:
            r6 = r1;
        L_0x0126:
            r7 = r9.f56B;
            r8 = 58;
            r7 = r7.indexOf(r8);
            if (r7 < 0) goto L_0x0174;
        L_0x0130:
            r5 = r5 + -1;
            if (r7 >= r5) goto L_0x0174;
        L_0x0134:
            r5 = r9.f56B;
            r5 = r5.substring(r6, r7);
            r6 = r9.f56B;
            r7 = r7 + 1;
            r6 = r6.substring(r7);
            r7 = r5.length();
            if (r7 <= 0) goto L_0x03e0;
        L_0x0148:
            r7 = r6.length();
            if (r7 <= 0) goto L_0x03e0;
        L_0x014e:
            r5 = java.lang.Float.parseFloat(r5);	 Catch:{ NumberFormatException -> 0x03e0 }
            r6 = java.lang.Float.parseFloat(r6);	 Catch:{ NumberFormatException -> 0x03e0 }
            r7 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1));	 Catch:{ NumberFormatException -> 0x03e0 }
            if (r7 <= 0) goto L_0x03e0;	 Catch:{ NumberFormatException -> 0x03e0 }
        L_0x015a:
            r7 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1));	 Catch:{ NumberFormatException -> 0x03e0 }
            if (r7 <= 0) goto L_0x03e0;	 Catch:{ NumberFormatException -> 0x03e0 }
        L_0x015e:
            r7 = r9.f58D;	 Catch:{ NumberFormatException -> 0x03e0 }
            if (r7 != r4) goto L_0x016b;	 Catch:{ NumberFormatException -> 0x03e0 }
        L_0x0162:
            r6 = r6 / r5;	 Catch:{ NumberFormatException -> 0x03e0 }
            r5 = java.lang.Math.abs(r6);	 Catch:{ NumberFormatException -> 0x03e0 }
            r9.f57C = r5;	 Catch:{ NumberFormatException -> 0x03e0 }
            goto L_0x03e0;	 Catch:{ NumberFormatException -> 0x03e0 }
        L_0x016b:
            r5 = r5 / r6;	 Catch:{ NumberFormatException -> 0x03e0 }
            r5 = java.lang.Math.abs(r5);	 Catch:{ NumberFormatException -> 0x03e0 }
            r9.f57C = r5;	 Catch:{ NumberFormatException -> 0x03e0 }
            goto L_0x03e0;
        L_0x0174:
            r5 = r9.f56B;
            r5 = r5.substring(r6);
            r6 = r5.length();
            if (r6 <= 0) goto L_0x03e0;
        L_0x0180:
            r5 = java.lang.Float.parseFloat(r5);	 Catch:{ NumberFormatException -> 0x03e0 }
            r9.f57C = r5;	 Catch:{ NumberFormatException -> 0x03e0 }
            goto L_0x03e0;
        L_0x0188:
            r6 = r9.f70P;
            r5 = r10.getFloat(r5, r6);
            r5 = java.lang.Math.max(r2, r5);
            r9.f70P = r5;
            goto L_0x03e0;
        L_0x0196:
            r6 = r9.f68N;	 Catch:{ Exception -> 0x01a0 }
            r6 = r10.getDimensionPixelSize(r5, r6);	 Catch:{ Exception -> 0x01a0 }
            r9.f68N = r6;	 Catch:{ Exception -> 0x01a0 }
            goto L_0x03e0;
        L_0x01a0:
            r6 = r9.f68N;
            r5 = r10.getInt(r5, r6);
            if (r5 != r7) goto L_0x03e0;
        L_0x01a8:
            r9.f68N = r7;
            goto L_0x03e0;
        L_0x01ac:
            r6 = r9.f66L;	 Catch:{ Exception -> 0x01b6 }
            r6 = r10.getDimensionPixelSize(r5, r6);	 Catch:{ Exception -> 0x01b6 }
            r9.f66L = r6;	 Catch:{ Exception -> 0x01b6 }
            goto L_0x03e0;
        L_0x01b6:
            r6 = r9.f66L;
            r5 = r10.getInt(r5, r6);
            if (r5 != r7) goto L_0x03e0;
        L_0x01be:
            r9.f66L = r7;
            goto L_0x03e0;
        L_0x01c2:
            r6 = r9.f69O;
            r5 = r10.getFloat(r5, r6);
            r5 = java.lang.Math.max(r2, r5);
            r9.f69O = r5;
            goto L_0x03e0;
        L_0x01d0:
            r6 = r9.f67M;	 Catch:{ Exception -> 0x01da }
            r6 = r10.getDimensionPixelSize(r5, r6);	 Catch:{ Exception -> 0x01da }
            r9.f67M = r6;	 Catch:{ Exception -> 0x01da }
            goto L_0x03e0;
        L_0x01da:
            r6 = r9.f67M;
            r5 = r10.getInt(r5, r6);
            if (r5 != r7) goto L_0x03e0;
        L_0x01e2:
            r9.f67M = r7;
            goto L_0x03e0;
        L_0x01e6:
            r6 = r9.f65K;	 Catch:{ Exception -> 0x01f0 }
            r6 = r10.getDimensionPixelSize(r5, r6);	 Catch:{ Exception -> 0x01f0 }
            r9.f65K = r6;	 Catch:{ Exception -> 0x01f0 }
            goto L_0x03e0;
        L_0x01f0:
            r6 = r9.f65K;
            r5 = r10.getInt(r5, r6);
            if (r5 != r7) goto L_0x03e0;
        L_0x01f8:
            r9.f65K = r7;
            goto L_0x03e0;
        L_0x01fc:
            r5 = r10.getInt(r5, r1);
            r9.f64J = r5;
            r5 = r9.f64J;
            if (r5 != r4) goto L_0x03e0;
        L_0x0206:
            r5 = "ConstraintLayout";
            r6 = "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.";
            android.util.Log.e(r5, r6);
            goto L_0x03e0;
        L_0x020f:
            r5 = r10.getInt(r5, r1);
            r9.f63I = r5;
            r5 = r9.f63I;
            if (r5 != r4) goto L_0x03e0;
        L_0x0219:
            r5 = "ConstraintLayout";
            r6 = "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.";
            android.util.Log.e(r5, r6);
            goto L_0x03e0;
        L_0x0222:
            r6 = r9.f55A;
            r5 = r10.getFloat(r5, r6);
            r9.f55A = r5;
            goto L_0x03e0;
        L_0x022c:
            r6 = r9.f106z;
            r5 = r10.getFloat(r5, r6);
            r9.f106z = r5;
            goto L_0x03e0;
        L_0x0236:
            r6 = r9.f75U;
            r5 = r10.getBoolean(r5, r6);
            r9.f75U = r5;
            goto L_0x03e0;
        L_0x0240:
            r6 = r9.f74T;
            r5 = r10.getBoolean(r5, r6);
            r9.f74T = r5;
            goto L_0x03e0;
        L_0x024a:
            r6 = r9.f105y;
            r5 = r10.getDimensionPixelSize(r5, r6);
            r9.f105y = r5;
            goto L_0x03e0;
        L_0x0254:
            r6 = r9.f104x;
            r5 = r10.getDimensionPixelSize(r5, r6);
            r9.f104x = r5;
            goto L_0x03e0;
        L_0x025e:
            r6 = r9.f103w;
            r5 = r10.getDimensionPixelSize(r5, r6);
            r9.f103w = r5;
            goto L_0x03e0;
        L_0x0268:
            r6 = r9.f102v;
            r5 = r10.getDimensionPixelSize(r5, r6);
            r9.f102v = r5;
            goto L_0x03e0;
        L_0x0272:
            r6 = r9.f101u;
            r5 = r10.getDimensionPixelSize(r5, r6);
            r9.f101u = r5;
            goto L_0x03e0;
        L_0x027c:
            r6 = r9.f100t;
            r5 = r10.getDimensionPixelSize(r5, r6);
            r9.f100t = r5;
            goto L_0x03e0;
        L_0x0286:
            r6 = r9.f99s;
            r6 = r10.getResourceId(r5, r6);
            r9.f99s = r6;
            r6 = r9.f99s;
            if (r6 != r0) goto L_0x03e0;
        L_0x0292:
            r5 = r10.getInt(r5, r0);
            r9.f99s = r5;
            goto L_0x03e0;
        L_0x029a:
            r6 = r9.f98r;
            r6 = r10.getResourceId(r5, r6);
            r9.f98r = r6;
            r6 = r9.f98r;
            if (r6 != r0) goto L_0x03e0;
        L_0x02a6:
            r5 = r10.getInt(r5, r0);
            r9.f98r = r5;
            goto L_0x03e0;
        L_0x02ae:
            r6 = r9.f97q;
            r6 = r10.getResourceId(r5, r6);
            r9.f97q = r6;
            r6 = r9.f97q;
            if (r6 != r0) goto L_0x03e0;
        L_0x02ba:
            r5 = r10.getInt(r5, r0);
            r9.f97q = r5;
            goto L_0x03e0;
        L_0x02c2:
            r6 = r9.f96p;
            r6 = r10.getResourceId(r5, r6);
            r9.f96p = r6;
            r6 = r9.f96p;
            if (r6 != r0) goto L_0x03e0;
        L_0x02ce:
            r5 = r10.getInt(r5, r0);
            r9.f96p = r5;
            goto L_0x03e0;
        L_0x02d6:
            r6 = r9.f92l;
            r6 = r10.getResourceId(r5, r6);
            r9.f92l = r6;
            r6 = r9.f92l;
            if (r6 != r0) goto L_0x03e0;
        L_0x02e2:
            r5 = r10.getInt(r5, r0);
            r9.f92l = r5;
            goto L_0x03e0;
        L_0x02ea:
            r6 = r9.f91k;
            r6 = r10.getResourceId(r5, r6);
            r9.f91k = r6;
            r6 = r9.f91k;
            if (r6 != r0) goto L_0x03e0;
        L_0x02f6:
            r5 = r10.getInt(r5, r0);
            r9.f91k = r5;
            goto L_0x03e0;
        L_0x02fe:
            r6 = r9.f90j;
            r6 = r10.getResourceId(r5, r6);
            r9.f90j = r6;
            r6 = r9.f90j;
            if (r6 != r0) goto L_0x03e0;
        L_0x030a:
            r5 = r10.getInt(r5, r0);
            r9.f90j = r5;
            goto L_0x03e0;
        L_0x0312:
            r6 = r9.f89i;
            r6 = r10.getResourceId(r5, r6);
            r9.f89i = r6;
            r6 = r9.f89i;
            if (r6 != r0) goto L_0x03e0;
        L_0x031e:
            r5 = r10.getInt(r5, r0);
            r9.f89i = r5;
            goto L_0x03e0;
        L_0x0326:
            r6 = r9.f88h;
            r6 = r10.getResourceId(r5, r6);
            r9.f88h = r6;
            r6 = r9.f88h;
            if (r6 != r0) goto L_0x03e0;
        L_0x0332:
            r5 = r10.getInt(r5, r0);
            r9.f88h = r5;
            goto L_0x03e0;
        L_0x033a:
            r6 = r9.f87g;
            r6 = r10.getResourceId(r5, r6);
            r9.f87g = r6;
            r6 = r9.f87g;
            if (r6 != r0) goto L_0x03e0;
        L_0x0346:
            r5 = r10.getInt(r5, r0);
            r9.f87g = r5;
            goto L_0x03e0;
        L_0x034e:
            r6 = r9.f86f;
            r6 = r10.getResourceId(r5, r6);
            r9.f86f = r6;
            r6 = r9.f86f;
            if (r6 != r0) goto L_0x03e0;
        L_0x035a:
            r5 = r10.getInt(r5, r0);
            r9.f86f = r5;
            goto L_0x03e0;
        L_0x0362:
            r6 = r9.f85e;
            r6 = r10.getResourceId(r5, r6);
            r9.f85e = r6;
            r6 = r9.f85e;
            if (r6 != r0) goto L_0x03e0;
        L_0x036e:
            r5 = r10.getInt(r5, r0);
            r9.f85e = r5;
            goto L_0x03e0;
        L_0x0375:
            r6 = r9.f84d;
            r6 = r10.getResourceId(r5, r6);
            r9.f84d = r6;
            r6 = r9.f84d;
            if (r6 != r0) goto L_0x03e0;
        L_0x0381:
            r5 = r10.getInt(r5, r0);
            r9.f84d = r5;
            goto L_0x03e0;
        L_0x0388:
            r6 = r9.f83c;
            r5 = r10.getFloat(r5, r6);
            r9.f83c = r5;
            goto L_0x03e0;
        L_0x0391:
            r6 = r9.f82b;
            r5 = r10.getDimensionPixelOffset(r5, r6);
            r9.f82b = r5;
            goto L_0x03e0;
        L_0x039a:
            r6 = r9.f81a;
            r5 = r10.getDimensionPixelOffset(r5, r6);
            r9.f81a = r5;
            goto L_0x03e0;
        L_0x03a3:
            r6 = r9.f95o;
            r5 = r10.getFloat(r5, r6);
            r6 = 1135869952; // 0x43b40000 float:360.0 double:5.611943214E-315;
            r5 = r5 % r6;
            r9.f95o = r5;
            r5 = r9.f95o;
            r5 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1));
            if (r5 >= 0) goto L_0x03e0;
        L_0x03b4:
            r5 = r9.f95o;
            r5 = r6 - r5;
            r5 = r5 % r6;
            r9.f95o = r5;
            goto L_0x03e0;
        L_0x03bc:
            r6 = r9.f94n;
            r5 = r10.getDimensionPixelSize(r5, r6);
            r9.f94n = r5;
            goto L_0x03e0;
        L_0x03c5:
            r6 = r9.f93m;
            r6 = r10.getResourceId(r5, r6);
            r9.f93m = r6;
            r6 = r9.f93m;
            if (r6 != r0) goto L_0x03e0;
        L_0x03d1:
            r5 = r10.getInt(r5, r0);
            r9.f93m = r5;
            goto L_0x03e0;
        L_0x03d8:
            r6 = r9.f73S;
            r5 = r10.getInt(r5, r6);
            r9.f73S = r5;
        L_0x03e0:
            r3 = r3 + 1;
            goto L_0x009a;
        L_0x03e4:
            r10.recycle();
            r9.m24a();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.ConstraintLayout.LayoutParams.<init>(android.content.Context, android.util.AttributeSet):void");
        }

        public final void m24a() {
            this.f79Y = false;
            this.f76V = true;
            this.f77W = true;
            if (this.width == -2 && this.f74T) {
                this.f76V = false;
                this.f63I = 1;
            }
            if (this.height == -2 && this.f75U) {
                this.f77W = false;
                this.f64J = 1;
            }
            if (this.width == 0 || this.width == -1) {
                this.f76V = false;
                if (this.width == 0 && this.f63I == 1) {
                    this.width = -2;
                    this.f74T = true;
                }
            }
            if (this.height == 0 || this.height == -1) {
                this.f77W = false;
                if (this.height == 0 && this.f64J == 1) {
                    this.height = -2;
                    this.f75U = true;
                }
            }
            if (this.f83c != -1.0f || this.f81a != -1 || this.f82b != -1) {
                this.f79Y = true;
                this.f76V = true;
                this.f77W = true;
                if (!(this.al instanceof Guideline)) {
                    this.al = new Guideline();
                }
                ((Guideline) this.al).m9446g(this.f73S);
            }
        }

        public LayoutParams() {
            super(-2, -2);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        @TargetApi(17)
        public void resolveLayoutDirection(int i) {
            int i2 = this.leftMargin;
            int i3 = this.rightMargin;
            super.resolveLayoutDirection(i);
            this.ad = -1;
            this.ae = -1;
            this.ab = -1;
            this.ac = -1;
            this.af = -1;
            this.ag = -1;
            this.af = this.f100t;
            this.ag = this.f102v;
            this.ah = this.f106z;
            this.ai = this.f81a;
            this.aj = this.f82b;
            this.ak = this.f83c;
            Object obj = null;
            if ((1 == getLayoutDirection() ? 1 : null) != null) {
                if (this.f96p != -1) {
                    this.ad = this.f96p;
                } else {
                    if (this.f97q != -1) {
                        this.ae = this.f97q;
                    }
                    if (this.f98r != -1) {
                        this.ac = this.f98r;
                        obj = 1;
                    }
                    if (this.f99s != -1) {
                        this.ab = this.f99s;
                        obj = 1;
                    }
                    if (this.f104x != -1) {
                        this.ag = this.f104x;
                    }
                    if (this.f105y != -1) {
                        this.af = this.f105y;
                    }
                    if (obj != null) {
                        this.ah = 1.0f - this.f106z;
                    }
                    if (this.f79Y && this.f73S == 1) {
                        if (this.f83c != -1.0f) {
                            this.ak = 1.0f - this.f83c;
                            this.ai = -1;
                            this.aj = -1;
                        } else if (this.f81a != -1) {
                            this.aj = this.f81a;
                            this.ai = -1;
                            this.ak = -1.0f;
                        } else if (this.f82b != -1) {
                            this.ai = this.f82b;
                            this.aj = -1;
                            this.ak = -1.0f;
                        }
                    }
                }
                obj = 1;
                if (this.f98r != -1) {
                    this.ac = this.f98r;
                    obj = 1;
                }
                if (this.f99s != -1) {
                    this.ab = this.f99s;
                    obj = 1;
                }
                if (this.f104x != -1) {
                    this.ag = this.f104x;
                }
                if (this.f105y != -1) {
                    this.af = this.f105y;
                }
                if (obj != null) {
                    this.ah = 1.0f - this.f106z;
                }
                if (this.f83c != -1.0f) {
                    this.ak = 1.0f - this.f83c;
                    this.ai = -1;
                    this.aj = -1;
                } else if (this.f81a != -1) {
                    this.aj = this.f81a;
                    this.ai = -1;
                    this.ak = -1.0f;
                } else if (this.f82b != -1) {
                    this.ai = this.f82b;
                    this.aj = -1;
                    this.ak = -1.0f;
                }
            } else {
                if (this.f96p != -1) {
                    this.ac = this.f96p;
                }
                if (this.f97q != -1) {
                    this.ab = this.f97q;
                }
                if (this.f98r != -1) {
                    this.ad = this.f98r;
                }
                if (this.f99s != -1) {
                    this.ae = this.f99s;
                }
                if (this.f104x != -1) {
                    this.af = this.f104x;
                }
                if (this.f105y != -1) {
                    this.ag = this.f105y;
                }
            }
            if (this.f98r == -1 && this.f99s == -1 && this.f97q == -1 && this.f96p == -1) {
                if (this.f86f != -1) {
                    this.ad = this.f86f;
                    if (this.rightMargin <= 0 && i3 > 0) {
                        this.rightMargin = i3;
                    }
                } else if (this.f87g != -1) {
                    this.ae = this.f87g;
                    if (this.rightMargin <= 0 && i3 > 0) {
                        this.rightMargin = i3;
                    }
                }
                if (this.f84d != -1) {
                    this.ab = this.f84d;
                    if (this.leftMargin <= 0 && i2 > 0) {
                        this.leftMargin = i2;
                    }
                } else if (this.f85e != -1) {
                    this.ac = this.f85e;
                    if (this.leftMargin <= 0 && i2 > 0) {
                        this.leftMargin = i2;
                    }
                }
            }
        }
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    private void m28a(Object obj, Object obj2) {
        if ((obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.f109c == null) {
                this.f109c = new HashMap();
            }
            obj = (String) obj;
            int indexOf = obj.indexOf(Operation.DIVISION);
            if (indexOf != -1) {
                obj = obj.substring(indexOf + 1);
            }
            this.f109c.put(obj, Integer.valueOf(((Integer) obj2).intValue()));
        }
    }

    public ConstraintLayout(Context context) {
        super(context);
        m27a(null);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m27a(attributeSet);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m27a(attributeSet);
    }

    public void setId(int i) {
        this.f107a.remove(getId());
        super.setId(i);
        this.f107a.put(getId(), this);
    }

    public void setTitle(String str) {
        this.f123q = str;
    }

    public String getTitle() {
        return this.f123q;
    }

    private void m27a(android.util.AttributeSet r14) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r13 = this;
        r0 = r13.f108b;
        r0.f316T = r13;
        r0 = r13.f107a;
        r1 = r13.getId();
        r0.put(r1, r13);
        r0 = 0;
        r13.f122p = r0;
        if (r14 == 0) goto L_0x00f0;
    L_0x0012:
        r1 = r13.getContext();
        r2 = android.support.constraint.C0004R.styleable.ConstraintLayout_Layout;
        r14 = r1.obtainStyledAttributes(r14, r2);
        r1 = r14.getIndexCount();
        r2 = 0;
        r3 = r2;
    L_0x0022:
        if (r3 >= r1) goto L_0x00ed;
    L_0x0024:
        r4 = r14.getIndex(r3);
        r5 = android.support.constraint.C0004R.styleable.ConstraintLayout_Layout_android_minWidth;
        if (r4 != r5) goto L_0x0036;
    L_0x002c:
        r5 = r13.f116j;
        r4 = r14.getDimensionPixelOffset(r4, r5);
        r13.f116j = r4;
        goto L_0x00e9;
    L_0x0036:
        r5 = android.support.constraint.C0004R.styleable.ConstraintLayout_Layout_android_minHeight;
        if (r4 != r5) goto L_0x0044;
    L_0x003a:
        r5 = r13.f117k;
        r4 = r14.getDimensionPixelOffset(r4, r5);
        r13.f117k = r4;
        goto L_0x00e9;
    L_0x0044:
        r5 = android.support.constraint.C0004R.styleable.ConstraintLayout_Layout_android_maxWidth;
        if (r4 != r5) goto L_0x0052;
    L_0x0048:
        r5 = r13.f118l;
        r4 = r14.getDimensionPixelOffset(r4, r5);
        r13.f118l = r4;
        goto L_0x00e9;
    L_0x0052:
        r5 = android.support.constraint.C0004R.styleable.ConstraintLayout_Layout_android_maxHeight;
        if (r4 != r5) goto L_0x0060;
    L_0x0056:
        r5 = r13.f119m;
        r4 = r14.getDimensionPixelOffset(r4, r5);
        r13.f119m = r4;
        goto L_0x00e9;
    L_0x0060:
        r5 = android.support.constraint.C0004R.styleable.ConstraintLayout_Layout_layout_optimizationLevel;
        if (r4 != r5) goto L_0x006e;
    L_0x0064:
        r5 = r13.f121o;
        r4 = r14.getInt(r4, r5);
        r13.f121o = r4;
        goto L_0x00e9;
    L_0x006e:
        r5 = android.support.constraint.C0004R.styleable.ConstraintLayout_Layout_title;
        if (r4 != r5) goto L_0x007a;
    L_0x0072:
        r4 = r14.getString(r4);
        r13.f123q = r4;
        goto L_0x00e9;
    L_0x007a:
        r5 = android.support.constraint.C0004R.styleable.ConstraintLayout_Layout_constraintSet;
        if (r4 != r5) goto L_0x00e9;
    L_0x007e:
        r4 = r14.getResourceId(r4, r2);
        r5 = new android.support.constraint.ConstraintSet;	 Catch:{ NotFoundException -> 0x00e5 }
        r5.<init>();	 Catch:{ NotFoundException -> 0x00e5 }
        r13.f122p = r5;	 Catch:{ NotFoundException -> 0x00e5 }
        r5 = r13.f122p;	 Catch:{ NotFoundException -> 0x00e5 }
        r6 = r13.getContext();	 Catch:{ NotFoundException -> 0x00e5 }
        r7 = r6.getResources();	 Catch:{ NotFoundException -> 0x00e5 }
        r7 = r7.getXml(r4);	 Catch:{ NotFoundException -> 0x00e5 }
        r8 = r7.getEventType();	 Catch:{ XmlPullParserException -> 0x00e0, IOException -> 0x00db }
    L_0x009b:
        r9 = 1;	 Catch:{ XmlPullParserException -> 0x00e0, IOException -> 0x00db }
        if (r8 == r9) goto L_0x00e7;	 Catch:{ XmlPullParserException -> 0x00e0, IOException -> 0x00db }
    L_0x009e:
        if (r8 == 0) goto L_0x00d3;	 Catch:{ XmlPullParserException -> 0x00e0, IOException -> 0x00db }
    L_0x00a0:
        r10 = 2;	 Catch:{ XmlPullParserException -> 0x00e0, IOException -> 0x00db }
        if (r8 == r10) goto L_0x00a4;	 Catch:{ XmlPullParserException -> 0x00e0, IOException -> 0x00db }
    L_0x00a3:
        goto L_0x00d6;	 Catch:{ XmlPullParserException -> 0x00e0, IOException -> 0x00db }
    L_0x00a4:
        r8 = r7.getName();	 Catch:{ XmlPullParserException -> 0x00e0, IOException -> 0x00db }
        r10 = android.util.Xml.asAttributeSet(r7);	 Catch:{ XmlPullParserException -> 0x00e0, IOException -> 0x00db }
        r11 = new android.support.constraint.ConstraintSet$Constraint;	 Catch:{ XmlPullParserException -> 0x00e0, IOException -> 0x00db }
        r11.<init>();	 Catch:{ XmlPullParserException -> 0x00e0, IOException -> 0x00db }
        r12 = android.support.constraint.C0004R.styleable.ConstraintSet;	 Catch:{ XmlPullParserException -> 0x00e0, IOException -> 0x00db }
        r10 = r6.obtainStyledAttributes(r10, r12);	 Catch:{ XmlPullParserException -> 0x00e0, IOException -> 0x00db }
        android.support.constraint.ConstraintSet.m35a(r11, r10);	 Catch:{ XmlPullParserException -> 0x00e0, IOException -> 0x00db }
        r10.recycle();	 Catch:{ XmlPullParserException -> 0x00e0, IOException -> 0x00db }
        r10 = "Guideline";	 Catch:{ XmlPullParserException -> 0x00e0, IOException -> 0x00db }
        r8 = r8.equalsIgnoreCase(r10);	 Catch:{ XmlPullParserException -> 0x00e0, IOException -> 0x00db }
        if (r8 == 0) goto L_0x00c7;	 Catch:{ XmlPullParserException -> 0x00e0, IOException -> 0x00db }
    L_0x00c5:
        r11.f153a = r9;	 Catch:{ XmlPullParserException -> 0x00e0, IOException -> 0x00db }
    L_0x00c7:
        r8 = r5.f181a;	 Catch:{ XmlPullParserException -> 0x00e0, IOException -> 0x00db }
        r9 = r11.f156d;	 Catch:{ XmlPullParserException -> 0x00e0, IOException -> 0x00db }
        r9 = java.lang.Integer.valueOf(r9);	 Catch:{ XmlPullParserException -> 0x00e0, IOException -> 0x00db }
        r8.put(r9, r11);	 Catch:{ XmlPullParserException -> 0x00e0, IOException -> 0x00db }
        goto L_0x00d6;	 Catch:{ XmlPullParserException -> 0x00e0, IOException -> 0x00db }
    L_0x00d3:
        r7.getName();	 Catch:{ XmlPullParserException -> 0x00e0, IOException -> 0x00db }
    L_0x00d6:
        r8 = r7.next();	 Catch:{ XmlPullParserException -> 0x00e0, IOException -> 0x00db }
        goto L_0x009b;
    L_0x00db:
        r5 = move-exception;
        r5.printStackTrace();	 Catch:{ NotFoundException -> 0x00e5 }
        goto L_0x00e7;	 Catch:{ NotFoundException -> 0x00e5 }
    L_0x00e0:
        r5 = move-exception;	 Catch:{ NotFoundException -> 0x00e5 }
        r5.printStackTrace();	 Catch:{ NotFoundException -> 0x00e5 }
        goto L_0x00e7;
    L_0x00e5:
        r13.f122p = r0;
    L_0x00e7:
        r13.f124r = r4;
    L_0x00e9:
        r3 = r3 + 1;
        goto L_0x0022;
    L_0x00ed:
        r14.recycle();
    L_0x00f0:
        r14 = r13.f108b;
        r0 = r13.f121o;
        r14.aq = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.ConstraintLayout.a(android.util.AttributeSet):void");
    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (VERSION.SDK_INT < 14) {
            onViewAdded(view);
        }
    }

    public void removeView(View view) {
        super.removeView(view);
        if (VERSION.SDK_INT < 14) {
            onViewRemoved(view);
        }
    }

    public void onViewAdded(View view) {
        if (VERSION.SDK_INT >= 14) {
            super.onViewAdded(view);
        }
        ConstraintWidget a = m29a(view);
        if ((view instanceof Guideline) && !(a instanceof Guideline)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.al = new Guideline();
            layoutParams.f79Y = true;
            ((Guideline) layoutParams.al).m9446g(layoutParams.f73S);
        }
        if (view instanceof ConstraintHelper) {
            ConstraintHelper constraintHelper = (ConstraintHelper) view;
            constraintHelper.m21a();
            ((LayoutParams) view.getLayoutParams()).f80Z = true;
            if (!this.f114h.contains(constraintHelper)) {
                this.f114h.add(constraintHelper);
            }
        }
        this.f107a.put(view.getId(), view);
        this.f120n = true;
    }

    public void onViewRemoved(View view) {
        if (VERSION.SDK_INT >= 14) {
            super.onViewRemoved(view);
        }
        this.f107a.remove(view.getId());
        ConstraintWidget a = m29a(view);
        this.f108b.m9456b(a);
        this.f114h.remove(view);
        this.f115i.remove(a);
        this.f120n = true;
    }

    public void setMinWidth(int i) {
        if (i != this.f116j) {
            this.f116j = i;
            requestLayout();
        }
    }

    public void setMinHeight(int i) {
        if (i != this.f117k) {
            this.f117k = i;
            requestLayout();
        }
    }

    public int getMinWidth() {
        return this.f116j;
    }

    public int getMinHeight() {
        return this.f117k;
    }

    public void setMaxWidth(int i) {
        if (i != this.f118l) {
            this.f118l = i;
            requestLayout();
        }
    }

    public void setMaxHeight(int i) {
        if (i != this.f119m) {
            this.f119m = i;
            requestLayout();
        }
    }

    public int getMaxWidth() {
        return this.f118l;
    }

    public int getMaxHeight() {
        return this.f119m;
    }

    private final ConstraintWidget m26a(int i) {
        if (i == 0) {
            return this.f108b;
        }
        View view = (View) this.f107a.get(i);
        if (view == this) {
            return this.f108b;
        }
        if (view == null) {
            return 0;
        }
        return ((LayoutParams) view.getLayoutParams()).al;
    }

    public final ConstraintWidget m29a(View view) {
        if (view == this) {
            return this.f108b;
        }
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).al;
    }

    public void onMeasure(int r51, int r52) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r50 = this;
        r0 = r50;
        r1 = r51;
        r2 = r52;
        r3 = android.view.View.MeasureSpec.getMode(r51);
        r4 = android.view.View.MeasureSpec.getSize(r51);
        r5 = android.view.View.MeasureSpec.getMode(r52);
        r6 = android.view.View.MeasureSpec.getSize(r52);
        r0.f112f = r3;
        r0.f113g = r5;
        r0.f110d = r4;
        r0.f111e = r6;
        r3 = r50.getPaddingLeft();
        r4 = r50.getPaddingTop();
        r5 = r0.f108b;
        r5.m90a(r3);
        r5 = r0.f108b;
        r5.m99b(r4);
        r5 = r0.f108b;
        r6 = r0.f118l;
        r5 = r5.f338p;
        r7 = 0;
        r5[r7] = r6;
        r5 = r0.f108b;
        r6 = r0.f119m;
        r5 = r5.f338p;
        r8 = 1;
        r5[r8] = r6;
        r5 = android.os.Build.VERSION.SDK_INT;
        r6 = 17;
        if (r5 < r6) goto L_0x0055;
    L_0x0048:
        r5 = r0.f108b;
        r9 = r50.getLayoutDirection();
        if (r9 != r8) goto L_0x0052;
    L_0x0050:
        r9 = r8;
        goto L_0x0053;
    L_0x0052:
        r9 = r7;
    L_0x0053:
        r5.f16396a = r9;
    L_0x0055:
        r5 = android.view.View.MeasureSpec.getMode(r51);
        r9 = android.view.View.MeasureSpec.getSize(r51);
        r10 = android.view.View.MeasureSpec.getMode(r52);
        r11 = android.view.View.MeasureSpec.getSize(r52);
        r12 = r50.getPaddingTop();
        r13 = r50.getPaddingBottom();
        r12 = r12 + r13;
        r13 = r50.getPaddingLeft();
        r14 = r50.getPaddingRight();
        r13 = r13 + r14;
        r14 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED;
        r15 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED;
        r50.getLayoutParams();
        r6 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r8 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        if (r5 == r6) goto L_0x0095;
    L_0x0084:
        if (r5 == 0) goto L_0x0092;
    L_0x0086:
        if (r5 == r8) goto L_0x008a;
    L_0x0088:
        r5 = r7;
        goto L_0x0098;
    L_0x008a:
        r5 = r0.f118l;
        r5 = java.lang.Math.min(r5, r9);
        r5 = r5 - r13;
        goto L_0x0098;
    L_0x0092:
        r14 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        goto L_0x0088;
    L_0x0095:
        r14 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        r5 = r9;
    L_0x0098:
        if (r10 == r6) goto L_0x00ac;
    L_0x009a:
        if (r10 == 0) goto L_0x00a9;
    L_0x009c:
        if (r10 == r8) goto L_0x00a0;
    L_0x009e:
        r11 = r7;
        goto L_0x00ae;
    L_0x00a0:
        r6 = r0.f119m;
        r6 = java.lang.Math.min(r6, r11);
        r6 = r6 - r12;
        r11 = r6;
        goto L_0x00ae;
    L_0x00a9:
        r15 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        goto L_0x009e;
    L_0x00ac:
        r15 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
    L_0x00ae:
        r6 = r0.f108b;
        r6.m109e(r7);
        r6 = r0.f108b;
        r6.m111f(r7);
        r6 = r0.f108b;
        r6.m95a(r14);
        r6 = r0.f108b;
        r6.m103c(r5);
        r5 = r0.f108b;
        r5.m101b(r15);
        r5 = r0.f108b;
        r5.m106d(r11);
        r5 = r0.f108b;
        r6 = r0.f116j;
        r9 = r50.getPaddingLeft();
        r6 = r6 - r9;
        r9 = r50.getPaddingRight();
        r6 = r6 - r9;
        r5.m109e(r6);
        r5 = r0.f108b;
        r6 = r0.f117k;
        r9 = r50.getPaddingTop();
        r6 = r6 - r9;
        r9 = r50.getPaddingBottom();
        r6 = r6 - r9;
        r5.m111f(r6);
        r5 = r0.f108b;
        r5 = r5.m114i();
        r6 = r0.f108b;
        r6 = r6.m115j();
        r9 = r0.f120n;
        r10 = 8;
        r11 = -1;
        if (r9 == 0) goto L_0x05cf;
    L_0x0101:
        r0.f120n = r7;
        r9 = r50.getChildCount();
        r12 = r7;
    L_0x0108:
        if (r12 >= r9) goto L_0x0119;
    L_0x010a:
        r13 = r0.getChildAt(r12);
        r13 = r13.isLayoutRequested();
        if (r13 == 0) goto L_0x0116;
    L_0x0114:
        r9 = 1;
        goto L_0x011a;
    L_0x0116:
        r12 = r12 + 1;
        goto L_0x0108;
    L_0x0119:
        r9 = r7;
    L_0x011a:
        if (r9 == 0) goto L_0x05cf;
    L_0x011c:
        r9 = r0.f115i;
        r9.clear();
        r9 = r50.isInEditMode();
        r12 = r50.getChildCount();
        if (r9 == 0) goto L_0x0166;
    L_0x012b:
        r13 = r7;
    L_0x012c:
        if (r13 >= r12) goto L_0x0166;
    L_0x012e:
        r14 = r0.getChildAt(r13);
        r15 = r50.getResources();	 Catch:{ NotFoundException -> 0x0161 }
        r8 = r14.getId();	 Catch:{ NotFoundException -> 0x0161 }
        r8 = r15.getResourceName(r8);	 Catch:{ NotFoundException -> 0x0161 }
        r15 = r14.getId();	 Catch:{ NotFoundException -> 0x0161 }
        r15 = java.lang.Integer.valueOf(r15);	 Catch:{ NotFoundException -> 0x0161 }
        r0.m28a(r8, r15);	 Catch:{ NotFoundException -> 0x0161 }
        r15 = 47;	 Catch:{ NotFoundException -> 0x0161 }
        r15 = r8.indexOf(r15);	 Catch:{ NotFoundException -> 0x0161 }
        if (r15 == r11) goto L_0x0157;	 Catch:{ NotFoundException -> 0x0161 }
    L_0x0151:
        r15 = r15 + 1;	 Catch:{ NotFoundException -> 0x0161 }
        r8 = r8.substring(r15);	 Catch:{ NotFoundException -> 0x0161 }
    L_0x0157:
        r14 = r14.getId();	 Catch:{ NotFoundException -> 0x0161 }
        r14 = r0.m26a(r14);	 Catch:{ NotFoundException -> 0x0161 }
        r14.f318V = r8;	 Catch:{ NotFoundException -> 0x0161 }
    L_0x0161:
        r13 = r13 + 1;
        r8 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        goto L_0x012c;
    L_0x0166:
        r8 = r7;
    L_0x0167:
        if (r8 >= r12) goto L_0x0179;
    L_0x0169:
        r13 = r0.getChildAt(r8);
        r13 = r0.m29a(r13);
        if (r13 == 0) goto L_0x0176;
    L_0x0173:
        r13.mo22e();
    L_0x0176:
        r8 = r8 + 1;
        goto L_0x0167;
    L_0x0179:
        r8 = r0.f124r;
        if (r8 == r11) goto L_0x019b;
    L_0x017d:
        r8 = r7;
    L_0x017e:
        if (r8 >= r12) goto L_0x019b;
    L_0x0180:
        r13 = r0.getChildAt(r8);
        r14 = r13.getId();
        r15 = r0.f124r;
        if (r14 != r15) goto L_0x0198;
    L_0x018c:
        r14 = r13 instanceof android.support.constraint.Constraints;
        if (r14 == 0) goto L_0x0198;
    L_0x0190:
        r13 = (android.support.constraint.Constraints) r13;
        r13 = r13.getConstraintSet();
        r0.f122p = r13;
    L_0x0198:
        r8 = r8 + 1;
        goto L_0x017e;
    L_0x019b:
        r8 = r0.f122p;
        if (r8 == 0) goto L_0x01a4;
    L_0x019f:
        r8 = r0.f122p;
        r8.m36a(r0);
    L_0x01a4:
        r8 = r0.f108b;
        r8.m9461z();
        r8 = r0.f114h;
        r8 = r8.size();
        if (r8 <= 0) goto L_0x01c2;
    L_0x01b1:
        r13 = r7;
    L_0x01b2:
        if (r13 >= r8) goto L_0x01c2;
    L_0x01b4:
        r14 = r0.f114h;
        r14 = r14.get(r13);
        r14 = (android.support.constraint.ConstraintHelper) r14;
        r14.m22a(r0);
        r13 = r13 + 1;
        goto L_0x01b2;
    L_0x01c2:
        r8 = r7;
    L_0x01c3:
        if (r8 >= r12) goto L_0x0200;
    L_0x01c5:
        r13 = r0.getChildAt(r8);
        r14 = r13 instanceof android.support.constraint.Placeholder;
        if (r14 == 0) goto L_0x01fd;
    L_0x01cd:
        r13 = (android.support.constraint.Placeholder) r13;
        r14 = r13.f183a;
        if (r14 != r11) goto L_0x01de;
    L_0x01d3:
        r14 = r13.isInEditMode();
        if (r14 != 0) goto L_0x01de;
    L_0x01d9:
        r14 = r13.f185c;
        r13.setVisibility(r14);
    L_0x01de:
        r14 = r13.f183a;
        r14 = r0.findViewById(r14);
        r13.f184b = r14;
        r14 = r13.f184b;
        if (r14 == 0) goto L_0x01fd;
    L_0x01ea:
        r14 = r13.f184b;
        r14 = r14.getLayoutParams();
        r14 = (android.support.constraint.ConstraintLayout.LayoutParams) r14;
        r15 = 1;
        r14.aa = r15;
        r14 = r13.f184b;
        r14.setVisibility(r7);
        r13.setVisibility(r7);
    L_0x01fd:
        r8 = r8 + 1;
        goto L_0x01c3;
    L_0x0200:
        r8 = r7;
    L_0x0201:
        if (r8 >= r12) goto L_0x05cf;
    L_0x0203:
        r13 = r0.getChildAt(r8);
        r14 = r0.m29a(r13);
        if (r14 == 0) goto L_0x05bb;
    L_0x020d:
        r15 = r13.getLayoutParams();
        r15 = (android.support.constraint.ConstraintLayout.LayoutParams) r15;
        r15.m24a();
        r11 = r15.am;
        if (r11 == 0) goto L_0x021d;
    L_0x021a:
        r15.am = r7;
        goto L_0x024c;
    L_0x021d:
        if (r9 == 0) goto L_0x024c;
    L_0x021f:
        r11 = r50.getResources();	 Catch:{ NotFoundException -> 0x024c }
        r7 = r13.getId();	 Catch:{ NotFoundException -> 0x024c }
        r7 = r11.getResourceName(r7);	 Catch:{ NotFoundException -> 0x024c }
        r11 = r13.getId();	 Catch:{ NotFoundException -> 0x024c }
        r11 = java.lang.Integer.valueOf(r11);	 Catch:{ NotFoundException -> 0x024c }
        r0.m28a(r7, r11);	 Catch:{ NotFoundException -> 0x024c }
        r11 = "id/";	 Catch:{ NotFoundException -> 0x024c }
        r11 = r7.indexOf(r11);	 Catch:{ NotFoundException -> 0x024c }
        r11 = r11 + 3;	 Catch:{ NotFoundException -> 0x024c }
        r7 = r7.substring(r11);	 Catch:{ NotFoundException -> 0x024c }
        r11 = r13.getId();	 Catch:{ NotFoundException -> 0x024c }
        r11 = r0.m26a(r11);	 Catch:{ NotFoundException -> 0x024c }
        r11.f318V = r7;	 Catch:{ NotFoundException -> 0x024c }
    L_0x024c:
        r7 = r13.getVisibility();
        r14.f317U = r7;
        r7 = r15.aa;
        if (r7 == 0) goto L_0x0258;
    L_0x0256:
        r14.f317U = r10;
    L_0x0258:
        r14.f316T = r13;
        r7 = r0.f108b;
        r7.m9454a(r14);
        r7 = r15.f77W;
        if (r7 == 0) goto L_0x0267;
    L_0x0263:
        r7 = r15.f76V;
        if (r7 != 0) goto L_0x026c;
    L_0x0267:
        r7 = r0.f115i;
        r7.add(r14);
    L_0x026c:
        r7 = r15.f79Y;
        if (r7 == 0) goto L_0x02a3;
    L_0x0270:
        r14 = (android.support.constraint.solver.widgets.Guideline) r14;
        r7 = r15.ai;
        r11 = r15.aj;
        r13 = r15.ak;
        r10 = android.os.Build.VERSION.SDK_INT;
        r24 = r7;
        r7 = 17;
        if (r10 >= r7) goto L_0x0287;
    L_0x0280:
        r7 = r15.f81a;
        r11 = r15.f82b;
        r13 = r15.f83c;
        goto L_0x0289;
    L_0x0287:
        r7 = r24;
    L_0x0289:
        r10 = -1082130432; // 0xffffffffbf800000 float:-1.0 double:NaN;
        r10 = (r13 > r10 ? 1 : (r13 == r10 ? 0 : -1));
        if (r10 == 0) goto L_0x0294;
    L_0x028f:
        r14.m9442a(r13);
        goto L_0x05bb;
    L_0x0294:
        r10 = -1;
        if (r7 == r10) goto L_0x029c;
    L_0x0297:
        r14.m9447h(r7);
        goto L_0x05bb;
    L_0x029c:
        if (r11 == r10) goto L_0x05bb;
    L_0x029e:
        r14.m9448i(r11);
        goto L_0x05bb;
    L_0x02a3:
        r10 = -1;
        r7 = r15.f84d;
        if (r7 != r10) goto L_0x02ec;
    L_0x02a8:
        r7 = r15.f85e;
        if (r7 != r10) goto L_0x02ec;
    L_0x02ac:
        r7 = r15.f86f;
        if (r7 != r10) goto L_0x02ec;
    L_0x02b0:
        r7 = r15.f87g;
        if (r7 != r10) goto L_0x02ec;
    L_0x02b4:
        r7 = r15.f97q;
        if (r7 != r10) goto L_0x02ec;
    L_0x02b8:
        r7 = r15.f96p;
        if (r7 != r10) goto L_0x02ec;
    L_0x02bc:
        r7 = r15.f98r;
        if (r7 != r10) goto L_0x02ec;
    L_0x02c0:
        r7 = r15.f99s;
        if (r7 != r10) goto L_0x02ec;
    L_0x02c4:
        r7 = r15.f88h;
        if (r7 != r10) goto L_0x02ec;
    L_0x02c8:
        r7 = r15.f89i;
        if (r7 != r10) goto L_0x02ec;
    L_0x02cc:
        r7 = r15.f90j;
        if (r7 != r10) goto L_0x02ec;
    L_0x02d0:
        r7 = r15.f91k;
        if (r7 != r10) goto L_0x02ec;
    L_0x02d4:
        r7 = r15.f92l;
        if (r7 != r10) goto L_0x02ec;
    L_0x02d8:
        r7 = r15.f71Q;
        if (r7 != r10) goto L_0x02ec;
    L_0x02dc:
        r7 = r15.f72R;
        if (r7 != r10) goto L_0x02ec;
    L_0x02e0:
        r7 = r15.f93m;
        if (r7 != r10) goto L_0x02ec;
    L_0x02e4:
        r7 = r15.width;
        if (r7 == r10) goto L_0x02ec;
    L_0x02e8:
        r7 = r15.height;
        if (r7 != r10) goto L_0x05bb;
    L_0x02ec:
        r7 = r15.ab;
        r10 = r15.ac;
        r11 = r15.ad;
        r13 = r15.ae;
        r25 = r7;
        r7 = r15.af;
        r26 = r7;
        r7 = r15.ag;
        r27 = r7;
        r7 = r15.ah;
        r28 = r7;
        r7 = android.os.Build.VERSION.SDK_INT;
        r29 = r10;
        r10 = 17;
        if (r7 >= r10) goto L_0x0365;
    L_0x030a:
        r7 = r15.f84d;
        r11 = r15.f85e;
        r13 = r15.f86f;
        r10 = r15.f87g;
        r30 = r12;
        r12 = r15.f100t;
        r31 = r12;
        r12 = r15.f102v;
        r32 = r12;
        r12 = r15.f106z;
        r33 = r12;
        r12 = -1;
        if (r7 != r12) goto L_0x0336;
    L_0x0323:
        if (r11 != r12) goto L_0x0336;
    L_0x0325:
        r34 = r7;
        r7 = r15.f97q;
        if (r7 == r12) goto L_0x032e;
    L_0x032b:
        r7 = r15.f97q;
        goto L_0x033a;
    L_0x032e:
        r7 = r15.f96p;
        if (r7 == r12) goto L_0x0338;
    L_0x0332:
        r7 = r15.f96p;
        r11 = r7;
        goto L_0x0338;
    L_0x0336:
        r34 = r7;
    L_0x0338:
        r7 = r34;
    L_0x033a:
        if (r13 != r12) goto L_0x0358;
    L_0x033c:
        if (r10 != r12) goto L_0x0358;
    L_0x033e:
        r35 = r7;
        r7 = r15.f98r;
        if (r7 == r12) goto L_0x034c;
    L_0x0344:
        r7 = r15.f98r;
        r37 = r5;
        r36 = r6;
        r13 = r7;
        goto L_0x035e;
    L_0x034c:
        r7 = r15.f99s;
        if (r7 == r12) goto L_0x035a;
    L_0x0350:
        r7 = r15.f99s;
        r37 = r5;
        r36 = r6;
        r10 = r7;
        goto L_0x035e;
    L_0x0358:
        r35 = r7;
    L_0x035a:
        r37 = r5;
        r36 = r6;
    L_0x035e:
        r23 = r31;
        r6 = r33;
        r7 = r35;
        goto L_0x0378;
    L_0x0365:
        r30 = r12;
        r12 = -1;
        r37 = r5;
        r36 = r6;
        r10 = r13;
        r7 = r25;
        r23 = r26;
        r32 = r27;
        r6 = r28;
        r13 = r11;
        r11 = r29;
    L_0x0378:
        r5 = r15.f93m;
        if (r5 == r12) goto L_0x0399;
    L_0x037c:
        r5 = r15.f93m;
        r20 = r0.m26a(r5);
        if (r20 == 0) goto L_0x04e4;
    L_0x0384:
        r5 = r15.f95o;
        r6 = r15.f94n;
        r19 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.f276g;
        r21 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.f276g;
        r23 = 0;
        r18 = r14;
        r22 = r6;
        r18.m94a(r19, r20, r21, r22, r23);
        r14.f339q = r5;
        goto L_0x04e4;
    L_0x0399:
        r5 = r12;
        if (r7 == r5) goto L_0x03b1;
    L_0x039c:
        r20 = r0.m26a(r7);
        if (r20 == 0) goto L_0x03af;
    L_0x03a2:
        r19 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.f271b;
        r21 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.f271b;
        r5 = r15.leftMargin;
        r18 = r14;
        r22 = r5;
        r18.m94a(r19, r20, r21, r22, r23);
    L_0x03af:
        r5 = -1;
        goto L_0x03c7;
    L_0x03b1:
        if (r11 == r5) goto L_0x03c7;
    L_0x03b3:
        r20 = r0.m26a(r11);
        if (r20 == 0) goto L_0x03af;
    L_0x03b9:
        r19 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.f271b;
        r21 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.f273d;
        r5 = r15.leftMargin;
        r18 = r14;
        r22 = r5;
        r18.m94a(r19, r20, r21, r22, r23);
        goto L_0x03af;
    L_0x03c7:
        if (r13 == r5) goto L_0x03df;
    L_0x03c9:
        r20 = r0.m26a(r13);
        if (r20 == 0) goto L_0x03f6;
    L_0x03cf:
        r19 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.f273d;
        r21 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.f271b;
        r5 = r15.rightMargin;
        r18 = r14;
        r22 = r5;
        r23 = r32;
        r18.m94a(r19, r20, r21, r22, r23);
        goto L_0x03f6;
    L_0x03df:
        if (r10 == r5) goto L_0x03f6;
    L_0x03e1:
        r20 = r0.m26a(r10);
        if (r20 == 0) goto L_0x03f6;
    L_0x03e7:
        r19 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.f273d;
        r21 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.f273d;
        r5 = r15.rightMargin;
        r18 = r14;
        r22 = r5;
        r23 = r32;
        r18.m94a(r19, r20, r21, r22, r23);
    L_0x03f6:
        r5 = r15.f88h;
        r7 = -1;
        if (r5 == r7) goto L_0x0415;
    L_0x03fb:
        r5 = r15.f88h;
        r20 = r0.m26a(r5);
        if (r20 == 0) goto L_0x0433;
    L_0x0403:
        r19 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.f272c;
        r21 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.f272c;
        r5 = r15.topMargin;
        r7 = r15.f101u;
        r18 = r14;
        r22 = r5;
        r23 = r7;
        r18.m94a(r19, r20, r21, r22, r23);
        goto L_0x0433;
    L_0x0415:
        r5 = r15.f89i;
        r7 = -1;
        if (r5 == r7) goto L_0x0433;
    L_0x041a:
        r5 = r15.f89i;
        r20 = r0.m26a(r5);
        if (r20 == 0) goto L_0x0433;
    L_0x0422:
        r19 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.f272c;
        r21 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.f274e;
        r5 = r15.topMargin;
        r7 = r15.f101u;
        r18 = r14;
        r22 = r5;
        r23 = r7;
        r18.m94a(r19, r20, r21, r22, r23);
    L_0x0433:
        r5 = r15.f90j;
        r7 = -1;
        if (r5 == r7) goto L_0x0452;
    L_0x0438:
        r5 = r15.f90j;
        r20 = r0.m26a(r5);
        if (r20 == 0) goto L_0x0470;
    L_0x0440:
        r19 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.f274e;
        r21 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.f272c;
        r5 = r15.bottomMargin;
        r7 = r15.f103w;
        r18 = r14;
        r22 = r5;
        r23 = r7;
        r18.m94a(r19, r20, r21, r22, r23);
        goto L_0x0470;
    L_0x0452:
        r5 = r15.f91k;
        r7 = -1;
        if (r5 == r7) goto L_0x0470;
    L_0x0457:
        r5 = r15.f91k;
        r20 = r0.m26a(r5);
        if (r20 == 0) goto L_0x0470;
    L_0x045f:
        r19 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.f274e;
        r21 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.f274e;
        r5 = r15.bottomMargin;
        r7 = r15.f103w;
        r18 = r14;
        r22 = r5;
        r23 = r7;
        r18.m94a(r19, r20, r21, r22, r23);
    L_0x0470:
        r5 = r15.f92l;
        r7 = -1;
        if (r5 == r7) goto L_0x04c7;
    L_0x0475:
        r5 = r0.f107a;
        r7 = r15.f92l;
        r5 = r5.get(r7);
        r5 = (android.view.View) r5;
        r7 = r15.f92l;
        r7 = r0.m26a(r7);
        if (r7 == 0) goto L_0x04c7;
    L_0x0487:
        if (r5 == 0) goto L_0x04c7;
    L_0x0489:
        r10 = r5.getLayoutParams();
        r10 = r10 instanceof android.support.constraint.ConstraintLayout.LayoutParams;
        if (r10 == 0) goto L_0x04c7;
    L_0x0491:
        r5 = r5.getLayoutParams();
        r5 = (android.support.constraint.ConstraintLayout.LayoutParams) r5;
        r10 = 1;
        r15.f78X = r10;
        r5.f78X = r10;
        r5 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.f275f;
        r38 = r14.mo14a(r5);
        r5 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.f275f;
        r39 = r7.mo14a(r5);
        r40 = 0;
        r41 = -1;
        r42 = android.support.constraint.solver.widgets.ConstraintAnchor.Strength.f267b;
        r43 = 0;
        r44 = 1;
        r38.m84a(r39, r40, r41, r42, r43, r44);
        r5 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.f272c;
        r5 = r14.mo14a(r5);
        r5.m86c();
        r5 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.f274e;
        r5 = r14.mo14a(r5);
        r5.m86c();
    L_0x04c7:
        r5 = 0;
        r7 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1));
        r10 = 1056964608; // 0x3f000000 float:0.5 double:5.222099017E-315;
        if (r7 < 0) goto L_0x04d4;
    L_0x04ce:
        r7 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1));
        if (r7 == 0) goto L_0x04d4;
    L_0x04d2:
        r14.f314R = r6;
    L_0x04d4:
        r6 = r15.f55A;
        r5 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1));
        if (r5 < 0) goto L_0x04e4;
    L_0x04da:
        r5 = r15.f55A;
        r5 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1));
        if (r5 == 0) goto L_0x04e4;
    L_0x04e0:
        r5 = r15.f55A;
        r14.f315S = r5;
    L_0x04e4:
        if (r9 == 0) goto L_0x04f6;
    L_0x04e6:
        r5 = r15.f71Q;
        r6 = -1;
        if (r5 != r6) goto L_0x04ef;
    L_0x04eb:
        r5 = r15.f72R;
        if (r5 == r6) goto L_0x04f6;
    L_0x04ef:
        r5 = r15.f71Q;
        r6 = r15.f72R;
        r14.m91a(r5, r6);
    L_0x04f6:
        r5 = r15.f76V;
        if (r5 != 0) goto L_0x0523;
    L_0x04fa:
        r5 = r15.width;
        r6 = -1;
        if (r5 != r6) goto L_0x0519;
    L_0x04ff:
        r5 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
        r14.m95a(r5);
        r5 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.f271b;
        r5 = r14.mo14a(r5);
        r6 = r15.leftMargin;
        r5.f284e = r6;
        r5 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.f273d;
        r5 = r14.mo14a(r5);
        r6 = r15.rightMargin;
        r5.f284e = r6;
        goto L_0x052d;
    L_0x0519:
        r5 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        r14.m95a(r5);
        r5 = 0;
        r14.m103c(r5);
        goto L_0x052d;
    L_0x0523:
        r5 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED;
        r14.m95a(r5);
        r5 = r15.width;
        r14.m103c(r5);
    L_0x052d:
        r5 = r15.f77W;
        if (r5 != 0) goto L_0x055a;
    L_0x0531:
        r5 = r15.height;
        r6 = -1;
        if (r5 != r6) goto L_0x0550;
    L_0x0536:
        r5 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
        r14.m101b(r5);
        r5 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.f272c;
        r5 = r14.mo14a(r5);
        r6 = r15.topMargin;
        r5.f284e = r6;
        r5 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.f274e;
        r5 = r14.mo14a(r5);
        r6 = r15.bottomMargin;
        r5.f284e = r6;
        goto L_0x0564;
    L_0x0550:
        r5 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        r14.m101b(r5);
        r5 = 0;
        r14.m106d(r5);
        goto L_0x0564;
    L_0x055a:
        r5 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED;
        r14.m101b(r5);
        r5 = r15.height;
        r14.m106d(r5);
    L_0x0564:
        r5 = r15.f56B;
        if (r5 == 0) goto L_0x056d;
    L_0x0568:
        r5 = r15.f56B;
        r14.m96a(r5);
    L_0x056d:
        r5 = r15.f59E;
        r6 = r14.ac;
        r7 = 0;
        r6[r7] = r5;
        r5 = r15.f60F;
        r6 = r14.ac;
        r7 = 1;
        r6[r7] = r5;
        r5 = r15.f61G;
        r14.f321Y = r5;
        r5 = r15.f62H;
        r14.f322Z = r5;
        r5 = r15.f63I;
        r6 = r15.f65K;
        r7 = r15.f67M;
        r10 = r15.f69O;
        r14.f326d = r5;
        r14.f328f = r6;
        r14.f329g = r7;
        r14.f330h = r10;
        r5 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r6 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1));
        r7 = 2;
        if (r6 >= 0) goto L_0x05a0;
    L_0x059a:
        r6 = r14.f326d;
        if (r6 != 0) goto L_0x05a0;
    L_0x059e:
        r14.f326d = r7;
    L_0x05a0:
        r6 = r15.f64J;
        r10 = r15.f66L;
        r11 = r15.f68N;
        r12 = r15.f70P;
        r14.f327e = r6;
        r14.f331i = r10;
        r14.f332j = r11;
        r14.f333k = r12;
        r5 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1));
        if (r5 >= 0) goto L_0x05c1;
    L_0x05b4:
        r5 = r14.f327e;
        if (r5 != 0) goto L_0x05c1;
    L_0x05b8:
        r14.f327e = r7;
        goto L_0x05c1;
    L_0x05bb:
        r37 = r5;
        r36 = r6;
        r30 = r12;
    L_0x05c1:
        r8 = r8 + 1;
        r12 = r30;
        r6 = r36;
        r5 = r37;
        r7 = 0;
        r10 = 8;
        r11 = -1;
        goto L_0x0201;
    L_0x05cf:
        r37 = r5;
        r36 = r6;
        r5 = r50.getPaddingTop();
        r6 = r50.getPaddingBottom();
        r5 = r5 + r6;
        r6 = r50.getPaddingLeft();
        r7 = r50.getPaddingRight();
        r6 = r6 + r7;
        r7 = r50.getChildCount();
        r8 = 0;
    L_0x05ea:
        if (r8 >= r7) goto L_0x06da;
    L_0x05ec:
        r10 = r0.getChildAt(r8);
        r11 = r10.getVisibility();
        r12 = 8;
        if (r11 == r12) goto L_0x06d2;
    L_0x05f8:
        r11 = r10.getLayoutParams();
        r11 = (android.support.constraint.ConstraintLayout.LayoutParams) r11;
        r12 = r11.al;
        r13 = r11.f79Y;
        if (r13 != 0) goto L_0x06d2;
    L_0x0604:
        r13 = r11.f80Z;
        if (r13 != 0) goto L_0x06d2;
    L_0x0608:
        r13 = r10.getVisibility();
        r12.f317U = r13;
        r13 = r11.width;
        r14 = r11.height;
        r15 = r11.f76V;
        if (r15 != 0) goto L_0x063b;
    L_0x0616:
        r15 = r11.f77W;
        if (r15 != 0) goto L_0x063b;
    L_0x061a:
        r15 = r11.f76V;
        if (r15 != 0) goto L_0x0624;
    L_0x061e:
        r15 = r11.f63I;
        r9 = 1;
        if (r15 == r9) goto L_0x063b;
    L_0x0623:
        goto L_0x0625;
    L_0x0624:
        r9 = 1;
    L_0x0625:
        r15 = r11.width;
        r9 = -1;
        if (r15 == r9) goto L_0x063b;
    L_0x062a:
        r15 = r11.f77W;
        if (r15 != 0) goto L_0x0639;
    L_0x062e:
        r15 = r11.f64J;
        r9 = 1;
        if (r15 == r9) goto L_0x063b;
    L_0x0633:
        r15 = r11.height;
        r9 = -1;
        if (r15 != r9) goto L_0x0639;
    L_0x0638:
        goto L_0x063b;
    L_0x0639:
        r9 = 0;
        goto L_0x063c;
    L_0x063b:
        r9 = 1;
    L_0x063c:
        if (r9 == 0) goto L_0x06b0;
    L_0x063e:
        if (r13 != 0) goto L_0x064b;
    L_0x0640:
        r9 = -2;
        r15 = getChildMeasureSpec(r1, r6, r9);
        r46 = r15;
        r15 = -1;
        r16 = 1;
        goto L_0x0665;
    L_0x064b:
        r9 = -2;
        r15 = -1;
        if (r13 != r15) goto L_0x0658;
    L_0x064f:
        r16 = getChildMeasureSpec(r1, r6, r15);
        r46 = r16;
        r16 = 0;
        goto L_0x0665;
    L_0x0658:
        if (r13 != r9) goto L_0x065d;
    L_0x065a:
        r16 = 1;
        goto L_0x065f;
    L_0x065d:
        r16 = 0;
    L_0x065f:
        r17 = getChildMeasureSpec(r1, r6, r13);
        r46 = r17;
    L_0x0665:
        if (r14 != 0) goto L_0x0674;
    L_0x0667:
        r17 = getChildMeasureSpec(r2, r5, r9);
        r47 = r5;
        r15 = r17;
        r5 = r46;
        r17 = 1;
        goto L_0x0696;
    L_0x0674:
        if (r14 != r15) goto L_0x0683;
    L_0x0676:
        r17 = getChildMeasureSpec(r2, r5, r15);
        r47 = r5;
        r15 = r17;
        r5 = r46;
        r17 = 0;
        goto L_0x0696;
    L_0x0683:
        if (r14 != r9) goto L_0x0687;
    L_0x0685:
        r15 = 1;
        goto L_0x0688;
    L_0x0687:
        r15 = 0;
    L_0x0688:
        r17 = getChildMeasureSpec(r2, r5, r14);
        r47 = r5;
        r5 = r46;
        r49 = r17;
        r17 = r15;
        r15 = r49;
    L_0x0696:
        r10.measure(r5, r15);
        if (r13 != r9) goto L_0x069d;
    L_0x069b:
        r5 = 1;
        goto L_0x069e;
    L_0x069d:
        r5 = 0;
    L_0x069e:
        r12.f334l = r5;
        if (r14 != r9) goto L_0x06a4;
    L_0x06a2:
        r5 = 1;
        goto L_0x06a5;
    L_0x06a4:
        r5 = 0;
    L_0x06a5:
        r12.f335m = r5;
        r13 = r10.getMeasuredWidth();
        r14 = r10.getMeasuredHeight();
        goto L_0x06b6;
    L_0x06b0:
        r47 = r5;
        r16 = 0;
        r17 = 0;
    L_0x06b6:
        r12.m103c(r13);
        r12.m106d(r14);
        if (r16 == 0) goto L_0x06c0;
    L_0x06be:
        r12.f312O = r13;
    L_0x06c0:
        if (r17 == 0) goto L_0x06c4;
    L_0x06c2:
        r12.f313P = r14;
    L_0x06c4:
        r5 = r11.f78X;
        if (r5 == 0) goto L_0x06d4;
    L_0x06c8:
        r5 = r10.getBaseline();
        r9 = -1;
        if (r5 == r9) goto L_0x06d4;
    L_0x06cf:
        r12.f309L = r5;
        goto L_0x06d4;
    L_0x06d2:
        r47 = r5;
    L_0x06d4:
        r8 = r8 + 1;
        r5 = r47;
        goto L_0x05ea;
    L_0x06da:
        r5 = 0;
    L_0x06db:
        if (r5 >= r7) goto L_0x071f;
    L_0x06dd:
        r6 = r0.getChildAt(r5);
        r8 = r6 instanceof android.support.constraint.Placeholder;
        if (r8 == 0) goto L_0x071b;
    L_0x06e5:
        r6 = (android.support.constraint.Placeholder) r6;
        r8 = r6.f184b;
        if (r8 == 0) goto L_0x071b;
    L_0x06eb:
        r8 = r6.getLayoutParams();
        r8 = (android.support.constraint.ConstraintLayout.LayoutParams) r8;
        r6 = r6.f184b;
        r6 = r6.getLayoutParams();
        r6 = (android.support.constraint.ConstraintLayout.LayoutParams) r6;
        r9 = r6.al;
        r10 = 0;
        r9.f317U = r10;
        r9 = r8.al;
        r11 = r6.al;
        r11 = r11.m114i();
        r9.m103c(r11);
        r8 = r8.al;
        r9 = r6.al;
        r9 = r9.m115j();
        r8.m106d(r9);
        r6 = r6.al;
        r8 = 8;
        r6.f317U = r8;
        goto L_0x071c;
    L_0x071b:
        r10 = 0;
    L_0x071c:
        r5 = r5 + 1;
        goto L_0x06db;
    L_0x071f:
        r10 = 0;
        r5 = r0.f114h;
        r5 = r5.size();
        if (r5 <= 0) goto L_0x0733;
    L_0x0728:
        r6 = r10;
    L_0x0729:
        if (r6 >= r5) goto L_0x0733;
    L_0x072b:
        r7 = r0.f114h;
        r7.get(r6);
        r6 = r6 + 1;
        goto L_0x0729;
    L_0x0733:
        r5 = r50.getChildCount();
        if (r5 <= 0) goto L_0x073e;
    L_0x0739:
        r5 = r0.f108b;
        r5.mo3074x();
    L_0x073e:
        r5 = r0.f115i;
        r5 = r5.size();
        r6 = r50.getPaddingBottom();
        r4 = r4 + r6;
        r6 = r50.getPaddingRight();
        r3 = r3 + r6;
        if (r5 <= 0) goto L_0x08f4;
    L_0x0750:
        r7 = r0.f108b;
        r7 = r7.m126u();
        r8 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r7 != r8) goto L_0x075c;
    L_0x075a:
        r7 = 1;
        goto L_0x075d;
    L_0x075c:
        r7 = r10;
    L_0x075d:
        r8 = r0.f108b;
        r8 = r8.m127v();
        r9 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r8 != r9) goto L_0x0769;
    L_0x0767:
        r8 = 1;
        goto L_0x076a;
    L_0x0769:
        r8 = r10;
    L_0x076a:
        r9 = r0.f108b;
        r9 = r9.m114i();
        r11 = r0.f116j;
        r9 = java.lang.Math.max(r9, r11);
        r11 = r0.f108b;
        r11 = r11.m115j();
        r12 = r0.f117k;
        r11 = java.lang.Math.max(r11, r12);
        r12 = r9;
        r9 = r10;
        r14 = r9;
        r13 = r11;
        r11 = r14;
    L_0x0787:
        if (r9 >= r5) goto L_0x086d;
    L_0x0789:
        r15 = r0.f115i;
        r15 = r15.get(r9);
        r15 = (android.support.constraint.solver.widgets.ConstraintWidget) r15;
        r10 = r15.f316T;
        r10 = (android.view.View) r10;
        if (r10 == 0) goto L_0x085f;
    L_0x0797:
        r16 = r10.getLayoutParams();
        r6 = r16;
        r6 = (android.support.constraint.ConstraintLayout.LayoutParams) r6;
        r48 = r5;
        r5 = r6.f80Z;
        if (r5 != 0) goto L_0x0861;
    L_0x07a5:
        r5 = r6.f79Y;
        if (r5 != 0) goto L_0x0861;
    L_0x07a9:
        r5 = r10.getVisibility();
        r0 = 8;
        if (r5 == r0) goto L_0x0861;
    L_0x07b1:
        r5 = r6.width;
        r0 = -2;
        if (r5 != r0) goto L_0x07c1;
    L_0x07b6:
        r0 = r6.f76V;
        if (r0 == 0) goto L_0x07c1;
    L_0x07ba:
        r0 = r6.width;
        r0 = getChildMeasureSpec(r1, r3, r0);
        goto L_0x07cb;
    L_0x07c1:
        r0 = r15.m114i();
        r5 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r5);
    L_0x07cb:
        r5 = r6.height;
        r1 = -2;
        if (r5 != r1) goto L_0x07db;
    L_0x07d0:
        r5 = r6.f77W;
        if (r5 == 0) goto L_0x07db;
    L_0x07d4:
        r5 = r6.height;
        r5 = getChildMeasureSpec(r2, r4, r5);
        goto L_0x07e5;
    L_0x07db:
        r5 = r15.m115j();
        r1 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r5 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r1);
    L_0x07e5:
        r10.measure(r0, r5);
        r0 = r10.getMeasuredWidth();
        r1 = r10.getMeasuredHeight();
        r5 = r15.m114i();
        if (r0 == r5) goto L_0x0816;
    L_0x07f6:
        r15.m103c(r0);
        if (r7 == 0) goto L_0x0815;
    L_0x07fb:
        r0 = r15.m120o();
        if (r0 <= r12) goto L_0x0815;
    L_0x0801:
        r0 = r15.m120o();
        r5 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.f273d;
        r5 = r15.mo14a(r5);
        r5 = r5.m85b();
        r0 = r0 + r5;
        r0 = java.lang.Math.max(r12, r0);
        r12 = r0;
    L_0x0815:
        r11 = 1;
    L_0x0816:
        r0 = r15.m115j();
        if (r1 == r0) goto L_0x083c;
    L_0x081c:
        r15.m106d(r1);
        if (r8 == 0) goto L_0x083b;
    L_0x0821:
        r0 = r15.m121p();
        if (r0 <= r13) goto L_0x083b;
    L_0x0827:
        r0 = r15.m121p();
        r1 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.f274e;
        r1 = r15.mo14a(r1);
        r1 = r1.m85b();
        r0 = r0 + r1;
        r0 = java.lang.Math.max(r13, r0);
        r13 = r0;
    L_0x083b:
        r11 = 1;
    L_0x083c:
        r0 = r6.f78X;
        if (r0 == 0) goto L_0x084f;
    L_0x0840:
        r0 = r10.getBaseline();
        r1 = -1;
        if (r0 == r1) goto L_0x0850;
    L_0x0847:
        r5 = r15.f309L;
        if (r0 == r5) goto L_0x0850;
    L_0x084b:
        r15.f309L = r0;
        r11 = 1;
        goto L_0x0850;
    L_0x084f:
        r1 = -1;
    L_0x0850:
        r0 = android.os.Build.VERSION.SDK_INT;
        r5 = 11;
        if (r0 < r5) goto L_0x0862;
    L_0x0856:
        r0 = r10.getMeasuredState();
        r14 = combineMeasuredStates(r14, r0);
        goto L_0x0862;
    L_0x085f:
        r48 = r5;
    L_0x0861:
        r1 = -1;
    L_0x0862:
        r9 = r9 + 1;
        r5 = r48;
        r0 = r50;
        r1 = r51;
        r10 = 0;
        goto L_0x0787;
    L_0x086d:
        r48 = r5;
        if (r11 == 0) goto L_0x08b0;
    L_0x0871:
        r0 = r50;
        r1 = r0.f108b;
        r5 = r37;
        r1.m103c(r5);
        r1 = r0.f108b;
        r5 = r36;
        r1.m106d(r5);
        r1 = r0.f108b;
        r1.mo3074x();
        r1 = r0.f108b;
        r1 = r1.m114i();
        if (r1 >= r12) goto L_0x0895;
    L_0x088e:
        r1 = r0.f108b;
        r1.m103c(r12);
        r8 = 1;
        goto L_0x0896;
    L_0x0895:
        r8 = 0;
    L_0x0896:
        r1 = r0.f108b;
        r1 = r1.m115j();
        if (r1 >= r13) goto L_0x08a6;
    L_0x089e:
        r1 = r0.f108b;
        r1.m106d(r13);
        r45 = 1;
        goto L_0x08a8;
    L_0x08a6:
        r45 = r8;
    L_0x08a8:
        if (r45 == 0) goto L_0x08b2;
    L_0x08aa:
        r1 = r0.f108b;
        r1.mo3074x();
        goto L_0x08b2;
    L_0x08b0:
        r0 = r50;
    L_0x08b2:
        r1 = r48;
        r5 = 0;
    L_0x08b5:
        if (r5 >= r1) goto L_0x08f5;
    L_0x08b7:
        r6 = r0.f115i;
        r6 = r6.get(r5);
        r6 = (android.support.constraint.solver.widgets.ConstraintWidget) r6;
        r7 = r6.f316T;
        r7 = (android.view.View) r7;
        if (r7 == 0) goto L_0x08ef;
    L_0x08c5:
        r8 = r7.getWidth();
        r9 = r6.m114i();
        if (r8 != r9) goto L_0x08d9;
    L_0x08cf:
        r8 = r7.getHeight();
        r9 = r6.m115j();
        if (r8 == r9) goto L_0x08ef;
    L_0x08d9:
        r8 = r6.m114i();
        r9 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r8 = android.view.View.MeasureSpec.makeMeasureSpec(r8, r9);
        r6 = r6.m115j();
        r6 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r9);
        r7.measure(r8, r6);
        goto L_0x08f1;
    L_0x08ef:
        r9 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
    L_0x08f1:
        r5 = r5 + 1;
        goto L_0x08b5;
    L_0x08f4:
        r14 = 0;
    L_0x08f5:
        r1 = r0.f108b;
        r1 = r1.m114i();
        r1 = r1 + r3;
        r3 = r0.f108b;
        r3 = r3.m115j();
        r3 = r3 + r4;
        r4 = android.os.Build.VERSION.SDK_INT;
        r5 = 11;
        if (r4 < r5) goto L_0x093e;
    L_0x0909:
        r4 = r51;
        r1 = resolveSizeAndState(r1, r4, r14);
        r4 = r14 << 16;
        r2 = resolveSizeAndState(r3, r2, r4);
        r3 = 16777215; // 0xffffff float:2.3509886E-38 double:8.2890456E-317;
        r1 = r1 & r3;
        r2 = r2 & r3;
        r3 = r0.f118l;
        r1 = java.lang.Math.min(r3, r1);
        r3 = r0.f119m;
        r2 = java.lang.Math.min(r3, r2);
        r3 = r0.f108b;
        r3 = r3.ar;
        r4 = 16777216; // 0x1000000 float:2.3509887E-38 double:8.289046E-317;
        if (r3 == 0) goto L_0x092f;
    L_0x092e:
        r1 = r1 | r4;
    L_0x092f:
        r3 = r0.f108b;
        r3 = r3.as;
        if (r3 == 0) goto L_0x0936;
    L_0x0935:
        r2 = r2 | r4;
    L_0x0936:
        r0.setMeasuredDimension(r1, r2);
        r0.f125s = r1;
        r0.f126t = r2;
        return;
    L_0x093e:
        r0.setMeasuredDimension(r1, r3);
        r0.f125s = r1;
        r0.f126t = r3;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.ConstraintLayout.onMeasure(int, int):void");
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        z = getChildCount();
        i = isInEditMode();
        boolean z2 = false;
        for (boolean z3 = false; z3 < z; z3++) {
            i4 = getChildAt(z3);
            LayoutParams layoutParams = (LayoutParams) i4.getLayoutParams();
            ConstraintWidget constraintWidget = layoutParams.al;
            if ((i4.getVisibility() != 8 || layoutParams.f79Y || layoutParams.f80Z || i != 0) && !layoutParams.aa) {
                int k = constraintWidget.m116k();
                int l = constraintWidget.m117l();
                int i5 = constraintWidget.m114i() + k;
                int j = constraintWidget.m115j() + l;
                i4.layout(k, l, i5, j);
                if (i4 instanceof Placeholder) {
                    i4 = ((Placeholder) i4).getContent();
                    if (i4 != 0) {
                        i4.setVisibility(0);
                        i4.layout(k, l, i5, j);
                    }
                }
            }
        }
        z = this.f114h.size();
        if (z <= false) {
            while (z2 < z) {
                this.f114h.get(z2);
                z2++;
            }
        }
    }

    public void setOptimizationLevel(int i) {
        this.f108b.aq = i;
    }

    public int getOptimizationLevel() {
        return this.f108b.aq;
    }

    protected static LayoutParams m25a() {
        return new LayoutParams();
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void setConstraintSet(ConstraintSet constraintSet) {
        this.f122p = constraintSet;
    }

    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            int childCount = getChildCount();
            float width = (float) getWidth();
            float height = (float) getHeight();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt.getVisibility() != 8) {
                    Object tag = childAt.getTag();
                    if (tag != null && (tag instanceof String)) {
                        String[] split = ((String) tag).split(",");
                        if (split.length == 4) {
                            int parseInt = Integer.parseInt(split[0]);
                            int parseInt2 = Integer.parseInt(split[1]);
                            parseInt = (int) ((((float) parseInt) / 1080.0f) * width);
                            parseInt2 = (int) ((((float) parseInt2) / 1920.0f) * height);
                            int parseInt3 = (int) ((((float) Integer.parseInt(split[2])) / 1080.0f) * width);
                            int parseInt4 = (int) ((((float) Integer.parseInt(split[3])) / 1920.0f) * height);
                            Paint paint = new Paint();
                            paint.setColor(-65536);
                            float f = (float) parseInt;
                            float f2 = (float) parseInt2;
                            float f3 = (float) (parseInt + parseInt3);
                            Canvas canvas2 = canvas;
                            float f4 = f2;
                            float f5 = f2;
                            f2 = f3;
                            float f6 = f;
                            Paint paint2 = paint;
                            canvas2.drawLine(f, f4, f2, f5, paint);
                            float f7 = (float) (parseInt2 + parseInt4);
                            float f8 = f3;
                            f = f7;
                            canvas2.drawLine(f8, f5, f2, f, paint);
                            f4 = f7;
                            f2 = f6;
                            canvas2.drawLine(f8, f4, f2, f, paint);
                            f8 = f6;
                            canvas2.drawLine(f8, f4, f2, f5, paint);
                            paint.setColor(-16711936);
                            f2 = f3;
                            Paint paint3 = paint;
                            canvas2.drawLine(f8, f5, f2, f7, paint);
                            canvas2.drawLine(f8, f7, f2, f5, paint);
                        }
                    }
                }
            }
        }
        ConstraintLayout constraintLayout = this;
    }

    public void requestLayout() {
        super.requestLayout();
        this.f120n = true;
        this.f125s = -1;
        this.f126t = -1;
        this.f110d = -1;
        this.f111e = -1;
        this.f112f = 0;
        this.f113g = 0;
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }
}
