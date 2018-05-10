package com.google.gson;

import com.google.gson.internal.LazilyParsedNumber;
import java.math.BigInteger;

public final class JsonPrimitive extends JsonElement {
    private static final Class<?>[] f14992b = new Class[]{Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class};
    public Object f14993a;

    public JsonPrimitive(Boolean bool) {
        m14936a((Object) bool);
    }

    public JsonPrimitive(Number number) {
        m14936a((Object) number);
    }

    public JsonPrimitive(String str) {
        m14936a((Object) str);
    }

    JsonPrimitive(Object obj) {
        m14936a(obj);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m14936a(java.lang.Object r8) {
        /*
        r7 = this;
        r0 = r8 instanceof java.lang.Character;
        if (r0 == 0) goto L_0x0011;
    L_0x0004:
        r8 = (java.lang.Character) r8;
        r8 = r8.charValue();
        r8 = java.lang.String.valueOf(r8);
        r7.f14993a = r8;
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
        r3 = f14992b;
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
        com.google.gson.internal.C$Gson$Preconditions.m7522a(r1);
        r7.f14993a = r8;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.JsonPrimitive.a(java.lang.Object):void");
    }

    public final Number mo2460b() {
        return this.f14993a instanceof String ? new LazilyParsedNumber((String) this.f14993a) : (Number) this.f14993a;
    }

    public final int hashCode() {
        if (this.f14993a == null) {
            return 31;
        }
        long longValue;
        if (m14937a(this)) {
            longValue = mo2460b().longValue();
            return (int) ((longValue >>> 32) ^ longValue);
        } else if (!(this.f14993a instanceof Number)) {
            return this.f14993a.hashCode();
        } else {
            longValue = Double.doubleToLongBits(mo2460b().doubleValue());
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
                if (this.f14993a == null) {
                    return jsonPrimitive.f14993a == null;
                } else {
                    if (m14937a(this) && m14937a(jsonPrimitive)) {
                        return mo2460b().longValue() == jsonPrimitive.mo2460b().longValue();
                    } else {
                        if (!(this.f14993a instanceof Number) || !(jsonPrimitive.f14993a instanceof Number)) {
                            return this.f14993a.equals(jsonPrimitive.f14993a);
                        }
                        double doubleValue = mo2460b().doubleValue();
                        double doubleValue2 = jsonPrimitive.mo2460b().doubleValue();
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

    private static boolean m14937a(JsonPrimitive jsonPrimitive) {
        if (!(jsonPrimitive.f14993a instanceof Number)) {
            return false;
        }
        Number number = (Number) jsonPrimitive.f14993a;
        if (!((number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short))) {
            if ((number instanceof Byte) == null) {
                return false;
            }
        }
        return true;
    }

    public final boolean mo2465g() {
        if (this.f14993a instanceof Boolean) {
            return ((Boolean) this.f14993a).booleanValue();
        }
        return Boolean.parseBoolean(mo2461c());
    }

    public final String mo2461c() {
        if (this.f14993a instanceof Number) {
            return mo2460b().toString();
        }
        if (this.f14993a instanceof Boolean) {
            return ((Boolean) this.f14993a).toString();
        }
        return (String) this.f14993a;
    }

    public final double mo2462d() {
        return this.f14993a instanceof Number ? mo2460b().doubleValue() : Double.parseDouble(mo2461c());
    }

    public final long mo2463e() {
        return this.f14993a instanceof Number ? mo2460b().longValue() : Long.parseLong(mo2461c());
    }

    public final int mo2464f() {
        return this.f14993a instanceof Number ? mo2460b().intValue() : Integer.parseInt(mo2461c());
    }
}
