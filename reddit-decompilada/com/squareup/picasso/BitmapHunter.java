package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import com.squareup.picasso.Picasso.LoadedFrom;
import com.squareup.picasso.Picasso.Priority;
import com.squareup.picasso.RequestHandler.Result;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

class BitmapHunter implements Runnable {
    private static final Object f23730t = new Object();
    private static final ThreadLocal<StringBuilder> f23731u = new C20481();
    private static final AtomicInteger f23732v = new AtomicInteger();
    private static final RequestHandler f23733w = new C25222();
    final int f23734a = f23732v.incrementAndGet();
    final Picasso f23735b;
    final Dispatcher f23736c;
    final Cache f23737d;
    final Stats f23738e;
    final String f23739f;
    final Request f23740g;
    final int f23741h;
    int f23742i;
    final RequestHandler f23743j;
    Action f23744k;
    List<Action> f23745l;
    Bitmap f23746m;
    Future<?> f23747n;
    LoadedFrom f23748o;
    Exception f23749p;
    int f23750q;
    int f23751r;
    Priority f23752s;

    static class C20481 extends ThreadLocal<StringBuilder> {
        C20481() {
        }

        protected final /* synthetic */ Object initialValue() {
            return new StringBuilder("Picasso-");
        }
    }

    static class C25222 extends RequestHandler {
        public final boolean mo5445a(Request request) {
            return true;
        }

        C25222() {
        }

