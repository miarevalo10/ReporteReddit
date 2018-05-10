package com.firebase.jobdispatcher;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import com.firebase.jobdispatcher.JobTrigger.ContentUriTrigger;
import com.firebase.jobdispatcher.JobTrigger.ExecutionWindowTrigger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class DefaultJobValidator implements JobValidator {
    private final Context f12695a;

    public DefaultJobValidator(Context context) {
        this.f12695a = context;
    }

    private static List<String> m11786a(List<String> list, List<String> list2) {
        if (list == null) {
            return list2;
        }
        if (list2 == null) {
            return list;
        }
        list.addAll(list2);
        return list;
    }

    private static List<String> m11785a(List<String> list, String str) {
        if (str == null) {
            return list;
        }
        if (list == null) {
            return m11784a(str);
        }
        Collections.addAll(list, new String[]{str});
        return list;
    }

    private static List<String> m11787a(boolean z, List<String> list, String str) {
        return z ? m11785a((List) list, str) : list;
    }

    public final List<String> mo1240a(JobParameters jobParameters) {
        List list;
        List a;
        List list2;
        Object obj;
        String format;
        Class cls;
        String e;
        PackageManager packageManager;
        List<ResolveInfo> queryIntentServices;
        StringBuilder stringBuilder;
        JobTrigger f = jobParameters.mo1250f();
        List list3 = null;
        if (f == Trigger.f3883a || (f instanceof ExecutionWindowTrigger) || (f instanceof ContentUriTrigger)) {
            list = null;
        } else {
            list = m11784a("Unknown trigger provided");
        }
        list = m11786a(null, list);
        RetryStrategy c = jobParameters.mo1247c();
        int i = c.f3880c;
        int i2 = c.f3881d;
        int i3 = c.f3882e;
        boolean z = (i == 1 || i == 2) ? false : true;
        list = m11786a(list, m11787a(i2 < 30, m11787a(300 > i3, m11787a(i3 < i2, m11787a(z, null, "Unknown retry policy provided"), "Maximum backoff must be greater than or equal to initial backoff"), "Maximum backoff must be greater than 300s (5 minutes)"), "Initial backoff must be at least 30s"));
        if (jobParameters.mo1252h() && jobParameters.mo1250f() == Trigger.f3883a) {
            list = m11785a(list, "ImmediateTriggers can't be used with recurring jobs");
        }
        Bundle b = jobParameters.mo1246b();
        if (b != null) {
            Parcel obtain = Parcel.obtain();
            b.writeToParcel(obtain, 0);
            i3 = obtain.dataSize();
            obtain.recycle();
            if (i3 > 10240) {
                a = m11784a(String.format(Locale.US, "Extras too large: %d bytes is > the max (%d bytes)", new Object[]{Integer.valueOf(i3), Integer.valueOf(10240)}));
                list = m11786a(list, a);
                if (jobParameters.mo1251g() > 1) {
                    b = jobParameters.mo1246b();
                    if (b == null) {
                        list2 = null;
                        for (String format2 : b.keySet()) {
                            obj = b.get(format2);
                            if (!(obj == null || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Double) || (obj instanceof String))) {
                                if (obj instanceof Boolean) {
                                    Locale locale = Locale.US;
                                    String str = "Received value of type '%s' for key '%s', but only the following extra parameter types are supported: Integer, Long, Double, String, and Boolean";
                                    Object[] objArr = new Object[2];
                                    if (obj != null) {
                                        cls = null;
                                    } else {
                                        cls = obj.getClass();
                                    }
                                    objArr[0] = cls;
                                    objArr[1] = format2;
                                    format2 = String.format(locale, str, objArr);
                                    list2 = m11785a(list2, format2);
                                }
                            }
                            format2 = null;
                            list2 = m11785a(list2, format2);
                        }
                    } else {
                        list2 = null;
                    }
                    list = m11786a(list, list2);
                }
                e = jobParameters.mo1249e();
                if (e == null) {
                    a = m11784a("Tag can't be null");
                } else if (e.length() <= 100) {
                    a = m11784a("Tag must be shorter than 100");
                } else {
                    a = null;
                }
                list = m11786a(list, a);
                jobParameters = jobParameters.mo1253i();
                if (jobParameters != null) {
                    if (jobParameters.isEmpty()) {
                        if (this.f12695a != null) {
                            list3 = m11784a("Context is null, can't query PackageManager");
                        } else {
                            packageManager = this.f12695a.getPackageManager();
                            if (packageManager != null) {
                                list3 = m11784a("PackageManager is null, can't validate service");
                            } else {
                                Intent intent = new Intent("com.firebase.jobdispatcher.ACTION_EXECUTE");
                                intent.setClassName(this.f12695a, jobParameters);
                                queryIntentServices = packageManager.queryIntentServices(intent, 0);
                                if (queryIntentServices != null) {
                                    if (queryIntentServices.isEmpty()) {
                                        for (ResolveInfo resolveInfo : queryIntentServices) {
                                            if (resolveInfo.serviceInfo == null && resolveInfo.serviceInfo.enabled) {
                                                break;
                                            }
                                        }
                                        stringBuilder = new StringBuilder();
                                        stringBuilder.append(jobParameters);
                                        stringBuilder.append(" is disabled.");
                                        list3 = m11784a(stringBuilder.toString());
                                    }
                                }
                                stringBuilder = new StringBuilder("Couldn't find a registered service with the name ");
                                stringBuilder.append(jobParameters);
                                stringBuilder.append(". Is it declared in the manifest with the right intent-filter? If not, the job won't be started.");
                                Log.e("FJD.GooglePlayReceiver", stringBuilder.toString());
                            }
                        }
                        return m11786a(list, list3);
                    }
                }
                list3 = m11784a("Service can't be empty");
                return m11786a(list, list3);
            }
        }
        a = null;
        list = m11786a(list, a);
        if (jobParameters.mo1251g() > 1) {
            b = jobParameters.mo1246b();
            if (b == null) {
                list2 = null;
            } else {
                list2 = null;
                for (String format22 : b.keySet()) {
                    obj = b.get(format22);
                    if (obj instanceof Boolean) {
                        Locale locale2 = Locale.US;
                        String str2 = "Received value of type '%s' for key '%s', but only the following extra parameter types are supported: Integer, Long, Double, String, and Boolean";
                        Object[] objArr2 = new Object[2];
                        if (obj != null) {
                            cls = obj.getClass();
                        } else {
                            cls = null;
                        }
                        objArr2[0] = cls;
                        objArr2[1] = format22;
                        format22 = String.format(locale2, str2, objArr2);
                        list2 = m11785a(list2, format22);
                    } else {
                        format22 = null;
                        list2 = m11785a(list2, format22);
                    }
                }
            }
            list = m11786a(list, list2);
        }
        e = jobParameters.mo1249e();
        if (e == null) {
            a = m11784a("Tag can't be null");
        } else if (e.length() <= 100) {
            a = null;
        } else {
            a = m11784a("Tag must be shorter than 100");
        }
        list = m11786a(list, a);
        jobParameters = jobParameters.mo1253i();
        if (jobParameters != null) {
            if (jobParameters.isEmpty()) {
                if (this.f12695a != null) {
                    packageManager = this.f12695a.getPackageManager();
                    if (packageManager != null) {
                        Intent intent2 = new Intent("com.firebase.jobdispatcher.ACTION_EXECUTE");
                        intent2.setClassName(this.f12695a, jobParameters);
                        queryIntentServices = packageManager.queryIntentServices(intent2, 0);
                        if (queryIntentServices != null) {
                            if (queryIntentServices.isEmpty()) {
                                for (ResolveInfo resolveInfo2 : queryIntentServices) {
                                    if (resolveInfo2.serviceInfo == null) {
                                    }
                                }
                                stringBuilder = new StringBuilder();
                                stringBuilder.append(jobParameters);
                                stringBuilder.append(" is disabled.");
                                list3 = m11784a(stringBuilder.toString());
                            }
                        }
                        stringBuilder = new StringBuilder("Couldn't find a registered service with the name ");
                        stringBuilder.append(jobParameters);
                        stringBuilder.append(". Is it declared in the manifest with the right intent-filter? If not, the job won't be started.");
                        Log.e("FJD.GooglePlayReceiver", stringBuilder.toString());
                    } else {
                        list3 = m11784a("PackageManager is null, can't validate service");
                    }
                } else {
                    list3 = m11784a("Context is null, can't query PackageManager");
                }
                return m11786a(list, list3);
            }
        }
        list3 = m11784a("Service can't be empty");
        return m11786a(list, list3);
    }

    private static List<String> m11784a(String str) {
        List arrayList = new ArrayList();
        arrayList.add(str);
        return arrayList;
    }
}
