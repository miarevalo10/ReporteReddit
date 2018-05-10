package com.instabug.library.annotation;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.instabug.library.C0593R;
import com.instabug.library.Instabug;
import com.instabug.library.InstabugColorTheme;
import com.instabug.library.annotation.AnnotationView.C0605b;
import com.instabug.library.annotation.AnnotationView.C0607d;
import com.instabug.library.annotation.AnnotationView.C0608e;
import com.instabug.library.annotation.AnnotationView.C0609f;
import com.instabug.library.annotation.AnnotationView.C0610g;
import com.instabug.library.annotation.ColorPickerPopUpView.C0612b;
import com.instabug.library.annotation.ShapeSuggestionsLayout.C06163;
import com.instabug.library.annotation.ShapeSuggestionsLayout.C0617a;
import com.instabug.library.annotation.ShapeSuggestionsLayout.C0618b;
import com.instabug.library.annotation.p017b.C0632g;
import com.instabug.library.annotation.p017b.C1650h;
import com.instabug.library.util.AttrResolver;
import com.instabug.library.util.BitmapUtils;
import com.instabug.library.util.C0773a.C0772a;
import com.instabug.library.view.IconView;
import com.instabug.library.view.ViewUtils;

public class AnnotationLayout extends LinearLayout implements OnClickListener {
    private static final String TAG = "AnnotationLayout";
    private LinearLayout annotationActionsContainer;
    private AnnotationView annotationView;
    private View border;
    private View brushIndicator;
    private ColorPickerPopUpView colorPicker;
    private IconView iconBlur;
    private IconView iconBrush;
    private RelativeLayout iconBrushLayout;
    private IconView iconMagnify;
    private IconView iconUndo;
    private ShapeSuggestionsLayout shapeSuggestionsLayout;
    private int tintingColor;

    class C13441 implements C0617a {
        final /* synthetic */ AnnotationLayout f15444a;

        C13441(AnnotationLayout annotationLayout) {
            this.f15444a = annotationLayout;
        }

        public final void mo2568a(int i) {
            if (i == 1) {
                i = this.f15444a.annotationView;
                C0632g c0632g = i.f9430d;
                C0633b c0633b = i.f9431e;
                i.f9427a.m8100c(i.f9428b);
                i.f9428b.m8086a(c0632g, c0633b);
                i.invalidate();
            }
        }
    }

    class C13452 implements C0608e {
        final /* synthetic */ AnnotationLayout f15445a;

        C13452(AnnotationLayout annotationLayout) {
            this.f15445a = annotationLayout;
        }

        public final void mo2569a() {
            if (this.f15445a.colorPicker.getVisibility() == 0) {
                this.f15445a.colorPicker.setVisibility(8);
            }
            this.f15445a.shapeSuggestionsLayout.m8041a();
        }
    }

    class C13463 implements C0610g {
        final /* synthetic */ AnnotationLayout f15446a;

        C13463(AnnotationLayout annotationLayout) {
            this.f15446a = annotationLayout;
        }

        public final void mo2570a(Path path, Path path2) {
            this.f15446a.showShapeSuggestions(path, path2);
        }
    }

    class C13474 implements C0609f {
        final /* synthetic */ AnnotationLayout f15447a;

        C13474(AnnotationLayout annotationLayout) {
            this.f15447a = annotationLayout;
        }

        public final void mo2571a(boolean z) {
            this.f15447a.iconMagnify.setEnabled(z);
        }
    }

    class C13485 implements C0612b {
        final /* synthetic */ AnnotationLayout f15448a;

        C13485(AnnotationLayout annotationLayout) {
            this.f15448a = annotationLayout;
        }

        public final void mo2572a(int i) {
            this.f15448a.annotationView.setDrawingColor(i);
            this.f15448a.colorPicker.setVisibility(8);
            this.f15448a.brushIndicator.setBackgroundColor(i);
        }
    }

    public AnnotationLayout(Context context) {
        this(context, null);
    }

