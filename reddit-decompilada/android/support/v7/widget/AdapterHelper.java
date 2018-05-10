package android.support.v7.widget;

import android.support.v4.util.Pools.Pool;
import android.support.v4.util.Pools.SimplePool;
import android.support.v7.widget.RecyclerView.ViewHolder;
import java.util.ArrayList;
import java.util.List;

class AdapterHelper implements Callback {
    final ArrayList<UpdateOp> f11874a;
    final ArrayList<UpdateOp> f11875b;
    final Callback f11876c;
    Runnable f11877d;
    final boolean f11878e;
    final OpReorderer f11879f;
    int f11880g;
    private Pool<UpdateOp> f11881h;

    interface Callback {
        ViewHolder mo690a(int i);

        void mo691a(int i, int i2);

        void mo692a(int i, int i2, Object obj);

        void mo693a(UpdateOp updateOp);

        void mo694b(int i, int i2);

        void mo695b(UpdateOp updateOp);

        void mo696c(int i, int i2);

        void mo697d(int i, int i2);
    }

    static class UpdateOp {
        int f2122a;
        int f2123b;
        Object f2124c;
        int f2125d;

        UpdateOp(int i, int i2, int i3, Object obj) {
            this.f2122a = i;
            this.f2123b = i2;
            this.f2125d = i3;
            this.f2124c = obj;
        }

        public String toString() {
            String str;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
            stringBuilder.append("[");
            int i = this.f2122a;
            if (i == 4) {
                str = "up";
            } else if (i != 8) {
                switch (i) {
                    case 1:
                        str = "add";
                        break;
                    case 2:
                        str = "rm";
                        break;
                    default:
                        str = "??";
                        break;
                }
            } else {
                str = "mv";
            }
            stringBuilder.append(str);
            stringBuilder.append(",s:");
            stringBuilder.append(this.f2123b);
            stringBuilder.append("c:");
            stringBuilder.append(this.f2125d);
            stringBuilder.append(",p:");
            stringBuilder.append(this.f2124c);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null) {
                if (getClass() == obj.getClass()) {
                    UpdateOp updateOp = (UpdateOp) obj;
                    if (this.f2122a != updateOp.f2122a) {
                        return false;
                    }
                    if (this.f2122a == 8 && Math.abs(this.f2125d - this.f2123b) == 1 && this.f2125d == updateOp.f2123b && this.f2123b == updateOp.f2125d) {
                        return true;
                    }
                    if (this.f2125d != updateOp.f2125d || this.f2123b != updateOp.f2123b) {
                        return false;
                    }
                    if (this.f2124c != null) {
                        if (this.f2124c.equals(updateOp.f2124c) == null) {
                            return false;
                        }
                    } else if (updateOp.f2124c != null) {
                        return false;
                    }
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return (31 * ((this.f2122a * 31) + this.f2123b)) + this.f2125d;
        }
    }

    AdapterHelper(Callback callback) {
        this(callback, (byte) 0);
    }

    private AdapterHelper(Callback callback, byte b) {
        this.f11881h = new SimplePool(30);
        this.f11874a = new ArrayList();
        this.f11875b = new ArrayList();
        this.f11880g = 0;
        this.f11876c = callback;
        this.f11878e = false;
        this.f11879f = new OpReorderer(this);
    }

    final void m10565a() {
        m10558a(this.f11874a);
        m10558a(this.f11875b);
        this.f11880g = 0;
    }

