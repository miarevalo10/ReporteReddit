package com.facebook.stetho.inspector.elements;

import com.facebook.stetho.common.Accumulator;
import com.facebook.stetho.common.ListUtil;
import com.facebook.stetho.common.Util;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

public final class ShadowDocument implements DocumentView {
    private final IdentityHashMap<Object, ElementInfo> mElementToInfoMap = new IdentityHashMap();
    private boolean mIsUpdating;
    private final Object mRootElement;

    public final class UpdateBuilder {
        private HashSet<Object> mCachedNotNewChildrenSet;
        private final Map<Object, ElementInfo> mElementToInfoChangesMap = new LinkedHashMap();
        private final HashSet<Object> mRootElementChanges = new HashSet();

        public final void setElementChildren(Object obj, List<Object> list) {
            ElementInfo elementInfo = (ElementInfo) this.mElementToInfoChangesMap.get(obj);
            if (elementInfo == null || !ListUtil.identityEquals(list, elementInfo.children)) {
                ElementInfo elementInfo2 = (ElementInfo) ShadowDocument.this.mElementToInfoMap.get(obj);
                if (elementInfo != null || elementInfo2 == null || !ListUtil.identityEquals(list, elementInfo2.children)) {
                    int size;
                    if (elementInfo == null || elementInfo2 == null || elementInfo2.parentElement != elementInfo.parentElement || !ListUtil.identityEquals(list, elementInfo2.children)) {
                        Object obj2 = elementInfo != null ? elementInfo.parentElement : elementInfo2 != null ? elementInfo2.parentElement : null;
                        ElementInfo elementInfo3 = new ElementInfo(obj, obj2, list);
                        this.mElementToInfoChangesMap.put(obj, elementInfo3);
                        list = elementInfo3;
                    } else {
                        list = (ElementInfo) ShadowDocument.this.mElementToInfoMap.get(obj);
                        this.mElementToInfoChangesMap.remove(obj);
                    }
                    HashSet acquireNotNewChildrenHashSet = acquireNotNewChildrenHashSet();
                    int i = 0;
                    if (!(elementInfo2 == null || elementInfo2.children == list.children)) {
                        size = elementInfo2.children.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            acquireNotNewChildrenHashSet.add(elementInfo2.children.get(i2));
                        }
                    }
                    if (!(elementInfo == null || elementInfo.children == list.children)) {
                        int size2 = elementInfo.children.size();
                        for (size = 0; size < size2; size++) {
                            acquireNotNewChildrenHashSet.add(elementInfo.children.get(size));
                        }
                    }
                    int size3 = list.children.size();
                    while (i < size3) {
                        Object obj3 = list.children.get(i);
                        setElementParent(obj3, obj);
                        acquireNotNewChildrenHashSet.remove(obj3);
                        i++;
                    }
                    list = acquireNotNewChildrenHashSet.iterator();
                    while (list.hasNext()) {
                        Object next = list.next();
                        elementInfo2 = (ElementInfo) this.mElementToInfoChangesMap.get(next);
                        if (elementInfo2 == null || elementInfo2.parentElement == obj) {
                            elementInfo2 = (ElementInfo) ShadowDocument.this.mElementToInfoMap.get(next);
                            if (elementInfo2 != null && elementInfo2.parentElement == obj) {
                                setElementParent(next, null);
                            }
                        }
                    }
                    releaseNotNewChildrenHashSet(acquireNotNewChildrenHashSet);
                }
            }
        }

        private void setElementParent(Object obj, Object obj2) {
            ElementInfo elementInfo = (ElementInfo) this.mElementToInfoChangesMap.get(obj);
            if (elementInfo == null || obj2 != elementInfo.parentElement) {
                ElementInfo elementInfo2 = (ElementInfo) ShadowDocument.this.mElementToInfoMap.get(obj);
                if (elementInfo != null || elementInfo2 == null || obj2 != elementInfo2.parentElement) {
                    if (elementInfo == null || elementInfo2 == null || obj2 != elementInfo2.parentElement || !ListUtil.identityEquals(elementInfo2.children, elementInfo.children)) {
                        List emptyList = elementInfo != null ? elementInfo.children : elementInfo2 != null ? elementInfo2.children : Collections.emptyList();
                        this.mElementToInfoChangesMap.put(obj, new ElementInfo(obj, obj2, emptyList));
                        if (obj2 == null) {
                            this.mRootElementChanges.add(obj);
                            return;
                        } else {
                            this.mRootElementChanges.remove(obj);
                            return;
                        }
                    }
                    this.mElementToInfoChangesMap.remove(obj);
                    if (obj2 == null) {
                        this.mRootElementChanges.remove(obj);
                    }
                }
            }
        }

        public final Update build() {
            return new Update(this.mElementToInfoChangesMap, this.mRootElementChanges);
        }

        private HashSet<Object> acquireNotNewChildrenHashSet() {
            HashSet<Object> hashSet = this.mCachedNotNewChildrenSet;
            if (hashSet == null) {
                hashSet = new HashSet();
            }
            this.mCachedNotNewChildrenSet = null;
            return hashSet;
        }

