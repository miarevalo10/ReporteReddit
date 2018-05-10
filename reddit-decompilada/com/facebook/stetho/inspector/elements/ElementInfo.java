package com.facebook.stetho.inspector.elements;

import com.facebook.stetho.common.ListUtil;
import com.facebook.stetho.common.Util;
import java.util.List;

public final class ElementInfo {
    public final List<Object> children;
    public final Object element;
    public final Object parentElement;

    ElementInfo(Object obj, Object obj2, List<Object> list) {
        this.element = Util.throwIfNull(obj);
        this.parentElement = obj2;
        this.children = ListUtil.copyToImmutableList(list);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ElementInfo)) {
            return false;
        }
        ElementInfo elementInfo = (ElementInfo) obj;
        return this.element == elementInfo.element && this.parentElement == elementInfo.parentElement && ListUtil.identityEquals(this.children, elementInfo.children) != null;
    }
}
