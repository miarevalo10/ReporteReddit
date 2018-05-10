package com.instabug.library.p020c;

import com.instabug.library.C0660d;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: InstabugSurvey */
public class C0653d {
    public static boolean m8149a() {
        try {
            Method a = C0660d.m8162a(Class.forName("com.instabug.survey.InstabugSurvey"), "showValidSurvey");
            if (a != null) {
                return ((Boolean) a.invoke(null, new Object[0])).booleanValue();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e2) {
            e2.printStackTrace();
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        }
        return false;
    }

    public static boolean m8152b() {
        try {
            Method a = C0660d.m8162a(Class.forName("com.instabug.survey.InstabugSurvey"), "hasValidSurveys");
            if (a != null) {
                return ((Boolean) a.invoke(null, new Object[0])).booleanValue();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e2) {
            e2.printStackTrace();
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        }
        return false;
    }

    public static void m8147a(Runnable runnable) {
        try {
            Method a = C0660d.m8162a(Class.forName("com.instabug.survey.InstabugSurvey"), "setPreShowingSurveyRunnable");
            if (a != null) {
                a.invoke(null, new Object[]{runnable});
            }
        } catch (Runnable runnable2) {
            runnable2.printStackTrace();
        } catch (Runnable runnable22) {
            runnable22.printStackTrace();
        } catch (Runnable runnable222) {
            runnable222.printStackTrace();
        }
    }

    public static void m8151b(Runnable runnable) {
        try {
            Method a = C0660d.m8162a(Class.forName("com.instabug.survey.InstabugSurvey"), "setAfterShowingSurveyRunnable");
            if (a != null) {
                a.invoke(null, new Object[]{runnable});
            }
        } catch (Runnable runnable2) {
            runnable2.printStackTrace();
        } catch (Runnable runnable22) {
            runnable22.printStackTrace();
        } catch (Runnable runnable222) {
            runnable222.printStackTrace();
        }
    }

    public static void m8148a(boolean z) {
        try {
            Method a = C0660d.m8162a(Class.forName("com.instabug.survey.InstabugSurvey"), "setSurveysAutoShowing");
            if (a != null) {
                a.invoke(null, new Object[]{Boolean.valueOf(z)});
            }
        } catch (boolean z2) {
            z2.printStackTrace();
        } catch (boolean z22) {
            z22.printStackTrace();
        } catch (boolean z222) {
            z222.printStackTrace();
        }
    }

    public static boolean m8150a(String str) {
        try {
            Method a = C0660d.m8162a(Class.forName("com.instabug.survey.InstabugSurvey"), "showSurvey");
            if (a != null) {
                return ((Boolean) a.invoke(null, new Object[]{str})).booleanValue();
            }
        } catch (String str2) {
            str2.printStackTrace();
        } catch (String str22) {
            str22.printStackTrace();
        } catch (String str222) {
            str222.printStackTrace();
        }
        return false;
    }

    public static boolean m8153b(String str) {
        try {
            Method a = C0660d.m8162a(Class.forName("com.instabug.survey.InstabugSurvey"), "hasRespondToSurvey");
            if (a != null) {
                return ((Boolean) a.invoke(null, new Object[]{str})).booleanValue();
            }
        } catch (String str2) {
            str2.printStackTrace();
        } catch (String str22) {
            str22.printStackTrace();
        } catch (String str222) {
            str222.printStackTrace();
        }
        return false;
    }
}
