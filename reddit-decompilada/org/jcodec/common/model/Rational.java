package org.jcodec.common.model;

import org.jcodec.common.StringUtils;
import org.jcodec.common.tools.MathUtil;

public class Rational {
    public static final Rational HALF = new Rational(1, 2);
    public static final Rational ONE = new Rational(1, 1);
    public static final Rational ZERO = new Rational(0, 1);
    final int den;
    final int num;

    public static Rational m28380R(int i, int i2) {
        return new Rational(i, i2);
    }

    public static Rational m28379R(int i) {
        return m28380R(i, 1);
    }

    public Rational(int i, int i2) {
        this.num = i;
        this.den = i2;
    }

    public int getNum() {
        return this.num;
    }

    public int getDen() {
        return this.den;
    }

    public static Rational parse(String str) {
        str = StringUtils.split(str, ":");
        return new Rational(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
    }

    public int hashCode() {
        return (31 * (this.den + 31)) + this.num;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Rational rational = (Rational) obj;
        return this.den == rational.den && this.num == rational.num;
    }

    public int multiplyS(int i) {
        return (int) ((((long) this.num) * ((long) i)) / ((long) this.den));
    }

    public int divideS(int i) {
        return (int) ((((long) this.den) * ((long) i)) / ((long) this.num));
    }

    public int divideByS(int i) {
        return this.num / (this.den * i);
    }

    public long multiply(long j) {
        return (((long) this.num) * j) / ((long) this.den);
    }

    public long divide(long j) {
        return (((long) this.den) * j) / ((long) this.num);
    }

    public Rational flip() {
        return new Rational(this.den, this.num);
    }

    public boolean smallerThen(Rational rational) {
        return this.num * rational.den < rational.num * this.den ? true : null;
    }

    public boolean greaterThen(Rational rational) {
        return this.num * rational.den > rational.num * this.den ? true : null;
    }

    public boolean smallerOrEqualTo(Rational rational) {
        return this.num * rational.den <= rational.num * this.den ? true : null;
    }

    public boolean greaterOrEqualTo(Rational rational) {
        return this.num * rational.den >= rational.num * this.den ? true : null;
    }

    public boolean equals(Rational rational) {
        return this.num * rational.den == rational.num * this.den ? true : null;
    }

    public Rational plus(Rational rational) {
        return MathUtil.reduce((this.num * rational.den) + (rational.num * this.den), this.den * rational.den);
    }

    public RationalLarge plus(RationalLarge rationalLarge) {
        return MathUtil.reduce((((long) this.num) * rationalLarge.den) + (rationalLarge.num * ((long) this.den)), ((long) this.den) * rationalLarge.den);
    }

    public Rational minus(Rational rational) {
        return MathUtil.reduce((this.num * rational.den) - (rational.num * this.den), this.den * rational.den);
    }

    public RationalLarge minus(RationalLarge rationalLarge) {
        return MathUtil.reduce((((long) this.num) * rationalLarge.den) - (rationalLarge.num * ((long) this.den)), ((long) this.den) * rationalLarge.den);
    }

    public Rational plus(int i) {
        return new Rational(this.num + (i * this.den), this.den);
    }

    public Rational minus(int i) {
        return new Rational(this.num - (i * this.den), this.den);
    }

    public Rational multiply(int i) {
        return new Rational(this.num * i, this.den);
    }

    public Rational divide(int i) {
        return new Rational(this.den * i, this.num);
    }

    public Rational divideBy(int i) {
        return new Rational(this.num, this.den * i);
    }

    public Rational multiply(Rational rational) {
        return MathUtil.reduce(this.num * rational.num, this.den * rational.den);
    }

    public RationalLarge multiply(RationalLarge rationalLarge) {
        return MathUtil.reduce(((long) this.num) * rationalLarge.num, ((long) this.den) * rationalLarge.den);
    }

    public Rational divide(Rational rational) {
        return MathUtil.reduce(rational.num * this.den, rational.den * this.num);
    }

    public RationalLarge divide(RationalLarge rationalLarge) {
        return MathUtil.reduce(rationalLarge.num * ((long) this.den), rationalLarge.den * ((long) this.num));
    }

    public Rational divideBy(Rational rational) {
        return MathUtil.reduce(this.num * rational.den, this.den * rational.num);
    }

    public RationalLarge divideBy(RationalLarge rationalLarge) {
        return MathUtil.reduce(((long) this.num) * rationalLarge.den, ((long) this.den) * rationalLarge.num);
    }

    public float scalar() {
        return ((float) this.num) / ((float) this.den);
    }

    public int scalarClip() {
        return this.num / this.den;
    }
}
