package com.instabug.library.annotation.p016a;

import android.graphics.Path;
import com.facebook.stetho.server.http.HttpStatus;
import com.instabug.library.annotation.p016a.C0625e.C0624a;
import com.instabug.library.annotation.p016a.C0628g.C0627a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: PathRecognizer */
public class C0622c {

    /* compiled from: PathRecognizer */
    public static class C0621a {
        public C0624a f9495a;
        public int f9496b;
        public float f9497c;
    }

    public static C0621a m8049a(Path path) {
        C0621a c0621a = new C0621a();
        C0619a c0619a = new C0619a(path);
        path = c0619a.m8046a(C0624a.OVAL);
        Path path2 = c0619a.f9485a;
        List arrayList = new ArrayList();
        Path a = C0620b.m8047a();
        for (int i = 0; i < 36; i++) {
            int i2 = i * 10;
            C0628g a2 = c0619a.m8045a(C0626f.m8051a(a, i2), path2);
            a2.f9513b = i2;
            arrayList.add(a2);
        }
        C0628g c0628g = (C0628g) Collections.max(arrayList);
        if ((c0628g.f9513b < 0 || c0628g.f9513b > 20) && ((c0628g.f9513b > 360 || c0628g.f9513b < 340) && ((c0628g.f9513b < 160 || c0628g.f9513b > HttpStatus.HTTP_OK) && (c0628g.f9513b <= 180 || c0628g.m8052a() != C0627a.TOP)))) {
            if (c0628g.f9513b >= 180 || c0628g.m8052a() != C0627a.BOTTOM) {
                if (c0628g.f9513b < 180) {
                    c0628g = (C0628g) arrayList.get((c0628g.f9513b + 180) / 10);
                } else {
                    c0628g = (C0628g) arrayList.get((c0628g.f9513b - 180) / 10);
                }
                c0628g.f9515d = C0619a.m8043a(arrayList);
            }
        }
        C0628g a3 = c0619a.m8046a(C0624a.RECT);
        if (c0628g.f9514c > a3.f9514c && c0628g.f9514c > path.f9514c) {
            if (c0628g.f9517f <= 1056964608) {
                if (c0628g.f9518g <= 1056964608) {
                    if (c0628g.f9523l < 100.0f) {
                        if (Math.abs(c0628g.f9520i - c0628g.f9522k) >= 10 || Math.abs(c0628g.f9521j - c0628g.f9519h) >= 10) {
                            c0621a.f9495a = C0624a.ARROW;
                        } else {
                            c0621a.f9495a = C0624a.LINE;
                        }
                        c0621a.f9496b = c0628g.f9513b;
                    } else {
                        c0621a.f9495a = C0624a.NONE;
                    }
                }
            }
            c0621a.f9495a = C0624a.NONE;
        } else if (a3.f9514c > path.f9514c) {
            if (a3.f9517f <= 1056964608) {
                if (a3.f9518g <= 1056964608) {
                    c0621a.f9495a = C0624a.RECT;
                    c0621a.f9496b = a3.f9513b;
                    c0621a.f9497c = a3.f9516e;
                }
            }
            c0621a.f9495a = C0624a.NONE;
        } else {
            if (path.f9517f <= 0.5f) {
                if (path.f9518g <= 0.5f) {
                    c0621a.f9495a = C0624a.OVAL;
                    c0621a.f9496b = path.f9513b;
                    c0621a.f9497c = path.f9516e;
                }
            }
            c0621a.f9495a = C0624a.NONE;
        }
        return c0621a;
    }
}
