package com.instabug.library.internal.storage.cache;

import android.content.Context;
import android.text.TextUtils;
import com.instabug.library.util.InstabugSDKLogger;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class OnDiskCache<V extends Cacheable> extends Cache<String, V> {
    private Class<V> VClass;
    private final File cacheDir;
    private final File cacheFile;
    private final Charset charset;

    public OnDiskCache(Context context, String str, String str2, Class<V> cls) {
        super(str);
        this.VClass = cls;
        this.cacheDir = context.getCacheDir();
        str = new StringBuilder();
        str.append(this.cacheDir);
        str.append(str2);
        this.cacheFile = new File(str.toString());
        if (this.cacheFile.exists() == null) {
            try {
                this.cacheFile.createNewFile();
            } catch (Context context2) {
                InstabugSDKLogger.m8358e(this, "Failed to create", context2);
            }
        }
        if (Charset.isSupported("UTF-8") != null) {
            this.charset = Charset.forName("UTF-8");
        } else {
            this.charset = Charset.defaultCharset();
        }
        if (checkCacheValidity() == null) {
            invalidate();
        }
    }

    public List<V> getValues() {
        BufferedReader bufferedReader;
        Throwable e;
        String str;
        Throwable th;
        Throwable th2;
        List<V> arrayList = new ArrayList();
        if (this.cacheFile.exists()) {
            synchronized (this.cacheFile) {
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(this.cacheFile), this.charset));
                    String readLine;
                    do {
                        try {
                            readLine = bufferedReader.readLine();
                            String value = getValue(readLine);
                            if (!(value == null || value.isEmpty())) {
                                Cacheable cacheable = (Cacheable) this.VClass.newInstance();
                                cacheable.fromJson(getValue(readLine));
                                arrayList.add(cacheable);
                                continue;
                            }
                        } catch (InstantiationException e2) {
                            e = e2;
                        } catch (IllegalAccessException e3) {
                            e = e3;
                        } catch (IOException e4) {
                            e = e4;
                        } catch (JSONException e5) {
                            e = e5;
                        }
                    } while (readLine != null);
                    try {
                        bufferedReader.close();
                    } catch (IOException e6) {
                        e = e6;
                        str = "Failed to close file reader";
                        InstabugSDKLogger.m8358e(this, str, e);
                        return arrayList;
                    }
                } catch (Throwable e7) {
                    th = e7;
                    bufferedReader = null;
                    e = th;
                    InstabugSDKLogger.m8358e(this, "InstantiationException happened while fetching values", e);
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e8) {
                            e = e8;
                            str = "Failed to close file reader";
                            InstabugSDKLogger.m8358e(this, str, e);
                            return arrayList;
                        }
                    }
                    return arrayList;
                } catch (Throwable e72) {
                    th = e72;
                    bufferedReader = null;
                    e = th;
                    InstabugSDKLogger.m8358e(this, "IllegalAccessException went wrong while fetching", e);
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e9) {
                            e = e9;
                            str = "Failed to close file reader";
                            InstabugSDKLogger.m8358e(this, str, e);
                            return arrayList;
                        }
                    }
                    return arrayList;
                } catch (Throwable e722) {
                    th = e722;
                    bufferedReader = null;
                    e = th;
                    InstabugSDKLogger.m8358e(this, "IOException went wrong while fetching values", e);
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e10) {
                            e = e10;
                            str = "Failed to close file reader";
                            InstabugSDKLogger.m8358e(this, str, e);
                            return arrayList;
                        }
                    }
                    return arrayList;
                } catch (Throwable e7222) {
                    th = e7222;
                    bufferedReader = null;
                    e = th;
                    try {
                        InstabugSDKLogger.m8358e(this, "JSONException went wrong while fetching values", e);
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e11) {
                                e = e11;
                                str = "Failed to close file reader";
                                InstabugSDKLogger.m8358e(this, str, e);
                                return arrayList;
                            }
                        }
                        return arrayList;
                    } catch (Throwable th3) {
                        th2 = th3;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable e12) {
                                InstabugSDKLogger.m8358e(this, "Failed to close file reader", e12);
                            }
                        }
                        throw th2;
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    bufferedReader = null;
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    throw th2;
                }
            }
            return arrayList;
        }
        InstabugSDKLogger.m8356d(this, "Cache file doesn't exist");
        return arrayList;
    }

    public V get(String str) {
        V v;
        StringBuilder stringBuilder;
        Throwable e;
        BufferedReader bufferedReader;
        String readLine;
        String key;
        OutOfMemoryError e2;
        String str2;
        StringBuilder stringBuilder2;
        StringBuilder stringBuilder3;
        if (str == null) {
            InstabugSDKLogger.m8356d(this, "Key equal null");
            return null;
        } else if (this.cacheFile.exists()) {
            try {
                v = (Cacheable) this.VClass.newInstance();
            } catch (Throwable e3) {
                stringBuilder = new StringBuilder("InstantiationException happened while fetching value for key ");
                stringBuilder.append(str);
                InstabugSDKLogger.m8358e(this, stringBuilder.toString(), e3);
                v = null;
                synchronized (this.cacheFile) {
                    try {
                        bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(this.cacheFile), this.charset));
                        do {
                            try {
                                readLine = bufferedReader.readLine();
                                key = getKey(readLine);
                                if (key != null) {
                                }
                            } catch (IOException e4) {
                                e3 = e4;
                            } catch (JSONException e5) {
                                e3 = e5;
                            } catch (OutOfMemoryError e6) {
                                e2 = e6;
                            }
                        } while (readLine != null);
                        try {
                            bufferedReader.close();
                        } catch (IOException e7) {
                            e3 = e7;
                            str2 = "Failed to close file reader";
                            InstabugSDKLogger.m8358e(this, str2, e3);
                            stringBuilder2 = new StringBuilder("No value found for key ");
                            stringBuilder2.append(str);
                            stringBuilder2.append(", returning null");
                            InstabugSDKLogger.m8356d(this, stringBuilder2.toString());
                            return null;
                        }
                    } catch (IOException e8) {
                        e3 = e8;
                        bufferedReader = null;
                        stringBuilder3 = new StringBuilder("IOException went wrong while fetching value for key ");
                        stringBuilder3.append(str);
                        InstabugSDKLogger.m8358e(this, stringBuilder3.toString(), e3);
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e9) {
                                e3 = e9;
                                str2 = "Failed to close file reader";
                                InstabugSDKLogger.m8358e(this, str2, e3);
                                stringBuilder2 = new StringBuilder("No value found for key ");
                                stringBuilder2.append(str);
                                stringBuilder2.append(", returning null");
                                InstabugSDKLogger.m8356d(this, stringBuilder2.toString());
                                return null;
                            }
                        }
                        stringBuilder2 = new StringBuilder("No value found for key ");
                        stringBuilder2.append(str);
                        stringBuilder2.append(", returning null");
                        InstabugSDKLogger.m8356d(this, stringBuilder2.toString());
                        return null;
                    } catch (JSONException e10) {
                        e3 = e10;
                        bufferedReader = null;
                        stringBuilder3 = new StringBuilder("JSONException went wrong while fetching value for key ");
                        stringBuilder3.append(str);
                        InstabugSDKLogger.m8358e(this, stringBuilder3.toString(), e3);
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e11) {
                                e3 = e11;
                                str2 = "Failed to close file reader";
                                InstabugSDKLogger.m8358e(this, str2, e3);
                                stringBuilder2 = new StringBuilder("No value found for key ");
                                stringBuilder2.append(str);
                                stringBuilder2.append(", returning null");
                                InstabugSDKLogger.m8356d(this, stringBuilder2.toString());
                                return null;
                            }
                        }
                        stringBuilder2 = new StringBuilder("No value found for key ");
                        stringBuilder2.append(str);
                        stringBuilder2.append(", returning null");
                        InstabugSDKLogger.m8356d(this, stringBuilder2.toString());
                        return null;
                    } catch (OutOfMemoryError e12) {
                        e2 = e12;
                        bufferedReader = null;
                        try {
                            stringBuilder3 = new StringBuilder("OOM while fetching value for key ");
                            stringBuilder3.append(str);
                            InstabugSDKLogger.m8357e(stringBuilder3.toString(), e2.toString());
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e13) {
                                    e3 = e13;
                                    str2 = "Failed to close file reader";
                                    InstabugSDKLogger.m8358e(this, str2, e3);
                                    stringBuilder2 = new StringBuilder("No value found for key ");
                                    stringBuilder2.append(str);
                                    stringBuilder2.append(", returning null");
                                    InstabugSDKLogger.m8356d(this, stringBuilder2.toString());
                                    return null;
                                }
                            }
                            stringBuilder2 = new StringBuilder("No value found for key ");
                            stringBuilder2.append(str);
                            stringBuilder2.append(", returning null");
                            InstabugSDKLogger.m8356d(this, stringBuilder2.toString());
                            return null;
                        } catch (Throwable th) {
                            str = th;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Throwable e14) {
                                    InstabugSDKLogger.m8358e(this, "Failed to close file reader", e14);
                                }
                            }
                            throw str;
                        }
                    } catch (Throwable th2) {
                        str = th2;
                        bufferedReader = null;
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        throw str;
                    }
                    stringBuilder2 = new StringBuilder("No value found for key ");
                    stringBuilder2.append(str);
                    stringBuilder2.append(", returning null");
                    InstabugSDKLogger.m8356d(this, stringBuilder2.toString());
                    return null;
                }
            } catch (Throwable e32) {
                stringBuilder = new StringBuilder("IllegalAccessException went wrong while fetching value for key ");
                stringBuilder.append(str);
                InstabugSDKLogger.m8358e(this, stringBuilder.toString(), e32);
                v = null;
                synchronized (this.cacheFile) {
                    bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(this.cacheFile), this.charset));
                    do {
                        readLine = bufferedReader.readLine();
                        key = getKey(readLine);
                        if (key != null) {
                        }
                    } while (readLine != null);
                    bufferedReader.close();
                    stringBuilder2 = new StringBuilder("No value found for key ");
                    stringBuilder2.append(str);
                    stringBuilder2.append(", returning null");
                    InstabugSDKLogger.m8356d(this, stringBuilder2.toString());
                    return null;
                }
            }
            synchronized (this.cacheFile) {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(this.cacheFile), this.charset));
                do {
                    readLine = bufferedReader.readLine();
                    key = getKey(readLine);
                    if (key != null && key.equals(str)) {
                        v.fromJson(getValue(readLine));
                        try {
                            bufferedReader.close();
                        } catch (String str3) {
                            InstabugSDKLogger.m8358e(this, "Failed to close file reader", str3);
                        }
                    }
                } while (readLine != null);
                bufferedReader.close();
                stringBuilder2 = new StringBuilder("No value found for key ");
                stringBuilder2.append(str3);
                stringBuilder2.append(", returning null");
                InstabugSDKLogger.m8356d(this, stringBuilder2.toString());
                return null;
            }
        } else {
            InstabugSDKLogger.m8356d(this, "Cache file doesn't exist");
            return null;
        }
        return v;
    }

    public V put(String str, V v) {
        Throwable e;
        StringBuilder stringBuilder;
        String str2;
        OutOfMemoryError e2;
        OutputStreamWriter outputStreamWriter = null;
        if (str == null) {
            InstabugSDKLogger.m8356d(this, "Key equal null");
            return null;
        } else if (v == null) {
            InstabugSDKLogger.m8356d(this, "Value equal null");
            return null;
        } else if (this.cacheFile.exists()) {
            V v2 = get(str);
            if (v2 != null) {
                delete(str);
            }
            synchronized (this.cacheFile) {
                OutputStreamWriter outputStreamWriter2;
                try {
                    outputStreamWriter2 = new OutputStreamWriter(new FileOutputStream(this.cacheFile, true), this.charset);
                    try {
                        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter2);
                        bufferedWriter.append(str).append(":").append(v.toJson()).append("\n");
                        bufferedWriter.close();
                    } catch (IOException e3) {
                        e = e3;
                        stringBuilder = new StringBuilder("Something went wrong while setting value for key ");
                        stringBuilder.append(str);
                        InstabugSDKLogger.m8358e(this, stringBuilder.toString(), e);
                        if (outputStreamWriter2 != null) {
                            try {
                                outputStreamWriter2.close();
                            } catch (IOException e4) {
                                str = e4;
                                str2 = "Failed to close file writer";
                                InstabugSDKLogger.m8358e(this, str2, str);
                                return v2 != null ? v : v2;
                            }
                        }
                        if (v2 != null) {
                        }
                    } catch (JSONException e5) {
                        str = e5;
                        outputStreamWriter = outputStreamWriter2;
                        try {
                            str.printStackTrace();
                            if (outputStreamWriter != null) {
                                try {
                                    outputStreamWriter.close();
                                } catch (IOException e6) {
                                    str = e6;
                                    str2 = "Failed to close file writer";
                                    InstabugSDKLogger.m8358e(this, str2, str);
                                    if (v2 != null) {
                                    }
                                }
                            }
                            if (v2 != null) {
                            }
                        } catch (Throwable th) {
                            str = th;
                            outputStreamWriter2 = outputStreamWriter;
                            if (outputStreamWriter2 != null) {
                                try {
                                    outputStreamWriter2.close();
                                } catch (V v3) {
                                    InstabugSDKLogger.m8358e(this, "Failed to close file writer", v3);
                                }
                            }
                            throw str;
                        }
                    } catch (OutOfMemoryError e7) {
                        e2 = e7;
                        try {
                            stringBuilder = new StringBuilder("OOM while while setting value for key ");
                            stringBuilder.append(str);
                            InstabugSDKLogger.m8357e(stringBuilder.toString(), e2.toString());
                            if (outputStreamWriter2 != null) {
                                try {
                                    outputStreamWriter2.close();
                                } catch (IOException e8) {
                                    str = e8;
                                    str2 = "Failed to close file writer";
                                    InstabugSDKLogger.m8358e(this, str2, str);
                                    if (v2 != null) {
                                    }
                                }
                            }
                            if (v2 != null) {
                            }
                        } catch (Throwable th2) {
                            str = th2;
                            if (outputStreamWriter2 != null) {
                                outputStreamWriter2.close();
                            }
                            throw str;
                        }
                    }
                    try {
                        outputStreamWriter2.close();
                    } catch (IOException e9) {
                        str = e9;
                        str2 = "Failed to close file writer";
                        InstabugSDKLogger.m8358e(this, str2, str);
                        if (v2 != null) {
                        }
                    }
                } catch (Throwable e10) {
                    Throwable th3 = e10;
                    outputStreamWriter2 = null;
                    e = th3;
                    stringBuilder = new StringBuilder("Something went wrong while setting value for key ");
                    stringBuilder.append(str);
                    InstabugSDKLogger.m8358e(this, stringBuilder.toString(), e);
                    if (outputStreamWriter2 != null) {
                        outputStreamWriter2.close();
                    }
                    if (v2 != null) {
                    }
                } catch (JSONException e11) {
                    str = e11;
                    str.printStackTrace();
                    if (outputStreamWriter != null) {
                        outputStreamWriter.close();
                    }
                    if (v2 != null) {
                    }
                } catch (OutOfMemoryError e12) {
                    OutOfMemoryError outOfMemoryError = e12;
                    outputStreamWriter2 = null;
                    e2 = outOfMemoryError;
                    stringBuilder = new StringBuilder("OOM while while setting value for key ");
                    stringBuilder.append(str);
                    InstabugSDKLogger.m8357e(stringBuilder.toString(), e2.toString());
                    if (outputStreamWriter2 != null) {
                        outputStreamWriter2.close();
                    }
                    if (v2 != null) {
                    }
                }
            }
            if (v2 != null) {
            }
        } else {
            InstabugSDKLogger.m8356d(this, "Cache file doesn't exist");
            return null;
        }
    }

    public V delete(String str) {
        StringBuilder stringBuilder;
        V v = null;
        if (this.cacheFile.exists()) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(this.cacheDir);
            stringBuilder2.append("/cache.tmp");
            File file = new File(stringBuilder2.toString());
            try {
                v = (Cacheable) this.VClass.newInstance();
            } catch (Throwable e) {
                stringBuilder = new StringBuilder("InstantiationException happened while deleting value for key ");
                stringBuilder.append(str);
                InstabugSDKLogger.m8358e(this, stringBuilder.toString(), e);
            } catch (Throwable e2) {
                stringBuilder = new StringBuilder("IllegalAccessException went wrong while deleting value for key ");
                stringBuilder.append(str);
                InstabugSDKLogger.m8358e(this, stringBuilder.toString(), e2);
            }
            synchronized (this.cacheFile) {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(this.cacheFile), this.charset));
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), this.charset));
                    String readLine;
                    do {
                        readLine = bufferedReader.readLine();
                        String key = getKey(readLine);
                        if (key != null) {
                            if (key.equals(str)) {
                                v.fromJson(getValue(readLine));
                                continue;
                            } else {
                                StringBuilder stringBuilder3 = new StringBuilder();
                                stringBuilder3.append(readLine);
                                stringBuilder3.append("\n");
                                bufferedWriter.write(stringBuilder3.toString());
                                continue;
                            }
                        }
                    } while (readLine != null);
                    bufferedReader.close();
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    if (this.cacheFile.delete() && !file.renameTo(this.cacheFile)) {
                        InstabugSDKLogger.m8357e(this, "Couldn't rename temp cache file");
                    }
                } catch (Throwable e3) {
                    stringBuilder = new StringBuilder("IOException went wrong while deleting value for key ");
                    stringBuilder.append(str);
                    InstabugSDKLogger.m8358e(this, stringBuilder.toString(), e3);
                } catch (Throwable e32) {
                    stringBuilder = new StringBuilder("JSONException went wrong while deleting value for key ");
                    stringBuilder.append(str);
                    InstabugSDKLogger.m8358e(this, stringBuilder.toString(), e32);
                } catch (OutOfMemoryError e4) {
                    stringBuilder = new StringBuilder("OOM while deleting value for key ");
                    stringBuilder.append(str);
                    InstabugSDKLogger.m8357e(stringBuilder.toString(), e4.toString());
                }
            }
            return v;
        }
        InstabugSDKLogger.m8356d(this, "Cache file doesn't exist");
        return null;
    }

    public long size() {
        if (this.cacheFile.exists()) {
            long totalSpace;
            synchronized (this.cacheFile) {
                totalSpace = this.cacheFile.getTotalSpace();
            }
            return totalSpace;
        }
        InstabugSDKLogger.m8356d(this, "Cache file doesn't exist");
        return -1;
    }

    public void invalidate() {
        if (this.cacheFile.exists()) {
            InstabugSDKLogger.m8356d(this, "Cache file  exist");
            synchronized (this.cacheFile) {
                this.cacheFile.delete();
            }
        }
        try {
            this.cacheFile.createNewFile();
        } catch (Throwable e) {
            InstabugSDKLogger.m8358e(this, "Failed to create cache file", e);
        }
    }

    public String getValue(String str) {
        return (str == null || str.isEmpty() || !str.contains(":")) ? null : str.substring(str.indexOf(":") + 1);
    }

    public String getKey(String str) {
        return (str == null || str.isEmpty() || !str.contains(":")) ? null : str.substring(0, str.indexOf(":"));
    }

    private boolean checkCacheValidity() {
        String readLine;
        Throwable e;
        Throwable th;
        OutOfMemoryError e2;
        if (this.cacheFile.exists()) {
            synchronized (this.cacheFile) {
                BufferedReader bufferedReader = null;
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(this.cacheFile), this.charset));
                    try {
                        readLine = bufferedReader2.readLine();
                        if (readLine != null) {
                            Object value = getValue(readLine);
                            if (!TextUtils.isEmpty(value)) {
                                JSONObject jSONObject = new JSONObject(value);
                            }
                        }
                        try {
                            bufferedReader2.close();
                        } catch (IOException e3) {
                            e = e3;
                            readLine = "Failed to close file reader";
                            InstabugSDKLogger.m8358e(this, readLine, e);
                            return true;
                        }
                    } catch (IOException e4) {
                        e = e4;
                        bufferedReader = bufferedReader2;
                        InstabugSDKLogger.m8358e(this, "IOException went wrong while fetching values", e);
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e5) {
                                e = e5;
                                readLine = "Failed to close file reader";
                                InstabugSDKLogger.m8358e(this, readLine, e);
                                return true;
                            }
                        }
                        return true;
                    } catch (Throwable e6) {
                        BufferedReader bufferedReader3 = bufferedReader2;
                        th = e6;
                        bufferedReader = bufferedReader3;
                        InstabugSDKLogger.m8358e(this, "JSONException went wrong while fetching values", th);
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable e62) {
                                InstabugSDKLogger.m8358e(this, "Failed to close file reader", e62);
                            }
                        }
                        return false;
                    } catch (OutOfMemoryError e7) {
                        e2 = e7;
                        bufferedReader = bufferedReader2;
                        try {
                            InstabugSDKLogger.m8357e("OOM while fetching values ", e2.toString());
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e8) {
                                    e = e8;
                                    readLine = "Failed to close file reader";
                                    InstabugSDKLogger.m8358e(this, readLine, e);
                                    return true;
                                }
                            }
                            return true;
                        } catch (Throwable th2) {
                            e = th2;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Throwable e622) {
                                    InstabugSDKLogger.m8358e(this, "Failed to close file reader", e622);
                                }
                            }
                            throw e;
                        }
                    } catch (Throwable th3) {
                        e = th3;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        throw e;
                    }
                } catch (IOException e9) {
                    e = e9;
                    InstabugSDKLogger.m8358e(this, "IOException went wrong while fetching values", e);
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    return true;
                } catch (JSONException e10) {
                    th = e10;
                    InstabugSDKLogger.m8358e(this, "JSONException went wrong while fetching values", th);
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    return false;
                } catch (OutOfMemoryError e11) {
                    e2 = e11;
                    InstabugSDKLogger.m8357e("OOM while fetching values ", e2.toString());
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    return true;
                }
                return true;
            }
        }
        InstabugSDKLogger.m8356d(this, "Cache file doesn't exist");
        return false;
    }
}
