package android.support.v4.app;

import android.support.v4.util.LogWriter;
import android.util.Log;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

final class BackStackRecord extends FragmentTransaction implements OpGenerator {
    final FragmentManagerImpl f11252a;
    ArrayList<Op> f11253b = new ArrayList();
    int f11254c;
    int f11255d;
    int f11256e;
    int f11257f;
    int f11258g;
    int f11259h;
    boolean f11260i;
    boolean f11261j = true;
    String f11262k;
    boolean f11263l;
    int f11264m = -1;
    int f11265n;
    CharSequence f11266o;
    int f11267p;
    CharSequence f11268q;
    ArrayList<String> f11269r;
    ArrayList<String> f11270s;
    boolean f11271t = false;
    ArrayList<Runnable> f11272u;

    static final class Op {
        int f934a;
        Fragment f935b;
        int f936c;
        int f937d;
        int f938e;
        int f939f;

        Op() {
        }

        Op(int i, Fragment fragment) {
            this.f934a = i;
            this.f935b = fragment;
        }
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("BackStackEntry{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f11264m >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.f11264m);
        }
        if (this.f11262k != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.f11262k);
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void m9778a(String str, PrintWriter printWriter) {
        m9779a(str, printWriter, true);
    }

    public final void m9779a(String str, PrintWriter printWriter, boolean z) {
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f11262k);
            printWriter.print(" mIndex=");
            printWriter.print(this.f11264m);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f11263l);
            if (this.f11258g != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f11258g));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.f11259h));
            }
            if (!(this.f11254c == 0 && this.f11255d == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f11254c));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f11255d));
            }
            if (!(this.f11256e == 0 && this.f11257f == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f11256e));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f11257f));
            }
            if (!(this.f11265n == 0 && this.f11266o == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f11265n));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f11266o);
            }
            if (!(this.f11267p == 0 && this.f11268q == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f11267p));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f11268q);
            }
        }
        if (!this.f11253b.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Operations:");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("    ");
            int size = this.f11253b.size();
            for (int i = 0; i < size; i++) {
                String str2;
                Op op = (Op) this.f11253b.get(i);
                switch (op.f934a) {
                    case 0:
                        str2 = "NULL";
                        break;
                    case 1:
                        str2 = "ADD";
                        break;
                    case 2:
                        str2 = "REPLACE";
                        break;
                    case 3:
                        str2 = "REMOVE";
                        break;
                    case 4:
                        str2 = "HIDE";
                        break;
                    case 5:
                        str2 = "SHOW";
                        break;
                    case 6:
                        str2 = "DETACH";
                        break;
                    case 7:
                        str2 = "ATTACH";
                        break;
                    case 8:
                        str2 = "SET_PRIMARY_NAV";
                        break;
                    case 9:
                        str2 = "UNSET_PRIMARY_NAV";
                        break;
                    default:
                        StringBuilder stringBuilder2 = new StringBuilder("cmd=");
                        stringBuilder2.append(op.f934a);
                        str2 = stringBuilder2.toString();
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(" ");
                printWriter.println(op.f935b);
                if (z) {
                    if (!(op.f936c == 0 && op.f937d == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(op.f936c));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(op.f937d));
                    }
                    if (op.f938e != 0 || op.f939f != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(op.f938e));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(op.f939f));
                    }
                }
            }
        }
    }

    public BackStackRecord(FragmentManagerImpl fragmentManagerImpl) {
        this.f11252a = fragmentManagerImpl;
    }

    final void m9776a(Op op) {
        this.f11253b.add(op);
        op.f936c = this.f11254c;
        op.f937d = this.f11255d;
        op.f938e = this.f11256e;
        op.f939f = this.f11257f;
    }

    public final FragmentTransaction mo197a(Fragment fragment, String str) {
        m9763a(0, fragment, str, 1);
        return this;
    }

    public final FragmentTransaction mo194a(int i, Fragment fragment) {
        m9763a(i, fragment, null, 1);
        return this;
    }

    public final FragmentTransaction mo195a(int i, Fragment fragment, String str) {
        m9763a(i, fragment, str, 1);
        return this;
    }

    private void m9763a(int i, Fragment fragment, String str, int i2) {
        Class cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (!cls.isAnonymousClass() && Modifier.isPublic(modifiers)) {
            if (!cls.isMemberClass() || Modifier.isStatic(modifiers)) {
                fragment.mFragmentManager = this.f11252a;
                if (str != null) {
                    if (fragment.mTag == null || str.equals(fragment.mTag)) {
                        fragment.mTag = str;
                    } else {
                        i2 = new StringBuilder("Can't change tag of fragment ");
                        i2.append(fragment);
                        i2.append(": was ");
                        i2.append(fragment.mTag);
                        i2.append(" now ");
                        i2.append(str);
                        throw new IllegalStateException(i2.toString());
                    }
                }
                if (i != 0) {
                    if (i == -1) {
                        i2 = new StringBuilder("Can't add fragment ");
                        i2.append(fragment);
                        i2.append(" with tag ");
                        i2.append(str);
                        i2.append(" to container view with no id");
                        throw new IllegalArgumentException(i2.toString());
                    } else if (fragment.mFragmentId == null || fragment.mFragmentId == i) {
                        fragment.mFragmentId = i;
                        fragment.mContainerId = i;
                    } else {
                        i2 = new StringBuilder("Can't change container ID of fragment ");
                        i2.append(fragment);
                        i2.append(": was ");
                        i2.append(fragment.mFragmentId);
                        i2.append(" now ");
                        i2.append(i);
                        throw new IllegalStateException(i2.toString());
                    }
                }
                m9776a(new Op(i2, fragment));
                return;
            }
        }
        fragment = new StringBuilder("Fragment ");
        fragment.append(cls.getCanonicalName());
        fragment.append(" must be a public static class to be  properly recreated from instance state.");
        throw new IllegalStateException(fragment.toString());
    }

    public final FragmentTransaction mo200b(int i, Fragment fragment) {
        return mo201b(i, fragment, null);
    }

    public final FragmentTransaction mo201b(int i, Fragment fragment, String str) {
        if (i == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        m9763a(i, fragment, str, 2);
        return this;
    }

    public final FragmentTransaction mo196a(Fragment fragment) {
        m9776a(new Op(3, fragment));
        return this;
    }

    public final FragmentTransaction mo202b(Fragment fragment) {
        m9776a(new Op(6, fragment));
        return this;
    }

    public final FragmentTransaction mo204c(Fragment fragment) {
        m9776a(new Op(7, fragment));
        return this;
    }

    public final FragmentTransaction mo192a() {
        this.f11258g = 4099;
        return this;
    }

    public final FragmentTransaction mo198a(String str) {
        if (this.f11261j) {
            this.f11260i = true;
            this.f11262k = str;
            return this;
        }
        throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }

    private FragmentTransaction m9766h() {
        if (this.f11260i) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.f11261j = false;
        return this;
    }

    final void m9775a(int i) {
        if (this.f11260i) {
            if (FragmentManagerImpl.f11300a) {
                StringBuilder stringBuilder = new StringBuilder("Bump nesting in ");
                stringBuilder.append(this);
                stringBuilder.append(" by ");
                stringBuilder.append(i);
                Log.v("FragmentManager", stringBuilder.toString());
            }
            int size = this.f11253b.size();
            for (int i2 = 0; i2 < size; i2++) {
                Op op = (Op) this.f11253b.get(i2);
                if (op.f935b != null) {
                    Fragment fragment = op.f935b;
                    fragment.mBackStackNesting += i;
                    if (FragmentManagerImpl.f11300a) {
                        StringBuilder stringBuilder2 = new StringBuilder("Bump nesting of ");
                        stringBuilder2.append(op.f935b);
                        stringBuilder2.append(" to ");
                        stringBuilder2.append(op.f935b.mBackStackNesting);
                        Log.v("FragmentManager", stringBuilder2.toString());
                    }
                }
            }
        }
    }

    public final void m9787b() {
        if (this.f11272u != null) {
            int size = this.f11272u.size();
            for (int i = 0; i < size; i++) {
                ((Runnable) this.f11272u.get(i)).run();
            }
            this.f11272u = null;
        }
    }

    public final int mo203c() {
        return m9764b(false);
    }

    public final int mo205d() {
        return m9764b(true);
    }

    public final void mo206e() {
        m9766h();
        this.f11252a.m9893b((OpGenerator) this, false);
    }

    public final void mo207f() {
        m9766h();
        this.f11252a.m9893b((OpGenerator) this, true);
    }

    private int m9764b(boolean z) {
        if (this.f11263l) {
            throw new IllegalStateException("commit already called");
        }
        if (FragmentManagerImpl.f11300a) {
            StringBuilder stringBuilder = new StringBuilder("Commit: ");
            stringBuilder.append(this);
            Log.v("FragmentManager", stringBuilder.toString());
            PrintWriter printWriter = new PrintWriter(new LogWriter("FragmentManager"));
            m9778a("  ", printWriter);
            printWriter.close();
        }
        this.f11263l = true;
        if (this.f11260i) {
            this.f11264m = this.f11252a.m9870a(this);
        } else {
            this.f11264m = -1;
        }
        this.f11252a.m9884a((OpGenerator) this, z);
        return this.f11264m;
    }

    public final boolean mo199a(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
        if (FragmentManagerImpl.f11300a) {
            StringBuilder stringBuilder = new StringBuilder("Run: ");
            stringBuilder.append(this);
            Log.v("FragmentManager", stringBuilder.toString());
        }
        arrayList.add(this);
        arrayList2.add(Boolean.valueOf(null));
        if (this.f11260i != null) {
            arrayList = this.f11252a;
            if (arrayList.f11312g == null) {
                arrayList.f11312g = new ArrayList();
            }
            arrayList.f11312g.add(this);
        }
        return true;
    }

    final boolean m9788b(int i) {
        int size = this.f11253b.size();
        for (int i2 = 0; i2 < size; i2++) {
            Op op = (Op) this.f11253b.get(i2);
            int i3 = op.f935b != null ? op.f935b.mContainerId : 0;
            if (i3 != 0 && i3 == i) {
                return true;
            }
        }
        return false;
    }

    final boolean m9781a(ArrayList<BackStackRecord> arrayList, int i, int i2) {
        if (i2 == i) {
            return false;
        }
        int size = this.f11253b.size();
        int i3 = -1;
        for (int i4 = 0; i4 < size; i4++) {
            Op op = (Op) this.f11253b.get(i4);
            int i5 = op.f935b != null ? op.f935b.mContainerId : 0;
            if (!(i5 == 0 || i5 == r3)) {
                for (i3 = i; i3 < i2; i3++) {
                    BackStackRecord backStackRecord = (BackStackRecord) arrayList.get(i3);
                    int size2 = backStackRecord.f11253b.size();
                    for (int i6 = 0; i6 < size2; i6++) {
                        Op op2 = (Op) backStackRecord.f11253b.get(i6);
                        if ((op2.f935b != null ? op2.f935b.mContainerId : 0) == i5) {
                            return true;
                        }
                    }
                }
                i3 = i5;
            }
        }
        return false;
    }

    final void m9794g() {
        int size = this.f11253b.size();
        for (int i = 0; i < size; i++) {
            Op op = (Op) this.f11253b.get(i);
            Fragment fragment = op.f935b;
            if (fragment != null) {
                fragment.setNextTransition(this.f11258g, this.f11259h);
            }
            int i2 = op.f934a;
            if (i2 != 1) {
                switch (i2) {
                    case 3:
                        fragment.setNextAnim(op.f937d);
                        this.f11252a.m9906e(fragment);
                        break;
                    case 4:
                        fragment.setNextAnim(op.f937d);
                        FragmentManagerImpl.m9854f(fragment);
                        break;
                    case 5:
                        fragment.setNextAnim(op.f936c);
                        FragmentManagerImpl.m9856g(fragment);
                        break;
                    case 6:
                        fragment.setNextAnim(op.f937d);
                        this.f11252a.m9910h(fragment);
                        break;
                    case 7:
                        fragment.setNextAnim(op.f936c);
                        this.f11252a.m9911i(fragment);
                        break;
                    case 8:
                        this.f11252a.m9914j(fragment);
                        break;
                    case 9:
                        this.f11252a.m9914j(null);
                        break;
                    default:
                        StringBuilder stringBuilder = new StringBuilder("Unknown cmd: ");
                        stringBuilder.append(op.f934a);
                        throw new IllegalArgumentException(stringBuilder.toString());
                }
            }
            fragment.setNextAnim(op.f936c);
            this.f11252a.m9881a(fragment, false);
            if (!(this.f11271t || op.f934a == 1 || fragment == null)) {
                this.f11252a.m9902c(fragment);
            }
        }
        if (!this.f11271t) {
            this.f11252a.m9876a(this.f11252a.f11317l, true);
        }
    }

    final void m9780a(boolean z) {
        for (int size = this.f11253b.size() - 1; size >= 0; size--) {
            Op op = (Op) this.f11253b.get(size);
            Fragment fragment = op.f935b;
            if (fragment != null) {
                fragment.setNextTransition(FragmentManagerImpl.m9850d(this.f11258g), this.f11259h);
            }
            int i = op.f934a;
            if (i != 1) {
                switch (i) {
                    case 3:
                        fragment.setNextAnim(op.f938e);
                        this.f11252a.m9881a(fragment, false);
                        break;
                    case 4:
                        fragment.setNextAnim(op.f938e);
                        FragmentManagerImpl.m9856g(fragment);
                        break;
                    case 5:
                        fragment.setNextAnim(op.f939f);
                        FragmentManagerImpl.m9854f(fragment);
                        break;
                    case 6:
                        fragment.setNextAnim(op.f938e);
                        this.f11252a.m9911i(fragment);
                        break;
                    case 7:
                        fragment.setNextAnim(op.f939f);
                        this.f11252a.m9910h(fragment);
                        break;
                    case 8:
                        this.f11252a.m9914j(null);
                        break;
                    case 9:
                        this.f11252a.m9914j(fragment);
                        break;
                    default:
                        StringBuilder stringBuilder = new StringBuilder("Unknown cmd: ");
                        stringBuilder.append(op.f934a);
                        throw new IllegalArgumentException(stringBuilder.toString());
                }
            }
            fragment.setNextAnim(op.f939f);
            this.f11252a.m9906e(fragment);
            if (!(this.f11271t || op.f934a == 3 || fragment == null)) {
                this.f11252a.m9902c(fragment);
            }
        }
        if (!this.f11271t && z) {
            this.f11252a.m9876a(this.f11252a.f11317l, true);
        }
    }

    final Fragment m9767a(ArrayList<Fragment> arrayList, Fragment fragment) {
        Fragment fragment2 = fragment;
        fragment = null;
        while (fragment < this.f11253b.size()) {
            Op op = (Op) this.f11253b.get(fragment);
            switch (op.f934a) {
                case 1:
                case 7:
                    arrayList.add(op.f935b);
                    break;
                case 2:
                    Fragment fragment3 = op.f935b;
                    int i = fragment3.mContainerId;
                    Fragment fragment4 = fragment2;
                    int i2 = fragment;
                    fragment = null;
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        Fragment fragment5 = (Fragment) arrayList.get(size);
                        if (fragment5.mContainerId == i) {
                            if (fragment5 == fragment3) {
                                fragment = 1;
                            } else {
                                if (fragment5 == fragment4) {
                                    this.f11253b.add(i2, new Op(9, fragment5));
                                    i2++;
                                    fragment4 = null;
                                }
                                Op op2 = new Op(3, fragment5);
                                op2.f936c = op.f936c;
                                op2.f938e = op.f938e;
                                op2.f937d = op.f937d;
                                op2.f939f = op.f939f;
                                this.f11253b.add(i2, op2);
                                arrayList.remove(fragment5);
                                i2++;
                            }
                        }
                    }
                    if (fragment != null) {
                        this.f11253b.remove(i2);
                        fragment = i2 - 1;
                    } else {
                        op.f934a = 1;
                        arrayList.add(fragment3);
                        fragment = i2;
                    }
                    fragment2 = fragment4;
                    break;
                case 3:
                case 6:
                    arrayList.remove(op.f935b);
                    if (op.f935b != fragment2) {
                        break;
                    }
                    this.f11253b.add(fragment, new Op(9, op.f935b));
                    fragment++;
                    fragment2 = null;
                    break;
                case 8:
                    this.f11253b.add(fragment, new Op(9, fragment2));
                    fragment++;
                    fragment2 = op.f935b;
                    break;
                default:
                    break;
            }
            fragment += 1;
        }
        return fragment2;
    }

    final Fragment m9783b(ArrayList<Fragment> arrayList, Fragment fragment) {
        for (int i = 0; i < this.f11253b.size(); i++) {
            Op op = (Op) this.f11253b.get(i);
            int i2 = op.f934a;
            if (i2 != 1) {
                if (i2 != 3) {
                    switch (i2) {
                        case 6:
                            break;
                        case 7:
                            break;
                        case 8:
                            fragment = null;
                            break;
                        case 9:
                            fragment = op.f935b;
                            break;
                        default:
                            break;
                    }
                }
                arrayList.add(op.f935b);
            }
            arrayList.remove(op.f935b);
        }
        return fragment;
    }

    final void m9777a(OnStartEnterTransitionListener onStartEnterTransitionListener) {
        for (int i = 0; i < this.f11253b.size(); i++) {
            Op op = (Op) this.f11253b.get(i);
            if (m9765b(op)) {
                op.f935b.setOnStartEnterTransitionListener(onStartEnterTransitionListener);
            }
        }
    }

    static boolean m9765b(Op op) {
        op = op.f935b;
        return (op == null || !op.mAdded || op.mView == null || op.mDetached || op.mHidden || op.isPostponed() == null) ? null : true;
    }

    public final FragmentTransaction mo193a(int i, int i2) {
        this.f11254c = i;
        this.f11255d = i2;
        this.f11256e = 0;
        this.f11257f = 0;
        return this;
    }
}
