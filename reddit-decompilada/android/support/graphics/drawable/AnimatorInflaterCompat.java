package android.support.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Build.VERSION;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.graphics.PathParser;
import android.support.v4.graphics.PathParser.PathDataNode;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import com.instabug.library.model.State;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class AnimatorInflaterCompat {

    private static class PathDataEvaluator implements TypeEvaluator<PathDataNode[]> {
        private PathDataNode[] f747a;

        public /* synthetic */ Object evaluate(float f, Object obj, Object obj2) {
            PathDataNode[] pathDataNodeArr = (PathDataNode[]) obj;
            PathDataNode[] pathDataNodeArr2 = (PathDataNode[]) obj2;
            if (PathParser.m806a(pathDataNodeArr, pathDataNodeArr2)) {
                if (this.f747a == null || !PathParser.m806a(this.f747a, pathDataNodeArr)) {
                    this.f747a = PathParser.m808a(pathDataNodeArr);
                }
                for (int i = 0; i < pathDataNodeArr.length; i++) {
                    this.f747a[i].m802a(pathDataNodeArr[i], pathDataNodeArr2[i], f);
                }
                return this.f747a;
            }
            throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
        }

        private PathDataEvaluator() {
        }
    }

    private static boolean m373a(int i) {
        return i >= 28 && i <= 31;
    }

    public static Animator m365a(Context context, int i) throws NotFoundException {
        if (VERSION.SDK_INT >= 24) {
            return AnimatorInflater.loadAnimator(context, i);
        }
        return m366a(context, context.getResources(), context.getTheme(), i);
    }

    private static Animator m366a(Context context, Resources resources, Theme theme, int i) throws NotFoundException {
        XmlResourceParser xmlResourceParser = null;
        try {
            XmlPullParser animation = resources.getAnimation(i);
            try {
                context = m367a(context, resources, theme, animation, Xml.asAttributeSet(animation), null, 0, 1.0f);
                if (animation != null) {
                    animation.close();
                }
                return context;
            } catch (XmlPullParserException e) {
                context = e;
                XmlPullParser xmlPullParser = animation;
                theme = new StringBuilder("Can't load animation resource ID #0x");
                theme.append(Integer.toHexString(i));
                resources = new NotFoundException(theme.toString());
                resources.initCause(context);
                throw resources;
            } catch (IOException e2) {
                context = e2;
                xmlResourceParser = animation;
                theme = new StringBuilder("Can't load animation resource ID #0x");
                theme.append(Integer.toHexString(i));
                resources = new NotFoundException(theme.toString());
                resources.initCause(context);
                throw resources;
            } catch (Throwable th) {
                context = th;
                xmlResourceParser = animation;
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
                throw context;
            }
        } catch (XmlPullParserException e3) {
            context = e3;
            theme = new StringBuilder("Can't load animation resource ID #0x");
            theme.append(Integer.toHexString(i));
            resources = new NotFoundException(theme.toString());
            resources.initCause(context);
            throw resources;
        } catch (IOException e4) {
            context = e4;
            theme = new StringBuilder("Can't load animation resource ID #0x");
            theme.append(Integer.toHexString(i));
            resources = new NotFoundException(theme.toString());
            resources.initCause(context);
            throw resources;
        } catch (Throwable th2) {
            context = th2;
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw context;
        }
    }

    private static PropertyValuesHolder m369a(TypedArray typedArray, int i, int i2, int i3, String str) {
        TypedValue peekValue = typedArray.peekValue(i2);
        int i4 = peekValue != null ? 1 : (byte) 0;
        int i5 = i4 != 0 ? peekValue.type : 0;
        TypedValue peekValue2 = typedArray.peekValue(i3);
        int i6 = peekValue2 != null ? 1 : (byte) 0;
        int i7 = i6 != 0 ? peekValue2.type : 0;
        if (i == 4) {
            i = ((i4 == 0 || m373a(i5) == 0) && (i6 == 0 || m373a(i7) == 0)) ? 0 : 3;
        }
        int i8 = i == 0 ? 1 : (byte) 0;
        PropertyValuesHolder propertyValuesHolder = null;
        if (i == 2) {
            i = typedArray.getString(i2);
            typedArray = typedArray.getString(i3);
            PathDataNode[] b = PathParser.m810b(i);
            PathDataNode[] b2 = PathParser.m810b(typedArray);
            if (!(b == 0 && b2 == 0)) {
                if (b != 0) {
                    TypeEvaluator pathDataEvaluator = new PathDataEvaluator();
                    if (b2 == 0) {
                        return PropertyValuesHolder.ofObject(str, pathDataEvaluator, new Object[]{b});
                    } else if (PathParser.m806a(b, b2)) {
                        return PropertyValuesHolder.ofObject(str, pathDataEvaluator, new Object[]{b, b2});
                    } else {
                        i3 = new StringBuilder(" Can't morph from ");
                        i3.append(i);
                        i3.append(" to ");
                        i3.append(typedArray);
                        throw new InflateException(i3.toString());
                    }
                } else if (b2 != null) {
                    propertyValuesHolder = PropertyValuesHolder.ofObject(str, new PathDataEvaluator(), new Object[]{b2});
                }
            }
            return propertyValuesHolder;
        }
        i = i == 3 ? ArgbEvaluator.m375a() : 0;
        if (i8 != 0) {
            if (i4 != 0) {
                if (i5 == 5) {
                    i2 = typedArray.getDimension(i2, 0.0f);
                } else {
                    i2 = typedArray.getFloat(i2, 0.0f);
                }
                if (i6 != 0) {
                    if (i7 == 5) {
                        typedArray = typedArray.getDimension(i3, 0.0f);
                    } else {
                        typedArray = typedArray.getFloat(i3, 0.0f);
                    }
                    propertyValuesHolder = PropertyValuesHolder.ofFloat(str, new float[]{i2, typedArray});
                } else {
                    propertyValuesHolder = PropertyValuesHolder.ofFloat(str, new float[]{i2});
                }
            } else {
                if (i7 == 5) {
                    typedArray = typedArray.getDimension(i3, 0.0f);
                } else {
                    typedArray = typedArray.getFloat(i3, 0.0f);
                }
                propertyValuesHolder = PropertyValuesHolder.ofFloat(str, new float[]{typedArray});
            }
        } else if (i4 != 0) {
            if (i5 == 5) {
                i2 = (int) typedArray.getDimension(i2, 0.0f);
            } else if (m373a(i5)) {
                i2 = typedArray.getColor(i2, 0);
            } else {
                i2 = typedArray.getInt(i2, 0);
            }
            if (i6 != 0) {
                if (i7 == 5) {
                    typedArray = (int) typedArray.getDimension(i3, 0.0f);
                } else if (m373a(i7)) {
                    typedArray = typedArray.getColor(i3, 0);
                } else {
                    typedArray = typedArray.getInt(i3, 0);
                }
                propertyValuesHolder = PropertyValuesHolder.ofInt(str, new int[]{i2, typedArray});
            } else {
                propertyValuesHolder = PropertyValuesHolder.ofInt(str, new int[]{i2});
            }
        } else if (i6 != 0) {
            if (i7 == 5) {
                typedArray = (int) typedArray.getDimension(i3, 0.0f);
            } else if (m373a(i7) != 0) {
                typedArray = typedArray.getColor(i3, 0);
            } else {
                typedArray = typedArray.getInt(i3, 0);
            }
            propertyValuesHolder = PropertyValuesHolder.ofInt(str, new int[]{typedArray});
        }
        PropertyValuesHolder propertyValuesHolder2 = propertyValuesHolder;
        if (propertyValuesHolder2 == null || i == 0) {
            return propertyValuesHolder2;
        }
        propertyValuesHolder2.setEvaluator(i);
        return propertyValuesHolder2;
    }

    private static void m371a(Path path, ObjectAnimator objectAnimator, float f, String str, String str2) {
        Path path2 = path;
        ObjectAnimator objectAnimator2 = objectAnimator;
        String str3 = str;
        String str4 = str2;
        int i = 0;
        PathMeasure pathMeasure = new PathMeasure(path2, false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Float.valueOf(0.0f));
        float f2 = 0.0f;
        do {
            f2 += pathMeasure.getLength();
            arrayList.add(Float.valueOf(f2));
        } while (pathMeasure.nextContour());
        pathMeasure = new PathMeasure(path2, false);
        int min = Math.min(100, ((int) (f2 / f)) + 1);
        float[] fArr = new float[min];
        float[] fArr2 = new float[min];
        float[] fArr3 = new float[2];
        f2 /= (float) (min - 1);
        int i2 = 0;
        float f3 = 0.0f;
        int i3 = i2;
        while (true) {
            float[] fArr4 = null;
            if (i3 >= min) {
                break;
            }
            pathMeasure.getPosTan(f3, fArr3, null);
            pathMeasure.getPosTan(f3, fArr3, null);
            fArr[i3] = fArr3[i];
            fArr2[i3] = fArr3[1];
            f3 += f2;
            int i4 = i2 + 1;
            if (i4 < arrayList.size() && f3 > ((Float) arrayList.get(i4)).floatValue()) {
                f3 -= ((Float) arrayList.get(i4)).floatValue();
                pathMeasure.nextContour();
                i2 = i4;
            }
            i3++;
            i = 0;
        }
        PropertyValuesHolder ofFloat = str3 != null ? PropertyValuesHolder.ofFloat(str3, fArr) : null;
        if (str4 != null) {
            fArr4 = PropertyValuesHolder.ofFloat(str4, fArr2);
        }
        if (ofFloat == null) {
            objectAnimator2.setValues(new PropertyValuesHolder[]{fArr4});
        } else if (fArr4 == null) {
            objectAnimator2.setValues(new PropertyValuesHolder[]{ofFloat});
        } else {
            objectAnimator2.setValues(new PropertyValuesHolder[]{ofFloat, fArr4});
        }
    }

    private static Animator m367a(Context context, Resources resources, Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet, AnimatorSet animatorSet, int i, float f) throws XmlPullParserException, IOException {
        Resources resources2 = resources;
        Theme theme2 = theme;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        AnimatorSet animatorSet2 = animatorSet;
        int depth = xmlPullParser.getDepth();
        Animator animator = null;
        ArrayList arrayList = null;
        while (true) {
            int next = xmlPullParser.next();
            int i2 = 0;
            if ((next != 3 || xmlPullParser.getDepth() > depth) && next != 1) {
                Context context2;
                if (next == 2) {
                    String name = xmlPullParser.getName();
                    if (name.equals("objectAnimator")) {
                        Animator objectAnimator = new ObjectAnimator();
                        m370a(context, resources2, theme2, attributeSet, objectAnimator, f, xmlPullParser2);
                        context2 = context;
                        animator = objectAnimator;
                    } else if (name.equals("animator")) {
                        animator = m370a(context, resources2, theme2, attributeSet, null, f, xmlPullParser2);
                        context2 = context;
                    } else if (name.equals("set")) {
                        Animator animatorSet3 = new AnimatorSet();
                        AttributeSet attributeSet2 = attributeSet;
                        TypedArray a = TypedArrayUtils.m780a(resources2, theme2, attributeSet2, AndroidResources.f735h);
                        Context context3 = context;
                        Resources resources3 = resources2;
                        Theme theme3 = theme2;
                        XmlPullParser xmlPullParser3 = xmlPullParser2;
                        AttributeSet attributeSet3 = attributeSet2;
                        TypedArray typedArray = a;
                        m367a(context3, resources3, theme3, xmlPullParser3, attributeSet3, (AnimatorSet) animatorSet3, TypedArrayUtils.m779a(a, xmlPullParser2, "ordering", 0, 0), f);
                        typedArray.recycle();
                        context2 = context;
                        animator = animatorSet3;
                        i2 = 0;
                    } else if (name.equals("propertyValuesHolder")) {
                        PropertyValuesHolder[] a2 = m374a(context, resources2, theme2, xmlPullParser2, Xml.asAttributeSet(xmlPullParser));
                        if (!(a2 == null || animator == null || !(animator instanceof ValueAnimator))) {
                            ((ValueAnimator) animator).setValues(a2);
                        }
                        i2 = 1;
                    } else {
                        StringBuilder stringBuilder = new StringBuilder("Unknown animator name: ");
                        stringBuilder.append(xmlPullParser.getName());
                        throw new RuntimeException(stringBuilder.toString());
                    }
                    if (animatorSet2 != null && r14 == 0) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(animator);
                    }
                } else {
                    context2 = context;
                }
            }
        }
        if (!(animatorSet2 == null || arrayList == null)) {
            Animator[] animatorArr = new Animator[arrayList.size()];
            Iterator it = arrayList.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                int i4 = i3 + 1;
                animatorArr[i3] = (Animator) it.next();
                i3 = i4;
            }
            if (i == 0) {
                animatorSet2.playTogether(animatorArr);
            } else {
                animatorSet2.playSequentially(animatorArr);
            }
        }
        return animator;
    }

    private static PropertyValuesHolder[] m374a(Context context, Resources resources, Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Resources resources2 = resources;
        Theme theme2 = theme;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        ArrayList arrayList = null;
        while (true) {
            int i;
            int eventType = xmlPullParser.getEventType();
            if (eventType != 3) {
                i = 1;
                if (eventType != 1) {
                    if (eventType != 2) {
                        xmlPullParser.next();
                    } else {
                        Context context2;
                        if (xmlPullParser.getName().equals("propertyValuesHolder")) {
                            TypedArray a = TypedArrayUtils.m780a(resources2, theme2, attributeSet, AndroidResources.f736i);
                            String b = TypedArrayUtils.m788b(a, xmlPullParser2, "propertyName", 3);
                            int i2 = 4;
                            int a2 = TypedArrayUtils.m779a(a, xmlPullParser2, "valueType", 2, 4);
                            int i3 = a2;
                            ArrayList arrayList2 = null;
                            while (true) {
                                int next = xmlPullParser.next();
                                if (next == 3 || next == r8) {
                                    Object ofKeyframe;
                                    context2 = context;
                                    if (arrayList2 != null) {
                                        int size = arrayList2.size();
                                        if (size > 0) {
                                            Keyframe keyframe = (Keyframe) arrayList2.get(0);
                                            Keyframe keyframe2 = (Keyframe) arrayList2.get(size - 1);
                                            float fraction = keyframe2.getFraction();
                                            if (fraction < 1.0f) {
                                                if (fraction < 0.0f) {
                                                    keyframe2.setFraction(1.0f);
                                                } else {
                                                    arrayList2.add(arrayList2.size(), m368a(keyframe2, 1.0f));
                                                    size++;
                                                }
                                            }
                                            float fraction2 = keyframe.getFraction();
                                            if (fraction2 != 0.0f) {
                                                if (fraction2 < 0.0f) {
                                                    keyframe.setFraction(0.0f);
                                                } else {
                                                    arrayList2.add(0, m368a(keyframe, 0.0f));
                                                    size++;
                                                }
                                            }
                                            Keyframe[] keyframeArr = new Keyframe[size];
                                            arrayList2.toArray(keyframeArr);
                                            i = 0;
                                            while (i < size) {
                                                Keyframe keyframe3 = keyframeArr[i];
                                                if (keyframe3.getFraction() < 0.0f) {
                                                    if (i == 0) {
                                                        keyframe3.setFraction(0.0f);
                                                    } else {
                                                        int i4 = size - 1;
                                                        if (i == i4) {
                                                            keyframe3.setFraction(1.0f);
                                                        } else {
                                                            int i5 = i + 1;
                                                            i2 = i;
                                                            while (i5 < i4) {
                                                                if (keyframeArr[i5].getFraction() < 0.0f) {
                                                                    i2 = i5;
                                                                    i5++;
                                                                    resources2 = resources;
                                                                } else {
                                                                    m372a(keyframeArr, keyframeArr[i2 + 1].getFraction() - keyframeArr[i - 1].getFraction(), i, i2);
                                                                }
                                                            }
                                                            m372a(keyframeArr, keyframeArr[i2 + 1].getFraction() - keyframeArr[i - 1].getFraction(), i, i2);
                                                        }
                                                        i++;
                                                        resources2 = resources;
                                                    }
                                                }
                                                float f = 0.0f;
                                                i++;
                                                resources2 = resources;
                                            }
                                            ofKeyframe = PropertyValuesHolder.ofKeyframe(b, keyframeArr);
                                            if (i3 == 3) {
                                                ofKeyframe.setEvaluator(ArgbEvaluator.m375a());
                                            }
                                            if (ofKeyframe == null) {
                                                ofKeyframe = m369a(a, a2, 0, 1, b);
                                            }
                                            if (ofKeyframe != null) {
                                                if (arrayList == null) {
                                                    arrayList = new ArrayList();
                                                }
                                                arrayList.add(ofKeyframe);
                                            }
                                            a.recycle();
                                        }
                                    }
                                    ofKeyframe = null;
                                    if (ofKeyframe == null) {
                                        ofKeyframe = m369a(a, a2, 0, 1, b);
                                    }
                                    if (ofKeyframe != null) {
                                        if (arrayList == null) {
                                            arrayList = new ArrayList();
                                        }
                                        arrayList.add(ofKeyframe);
                                    }
                                    a.recycle();
                                } else {
                                    if (xmlPullParser.getName().equals("keyframe")) {
                                        TypedArray a3;
                                        Keyframe ofFloat;
                                        if (i3 == i2) {
                                            a3 = TypedArrayUtils.m780a(resources2, theme2, Xml.asAttributeSet(xmlPullParser), AndroidResources.f737j);
                                            TypedValue a4 = TypedArrayUtils.m782a(a3, xmlPullParser2, "value");
                                            i3 = ((a4 != null ? 1 : 0) == 0 || !m373a(a4.type)) ? 0 : 3;
                                            a3.recycle();
                                        }
                                        a3 = TypedArrayUtils.m780a(resources2, theme2, Xml.asAttributeSet(xmlPullParser), AndroidResources.f737j);
                                        float a5 = TypedArrayUtils.m775a(a3, xmlPullParser2, "fraction", 3, -1.0f);
                                        TypedValue a6 = TypedArrayUtils.m782a(a3, xmlPullParser2, "value");
                                        int i6 = a6 != null ? 1 : 0;
                                        next = i3 == i2 ? (i6 == 0 || !m373a(a6.type)) ? 0 : 3 : i3;
                                        if (i6 != 0) {
                                            if (next != 3) {
                                                switch (next) {
                                                    case 0:
                                                        ofFloat = Keyframe.ofFloat(a5, TypedArrayUtils.m775a(a3, xmlPullParser2, "value", 0, 0.0f));
                                                        break;
                                                    case 1:
                                                        break;
                                                    default:
                                                        ofFloat = null;
                                                        break;
                                                }
                                            }
                                            ofFloat = Keyframe.ofInt(a5, TypedArrayUtils.m779a(a3, xmlPullParser2, "value", 0, 0));
                                        } else if (next == 0) {
                                            ofFloat = Keyframe.ofFloat(a5);
                                        } else {
                                            ofFloat = Keyframe.ofInt(a5);
                                        }
                                        i2 = TypedArrayUtils.m778a(a3, xmlPullParser2, "interpolator", 1);
                                        if (i2 > 0) {
                                            ofFloat.setInterpolator(AnimationUtilsCompat.m364a(context, i2));
                                        } else {
                                            context2 = context;
                                        }
                                        a3.recycle();
                                        if (ofFloat != null) {
                                            if (arrayList2 == null) {
                                                arrayList2 = new ArrayList();
                                            }
                                            arrayList2.add(ofFloat);
                                        }
                                        xmlPullParser.next();
                                    } else {
                                        context2 = context;
                                    }
                                    i = 1;
                                    i2 = 4;
                                }
                            }
                        } else {
                            context2 = context;
                            AttributeSet attributeSet2 = attributeSet;
                        }
                        xmlPullParser.next();
                        resources2 = resources;
                    }
                }
            }
            if (arrayList == null) {
                return null;
            }
            int size2 = arrayList.size();
            PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[size2];
            for (i = 0; i < size2; i++) {
                propertyValuesHolderArr[i] = (PropertyValuesHolder) arrayList.get(i);
            }
            return propertyValuesHolderArr;
        }
    }

    private static Keyframe m368a(Keyframe keyframe, float f) {
        if (keyframe.getType() == Float.TYPE) {
            return Keyframe.ofFloat(f);
        }
        if (keyframe.getType() == Integer.TYPE) {
            return Keyframe.ofInt(f);
        }
        return Keyframe.ofObject(f);
    }

    private static void m372a(Keyframe[] keyframeArr, float f, int i, int i2) {
        f /= (float) ((i2 - i) + 2);
        while (i <= i2) {
            keyframeArr[i].setFraction(keyframeArr[i - 1].getFraction() + f);
            i++;
        }
    }

    private static ValueAnimator m370a(Context context, Resources resources, Theme theme, AttributeSet attributeSet, ValueAnimator valueAnimator, float f, XmlPullParser xmlPullParser) throws NotFoundException {
        Resources resources2 = resources;
        Theme theme2 = theme;
        AttributeSet attributeSet2 = attributeSet;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        TypedArray a = TypedArrayUtils.m780a(resources2, theme2, attributeSet2, AndroidResources.f734g);
        TypedArray a2 = TypedArrayUtils.m780a(resources2, theme2, attributeSet2, AndroidResources.f738k);
        ValueAnimator valueAnimator2 = valueAnimator == null ? new ValueAnimator() : valueAnimator;
        long a3 = (long) TypedArrayUtils.m779a(a, xmlPullParser2, State.KEY_DURATION, 1, 300);
        long a4 = (long) TypedArrayUtils.m779a(a, xmlPullParser2, "startOffset", 2, 0);
        int a5 = TypedArrayUtils.m779a(a, xmlPullParser2, "valueType", 7, 4);
        if (TypedArrayUtils.m785a(xmlPullParser2, "valueFrom") && TypedArrayUtils.m785a(xmlPullParser2, "valueTo")) {
            if (a5 == 4) {
                TypedValue peekValue = a.peekValue(5);
                int i = peekValue != null ? 1 : 0;
                a5 = i != 0 ? peekValue.type : 0;
                TypedValue peekValue2 = a.peekValue(6);
                int i2 = peekValue2 != null ? 1 : 0;
                a5 = ((i == 0 || !m373a(a5)) && (i2 == 0 || !m373a(i2 != 0 ? peekValue2.type : 0))) ? 0 : 3;
            }
            if (m369a(a, a5, 5, 6, "") != null) {
                valueAnimator2.setValues(new PropertyValuesHolder[]{m369a(a, a5, 5, 6, "")});
            }
        }
        valueAnimator2.setDuration(a3);
        valueAnimator2.setStartDelay(a4);
        valueAnimator2.setRepeatCount(TypedArrayUtils.m779a(a, xmlPullParser2, "repeatCount", 3, 0));
        valueAnimator2.setRepeatMode(TypedArrayUtils.m779a(a, xmlPullParser2, "repeatMode", 4, 1));
        if (a2 != null) {
            ObjectAnimator objectAnimator = (ObjectAnimator) valueAnimator2;
            String b = TypedArrayUtils.m788b(a2, xmlPullParser2, "pathData", 1);
            if (b != null) {
                String b2 = TypedArrayUtils.m788b(a2, xmlPullParser2, "propertyXName", 2);
                String b3 = TypedArrayUtils.m788b(a2, xmlPullParser2, "propertyYName", 3);
                if (b2 == null && b3 == null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(a2.getPositionDescription());
                    stringBuilder.append(" propertyXName or propertyYName is needed for PathData");
                    throw new InflateException(stringBuilder.toString());
                }
                m371a(PathParser.m804a(b), objectAnimator, 0.5f * f, b2, b3);
            } else {
                objectAnimator.setPropertyName(TypedArrayUtils.m788b(a2, xmlPullParser2, "propertyName", 0));
            }
        }
        a5 = TypedArrayUtils.m778a(a, xmlPullParser2, "interpolator", 0);
        if (a5 > 0) {
            valueAnimator2.setInterpolator(AnimationUtilsCompat.m364a(context, a5));
        }
        a.recycle();
        if (a2 != null) {
            a2.recycle();
        }
        return valueAnimator2;
    }
}
