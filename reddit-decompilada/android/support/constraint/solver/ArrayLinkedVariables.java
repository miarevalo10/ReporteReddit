package android.support.constraint.solver;

import android.support.constraint.solver.SolverVariable.Type;
import java.util.Arrays;

public class ArrayLinkedVariables {
    int f186a = 0;
    final Cache f187b;
    int[] f188c = new int[this.f193h];
    int[] f189d = new int[this.f193h];
    float[] f190e = new float[this.f193h];
    int f191f = -1;
    private final ArrayRow f192g;
    private int f193h = 8;
    private SolverVariable f194i = null;
    private int f195j = -1;
    private boolean f196k = false;

    ArrayLinkedVariables(ArrayRow arrayRow, Cache cache) {
        this.f192g = arrayRow;
        this.f187b = cache;
    }

    public final void m43a(SolverVariable solverVariable, float f) {
        if (f == 0.0f) {
            m38a(solverVariable);
        } else if (this.f191f == -1) {
            this.f191f = 0;
            this.f190e[this.f191f] = f;
            this.f188c[this.f191f] = solverVariable.f252a;
            this.f189d[this.f191f] = -1;
            solverVariable.f260i += Float.MIN_VALUE;
            this.f186a += 1;
            if (this.f196k == null) {
                this.f195j += 1;
                if (this.f195j >= this.f188c.length) {
                    this.f196k = true;
                    this.f195j = this.f188c.length - 1;
                }
            }
        } else {
            int i = this.f191f;
            int i2 = 0;
            int i3 = -1;
            while (i != -1 && i2 < this.f186a) {
                if (this.f188c[i] == solverVariable.f252a) {
                    this.f190e[i] = f;
                    return;
                }
                if (this.f188c[i] < solverVariable.f252a) {
                    i3 = i;
                }
                i = this.f189d[i];
                i2++;
            }
            i = this.f195j + 1;
            if (this.f196k) {
                if (this.f188c[this.f195j] == -1) {
                    i = this.f195j;
                } else {
                    i = this.f188c.length;
                }
            }
            if (i >= this.f188c.length && this.f186a < this.f188c.length) {
                for (i2 = 0; i2 < this.f188c.length; i2++) {
                    if (this.f188c[i2] == -1) {
                        i = i2;
                        break;
                    }
                }
            }
            if (i >= this.f188c.length) {
                i = this.f188c.length;
                this.f193h *= 2;
                this.f196k = false;
                this.f195j = i - 1;
                this.f190e = Arrays.copyOf(this.f190e, this.f193h);
                this.f188c = Arrays.copyOf(this.f188c, this.f193h);
                this.f189d = Arrays.copyOf(this.f189d, this.f193h);
            }
            this.f188c[i] = solverVariable.f252a;
            this.f190e[i] = f;
            if (i3 != -1) {
                this.f189d[i] = this.f189d[i3];
                this.f189d[i3] = i;
            } else {
                this.f189d[i] = this.f191f;
                this.f191f = i;
            }
            solverVariable.f260i += Float.MIN_VALUE;
            this.f186a += 1;
            if (this.f196k == null) {
                this.f195j += 1;
            }
            if (this.f186a >= this.f188c.length) {
                this.f196k = true;
            }
            if (this.f195j >= this.f188c.length) {
                this.f196k = true;
                this.f195j = this.f188c.length - 1;
            }
        }
    }

    public final void m45b(SolverVariable solverVariable, float f) {
        if (f != 0.0f) {
            if (this.f191f == -1) {
                this.f191f = 0;
                this.f190e[this.f191f] = f;
                this.f188c[this.f191f] = solverVariable.f252a;
                this.f189d[this.f191f] = -1;
                solverVariable.f260i += Float.MIN_VALUE;
                this.f186a += 1;
                if (this.f196k == null) {
                    this.f195j += 1;
                    if (this.f195j >= this.f188c.length) {
                        this.f196k = true;
                        this.f195j = this.f188c.length - 1;
                    }
                }
                return;
            }
            int i = this.f191f;
            int i2 = 0;
            int i3 = -1;
            while (i != -1 && i2 < this.f186a) {
                int i4 = this.f188c[i];
                if (i4 == solverVariable.f252a) {
                    float[] fArr = this.f190e;
                    fArr[i] = fArr[i] + f;
                    if (this.f190e[i] == 0.0f) {
                        if (i == this.f191f) {
                            this.f191f = this.f189d[i];
                        } else {
                            this.f189d[i3] = this.f189d[i];
                        }
                        this.f187b.mIndexedVariables[i4].m80a(this.f192g);
                        if (this.f196k != null) {
                            this.f195j = i;
                        }
                        solverVariable.f260i -= Float.MIN_VALUE;
                        this.f186a -= 1;
                    }
                    return;
                }
                if (this.f188c[i] < solverVariable.f252a) {
                    i3 = i;
                }
                i = this.f189d[i];
                i2++;
            }
            int i5 = this.f195j + 1;
            if (this.f196k) {
                if (this.f188c[this.f195j] == -1) {
                    i5 = this.f195j;
                } else {
                    i5 = this.f188c.length;
                }
            }
            if (i5 >= this.f188c.length && this.f186a < this.f188c.length) {
                for (i = 0; i < this.f188c.length; i++) {
                    if (this.f188c[i] == -1) {
                        i5 = i;
                        break;
                    }
                }
            }
            if (i5 >= this.f188c.length) {
                i5 = this.f188c.length;
                this.f193h *= 2;
                this.f196k = false;
                this.f195j = i5 - 1;
                this.f190e = Arrays.copyOf(this.f190e, this.f193h);
                this.f188c = Arrays.copyOf(this.f188c, this.f193h);
                this.f189d = Arrays.copyOf(this.f189d, this.f193h);
            }
            this.f188c[i5] = solverVariable.f252a;
            this.f190e[i5] = f;
            if (i3 != -1) {
                this.f189d[i5] = this.f189d[i3];
                this.f189d[i3] = i5;
            } else {
                this.f189d[i5] = this.f191f;
                this.f191f = i5;
            }
            solverVariable.f260i += Float.MIN_VALUE;
            this.f186a += 1;
            if (this.f196k == null) {
                this.f195j += 1;
            }
            if (this.f195j >= this.f188c.length) {
                this.f196k = true;
                this.f195j = this.f188c.length - 1;
            }
        }
    }

