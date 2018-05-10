package net.hockeyapp.android.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ImageUtils {
    public static int m28218a(File file) throws IOException {
        InputStream inputStream = null;
        try {
            InputStream fileInputStream = new FileInputStream(file);
            try {
                file = m28219a(fileInputStream);
                fileInputStream.close();
                return file;
            } catch (Throwable th) {
                file = th;
                inputStream = fileInputStream;
                if (inputStream != null) {
                    inputStream.close();
                }
                throw file;
            }
        } catch (Throwable th2) {
            file = th2;
            if (inputStream != null) {
                inputStream.close();
            }
            throw file;
        }
    }

    public static int m28216a(Context context, Uri uri) {
        Throwable e;
        InputStream inputStream = null;
        try {
            InputStream openInputStream = context.getContentResolver().openInputStream(uri);
            try {
                uri = m28219a(openInputStream);
                if (openInputStream != null) {
                    try {
                        openInputStream.close();
                    } catch (Throwable e2) {
                        HockeyLog.m28206a("Unable to close input stream.", e2);
                    }
                }
                return uri;
            } catch (IOException e3) {
                e = e3;
                inputStream = openInputStream;
                try {
                    HockeyLog.m28206a("Unable to determine necessary screen orientation.", e);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable e22) {
                            HockeyLog.m28206a("Unable to close input stream.", e22);
                        }
                    }
                    return 1;
                } catch (Throwable th) {
                    uri = th;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable e222) {
                            HockeyLog.m28206a("Unable to close input stream.", e222);
                        }
                    }
                    throw uri;
                }
            } catch (Throwable th2) {
                uri = th2;
                inputStream = openInputStream;
                if (inputStream != null) {
                    inputStream.close();
                }
                throw uri;
            }
        } catch (IOException e4) {
            e = e4;
            HockeyLog.m28206a("Unable to determine necessary screen orientation.", e);
            if (inputStream != null) {
                inputStream.close();
            }
            return 1;
        }
    }

    private static int m28219a(InputStream inputStream) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, null, options);
        if (options.outWidth != -1) {
            if (options.outHeight != -1) {
                if (((float) options.outWidth) / ((float) options.outHeight) > 1.0f) {
                    return null;
                }
                return 1;
            }
        }
        return 1;
    }

    public static Bitmap m28221a(File file, int i, int i2) throws IOException {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        options.inSampleSize = m28217a(options, i, i2);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(file.getAbsolutePath(), options);
    }

    public static Bitmap m28220a(Context context, Uri uri, int i, int i2) throws IOException {
        InputStream openInputStream;
        InputStream inputStream = null;
        try {
            Options options = new Options();
            options.inJustDecodeBounds = true;
            openInputStream = context.getContentResolver().openInputStream(uri);
            try {
                BitmapFactory.decodeStream(openInputStream, null, options);
                options.inSampleSize = m28217a(options, i, i2);
                options.inJustDecodeBounds = false;
                context = context.getContentResolver().openInputStream(uri);
            } catch (Throwable th) {
                uri = th;
                if (openInputStream != null) {
                    openInputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                throw uri;
            }
            try {
                uri = BitmapFactory.decodeStream(context, null, options);
                if (openInputStream != null) {
                    openInputStream.close();
                }
                if (context != null) {
                    context.close();
                }
                return uri;
            } catch (Throwable th2) {
                uri = th2;
                inputStream = context;
                if (openInputStream != null) {
                    openInputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                throw uri;
            }
        } catch (Throwable th3) {
            uri = th3;
            openInputStream = null;
            if (openInputStream != null) {
                openInputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            throw uri;
        }
    }

    private static int m28217a(Options options, int i, int i2) {
        int i3 = options.outHeight;
        options = options.outWidth;
        int i4 = 1;
        if (i3 > i2 || options > i) {
            i3 /= 2;
            options /= 2;
            while (i3 / i4 > i2 && options / i4 > i) {
                i4 *= 2;
            }
        }
        return i4;
    }
}
