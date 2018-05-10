package com.raizlabs.android.dbflow.converter;

import java.math.BigInteger;

public class BigIntegerConverter extends TypeConverter<String, BigInteger> {
    public String getDBValue(BigInteger bigInteger) {
        return bigInteger == null ? null : bigInteger.toString();
    }

    public BigInteger getModelValue(String str) {
        return str == null ? null : new BigInteger(str);
    }
}
