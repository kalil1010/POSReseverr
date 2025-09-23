package org.apache.commons.lang3;

import java.util.Random;
import kotlin.jvm.internal.PrimitiveCompanionObjects8;

/* loaded from: classes.dex */
public class RandomUtils {
    private static final Random RANDOM = new Random();

    public static boolean nextBoolean() {
        return RANDOM.nextBoolean();
    }

    public static byte[] nextBytes(int count) {
        Validate.isTrue(count >= 0, "Count cannot be negative.", new Object[0]);
        byte[] result = new byte[count];
        RANDOM.nextBytes(result);
        return result;
    }

    public static int nextInt(int startInclusive, int endExclusive) {
        Validate.isTrue(endExclusive >= startInclusive, "Start value must be smaller or equal to end value.", new Object[0]);
        Validate.isTrue(startInclusive >= 0, "Both range values must be non-negative.", new Object[0]);
        if (startInclusive == endExclusive) {
            return startInclusive;
        }
        return RANDOM.nextInt(endExclusive - startInclusive) + startInclusive;
    }

    public static int nextInt() {
        return nextInt(0, Integer.MAX_VALUE);
    }

    public static long nextLong(long startInclusive, long endExclusive) {
        Validate.isTrue(endExclusive >= startInclusive, "Start value must be smaller or equal to end value.", new Object[0]);
        Validate.isTrue(startInclusive >= 0, "Both range values must be non-negative.", new Object[0]);
        if (startInclusive == endExclusive) {
            return startInclusive;
        }
        return (long) nextDouble(startInclusive, endExclusive);
    }

    public static long nextLong() {
        return nextLong(0L, PrimitiveCompanionObjects8.MAX_VALUE);
    }

    public static double nextDouble(double startInclusive, double endInclusive) {
        Validate.isTrue(endInclusive >= startInclusive, "Start value must be smaller or equal to end value.", new Object[0]);
        Validate.isTrue(startInclusive >= 0.0d, "Both range values must be non-negative.", new Object[0]);
        if (startInclusive == endInclusive) {
            return startInclusive;
        }
        return ((endInclusive - startInclusive) * RANDOM.nextDouble()) + startInclusive;
    }

    public static double nextDouble() {
        return nextDouble(0.0d, Double.MAX_VALUE);
    }

    public static float nextFloat(float startInclusive, float endInclusive) {
        Validate.isTrue(endInclusive >= startInclusive, "Start value must be smaller or equal to end value.", new Object[0]);
        Validate.isTrue(startInclusive >= 0.0f, "Both range values must be non-negative.", new Object[0]);
        if (startInclusive == endInclusive) {
            return startInclusive;
        }
        return ((endInclusive - startInclusive) * RANDOM.nextFloat()) + startInclusive;
    }

    public static float nextFloat() {
        return nextFloat(0.0f, Float.MAX_VALUE);
    }
}
