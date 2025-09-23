package org.apache.commons.lang3.mutable;

import org.apache.commons.lang3.math.NumberUtils;

/* loaded from: classes.dex */
public class MutableByte extends Number implements Comparable<MutableByte>, Mutable<Number> {
    private static final long serialVersionUID = -1585823265;
    private byte value;

    public MutableByte() {
    }

    public MutableByte(byte value) {
        this.value = value;
    }

    public MutableByte(Number value) {
        this.value = value.byteValue();
    }

    public MutableByte(String value) {
        this.value = Byte.parseByte(value);
    }

    @Override // org.apache.commons.lang3.mutable.Mutable
    /* renamed from: getValue */
    public Number getValue2() {
        return Byte.valueOf(this.value);
    }

    public void setValue(byte value) {
        this.value = value;
    }

    @Override // org.apache.commons.lang3.mutable.Mutable
    public void setValue(Number value) {
        this.value = value.byteValue();
    }

    public void increment() {
        this.value = (byte) (this.value + 1);
    }

    public byte getAndIncrement() {
        byte last = this.value;
        this.value = (byte) (this.value + 1);
        return last;
    }

    public byte incrementAndGet() {
        byte b = (byte) (this.value + 1);
        this.value = b;
        return b;
    }

    public void decrement() {
        this.value = (byte) (this.value - 1);
    }

    public byte getAndDecrement() {
        byte last = this.value;
        this.value = (byte) (this.value - 1);
        return last;
    }

    public byte decrementAndGet() {
        byte b = (byte) (this.value - 1);
        this.value = b;
        return b;
    }

    public void add(byte operand) {
        this.value = (byte) (this.value + operand);
    }

    public void add(Number operand) {
        this.value = (byte) (this.value + operand.byteValue());
    }

    public void subtract(byte operand) {
        this.value = (byte) (this.value - operand);
    }

    public void subtract(Number operand) {
        this.value = (byte) (this.value - operand.byteValue());
    }

    public byte addAndGet(byte operand) {
        byte b = (byte) (this.value + operand);
        this.value = b;
        return b;
    }

    public byte addAndGet(Number operand) {
        byte bByteValue = (byte) (this.value + operand.byteValue());
        this.value = bByteValue;
        return bByteValue;
    }

    public byte getAndAdd(byte operand) {
        byte last = this.value;
        this.value = (byte) (this.value + operand);
        return last;
    }

    public byte getAndAdd(Number operand) {
        byte last = this.value;
        this.value = (byte) (this.value + operand.byteValue());
        return last;
    }

    @Override // java.lang.Number
    public byte byteValue() {
        return this.value;
    }

    @Override // java.lang.Number
    public int intValue() {
        return this.value;
    }

    @Override // java.lang.Number
    public long longValue() {
        return this.value;
    }

    @Override // java.lang.Number
    public float floatValue() {
        return this.value;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return this.value;
    }

    public Byte toByte() {
        return Byte.valueOf(byteValue());
    }

    public boolean equals(Object obj) {
        return (obj instanceof MutableByte) && this.value == ((MutableByte) obj).byteValue();
    }

    public int hashCode() {
        return this.value;
    }

    @Override // java.lang.Comparable
    public int compareTo(MutableByte other) {
        return NumberUtils.compare(this.value, other.value);
    }

    public String toString() {
        return String.valueOf((int) this.value);
    }
}