    public AnnotationLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @TargetApi(11)
    public AnnotationLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initViews();
    }

    @TargetApi(21)
    public AnnotationLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        initViews();
    }

    private void initViews() {
        inflate(getContext(), C0593R.layout.instabug_annotation_view, this);
        this.annotationActionsContainer = (LinearLayout) findViewById(C0593R.id.instabug_annotation_actions_container);
        this.shapeSuggestionsLayout = (ShapeSuggestionsLayout) findViewById(C0593R.id.shapeSuggestionsLayout);
        this.shapeSuggestionsLayout.setOnShapeSelectedListener(new C13441(this));
        this.iconBrushLayout = (RelativeLayout) findViewById(C0593R.id.icon_brush_layout);
        this.iconBrush = (IconView) findViewById(C0593R.id.icon_brush);
        this.iconMagnify = (IconView) findViewById(C0593R.id.icon_magnify);
        this.iconBlur = (IconView) findViewById(C0593R.id.icon_blur);
        this.iconUndo = (IconView) findViewById(C0593R.id.icon_undo);
        this.iconBrush.setEnabled(false);
        this.iconMagnify.setEnabled(false);
        this.iconBlur.setEnabled(false);
        this.iconUndo.setEnabled(false);
        this.border = findViewById(C0593R.id.instabug_annotation_image_border);
        this.annotationView = (AnnotationView) findViewById(C0593R.id.instabug_annotation_image);
        this.colorPicker = (ColorPickerPopUpView) findViewById(C0593R.id.instabug_color_picker);
        this.brushIndicator = findViewById(C0593R.id.brush_indicator);
        this.annotationView.setDrawingMode(C0605b.DRAW_PATH);
        this.iconBrush.setTextColor(Instabug.getPrimaryColor());
        this.annotationView.setDrawingColor(this.colorPicker.getSelectedColor());
        this.annotationView.setOnActionDownListener(new C13452(this));
        this.annotationView.setOnPathRecognizedListener(new C13463(this));
        this.annotationView.m8032setOnNewMagnifierAddingAbilityChangedListener(new C13474(this));
        this.colorPicker.setOnColorSelectionListener(new C13485(this));
        this.colorPicker.setPopUpBackgroundColor(AttrResolver.getBackgroundColor(getContext()));
        this.colorPicker.setPopUpBorderColor(AttrResolver.getDividerColor(getContext()));
        this.iconBrushLayout.setOnClickListener(this);
        this.iconMagnify.setOnClickListener(this);
        this.iconBlur.setOnClickListener(this);
        this.iconUndo.setOnClickListener(this);
        setViewSelector(this.iconMagnify);
        setViewSelector(this.iconUndo);
        if (Instabug.getTheme() == InstabugColorTheme.InstabugColorThemeLight) {
            this.tintingColor = ContextCompat.m719c(getContext(), C0593R.color.instabug_theme_tinting_color_light);
        } else {
            this.tintingColor = ContextCompat.m719c(getContext(), C0593R.color.instabug_theme_tinting_color_dark);
        }
    }

    private void showShapeSuggestions(Path... pathArr) {
        for (Path path : pathArr) {
            ShapeSuggestionsLayout shapeSuggestionsLayout = this.shapeSuggestionsLayout;
            View c0618b = new C0618b(shapeSuggestionsLayout, shapeSuggestionsLayout.getContext(), path, AttrResolver.getTintingColor(shapeSuggestionsLayout.getContext()));
            c0618b.setOnClickListener(new C06163(shapeSuggestionsLayout));
            shapeSuggestionsLayout.addView(c0618b);
            shapeSuggestionsLayout.m8042a(0);
        }
        pathArr = this.shapeSuggestionsLayout;
        if (pathArr.f9480a) {
            pathArr.f9480a = false;
            pathArr.setVisibility(0);
            if (VERSION.SDK_INT >= 12) {
                pathArr.animate().alpha(1.0f).setDuration(400).setListener(null);
            }
            pathArr.f9482c.postDelayed(pathArr.f9481b, 3000);
        }
    }

    private void setBorder() {
        int convertDpToPx = ViewUtils.convertDpToPx(getContext(), 4.0f);
        int convertDpToPx2 = ViewUtils.convertDpToPx(getContext(), 2.0f);
        Drawable shapeDrawable = new ShapeDrawable();
        shapeDrawable.setShape(new RectShape());
        shapeDrawable.getPaint().setColor(Instabug.getPrimaryColor());
        shapeDrawable.getPaint().setStyle(Style.STROKE);
        shapeDrawable.getPaint().setStrokeWidth((float) convertDpToPx);
        this.border.setPadding(convertDpToPx2, convertDpToPx2, convertDpToPx2, convertDpToPx2);
        if (VERSION.SDK_INT >= 16) {
            this.border.setBackground(shapeDrawable);
        } else {
            this.border.setBackgroundDrawable(shapeDrawable);
        }
    }

    private void setViewSelector(final IconView iconView) {
        iconView.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ AnnotationLayout f9400b;

            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == null) {
                    iconView.setTextColor(Instabug.getPrimaryColor());
                } else if (motionEvent.getAction() == 1) {
                    iconView.setTextColor(this.f9400b.tintingColor);
                }
                return null;
            }
        });
    }

    public void onClick(View view) {
        this.shapeSuggestionsLayout.m8041a();
        view = view.getId();
        if (view == C0593R.id.icon_brush_layout) {
            if (this.iconBrush.getCurrentTextColor() == Instabug.getPrimaryColor()) {
                switchColorPickerVisibility();
            }
            this.annotationView.setDrawingMode(C0605b.DRAW_PATH);
            resetColorSelection();
            this.iconBrush.setTextColor(Instabug.getPrimaryColor());
        } else if (view == C0593R.id.icon_magnify) {
            view = this.annotationView;
            if (view.f9432f < 5) {
                C0632g c1650h = new C1650h(view.m8030b());
                int min = Math.min(view.getWidth(), view.getHeight()) / 2;
                r3 = (view.getWidth() - min) / 2;
                int height = (view.getHeight() - min) / 2;
                C0633b c0633b = new C0633b((float) r3, (float) (height - 30), (float) (r3 + min), (float) ((min + height) + 30));
                C0607d c0607d = C0607d.HIGH;
                C0636c c0636c = new C0636c(c1650h);
                c0636c.m8087a(c0633b);
                view.getOriginalBitmap();
                view.f9428b = c0636c;
                if (c0607d == C0607d.LOW) {
                    view.f9427a.m8099b(c0636c);
                } else {
                    view.f9427a.m8098a(c0636c);
                }
                view.invalidate();
                view.f9432f++;
            }
            if (view.f9432f == 5 && view.f9429c != null) {
                view.f9429c.mo2571a(false);
            }
            hideColorPicker();
        } else if (view == C0593R.id.icon_blur) {
            this.annotationView.setDrawingMode(C0605b.DRAW_BLUR);
            resetColorSelection();
            this.iconBlur.setTextColor(Instabug.getPrimaryColor());
            hideColorPicker();
        } else {
            if (view == C0593R.id.icon_undo) {
                C0636c c0636c2;
                view = this.annotationView;
                C0637d c0637d = view.f9427a;
                if (c0637d.f9553d.size() > 0) {
                    c0636c2 = (C0636c) c0637d.f9553d.pop();
                    if (!c0636c2.m8092c()) {
                        if (!c0637d.f9551b.remove(c0636c2)) {
                            c0637d.f9552c.remove(c0636c2);
                        }
                        c0637d.f9550a.remove(c0636c2);
                        while (true) {
                            r3 = c0637d.f9553d.indexOf(c0636c2);
                            if (r3 == -1) {
                                break;
                            }
                            c0637d.f9553d.remove(r3);
                        }
                        if (c0636c2 != null && (c0636c2.m8093d() instanceof C1650h)) {
                            view.f9432f--;
                            view.m8031c();
                        }
                        view.f9428b = null;
                        view.m8029a();
                        view.invalidate();
                        hideColorPicker();
                    }
                }
                c0636c2 = null;
                view.f9432f--;
                view.m8031c();
                view.f9428b = null;
                view.m8029a();
                view.invalidate();
                hideColorPicker();
            }
        }
    }

    private void switchColorPickerVisibility() {
        this.colorPicker.setVisibility(this.colorPicker.getVisibility() == 0 ? 8 : 0);
    }

    private void hideColorPicker() {
        if (this.colorPicker.getVisibility() == 0) {
            this.colorPicker.setVisibility(8);
        }
    }

    private void resetColorSelection() {
        int childCount = this.annotationActionsContainer.getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (this.annotationActionsContainer.getChildAt(i) instanceof IconView) {
                ((TextView) this.annotationActionsContainer.getChildAt(i)).setTextColor(this.tintingColor);
            }
        }
        this.iconBrush.setTextColor(this.tintingColor);
    }

    public void setBaseImage(Uri uri, final Runnable runnable) {
        BitmapUtils.loadBitmap(uri.getPath(), this.annotationView, new C0772a(this) {
            final /* synthetic */ AnnotationLayout f15450b;

            public final void mo2573a() {
                this.f15450b.enableButtons();
                this.f15450b.setBorder();
                if (runnable != null) {
                    runnable.run();
                }
            }
        });
    }

    private void enableButtons() {
        this.iconBrush.setEnabled(true);
        this.iconMagnify.setEnabled(true);
        this.iconBlur.setEnabled(true);
        this.iconUndo.setEnabled(true);
    }

    public Bitmap getAnnotatedBitmap() {
        return this.annotationView.m8030b();
    }
}
