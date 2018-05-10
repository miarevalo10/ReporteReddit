package android.support.constraint.solver;

public class SolverVariable {
    private static int f247j = 1;
    private static int f248k = 1;
    private static int f249l = 1;
    private static int f250m = 1;
    private static int f251n = 1;
    public int f252a = -1;
    int f253b = -1;
    public int f254c = 0;
    public float f255d;
    float[] f256e = new float[7];
    Type f257f;
    ArrayRow[] f258g = new ArrayRow[8];
    int f259h = 0;
    public int f260i = 0;
    private String f261o;

    public enum Type {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    static void m79a() {
        f248k++;
    }

    public SolverVariable(Type type) {
        this.f257f = type;
    }

    final void m80a(ArrayRow arrayRow) {
        int i = 0;
        for (int i2 = 0; i2 < this.f259h; i2++) {
            if (this.f258g[i2] == arrayRow) {
                while (i < (this.f259h - i2) - 1) {
                    int i3 = i2 + i;
                    this.f258g[i3] = this.f258g[i3 + 1];
                    i++;
                }
                this.f259h--;
                return;
            }
        }
    }

    public final void m81b() {
        this.f261o = null;
        this.f257f = Type.UNKNOWN;
        this.f254c = 0;
        this.f252a = -1;
        this.f253b = -1;
        this.f255d = 0.0f;
        this.f259h = 0;
        this.f260i = 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(this.f261o);
        return stringBuilder.toString();
    }
}
