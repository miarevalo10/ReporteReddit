package kotlin.reflect.jvm.internal.impl.resolve.scopes;

/* compiled from: MemberScope.kt */
public abstract class DescriptorKindExclude {

    /* compiled from: MemberScope.kt */
    public static final class NonExtensions extends DescriptorKindExclude {
        public static final NonExtensions f32950a = null;
        private static final int f32951b = 0;

        private NonExtensions() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindExclude.NonExtensions.<init>():void
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:256)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: jadx.core.utils.exceptions.DecodeException: Unknown instruction: not-int
	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:568)
	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:56)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:102)
	... 6 more
*/
            /*
            // Can't load method instructions.
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindExclude.NonExtensions.<init>():void");
        }

        static {
            NonExtensions nonExtensions = new NonExtensions();
        }

        public final int mo5778a() {
            return f32951b;
        }
    }

    /* compiled from: MemberScope.kt */
    public static final class TopLevelPackages extends DescriptorKindExclude {
        public static final TopLevelPackages f32952a = null;

        public final int mo5778a() {
            return 0;
        }

        static {
            TopLevelPackages topLevelPackages = new TopLevelPackages();
        }

        private TopLevelPackages() {
            f32952a = this;
        }
    }

    public abstract int mo5778a();

    public String toString() {
        return getClass().getSimpleName();
    }
}
