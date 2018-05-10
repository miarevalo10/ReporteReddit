package org.jcodec.containers.mp4.boxes;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import org.jcodec.common.Assert;
import org.jcodec.common.NIOUtils;
import org.jcodec.common.logging.Logger;
import org.jcodec.common.tools.ToJSON;

public abstract class Box {
    private static final String GET_MODEL_FIELDS = "getModelFields";
    protected Header header;

    public abstract void doWrite(ByteBuffer byteBuffer);

    public abstract void parse(ByteBuffer byteBuffer);

    public Box(Header header) {
        this.header = header;
    }

    public Box(Box box) {
        this.header = box.header;
    }

    public Header getHeader() {
        return this.header;
    }

    public static Box findFirst(NodeBox nodeBox, String... strArr) {
        return (Box) findFirst(nodeBox, Box.class, strArr);
    }

    public static <T> T findFirst(NodeBox nodeBox, Class<T> cls, String... strArr) {
        Object[] findAll = findAll(nodeBox, cls, strArr);
        return findAll.length > null ? findAll[null] : null;
    }

    public static Box[] findAll(Box box, String... strArr) {
        return (Box[]) findAll(box, Box.class, strArr);
    }

    private static void findSub(Box box, List<String> list, Collection<Box> collection) {
        if (list.size() > 0) {
            String str = (String) list.remove(0);
            if (box instanceof NodeBox) {
                for (Box box2 : ((NodeBox) box).getBoxes()) {
                    if (str == null || str.equals(box2.header.getFourcc())) {
                        findSub(box2, list, collection);
                    }
                }
            }
            list.add(0, str);
            return;
        }
        collection.add(box);
    }

    public static <T> T[] findAll(Box box, Class<T> cls, String... strArr) {
        Object linkedList = new LinkedList();
        List linkedList2 = new LinkedList();
        for (Object add : strArr) {
            linkedList2.add(add);
        }
        findSub(box, linkedList2, linkedList);
        return linkedList.toArray((Object[]) Array.newInstance(cls, 0));
    }

    public void write(ByteBuffer byteBuffer) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        NIOUtils.skip(byteBuffer, 8);
        doWrite(byteBuffer);
        this.header.setBodySize((byteBuffer.position() - duplicate.position()) - 8);
        Assert.assertEquals(this.header.headerSize(), 8);
        this.header.write(duplicate);
    }

    public String getFourcc() {
        return this.header.getFourcc();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        dump(stringBuilder);
        return stringBuilder.toString();
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public boolean equals(Object obj) {
        return obj == null ? null : toString().equals(obj.toString());
    }

    protected void dump(StringBuilder stringBuilder) {
        StringBuilder stringBuilder2 = new StringBuilder("{\"tag\":\"");
        stringBuilder2.append(this.header.getFourcc());
        stringBuilder2.append("\",");
        stringBuilder.append(stringBuilder2.toString());
        List arrayList = new ArrayList(0);
        collectModel(getClass(), arrayList);
        ToJSON.fieldsToJSON(this, stringBuilder, (String[]) arrayList.toArray(new String[0]));
        stringBuilder.append("}");
    }

    protected void collectModel(java.lang.Class r6, java.util.List<java.lang.String> r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = org.jcodec.containers.mp4.boxes.Box.class;
        if (r0 == r6) goto L_0x0036;
    L_0x0004:
        r0 = org.jcodec.containers.mp4.boxes.Box.class;
        r0 = r0.isAssignableFrom(r6);
        if (r0 != 0) goto L_0x000d;
    L_0x000c:
        goto L_0x0036;
    L_0x000d:
        r0 = r6.getSuperclass();
        r5.collectModel(r0, r7);
        r0 = "getModelFields";	 Catch:{ NoSuchMethodException -> 0x002b, Exception -> 0x002a }
        r1 = 1;	 Catch:{ NoSuchMethodException -> 0x002b, Exception -> 0x002a }
        r2 = new java.lang.Class[r1];	 Catch:{ NoSuchMethodException -> 0x002b, Exception -> 0x002a }
        r3 = java.util.List.class;	 Catch:{ NoSuchMethodException -> 0x002b, Exception -> 0x002a }
        r4 = 0;	 Catch:{ NoSuchMethodException -> 0x002b, Exception -> 0x002a }
        r2[r4] = r3;	 Catch:{ NoSuchMethodException -> 0x002b, Exception -> 0x002a }
        r0 = r6.getDeclaredMethod(r0, r2);	 Catch:{ NoSuchMethodException -> 0x002b, Exception -> 0x002a }
        r1 = new java.lang.Object[r1];	 Catch:{ NoSuchMethodException -> 0x002b, Exception -> 0x002a }
        r1[r4] = r7;	 Catch:{ NoSuchMethodException -> 0x002b, Exception -> 0x002a }
        r0.invoke(r5, r1);	 Catch:{ NoSuchMethodException -> 0x002b, Exception -> 0x002a }
        return;
    L_0x002a:
        return;
    L_0x002b:
        r5.checkWrongSignature(r6);
        r6 = org.jcodec.common.tools.ToJSON.allFields(r6);
        r7.addAll(r6);
        return;
    L_0x0036:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.containers.mp4.boxes.Box.collectModel(java.lang.Class, java.util.List):void");
    }

    private void checkWrongSignature(Class cls) {
        for (Method name : cls.getDeclaredMethods()) {
            if (name.getName().equals(GET_MODEL_FIELDS)) {
                StringBuilder stringBuilder = new StringBuilder("Class ");
                stringBuilder.append(cls.getCanonicalName());
                stringBuilder.append(" contains 'getModelFields' of wrong signature.\nDid you mean to define 'protected void getModelFields(List<String> model) ?");
                Logger.warn(stringBuilder.toString());
                return;
            }
        }
    }

    public static <T extends Box> T as(Class<T> cls, LeafBox leafBox) {
        try {
            Box box = (Box) cls.getConstructor(new Class[]{Header.class}).newInstance(new Object[]{leafBox.getHeader()});
            box.parse(leafBox.getData());
            return box;
        } catch (Class<T> cls2) {
            throw new RuntimeException(cls2);
        }
    }
}
