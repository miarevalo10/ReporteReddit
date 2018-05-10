package android.support.constraint.solver;

import java.util.Arrays;

public class ArrayRow implements Row {
    SolverVariable f10988a = null;
    public float f10989b = 0.0f;
    boolean f10990c = false;
    public final ArrayLinkedVariables f10991d;
    public boolean f10992e = false;

    public ArrayRow(Cache cache) {
        this.f10991d = new ArrayLinkedVariables(this, cache);
    }

    final void m9429a() {
        ArrayLinkedVariables arrayLinkedVariables = this.f10991d;
        int i = arrayLinkedVariables.f191f;
        int i2 = 0;
        while (i != -1 && i2 < arrayLinkedVariables.f186a) {
            SolverVariable solverVariable = arrayLinkedVariables.f187b.mIndexedVariables[arrayLinkedVariables.f188c[i]];
            for (int i3 = 0; i3 < solverVariable.f259h; i3++) {
                if (solverVariable.f258g[i3] == this) {
                    break;
                }
            }
            if (solverVariable.f259h >= solverVariable.f258g.length) {
                solverVariable.f258g = (ArrayRow[]) Arrays.copyOf(solverVariable.f258g, solverVariable.f258g.length * 2);
            }
            solverVariable.f258g[solverVariable.f259h] = this;
            solverVariable.f259h++;
            i = arrayLinkedVariables.f189d[i];
            i2++;
        }
    }

