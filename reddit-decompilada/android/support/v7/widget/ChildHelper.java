package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;
import java.util.List;

class ChildHelper {
    final Callback f2209a;
    final Bucket f2210b = new Bucket();
    final List<View> f2211c = new ArrayList();

    static class Bucket {
        long f2207a = 0;
        Bucket f2208b;

        final void m1885a(int r1, boolean r2) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: android.support.v7.widget.ChildHelper.Bucket.a(int, boolean):void
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:256)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: jadx.core.utils.exceptions.DecodeException: Unknown instruction: not-long
	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:568)
	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:56)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:102)
	... 6 more
*/
            /*
            // Can't load method instructions.
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ChildHelper.Bucket.a(int, boolean):void");
        }

        final void m1886b(int r1) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: android.support.v7.widget.ChildHelper.Bucket.b(int):void
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:256)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: jadx.core.utils.exceptions.DecodeException: Unknown instruction: not-long
	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:568)
	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:56)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:102)
	... 6 more
*/
            /*
            // Can't load method instructions.
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ChildHelper.Bucket.b(int):void");
        }

        final boolean m1888d(int r1) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: android.support.v7.widget.ChildHelper.Bucket.d(int):boolean
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:256)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: jadx.core.utils.exceptions.DecodeException: Unknown instruction: not-long
	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:568)
	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:56)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:102)
	... 6 more
*/
            /*
            // Can't load method instructions.
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ChildHelper.Bucket.d(int):boolean");
        }

        Bucket() {
        }

        final void m1884a(int i) {
            Bucket bucket = this;
            while (i >= 64) {
                bucket.m1883a();
                bucket = bucket.f2208b;
                i -= 64;
            }
            bucket.f2207a |= 1 << i;
        }

        private void m1883a() {
            if (this.f2208b == null) {
                this.f2208b = new Bucket();
            }
        }

        final boolean m1887c(int i) {
            Bucket bucket = this;
            while (i >= 64) {
                bucket.m1883a();
                bucket = bucket.f2208b;
                i -= 64;
            }
            return (bucket.f2207a & (1 << i)) != 0;
        }

        final int m1889e(int i) {
            if (this.f2208b == null) {
                if (i >= 64) {
                    return Long.bitCount(this.f2207a);
                }
                return Long.bitCount(this.f2207a & ((1 << i) - 1));
            } else if (i < 64) {
                return Long.bitCount(this.f2207a & ((1 << i) - 1));
            } else {
                return this.f2208b.m1889e(i - 64) + Long.bitCount(this.f2207a);
            }
        }

        public String toString() {
            if (this.f2208b == null) {
                return Long.toBinaryString(this.f2207a);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.f2208b.toString());
            stringBuilder.append("xx");
            stringBuilder.append(Long.toBinaryString(this.f2207a));
            return stringBuilder.toString();
        }
    }

    interface Callback {
        int mo679a();

        int mo680a(View view);

        void mo681a(int i);

        void mo682a(View view, int i);

        void mo683a(View view, int i, LayoutParams layoutParams);

        ViewHolder mo684b(View view);

        View mo685b(int i);

        void mo686b();

        void mo687c(int i);

        void mo688c(View view);

        void mo689d(View view);
    }

    ChildHelper(Callback callback) {
        this.f2209a = callback;
    }

    final void m1903a(View view) {
        this.f2211c.add(view);
        this.f2209a.mo688c(view);
    }

    final boolean m1908b(View view) {
        if (!this.f2211c.remove(view)) {
            return null;
        }
        this.f2209a.mo689d(view);
        return true;
    }

    final void m1905a(View view, int i, boolean z) {
        if (i < 0) {
            i = this.f2209a.mo679a();
        } else {
            i = m1902a(i);
        }
        this.f2210b.m1885a(i, z);
        if (z) {
            m1903a(view);
        }
        this.f2209a.mo682a(view, i);
    }

    final int m1902a(int i) {
        if (i < 0) {
            return -1;
        }
        int a = this.f2209a.mo679a();
        int i2 = i;
        while (i2 < a) {
            int e = i - (i2 - this.f2210b.m1889e(i2));
            if (e == 0) {
                while (this.f2210b.m1887c(i2) != 0) {
                    i2++;
                }
                return i2;
            }
            i2 += e;
        }
        return -1;
    }

    final View m1907b(int i) {
        return this.f2209a.mo685b(m1902a(i));
    }

    final void m1904a(View view, int i, LayoutParams layoutParams, boolean z) {
        if (i < 0) {
            i = this.f2209a.mo679a();
        } else {
            i = m1902a(i);
        }
        this.f2210b.m1885a(i, z);
        if (z) {
            m1903a(view);
        }
        this.f2209a.mo683a(view, i, layoutParams);
    }

    final int m1901a() {
        return this.f2209a.mo679a() - this.f2211c.size();
    }

    final int m1906b() {
        return this.f2209a.mo679a();
    }

    final View m1910c(int i) {
        return this.f2209a.mo685b(i);
    }

    final void m1911d(int i) {
        i = m1902a(i);
        this.f2210b.m1888d(i);
        this.f2209a.mo687c(i);
    }

    final int m1909c(View view) {
        view = this.f2209a.mo680a(view);
        if (view == -1 || this.f2210b.m1887c(view)) {
            return -1;
        }
        return view - this.f2210b.m1889e(view);
    }

    final boolean m1912d(View view) {
        return this.f2211c.contains(view);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f2210b.toString());
        stringBuilder.append(", hidden list:");
        stringBuilder.append(this.f2211c.size());
        return stringBuilder.toString();
    }
}
