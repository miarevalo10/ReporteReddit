package org.apache.commons.cli;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Options implements Serializable {
    Map f26712a = new HashMap();
    Map f26713b = new HashMap();
    List f26714c = new ArrayList();
    private Map f26715d = new HashMap();

    public final Options m28328a(Option option) {
        String a = option.m28322a();
        if (option.m28324b()) {
            this.f26713b.put(option.f26700b, option);
        }
        if (option.f26703e) {
            if (this.f26714c.contains(a)) {
                this.f26714c.remove(this.f26714c.indexOf(a));
            }
            this.f26714c.add(a);
        }
        this.f26712a.put(a, option);
        return this;
    }

    final List m28327a() {
        return new ArrayList(this.f26712a.values());
    }

    public final boolean m28329a(String str) {
        str = Util.m28331a(str);
        if (!this.f26712a.containsKey(str)) {
            if (this.f26713b.containsKey(str) == null) {
                return null;
            }
        }
        return true;
    }

    public final OptionGroup m28330b(Option option) {
        return (OptionGroup) this.f26715d.get(option.m28322a());
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[ Options: [ short ");
        stringBuffer.append(this.f26712a.toString());
        stringBuffer.append(" ] [ long ");
        stringBuffer.append(this.f26713b);
        stringBuffer.append(" ]");
        return stringBuffer.toString();
    }
}
