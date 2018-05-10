package com.googlecode.mp4parser.boxes.mp4.objectdescriptors;

import com.coremedia.iso.IsoTypeReader;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ObjectDescriptorFactory {
    protected static Logger f8980a = Logger.getLogger(ObjectDescriptorFactory.class.getName());
    protected static Map<Integer, Map<Integer, Class<? extends BaseDescriptor>>> f8981b = new HashMap();

    static {
        Set<Class> hashSet = new HashSet();
        hashSet.add(DecoderSpecificInfo.class);
        hashSet.add(SLConfigDescriptor.class);
        hashSet.add(BaseDescriptor.class);
        hashSet.add(ExtensionDescriptor.class);
        hashSet.add(ObjectDescriptorBase.class);
        hashSet.add(ProfileLevelIndicationDescriptor.class);
        hashSet.add(AudioSpecificConfig.class);
        hashSet.add(ExtensionProfileLevelDescriptor.class);
        hashSet.add(ESDescriptor.class);
        hashSet.add(DecoderConfigDescriptor.class);
        for (Class cls : hashSet) {
            Descriptor descriptor = (Descriptor) cls.getAnnotation(Descriptor.class);
            int[] a = descriptor.m7688a();
            int b = descriptor.m7689b();
            Map map = (Map) f8981b.get(Integer.valueOf(b));
            if (map == null) {
                map = new HashMap();
            }
            for (int valueOf : a) {
                map.put(Integer.valueOf(valueOf), cls);
            }
            f8981b.put(Integer.valueOf(b), map);
        }
    }

    public static BaseDescriptor m7690a(int i, ByteBuffer byteBuffer) throws IOException {
        BaseDescriptor baseDescriptor;
        Logger logger;
        int d = IsoTypeReader.m3284d(byteBuffer);
        Map map = (Map) f8981b.get(Integer.valueOf(i));
        if (map == null) {
            map = (Map) f8981b.get(Integer.valueOf(-1));
        }
        Class cls = (Class) map.get(Integer.valueOf(d));
        if (!(cls == null || cls.isInterface())) {
            if (!Modifier.isAbstract(cls.getModifiers())) {
                try {
                    baseDescriptor = (BaseDescriptor) cls.newInstance();
                    baseDescriptor.m7679a(d, byteBuffer);
                    return baseDescriptor;
                } catch (ByteBuffer byteBuffer2) {
                    logger = f8980a;
                    Level level = Level.SEVERE;
                    StringBuilder stringBuilder = new StringBuilder("Couldn't instantiate BaseDescriptor class ");
                    stringBuilder.append(cls);
                    stringBuilder.append(" for objectTypeIndication ");
                    stringBuilder.append(i);
                    stringBuilder.append(" and tag ");
                    stringBuilder.append(d);
                    logger.log(level, stringBuilder.toString(), byteBuffer2);
                    throw new RuntimeException(byteBuffer2);
                }
            }
        }
        logger = f8980a;
        StringBuilder stringBuilder2 = new StringBuilder("No ObjectDescriptor found for objectTypeIndication ");
        stringBuilder2.append(Integer.toHexString(i));
        stringBuilder2.append(" and tag ");
        stringBuilder2.append(Integer.toHexString(d));
        stringBuilder2.append(" found: ");
        stringBuilder2.append(cls);
        logger.warning(stringBuilder2.toString());
        baseDescriptor = new UnknownDescriptor();
        baseDescriptor.m7679a(d, byteBuffer2);
        return baseDescriptor;
    }
}