    public final float m38a(SolverVariable solverVariable) {
        if (this.f194i == solverVariable) {
            this.f194i = null;
        }
        if (this.f191f == -1) {
            return 0.0f;
        }
        int i = this.f191f;
        int i2 = 0;
        int i3 = -1;
        while (i != -1 && i2 < this.f186a) {
            int i4 = this.f188c[i];
            if (i4 == solverVariable.f252a) {
                if (i == this.f191f) {
                    this.f191f = this.f189d[i];
                } else {
                    this.f189d[i3] = this.f189d[i];
                }
                this.f187b.mIndexedVariables[i4].m80a(this.f192g);
                solverVariable.f260i--;
                this.f186a--;
                this.f188c[i] = -1;
                if (this.f196k != null) {
                    this.f195j = i;
                }
                return this.f190e[i];
            }
            i2++;
            i3 = i;
            i = this.f189d[i];
        }
        return 0.0f;
    }

    public final void m41a() {
        this.f191f = -1;
        this.f195j = -1;
        this.f196k = false;
        this.f186a = 0;
    }

    static boolean m37b(SolverVariable solverVariable) {
        return solverVariable.f260i <= 1 ? true : null;
    }

    final void m42a(ArrayRow arrayRow, ArrayRow arrayRow2) {
        int i = this.f191f;
        while (true) {
            int i2 = 0;
            while (i != -1 && i2 < this.f186a) {
                if (this.f188c[i] == arrayRow2.f10988a.f252a) {
                    float f = this.f190e[i];
                    m38a(arrayRow2.f10988a);
                    ArrayLinkedVariables arrayLinkedVariables = arrayRow2.f10991d;
                    int i3 = arrayLinkedVariables.f191f;
                    int i4 = 0;
                    while (i3 != -1 && i4 < arrayLinkedVariables.f186a) {
                        m45b(this.f187b.mIndexedVariables[arrayLinkedVariables.f188c[i3]], arrayLinkedVariables.f190e[i3] * f);
                        i3 = arrayLinkedVariables.f189d[i3];
                        i4++;
                    }
                    arrayRow.f10989b += arrayRow2.f10989b * f;
                    arrayRow2.f10988a.m80a(arrayRow);
                    i = this.f191f;
                } else {
                    i = this.f189d[i];
                    i2++;
                }
            }
            return;
        }
    }

    final SolverVariable m40a(boolean[] zArr, SolverVariable solverVariable) {
        int i = this.f191f;
        int i2 = 0;
        SolverVariable solverVariable2 = null;
        float f = 0.0f;
        while (i != -1 && i2 < this.f186a) {
            if (this.f190e[i] < 0.0f) {
                SolverVariable solverVariable3 = this.f187b.mIndexedVariables[this.f188c[i]];
                if ((zArr == null || !zArr[solverVariable3.f252a]) && solverVariable3 != solverVariable && (solverVariable3.f257f == Type.SLACK || solverVariable3.f257f == Type.ERROR)) {
                    float f2 = this.f190e[i];
                    if (f2 < f) {
                        solverVariable2 = solverVariable3;
                        f = f2;
                    }
                }
            }
            i = this.f189d[i];
            i2++;
        }
        return solverVariable2;
    }

    final SolverVariable m39a(int i) {
        int i2 = this.f191f;
        int i3 = 0;
        while (i2 != -1 && i3 < this.f186a) {
            if (i3 == i) {
                return this.f187b.mIndexedVariables[this.f188c[i2]];
            }
            i2 = this.f189d[i2];
            i3++;
        }
        return 0;
    }

    final float m44b(int i) {
        int i2 = this.f191f;
        int i3 = 0;
        while (i2 != -1 && i3 < this.f186a) {
            if (i3 == i) {
                return this.f190e[i2];
            }
            i2 = this.f189d[i2];
            i3++;
        }
        return 0;
    }

    public final float m46c(SolverVariable solverVariable) {
        int i = this.f191f;
        int i2 = 0;
        while (i != -1 && i2 < this.f186a) {
            if (this.f188c[i] == solverVariable.f252a) {
                return this.f190e[i];
            }
            i = this.f189d[i];
            i2++;
        }
        return null;
    }

    public String toString() {
        String str = "";
        int i = this.f191f;
        int i2 = 0;
        while (i != -1 && i2 < this.f186a) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(" -> ");
            str = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(this.f190e[i]);
            stringBuilder.append(" : ");
            str = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(this.f187b.mIndexedVariables[this.f188c[i]]);
            str = stringBuilder.toString();
            i = this.f189d[i];
            i2++;
        }
        return str;
    }
}
