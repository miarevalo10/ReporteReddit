package com.googlecode.mp4parser.boxes.mp4.objectdescriptors;

import com.coremedia.iso.Hex;
import com.coremedia.iso.IsoTypeReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

@Descriptor(a = {4})
public class DecoderConfigDescriptor extends BaseDescriptor {
    private static Logger f15182k = Logger.getLogger(DecoderConfigDescriptor.class.getName());
    public int f15183a;
    public int f15184b;
    public int f15185c;
    public int f15186d;
    public long f15187e;
    public long f15188f;
    public DecoderSpecificInfo f15189g;
    public AudioSpecificConfig f15190h;
    public List<ProfileLevelIndicationDescriptor> f15191i;
    byte[] f15192j;

    public DecoderConfigDescriptor() {
        this.f15191i = new ArrayList();
        this.Y = 4;
    }

    public final void mo2524a(ByteBuffer byteBuffer) throws IOException {
        this.f15183a = IsoTypeReader.m3284d(byteBuffer);
        int d = IsoTypeReader.m3284d(byteBuffer);
        this.f15184b = d >>> 2;
        this.f15185c = (d >> 1) & 1;
        this.f15186d = IsoTypeReader.m3282b(byteBuffer);
        this.f15187e = IsoTypeReader.m3280a(byteBuffer);
        this.f15188f = IsoTypeReader.m3280a(byteBuffer);
        while (byteBuffer.remaining() > 2) {
            d = byteBuffer.position();
            BaseDescriptor a = ObjectDescriptorFactory.m7690a(this.f15183a, byteBuffer);
            int position = byteBuffer.position() - d;
            Logger logger = f15182k;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(a);
            stringBuilder.append(" - DecoderConfigDescr1 read: ");
            stringBuilder.append(position);
            stringBuilder.append(", size: ");
            stringBuilder.append(a != null ? Integer.valueOf(a.m7682b()) : null);
            logger.finer(stringBuilder.toString());
            if (a != null) {
                d = a.m7682b();
                if (position < d) {
                    this.f15192j = new byte[(d - position)];
                    byteBuffer.get(this.f15192j);
                }
            }
            if (a instanceof DecoderSpecificInfo) {
                this.f15189g = (DecoderSpecificInfo) a;
            } else if (a instanceof AudioSpecificConfig) {
                this.f15190h = (AudioSpecificConfig) a;
            } else if (a instanceof ProfileLevelIndicationDescriptor) {
                this.f15191i.add((ProfileLevelIndicationDescriptor) a);
            }
        }
    }

    public final int mo2523a() {
        int i = 0;
        int b = 13 + (this.f15190h == null ? 0 : this.f15190h.m7682b());
        if (this.f15189g != null) {
            i = this.f15189g.m7682b();
        }
        b += i;
        for (ProfileLevelIndicationDescriptor b2 : this.f15191i) {
            b += b2.m7682b();
        }
        return b;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DecoderConfigDescriptor");
        stringBuilder.append("{objectTypeIndication=");
        stringBuilder.append(this.f15183a);
        stringBuilder.append(", streamType=");
        stringBuilder.append(this.f15184b);
        stringBuilder.append(", upStream=");
        stringBuilder.append(this.f15185c);
        stringBuilder.append(", bufferSizeDB=");
        stringBuilder.append(this.f15186d);
        stringBuilder.append(", maxBitRate=");
        stringBuilder.append(this.f15187e);
        stringBuilder.append(", avgBitRate=");
        stringBuilder.append(this.f15188f);
        stringBuilder.append(", decoderSpecificInfo=");
        stringBuilder.append(this.f15189g);
        stringBuilder.append(", audioSpecificInfo=");
        stringBuilder.append(this.f15190h);
        stringBuilder.append(", configDescriptorDeadBytes=");
        stringBuilder.append(Hex.m3277a(this.f15192j != null ? this.f15192j : new byte[0]));
        stringBuilder.append(", profileLevelIndicationDescriptors=");
        stringBuilder.append(this.f15191i == null ? "null" : Arrays.asList(new List[]{this.f15191i}).toString());
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
