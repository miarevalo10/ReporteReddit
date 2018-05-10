package org.apache.commons.cli;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CommandLine implements Serializable {
    public List f26688a = new LinkedList();
    List f26689b = new ArrayList();

    CommandLine() {
    }

    public final boolean m28313a(String str) {
        List list = this.f26689b;
        str = Util.m28331a(str);
        for (Object obj : this.f26689b) {
            if (!str.equals(obj.f26699a)) {
                if (str.equals(obj.f26700b)) {
                    break;
                }
            }
            break;
        }
        Object obj2 = null;
        return list.contains(obj2);
    }

    final void m28314b(String str) {
        this.f26688a.add(str);
    }
}