        private void releaseNotNewChildrenHashSet(HashSet<Object> hashSet) {
            hashSet.clear();
            if (this.mCachedNotNewChildrenSet == null) {
                this.mCachedNotNewChildrenSet = hashSet;
            }
        }
    }

    public final class Update implements DocumentView {
        private final Map<Object, ElementInfo> mElementToInfoChangesMap;
        private final Set<Object> mRootElementChangesSet;

        public Update(Map<Object, ElementInfo> map, Set<Object> set) {
            this.mElementToInfoChangesMap = map;
            this.mRootElementChangesSet = set;
        }

        public final boolean isEmpty() {
            return this.mElementToInfoChangesMap.isEmpty();
        }

        public final boolean isElementChanged(Object obj) {
            return this.mElementToInfoChangesMap.containsKey(obj);
        }

        public final Object getRootElement() {
            return ShadowDocument.this.getRootElement();
        }

        public final ElementInfo getElementInfo(Object obj) {
            ElementInfo elementInfo = (ElementInfo) this.mElementToInfoChangesMap.get(obj);
            if (elementInfo != null) {
                return elementInfo;
            }
            return (ElementInfo) ShadowDocument.this.mElementToInfoMap.get(obj);
        }

        public final void getChangedElements(Accumulator<Object> accumulator) {
            for (Object store : this.mElementToInfoChangesMap.keySet()) {
                accumulator.store(store);
            }
        }

        public final void getGarbageElements(Accumulator<Object> accumulator) {
            Object remove;
            Queue arrayDeque = new ArrayDeque();
            for (Object remove2 : this.mRootElementChangesSet) {
                ElementInfo elementInfo = getElementInfo(remove2);
                if (remove2 != ShadowDocument.this.mRootElement && elementInfo.parentElement == null) {
                    arrayDeque.add(remove2);
                    arrayDeque.add(remove2);
                }
            }
            while (!arrayDeque.isEmpty()) {
                Object remove3 = arrayDeque.remove();
                remove2 = arrayDeque.remove();
                if (remove3 == remove2) {
                    remove2 = null;
                }
                if (getElementInfo(remove3).parentElement == remove2) {
                    accumulator.store(remove3);
                    ElementInfo elementInfo2 = ShadowDocument.this.getElementInfo(remove3);
                    if (elementInfo2 != null) {
                        int size = elementInfo2.children.size();
                        for (int i = 0; i < size; i++) {
                            arrayDeque.add(elementInfo2.children.get(i));
                            arrayDeque.add(remove3);
                        }
                    }
                }
            }
        }

        public final void abandon() {
            if (ShadowDocument.this.mIsUpdating) {
                ShadowDocument.this.mIsUpdating = false;
                return;
            }
            throw new IllegalStateException();
        }

        public final void commit() {
            if (ShadowDocument.this.mIsUpdating) {
                ShadowDocument.this.mElementToInfoMap.putAll(this.mElementToInfoChangesMap);
                for (Object removeGarbageSubTree : this.mRootElementChangesSet) {
                    removeGarbageSubTree(ShadowDocument.this.mElementToInfoMap, removeGarbageSubTree);
                }
                ShadowDocument.this.mIsUpdating = false;
                return;
            }
            throw new IllegalStateException();
        }

        private void removeGarbageSubTree(Map<Object, ElementInfo> map, Object obj) {
            ElementInfo elementInfo = (ElementInfo) map.get(obj);
            if (elementInfo.parentElement == null || !map.containsKey(elementInfo.parentElement)) {
                map.remove(obj);
                int size = elementInfo.children.size();
                for (obj = null; obj < size; obj++) {
                    removeGarbageSubTree(map, elementInfo.children.get(obj));
                }
            }
        }

        private void validateTree(Map<Object, ElementInfo> map) {
            HashSet hashSet = new HashSet();
            for (Entry entry : map.entrySet()) {
                Object key = entry.getKey();
                ElementInfo elementInfo = (ElementInfo) entry.getValue();
                if (key != elementInfo.element) {
                    throw new IllegalStateException("element != elementInfo.element");
                }
                int size = elementInfo.children.size();
                int i = 0;
                while (i < size) {
                    ElementInfo elementInfo2 = (ElementInfo) map.get(elementInfo.children.get(i));
                    if (elementInfo2 == null) {
                        throw new IllegalStateException(String.format("elementInfo.get(elementInfo.children.get(%s)) == null", new Object[]{Integer.valueOf(i)}));
                    } else if (elementInfo2.parentElement != key) {
                        throw new IllegalStateException("childElementInfo.parentElement != element");
                    } else {
                        i++;
                    }
                }
                if (elementInfo.parentElement == null) {
                    hashSet.add(key);
                } else {
                    ElementInfo elementInfo3 = (ElementInfo) map.get(elementInfo.parentElement);
                    if (elementInfo3 == null) {
                        throw new IllegalStateException("elementToInfoMap.get(elementInfo.parentElementInfo) == NULL");
                    } else if (elementInfo.parentElement != elementInfo3.element) {
                        throw new IllegalStateException("elementInfo.parentElementInfo != parentElementInfo.parent");
                    } else if (!elementInfo3.children.contains(key)) {
                        throw new IllegalStateException("parentElementInfo.children.contains(element) == FALSE");
                    }
                }
            }
            if (hashSet.size() != 1) {
                throw new IllegalStateException("elementToInfoMap is a forest, not a tree. rootElements.size() != 1");
            }
        }
    }

    public ShadowDocument(Object obj) {
        this.mRootElement = Util.throwIfNull(obj);
    }

    public final Object getRootElement() {
        return this.mRootElement;
    }

    public final ElementInfo getElementInfo(Object obj) {
        return (ElementInfo) this.mElementToInfoMap.get(obj);
    }

    public final UpdateBuilder beginUpdate() {
        if (this.mIsUpdating) {
            throw new IllegalStateException();
        }
        this.mIsUpdating = true;
        return new UpdateBuilder();
    }
}