    final void m10569b() {
        OpReorderer opReorderer = this.f11879f;
        List list = this.f11874a;
        while (true) {
            int a = OpReorderer.m1986a(list);
            Object obj = null;
            int i = 0;
            int i2;
            if (a != -1) {
                int i3 = a + 1;
                UpdateOp updateOp = (UpdateOp) list.get(a);
                UpdateOp updateOp2 = (UpdateOp) list.get(i3);
                i2 = updateOp2.f2122a;
                if (i2 != 4) {
                    switch (i2) {
                        case 1:
                            OpReorderer.m1987a(list, a, updateOp, i3, updateOp2);
                            break;
                        case 2:
                            int i4;
                            UpdateOp a2;
                            if (updateOp.f2123b < updateOp.f2125d) {
                                if (updateOp2.f2123b == updateOp.f2123b && updateOp2.f2125d == updateOp.f2125d - updateOp.f2123b) {
                                    i4 = 0;
                                    i = 1;
                                } else {
                                    i4 = 0;
                                }
                            } else if (updateOp2.f2123b == updateOp.f2125d + 1 && updateOp2.f2125d == updateOp.f2123b - updateOp.f2125d) {
                                i4 = 1;
                                i = i4;
                            } else {
                                i4 = 1;
                            }
                            if (updateOp.f2125d >= updateOp2.f2123b) {
                                if (updateOp.f2125d < updateOp2.f2123b + updateOp2.f2125d) {
                                    updateOp2.f2125d--;
                                    updateOp.f2122a = 2;
                                    updateOp.f2125d = 1;
                                    if (updateOp2.f2125d != 0) {
                                        break;
                                    }
                                    list.remove(i3);
                                    opReorderer.f2337a.mo576a(updateOp2);
                                    break;
                                }
                            }
                            updateOp2.f2123b--;
                            if (updateOp.f2123b <= updateOp2.f2123b) {
                                updateOp2.f2123b++;
                            } else if (updateOp.f2123b < updateOp2.f2123b + updateOp2.f2125d) {
                                a2 = opReorderer.f2337a.mo575a(2, updateOp.f2123b + 1, (updateOp2.f2123b + updateOp2.f2125d) - updateOp.f2123b, null);
                                updateOp2.f2125d = updateOp.f2123b - updateOp2.f2123b;
                            }
                            if (i == 0) {
                                if (i4 != 0) {
                                    if (a2 != null) {
                                        if (updateOp.f2123b > a2.f2123b) {
                                            updateOp.f2123b -= a2.f2125d;
                                        }
                                        if (updateOp.f2125d > a2.f2123b) {
                                            updateOp.f2125d -= a2.f2125d;
                                        }
                                    }
                                    if (updateOp.f2123b > updateOp2.f2123b) {
                                        updateOp.f2123b -= updateOp2.f2125d;
                                    }
                                    if (updateOp.f2125d > updateOp2.f2123b) {
                                        updateOp.f2125d -= updateOp2.f2125d;
                                    }
                                } else {
                                    if (a2 != null) {
                                        if (updateOp.f2123b >= a2.f2123b) {
                                            updateOp.f2123b -= a2.f2125d;
                                        }
                                        if (updateOp.f2125d >= a2.f2123b) {
                                            updateOp.f2125d -= a2.f2125d;
                                        }
                                    }
                                    if (updateOp.f2123b >= updateOp2.f2123b) {
                                        updateOp.f2123b -= updateOp2.f2125d;
                                    }
                                    if (updateOp.f2125d >= updateOp2.f2123b) {
                                        updateOp.f2125d -= updateOp2.f2125d;
                                    }
                                }
                                list.set(a, updateOp2);
                                if (updateOp.f2123b != updateOp.f2125d) {
                                    list.set(i3, updateOp);
                                } else {
                                    list.remove(i3);
                                }
                                if (a2 == null) {
                                    break;
                                }
                                list.add(a, a2);
                                break;
                            }
                            list.set(a, updateOp2);
                            list.remove(i3);
                            opReorderer.f2337a.mo576a(updateOp);
                            break;
                        default:
                            break;
                    }
                }
                Object a3;
                int i5;
                UpdateOp a4;
                if (updateOp.f2125d < updateOp2.f2123b) {
                    updateOp2.f2123b--;
                } else if (updateOp.f2125d < updateOp2.f2123b + updateOp2.f2125d) {
                    updateOp2.f2125d--;
                    a3 = opReorderer.f2337a.mo575a(4, updateOp.f2123b, 1, updateOp2.f2124c);
                    if (updateOp.f2123b <= updateOp2.f2123b) {
                        updateOp2.f2123b++;
                    } else if (updateOp.f2123b < updateOp2.f2123b + updateOp2.f2125d) {
                        i5 = (updateOp2.f2123b + updateOp2.f2125d) - updateOp.f2123b;
                        a4 = opReorderer.f2337a.mo575a(4, updateOp.f2123b + 1, i5, updateOp2.f2124c);
                        updateOp2.f2125d -= i5;
                        obj = a4;
                    }
                    list.set(i3, updateOp);
                    if (updateOp2.f2125d <= 0) {
                        list.set(a, updateOp2);
                    } else {
                        list.remove(a);
                        opReorderer.f2337a.mo576a(updateOp2);
                    }
                    if (a3 != null) {
                        list.add(a, a3);
                    }
                    if (obj != null) {
                        list.add(a, obj);
                    }
                }
                a3 = null;
                if (updateOp.f2123b <= updateOp2.f2123b) {
                    updateOp2.f2123b++;
                } else if (updateOp.f2123b < updateOp2.f2123b + updateOp2.f2125d) {
                    i5 = (updateOp2.f2123b + updateOp2.f2125d) - updateOp.f2123b;
                    a4 = opReorderer.f2337a.mo575a(4, updateOp.f2123b + 1, i5, updateOp2.f2124c);
                    updateOp2.f2125d -= i5;
                    obj = a4;
                }
                list.set(i3, updateOp);
                if (updateOp2.f2125d <= 0) {
                    list.remove(a);
                    opReorderer.f2337a.mo576a(updateOp2);
                } else {
                    list.set(a, updateOp2);
                }
                if (a3 != null) {
                    list.add(a, a3);
                }
                if (obj != null) {
                    list.add(a, obj);
                }
            } else {
                int size = this.f11874a.size();
                for (int i6 = 0; i6 < size; i6++) {
                    UpdateOp updateOp3 = (UpdateOp) this.f11874a.get(i6);
                    int i7 = updateOp3.f2122a;
                    int i8;
                    int i9;
                    int i10;
                    if (i7 == 4) {
                        i7 = updateOp3.f2123b;
                        i8 = updateOp3.f2123b + updateOp3.f2125d;
                        i9 = -1;
                        i10 = i7;
                        i7 = 0;
                        for (i2 = updateOp3.f2123b; i2 < i8; i2++) {
                            if (this.f11876c.mo690a(i2) == null) {
                                if (!m10562c(i2)) {
                                    if (i9 == 1) {
                                        m10561c(mo575a(4, i10, i7, updateOp3.f2124c));
                                        i7 = 0;
                                        i10 = i2;
                                    }
                                    i9 = 0;
                                    i7++;
                                }
                            }
                            if (i9 == 0) {
                                m10560b(mo575a(4, i10, i7, updateOp3.f2124c));
                                i7 = 0;
                                i10 = i2;
                            }
                            i9 = 1;
                            i7++;
                        }
                        if (i7 != updateOp3.f2125d) {
                            Object obj2 = updateOp3.f2124c;
                            mo576a(updateOp3);
                            updateOp3 = mo575a(4, i10, i7, obj2);
                        }
                        if (i9 == 0) {
                            m10560b(updateOp3);
                        } else {
                            m10561c(updateOp3);
                        }
                    } else if (i7 != 8) {
                        switch (i7) {
                            case 1:
                                m10561c(updateOp3);
                                break;
                            case 2:
                                i7 = updateOp3.f2123b;
                                i8 = updateOp3.f2123b + updateOp3.f2125d;
                                i2 = updateOp3.f2123b;
                                i10 = -1;
                                i9 = 0;
                                while (i2 < i8) {
                                    int i11;
                                    if (this.f11876c.mo690a(i2) == null) {
                                        if (!m10562c(i2)) {
                                            if (i10 == 1) {
                                                m10561c(mo575a(2, i7, i9, null));
                                                i10 = 1;
                                            } else {
                                                i10 = 0;
                                            }
                                            i11 = 0;
                                            if (i10 == 0) {
                                                i2 -= i9;
                                                i8 -= i9;
                                                i9 = 1;
                                            } else {
                                                i9++;
                                            }
                                            i2++;
                                            i10 = i11;
                                        }
                                    }
                                    if (i10 == 0) {
                                        m10560b(mo575a(2, i7, i9, null));
                                        i10 = 1;
                                    } else {
                                        i10 = 0;
                                    }
                                    i11 = 1;
                                    if (i10 == 0) {
                                        i9++;
                                    } else {
                                        i2 -= i9;
                                        i8 -= i9;
                                        i9 = 1;
                                    }
                                    i2++;
                                    i10 = i11;
                                }
                                if (i9 != updateOp3.f2125d) {
                                    mo576a(updateOp3);
                                    updateOp3 = mo575a(2, i7, i9, null);
                                }
                                if (i10 != 0) {
                                    m10561c(updateOp3);
                                    break;
                                } else {
                                    m10560b(updateOp3);
                                    break;
                                }
                            default:
                                break;
                        }
                    } else {
                        m10561c(updateOp3);
                    }
                    if (this.f11877d != null) {
                        this.f11877d.run();
                    }
                }
                this.f11874a.clear();
                return;
            }
        }
    }

