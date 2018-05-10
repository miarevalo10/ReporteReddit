package com.googlecode.mp4parser;

import org.mp4parser.aspectj.lang.JoinPoint;
import org.mp4parser.aspectj.lang.NoAspectBoundException;

public class RequiresParseDetailAspect {
    public static final RequiresParseDetailAspect f8875a;
    private static Throwable f8876b;

    public static RequiresParseDetailAspect m7623a() {
        if (f8875a != null) {
            return f8875a;
        }
        throw new NoAspectBoundException("com.googlecode.mp4parser.RequiresParseDetailAspect", f8876b);
    }

    public static void m7624a(JoinPoint joinPoint) {
        if (!(joinPoint.a() instanceof AbstractBox)) {
            StringBuilder stringBuilder = new StringBuilder("Only methods in subclasses of ");
            stringBuilder.append(AbstractBox.class.getName());
            stringBuilder.append(" can  be annotated with ParseDetail");
            throw new RuntimeException(stringBuilder.toString());
        } else if (!((AbstractBox) joinPoint.a()).isParsed()) {
            ((AbstractBox) joinPoint.a()).parseDetails();
        }
    }

    static {
        try {
            f8875a = new RequiresParseDetailAspect();
        } catch (Throwable th) {
            f8876b = th;
        }
    }
}
