package com.instabug.library.p020c;

import android.os.Bundle;
import com.instabug.library.C0660d;
import com.instabug.library.OnSdkDismissedCallback;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/* compiled from: InstabugChat */
public class C0651b {
    public static void m8132a(Runnable runnable) throws IllegalStateException {
        try {
            Method a = C0660d.m8162a(Class.forName("com.instabug.chat.InstabugChat"), "setNewMessageHandler");
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

    public static int m8129a() throws IllegalStateException {
        try {
            Method a = C0660d.m8162a(Class.forName("com.instabug.chat.InstabugChat"), "getUnreadMessagesCount");
            if (a != null) {
                return ((Integer) a.invoke(null, new Object[0])).intValue();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e2) {
            e2.printStackTrace();
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        }
        return 0;
    }

    public static boolean m8136a(Bundle bundle) {
        try {
            Method a = C0660d.m8163a(Class.forName("com.instabug.chat.InstabugChat"), "isInstabugNotification", Bundle.class);
            if (a != null) {
                return ((Boolean) a.invoke(null, new Object[]{bundle})).booleanValue();
            }
        } catch (Bundle bundle2) {
            bundle2.printStackTrace();
        } catch (Bundle bundle22) {
            bundle22.printStackTrace();
        } catch (Bundle bundle222) {
            bundle222.printStackTrace();
        }
        return false;
    }

    public static boolean m8137a(Map<String, String> map) {
        try {
            Method a = C0660d.m8163a(Class.forName("com.instabug.chat.InstabugChat"), "isInstabugNotification", Map.class);
            if (a != null) {
                return ((Boolean) a.invoke(null, new Object[]{map})).booleanValue();
            }
        } catch (Map<String, String> map2) {
            map2.printStackTrace();
        } catch (Map<String, String> map22) {
            map22.printStackTrace();
        } catch (Map<String, String> map222) {
            map222.printStackTrace();
        }
        return false;
    }

    public static void m8139b(Bundle bundle) {
        try {
            Method a = C0660d.m8163a(Class.forName("com.instabug.chat.InstabugChat"), "showNotification", Bundle.class);
            if (a != null) {
                a.invoke(null, new Object[]{bundle});
            }
        } catch (Bundle bundle2) {
            bundle2.printStackTrace();
        } catch (Bundle bundle22) {
            bundle22.printStackTrace();
        } catch (Bundle bundle222) {
            bundle222.printStackTrace();
        }
    }

    public static void m8140b(Map<String, String> map) {
        try {
            Method a = C0660d.m8163a(Class.forName("com.instabug.chat.InstabugChat"), "showNotification", Map.class);
            if (a != null) {
                a.invoke(null, new Object[]{map});
            }
        } catch (Map<String, String> map2) {
            map2.printStackTrace();
        } catch (Map<String, String> map22) {
            map22.printStackTrace();
        } catch (Map<String, String> map222) {
            map222.printStackTrace();
        }
    }

    public static void m8134a(boolean z) {
        try {
            Method a = C0660d.m8162a(Class.forName("com.instabug.chat.InstabugChat"), "enableNotification");
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

    public static void m8133a(String str) {
        try {
            Method a = C0660d.m8162a(Class.forName("com.instabug.chat.InstabugChat"), "setPushNotificationRegistrationToken");
            if (a != null) {
                a.invoke(null, new Object[]{str});
            }
        } catch (String str2) {
            str2.printStackTrace();
        } catch (String str22) {
            str22.printStackTrace();
        } catch (String str222) {
            str222.printStackTrace();
        }
    }

    public static void m8141b(boolean z) {
        try {
            Method a = C0660d.m8162a(Class.forName("com.instabug.chat.InstabugChat"), "enableConversationSound");
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

    public static void m8142c(boolean z) {
        try {
            Method a = C0660d.m8162a(Class.forName("com.instabug.chat.InstabugChat"), "enableSystemNotificationSound");
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

    public static void m8143d(boolean z) {
        try {
            Method a = C0660d.m8162a(Class.forName("com.instabug.chat.InstabugChat"), "enableInAppNotificationSound");
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

    public static void m8130a(int i) {
        try {
            Method a = C0660d.m8162a(Class.forName("com.instabug.chat.InstabugChat"), "setNotificationIcon");
            if (a != null) {
                a.invoke(null, new Object[]{Integer.valueOf(i)});
            }
        } catch (int i2) {
            i2.printStackTrace();
        } catch (int i22) {
            i22.printStackTrace();
        } catch (int i222) {
            i222.printStackTrace();
        }
    }

    public static void m8135a(boolean z, boolean z2, boolean z3) {
        try {
            Method a = C0660d.m8162a(Class.forName("com.instabug.chat.InstabugChat"), "setAttachmentTypesEnabled");
            if (a != null) {
                a.invoke(null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)});
            }
        } catch (boolean z4) {
            z4.printStackTrace();
        } catch (boolean z42) {
            z42.printStackTrace();
        } catch (boolean z422) {
            z422.printStackTrace();
        }
    }

    public static void m8138b() {
        try {
            Method a = C0660d.m8162a(Class.forName("com.instabug.chat.InstabugChat"), "openNewChat");
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

    public static void m8144e(boolean z) {
        try {
            Method a = C0660d.m8162a(Class.forName("com.instabug.chat.InstabugChat"), "skipImageAttachmentAnnotation");
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

    public static void m8131a(OnSdkDismissedCallback onSdkDismissedCallback) {
        try {
            Method a = C0660d.m8162a(Class.forName("com.instabug.chat.InstabugChat"), "setOnSdkDismissedCallback");
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
}
