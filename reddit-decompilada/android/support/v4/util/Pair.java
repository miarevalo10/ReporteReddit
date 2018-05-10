package android.support.v4.util;

public class Pair<F, S> {
    public final F f1410a;
    public final S f1411b;

    private Pair(F f, S s) {
        this.f1410a = f;
        this.f1411b = s;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        if (!m1039b(pair.f1410a, this.f1410a) || m1039b(pair.f1411b, this.f1411b) == null) {
            return false;
        }
        return true;
    }

    private static boolean m1039b(Object obj, Object obj2) {
        if (obj != obj2) {
            if (obj == null || obj.equals(obj2) == null) {
                return null;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = this.f1410a == null ? 0 : this.f1410a.hashCode();
        if (this.f1411b != null) {
            i = this.f1411b.hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Pair{");
        stringBuilder.append(String.valueOf(this.f1410a));
        stringBuilder.append(" ");
        stringBuilder.append(String.valueOf(this.f1411b));
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public static <A, B> Pair<A, B> m1038a(A a, B b) {
        return new Pair(a, b);
    }
}
