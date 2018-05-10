package timber.log;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public final class Timber {
    static volatile Tree[] f41422a = f41423b;
    private static final Tree[] f41423b = new Tree[0];
    private static final List<Tree> f41424c = new ArrayList();
    private static final Tree f41425d = new C31431();

    public static abstract class Tree {
        final ThreadLocal<String> f41421a = new ThreadLocal();

        public abstract void mo7910a(int i, String str, String str2, Throwable th);

        public boolean m43543a(int i) {
            return true;
        }

        public void mo7911a(String str, Object... objArr) {
            m43539a(2, null, str, objArr);
        }

        public void mo7913b(String str, Object... objArr) {
            m43539a(3, null, str, objArr);
        }

        public void mo7912a(Throwable th, String str, Object... objArr) {
            m43539a(3, th, str, objArr);
        }

        public void mo7915c(String str, Object... objArr) {
            m43539a(4, null, str, objArr);
        }

        public void mo7917d(String str, Object... objArr) {
            m43539a(5, null, str, objArr);
        }

        public void mo7914b(Throwable th, String str, Object... objArr) {
            m43539a(5, th, str, objArr);
        }

        public void mo7918e(String str, Object... objArr) {
            m43539a(6, null, str, objArr);
        }

        public void mo7916c(Throwable th, String str, Object... objArr) {
            m43539a(6, th, str, objArr);
        }

        private void m43539a(int i, Throwable th, String str, Object... objArr) {
            if (m43543a(i)) {
                if (str != null && str.length() == 0) {
                    str = null;
                }
                if (str != null) {
                    if (objArr.length > 0) {
                        str = String.format(str, objArr);
                    }
                    if (th != null) {
                        objArr = new StringBuilder();
                        objArr.append(str);
                        objArr.append("\n");
                        objArr.append(m43538a(th));
                        str = objArr.toString();
                    }
                } else if (th != null) {
                    str = m43538a(th);
                } else {
                    return;
                }
                String str2 = (String) this.f41421a.get();
                if (str2 != null) {
                    this.f41421a.remove();
                }
                mo7910a(i, str2, str, th);
            }
        }

        private static String m43538a(Throwable th) {
            Writer stringWriter = new StringWriter(256);
            PrintWriter printWriter = new PrintWriter(stringWriter, false);
            th.printStackTrace(printWriter);
            printWriter.flush();
            return stringWriter.toString();
        }
    }

    static class C31431 extends Tree {
        C31431() {
        }

        public final void mo7911a(String str, Object... objArr) {
            for (Tree a : Timber.f41422a) {
                a.mo7911a(str, objArr);
            }
        }

        public final void mo7913b(String str, Object... objArr) {
            for (Tree b : Timber.f41422a) {
                b.mo7913b(str, objArr);
            }
        }

        public final void mo7912a(Throwable th, String str, Object... objArr) {
            for (Tree a : Timber.f41422a) {
                a.mo7912a(th, str, objArr);
            }
        }

        public final void mo7915c(String str, Object... objArr) {
            for (Tree c : Timber.f41422a) {
                c.mo7915c(str, objArr);
            }
        }

        public final void mo7917d(String str, Object... objArr) {
            for (Tree d : Timber.f41422a) {
                d.mo7917d(str, objArr);
            }
        }

        public final void mo7914b(Throwable th, String str, Object... objArr) {
            for (Tree b : Timber.f41422a) {
                b.mo7914b(th, str, objArr);
            }
        }

        public final void mo7918e(String str, Object... objArr) {
            for (Tree e : Timber.f41422a) {
                e.mo7918e(str, objArr);
            }
        }

        public final void mo7916c(Throwable th, String str, Object... objArr) {
            for (Tree c : Timber.f41422a) {
                c.mo7916c(th, str, objArr);
            }
        }

        protected final void mo7910a(int i, String str, String str2, Throwable th) {
            throw new AssertionError("Missing override for log method.");
        }
    }

    public static void m43551a(String str, Object... objArr) {
        f41425d.mo7911a(str, objArr);
    }

    public static void m43554b(String str, Object... objArr) {
        f41425d.mo7913b(str, objArr);
    }

    public static void m43552a(Throwable th, String str, Object... objArr) {
        f41425d.mo7912a(th, str, objArr);
    }

    public static void m43556c(String str, Object... objArr) {
        f41425d.mo7915c(str, objArr);
    }

    public static void m43558d(String str, Object... objArr) {
        f41425d.mo7917d(str, objArr);
    }

    public static void m43555b(Throwable th, String str, Object... objArr) {
        f41425d.mo7914b(th, str, objArr);
    }

    public static void m43559e(String str, Object... objArr) {
        f41425d.mo7918e(str, objArr);
    }

    public static void m43557c(Throwable th, String str, Object... objArr) {
        f41425d.mo7916c(th, str, objArr);
    }

    public static Tree m43550a(String str) {
        for (Tree tree : f41422a) {
            tree.f41421a.set(str);
        }
        return f41425d;
    }

    public static void m43553a(Tree tree) {
        if (tree == f41425d) {
            throw new IllegalArgumentException("Cannot plant Timber into itself.");
        }
        synchronized (f41424c) {
            f41424c.add(tree);
            f41422a = (Tree[]) f41424c.toArray(new Tree[f41424c.size()]);
        }
    }
}
