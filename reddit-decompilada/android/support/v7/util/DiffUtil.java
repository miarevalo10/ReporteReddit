package android.support.v7.util;

import android.support.v7.widget.RecyclerView.Adapter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DiffUtil {
    private static final Comparator<Snake> f1958a = new C01831();

    static class C01831 implements Comparator<Snake> {
        C01831() {
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            Snake snake = (Snake) obj;
            Snake snake2 = (Snake) obj2;
            int i = snake.f1953a - snake2.f1953a;
            return i == 0 ? snake.f1954b - snake2.f1954b : i;
        }
    }

    public static abstract class Callback {
        public abstract int mo491a();

        public abstract boolean mo492a(int i, int i2);

        public abstract int mo493b();

        public abstract boolean mo494b(int i, int i2);
    }

    public static class DiffResult {
        private final List<Snake> f1939a;
        private final int[] f1940b;
        private final int[] f1941c;
        private final Callback f1942d;
        private final int f1943e;
        private final int f1944f;
        private final boolean f1945g;

        DiffResult(Callback callback, List<Snake> list, int[] iArr, int[] iArr2, boolean z) {
            this.f1939a = list;
            this.f1940b = iArr;
            this.f1941c = iArr2;
            Arrays.fill(this.f1940b, 0);
            Arrays.fill(this.f1941c, 0);
            this.f1942d = callback;
            this.f1943e = callback.mo491a();
            this.f1944f = callback.mo493b();
            this.f1945g = z;
            callback = this.f1939a.isEmpty() != null ? null : (Snake) this.f1939a.get(0);
            if (!(callback != null && callback.f1953a == null && callback.f1954b == null)) {
                callback = new Snake();
                callback.f1953a = 0;
                callback.f1954b = 0;
                callback.f1956d = false;
                callback.f1955c = 0;
                callback.f1957e = false;
                this.f1939a.add(0, callback);
            }
            m1658a();
        }

        private void m1658a() {
            int i = this.f1943e;
            int i2 = this.f1944f;
            for (int size = this.f1939a.size() - 1; size >= 0; size--) {
                Snake snake = (Snake) this.f1939a.get(size);
                int i3 = snake.f1953a + snake.f1955c;
                int i4 = snake.f1954b + snake.f1955c;
                int i5 = 0;
                if (this.f1945g) {
                    while (i > i3) {
                        if (this.f1940b[i - 1] == 0) {
                            m1660a(i, i2, size, false);
                        }
                        i--;
                    }
                    while (i2 > i4) {
                        if (this.f1941c[i2 - 1] == 0) {
                            m1660a(i, i2, size, true);
                        }
                        i2--;
                    }
                }
                while (i5 < snake.f1955c) {
                    i = snake.f1953a + i5;
                    i2 = snake.f1954b + i5;
                    i3 = this.f1942d.mo494b(i, i2) ? 1 : 2;
                    this.f1940b[i] = (i2 << 5) | i3;
                    this.f1941c[i2] = (i << 5) | i3;
                    i5++;
                }
                i = snake.f1953a;
                i2 = snake.f1954b;
            }
        }

        private boolean m1660a(int i, int i2, int i3, boolean z) {
            int i4;
            int i5;
            if (z) {
                i2--;
                i4 = i;
                i5 = i2;
            } else {
                i4 = i - 1;
                i5 = i4;
            }
            while (i3 >= 0) {
                Snake snake = (Snake) this.f1939a.get(i3);
                int i6 = snake.f1953a + snake.f1955c;
                int i7 = snake.f1954b + snake.f1955c;
                int i8 = 4;
                if (z) {
                    for (i4--; i4 >= i6; i4--) {
                        if (this.f1942d.mo492a(i4, i5) != 0) {
                            if (this.f1942d.mo494b(i4, i5) != 0) {
                                i8 = 8;
                            }
                            this.f1941c[i5] = (i4 << 5) | 16;
                            this.f1940b[i4] = (i5 << 5) | i8;
                            return true;
                        }
                    }
                    continue;
                } else {
                    for (i2--; i2 >= i7; i2--) {
                        if (this.f1942d.mo492a(i5, i2)) {
                            if (this.f1942d.mo494b(i5, i2) != 0) {
                                i8 = 8;
                            }
                            i--;
                            this.f1940b[i] = (i2 << 5) | 16;
                            this.f1941c[i2] = (i << 5) | i8;
                            return true;
                        }
                    }
                    continue;
                }
                i4 = snake.f1953a;
                i2 = snake.f1954b;
                i3--;
            }
            return false;
        }

        public final void m1663a(final Adapter adapter) {
            m1662a(new ListUpdateCallback(this) {
                final /* synthetic */ DiffResult f11682b;

                public final void mo505a(int i, int i2) {
                    adapter.m2025c(i, i2);
                }

                public final void mo507b(int i, int i2) {
                    adapter.m2028d(i, i2);
                }

                public final void mo508c(int i, int i2) {
                    adapter.m2022b(i, i2);
                }

                public final void mo506a(int i, int i2, Object obj) {
                    adapter.m2015a(i, i2, obj);
                }
            });
        }

        public final void m1662a(ListUpdateCallback listUpdateCallback) {
            if (listUpdateCallback instanceof BatchingListUpdateCallback) {
                listUpdateCallback = (BatchingListUpdateCallback) listUpdateCallback;
            } else {
                listUpdateCallback = new BatchingListUpdateCallback(listUpdateCallback);
            }
            ArrayList arrayList = new ArrayList();
            int i = this.f1943e;
            int i2 = this.f1944f;
            for (int size = this.f1939a.size() - 1; size >= 0; size--) {
                Snake snake = (Snake) this.f1939a.get(size);
                int i3 = snake.f1955c;
                int i4 = snake.f1953a + i3;
                int i5 = snake.f1954b + i3;
                if (i4 < i) {
                    m1661b(arrayList, listUpdateCallback, i4, i - i4, i4);
                }
                if (i5 < i2) {
                    m1659a(arrayList, listUpdateCallback, i4, i2 - i5, i5);
                }
                for (i3--; i3 >= 0; i3--) {
                    if ((this.f1940b[snake.f1953a + i3] & 31) == 2) {
                        listUpdateCallback.mo506a(snake.f1953a + i3, 1, null);
                    }
                }
                i = snake.f1953a;
                i2 = snake.f1954b;
            }
            listUpdateCallback.m10395a();
        }

        private static PostponedUpdate m1657a(List<PostponedUpdate> list, int i, boolean z) {
            int size = list.size() - 1;
            while (size >= 0) {
                PostponedUpdate postponedUpdate = (PostponedUpdate) list.get(size);
                if (postponedUpdate.f1946a == i && postponedUpdate.f1948c == z) {
                    list.remove(size);
                    while (size < list.size()) {
                        PostponedUpdate postponedUpdate2 = (PostponedUpdate) list.get(size);
                        postponedUpdate2.f1947b += z ? 1 : -1;
                        size++;
                    }
                    return postponedUpdate;
                }
                size--;
            }
            return null;
        }

        private void m1659a(List<PostponedUpdate> list, ListUpdateCallback listUpdateCallback, int i, int i2, int i3) {
            if (this.f1945g) {
                for (i2--; i2 >= 0; i2--) {
                    int i4 = i3 + i2;
                    int i5 = this.f1941c[i4] & 31;
                    if (i5 == 0) {
                        listUpdateCallback.mo505a(i, 1);
                        for (PostponedUpdate postponedUpdate : list) {
                            postponedUpdate.f1947b++;
                        }
                    } else if (i5 == 4 || i5 == 8) {
                        listUpdateCallback.mo508c(m1657a(list, this.f1941c[i4] >> 5, true).f1947b, i);
                        if (i5 == 4) {
                            listUpdateCallback.mo506a(i, 1, null);
                        }
                    } else if (i5 != 16) {
                        listUpdateCallback = new StringBuilder("unknown flag for pos ");
                        listUpdateCallback.append(i4);
                        listUpdateCallback.append(" ");
                        listUpdateCallback.append(Long.toBinaryString((long) i5));
                        throw new IllegalStateException(listUpdateCallback.toString());
                    } else {
                        list.add(new PostponedUpdate(i4, i, false));
                    }
                }
                return;
            }
            listUpdateCallback.mo505a(i, i2);
        }

        private void m1661b(List<PostponedUpdate> list, ListUpdateCallback listUpdateCallback, int i, int i2, int i3) {
            if (this.f1945g) {
                for (i2--; i2 >= 0; i2--) {
                    int i4 = i3 + i2;
                    int i5 = this.f1940b[i4] & 31;
                    if (i5 == 0) {
                        listUpdateCallback.mo507b(i + i2, 1);
                        for (PostponedUpdate postponedUpdate : list) {
                            postponedUpdate.f1947b--;
                        }
                    } else if (i5 == 4 || i5 == 8) {
                        PostponedUpdate a = m1657a(list, this.f1940b[i4] >> 5, false);
                        listUpdateCallback.mo508c(i + i2, a.f1947b - 1);
                        if (i5 == 4) {
                            listUpdateCallback.mo506a(a.f1947b - 1, 1, null);
                        }
                    } else if (i5 != 16) {
                        listUpdateCallback = new StringBuilder("unknown flag for pos ");
                        listUpdateCallback.append(i4);
                        listUpdateCallback.append(" ");
                        listUpdateCallback.append(Long.toBinaryString((long) i5));
                        throw new IllegalStateException(listUpdateCallback.toString());
                    } else {
                        list.add(new PostponedUpdate(i4, i + i2, true));
                    }
                }
                return;
            }
            listUpdateCallback.mo507b(i, i2);
        }
    }

    private static class PostponedUpdate {
        int f1946a;
        int f1947b;
        boolean f1948c;

        public PostponedUpdate(int i, int i2, boolean z) {
            this.f1946a = i;
            this.f1947b = i2;
            this.f1948c = z;
        }
    }

    static class Range {
        int f1949a;
        int f1950b;
        int f1951c;
        int f1952d;

        public Range(int i, int i2) {
            this.f1949a = 0;
            this.f1950b = i;
            this.f1951c = 0;
            this.f1952d = i2;
        }
    }

    static class Snake {
        int f1953a;
        int f1954b;
        int f1955c;
        boolean f1956d;
        boolean f1957e;

        Snake() {
        }
    }

    public static DiffResult m1664a(Callback callback) {
        return m1665a(callback, true);
    }

    public static DiffResult m1665a(Callback callback, boolean z) {
        int a = callback.mo491a();
        int b = callback.mo493b();
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        arrayList2.add(new Range(a, b));
        a = Math.abs(a - b) + (a + b);
        b = a * 2;
        int[] iArr = new int[b];
        int[] iArr2 = new int[b];
        List arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            Range range = (Range) arrayList2.remove(arrayList2.size() - 1);
            Snake a2 = m1666a(callback, range.f1949a, range.f1950b, range.f1951c, range.f1952d, iArr, iArr2, a);
            if (a2 != null) {
                if (a2.f1955c > 0) {
                    arrayList.add(a2);
                }
                a2.f1953a += range.f1949a;
                a2.f1954b += range.f1951c;
                Range range2 = arrayList3.isEmpty() ? new Range() : (Range) arrayList3.remove(arrayList3.size() - 1);
                range2.f1949a = range.f1949a;
                range2.f1951c = range.f1951c;
                if (a2.f1957e) {
                    range2.f1950b = a2.f1953a;
                    range2.f1952d = a2.f1954b;
                } else if (a2.f1956d) {
                    range2.f1950b = a2.f1953a - 1;
                    range2.f1952d = a2.f1954b;
                } else {
                    range2.f1950b = a2.f1953a;
                    range2.f1952d = a2.f1954b - 1;
                }
                arrayList2.add(range2);
                if (!a2.f1957e) {
                    range.f1949a = a2.f1953a + a2.f1955c;
                    range.f1951c = a2.f1954b + a2.f1955c;
                } else if (a2.f1956d) {
                    range.f1949a = (a2.f1953a + a2.f1955c) + 1;
                    range.f1951c = a2.f1954b + a2.f1955c;
                } else {
                    range.f1949a = a2.f1953a + a2.f1955c;
                    range.f1951c = (a2.f1954b + a2.f1955c) + 1;
                }
                arrayList2.add(range);
            } else {
                arrayList3.add(range);
            }
        }
        Collections.sort(arrayList, f1958a);
        return new DiffResult(callback, arrayList, iArr, iArr2, z);
    }

    private static Snake m1666a(Callback callback, int i, int i2, int i3, int i4, int[] iArr, int[] iArr2, int i5) {
        Callback callback2 = callback;
        int[] iArr3 = iArr;
        int[] iArr4 = iArr2;
        int i6 = i2 - i;
        int i7 = i4 - i3;
        if (i6 > 0) {
            if (i7 > 0) {
                int i8 = i6 - i7;
                int i9 = 1;
                int i10 = ((i6 + i7) + 1) / 2;
                int i11 = (i5 - i10) - 1;
                int i12 = (i5 + i10) + 1;
                boolean z = false;
                Arrays.fill(iArr3, i11, i12, 0);
                Arrays.fill(iArr4, i11 + i8, i12 + i8, i6);
                i11 = i8 % 2 != 0 ? 1 : 0;
                i12 = 0;
                while (i12 <= i10) {
                    int i13;
                    int i14;
                    int i15;
                    Snake snake;
                    int i16 = -i12;
                    int i17 = i16;
                    while (i17 <= i12) {
                        if (i17 != i16) {
                            if (i17 != i12) {
                                int i18 = i5 + i17;
                                if (iArr3[i18 - 1] < iArr3[i18 + i9]) {
                                }
                            }
                            i9 = iArr3[(i5 + i17) - 1] + 1;
                            z = true;
                            i13 = i10;
                            i10 = i9 - i17;
                            while (i9 < i6 && i10 < i7) {
                                i14 = i6;
                                i15 = i7;
                                if (callback2.mo492a(i + i9, i3 + i10)) {
                                    break;
                                }
                                i9++;
                                i10++;
                                i6 = i14;
                                i7 = i15;
                            }
                            i14 = i6;
                            i15 = i7;
                            i6 = i5 + i17;
                            iArr3[i6] = i9;
                            if (i11 != 0 || i17 < (i8 - i12) + 1 || i17 > (i8 + i12) - 1 || iArr3[i6] < iArr4[i6]) {
                                i17 += 2;
                                z = false;
                                i10 = i13;
                                i6 = i14;
                                i7 = i15;
                                i9 = 1;
                            } else {
                                snake = new Snake();
                                snake.f1953a = iArr4[i6];
                                snake.f1954b = snake.f1953a - i17;
                                snake.f1955c = iArr3[i6] - iArr4[i6];
                                snake.f1956d = z;
                                snake.f1957e = false;
                                return snake;
                            }
                        }
                        int i19 = i9;
                        i9 = iArr3[(i5 + i17) + 1];
                        z = false;
                        i13 = i10;
                        i10 = i9 - i17;
                        while (i9 < i6) {
                            i14 = i6;
                            i15 = i7;
                            if (callback2.mo492a(i + i9, i3 + i10)) {
                                break;
                            }
                            i9++;
                            i10++;
                            i6 = i14;
                            i7 = i15;
                        }
                        i14 = i6;
                        i15 = i7;
                        i6 = i5 + i17;
                        iArr3[i6] = i9;
                        if (i11 != 0) {
                        }
                        i17 += 2;
                        z = false;
                        i10 = i13;
                        i6 = i14;
                        i7 = i15;
                        i9 = 1;
                    }
                    i14 = i6;
                    i15 = i7;
                    i13 = i10;
                    boolean z2 = z;
                    i7 = i16;
                    while (i7 <= i12) {
                        int i20;
                        i10 = i7 + i8;
                        if (i10 != i12 + i8) {
                            boolean z3;
                            if (i10 != i16 + i8) {
                                i9 = i5 + i10;
                                z3 = true;
                                if (iArr4[i9 - 1] < iArr4[i9 + 1]) {
                                }
                            } else {
                                z3 = true;
                            }
                            i9 = iArr4[(i5 + i10) + 1] - 1;
                            z = z3;
                            i17 = i9 - i10;
                            while (i9 > 0 && i17 > 0 && callback2.mo492a((i + i9) - 1, (i3 + i17) - 1)) {
                                i9--;
                                i17--;
                            }
                            i20 = i5 + i10;
                            iArr4[i20] = i9;
                            if (i11 == 0 || i10 < i16 || i10 > i12 || iArr3[i20] < iArr4[i20]) {
                                i7 += 2;
                                z2 = false;
                            } else {
                                snake = new Snake();
                                snake.f1953a = iArr4[i20];
                                snake.f1954b = snake.f1953a - i10;
                                snake.f1955c = iArr3[i20] - iArr4[i20];
                                snake.f1956d = z;
                                snake.f1957e = true;
                                return snake;
                            }
                        }
                        i9 = iArr4[(i5 + i10) - 1];
                        z = z2;
                        i17 = i9 - i10;
                        while (i9 > 0) {
                            i9--;
                            i17--;
                        }
                        i20 = i5 + i10;
                        iArr4[i20] = i9;
                        if (i11 == 0) {
                        }
                        i7 += 2;
                        z2 = false;
                    }
                    i12++;
                    i9 = 1;
                    i10 = i13;
                    i6 = i14;
                    i7 = i15;
                    z = false;
                }
                throw new IllegalStateException("DiffUtil hit an unexpected case while trying to calculate the optimal path. Please make sure your data is not changing during the diff calculation.");
            }
        }
        return null;
    }
}
