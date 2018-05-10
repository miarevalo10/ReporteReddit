package net.hockeyapp.android;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;
import io.fabric.sdk.android.services.events.EventsFilesManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import net.hockeyapp.android.utils.AsyncTaskUtils;
import net.hockeyapp.android.utils.HockeyLog;
import net.hockeyapp.android.utils.ImageUtils;
import net.hockeyapp.android.views.PaintView;

public class PaintActivity extends Activity {
    private PaintView f26536a;
    private Uri f26537b;

    class C21551 extends AsyncTask<Void, Object, Integer> {
        final /* synthetic */ PaintActivity f26531a;

        C21551(PaintActivity paintActivity) {
            this.f26531a = paintActivity;
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            Integer num = (Integer) obj;
            this.f26531a.setRequestedOrientation(num.intValue());
            if ((this.f26531a.getResources().getDisplayMetrics().widthPixels > this.f26531a.getResources().getDisplayMetrics().heightPixels ? null : true) != num.intValue()) {
                HockeyLog.m28204a("Image loading skipped because activity will be destroyed for orientation change.");
            } else {
                PaintActivity.m28180b(this.f26531a);
            }
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return Integer.valueOf(ImageUtils.m28216a(this.f26531a, this.f26531a.f26537b));
        }
    }

    class C21562 implements OnClickListener {
        final /* synthetic */ PaintActivity f26532a;

        C21562(PaintActivity paintActivity) {
            this.f26532a = paintActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            switch (i) {
                case -2:
                    this.f26532a.finish();
                    break;
                case -1:
                    this.f26532a.m28179a();
                    return;
                default:
                    break;
            }
        }
    }

    @SuppressLint({"StaticFieldLeak"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bundle = getIntent().getExtras();
        if (bundle != null) {
            if (bundle.getParcelable("imageUri") != null) {
                this.f26537b = (Uri) bundle.getParcelable("imageUri");
                AsyncTaskUtils.m28200a(new C21551(this));
                return;
            }
        }
        HockeyLog.m28209c("Can't set up PaintActivity as image extra was not provided!");
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0, 1, 0, getString(C2158R.string.hockeyapp_paint_menu_save));
        menu.add(0, 2, 0, getString(C2158R.string.hockeyapp_paint_menu_undo));
        menu.add(0, 3, 0, getString(C2158R.string.hockeyapp_paint_menu_clear));
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 1:
                m28179a();
                return true;
            case 2:
                menuItem = this.f26536a;
                if (!menuItem.f26654a.empty()) {
                    menuItem.f26654a.pop();
                    menuItem.invalidate();
                }
                return true;
            case 3:
                menuItem = this.f26536a;
                menuItem.f26654a.clear();
                menuItem.invalidate();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || this.f26536a.f26654a.empty()) {
            return super.onKeyDown(i, keyEvent);
        }
        i = new C21562(this);
        new Builder(this).setMessage(C2158R.string.hockeyapp_paint_dialog_message).setPositiveButton(C2158R.string.hockeyapp_paint_dialog_positive_button, i).setNegativeButton(C2158R.string.hockeyapp_paint_dialog_negative_button, i).setNeutralButton(C2158R.string.hockeyapp_paint_dialog_neutral_button, i).show();
        return true;
    }

    @SuppressLint({"StaticFieldLeak"})
    private void m28179a() {
        this.f26536a.setDrawingCacheEnabled(true);
        final Bitmap drawingCache = this.f26536a.getDrawingCache();
        AsyncTaskUtils.m28200a(new AsyncTask<Void, Object, Boolean>(this) {
            File f26533a;
            final /* synthetic */ PaintActivity f26535c;

            protected /* synthetic */ Object doInBackground(Object[] objArr) {
                return m28175a();
            }

            protected /* synthetic */ void onPostExecute(Object obj) {
                if (((Boolean) obj).booleanValue() != null) {
                    obj = new Intent();
                    obj.putExtra("imageUri", Uri.fromFile(this.f26533a));
                    if (this.f26535c.getParent() == null) {
                        this.f26535c.setResult(-1, obj);
                    } else {
                        this.f26535c.getParent().setResult(-1, obj);
                    }
                } else if (this.f26535c.getParent() == null) {
                    this.f26535c.setResult(0);
                } else {
                    this.f26535c.getParent().setResult(0);
                }
                this.f26535c.finish();
            }

            private Boolean m28175a() {
                File file = new File(this.f26535c.getCacheDir(), "HockeyApp");
                if (!file.exists() && !file.mkdir()) {
                    return Boolean.valueOf(false);
                }
                String a = this.f26535c.m28177a(this.f26535c.f26537b, this.f26535c.f26537b.getLastPathSegment());
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(a);
                stringBuilder.append(".jpg");
                this.f26533a = new File(file, stringBuilder.toString());
                int i = 1;
                while (this.f26533a.exists()) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(a);
                    stringBuilder2.append(EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR);
                    stringBuilder2.append(i);
                    stringBuilder2.append(".jpg");
                    this.f26533a = new File(file, stringBuilder2.toString());
                    i++;
                }
                try {
                    OutputStream fileOutputStream = new FileOutputStream(this.f26533a);
                    drawingCache.compress(CompressFormat.JPEG, 100, fileOutputStream);
                    fileOutputStream.close();
                    return Boolean.valueOf(true);
                } catch (Throwable e) {
                    HockeyLog.m28206a("Could not save image.", e);
                    return Boolean.valueOf(false);
                }
            }
        });
    }

    private String m28177a(Uri uri, String str) {
        uri = getApplicationContext().getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
        String str2 = null;
        if (uri != null) {
            try {
                if (uri.moveToFirst()) {
                    str2 = uri.getString(0);
                }
                uri.close();
            } catch (Throwable th) {
                uri.close();
            }
        }
        if (str2 == null) {
            return str;
        }
        return new File(str2).getName();
    }

    static /* synthetic */ void m28180b(PaintActivity paintActivity) {
        paintActivity.f26536a = new PaintView(paintActivity, paintActivity.f26537b, paintActivity.getResources().getDisplayMetrics().widthPixels, paintActivity.getResources().getDisplayMetrics().heightPixels);
        View linearLayout = new LinearLayout(paintActivity);
        linearLayout.setLayoutParams(new LayoutParams(-1, -1));
        linearLayout.setGravity(17);
        linearLayout.setOrientation(1);
        View linearLayout2 = new LinearLayout(paintActivity);
        linearLayout2.setLayoutParams(new LayoutParams(-1, -1));
        linearLayout2.setGravity(17);
        linearLayout2.setOrientation(0);
        linearLayout.addView(linearLayout2);
        linearLayout2.addView(paintActivity.f26536a);
        paintActivity.setContentView(linearLayout);
        Toast.makeText(paintActivity, C2158R.string.hockeyapp_paint_indicator_toast, 1).show();
    }
}
