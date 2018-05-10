package com.reddit.frontpage.util;

import android.content.Context;
import android.widget.ImageView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestListener;
import com.reddit.config.GlideApp;
import com.reddit.frontpage.widgets.video.VideoPlayerOld;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import org.jcodec.codecs.mpeg12.MPEGConst;

public class ImageUtil {
    private static int f21742a = -1;

    public static boolean m23724a(int i, int i2) {
        if (i > 0) {
            if (i2 > 0) {
                if (i <= MPEGConst.CODE_END && i2 <= MPEGConst.CODE_END) {
                    return true;
                }
                if (f21742a == -1) {
                    Util.m24006c();
                    EGL10 egl10 = (EGL10) EGLContext.getEGL();
                    EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
                    egl10.eglInitialize(eglGetDisplay, new int[2]);
                    int[] iArr = new int[1];
                    egl10.eglGetConfigs(eglGetDisplay, null, 0, iArr);
                    EGLConfig[] eGLConfigArr = new EGLConfig[iArr[0]];
                    egl10.eglGetConfigs(eglGetDisplay, eGLConfigArr, iArr[0], iArr);
                    int[] iArr2 = new int[1];
                    int i3 = 0;
                    int i4 = i3;
                    while (i3 < iArr[0]) {
                        egl10.eglGetConfigAttrib(eglGetDisplay, eGLConfigArr[i3], 12332, iArr2);
                        if (i4 < iArr2[0]) {
                            i4 = iArr2[0];
                        }
                        i3++;
                    }
                    egl10.eglTerminate(eglGetDisplay);
                    f21742a = Math.max(i4, MPEGConst.CODE_END);
                }
                return i <= f21742a && i2 <= f21742a;
            }
        }
        return false;
    }

    public static void m23720a(Context context, String str, ImageView imageView) {
        m23721a(context, str, imageView, null);
    }

    public static void m23723a(Context context, String str, String str2, String str3, VideoPlayerOld videoPlayerOld) {
        if (str2 != null) {
            GlideApp.a(context).b(str2).diskCacheStrategy(DiskCacheStrategy.d).fitCenter().into(videoPlayerOld.getPreviewImage());
        } else if (str != null) {
            GlideApp.a(context).b(str).diskCacheStrategy(DiskCacheStrategy.d).fitCenter().into(videoPlayerOld.getPreviewImage());
        }
        videoPlayerOld.m24383a(Util.m23964a(str, str3), true, null);
    }

    public static void m23721a(Context context, String str, ImageView imageView, RequestListener requestListener) {
        if (requestListener != null) {
            GlideApp.a(context).b(str).diskCacheStrategy(DiskCacheStrategy.a).dontAnimate().fitCenter().listener(requestListener).into(imageView);
        } else {
            GlideApp.a(context).b(str).diskCacheStrategy(DiskCacheStrategy.a).dontAnimate().fitCenter().into(imageView);
        }
    }

    public static void m23726b(Context context, String str, ImageView imageView, RequestListener requestListener) {
        GlideApp.a(context).i().load(str).diskCacheStrategy(DiskCacheStrategy.d).dontAnimate().listener(requestListener).into(imageView);
    }

    public static void m23722a(Context context, String str, ImageView imageView, String str2) {
        if (str2 != null) {
            GlideApp.a(context).i().load(str).diskCacheStrategy(DiskCacheStrategy.d).dontAnimate().thumbnail(GlideApp.a(context).i().load(str2)).into(imageView);
        } else {
            GlideApp.a(context).i().load(str).diskCacheStrategy(DiskCacheStrategy.d).dontAnimate().into(imageView);
        }
    }

    public static void m23725b(Context context, String str, ImageView imageView) {
        GlideApp.a(context).b(str).centerCrop().dontAnimate().diskCacheStrategy(DiskCacheStrategy.a).into(imageView);
    }
}
