package android.support.graphics.drawable;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.content.res.XmlResourceParser;
import android.os.Build.VERSION;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

public class AnimationUtilsCompat {
    public static Interpolator m364a(Context context, int i) throws NotFoundException {
        StringBuilder stringBuilder;
        NotFoundException notFoundException;
        if (VERSION.SDK_INT >= 21) {
            return AnimationUtils.loadInterpolator(context, i);
        }
        Interpolator interpolator = null;
        XmlResourceParser xmlResourceParser;
        if (i == 17563663) {
            try {
                return new FastOutLinearInInterpolator();
            } catch (XmlPullParserException e) {
                context = e;
                stringBuilder = new StringBuilder("Can't load animation resource ID #0x");
                stringBuilder.append(Integer.toHexString(i));
                notFoundException = new NotFoundException(stringBuilder.toString());
                notFoundException.initCause(context);
                throw notFoundException;
            } catch (IOException e2) {
                context = e2;
                try {
                    stringBuilder = new StringBuilder("Can't load animation resource ID #0x");
                    stringBuilder.append(Integer.toHexString(i));
                    notFoundException = new NotFoundException(stringBuilder.toString());
                    notFoundException.initCause(context);
                    throw notFoundException;
                } catch (Throwable th) {
                    context = th;
                    xmlResourceParser = interpolator;
                    if (xmlResourceParser != null) {
                        xmlResourceParser.close();
                    }
                    throw context;
                }
            }
        } else if (i == 17563661) {
            return new FastOutSlowInInterpolator();
        } else {
            if (i == 17563662) {
                return new LinearOutSlowInInterpolator();
            }
            xmlResourceParser = context.getResources().getAnimation(i);
            try {
                context.getResources();
                context.getTheme();
                int depth = xmlResourceParser.getDepth();
                while (true) {
                    int next = xmlResourceParser.next();
                    if ((next != 3 || xmlResourceParser.getDepth() > depth) && next != 1) {
                        if (next == 2) {
                            AttributeSet asAttributeSet = Xml.asAttributeSet(xmlResourceParser);
                            String name = xmlResourceParser.getName();
                            if (name.equals("linearInterpolator")) {
                                interpolator = new LinearInterpolator();
                            } else {
                                AccelerateInterpolator accelerateInterpolator;
                                if (name.equals("accelerateInterpolator")) {
                                    accelerateInterpolator = new AccelerateInterpolator(context, asAttributeSet);
                                } else if (name.equals("decelerateInterpolator")) {
                                    accelerateInterpolator = new DecelerateInterpolator(context, asAttributeSet);
                                } else if (name.equals("accelerateDecelerateInterpolator")) {
                                    interpolator = new AccelerateDecelerateInterpolator();
                                } else if (name.equals("cycleInterpolator")) {
                                    accelerateInterpolator = new CycleInterpolator(context, asAttributeSet);
                                } else if (name.equals("anticipateInterpolator")) {
                                    accelerateInterpolator = new AnticipateInterpolator(context, asAttributeSet);
                                } else if (name.equals("overshootInterpolator")) {
                                    accelerateInterpolator = new OvershootInterpolator(context, asAttributeSet);
                                } else if (name.equals("anticipateOvershootInterpolator")) {
                                    accelerateInterpolator = new AnticipateOvershootInterpolator(context, asAttributeSet);
                                } else if (name.equals("bounceInterpolator")) {
                                    interpolator = new BounceInterpolator();
                                } else if (name.equals("pathInterpolator")) {
                                    accelerateInterpolator = new PathInterpolatorCompat(context, asAttributeSet, xmlResourceParser);
                                } else {
                                    StringBuilder stringBuilder2 = new StringBuilder("Unknown interpolator name: ");
                                    stringBuilder2.append(xmlResourceParser.getName());
                                    throw new RuntimeException(stringBuilder2.toString());
                                }
                                interpolator = accelerateInterpolator;
                            }
                        }
                    }
                }
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
                return interpolator;
            } catch (XmlPullParserException e3) {
                context = e3;
                XmlResourceParser xmlResourceParser2 = xmlResourceParser;
                stringBuilder = new StringBuilder("Can't load animation resource ID #0x");
                stringBuilder.append(Integer.toHexString(i));
                notFoundException = new NotFoundException(stringBuilder.toString());
                notFoundException.initCause(context);
                throw notFoundException;
            } catch (IOException e4) {
                context = e4;
                interpolator = xmlResourceParser;
                stringBuilder = new StringBuilder("Can't load animation resource ID #0x");
                stringBuilder.append(Integer.toHexString(i));
                notFoundException = new NotFoundException(stringBuilder.toString());
                notFoundException.initCause(context);
                throw notFoundException;
            } catch (Throwable th2) {
                context = th2;
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
                throw context;
            }
        }
    }
}
