package android.support.v7.widget;

import android.support.v4.util.ArrayMap;
import android.support.v4.util.LongSparseArray;
import android.support.v4.util.Pools.Pool;
import android.support.v4.util.Pools.SimplePool;
import android.support.v7.widget.RecyclerView.ItemAnimator.ItemHolderInfo;
import android.support.v7.widget.RecyclerView.ViewHolder;

class ViewInfoStore {
    final ArrayMap<ViewHolder, InfoRecord> f2674a = new ArrayMap();
    final LongSparseArray<ViewHolder> f2675b = new LongSparseArray();

    static class InfoRecord {
        static Pool<InfoRecord> f2670d = new SimplePool(20);
        int f2671a;
        ItemHolderInfo f2672b;
        ItemHolderInfo f2673c;

        private InfoRecord() {
        }

        static InfoRecord m2371a() {
            InfoRecord infoRecord = (InfoRecord) f2670d.mo362a();
            return infoRecord == null ? new InfoRecord() : infoRecord;
        }

        static void m2372a(InfoRecord infoRecord) {
            infoRecord.f2671a = 0;
            infoRecord.f2672b = null;
            infoRecord.f2673c = null;
            f2670d.mo363a(infoRecord);
        }

        static void m2373b() {
            do {
            } while (f2670d.mo362a() != null);
        }
    }

    interface ProcessCallback {
        void mo675a(ViewHolder viewHolder);

        void mo676a(ViewHolder viewHolder, ItemHolderInfo itemHolderInfo, ItemHolderInfo itemHolderInfo2);

        void mo677b(ViewHolder viewHolder, ItemHolderInfo itemHolderInfo, ItemHolderInfo itemHolderInfo2);

        void mo678c(ViewHolder viewHolder, ItemHolderInfo itemHolderInfo, ItemHolderInfo itemHolderInfo2);
    }

    final android.support.v7.widget.RecyclerView.ItemAnimator.ItemHolderInfo m2379a(android.support.v7.widget.RecyclerView.ViewHolder r1, int r2) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: android.support.v7.widget.ViewInfoStore.a(android.support.v7.widget.RecyclerView$ViewHolder, int):android.support.v7.widget.RecyclerView$ItemAnimator$ItemHolderInfo
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: jadx.core.utils.exceptions.DecodeException: Unknown instruction: not-int
	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:568)
	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:56)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:102)
	... 5 more
*/
        /*
        // Can't load method instructions.
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ViewInfoStore.a(android.support.v7.widget.RecyclerView$ViewHolder, int):android.support.v7.widget.RecyclerView$ItemAnimator$ItemHolderInfo");
    }

    ViewInfoStore() {
    }

    final void m2380a() {
        this.f2674a.clear();
        this.f2675b.m1020c();
    }

    final void m2382a(ViewHolder viewHolder, ItemHolderInfo itemHolderInfo) {
        InfoRecord infoRecord = (InfoRecord) this.f2674a.get(viewHolder);
        if (infoRecord == null) {
            infoRecord = InfoRecord.m2371a();
            this.f2674a.put(viewHolder, infoRecord);
        }
        infoRecord.f2672b = itemHolderInfo;
        infoRecord.f2671a |= 4;
    }

    final boolean m2383a(ViewHolder viewHolder) {
        InfoRecord infoRecord = (InfoRecord) this.f2674a.get(viewHolder);
        return (infoRecord == null || (infoRecord.f2671a & 1) == null) ? null : true;
    }

    final void m2381a(long j, ViewHolder viewHolder) {
        this.f2675b.m1017a(j, viewHolder);
    }

    final void m2385b(ViewHolder viewHolder, ItemHolderInfo itemHolderInfo) {
        InfoRecord infoRecord = (InfoRecord) this.f2674a.get(viewHolder);
        if (infoRecord == null) {
            infoRecord = InfoRecord.m2371a();
            this.f2674a.put(viewHolder, infoRecord);
        }
        infoRecord.f2673c = itemHolderInfo;
        infoRecord.f2671a |= 8;
    }

    final void m2384b(ViewHolder viewHolder) {
        InfoRecord infoRecord = (InfoRecord) this.f2674a.get(viewHolder);
        if (infoRecord == null) {
            infoRecord = InfoRecord.m2371a();
            this.f2674a.put(viewHolder, infoRecord);
        }
        r0.f2671a |= 1;
    }

    final void m2386c(ViewHolder viewHolder) {
        InfoRecord infoRecord = (InfoRecord) this.f2674a.get(viewHolder);
        if (infoRecord != null) {
            infoRecord.f2671a &= -2;
        }
    }

    final void m2387d(ViewHolder viewHolder) {
        InfoRecord infoRecord;
        for (int b = this.f2675b.m1018b() - 1; b >= 0; b--) {
            if (viewHolder == this.f2675b.m1019b(b)) {
                LongSparseArray longSparseArray = this.f2675b;
                if (longSparseArray.f1393d[b] != LongSparseArray.f1390a) {
                    longSparseArray.f1393d[b] = LongSparseArray.f1390a;
                    longSparseArray.f1391b = true;
                }
                infoRecord = (InfoRecord) this.f2674a.remove(viewHolder);
                if (infoRecord != null) {
                    InfoRecord.m2372a(infoRecord);
                }
            }
        }
        infoRecord = (InfoRecord) this.f2674a.remove(viewHolder);
        if (infoRecord != null) {
            InfoRecord.m2372a(infoRecord);
        }
    }

    static void m2378b() {
        InfoRecord.m2373b();
    }
}
