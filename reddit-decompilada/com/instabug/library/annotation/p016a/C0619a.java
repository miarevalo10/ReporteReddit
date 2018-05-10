package com.instabug.library.annotation.p016a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathMeasure;
import com.instabug.library.annotation.p016a.C0625e.C0624a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: Matcher */
public class C0619a {
    final Path f9485a;
    private int f9486b;
    private int f9487c;
    private int f9488d;
    private int f9489e;
    private int f9490f;
    private float f9491g;
    private Paint f9492h = new Paint();

    public C0619a(Path path) {
        this.f9492h.setStyle(Style.STROKE);
        this.f9492h.setStrokeWidth(2.0f);
        this.f9485a = C0626f.m8050a(path);
        m8044a(this.f9485a);
    }

    private void m8044a(Path path) {
        int i = 0;
        this.f9491g = new PathMeasure(path, false).getLength();
        Bitmap createBitmap = Bitmap.createBitmap(28, 28, Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        this.f9492h.setColor(-65536);
        canvas.drawPath(path, this.f9492h);
        int[] iArr = new int[784];
        createBitmap.getPixels(iArr, 0, 28, 0, 0, 28, 28);
        while (i < 784) {
            if (iArr[i] == -65536) {
                this.f9486b++;
                if (i < 392) {
                    this.f9488d++;
                } else {
                    this.f9490f++;
                }
                if (i % 28 < 14) {
                    this.f9487c++;
                } else {
                    this.f9489e++;
                }
            }
            i++;
        }
    }

    final C0628g m8045a(Path path, Path path2) {
        Bitmap createBitmap = Bitmap.createBitmap(28, 28, Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        this.f9492h.setColor(-16777216);
        canvas.drawPath(path, this.f9492h);
        int[] iArr = new int[784];
        createBitmap.getPixels(iArr, 0, 28, 0, 0, 28, 28);
        int i = 0;
        int i2 = 0;
        int i3 = i2;
        while (i2 < 784) {
            if (iArr[i2] == -16777216) {
                i3++;
            }
            i2++;
        }
        r0.f9492h.setColor(-2130706433);
        canvas.drawPath(path2, r0.f9492h);
        int[] iArr2 = new int[784];
        createBitmap.getPixels(iArr2, 0, createBitmap.getWidth(), 0, 0, 28, 28);
        C0628g c0628g = new C0628g();
        float f = 0.0f;
        float f2 = f;
        i2 = 0;
        while (i < 784) {
            int i4 = iArr2[i];
            if (i4 == -8355712) {
                i2++;
            } else if (i4 == -2130706433) {
                f += 1.0f;
            } else if (i4 == -16777216) {
                f2 += 1.0f;
            }
            i++;
        }
        c0628g.f9512a = i2;
        c0628g.f9517f = f / ((float) r0.f9486b);
        float f3 = (float) i3;
        c0628g.f9518g = f2 / f3;
        c0628g.f9514c = ((((1.0f - c0628g.f9518g) + 1.0f) - c0628g.f9517f) + (((float) i2) / f3)) / 3.0f;
        c0628g.f9519h = r0.f9487c;
        c0628g.f9520i = r0.f9488d;
        c0628g.f9521j = r0.f9489e;
        c0628g.f9522k = r0.f9490f;
        c0628g.f9523l = r0.f9491g;
        return c0628g;
    }

    static float m8043a(List<C0628g> list) {
        float f = 0.0f;
        for (C0628g c0628g : list) {
            f += c0628g.f9514c;
        }
        return f / ((float) list.size());
    }

    public final C0628g m8046a(C0624a c0624a) {
        List arrayList = new ArrayList();
        for (C0623d c0623d : C0620b.m8048a(c0624a)) {
            for (int i = 0; i < 18; i++) {
                int i2 = i * 10;
                C0628g a = m8045a(C0626f.m8051a(c0623d.f9498a, i2), this.f9485a);
                a.f9513b = i2;
                a.f9516e = c0623d.f9499b;
                arrayList.add(a);
                if (c0624a == C0624a.OVAL && c0623d.f9499b == 0.0f) {
                    break;
                }
            }
        }
        C0628g c0628g = (C0628g) Collections.max(arrayList);
        c0628g.f9515d = C0619a.m8043a(arrayList);
        return c0628g;
    }
}
