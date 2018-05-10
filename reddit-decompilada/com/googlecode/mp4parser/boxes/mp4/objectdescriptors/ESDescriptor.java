package com.googlecode.mp4parser.boxes.mp4.objectdescriptors;

import com.coremedia.iso.IsoTypeReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Descriptor(a = {3})
public class ESDescriptor extends BaseDescriptor {
    private static Logger f15194n = Logger.getLogger(ESDescriptor.class.getName());
    public int f15195a;
    public int f15196b;
    public int f15197c;
    public int f15198d;
    public int f15199e;
    public int f15200f;
    public String f15201g;
    public int f15202h;
    public int f15203i;
    public int f15204j;
    public DecoderConfigDescriptor f15205k;
    public SLConfigDescriptor f15206l;
    public List<BaseDescriptor> f15207m;

    public ESDescriptor() {
        this.f15200f = 0;
        this.f15207m = new ArrayList();
        this.Y = 3;
    }

    public final void mo2524a(ByteBuffer byteBuffer) throws IOException {
        this.f15195a = IsoTypeReader.m3283c(byteBuffer);
        int d = IsoTypeReader.m3284d(byteBuffer);
        this.f15196b = d >>> 7;
        this.f15197c = (d >>> 6) & 1;
        this.f15198d = (d >>> 5) & 1;
        this.f15199e = d & 31;
        if (this.f15196b == 1) {
            this.f15203i = IsoTypeReader.m3283c(byteBuffer);
        }
        if (this.f15197c == 1) {
            this.f15200f = IsoTypeReader.m3284d(byteBuffer);
            this.f15201g = IsoTypeReader.m3281a(byteBuffer, this.f15200f);
        }
        if (this.f15198d == 1) {
            this.f15204j = IsoTypeReader.m3283c(byteBuffer);
        }
        while (byteBuffer.remaining() > 1) {
            BaseDescriptor a = ObjectDescriptorFactory.m7690a(-1, byteBuffer);
            if (a instanceof DecoderConfigDescriptor) {
                this.f15205k = (DecoderConfigDescriptor) a;
            } else if (a instanceof SLConfigDescriptor) {
                this.f15206l = (SLConfigDescriptor) a;
            } else {
                this.f15207m.add(a);
            }
        }
    }

