package androidx.constraintlayout.motion.widget;

import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.motion.utils.CurveFit;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class SplineSet {
    private static final String TAG = "SplineSet";
    private int count;
    protected CurveFit mCurveFit;
    private String mType;
    protected int[] mTimePoints = new int[10];
    protected float[] mValues = new float[10];

    public abstract void setProperty(View view, float f);

    public String toString() {
        String str = this.mType;
        DecimalFormat df = new DecimalFormat("##.##");
        for (int i = 0; i < this.count; i++) {
            str = str + "[" + this.mTimePoints[i] + " , " + df.format(this.mValues[i]) + "] ";
        }
        return str;
    }

    public void setType(String type) {
        this.mType = type;
    }

    public float get(float t) {
        return (float) this.mCurveFit.getPos(t, 0);
    }

    public float getSlope(float t) {
        return (float) this.mCurveFit.getSlope(t, 0);
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    static SplineSet makeCustomSpline(String str, SparseArray<ConstraintAttribute> attrList) {
        return new CustomSet(str, attrList);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:142:0x00b8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static androidx.constraintlayout.motion.widget.SplineSet makeSpline(java.lang.String r1) {
        /*
            Method dump skipped, instructions count: 388
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.SplineSet.makeSpline(java.lang.String):androidx.constraintlayout.motion.widget.SplineSet");
    }

    public void setPoint(int position, float value) {
        int[] iArr = this.mTimePoints;
        if (iArr.length < this.count + 1) {
            this.mTimePoints = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.mValues;
            this.mValues = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.mTimePoints;
        int i = this.count;
        iArr2[i] = position;
        this.mValues[i] = value;
        this.count = i + 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setup(int r11) {
        /*
            r10 = this;
            int r0 = r10.count
            if (r0 != 0) goto L5
            return
        L5:
            int[] r1 = r10.mTimePoints
            float[] r2 = r10.mValues
            r3 = 1
            int r0 = r0 - r3
            r4 = 0
            androidx.constraintlayout.motion.widget.SplineSet.Sort.doubleQuickSort(r1, r2, r4, r0)
            r0 = 1
            r1 = 1
        L11:
            int r2 = r10.count
            if (r1 >= r2) goto L24
            int[] r2 = r10.mTimePoints
            int r5 = r1 + (-1)
            r5 = r2[r5]
            r2 = r2[r1]
            if (r5 == r2) goto L21
            int r0 = r0 + 1
        L21:
            int r1 = r1 + 1
            goto L11
        L24:
            double[] r1 = new double[r0]
            r2 = 2
            int[] r2 = new int[r2]
            r2[r3] = r3
            r2[r4] = r0
            java.lang.Class<double> r3 = double.class
            java.lang.Object r2 = java.lang.reflect.Array.newInstance(r3, r2)
            double[][] r2 = (double[][]) r2
            r3 = 0
            r5 = 0
        L37:
            int r6 = r10.count
            if (r5 >= r6) goto L64
            if (r5 <= 0) goto L48
            int[] r6 = r10.mTimePoints
            r7 = r6[r5]
            int r8 = r5 + (-1)
            r6 = r6[r8]
            if (r7 != r6) goto L48
            goto L61
        L48:
            int[] r6 = r10.mTimePoints
            r6 = r6[r5]
            double r6 = (double) r6
            r8 = 4576918229304087675(0x3f847ae147ae147b, double:0.01)
            double r6 = r6 * r8
            r1[r3] = r6
            r6 = r2[r3]
            float[] r7 = r10.mValues
            r7 = r7[r5]
            double r7 = (double) r7
            r6[r4] = r7
            int r3 = r3 + 1
        L61:
            int r5 = r5 + 1
            goto L37
        L64:
            androidx.constraintlayout.motion.utils.CurveFit r4 = androidx.constraintlayout.motion.utils.CurveFit.get(r11, r1, r2)
            r10.mCurveFit = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.SplineSet.setup(int):void");
    }

    static class ElevationSet extends SplineSet {
        ElevationSet() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float t) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setElevation(get(t));
            }
        }
    }

    static class AlphaSet extends SplineSet {
        AlphaSet() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float t) {
            view.setAlpha(get(t));
        }
    }

    static class RotationSet extends SplineSet {
        RotationSet() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float t) {
            view.setRotation(get(t));
        }
    }

    static class RotationXset extends SplineSet {
        RotationXset() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float t) {
            view.setRotationX(get(t));
        }
    }

    static class RotationYset extends SplineSet {
        RotationYset() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float t) {
            view.setRotationY(get(t));
        }
    }

    static class PivotXset extends SplineSet {
        PivotXset() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float t) {
            view.setPivotX(get(t));
        }
    }

    static class PivotYset extends SplineSet {
        PivotYset() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float t) {
            view.setPivotY(get(t));
        }
    }

    static class PathRotate extends SplineSet {
        PathRotate() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float t) {
        }

        public void setPathRotate(View view, float t, double dx, double dy) {
            view.setRotation(get(t) + ((float) Math.toDegrees(Math.atan2(dy, dx))));
        }
    }

    static class ScaleXset extends SplineSet {
        ScaleXset() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float t) {
            view.setScaleX(get(t));
        }
    }

    static class ScaleYset extends SplineSet {
        ScaleYset() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float t) {
            view.setScaleY(get(t));
        }
    }

    static class TranslationXset extends SplineSet {
        TranslationXset() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float t) {
            view.setTranslationX(get(t));
        }
    }

    static class TranslationYset extends SplineSet {
        TranslationYset() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float t) {
            view.setTranslationY(get(t));
        }
    }

    static class TranslationZset extends SplineSet {
        TranslationZset() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float t) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setTranslationZ(get(t));
            }
        }
    }

    static class CustomSet extends SplineSet {
        String mAttributeName;
        SparseArray<ConstraintAttribute> mConstraintAttributeList;
        float[] mTempValues;

        public CustomSet(String attribute, SparseArray<ConstraintAttribute> attrList) {
            this.mAttributeName = attribute.split(",")[1];
            this.mConstraintAttributeList = attrList;
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setup(int curveType) {
            int size = this.mConstraintAttributeList.size();
            int dimensionality = this.mConstraintAttributeList.valueAt(0).noOfInterpValues();
            double[] time = new double[size];
            this.mTempValues = new float[dimensionality];
            double[][] values = (double[][]) Array.newInstance((Class<?>) double.class, size, dimensionality);
            for (int i = 0; i < size; i++) {
                int key = this.mConstraintAttributeList.keyAt(i);
                ConstraintAttribute ca = this.mConstraintAttributeList.valueAt(i);
                time[i] = key * 0.01d;
                ca.getValuesToInterpolate(this.mTempValues);
                int k = 0;
                while (true) {
                    if (k < this.mTempValues.length) {
                        values[i][k] = r8[k];
                        k++;
                    }
                }
            }
            this.mCurveFit = CurveFit.get(curveType, time, values);
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setPoint(int position, float value) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        public void setPoint(int position, ConstraintAttribute value) {
            this.mConstraintAttributeList.append(position, value);
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float t) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            this.mCurveFit.getPos(t, this.mTempValues);
            this.mConstraintAttributeList.valueAt(0).setInterpolatedValue(view, this.mTempValues);
        }
    }

    static class ProgressSet extends SplineSet {
        boolean mNoMethod = false;

        ProgressSet() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float t) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(get(t));
                return;
            }
            if (this.mNoMethod) {
                return;
            }
            Method method = null;
            try {
                method = view.getClass().getMethod("setProgress", Float.TYPE);
            } catch (NoSuchMethodException e) {
                this.mNoMethod = true;
            }
            if (method != null) {
                try {
                    method.invoke(view, Float.valueOf(get(t)));
                } catch (IllegalAccessException e2) {
                    Log.e(SplineSet.TAG, "unable to setProgress", e2);
                } catch (InvocationTargetException e3) {
                    Log.e(SplineSet.TAG, "unable to setProgress", e3);
                }
            }
        }
    }

    private static class Sort {
        private Sort() {
        }

        static void doubleQuickSort(int[] key, float[] value, int low, int hi) {
            int[] stack = new int[key.length + 10];
            int count = 0 + 1;
            stack[0] = hi;
            int count2 = count + 1;
            stack[count] = low;
            while (count2 > 0) {
                int count3 = count2 - 1;
                int low2 = stack[count3];
                count2 = count3 - 1;
                int hi2 = stack[count2];
                if (low2 < hi2) {
                    int p = partition(key, value, low2, hi2);
                    int count4 = count2 + 1;
                    stack[count2] = p - 1;
                    int count5 = count4 + 1;
                    stack[count4] = low2;
                    int count6 = count5 + 1;
                    stack[count5] = hi2;
                    count2 = count6 + 1;
                    stack[count6] = p + 1;
                }
            }
        }

        private static int partition(int[] array, float[] value, int low, int hi) {
            int pivot = array[hi];
            int i = low;
            for (int j = low; j < hi; j++) {
                if (array[j] <= pivot) {
                    swap(array, value, i, j);
                    i++;
                }
            }
            swap(array, value, i, hi);
            return i;
        }

        private static void swap(int[] array, float[] value, int a, int b) {
            int tmp = array[a];
            array[a] = array[b];
            array[b] = tmp;
            float tmpv = value[a];
            value[a] = value[b];
            value[b] = tmpv;
        }
    }
}