    final void m10570c() {
        int size = this.f11875b.size();
        for (int i = 0; i < size; i++) {
            this.f11876c.mo695b((UpdateOp) this.f11875b.get(i));
        }
        m10558a(this.f11875b);
        this.f11880g = 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m10560b(android.support.v7.widget.AdapterHelper.UpdateOp r13) {
        /*
        r12 = this;
        r0 = r13.f2122a;
        r1 = 1;
        if (r0 == r1) goto L_0x008c;
    L_0x0005:
        r0 = r13.f2122a;
        r2 = 8;
        if (r0 != r2) goto L_0x000d;
    L_0x000b:
        goto L_0x008c;
    L_0x000d:
        r0 = r13.f2123b;
        r2 = r13.f2122a;
        r0 = r12.m10559b(r0, r2);
        r2 = r13.f2123b;
        r3 = r13.f2122a;
        r4 = 2;
        r5 = 4;
        r6 = 0;
        if (r3 == r4) goto L_0x0036;
    L_0x001e:
        if (r3 == r5) goto L_0x0034;
    L_0x0020:
        r0 = new java.lang.IllegalArgumentException;
        r1 = new java.lang.StringBuilder;
        r2 = "op should be remove or update.";
        r1.<init>(r2);
        r1.append(r13);
        r13 = r1.toString();
        r0.<init>(r13);
        throw r0;
    L_0x0034:
        r3 = r1;
        goto L_0x0037;
    L_0x0036:
        r3 = r6;
    L_0x0037:
        r7 = r0;
        r0 = r1;
        r8 = r2;
        r2 = r0;
    L_0x003b:
        r9 = r13.f2125d;
        if (r0 >= r9) goto L_0x0078;
    L_0x003f:
        r9 = r13.f2123b;
        r10 = r3 * r0;
        r9 = r9 + r10;
        r10 = r13.f2122a;
        r9 = r12.m10559b(r9, r10);
        r10 = r13.f2122a;
        if (r10 == r4) goto L_0x0058;
    L_0x004e:
        if (r10 == r5) goto L_0x0052;
    L_0x0050:
        r10 = r6;
        goto L_0x005b;
    L_0x0052:
        r10 = r7 + 1;
        if (r9 != r10) goto L_0x0050;
    L_0x0056:
        r10 = r1;
        goto L_0x005b;
    L_0x0058:
        if (r9 != r7) goto L_0x0050;
    L_0x005a:
        goto L_0x0056;
    L_0x005b:
        if (r10 == 0) goto L_0x0060;
    L_0x005d:
        r2 = r2 + 1;
        goto L_0x0075;
    L_0x0060:
        r10 = r13.f2122a;
        r11 = r13.f2124c;
        r7 = r12.mo575a(r10, r7, r2, r11);
        r12.m10557a(r7, r8);
        r12.mo576a(r7);
        r7 = r13.f2122a;
        if (r7 != r5) goto L_0x0073;
    L_0x0072:
        r8 = r8 + r2;
    L_0x0073:
        r2 = r1;
        r7 = r9;
    L_0x0075:
        r0 = r0 + 1;
        goto L_0x003b;
    L_0x0078:
        r0 = r13.f2124c;
        r12.mo576a(r13);
        if (r2 <= 0) goto L_0x008b;
    L_0x007f:
        r13 = r13.f2122a;
        r13 = r12.mo575a(r13, r7, r2, r0);
        r12.m10557a(r13, r8);
        r12.mo576a(r13);
    L_0x008b:
        return;
    L_0x008c:
        r13 = new java.lang.IllegalArgumentException;
        r0 = "should not dispatch add or move for pre layout";
        r13.<init>(r0);
        throw r13;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.AdapterHelper.b(android.support.v7.widget.AdapterHelper$UpdateOp):void");
    }

    private void m10557a(UpdateOp updateOp, int i) {
        this.f11876c.mo693a(updateOp);
        int i2 = updateOp.f2122a;
        if (i2 == 2) {
            this.f11876c.mo691a(i, updateOp.f2125d);
        } else if (i2 != 4) {
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        } else {
            this.f11876c.mo692a(i, updateOp.f2125d, updateOp.f2124c);
        }
    }

    private int m10559b(int i, int i2) {
        for (int size = this.f11875b.size() - 1; size >= 0; size--) {
            UpdateOp updateOp = (UpdateOp) this.f11875b.get(size);
            if (updateOp.f2122a == 8) {
                int i3;
                int i4;
                if (updateOp.f2123b < updateOp.f2125d) {
                    i3 = updateOp.f2123b;
                    i4 = updateOp.f2125d;
                } else {
                    i3 = updateOp.f2125d;
                    i4 = updateOp.f2123b;
                }
                if (i < i3 || i > r4) {
                    if (i < updateOp.f2123b) {
                        if (i2 == 1) {
                            updateOp.f2123b++;
                            updateOp.f2125d++;
                        } else if (i2 == 2) {
                            updateOp.f2123b--;
                            updateOp.f2125d--;
                        }
                    }
                } else if (i3 == updateOp.f2123b) {
                    if (i2 == 1) {
                        updateOp.f2125d++;
                    } else if (i2 == 2) {
                        updateOp.f2125d--;
                    }
                    i++;
                } else {
                    if (i2 == 1) {
                        updateOp.f2123b++;
                    } else if (i2 == 2) {
                        updateOp.f2123b--;
                    }
                    i--;
                }
            } else if (updateOp.f2123b <= i) {
                if (updateOp.f2122a == 1) {
                    i -= updateOp.f2125d;
                } else if (updateOp.f2122a == 2) {
                    i += updateOp.f2125d;
                }
            } else if (i2 == 1) {
                updateOp.f2123b++;
            } else if (i2 == 2) {
                updateOp.f2123b--;
            }
        }
        for (i2 = this.f11875b.size() - 1; i2 >= 0; i2--) {
            UpdateOp updateOp2 = (UpdateOp) this.f11875b.get(i2);
            if (updateOp2.f2122a == 8) {
                if (updateOp2.f2125d == updateOp2.f2123b || updateOp2.f2125d < 0) {
                    this.f11875b.remove(i2);
                    mo576a(updateOp2);
                }
            } else if (updateOp2.f2125d <= 0) {
                this.f11875b.remove(i2);
                mo576a(updateOp2);
            }
        }
        return i;
    }

    private boolean m10562c(int i) {
        int size = this.f11875b.size();
        for (int i2 = 0; i2 < size; i2++) {
            UpdateOp updateOp = (UpdateOp) this.f11875b.get(i2);
            if (updateOp.f2122a == 8) {
                if (m10563a(updateOp.f2125d, i2 + 1) == i) {
                    return true;
                }
            } else if (updateOp.f2122a == 1) {
                int i3 = updateOp.f2123b + updateOp.f2125d;
                for (int i4 = updateOp.f2123b; i4 < i3; i4++) {
                    if (m10563a(i4, i2 + 1) == i) {
                        return true;
                    }
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    private void m10561c(UpdateOp updateOp) {
        this.f11875b.add(updateOp);
        int i = updateOp.f2122a;
        if (i == 4) {
            this.f11876c.mo692a(updateOp.f2123b, updateOp.f2125d, updateOp.f2124c);
        } else if (i != 8) {
            switch (i) {
                case 1:
                    this.f11876c.mo696c(updateOp.f2123b, updateOp.f2125d);
                    return;
                case 2:
                    this.f11876c.mo694b(updateOp.f2123b, updateOp.f2125d);
                    return;
                default:
                    StringBuilder stringBuilder = new StringBuilder("Unknown update op type for ");
                    stringBuilder.append(updateOp);
                    throw new IllegalArgumentException(stringBuilder.toString());
            }
        } else {
            this.f11876c.mo697d(updateOp.f2123b, updateOp.f2125d);
        }
    }

    final boolean m10571d() {
        return this.f11874a.size() > 0;
    }

    final boolean m10567a(int i) {
        return (i & this.f11880g) != 0;
    }

    final int m10568b(int i) {
        return m10563a(i, 0);
    }

    final int m10563a(int i, int i2) {
        int size = this.f11875b.size();
        while (i2 < size) {
            UpdateOp updateOp = (UpdateOp) this.f11875b.get(i2);
            if (updateOp.f2122a == 8) {
                if (updateOp.f2123b == i) {
                    i = updateOp.f2125d;
                } else {
                    if (updateOp.f2123b < i) {
                        i--;
                    }
                    if (updateOp.f2125d <= i) {
                        i++;
                    }
                }
            } else if (updateOp.f2123b > i) {
                continue;
            } else if (updateOp.f2122a == 2) {
                if (i < updateOp.f2123b + updateOp.f2125d) {
                    return -1;
                }
                i -= updateOp.f2125d;
            } else if (updateOp.f2122a == 1) {
                i += updateOp.f2125d;
            }
            i2++;
        }
        return i;
    }

    final void m10572e() {
        m10570c();
        int size = this.f11874a.size();
        for (int i = 0; i < size; i++) {
            UpdateOp updateOp = (UpdateOp) this.f11874a.get(i);
            int i2 = updateOp.f2122a;
            if (i2 == 4) {
                this.f11876c.mo695b(updateOp);
                this.f11876c.mo692a(updateOp.f2123b, updateOp.f2125d, updateOp.f2124c);
            } else if (i2 != 8) {
                switch (i2) {
                    case 1:
                        this.f11876c.mo695b(updateOp);
                        this.f11876c.mo696c(updateOp.f2123b, updateOp.f2125d);
                        break;
                    case 2:
                        this.f11876c.mo695b(updateOp);
                        this.f11876c.mo691a(updateOp.f2123b, updateOp.f2125d);
                        break;
                    default:
                        break;
                }
            } else {
                this.f11876c.mo695b(updateOp);
                this.f11876c.mo697d(updateOp.f2123b, updateOp.f2125d);
            }
            if (this.f11877d != null) {
                this.f11877d.run();
            }
        }
        m10558a(this.f11874a);
        this.f11880g = 0;
    }

    public final UpdateOp mo575a(int i, int i2, int i3, Object obj) {
        UpdateOp updateOp = (UpdateOp) this.f11881h.mo362a();
        if (updateOp == null) {
            return new UpdateOp(i, i2, i3, obj);
        }
        updateOp.f2122a = i;
        updateOp.f2123b = i2;
        updateOp.f2125d = i3;
        updateOp.f2124c = obj;
        return updateOp;
    }

    public final void mo576a(UpdateOp updateOp) {
        if (!this.f11878e) {
            updateOp.f2124c = null;
            this.f11881h.mo363a(updateOp);
        }
    }

    private void m10558a(List<UpdateOp> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            mo576a((UpdateOp) list.get(i));
        }
        list.clear();
    }
}
