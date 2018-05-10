package com.coremedia.iso;

import com.coremedia.iso.boxes.Box;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PropertyBoxParserImpl extends AbstractBoxParser {
    static String[] f16749g = new String[0];
    Properties f16750b;
    Pattern f16751c = Pattern.compile("(.*)\\((.*?)\\)");
    StringBuilder f16752d = new StringBuilder();
    ThreadLocal<String> f16753e = new ThreadLocal();
    ThreadLocal<String[]> f16754f = new ThreadLocal();

    public PropertyBoxParserImpl() {
        InputStream resourceAsStream = getClass().getResourceAsStream("/isoparser-default.properties");
        try {
            this.f16750b = new Properties();
            this.f16750b.load(resourceAsStream);
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (contextClassLoader == null) {
                contextClassLoader = ClassLoader.getSystemClassLoader();
            }
            Enumeration resources = contextClassLoader.getResources("isoparser-custom.properties");
            while (resources.hasMoreElements()) {
                InputStream openStream = ((URL) resources.nextElement()).openStream();
                try {
                    this.f16750b.load(openStream);
                    openStream.close();
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                } catch (Throwable th) {
                    openStream.close();
                }
            }
        } finally {
            try {
                resourceAsStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public final Box mo3275a(String str, byte[] bArr, String str2) {
        Object property;
        int i = 0;
        if (bArr == null) {
            property = this.f16750b.getProperty(str);
            if (property == null) {
                StringBuilder stringBuilder = this.f16752d;
                stringBuilder.append(str2);
                stringBuilder.append('-');
                stringBuilder.append(str);
                String stringBuilder2 = stringBuilder.toString();
                this.f16752d.setLength(0);
                property = this.f16750b.getProperty(stringBuilder2);
            }
        } else if ("uuid".equals(str)) {
            Properties properties = this.f16750b;
            StringBuilder stringBuilder3 = new StringBuilder("uuid[");
            stringBuilder3.append(Hex.m3277a(bArr).toUpperCase());
            stringBuilder3.append("]");
            property = properties.getProperty(stringBuilder3.toString());
            if (property == null) {
                properties = this.f16750b;
                stringBuilder3 = new StringBuilder(String.valueOf(str2));
                stringBuilder3.append("-uuid[");
                stringBuilder3.append(Hex.m3277a(bArr).toUpperCase());
                stringBuilder3.append("]");
                property = properties.getProperty(stringBuilder3.toString());
            }
            if (property == null) {
                property = this.f16750b.getProperty("uuid");
            }
        } else {
            throw new RuntimeException("we have a userType but no uuid box type. Something's wrong");
        }
        if (property == null) {
            property = this.f16750b.getProperty("default");
        }
        if (property == null) {
            str2 = new StringBuilder("No box object found for ");
            str2.append(str);
            throw new RuntimeException(str2.toString());
        }
        ThreadLocal threadLocal;
        if (property.endsWith(")")) {
            Matcher matcher = this.f16751c.matcher(property);
            if (matcher.matches()) {
                this.f16753e.set(matcher.group(1));
                if (matcher.group(2).length() == 0) {
                    threadLocal = this.f16754f;
                    property = f16749g;
                } else {
                    ThreadLocal threadLocal2 = this.f16754f;
                    property = matcher.group(2).length() > 0 ? matcher.group(2).split(",") : new String[0];
                    threadLocal = threadLocal2;
                }
            } else {
                bArr = new StringBuilder("Cannot work with that constructor: ");
                bArr.append(property);
                throw new RuntimeException(bArr.toString());
            }
        }
        this.f16754f.set(f16749g);
        threadLocal = this.f16753e;
        threadLocal.set(property);
        String[] strArr = (String[]) this.f16754f.get();
        try {
            Class cls = Class.forName((String) this.f16753e.get());
            if (strArr.length <= 0) {
                return (Box) cls.newInstance();
            }
            Class[] clsArr = new Class[strArr.length];
            Object[] objArr = new Object[strArr.length];
            while (i < strArr.length) {
                if ("userType".equals(strArr[i])) {
                    objArr[i] = bArr;
                    clsArr[i] = byte[].class;
                } else if ("type".equals(strArr[i])) {
                    objArr[i] = str;
                    clsArr[i] = String.class;
                } else if ("parent".equals(strArr[i])) {
                    objArr[i] = str2;
                    clsArr[i] = String.class;
                } else {
                    bArr = new StringBuilder("No such param: ");
                    bArr.append(strArr[i]);
                    throw new InternalError(bArr.toString());
                }
                i++;
            }
            return (Box) cls.getConstructor(clsArr).newInstance(objArr);
        } catch (String str3) {
            throw new RuntimeException(str3);
        } catch (String str32) {
            throw new RuntimeException(str32);
        } catch (String str322) {
            throw new RuntimeException(str322);
        } catch (String str3222) {
            throw new RuntimeException(str3222);
        } catch (String str32222) {
            throw new RuntimeException(str32222);
        }
    }
}
