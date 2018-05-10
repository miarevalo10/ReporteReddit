package kotlin.reflect.jvm.internal.impl.util;

import java.util.Set;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.text.Regex;

/* compiled from: OperatorNameConventions.kt */
public final class OperatorNameConventions {
    public static final Name f26381A = null;
    public static final Name f26382B = null;
    public static final Name f26383C = null;
    public static final Name f26384D = null;
    public static final Name f26385E = null;
    public static final Name f26386F = null;
    public static final Name f26387G = null;
    public static final Set<Name> f26388H = null;
    public static final Set<Name> f26389I = null;
    public static final Set<Name> f26390J = null;
    public static final Set<Name> f26391K = null;
    public static final OperatorNameConventions f26392L = null;
    public static final Name f26393a = null;
    public static final Name f26394b = null;
    public static final Name f26395c = null;
    public static final Name f26396d = null;
    public static final Name f26397e = null;
    public static final Name f26398f = null;
    public static final Name f26399g = null;
    public static final Name f26400h = null;
    public static final Name f26401i = null;
    public static final Name f26402j = null;
    public static final Name f26403k = null;
    public static final Name f26404l = null;
    public static final Regex f26405m = null;
    public static final Name f26406n = null;
    public static final Name f26407o = null;
    public static final Name f26408p = null;
    public static final Name f26409q = null;
    public static final Name f26410r = null;
    public static final Name f26411s = null;
    public static final Name f26412t = null;
    public static final Name f26413u = null;
    public static final Name f26414v = null;
    public static final Name f26415w = null;
    public static final Name f26416x = null;
    public static final Name f26417y = null;
    public static final Name f26418z = null;

    static {
        OperatorNameConventions operatorNameConventions = new OperatorNameConventions();
    }

    private OperatorNameConventions() {
        f26392L = this;
        f26393a = Name.m27424a("getValue");
        f26394b = Name.m27424a("setValue");
        f26395c = Name.m27424a("provideDelegate");
        f26396d = Name.m27424a("equals");
        f26397e = Name.m27424a("compareTo");
        f26398f = Name.m27424a("contains");
        f26399g = Name.m27424a("invoke");
        f26400h = Name.m27424a("iterator");
        f26401i = Name.m27424a("get");
        f26402j = Name.m27424a("set");
        f26403k = Name.m27424a("next");
        f26404l = Name.m27424a("hasNext");
        f26405m = new Regex("component\\d+");
        f26406n = Name.m27424a("and");
        f26407o = Name.m27424a("or");
        f26408p = Name.m27424a("inc");
        f26409q = Name.m27424a("dec");
        f26410r = Name.m27424a("plus");
        f26411s = Name.m27424a("minus");
        f26412t = Name.m27424a("not");
        f26413u = Name.m27424a("unaryMinus");
        f26414v = Name.m27424a("unaryPlus");
        f26415w = Name.m27424a("times");
        f26416x = Name.m27424a("div");
        f26417y = Name.m27424a("mod");
        f26418z = Name.m27424a("rem");
        f26381A = Name.m27424a("rangeTo");
        f26382B = Name.m27424a("timesAssign");
        f26383C = Name.m27424a("divAssign");
        f26384D = Name.m27424a("modAssign");
        f26385E = Name.m27424a("remAssign");
        f26386F = Name.m27424a("plusAssign");
        f26387G = Name.m27424a("minusAssign");
        f26388H = SetsKt__SetsKt.m26802a((Object[]) new Name[]{f26408p, f26409q, f26414v, f26413u, f26412t});
        f26389I = SetsKt__SetsKt.m26802a((Object[]) new Name[]{f26414v, f26413u, f26412t});
        f26390J = SetsKt__SetsKt.m26802a((Object[]) new Name[]{f26415w, f26410r, f26411s, f26416x, f26417y, f26418z, f26381A});
        f26391K = SetsKt__SetsKt.m26802a((Object[]) new Name[]{f26382B, f26383C, f26384D, f26385E, f26386F, f26387G});
    }
}
