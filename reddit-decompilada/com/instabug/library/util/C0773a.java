package com.instabug.library.util;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

/* compiled from: BitmapWorkerTask */
public class C0773a extends AsyncTask<String, Void, Bitmap> {
    private final WeakReference<ImageView> f9895a;
    private float f9896b;
    private float f9897c;
    private boolean f9898d;
    private C0772a f9899e;

    /* compiled from: BitmapWorkerTask */
    public interface C0772a {
        void mo2573a();
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        objArr = BitmapUtils.decodeSampledBitmapFromLocalPath(((String[]) objArr)[0]);
        return this.f9898d ? BitmapUtils.resizeBitmap(objArr, this.f9896b, this.f9897c) : objArr;
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        Bitmap bitmap = (Bitmap) obj;
        if (bitmap != null) {
            ImageView imageView = (ImageView) this.f9895a.get();
            if (imageView != null) {
                imageView.setImageBitmap(bitmap);
                if (this.f9899e != null) {
                    this.f9899e.mo2573a();
                }
            }
        }
    }

    public C0773a(ImageView imageView) {
        this.f9895a = new WeakReference(imageView);
    }

    public C0773a(ImageView imageView, float f, float f2) {
        this(imageView);
        this.f9896b = f;
        this.f9897c = f2;
        this.f9898d = true;
    }

    public C0773a(ImageView imageView, C0772a c0772a) {
        this(imageView);
        this.f9899e = c0772a;
    }
}