        public final Result mo5446b(Request request) throws IOException {
            StringBuilder stringBuilder = new StringBuilder("Unrecognized type of request: ");
            stringBuilder.append(request);
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    private static boolean m25746a(boolean z, int i, int i2, int i3, int i4) {
        if (z && i <= i3) {
            if (i2 <= i4) {
                return false;
            }
        }
        return true;
    }

    private BitmapHunter(Picasso picasso, Dispatcher dispatcher, Cache cache, Stats stats, Action action, RequestHandler requestHandler) {
        this.f23735b = picasso;
        this.f23736c = dispatcher;
        this.f23737d = cache;
        this.f23738e = stats;
        this.f23744k = action;
        this.f23739f = action.f23721i;
        this.f23740g = action.f23714b;
        this.f23752s = action.f23714b.priority;
        this.f23741h = action.f23717e;
        this.f23742i = action.f23718f;
        this.f23743j = requestHandler;
        this.f23751r = requestHandler.mo5456a();
    }

    public void run() {
        BitmapHunter bitmapHunter;
        Throwable e;
        Throwable th;
        try {
            String name = this.f23740g.getName();
            StringBuilder stringBuilder = (StringBuilder) f23731u.get();
            stringBuilder.ensureCapacity(name.length() + 8);
            stringBuilder.replace(8, stringBuilder.length(), name);
            Thread.currentThread().setName(stringBuilder.toString());
            if (r1.f23735b.f23840n) {
                Utils.m25825a("Hunter", "executing", Utils.m25819a(this));
            }
            r1.f23746m = m25747c();
            if (r1.f23746m == null) {
                r1.f23736c.m25761b(r1);
            } else {
                Dispatcher dispatcher = r1.f23736c;
                dispatcher.f23768i.sendMessage(dispatcher.f23768i.obtainMessage(4, r1));
            }
            Thread.currentThread().setName("Picasso-Idle");
        } catch (Exception e2) {
            bitmapHunter = r1;
            Exception exception = e2;
            if (!(exception.f23780a && exception.f23781b == 504)) {
                bitmapHunter.f23749p = exception;
            }
            bitmapHunter.f23736c.m25761b(bitmapHunter);
            Thread.currentThread().setName("Picasso-Idle");
        } catch (Exception e22) {
            r1.f23749p = e22;
            bitmapHunter.f23736c.m25758a(bitmapHunter);
            Thread.currentThread().setName("Picasso-Idle");
        } catch (Exception e222) {
            r1.f23749p = e222;
            bitmapHunter.f23736c.m25758a(bitmapHunter);
            Thread.currentThread().setName("Picasso-Idle");
        } catch (Throwable e3) {
            Throwable th2 = e3;
            Writer stringWriter = new StringWriter();
            Stats stats = r1.f23738e;
            int maxSize = stats.f23889b.maxSize();
            int size = stats.f23889b.size();
            long j = stats.f23891d;
            long j2 = stats.f23892e;
            long j3 = stats.f23893f;
            Throwable th3 = th2;
            long j4 = stats.f23894g;
            long j5 = stats.f23895h;
            long j6 = stats.f23896i;
            long j7 = stats.f23897j;
            long j8 = stats.f23898k;
            int i = stats.f23899l;
            int i2 = stats.f23900m;
            StatsSnapshot statsSnapshot = r5;
            int i3 = i;
            long j9 = j4;
            long j10 = j5;
            long j11 = j6;
            long j12 = j7;
            long j13 = j8;
            StatsSnapshot statsSnapshot2 = new StatsSnapshot(maxSize, size, j, j2, j3, j9, j10, j11, j12, j13, i3, i2, stats.f23901n, System.currentTimeMillis());
            PrintWriter printWriter = new PrintWriter(stringWriter);
            printWriter.println("===============BEGIN PICASSO STATS ===============");
            printWriter.println("Memory Cache Stats");
            printWriter.print("  Max Cache Size: ");
            StatsSnapshot statsSnapshot3 = statsSnapshot;
            printWriter.println(statsSnapshot3.f23902a);
            printWriter.print("  Cache Size: ");
            printWriter.println(statsSnapshot3.f23903b);
            printWriter.print("  Cache % Full: ");
            printWriter.println((int) Math.ceil((double) ((((float) statsSnapshot3.f23903b) / ((float) statsSnapshot3.f23902a)) * 100.0f)));
            printWriter.print("  Cache Hits: ");
            printWriter.println(statsSnapshot3.f23904c);
            printWriter.print("  Cache Misses: ");
            printWriter.println(statsSnapshot3.f23905d);
            printWriter.println("Network Stats");
            printWriter.print("  Download Count: ");
            printWriter.println(statsSnapshot3.f23912k);
            printWriter.print("  Total Download Size: ");
            printWriter.println(statsSnapshot3.f23906e);
            printWriter.print("  Average Download Size: ");
            printWriter.println(statsSnapshot3.f23909h);
            printWriter.println("Bitmap Stats");
            printWriter.print("  Total Bitmaps Decoded: ");
            printWriter.println(statsSnapshot3.f23913l);
            printWriter.print("  Total Bitmap Size: ");
            printWriter.println(statsSnapshot3.f23907f);
            printWriter.print("  Total Transformed Bitmaps: ");
            printWriter.println(statsSnapshot3.f23914m);
            printWriter.print("  Total Transformed Bitmap Size: ");
            printWriter.println(statsSnapshot3.f23908g);
            printWriter.print("  Average Bitmap Size: ");
            printWriter.println(statsSnapshot3.f23910i);
            printWriter.print("  Average Transformed Bitmap Size: ");
            printWriter.println(statsSnapshot3.f23911j);
            printWriter.println("===============END PICASSO STATS ===============");
            printWriter.flush();
            this.f23749p = new RuntimeException(stringWriter.toString(), th3);
            bitmapHunter.f23736c.m25761b(bitmapHunter);
            Thread.currentThread().setName("Picasso-Idle");
        } catch (Exception e2222) {
            r1.f23749p = e2222;
            r1.f23736c.m25761b(r1);
            Thread.currentThread().setName("Picasso-Idle");
        } catch (Throwable th4) {
            e3 = th4;
            th = e3;
            Thread.currentThread().setName("Picasso-Idle");
            throw th;
        }
    }

    private Bitmap m25747c() throws IOException {
        Bitmap bitmap;
        float markableInputStream;
        long a;
        int d;
        boolean a2;
        boolean c;
        if (MemoryPolicy.m25768a(this.f23741h)) {
            bitmap = r1.f23737d.get(r1.f23739f);
            if (bitmap != null) {
                r1.f23738e.m25802a();
                r1.f23748o = LoadedFrom.MEMORY;
                if (r1.f23735b.f23840n) {
                    Utils.m25826a("Hunter", "decoded", r1.f23740g.logId(), "from cache");
                }
                return bitmap;
            }
        }
        bitmap = null;
        r1.f23740g.networkPolicy = r1.f23751r == 0 ? NetworkPolicy.OFFLINE.f23802d : r1.f23742i;
        Result b = r1.f23743j.mo5446b(r1.f23740g);
        int i = 0;
        if (b != null) {
            r1.f23748o = b.f23881a;
            r1.f23750q = b.f23884d;
            bitmap = b.f23882b;
            if (bitmap == null) {
                InputStream inputStream = b.f23883c;
                try {
                    Bitmap decodeByteArray;
                    Request request = r1.f23740g;
                    markableInputStream = new MarkableInputStream(inputStream);
                    a = markableInputStream.m25766a(65536);
                    d = RequestHandler.m25795d(request);
                    a2 = RequestHandler.m25794a((Options) d);
                    c = Utils.m25832c((InputStream) markableInputStream);
                    markableInputStream.m25767a(a);
                    if (c) {
                        byte[] b2 = Utils.m25830b((InputStream) markableInputStream);
                        if (a2) {
                            BitmapFactory.decodeByteArray(b2, 0, b2.length, d);
                            markableInputStream = request.targetWidth;
                            a = request.targetHeight;
                            RequestHandler.m25793a(markableInputStream, a, d, request);
                        }
                        decodeByteArray = BitmapFactory.decodeByteArray(b2, 0, b2.length, d);
                    } else {
                        if (a2) {
                            BitmapFactory.decodeStream(markableInputStream, null, d);
                            a2 = request.targetWidth;
                            c = request.targetHeight;
                            RequestHandler.m25793a(a2, c, d, request);
                            markableInputStream.m25767a(a);
                        }
                        decodeByteArray = BitmapFactory.decodeStream(markableInputStream, null, d);
                        if (decodeByteArray == null) {
                            throw new IOException("Failed to decode stream.");
                        }
                    }
                    Utils.m25824a(inputStream);
                    bitmap = decodeByteArray;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    Utils.m25824a(inputStream);
                }
            }
        }
        if (bitmap != null) {
            if (r1.f23735b.f23840n) {
                markableInputStream = r1.f23740g.logId();
                Utils.m25825a("Hunter", "decoded", markableInputStream);
            }
            float f = 2.8E-45f;
            r1.f23738e.m25803a(bitmap, 2);
            if (r1.f23740g.needsTransformation() || r1.f23750q != 0) {
                synchronized (f23730t) {
                    try {
                        if (r1.f23740g.needsMatrixTransform() || r1.f23750q != 0) {
                            int i2;
                            int i3;
                            Bitmap createBitmap;
                            Request request2 = r1.f23740g;
                            a = r1.f23750q;
                            int width = bitmap.getWidth();
                            d = bitmap.getHeight();
                            a2 = request2.onlyScaleDown;
                            c = new Matrix();
                            if (request2.needsMatrixTransform()) {
                                int i4 = request2.targetWidth;
                                int i5 = request2.targetHeight;
                                float f2 = request2.rotationDegrees;
                                if (f2 != 0.0f) {
                                    if (request2.hasRotationPivot) {
                                        c.setRotate(f2, request2.rotationPivotX, request2.rotationPivotY);
                                    } else {
                                        c.setRotate(f2);
                                    }
                                }
                                float f3;
                                if (request2.centerCrop) {
                                    f3 = (float) i4;
                                    markableInputStream = (float) width;
                                    f2 = f3 / markableInputStream;
                                    i2 = (float) i5;
                                    f = (float) d;
                                    float f4 = i2 / f;
                                    if (f2 > f4) {
                                        f = (int) Math.ceil((double) (f * (f4 / f2)));
                                        i = (d - f) / 2;
                                        markableInputStream = (float) f;
                                        f4 = i2 / markableInputStream;
                                    } else {
                                        int ceil = (int) Math.ceil((double) (markableInputStream * (f2 / f4)));
                                        f2 = f3 / ((float) ceil);
                                        i = (width - ceil) / 2;
                                        i2 = d;
                                        i3 = ceil;
                                        f = f4;
                                    }
                                    if (m25746a(a2, width, d, i4, i5)) {
                                        r11.preScale(f2, f);
                                    }
                                    width = i3;
                                    i3 = 0;
                                    if (r7 != 0) {
                                        r11.preRotate((float) r7);
                                    }
                                    createBitmap = Bitmap.createBitmap(bitmap, i, i3, width, i2, r11, true);
                                    if (createBitmap != bitmap) {
                                        bitmap.recycle();
                                        bitmap = createBitmap;
                                    }
                                    if (r1.f23735b.f23840n) {
                                        Utils.m25825a("Hunter", "transformed", r1.f23740g.logId());
                                    }
                                } else if (request2.centerInside) {
                                    f = ((float) i4) / ((float) width);
                                    f3 = ((float) i5) / ((float) d);
                                    if (f >= f3) {
                                        f = f3;
                                    }
                                    if (m25746a(a2, width, d, i4, i5)) {
                                        c.preScale(f, f);
                                    }
                                } else if (!((i4 == 0 && i5 == 0) || (i4 == width && i5 == d))) {
                                    if (i4 != 0) {
                                        f = (float) i4;
                                        f3 = (float) width;
                                    } else {
                                        f = (float) i5;
                                        f3 = (float) d;
                                    }
                                    f /= f3;
                                    if (i5 != 0) {
                                        f3 = (float) i5;
                                        markableInputStream = (float) d;
                                    } else {
                                        f3 = (float) i4;
                                        markableInputStream = (float) width;
                                    }
                                    f3 /= markableInputStream;
                                    if (m25746a(a2, width, d, i4, i5)) {
                                        c.preScale(f, f3);
                                    }
                                }
                            }
                            i2 = d;
                            i = 0;
                            i3 = 0;
                            if (r7 != 0) {
                                r11.preRotate((float) r7);
                            }
                            createBitmap = Bitmap.createBitmap(bitmap, i, i3, width, i2, r11, true);
                            if (createBitmap != bitmap) {
                                bitmap.recycle();
                                bitmap = createBitmap;
                            }
                            if (r1.f23735b.f23840n) {
                                Utils.m25825a("Hunter", "transformed", r1.f23740g.logId());
                            }
                        }
                    } finally {
                        bitmap = 
/*
Method generation error in method: com.squareup.picasso.BitmapHunter.c():android.graphics.Bitmap
jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0208: MERGE  (r2_19 'bitmap' android.graphics.Bitmap) = (r0_2 float), (r4_42 'f' float) in method: com.squareup.picasso.BitmapHunter.c():android.graphics.Bitmap
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:226)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:203)
	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:100)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:50)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:297)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeSynchronizedRegion(RegionGen.java:227)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:118)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:57)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:118)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:57)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:183)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:328)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:265)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:228)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:118)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:83)
	at jadx.core.codegen.CodeGen.visit(CodeGen.java:19)
	at jadx.core.ProcessClass.process(ProcessClass.java:43)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: jadx.core.utils.exceptions.CodegenException: MERGE can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:530)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:514)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
	... 38 more

*/

                        final void m25748a(Action action) {
                            boolean z;
                            int i = 1;
                            int i2 = 0;
                            if (this.f23744k == action) {
                                this.f23744k = null;
                                z = true;
                            } else {
                                z = this.f23745l != null ? this.f23745l.remove(action) : false;
                            }
                            if (z && action.f23714b.priority == this.f23752s) {
                                Priority priority = Priority.LOW;
                                int i3 = (this.f23745l == null || this.f23745l.isEmpty()) ? 0 : 1;
                                if (this.f23744k == null) {
                                    if (i3 == 0) {
                                        i = 0;
                                    }
                                }
                                if (i != 0) {
                                    if (this.f23744k != null) {
                                        priority = this.f23744k.f23714b.priority;
                                    }
                                    if (i3 != 0) {
                                        i = this.f23745l.size();
                                        while (i2 < i) {
                                            Priority priority2 = ((Action) this.f23745l.get(i2)).f23714b.priority;
                                            if (priority2.ordinal() > priority.ordinal()) {
                                                priority = priority2;
                                            }
                                            i2++;
                                        }
                                    }
                                }
                                this.f23752s = priority;
                            }
                            if (this.f23735b.f23840n) {
                                Utils.m25826a("Hunter", "removed", action.f23714b.logId(), Utils.m25820a(this, "from "));
                            }
                        }

                        final boolean m25749a() {
                            if (this.f23744k == null && ((this.f23745l == null || this.f23745l.isEmpty()) && this.f23747n != null && this.f23747n.cancel(false))) {
                                return true;
                            }
                            return false;
                        }

                        final boolean m25750b() {
                            return this.f23747n != null && this.f23747n.isCancelled();
                        }

                        private static Bitmap m25744a(List<Transformation> list, Bitmap bitmap) {
                            int size = list.size();
                            int i = 0;
                            while (i < size) {
                                final Transformation transformation = (Transformation) list.get(i);
                                try {
                                    Bitmap a = transformation.m25806a();
                                    if (a == null) {
                                        bitmap = new StringBuilder("Transformation ");
                                        bitmap.append(transformation.m25807b());
                                        bitmap.append(" returned null after ");
                                        bitmap.append(i);
                                        bitmap.append(" previous transformation(s).\n\nTransformation list:\n");
                                        for (Transformation b : list) {
                                            bitmap.append(b.m25807b());
                                            bitmap.append('\n');
                                        }
                                        Picasso.f23827a.post(new Runnable() {
                                            public final void run() {
                                                throw new NullPointerException(bitmap.toString());
                                            }
                                        });
                                        return null;
                                    } else if (a == bitmap && bitmap.isRecycled()) {
                                        Picasso.f23827a.post(new Runnable() {
                                            public final void run() {
                                                StringBuilder stringBuilder = new StringBuilder("Transformation ");
                                                stringBuilder.append(transformation.m25807b());
                                                stringBuilder.append(" returned input Bitmap but recycled it.");
                                                throw new IllegalStateException(stringBuilder.toString());
                                            }
                                        });
                                        return null;
                                    } else if (a == bitmap || bitmap.isRecycled() != null) {
                                        i++;
                                        bitmap = a;
                                    } else {
                                        Picasso.f23827a.post(new Runnable() {
                                            public final void run() {
                                                StringBuilder stringBuilder = new StringBuilder("Transformation ");
                                                stringBuilder.append(transformation.m25807b());
                                                stringBuilder.append(" mutated input Bitmap but failed to recycle the original.");
                                                throw new IllegalStateException(stringBuilder.toString());
                                            }
                                        });
                                        return null;
                                    }
                                } catch (final List<Transformation> list2) {
                                    Picasso.f23827a.post(new Runnable() {
                                        public final void run() {
                                            StringBuilder stringBuilder = new StringBuilder("Transformation ");
                                            stringBuilder.append(transformation.m25807b());
                                            stringBuilder.append(" crashed with exception.");
                                            throw new RuntimeException(stringBuilder.toString(), list2);
                                        }
                                    });
                                    return null;
                                }
                            }
                            return bitmap;
                        }

                        static BitmapHunter m25745a(Picasso picasso, Dispatcher dispatcher, Cache cache, Stats stats, Action action) {
                            Request request = action.f23714b;
                            List list = picasso.f23830d;
                            int size = list.size();
                            for (int i = 0; i < size; i++) {
                                RequestHandler requestHandler = (RequestHandler) list.get(i);
                                if (requestHandler.mo5445a(request)) {
                                    return new BitmapHunter(picasso, dispatcher, cache, stats, action, requestHandler);
                                }
                            }
                            return new BitmapHunter(picasso, dispatcher, cache, stats, action, f23733w);
                        }
                    }
