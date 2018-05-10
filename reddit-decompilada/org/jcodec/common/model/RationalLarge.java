package org.jcodec.common.model;

import org.jcodec.common.StringUtils;
import org.jcodec.common.tools.MathUtil;

public class RationalLarge {
    public static final Rational HALF = new Rational(1, 2);
    public static final Rational ONE = new Rational(1, 1);
    public static final RationalLarge ZERO = new RationalLarge(0, 1);
    final long den;
    final long num;

    public RationalLarge(long j, long j2) {
        this.num = j;
        this.den = j2;
    }

    public long getNum() {
        return this.num;
    }

    public long getDen() {
        return this.den;
    }

    public static Rational parse(String str) {
        str = StringUtils.split(str, ":");
        return new Rational(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
    }

    public int hashCode() {
        return (31 * (((int) (this.den ^ (this.den >>> 32))) + 31)) + ((int) (this.num ^ (this.num >>> 32)));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RationalLarge rationalLarge = (RationalLarge) obj;
        return this.den == rationalLarge.den && this.num == rationalLarge.num;
    }

    public long multiplyS(long j) {
        return (this.num * j) / this.den;
    }

    public long divideS(long j) {
        return (this.den * j) / this.num;
    }

    public long divideByS(long j) {
        return this.num / (this.den * j);
    }

    public RationalLarge flip() {
        return new RationalLarge(this.den, this.num);
    }

    public static RationalLarge m28382R(long j, long j2) {
        return new RationalLarge(j, j2);
    }

    public static RationalLarge m28381R(long j) {
        return m28382R(j, 1);
    }

    public boolean lessThen(RationalLarge rationalLarge) {
        return this.num * rationalLarge.den < rationalLarge.num * this.den ? true : null;
    }

    public boolean greaterThen(RationalLarge rationalLarge) {
        return this.num * rationalLarge.den > rationalLarge.num * this.den ? true : null;
    }

    public boolean smallerOrEqualTo(RationalLarge rationalLarge) {
        return this.num * rationalLarge.den <= rationalLarge.num * this.den ? true : null;
    }

    public boolean greaterOrEqualTo(RationalLarge rationalLarge) {
        return this.num * rationalLarge.den >= rationalLarge.num * this.den ? true : null;
    }

    public boolean equals(RationalLarge rationalLarge) {
        return this.num * rationalLarge.den == rationalLarge.num * this.den ? true : null;
    }

    public RationalLarge plus(RationalLarge rationalLarge) {
        return MathUtil.reduce((this.num * rationalLarge.den) + (rationalLarge.num * this.den), this.den * rationalLarge.den);
    }

    public RationalLarge plus(Rational rational) {
        return MathUtil.reduce((this.num * ((long) rational.den)) + (((long) rational.num) * this.den), this.den * ((long) rational.den));
    }

    public RationalLarge minus(RationalLarge rationalLarge) {
        return MathUtil.reduce((this.num * rationalLarge.den) - (rationalLarge.num * this.den), this.den * rationalLarge.den);
    }

    public RationalLarge minus(Rational rational) {
        return MathUtil.reduce((this.num * ((long) rational.den)) - (((long) rational.num) * this.den), this.den * ((long) rational.den));
    }

    public RationalLarge plus(long j) {
        return new RationalLarge(this.num + (j * this.den), this.den);
    }

    public RationalLarge minus(long j) {
        return new RationalLarge(this.num - (j * this.den), this.den);
    }

    public RationalLarge multiply(long j) {
        return new RationalLarge(this.num * j, this.den);
    }

    public RationalLarge divide(long j) {
        return new RationalLarge(this.den * j, this.num);
    }

    public RationalLarge divideBy(long j) {
        return new RationalLarge(this.num, this.den * j);
    }

    public RationalLarge multiply(RationalLarge rationalLarge) {
        return MathUtil.reduce(this.num * rationalLarge.num, this.den * rationalLarge.den);
    }

    public RationalLarge multiply(Rational rational) {
        return MathUtil.reduce(this.num * ((long) rational.num), this.den * ((long) rational.den));
    }

    public RationalLarge divide(RationalLarge rationalLarge) {
        return MathUtil.reduce(rationalLarge.num * this.den, rationalLarge.den * this.num);
    }

    public RationalLarge divide(Rational rational) {
        return MathUtil.reduce(((long) rational.num) * this.den, ((long) rational.den) * this.num);
    }

    public RationalLarge divideBy(RationalLarge rationalLarge) {
        return MathUtil.reduce(this.num * rationalLarge.den, this.den * rationalLarge.num);
    }

    public RationalLarge divideBy(Rational rational) {
        return MathUtil.reduce(this.num * ((long) rational.den), this.den * ((long) rational.num));
    }

    public double scalar() {
        return ((double) this.num) / ((double) this.den);
    }

    public long scalarClip() {
        return this.num / this.den;
    }
}
