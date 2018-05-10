package org.threeten.bp.zone;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;
import org.threeten.bp.ZoneOffset;

final class Ser implements Externalizable {
    private byte f41097a;
    private Object f41098b;

    public final void writeExternal(ObjectOutput objectOutput) throws IOException {
        byte b = this.f41097a;
        Object obj = this.f41098b;
        objectOutput.writeByte(b);
        switch (b) {
            case (byte) 1:
                StandardZoneRules standardZoneRules = (StandardZoneRules) obj;
                int i = 0;
                objectOutput.writeInt(standardZoneRules.f41546a.length);
                for (long a : standardZoneRules.f41546a) {
                    m43211a(a, (DataOutput) objectOutput);
                }
                for (ZoneOffset a2 : standardZoneRules.f41547b) {
                    m43212a(a2, (DataOutput) objectOutput);
                }
                objectOutput.writeInt(standardZoneRules.f41548c.length);
                for (long a3 : standardZoneRules.f41548c) {
                    m43211a(a3, (DataOutput) objectOutput);
                }
                for (ZoneOffset a22 : standardZoneRules.f41549d) {
                    m43212a(a22, (DataOutput) objectOutput);
                }
                objectOutput.writeByte(standardZoneRules.f41550e.length);
                ZoneOffsetTransitionRule[] zoneOffsetTransitionRuleArr = standardZoneRules.f41550e;
                int length = zoneOffsetTransitionRuleArr.length;
                while (i < length) {
                    zoneOffsetTransitionRuleArr[i].m43225a((DataOutput) objectOutput);
                    i++;
                }
                return;
            case (byte) 2:
                ZoneOffsetTransition zoneOffsetTransition = (ZoneOffsetTransition) obj;
                m43211a(zoneOffsetTransition.m43220a(), (DataOutput) objectOutput);
                m43212a(zoneOffsetTransition.f41104b, (DataOutput) objectOutput);
                m43212a(zoneOffsetTransition.f41105c, (DataOutput) objectOutput);
                return;
            case (byte) 3:
                ((ZoneOffsetTransitionRule) obj).m43225a((DataOutput) objectOutput);
                return;
            default:
                throw new InvalidClassException("Unknown serialized type");
        }
    }

    public final void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        this.f41097a = objectInput.readByte();
        this.f41098b = m43209a(this.f41097a, (DataInput) objectInput);
    }

    static Object m43210a(DataInput dataInput) throws IOException, ClassNotFoundException {
        return m43209a(dataInput.readByte(), dataInput);
    }

    private static Object m43209a(byte b, DataInput dataInput) throws IOException, ClassNotFoundException {
        switch (b) {
            case (byte) 1:
                return StandardZoneRules.m43644a(dataInput);
            case (byte) 2:
                return ZoneOffsetTransition.m43217a(dataInput);
            case (byte) 3:
                return ZoneOffsetTransitionRule.m43224a(dataInput);
            default:
                throw new StreamCorruptedException("Unknown serialized type");
        }
    }

    static ZoneOffset m43213b(DataInput dataInput) throws IOException {
        byte readByte = dataInput.readByte();
        return readByte == Byte.MAX_VALUE ? ZoneOffset.a(dataInput.readInt()) : ZoneOffset.a(readByte * 900);
    }

    private static void m43211a(long j, DataOutput dataOutput) throws IOException {
        if (j < -4575744000L || j >= 10413792000L || j % 900 != 0) {
            dataOutput.writeByte(255);
            dataOutput.writeLong(j);
            return;
        }
        j = (int) ((j + 4575744000L) / 900);
        dataOutput.writeByte((j >>> 16) & 255);
        dataOutput.writeByte((j >>> 8) & 255);
        dataOutput.writeByte(j & 255);
    }

    static long m43214c(DataInput dataInput) throws IOException {
        int readByte = dataInput.readByte() & 255;
        if (readByte == 255) {
            return dataInput.readLong();
        }
        return (((long) (((readByte << 16) + ((dataInput.readByte() & 255) << 8)) + (dataInput.readByte() & 255))) * 900) - 4575744000L;
    }

    private static void m43212a(ZoneOffset zoneOffset, DataOutput dataOutput) throws IOException {
        zoneOffset = zoneOffset.g;
        int i = zoneOffset % 900 == 0 ? zoneOffset / 900 : 127;
        dataOutput.writeByte(i);
        if (i == 127) {
            dataOutput.writeInt(zoneOffset);
        }
    }
}
