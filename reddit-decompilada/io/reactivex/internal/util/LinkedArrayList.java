package io.reactivex.internal.util;

import java.util.ArrayList;
import java.util.List;

public class LinkedArrayList {
    final int f25190h;
    public Object[] f25191i;
    Object[] f25192j;
    public volatile int f25193k;
    int f25194l;

    public LinkedArrayList(int i) {
        this.f25190h = i;
    }

    public final void m26693a(Object obj) {
        if (this.f25193k == 0) {
            this.f25191i = new Object[(this.f25190h + 1)];
            this.f25192j = this.f25191i;
            this.f25191i[0] = obj;
            this.f25194l = 1;
            this.f25193k = 1;
        } else if (this.f25194l == this.f25190h) {
            Object[] objArr = new Object[(this.f25190h + 1)];
            objArr[0] = obj;
            this.f25192j[this.f25190h] = objArr;
            this.f25192j = objArr;
            this.f25194l = 1;
            this.f25193k += 1;
        } else {
            this.f25192j[this.f25194l] = obj;
            this.f25194l += 1;
            this.f25193k += 1;
        }
    }

    public String toString() {
        int i = this.f25190h;
        int i2 = this.f25193k;
        List arrayList = new ArrayList(i2 + 1);
        Object[] objArr = this.f25191i;
        int i3 = 0;
        int i4 = i3;
        while (i3 < i2) {
            arrayList.add(objArr[i4]);
            i3++;
            i4++;
            if (i4 == i) {
                objArr = (Object[]) objArr[i];
                i4 = 0;
            }
        }
        return arrayList.toString();
    }
}
