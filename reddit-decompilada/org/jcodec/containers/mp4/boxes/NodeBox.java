package org.jcodec.containers.mp4.boxes;

import com.coremedia.iso.boxes.FreeBox;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.jcodec.common.NIOUtils;
import org.jcodec.common.tools.ToJSON;

public class NodeBox extends Box {
    private static final int MAX_BOX_SIZE = 134217728;
    protected List<Box> boxes = new LinkedList();
    protected BoxFactory factory = BoxFactory.getDefault();

    protected void getModelFields(List<String> list) {
    }

    public NodeBox(Header header) {
        super(header);
    }

    public NodeBox(NodeBox nodeBox) {
        super((Box) nodeBox);
        this.boxes = nodeBox.boxes;
        this.factory = nodeBox.factory;
    }

    public void parse(ByteBuffer byteBuffer) {
        while (byteBuffer.remaining() >= 8) {
            Box parseChildBox = parseChildBox(byteBuffer, this.factory);
            if (parseChildBox != null) {
                this.boxes.add(parseChildBox);
            }
        }
    }

    public static Box parseChildBox(ByteBuffer byteBuffer, BoxFactory boxFactory) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        while (byteBuffer.remaining() >= 4 && duplicate.getInt() == 0) {
            byteBuffer.getInt();
        }
        if (byteBuffer.remaining() < 4) {
            return null;
        }
        Header read = Header.read(byteBuffer);
        if (read == null || ((long) byteBuffer.remaining()) < read.getBodySize()) {
            return null;
        }
        return parseBox(NIOUtils.read(byteBuffer, (int) read.getBodySize()), read, boxFactory);
    }

    public static org.jcodec.containers.mp4.boxes.Box newBox(org.jcodec.containers.mp4.boxes.Header r4, org.jcodec.containers.mp4.boxes.BoxFactory r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r4.getFourcc();
        r5 = r5.toClass(r0);
        if (r5 != 0) goto L_0x0010;
    L_0x000a:
        r5 = new org.jcodec.containers.mp4.boxes.LeafBox;
        r5.<init>(r4);
        return r5;
    L_0x0010:
        r0 = 1;
        r1 = new java.lang.Class[r0];	 Catch:{ NoSuchMethodException -> 0x0029 }
        r2 = org.jcodec.containers.mp4.boxes.Header.class;	 Catch:{ NoSuchMethodException -> 0x0029 }
        r3 = 0;	 Catch:{ NoSuchMethodException -> 0x0029 }
        r1[r3] = r2;	 Catch:{ NoSuchMethodException -> 0x0029 }
        r1 = r5.getConstructor(r1);	 Catch:{ NoSuchMethodException -> 0x0029 }
        r0 = new java.lang.Object[r0];	 Catch:{ NoSuchMethodException -> 0x0029 }
        r0[r3] = r4;	 Catch:{ NoSuchMethodException -> 0x0029 }
        r4 = r1.newInstance(r0);	 Catch:{ NoSuchMethodException -> 0x0029 }
        r4 = (org.jcodec.containers.mp4.boxes.Box) r4;	 Catch:{ NoSuchMethodException -> 0x0029 }
        return r4;
    L_0x0027:
        r4 = move-exception;
        goto L_0x0030;
    L_0x0029:
        r4 = r5.newInstance();	 Catch:{ Exception -> 0x0027 }
        r4 = (org.jcodec.containers.mp4.boxes.Box) r4;	 Catch:{ Exception -> 0x0027 }
        return r4;
    L_0x0030:
        r5 = new java.lang.RuntimeException;
        r5.<init>(r4);
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.containers.mp4.boxes.NodeBox.newBox(org.jcodec.containers.mp4.boxes.Header, org.jcodec.containers.mp4.boxes.BoxFactory):org.jcodec.containers.mp4.boxes.Box");
    }

    public static Box parseBox(ByteBuffer byteBuffer, Header header, BoxFactory boxFactory) {
        boxFactory = newBox(header, boxFactory);
        if (header.getBodySize() >= 134217728) {
            return new LeafBox(new Header(FreeBox.TYPE, 8));
        }
        boxFactory.parse(byteBuffer);
        return boxFactory;
    }

    public List<Box> getBoxes() {
        return this.boxes;
    }

    public void add(Box box) {
        this.boxes.add(box);
    }

    protected void doWrite(ByteBuffer byteBuffer) {
        for (Box write : this.boxes) {
            write.write(byteBuffer);
        }
    }

    public void addFirst(MovieHeaderBox movieHeaderBox) {
        this.boxes.add(0, movieHeaderBox);
    }

    public void replace(String str, Box box) {
        removeChildren(str);
        add(box);
    }

    public void replace(Box box) {
        removeChildren(box.getFourcc());
        add(box);
    }

    protected void dump(StringBuilder stringBuilder) {
        StringBuilder stringBuilder2 = new StringBuilder("{\"tag\":\"");
        stringBuilder2.append(this.header.getFourcc());
        stringBuilder2.append("\",");
        stringBuilder.append(stringBuilder2.toString());
        List arrayList = new ArrayList(0);
        collectModel(getClass(), arrayList);
        ToJSON.fieldsToJSON(this, stringBuilder, (String[]) arrayList.toArray(new String[0]));
        stringBuilder.append("\"boxes\": [");
        dumpBoxes(stringBuilder);
        stringBuilder.append("]");
        stringBuilder.append("}");
    }

    protected void dumpBoxes(StringBuilder stringBuilder) {
        for (int i = 0; i < this.boxes.size(); i++) {
            ((Box) this.boxes.get(i)).dump(stringBuilder);
            if (i < this.boxes.size() - 1) {
                stringBuilder.append(",");
            }
        }
    }

    public void removeChildren(String... strArr) {
        Iterator it = this.boxes.iterator();
        while (it.hasNext()) {
            String fourcc = ((Box) it.next()).getFourcc();
            for (String equals : strArr) {
                if (equals.equals(fourcc)) {
                    it.remove();
                    break;
                }
            }
        }
    }
}
