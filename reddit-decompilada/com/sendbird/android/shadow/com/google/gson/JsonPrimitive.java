package com.sendbird.android.shadow.com.google.gson;

import com.sendbird.android.shadow.com.google.gson.internal.LazilyParsedNumber;
import java.math.BigInteger;

public final class JsonPrimitive extends JsonElement {
    private static final Class<?>[] f30236b = new Class[]{Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class};
    public Object f30237a;

    public JsonPrimitive(Boolean bool) {
        m31133a((Object) bool);
    }

    public JsonPrimitive(Number number) {
        m31133a((Object) number);
    }

    public JsonPrimitive(String str) {
        m31133a((Object) str);
    }

    JsonPrimitive(Object obj) {
        m31133a(obj);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m31133a(java.lang.Object r8) {
        /*
        r7 = this;
        r0 = r8 instanceof java.lang.Character;
        if (r0 == 0) goto L_0x0011;
    L_0x0004:
        r8 = (java.lang.Character) r8;
        r8 = r8.charValue();
        r8 = java.lang.String.valueOf(r8);
        r7.f30237a = r8;
        return;
    L_0x0011:
        r0 = r8 instanceof java.lang.Number;
        r1 = 0;
        r2 = 1;
        if (r0 != 0) goto L_0x0036;
    L_0x0017:
        r0 = r8 instanceof java.lang.String;
        if (r0 == 0) goto L_0x001d;
    L_0x001b:
        r0 = r2;
        goto L_0x0034;
    L_0x001d:
        r0 = r8.getClass();
        r3 = f30236b;
        r4 = r3.length;
        r5 = r1;
    L_0x0025:
        if (r5 >= r4) goto L_0x0033;
    L_0x0027:
        r6 = r3[r5];
        r6 = r6.isAssignableFrom(r0);
        if (r6 == 0) goto L_0x0030;
    L_0x002f:
        goto L_0x001b;
    L_0x0030:
        r5 = r5 + 1;
        goto L_0x0025;
    L_0x0033:
        r0 = r1;
    L_0x0034:
        if (r0 == 0) goto L_0x0037;
    L_0x0036:
        r1 = r2;
    L_0x0037:
        com.sendbird.android.shadow.com.google.gson.internal.C$Gson$Preconditions.m25094a(r1);
        r7.f30237a = r8;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.com.google.gson.JsonPrimitive.a(java.lang.Object):void");
    }

    public final Number mo5243b() {
        return this.f30237a instanceof String ? new LazilyParsedNumber((String) this.f30237a) : (Number) this.f30237a;
    }

    public final int hashCode() {
        if (this.f30237a == null) {
            return 31;
        }
        long longValue;
        if (m31134a(this)) {
            longValue = mo5243b().longValue();
            return (int) ((longValue >>> 32) ^ longValue);
        } else if (!(this.f30237a instanceof Number)) {
            return this.f30237a.hashCode();
        } else {
            longValue = Double.doubleToLongBits(mo5243b().doubleValue());
            return (int) ((longValue >>> 32) ^ longValue);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                JsonPrimitive jsonPrimitive = (JsonPrimitive) obj;
                if (this.f30237a == null) {
                    return jsonPrimitive.f30237a == null;
                } else {
                    if (m31134a(this) && m31134a(jsonPrimitive)) {
                        return mo5243b().longValue() == jsonPrimitive.mo5243b().longValue();
                    } else {
                        if (!(this.f30237a instanceof Number) || !(jsonPrimitive.f30237a instanceof Number)) {
                            return this.f30237a.equals(jsonPrimitive.f30237a);
                        }
                        double doubleValue = mo5243b().doubleValue();
                        double doubleValue2 = jsonPrimitive.mo5243b().doubleValue();
                        if (doubleValue != doubleValue2) {
                            if (Double.isNaN(doubleValue) == null || Double.isNaN(doubleValue2) == null) {
                                return false;
                            }
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean m31134a(JsonPrimitive jsonPrimitive) {
        if (!(jsonPrimitive.f30237a instanceof Number)) {
            return false;
        }
        Number number = (Number) jsonPrimitive.f30237a;
        if (!((number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short))) {
            if ((number instanceof Byte) == null) {
                return false;
            }
        }
        return true;
    }

    public final boolean mo5248g() {
        if (this.f30237a instanceof Boolean) {
            return ((Boolean) this.f30237a).booleanValue();
        }
        return Boolean.parseBoolean(mo5244c());
    }

    public final String mo5244c() {
        if (this.f30237a instanceof Number) {
            return mo5243b().toString();
        }
        if (this.f30237a instanceof Boolean) {
            return ((Boolean) this.f30237a).toString();
        }
        return (String) this.f30237a;
    }

    public final double mo5245d() {
        return this.f30237a instanceof Number ? mo5243b().doubleValue() : Double.parseDouble(mo5244c());
    }

    public final long mo5246e() {
        return this.f30237a instanceof Number ? mo5243b().longValue() : Long.parseLong(mo5244c());
    }

    public final int mo5247f() {
        return this.f30237a instanceof Number ? mo5243b().intValue() : Integer.parseInt(mo5244c());
    }
}
