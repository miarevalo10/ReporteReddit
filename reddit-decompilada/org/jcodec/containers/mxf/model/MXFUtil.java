package org.jcodec.containers.mxf.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MXFUtil {
    public static <T> T resolveRef(List<MXFMetadata> list, UL ul, Class<T> cls) {
        list = resolveRefs(list, new UL[]{ul}, cls);
        return list.size() > null ? list.get(0) : null;
    }

    public static <T> List<T> resolveRefs(List<MXFMetadata> list, UL[] ulArr, Class<T> cls) {
        List<MXFMetadata> arrayList = new ArrayList(list);
        list = arrayList.iterator();
        while (list.hasNext()) {
            MXFMetadata mXFMetadata = (MXFMetadata) list.next();
            if (mXFMetadata.getUid() == null || !cls.isAssignableFrom(mXFMetadata.getClass())) {
                list.remove();
            }
        }
        list = new ArrayList();
        for (Object equals : ulArr) {
            for (MXFMetadata mXFMetadata2 : arrayList) {
                if (mXFMetadata2.getUid().equals(equals)) {
                    list.add(mXFMetadata2);
                }
            }
        }
        return list;
    }

    public static <T> T findMeta(Collection<MXFMetadata> collection, Class<T> cls) {
        for (MXFMetadata mXFMetadata : collection) {
            if (mXFMetadata.getClass().isAssignableFrom(cls)) {
                return mXFMetadata;
            }
        }
        return null;
    }

    public static <T> List<T> findAllMeta(Collection<MXFMetadata> collection, Class<T> cls) {
        List<T> arrayList = new ArrayList();
        for (MXFMetadata mXFMetadata : collection) {
            if (cls.isAssignableFrom(mXFMetadata.getClass())) {
                arrayList.add(mXFMetadata);
            }
        }
        return arrayList;
    }
}