    public final ArrayRow m9426a(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i) {
        Object obj = null;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                obj = 1;
            }
            this.f10989b = (float) i;
        }
        if (obj == null) {
            this.f10991d.m43a(solverVariable, -1.0f);
            this.f10991d.m43a(solverVariable2, 1.0f);
            this.f10991d.m43a(solverVariable3, 1.0f);
        } else {
            this.f10991d.m43a(solverVariable, 1.0f);
            this.f10991d.m43a(solverVariable2, -1.0f);
            this.f10991d.m43a(solverVariable3, -1.0f);
        }
        return this;
    }

    public final ArrayRow m9433b(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i) {
        Object obj = null;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                obj = 1;
            }
            this.f10989b = (float) i;
        }
        if (obj == null) {
            this.f10991d.m43a(solverVariable, -1.0f);
            this.f10991d.m43a(solverVariable2, 1.0f);
            this.f10991d.m43a(solverVariable3, -1.0f);
        } else {
            this.f10991d.m43a(solverVariable, 1.0f);
            this.f10991d.m43a(solverVariable2, -1.0f);
            this.f10991d.m43a(solverVariable3, 1.0f);
        }
        return this;
    }

    public final ArrayRow m9425a(LinearSystem linearSystem, int i) {
        this.f10991d.m43a(linearSystem.m61a(i), 1.0f);
        this.f10991d.m43a(linearSystem.m61a(i), (float) -1082130432);
        return this;
    }

    public final ArrayRow m9427a(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f) {
        this.f10991d.m43a(solverVariable, -1.0f);
        this.f10991d.m43a(solverVariable2, 1.0f);
        this.f10991d.m43a(solverVariable3, f);
        this.f10991d.m43a(solverVariable4, -f);
        return this;
    }

    public final ArrayRow m9434b(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f) {
        this.f10991d.m43a(solverVariable3, 0.5f);
        this.f10991d.m43a(solverVariable4, 0.5f);
        this.f10991d.m43a(solverVariable, -0.5f);
        this.f10991d.m43a(solverVariable2, -0.5f);
        this.f10989b = -f;
        return this;
    }

    final boolean m9432a(ArrayRow arrayRow) {
        this.f10991d.m42a(this, arrayRow);
        return true;
    }

    final void m9431a(SolverVariable solverVariable) {
        if (this.f10988a != null) {
            this.f10991d.m43a(this.f10988a, -1.0f);
            this.f10988a = null;
        }
        float a = this.f10991d.m38a(solverVariable) * -1.0f;
        this.f10988a = solverVariable;
        if (a != 1.0f) {
            this.f10989b /= a;
            solverVariable = this.f10991d;
            int i = solverVariable.f191f;
            int i2 = 0;
            while (i != -1 && i2 < solverVariable.f186a) {
                float[] fArr = solverVariable.f190e;
                fArr[i] = fArr[i] / a;
                i = solverVariable.f189d[i];
                i2++;
            }
        }
    }

    public final SolverVariable mo6a(boolean[] zArr) {
        return this.f10991d.m40a(zArr, null);
    }

    public final void mo8b() {
        this.f10991d.m41a();
        this.f10988a = null;
        this.f10989b = 0.0f;
    }

    public final void mo7a(Row row) {
        if (row instanceof ArrayRow) {
            ArrayRow arrayRow = (ArrayRow) row;
            this.f10988a = null;
            this.f10991d.m41a();
            for (int i = 0; i < arrayRow.f10991d.f186a; i++) {
                this.f10991d.m45b(arrayRow.f10991d.m39a(i), arrayRow.f10991d.m44b(i));
            }
        }
    }

    public void mo9b(SolverVariable solverVariable) {
        float f = 1.0f;
        if (solverVariable.f254c != 1) {
            if (solverVariable.f254c == 2) {
                f = 1000.0f;
            } else if (solverVariable.f254c == 3) {
                f = 1000000.0f;
            } else if (solverVariable.f254c == 4) {
                f = 1.0E9f;
            } else if (solverVariable.f254c == 5) {
                f = 1.0E12f;
            }
        }
        this.f10991d.m43a(solverVariable, f);
    }

    public final SolverVariable mo10c() {
        return this.f10988a;
    }

    public String toString() {
        StringBuilder stringBuilder;
        String stringBuilder2;
        int i;
        String str = "";
        if (this.f10988a == null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("0");
            str = stringBuilder.toString();
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(this.f10988a);
            str = stringBuilder.toString();
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(" = ");
        str = stringBuilder.toString();
        int i2 = 0;
        if (this.f10989b != 0.0f) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(this.f10989b);
            stringBuilder2 = stringBuilder.toString();
            i = 1;
        } else {
            stringBuilder2 = str;
            i = 0;
        }
        int i3 = this.f10991d.f186a;
        while (i2 < i3) {
            StringBuilder stringBuilder3;
            SolverVariable a = this.f10991d.m39a(i2);
            if (a != null) {
                float b = this.f10991d.m44b(i2);
                String solverVariable = a.toString();
                if (i == 0) {
                    if (b < 0.0f) {
                        stringBuilder3 = new StringBuilder();
                        stringBuilder3.append(stringBuilder2);
                        stringBuilder3.append("- ");
                        stringBuilder2 = stringBuilder3.toString();
                        b *= -1.0f;
                    }
                } else if (b > 0.0f) {
                    stringBuilder3 = new StringBuilder();
                    stringBuilder3.append(stringBuilder2);
                    stringBuilder3.append(" + ");
                    stringBuilder2 = stringBuilder3.toString();
                } else {
                    stringBuilder3 = new StringBuilder();
                    stringBuilder3.append(stringBuilder2);
                    stringBuilder3.append(" - ");
                    stringBuilder2 = stringBuilder3.toString();
                    b *= -1.0f;
                }
                if (b == 1.0f) {
                    stringBuilder3 = new StringBuilder();
                    stringBuilder3.append(stringBuilder2);
                    stringBuilder3.append(solverVariable);
                    str = stringBuilder3.toString();
                } else {
                    stringBuilder3 = new StringBuilder();
                    stringBuilder3.append(stringBuilder2);
                    stringBuilder3.append(b);
                    stringBuilder3.append(" ");
                    stringBuilder3.append(solverVariable);
                    str = stringBuilder3.toString();
                }
                stringBuilder2 = str;
                i = 1;
            }
            i2++;
        }
        if (i != 0) {
            return stringBuilder2;
        }
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(stringBuilder2);
        stringBuilder3.append("0.0");
        return stringBuilder3.toString();
    }
}
