package android.support.constraint;

import android.content.Context;
import android.graphics.Canvas;
import android.support.constraint.solver.widgets.Helper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.util.Arrays;

public abstract class ConstraintHelper extends View {
    protected int[] f48a = new int[32];
    protected int f49b = 0;
    protected Context f50c;
    protected Helper f51d = null;
    protected boolean f52e = false;
    private String f53f;

    public void onDraw(Canvas canvas) {
    }

    public ConstraintHelper(Context context) {
        super(context);
        this.f50c = context;
        mo5a(null);
    }

    protected void mo5a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            attributeSet = getContext().obtainStyledAttributes(attributeSet, C0004R.styleable.ConstraintLayout_Layout);
            int indexCount = attributeSet.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = attributeSet.getIndex(i);
                if (index == C0004R.styleable.ConstraintLayout_Layout_constraint_referenced_ids) {
                    this.f53f = attributeSet.getString(index);
                    setIds(this.f53f);
                }
            }
        }
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f48a, this.f49b);
    }

    public void setReferencedIds(int[] iArr) {
        int i = 0;
        this.f49b = 0;
        while (i < iArr.length) {
            setTag(iArr[i], null);
            i++;
        }
    }

    public void setTag(int i, Object obj) {
        if (this.f49b + 1 > this.f48a.length) {
            this.f48a = Arrays.copyOf(this.f48a, this.f48a.length * 2);
        }
        this.f48a[this.f49b] = i;
        this.f49b++;
    }

    protected void onMeasure(int i, int i2) {
        if (this.f52e) {
            super.onMeasure(i, i2);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    public final void m21a() {
        if (this.f51d != null) {
            LayoutParams layoutParams = getLayoutParams();
            if (layoutParams instanceof ConstraintLayout.LayoutParams) {
                ((ConstraintLayout.LayoutParams) layoutParams).al = this.f51d;
            }
        }
    }

    private void m20a(java.lang.String r6) {
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
        r5 = this;
        if (r6 != 0) goto L_0x0003;
    L_0x0002:
        return;
    L_0x0003:
        r0 = r5.f50c;
        if (r0 != 0) goto L_0x0008;
    L_0x0007:
        return;
    L_0x0008:
        r6 = r6.trim();
        r0 = 0;
        r1 = 0;
        r2 = android.support.constraint.C0004R.id.class;	 Catch:{ Exception -> 0x0019 }
        r2 = r2.getField(r6);	 Catch:{ Exception -> 0x0019 }
        r2 = r2.getInt(r1);	 Catch:{ Exception -> 0x0019 }
        r0 = r2;
    L_0x0019:
        if (r0 != 0) goto L_0x002d;
    L_0x001b:
        r0 = r5.f50c;
        r0 = r0.getResources();
        r2 = "id";
        r3 = r5.f50c;
        r3 = r3.getPackageName();
        r0 = r0.getIdentifier(r6, r2, r3);
    L_0x002d:
        if (r0 != 0) goto L_0x006a;
    L_0x002f:
        r2 = r5.isInEditMode();
        if (r2 == 0) goto L_0x006a;
    L_0x0035:
        r2 = r5.getParent();
        r2 = r2 instanceof android.support.constraint.ConstraintLayout;
        if (r2 == 0) goto L_0x006a;
    L_0x003d:
        r2 = r5.getParent();
        r2 = (android.support.constraint.ConstraintLayout) r2;
        r3 = r6 instanceof java.lang.String;
        if (r3 == 0) goto L_0x005d;
    L_0x0047:
        r3 = r6;
        r3 = (java.lang.String) r3;
        r4 = r2.f109c;
        if (r4 == 0) goto L_0x005d;
    L_0x004e:
        r4 = r2.f109c;
        r4 = r4.containsKey(r3);
        if (r4 == 0) goto L_0x005d;
    L_0x0056:
        r2 = r2.f109c;
        r2 = r2.get(r3);
        goto L_0x005e;
    L_0x005d:
        r2 = r1;
    L_0x005e:
        if (r2 == 0) goto L_0x006a;
    L_0x0060:
        r3 = r2 instanceof java.lang.Integer;
        if (r3 == 0) goto L_0x006a;
    L_0x0064:
        r2 = (java.lang.Integer) r2;
        r0 = r2.intValue();
    L_0x006a:
        if (r0 == 0) goto L_0x0070;
    L_0x006c:
        r5.setTag(r0, r1);
        return;
    L_0x0070:
        r0 = "ConstraintHelper";
        r1 = new java.lang.StringBuilder;
        r2 = "Could not find id of \"";
        r1.<init>(r2);
        r1.append(r6);
        r6 = "\"";
        r1.append(r6);
        r6 = r1.toString();
        android.util.Log.w(r0, r6);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.ConstraintHelper.a(java.lang.String):void");
    }

    private void setIds(String str) {
        if (str != null) {
            int i = 0;
            while (true) {
                int indexOf = str.indexOf(44, i);
                if (indexOf == -1) {
                    m20a(str.substring(i));
                    return;
                } else {
                    m20a(str.substring(i, indexOf));
                    i = indexOf + 1;
                }
            }
        }
    }

    public final void m22a(ConstraintLayout constraintLayout) {
        if (isInEditMode()) {
            setIds(this.f53f);
        }
        if (this.f51d != null) {
            this.f51d.m9452x();
            for (int i = 0; i < this.f49b; i++) {
                View findViewById = constraintLayout.findViewById(this.f48a[i]);
                if (findViewById != null) {
                    this.f51d.m9451a(constraintLayout.m29a(findViewById));
                }
            }
        }
    }
}
