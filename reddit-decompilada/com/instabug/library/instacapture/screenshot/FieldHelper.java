package com.instabug.library.instacapture.screenshot;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import com.instabug.library.util.InstabugSDKLogger;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class FieldHelper {
    private static final String FIELD_NAME_GLOBAL = "mGlobal";
    private static final String FIELD_NAME_PARAMS = "mParams";
    private static final String FIELD_NAME_ROOTS = "mRoots";
    private static final String FIELD_NAME_VIEW = "mView";
    private static final String FIELD_NAME_WINDOW_MANAGER = "mWindowManager";

    private FieldHelper() {
    }

    public static List<RootViewInfo> getRootViews(Activity activity, int[] iArr) {
        List<RootViewInfo> arrayList = new ArrayList();
        try {
            Object[] toArray;
            if (VERSION.SDK_INT >= 17) {
                activity = getFieldValue(FIELD_NAME_GLOBAL, activity.getWindowManager());
            } else {
                activity = getFieldValue(FIELD_NAME_WINDOW_MANAGER, activity.getWindowManager());
            }
            Object fieldValue = getFieldValue(FIELD_NAME_ROOTS, activity);
            activity = getFieldValue(FIELD_NAME_PARAMS, activity);
            if (VERSION.SDK_INT >= 19) {
                toArray = ((List) fieldValue).toArray();
                List list = (List) activity;
                activity = (LayoutParams[]) list.toArray(new LayoutParams[list.size()]);
            } else {
                toArray = (Object[]) fieldValue;
                activity = (LayoutParams[]) activity;
            }
            for (int i = 0; i < toArray.length; i++) {
                try {
                    View view = (View) getFieldValue(FIELD_NAME_VIEW, toArray[i]);
                    int i2;
                    if (iArr != null) {
                        int length = iArr.length;
                        int i3 = 0;
                        i2 = i3;
                        while (i3 < length) {
                            if (iArr[i3] == view.getId()) {
                                i2 = 1;
                            }
                            i3++;
                        }
                    } else {
                        i2 = 0;
                    }
                    if (view.getVisibility() == 0 && r7 == 0) {
                        arrayList.add(new RootViewInfo(view, activity[i]));
                    }
                } catch (Throwable e) {
                    InstabugSDKLogger.m8358e(FieldHelper.class, "Screenshot capturing failed in one of the viewRoots", e);
                }
            }
            return arrayList;
        } catch (Activity activity2) {
            InstabugSDKLogger.m8358e(FieldHelper.class, "Can't fine one of (WindowManager, rootObjects, paramsObject) field name so screenshot capturing failed", activity2);
            return arrayList;
        }
    }

    private static Object getFieldValue(String str, Object obj) throws NoSuchFieldException, IllegalAccessException {
        if (str.equals(FIELD_NAME_WINDOW_MANAGER)) {
            str = findField(str, obj.getClass());
        } else {
            str = obj.getClass().getDeclaredField(str);
        }
        str.setAccessible(true);
        return str.get(obj);
    }

    private static Field findField(String str, Class cls) throws NoSuchFieldException {
        for (Class cls2 = cls; cls2 != Object.class; cls2 = cls2.getSuperclass()) {
            for (Field field : cls2.getDeclaredFields()) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder("Field: ");
        stringBuilder.append(str);
        stringBuilder.append(" is not found in class: ");
        stringBuilder.append(cls.toString());
        throw new NoSuchFieldException(stringBuilder.toString());
    }
}
