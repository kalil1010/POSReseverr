package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.bobby.nfccardscanner.BuildConfig;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes.dex */
public class Debug {
    public static void logStack(String tag, String msg, int n) {
        StackTraceElement[] st = new Throwable().getStackTrace();
        String s = StringUtils.SPACE;
        int n2 = Math.min(n, st.length - 1);
        for (int i = 1; i <= n2; i++) {
            StackTraceElement stackTraceElement = st[i];
            String stack = ".(" + st[i].getFileName() + ":" + st[i].getLineNumber() + ") " + st[i].getMethodName();
            s = s + StringUtils.SPACE;
            Log.v(tag, msg + s + stack + s);
        }
    }

    public static void printStack(String msg, int n) {
        StackTraceElement[] st = new Throwable().getStackTrace();
        String s = StringUtils.SPACE;
        int n2 = Math.min(n, st.length - 1);
        for (int i = 1; i <= n2; i++) {
            StackTraceElement stackTraceElement = st[i];
            String stack = ".(" + st[i].getFileName() + ":" + st[i].getLineNumber() + ") ";
            s = s + StringUtils.SPACE;
            System.out.println(msg + s + stack + s);
        }
    }

    public static String getName(View view) {
        try {
            Context context = view.getContext();
            return context.getResources().getResourceEntryName(view.getId());
        } catch (Exception e) {
            return "UNKNOWN";
        }
    }

    public static void dumpPoc(Object obj) throws IllegalAccessException, SecurityException, IllegalArgumentException {
        StackTraceElement s = new Throwable().getStackTrace()[1];
        String loc = ".(" + s.getFileName() + ":" + s.getLineNumber() + ")";
        Class c = obj.getClass();
        System.out.println(loc + "------------- " + c.getName() + " --------------------");
        Field[] declaredFields = c.getFields();
        for (Field declaredField : declaredFields) {
            try {
                Object value = declaredField.get(obj);
                if (declaredField.getName().startsWith("layout_constraint") && ((!(value instanceof Integer) || !value.toString().equals("-1")) && ((!(value instanceof Integer) || !value.toString().equals("0")) && ((!(value instanceof Float) || !value.toString().equals(BuildConfig.VERSION_NAME)) && (!(value instanceof Float) || !value.toString().equals("0.5")))))) {
                    System.out.println(loc + "    " + declaredField.getName() + StringUtils.SPACE + value);
                }
            } catch (IllegalAccessException e) {
            }
        }
        System.out.println(loc + "------------- " + c.getSimpleName() + " --------------------");
    }

    public static String getName(Context context, int id) {
        if (id != -1) {
            try {
                return context.getResources().getResourceEntryName(id);
            } catch (Exception e) {
                return "?" + id;
            }
        }
        return "UNKNOWN";
    }

    public static String getName(Context context, int[] id) throws Resources.NotFoundException {
        String resourceEntryName;
        try {
            String str = id.length + "[";
            int i = 0;
            while (i < id.length) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(i == 0 ? "" : StringUtils.SPACE);
                String str2 = sb.toString();
                try {
                    resourceEntryName = context.getResources().getResourceEntryName(id[i]);
                } catch (Resources.NotFoundException e) {
                    resourceEntryName = "? " + id[i] + StringUtils.SPACE;
                }
                String tmp = resourceEntryName;
                str = str2 + tmp;
                i++;
            }
            return str + "]";
        } catch (Exception ex) {
            Log.v("DEBUG", ex.toString());
            return "UNKNOWN";
        }
    }

    public static String getState(MotionLayout layout, int stateId) {
        if (stateId == -1) {
            return "UNDEFINED";
        }
        Context context = layout.getContext();
        return context.getResources().getResourceEntryName(stateId);
    }

    public static String getActionType(MotionEvent event) throws SecurityException {
        int type = event.getAction();
        Field[] fields = MotionEvent.class.getFields();
        for (Field field : fields) {
            if (Modifier.isStatic(field.getModifiers()) && field.getType().equals(Integer.TYPE) && field.getInt(null) == type) {
                return field.getName();
            }
        }
        return "---";
    }

    public static String getLocation() {
        StackTraceElement s = new Throwable().getStackTrace()[1];
        return ".(" + s.getFileName() + ":" + s.getLineNumber() + ")";
    }

    public static String getLoc() {
        StackTraceElement s = new Throwable().getStackTrace()[1];
        return ".(" + s.getFileName() + ":" + s.getLineNumber() + ") " + s.getMethodName() + "()";
    }

    public static String getLocation2() {
        StackTraceElement s = new Throwable().getStackTrace()[2];
        return ".(" + s.getFileName() + ":" + s.getLineNumber() + ")";
    }

    public static String getCallFrom(int n) {
        StackTraceElement s = new Throwable().getStackTrace()[n + 2];
        return ".(" + s.getFileName() + ":" + s.getLineNumber() + ")";
    }

    public static void dumpLayoutParams(ViewGroup layout, String str) throws IllegalAccessException, SecurityException, IllegalArgumentException {
        StackTraceElement s = new Throwable().getStackTrace()[1];
        String loc = ".(" + s.getFileName() + ":" + s.getLineNumber() + ") " + str + "  ";
        int n = layout.getChildCount();
        System.out.println(str + " children " + n);
        for (int i = 0; i < n; i++) {
            View v = layout.getChildAt(i);
            System.out.println(loc + "     " + getName(v));
            ViewGroup.LayoutParams param = v.getLayoutParams();
            Field[] declaredFields = param.getClass().getFields();
            for (Field declaredField : declaredFields) {
                try {
                    Object value = declaredField.get(param);
                    String name = declaredField.getName();
                    if (name.contains("To") && !value.toString().equals("-1")) {
                        System.out.println(loc + "       " + declaredField.getName() + StringUtils.SPACE + value);
                    }
                } catch (IllegalAccessException e) {
                }
            }
        }
    }

    public static void dumpLayoutParams(ViewGroup.LayoutParams param, String str) throws IllegalAccessException, SecurityException, IllegalArgumentException {
        StackTraceElement s = new Throwable().getStackTrace()[1];
        String loc = ".(" + s.getFileName() + ":" + s.getLineNumber() + ") " + str + "  ";
        System.out.println(" >>>>>>>>>>>>>>>>>>. dump " + loc + "  " + param.getClass().getName());
        Field[] declaredFields = param.getClass().getFields();
        for (Field declaredField : declaredFields) {
            try {
                Object value = declaredField.get(param);
                String name = declaredField.getName();
                if (name.contains("To") && !value.toString().equals("-1")) {
                    System.out.println(loc + "       " + name + StringUtils.SPACE + value);
                }
            } catch (IllegalAccessException e) {
            }
        }
        System.out.println(" <<<<<<<<<<<<<<<<< dump " + loc);
    }
}
