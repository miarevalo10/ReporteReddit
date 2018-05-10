package org.mp4parser.aspectj.runtime.reflect;

class StringMaker {
    static StringMaker f27190j;
    static StringMaker f27191k;
    static StringMaker f27192l;
    boolean f27193a = true;
    boolean f27194b = true;
    boolean f27195c = false;
    boolean f27196d = false;
    boolean f27197e = false;
    boolean f27198f = true;
    boolean f27199g = true;
    boolean f27200h = true;
    int f27201i;

    StringMaker() {
    }

    static {
        StringMaker stringMaker = new StringMaker();
        f27190j = stringMaker;
        stringMaker.f27193a = true;
        f27190j.f27194b = false;
        f27190j.f27195c = false;
        f27190j.f27196d = false;
        f27190j.f27197e = true;
        f27190j.f27198f = false;
        f27190j.f27199g = false;
        f27190j.f27201i = 0;
        stringMaker = new StringMaker();
        f27191k = stringMaker;
        stringMaker.f27193a = true;
        f27191k.f27194b = true;
        f27191k.f27195c = false;
        f27191k.f27196d = false;
        f27191k.f27197e = false;
        f27190j.f27201i = 1;
        stringMaker = new StringMaker();
        f27192l = stringMaker;
        stringMaker.f27193a = false;
        f27192l.f27194b = true;
        f27192l.f27195c = false;
        f27192l.f27196d = true;
        f27192l.f27197e = false;
        f27192l.f27200h = false;
        f27192l.f27201i = 2;
    }

    static String m28656a(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        if (lastIndexOf == -1) {
            return str;
        }
        return str.substring(lastIndexOf + 1);
    }

    final String m28658a(Class cls, String str, boolean z) {
        if (cls == null) {
            return "ANONYMOUS";
        }
        if (cls.isArray()) {
            cls = cls.getComponentType();
            str = new StringBuffer();
            str.append(m28658a(cls, cls.getName(), z));
            str.append("[]");
            return str.toString();
        } else if (!z) {
            return str.replace('$', '.');
        } else {
            z = str.lastIndexOf(46);
            if (!z) {
                str = str.substring(z + 1);
            }
            return str.replace('$', '.');
        }
    }

    public final String m28657a(Class cls) {
        return m28658a(cls, cls.getName(), this.f27193a);
    }

    public final void m28659a(StringBuffer stringBuffer, Class[] clsArr) {
        for (int i = 0; i < clsArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(m28657a(clsArr[i]));
        }
    }
}