    public final int mo2523a() {
        int i = this.f15196b > 0 ? 5 : 3;
        if (this.f15197c > 0) {
            i += 1 + this.f15200f;
        }
        if (this.f15198d > 0) {
            i += 2;
        }
        i = (i + this.f15205k.m7682b()) + this.f15206l.m7682b();
        if (this.f15207m.size() <= 0) {
            return i;
        }
        throw new RuntimeException(" Doesn't handle other descriptors yet");
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ESDescriptor");
        stringBuilder.append("{esId=");
        stringBuilder.append(this.f15195a);
        stringBuilder.append(", streamDependenceFlag=");
        stringBuilder.append(this.f15196b);
        stringBuilder.append(", URLFlag=");
        stringBuilder.append(this.f15197c);
        stringBuilder.append(", oCRstreamFlag=");
        stringBuilder.append(this.f15198d);
        stringBuilder.append(", streamPriority=");
        stringBuilder.append(this.f15199e);
        stringBuilder.append(", URLLength=");
        stringBuilder.append(this.f15200f);
        stringBuilder.append(", URLString='");
        stringBuilder.append(this.f15201g);
        stringBuilder.append('\'');
        stringBuilder.append(", remoteODFlag=");
        stringBuilder.append(this.f15202h);
        stringBuilder.append(", dependsOnEsId=");
        stringBuilder.append(this.f15203i);
        stringBuilder.append(", oCREsId=");
        stringBuilder.append(this.f15204j);
        stringBuilder.append(", decoderConfigDescriptor=");
        stringBuilder.append(this.f15205k);
        stringBuilder.append(", slConfigDescriptor=");
        stringBuilder.append(this.f15206l);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r5) {
        /*
        r4 = this;
        r0 = 1;
        if (r4 != r5) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = 0;
        if (r5 == 0) goto L_0x00a5;
    L_0x0007:
        r2 = r4.getClass();
        r3 = r5.getClass();
        if (r2 == r3) goto L_0x0013;
    L_0x0011:
        goto L_0x00a5;
    L_0x0013:
        r5 = (com.googlecode.mp4parser.boxes.mp4.objectdescriptors.ESDescriptor) r5;
        r2 = r4.f15197c;
        r3 = r5.f15197c;
        if (r2 == r3) goto L_0x001c;
    L_0x001b:
        return r1;
    L_0x001c:
        r2 = r4.f15200f;
        r3 = r5.f15200f;
        if (r2 == r3) goto L_0x0023;
    L_0x0022:
        return r1;
    L_0x0023:
        r2 = r4.f15203i;
        r3 = r5.f15203i;
        if (r2 == r3) goto L_0x002a;
    L_0x0029:
        return r1;
    L_0x002a:
        r2 = r4.f15195a;
        r3 = r5.f15195a;
        if (r2 == r3) goto L_0x0031;
    L_0x0030:
        return r1;
    L_0x0031:
        r2 = r4.f15204j;
        r3 = r5.f15204j;
        if (r2 == r3) goto L_0x0038;
    L_0x0037:
        return r1;
    L_0x0038:
        r2 = r4.f15198d;
        r3 = r5.f15198d;
        if (r2 == r3) goto L_0x003f;
    L_0x003e:
        return r1;
    L_0x003f:
        r2 = r4.f15202h;
        r3 = r5.f15202h;
        if (r2 == r3) goto L_0x0046;
    L_0x0045:
        return r1;
    L_0x0046:
        r2 = r4.f15196b;
        r3 = r5.f15196b;
        if (r2 == r3) goto L_0x004d;
    L_0x004c:
        return r1;
    L_0x004d:
        r2 = r4.f15199e;
        r3 = r5.f15199e;
        if (r2 == r3) goto L_0x0054;
    L_0x0053:
        return r1;
    L_0x0054:
        r2 = r4.f15201g;
        if (r2 == 0) goto L_0x0063;
    L_0x0058:
        r2 = r4.f15201g;
        r3 = r5.f15201g;
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x0068;
    L_0x0062:
        goto L_0x0067;
    L_0x0063:
        r2 = r5.f15201g;
        if (r2 == 0) goto L_0x0068;
    L_0x0067:
        return r1;
    L_0x0068:
        r2 = r4.f15205k;
        if (r2 == 0) goto L_0x0077;
    L_0x006c:
        r2 = r4.f15205k;
        r3 = r5.f15205k;
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x007c;
    L_0x0076:
        goto L_0x007b;
    L_0x0077:
        r2 = r5.f15205k;
        if (r2 == 0) goto L_0x007c;
    L_0x007b:
        return r1;
    L_0x007c:
        r2 = r4.f15207m;
        if (r2 == 0) goto L_0x008b;
    L_0x0080:
        r2 = r4.f15207m;
        r3 = r5.f15207m;
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x0090;
    L_0x008a:
        goto L_0x008f;
    L_0x008b:
        r2 = r5.f15207m;
        if (r2 == 0) goto L_0x0090;
    L_0x008f:
        return r1;
    L_0x0090:
        r2 = r4.f15206l;
        if (r2 == 0) goto L_0x009f;
    L_0x0094:
        r2 = r4.f15206l;
        r5 = r5.f15206l;
        r5 = r2.equals(r5);
        if (r5 != 0) goto L_0x00a4;
    L_0x009e:
        goto L_0x00a3;
    L_0x009f:
        r5 = r5.f15206l;
        if (r5 == 0) goto L_0x00a4;
    L_0x00a3:
        return r1;
    L_0x00a4:
        return r0;
    L_0x00a5:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.googlecode.mp4parser.boxes.mp4.objectdescriptors.ESDescriptor.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int i = 0;
        int hashCode = 31 * ((((((((((((((((((((((this.f15195a * 31) + this.f15196b) * 31) + this.f15197c) * 31) + this.f15198d) * 31) + this.f15199e) * 31) + this.f15200f) * 31) + (this.f15201g != null ? this.f15201g.hashCode() : 0)) * 31) + this.f15202h) * 31) + this.f15203i) * 31) + this.f15204j) * 31) + (this.f15205k != null ? this.f15205k.hashCode() : 0)) * 31) + (this.f15206l != null ? this.f15206l.hashCode() : 0));
        if (this.f15207m != null) {
            i = this.f15207m.hashCode();
        }
        return hashCode + i;
    }
}
