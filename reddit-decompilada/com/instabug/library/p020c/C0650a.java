package com.instabug.library.p020c;

import com.instabug.library.C0660d;
import com.instabug.library.OnSdkDismissedCallback;
import com.instabug.library.bugreporting.model.ReportCategory;
import com.instabug.library.extendedbugreport.ExtendedBugReport.State;
import com.instabug.library.model.BugCategory;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/* compiled from: InstabugBugReporting */
public class C0650a {
    public static void m8119a(Runnable runnable) throws IllegalStateException {
        try {
            Method a = C0660d.m8162a(Class.forName("com.instabug.bug.InstabugBugReporting"), "setPreSendingRunnable");
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

    public static void m8116a(OnSdkDismissedCallback onSdkDismissedCallback) {
        try {
            Method a = C0660d.m8162a(Class.forName("com.instabug.bug.InstabugBugReporting"), "setLegacyOnSdkDismissedCallback");
            if (a != null) {
                a.invoke(null, new Object[]{onSdkDismissedCallback});
            }
        } catch (OnSdkDismissedCallback onSdkDismissedCallback2) {
            onSdkDismissedCallback2.printStackTrace();
        } catch (OnSdkDismissedCallback onSdkDismissedCallback22) {
            onSdkDismissedCallback22.printStackTrace();
        } catch (OnSdkDismissedCallback onSdkDismissedCallback222) {
            onSdkDismissedCallback222.printStackTrace();
        }
    }

    public static void m8121a(boolean z) {
        try {
            Method a = C0660d.m8162a(Class.forName("com.instabug.bug.InstabugBugReporting"), "setShouldSkipInitialScreenshotAnnotation");
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

    public static void m8125b(boolean z) {
        try {
            Method a = C0660d.m8162a(Class.forName("com.instabug.bug.InstabugBugReporting"), "setEmailFieldRequired");
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

    public static void m8126c(boolean z) {
        try {
            Method a = C0660d.m8162a(Class.forName("com.instabug.bug.InstabugBugReporting"), "setCommentFieldRequired");
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

    public static void m8127d(boolean z) {
        try {
            Method a = C0660d.m8162a(Class.forName("com.instabug.bug.InstabugBugReporting"), "setEmailFieldVisibility");
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

    public static void m8122a(boolean z, boolean z2, boolean z3, boolean z4) {
        try {
            Method a = C0660d.m8162a(Class.forName("com.instabug.bug.InstabugBugReporting"), "setAttachmentTypesEnabled");
            if (a != null) {
                a.invoke(null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)});
            }
        } catch (boolean z5) {
            z5.printStackTrace();
        } catch (boolean z52) {
            z52.printStackTrace();
        } catch (boolean z522) {
            z522.printStackTrace();
        }
    }

    public static void m8120a(List<BugCategory> list) {
        try {
            Method a = C0660d.m8162a(Class.forName("com.instabug.bug.InstabugBugReporting"), "setLegacyBugCategories");
            if (a != null) {
                a.invoke(null, new Object[]{list});
            }
        } catch (List<BugCategory> list2) {
            list2.printStackTrace();
        } catch (List<BugCategory> list22) {
            list22.printStackTrace();
        } catch (List<BugCategory> list222) {
            list222.printStackTrace();
        }
    }

    public static void m8124b(List<ReportCategory> list) {
        try {
            Method a = C0660d.m8162a(Class.forName("com.instabug.bug.InstabugBugReporting"), "setLegacyReportCategories");
            if (a != null) {
                a.invoke(null, new Object[]{list});
            }
        } catch (List<ReportCategory> list2) {
            list2.printStackTrace();
        } catch (List<ReportCategory> list22) {
            list22.printStackTrace();
        } catch (List<ReportCategory> list222) {
            list222.printStackTrace();
        }
    }

    public static void m8128e(boolean z) {
        try {
            Method a = C0660d.m8162a(Class.forName("com.instabug.bug.InstabugBugReporting"), "setSuccessDialogEnabled");
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

    public static Runnable m8115a() {
        try {
            Method a = C0660d.m8162a(Class.forName("com.instabug.bug.InstabugBugReporting"), "getPreReportRunnable");
            if (a != null) {
                return (Runnable) a.invoke(null, new Object[0]);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e2) {
            e2.printStackTrace();
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        }
        return null;
    }

    public static void m8118a(CharSequence charSequence, boolean z) {
        try {
            Method a = C0660d.m8162a(Class.forName("com.instabug.bug.InstabugBugReporting"), "addExtraReportField");
            if (a != null) {
                a.invoke(null, new Object[]{charSequence, Boolean.valueOf(z)});
            }
        } catch (CharSequence charSequence2) {
            charSequence2.printStackTrace();
        } catch (CharSequence charSequence22) {
            charSequence22.printStackTrace();
        } catch (CharSequence charSequence222) {
            charSequence222.printStackTrace();
        }
    }

    public static void m8123b() {
        try {
            Method a = C0660d.m8162a(Class.forName("com.instabug.bug.InstabugBugReporting"), "clearExtraReportFields");
            if (a != null) {
                a.invoke(null, new Object[0]);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e2) {
            e2.printStackTrace();
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        }
    }

    public static void m8117a(State state) {
        try {
            Method a = C0660d.m8162a(Class.forName("com.instabug.bug.InstabugBugReporting"), "setExtendedBugReportState");
            if (a != null) {
                a.invoke(null, new Object[]{state});
            }
        } catch (State state2) {
            state2.printStackTrace();
        } catch (State state22) {
            state22.printStackTrace();
        } catch (State state222) {
            state222.printStackTrace();
        }
    }
}
