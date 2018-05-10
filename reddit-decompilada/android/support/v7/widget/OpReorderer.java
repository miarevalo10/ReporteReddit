package android.support.v7.widget;

import java.util.List;

class OpReorderer {
    final Callback f2337a;

    interface Callback {
        UpdateOp mo575a(int i, int i2, int i3, Object obj);

        void mo576a(UpdateOp updateOp);
    }

    OpReorderer(Callback callback) {
        this.f2337a = callback;
    }

    static void m1987a(List<UpdateOp> list, int i, UpdateOp updateOp, int i2, UpdateOp updateOp2) {
        int i3 = updateOp.f2125d < updateOp2.f2123b ? -1 : 0;
        if (updateOp.f2123b < updateOp2.f2123b) {
            i3++;
        }
        if (updateOp2.f2123b <= updateOp.f2123b) {
            updateOp.f2123b += updateOp2.f2125d;
        }
        if (updateOp2.f2123b <= updateOp.f2125d) {
            updateOp.f2125d += updateOp2.f2125d;
        }
        updateOp2.f2123b += i3;
        list.set(i, updateOp2);
        list.set(i2, updateOp);
    }

    static int m1986a(List<UpdateOp> list) {
        int i = 0;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (((UpdateOp) list.get(size)).f2122a != 8) {
                i = 1;
            } else if (i != 0) {
                return size;
            }
        }
        return -1;
    }
}
