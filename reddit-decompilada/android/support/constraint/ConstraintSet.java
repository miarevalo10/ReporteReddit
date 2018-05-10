package android.support.constraint;

import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.constraint.ConstraintLayout.LayoutParams;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class ConstraintSet {
    private static final int[] f179b = new int[]{0, 4, 8};
    private static SparseIntArray f180c;
    HashMap<Integer, Constraint> f181a = new HashMap();

    private static class Constraint {
        public int f127A;
        public int f128B;
        public int f129C;
        public int f130D;
        public int f131E;
        public int f132F;
        public int f133G;
        public int f134H;
        public int f135I;
        public int f136J;
        public int f137K;
        public int f138L;
        public int f139M;
        public int f140N;
        public int f141O;
        public int f142P;
        public float f143Q;
        public float f144R;
        public int f145S;
        public int f146T;
        public float f147U;
        public boolean f148V;
        public float f149W;
        public float f150X;
        public float f151Y;
        public float f152Z;
        boolean f153a;
        public float aa;
        public float ab;
        public float ac;
        public float ad;
        public float ae;
        public float af;
        public float ag;
        public boolean ah;
        public boolean ai;
        public int aj;
        public int ak;
        public int al;
        public int am;
        public int an;
        public int ao;
        public float ap;
        public float aq;
        public int ar;
        public int as;
        public int[] at;
        public int f154b;
        public int f155c;
        int f156d;
        public int f157e;
        public int f158f;
        public float f159g;
        public int f160h;
        public int f161i;
        public int f162j;
        public int f163k;
        public int f164l;
        public int f165m;
        public int f166n;
        public int f167o;
        public int f168p;
        public int f169q;
        public int f170r;
        public int f171s;
        public int f172t;
        public float f173u;
        public float f174v;
        public String f175w;
        public int f176x;
        public int f177y;
        public float f178z;

        private Constraint() {
            this.f153a = false;
            this.f157e = -1;
            this.f158f = -1;
            this.f159g = -1.0f;
            this.f160h = -1;
            this.f161i = -1;
            this.f162j = -1;
            this.f163k = -1;
            this.f164l = -1;
            this.f165m = -1;
            this.f166n = -1;
            this.f167o = -1;
            this.f168p = -1;
            this.f169q = -1;
            this.f170r = -1;
            this.f171s = -1;
            this.f172t = -1;
            this.f173u = 0.5f;
            this.f174v = 0.5f;
            this.f175w = null;
            this.f176x = -1;
            this.f177y = 0;
            this.f178z = 0.0f;
            this.f127A = -1;
            this.f128B = -1;
            this.f129C = -1;
            this.f130D = -1;
            this.f131E = -1;
            this.f132F = -1;
            this.f133G = -1;
            this.f134H = -1;
            this.f135I = -1;
            this.f136J = 0;
            this.f137K = -1;
            this.f138L = -1;
            this.f139M = -1;
            this.f140N = -1;
            this.f141O = -1;
            this.f142P = -1;
            this.f143Q = 0.0f;
            this.f144R = 0.0f;
            this.f145S = 0;
            this.f146T = 0;
            this.f147U = 1.0f;
            this.f148V = false;
            this.f149W = 0.0f;
            this.f150X = 0.0f;
            this.f151Y = 0.0f;
            this.f152Z = 0.0f;
            this.aa = 1.0f;
            this.ab = 1.0f;
            this.ac = Float.NaN;
            this.ad = Float.NaN;
            this.ae = 0.0f;
            this.af = 0.0f;
            this.ag = 0.0f;
            this.ah = false;
            this.ai = false;
            this.aj = -1;
            this.ak = -1;
            this.al = -1;
            this.am = -1;
            this.an = -1;
            this.ao = -1;
            this.ap = 1.0f;
            this.aq = 1.0f;
            this.ar = -1;
            this.as = -1;
        }

        public final void m33a(LayoutParams layoutParams) {
            layoutParams.f84d = this.f160h;
            layoutParams.f85e = this.f161i;
            layoutParams.f86f = this.f162j;
            layoutParams.f87g = this.f163k;
            layoutParams.f88h = this.f164l;
            layoutParams.f89i = this.f165m;
            layoutParams.f90j = this.f166n;
            layoutParams.f91k = this.f167o;
            layoutParams.f92l = this.f168p;
            layoutParams.f96p = this.f169q;
            layoutParams.f97q = this.f170r;
            layoutParams.f98r = this.f171s;
            layoutParams.f99s = this.f172t;
            layoutParams.leftMargin = this.f130D;
            layoutParams.rightMargin = this.f131E;
            layoutParams.topMargin = this.f132F;
            layoutParams.bottomMargin = this.f133G;
            layoutParams.f104x = this.f142P;
            layoutParams.f105y = this.f141O;
            layoutParams.f106z = this.f173u;
            layoutParams.f55A = this.f174v;
            layoutParams.f93m = this.f176x;
            layoutParams.f94n = this.f177y;
            layoutParams.f95o = this.f178z;
            layoutParams.f56B = this.f175w;
            layoutParams.f71Q = this.f127A;
            layoutParams.f72R = this.f128B;
            layoutParams.f60F = this.f143Q;
            layoutParams.f59E = this.f144R;
            layoutParams.f62H = this.f146T;
            layoutParams.f61G = this.f145S;
            layoutParams.f74T = this.ah;
            layoutParams.f75U = this.ai;
            layoutParams.f63I = this.aj;
            layoutParams.f64J = this.ak;
            layoutParams.f67M = this.al;
            layoutParams.f68N = this.am;
            layoutParams.f65K = this.an;
            layoutParams.f66L = this.ao;
            layoutParams.f69O = this.ap;
            layoutParams.f70P = this.aq;
            layoutParams.f73S = this.f129C;
            layoutParams.f83c = this.f159g;
            layoutParams.f81a = this.f157e;
            layoutParams.f82b = this.f158f;
            layoutParams.width = this.f154b;
            layoutParams.height = this.f155c;
            if (VERSION.SDK_INT >= 17) {
                layoutParams.setMarginStart(this.f135I);
                layoutParams.setMarginEnd(this.f134H);
            }
            layoutParams.m24a();
        }

        private void m30a(int i, Constraints.LayoutParams layoutParams) {
            this.f156d = i;
            this.f160h = layoutParams.f84d;
            this.f161i = layoutParams.f85e;
            this.f162j = layoutParams.f86f;
            this.f163k = layoutParams.f87g;
            this.f164l = layoutParams.f88h;
            this.f165m = layoutParams.f89i;
            this.f166n = layoutParams.f90j;
            this.f167o = layoutParams.f91k;
            this.f168p = layoutParams.f92l;
            this.f169q = layoutParams.f96p;
            this.f170r = layoutParams.f97q;
            this.f171s = layoutParams.f98r;
            this.f172t = layoutParams.f99s;
            this.f173u = layoutParams.f106z;
            this.f174v = layoutParams.f55A;
            this.f175w = layoutParams.f56B;
            this.f176x = layoutParams.f93m;
            this.f177y = layoutParams.f94n;
            this.f178z = layoutParams.f95o;
            this.f127A = layoutParams.f71Q;
            this.f128B = layoutParams.f72R;
            this.f129C = layoutParams.f73S;
            this.f159g = layoutParams.f83c;
            this.f157e = layoutParams.f81a;
            this.f158f = layoutParams.f82b;
            this.f154b = layoutParams.width;
            this.f155c = layoutParams.height;
            this.f130D = layoutParams.leftMargin;
            this.f131E = layoutParams.rightMargin;
            this.f132F = layoutParams.topMargin;
            this.f133G = layoutParams.bottomMargin;
            this.f143Q = layoutParams.f60F;
            this.f144R = layoutParams.f59E;
            this.f146T = layoutParams.f62H;
            this.f145S = layoutParams.f61G;
            this.ah = layoutParams.f74T;
            this.ai = layoutParams.f75U;
            this.aj = layoutParams.f63I;
            this.ak = layoutParams.f64J;
            this.ah = layoutParams.f74T;
            this.al = layoutParams.f67M;
            this.am = layoutParams.f68N;
            this.an = layoutParams.f65K;
            this.ao = layoutParams.f66L;
            this.ap = layoutParams.f69O;
            this.aq = layoutParams.f70P;
            if (VERSION.SDK_INT >= 17) {
                this.f134H = layoutParams.getMarginEnd();
                this.f135I = layoutParams.getMarginStart();
            }
            this.f147U = layoutParams.an;
            this.f150X = layoutParams.aq;
            this.f151Y = layoutParams.ar;
            this.f152Z = layoutParams.as;
            this.aa = layoutParams.at;
            this.ab = layoutParams.au;
            this.ac = layoutParams.av;
            this.ad = layoutParams.aw;
            this.ae = layoutParams.ax;
            this.af = layoutParams.ay;
            this.ag = layoutParams.az;
            this.f149W = layoutParams.ap;
            this.f148V = layoutParams.ao;
        }

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            Constraint constraint = new Constraint();
            constraint.f153a = this.f153a;
            constraint.f154b = this.f154b;
            constraint.f155c = this.f155c;
            constraint.f157e = this.f157e;
            constraint.f158f = this.f158f;
            constraint.f159g = this.f159g;
            constraint.f160h = this.f160h;
            constraint.f161i = this.f161i;
            constraint.f162j = this.f162j;
            constraint.f163k = this.f163k;
            constraint.f164l = this.f164l;
            constraint.f165m = this.f165m;
            constraint.f166n = this.f166n;
            constraint.f167o = this.f167o;
            constraint.f168p = this.f168p;
            constraint.f169q = this.f169q;
            constraint.f170r = this.f170r;
            constraint.f171s = this.f171s;
            constraint.f172t = this.f172t;
            constraint.f173u = this.f173u;
            constraint.f174v = this.f174v;
            constraint.f175w = this.f175w;
            constraint.f127A = this.f127A;
            constraint.f128B = this.f128B;
            constraint.f173u = this.f173u;
            constraint.f173u = this.f173u;
            constraint.f173u = this.f173u;
            constraint.f173u = this.f173u;
            constraint.f173u = this.f173u;
            constraint.f129C = this.f129C;
            constraint.f130D = this.f130D;
            constraint.f131E = this.f131E;
            constraint.f132F = this.f132F;
            constraint.f133G = this.f133G;
            constraint.f134H = this.f134H;
            constraint.f135I = this.f135I;
            constraint.f136J = this.f136J;
            constraint.f137K = this.f137K;
            constraint.f138L = this.f138L;
            constraint.f139M = this.f139M;
            constraint.f140N = this.f140N;
            constraint.f141O = this.f141O;
            constraint.f142P = this.f142P;
            constraint.f143Q = this.f143Q;
            constraint.f144R = this.f144R;
            constraint.f145S = this.f145S;
            constraint.f146T = this.f146T;
            constraint.f147U = this.f147U;
            constraint.f148V = this.f148V;
            constraint.f149W = this.f149W;
            constraint.f150X = this.f150X;
            constraint.f151Y = this.f151Y;
            constraint.f152Z = this.f152Z;
            constraint.aa = this.aa;
            constraint.ab = this.ab;
            constraint.ac = this.ac;
            constraint.ad = this.ad;
            constraint.ae = this.ae;
            constraint.af = this.af;
            constraint.ag = this.ag;
            constraint.ah = this.ah;
            constraint.ai = this.ai;
            constraint.aj = this.aj;
            constraint.ak = this.ak;
            constraint.al = this.al;
            constraint.am = this.am;
            constraint.an = this.an;
            constraint.ao = this.ao;
            constraint.ap = this.ap;
            constraint.aq = this.aq;
            constraint.ar = this.ar;
            constraint.as = this.as;
            if (this.at != null) {
                constraint.at = Arrays.copyOf(this.at, this.at.length);
            }
            constraint.f176x = this.f176x;
            constraint.f177y = this.f177y;
            constraint.f178z = this.f178z;
            return constraint;
        }

        static /* synthetic */ void m32a(Constraint constraint, ConstraintHelper constraintHelper, int i, Constraints.LayoutParams layoutParams) {
            constraint.m30a(i, layoutParams);
            if ((constraintHelper instanceof Barrier) != 0) {
                constraint.as = 1;
                Barrier barrier = (Barrier) constraintHelper;
                constraint.ar = barrier.getType();
                constraint.at = barrier.getReferencedIds();
            }
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f180c = sparseIntArray;
        sparseIntArray.append(C0004R.styleable.ConstraintSet_layout_constraintLeft_toLeftOf, 25);
        f180c.append(C0004R.styleable.ConstraintSet_layout_constraintLeft_toRightOf, 26);
        f180c.append(C0004R.styleable.ConstraintSet_layout_constraintRight_toLeftOf, 29);
        f180c.append(C0004R.styleable.ConstraintSet_layout_constraintRight_toRightOf, 30);
        f180c.append(C0004R.styleable.ConstraintSet_layout_constraintTop_toTopOf, 36);
        f180c.append(C0004R.styleable.ConstraintSet_layout_constraintTop_toBottomOf, 35);
        f180c.append(C0004R.styleable.ConstraintSet_layout_constraintBottom_toTopOf, 4);
        f180c.append(C0004R.styleable.ConstraintSet_layout_constraintBottom_toBottomOf, 3);
        f180c.append(C0004R.styleable.ConstraintSet_layout_constraintBaseline_toBaselineOf, 1);
        f180c.append(C0004R.styleable.ConstraintSet_layout_editor_absoluteX, 6);
        f180c.append(C0004R.styleable.ConstraintSet_layout_editor_absoluteY, 7);
        f180c.append(C0004R.styleable.ConstraintSet_layout_constraintGuide_begin, 17);
        f180c.append(C0004R.styleable.ConstraintSet_layout_constraintGuide_end, 18);
        f180c.append(C0004R.styleable.ConstraintSet_layout_constraintGuide_percent, 19);
        f180c.append(C0004R.styleable.ConstraintSet_android_orientation, 27);
        f180c.append(C0004R.styleable.ConstraintSet_layout_constraintStart_toEndOf, 32);
        f180c.append(C0004R.styleable.ConstraintSet_layout_constraintStart_toStartOf, 33);
        f180c.append(C0004R.styleable.ConstraintSet_layout_constraintEnd_toStartOf, 10);
        f180c.append(C0004R.styleable.ConstraintSet_layout_constraintEnd_toEndOf, 9);
        f180c.append(C0004R.styleable.ConstraintSet_layout_goneMarginLeft, 13);
        f180c.append(C0004R.styleable.ConstraintSet_layout_goneMarginTop, 16);
        f180c.append(C0004R.styleable.ConstraintSet_layout_goneMarginRight, 14);
        f180c.append(C0004R.styleable.ConstraintSet_layout_goneMarginBottom, 11);
        f180c.append(C0004R.styleable.ConstraintSet_layout_goneMarginStart, 15);
        f180c.append(C0004R.styleable.ConstraintSet_layout_goneMarginEnd, 12);
        f180c.append(C0004R.styleable.ConstraintSet_layout_constraintVertical_weight, 40);
        f180c.append(C0004R.styleable.ConstraintSet_layout_constraintHorizontal_weight, 39);
        f180c.append(C0004R.styleable.ConstraintSet_layout_constraintHorizontal_chainStyle, 41);
        f180c.append(C0004R.styleable.ConstraintSet_layout_constraintVertical_chainStyle, 42);
        f180c.append(C0004R.styleable.ConstraintSet_layout_constraintHorizontal_bias, 20);
        f180c.append(C0004R.styleable.ConstraintSet_layout_constraintVertical_bias, 37);
        f180c.append(C0004R.styleable.ConstraintSet_layout_constraintDimensionRatio, 5);
        f180c.append(C0004R.styleable.ConstraintSet_layout_constraintLeft_creator, 64);
        f180c.append(C0004R.styleable.ConstraintSet_layout_constraintTop_creator, 64);
        f180c.append(C0004R.styleable.ConstraintSet_layout_constraintRight_creator, 64);
        f180c.append(C0004R.styleable.ConstraintSet_layout_constraintBottom_creator, 64);
        f180c.append(C0004R.styleable.ConstraintSet_layout_constraintBaseline_creator, 64);
        f180c.append(C0004R.styleable.ConstraintSet_android_layout_marginLeft, 24);
        f180c.append(C0004R.styleable.ConstraintSet_android_layout_marginRight, 28);
        f180c.append(C0004R.styleable.ConstraintSet_android_layout_marginStart, 31);
        f180c.append(C0004R.styleable.ConstraintSet_android_layout_marginEnd, 8);
        f180c.append(C0004R.styleable.ConstraintSet_android_layout_marginTop, 34);
        f180c.append(C0004R.styleable.ConstraintSet_android_layout_marginBottom, 2);
        f180c.append(C0004R.styleable.ConstraintSet_android_layout_width, 23);
        f180c.append(C0004R.styleable.ConstraintSet_android_layout_height, 21);
        f180c.append(C0004R.styleable.ConstraintSet_android_visibility, 22);
        f180c.append(C0004R.styleable.ConstraintSet_android_alpha, 43);
        f180c.append(C0004R.styleable.ConstraintSet_android_elevation, 44);
        f180c.append(C0004R.styleable.ConstraintSet_android_rotationX, 45);
        f180c.append(C0004R.styleable.ConstraintSet_android_rotationY, 46);
        f180c.append(C0004R.styleable.ConstraintSet_android_rotation, 60);
        f180c.append(C0004R.styleable.ConstraintSet_android_scaleX, 47);
        f180c.append(C0004R.styleable.ConstraintSet_android_scaleY, 48);
        f180c.append(C0004R.styleable.ConstraintSet_android_transformPivotX, 49);
        f180c.append(C0004R.styleable.ConstraintSet_android_transformPivotY, 50);
        f180c.append(C0004R.styleable.ConstraintSet_android_translationX, 51);
        f180c.append(C0004R.styleable.ConstraintSet_android_translationY, 52);
        f180c.append(C0004R.styleable.ConstraintSet_android_translationZ, 53);
        f180c.append(C0004R.styleable.ConstraintSet_layout_constraintWidth_default, 54);
        f180c.append(C0004R.styleable.ConstraintSet_layout_constraintHeight_default, 55);
        f180c.append(C0004R.styleable.ConstraintSet_layout_constraintWidth_max, 56);
        f180c.append(C0004R.styleable.ConstraintSet_layout_constraintHeight_max, 57);
        f180c.append(C0004R.styleable.ConstraintSet_layout_constraintWidth_min, 58);
        f180c.append(C0004R.styleable.ConstraintSet_layout_constraintHeight_min, 59);
        f180c.append(C0004R.styleable.ConstraintSet_layout_constraintCircle, 61);
        f180c.append(C0004R.styleable.ConstraintSet_layout_constraintCircleRadius, 62);
        f180c.append(C0004R.styleable.ConstraintSet_layout_constraintCircleAngle, 63);
        f180c.append(C0004R.styleable.ConstraintSet_android_id, 38);
    }

    final void m36a(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        HashSet hashSet = new HashSet(this.f181a.keySet());
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            int id = childAt.getId();
            if (id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (this.f181a.containsKey(Integer.valueOf(id))) {
                hashSet.remove(Integer.valueOf(id));
                Constraint constraint = (Constraint) this.f181a.get(Integer.valueOf(id));
                if (constraint.as != -1) {
                    if (constraint.as == 1) {
                        Barrier barrier = (Barrier) childAt;
                        barrier.setId(id);
                        barrier.setReferencedIds(constraint.at);
                        barrier.setType(constraint.ar);
                        constraint.m33a(ConstraintLayout.m25a());
                    }
                }
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                constraint.m33a(layoutParams);
                childAt.setLayoutParams(layoutParams);
                childAt.setVisibility(constraint.f136J);
                if (VERSION.SDK_INT >= 17) {
                    childAt.setAlpha(constraint.f147U);
                    childAt.setRotation(constraint.f150X);
                    childAt.setRotationX(constraint.f151Y);
                    childAt.setRotationY(constraint.f152Z);
                    childAt.setScaleX(constraint.aa);
                    childAt.setScaleY(constraint.ab);
                    if (!Float.isNaN(constraint.ac)) {
                        childAt.setPivotX(constraint.ac);
                    }
                    if (!Float.isNaN(constraint.ad)) {
                        childAt.setPivotY(constraint.ad);
                    }
                    childAt.setTranslationX(constraint.ae);
                    childAt.setTranslationY(constraint.af);
                    if (VERSION.SDK_INT >= 21) {
                        childAt.setTranslationZ(constraint.ag);
                        if (constraint.f148V) {
                            childAt.setElevation(constraint.f149W);
                        }
                    }
                }
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            Constraint constraint2 = (Constraint) this.f181a.get(num);
            if (constraint2.as != -1) {
                if (constraint2.as == 1) {
                    childAt = new Barrier(constraintLayout.getContext());
                    childAt.setId(num.intValue());
                    childAt.setReferencedIds(constraint2.at);
                    childAt.setType(constraint2.ar);
                    ViewGroup.LayoutParams a = ConstraintLayout.m25a();
                    constraint2.m33a(a);
                    constraintLayout.addView(childAt, a);
                }
            }
            if (constraint2.f153a) {
                childAt = new Guideline(constraintLayout.getContext());
                childAt.setId(num.intValue());
                ViewGroup.LayoutParams a2 = ConstraintLayout.m25a();
                constraint2.m33a(a2);
                constraintLayout.addView(childAt, a2);
            }
        }
    }

    private static int m34a(TypedArray typedArray, int i, int i2) {
        i2 = typedArray.getResourceId(i, i2);
        return i2 == -1 ? typedArray.getInt(i, -1) : i2;
    }

    static void m35a(Constraint constraint, TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArray.getIndex(i);
            int i2 = f180c.get(index);
            switch (i2) {
                case 1:
                    constraint.f168p = m34a(typedArray, index, constraint.f168p);
                    break;
                case 2:
                    constraint.f133G = typedArray.getDimensionPixelSize(index, constraint.f133G);
                    break;
                case 3:
                    constraint.f167o = m34a(typedArray, index, constraint.f167o);
                    break;
                case 4:
                    constraint.f166n = m34a(typedArray, index, constraint.f166n);
                    break;
                case 5:
                    constraint.f175w = typedArray.getString(index);
                    break;
                case 6:
                    constraint.f127A = typedArray.getDimensionPixelOffset(index, constraint.f127A);
                    break;
                case 7:
                    constraint.f128B = typedArray.getDimensionPixelOffset(index, constraint.f128B);
                    break;
                case 8:
                    constraint.f134H = typedArray.getDimensionPixelSize(index, constraint.f134H);
                    break;
                case 9:
                    constraint.f172t = m34a(typedArray, index, constraint.f172t);
                    break;
                case 10:
                    constraint.f171s = m34a(typedArray, index, constraint.f171s);
                    break;
                case 11:
                    constraint.f140N = typedArray.getDimensionPixelSize(index, constraint.f140N);
                    break;
                case 12:
                    constraint.f141O = typedArray.getDimensionPixelSize(index, constraint.f141O);
                    break;
                case 13:
                    constraint.f137K = typedArray.getDimensionPixelSize(index, constraint.f137K);
                    break;
                case 14:
                    constraint.f139M = typedArray.getDimensionPixelSize(index, constraint.f139M);
                    break;
                case 15:
                    constraint.f142P = typedArray.getDimensionPixelSize(index, constraint.f142P);
                    break;
                case 16:
                    constraint.f138L = typedArray.getDimensionPixelSize(index, constraint.f138L);
                    break;
                case 17:
                    constraint.f157e = typedArray.getDimensionPixelOffset(index, constraint.f157e);
                    break;
                case 18:
                    constraint.f158f = typedArray.getDimensionPixelOffset(index, constraint.f158f);
                    break;
                case 19:
                    constraint.f159g = typedArray.getFloat(index, constraint.f159g);
                    break;
                case 20:
                    constraint.f173u = typedArray.getFloat(index, constraint.f173u);
                    break;
                case 21:
                    constraint.f155c = typedArray.getLayoutDimension(index, constraint.f155c);
                    break;
                case 22:
                    constraint.f136J = typedArray.getInt(index, constraint.f136J);
                    constraint.f136J = f179b[constraint.f136J];
                    break;
                case 23:
                    constraint.f154b = typedArray.getLayoutDimension(index, constraint.f154b);
                    break;
                case 24:
                    constraint.f130D = typedArray.getDimensionPixelSize(index, constraint.f130D);
                    break;
                case 25:
                    constraint.f160h = m34a(typedArray, index, constraint.f160h);
                    break;
                case 26:
                    constraint.f161i = m34a(typedArray, index, constraint.f161i);
                    break;
                case 27:
                    constraint.f129C = typedArray.getInt(index, constraint.f129C);
                    break;
                case 28:
                    constraint.f131E = typedArray.getDimensionPixelSize(index, constraint.f131E);
                    break;
                case 29:
                    constraint.f162j = m34a(typedArray, index, constraint.f162j);
                    break;
                case 30:
                    constraint.f163k = m34a(typedArray, index, constraint.f163k);
                    break;
                case 31:
                    constraint.f135I = typedArray.getDimensionPixelSize(index, constraint.f135I);
                    break;
                case 32:
                    constraint.f169q = m34a(typedArray, index, constraint.f169q);
                    break;
                case 33:
                    constraint.f170r = m34a(typedArray, index, constraint.f170r);
                    break;
                case 34:
                    constraint.f132F = typedArray.getDimensionPixelSize(index, constraint.f132F);
                    break;
                case 35:
                    constraint.f165m = m34a(typedArray, index, constraint.f165m);
                    break;
                case 36:
                    constraint.f164l = m34a(typedArray, index, constraint.f164l);
                    break;
                case 37:
                    constraint.f174v = typedArray.getFloat(index, constraint.f174v);
                    break;
                case 38:
                    constraint.f156d = typedArray.getResourceId(index, constraint.f156d);
                    break;
                case 39:
                    constraint.f144R = typedArray.getFloat(index, constraint.f144R);
                    break;
                case 40:
                    constraint.f143Q = typedArray.getFloat(index, constraint.f143Q);
                    break;
                case 41:
                    constraint.f145S = typedArray.getInt(index, constraint.f145S);
                    break;
                case 42:
                    constraint.f146T = typedArray.getInt(index, constraint.f146T);
                    break;
                case 43:
                    constraint.f147U = typedArray.getFloat(index, constraint.f147U);
                    break;
                case 44:
                    constraint.f148V = true;
                    constraint.f149W = typedArray.getDimension(index, constraint.f149W);
                    break;
                case 45:
                    constraint.f151Y = typedArray.getFloat(index, constraint.f151Y);
                    break;
                case 46:
                    constraint.f152Z = typedArray.getFloat(index, constraint.f152Z);
                    break;
                case 47:
                    constraint.aa = typedArray.getFloat(index, constraint.aa);
                    break;
                case 48:
                    constraint.ab = typedArray.getFloat(index, constraint.ab);
                    break;
                case 49:
                    constraint.ac = typedArray.getFloat(index, constraint.ac);
                    break;
                case 50:
                    constraint.ad = typedArray.getFloat(index, constraint.ad);
                    break;
                case 51:
                    constraint.ae = typedArray.getDimension(index, constraint.ae);
                    break;
                case 52:
                    constraint.af = typedArray.getDimension(index, constraint.af);
                    break;
                case 53:
                    constraint.ag = typedArray.getDimension(index, constraint.ag);
                    break;
                default:
                    StringBuilder stringBuilder;
                    switch (i2) {
                        case 60:
                            constraint.f150X = typedArray.getFloat(index, constraint.f150X);
                            break;
                        case 61:
                            constraint.f176x = m34a(typedArray, index, constraint.f176x);
                            break;
                        case 62:
                            constraint.f177y = typedArray.getDimensionPixelSize(index, constraint.f177y);
                            break;
                        case 63:
                            constraint.f178z = typedArray.getFloat(index, constraint.f178z);
                            break;
                        case 64:
                            stringBuilder = new StringBuilder("unused attribute 0x");
                            stringBuilder.append(Integer.toHexString(index));
                            stringBuilder.append("   ");
                            stringBuilder.append(f180c.get(index));
                            Log.w("ConstraintSet", stringBuilder.toString());
                            break;
                        default:
                            stringBuilder = new StringBuilder("Unknown attribute 0x");
                            stringBuilder.append(Integer.toHexString(index));
                            stringBuilder.append("   ");
                            stringBuilder.append(f180c.get(index));
                            Log.w("ConstraintSet", stringBuilder.toString());
                            break;
                    }
            }
        }
    }
}
