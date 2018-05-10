package kotlin.reflect.jvm.internal.impl.load.kotlin.header;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.java.JvmBytecodeBinaryVersion;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

public class ReadKotlinClassHeaderAnnotationVisitor implements AnnotationVisitor {
    private static final boolean f32836i = "true".equals(System.getProperty("kotlin.ignore.old.metadata"));
    private static final Map<ClassId, Kind> f32837j;
    public JvmMetadataVersion f32838a = null;
    public JvmBytecodeBinaryVersion f32839b = null;
    public String f32840c = null;
    public int f32841d = 0;
    public String[] f32842e = null;
    public String[] f32843f = null;
    public String[] f32844g = null;
    public Kind f32845h = null;

    private static abstract class CollectStringArrayAnnotationVisitor implements AnnotationArrayArgumentVisitor {
        private final List<String> f32833a = new ArrayList();

        public final void mo5821a(ClassId classId, Name name) {
            if (classId == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"enumClassId", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$CollectStringArrayAnnotationVisitor", "visitEnum"}));
            } else if (name == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"enumEntryName", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$CollectStringArrayAnnotationVisitor", "visitEnum"}));
            }
        }

        protected abstract void mo6722a(String[] strArr);

        public final void mo5820a(Object obj) {
            if (obj instanceof String) {
                this.f32833a.add((String) obj);
            }
        }

        public final void mo5819a() {
            mo6722a((String[]) this.f32833a.toArray(new String[this.f32833a.size()]));
        }
    }

    private class KotlinMetadataArgumentVisitor implements AnnotationArgumentVisitor {
        final /* synthetic */ ReadKotlinClassHeaderAnnotationVisitor f32834a;

        class C27581 extends CollectStringArrayAnnotationVisitor {
            final /* synthetic */ KotlinMetadataArgumentVisitor f36125a;

            C27581(KotlinMetadataArgumentVisitor kotlinMetadataArgumentVisitor) {
                this.f36125a = kotlinMetadataArgumentVisitor;
            }

            protected final void mo6722a(String[] strArr) {
                if (strArr == null) {
                    throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"result", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor$1", "visitEnd"}));
                } else {
                    this.f36125a.f32834a.f32842e = strArr;
                }
            }
        }

        class C27592 extends CollectStringArrayAnnotationVisitor {
            final /* synthetic */ KotlinMetadataArgumentVisitor f36126a;

            C27592(KotlinMetadataArgumentVisitor kotlinMetadataArgumentVisitor) {
                this.f36126a = kotlinMetadataArgumentVisitor;
            }

            protected final void mo6722a(String[] strArr) {
                if (strArr == null) {
                    throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"result", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor$2", "visitEnd"}));
                } else {
                    this.f36126a.f32834a.f32843f = strArr;
                }
            }
        }

        public final AnnotationArgumentVisitor mo5814a(Name name, ClassId classId) {
            if (name == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"name", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor", "visitAnnotation"}));
            } else if (classId != null) {
                return null;
            } else {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"classId", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor", "visitAnnotation"}));
            }
        }

        public final void mo5816a() {
        }

        public final void mo5818a(Name name, ClassId classId, Name name2) {
            if (name == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"name", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor", "visitEnum"}));
            } else if (classId == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"enumClassId", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor", "visitEnum"}));
            } else if (name2 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"enumEntryName", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor", "visitEnum"}));
            }
        }

        private KotlinMetadataArgumentVisitor(ReadKotlinClassHeaderAnnotationVisitor readKotlinClassHeaderAnnotationVisitor) {
            this.f32834a = readKotlinClassHeaderAnnotationVisitor;
        }

        public final void mo5817a(Name name, Object obj) {
            if (name != null) {
                name = name.m27429a();
                if ("k".equals(name)) {
                    if ((obj instanceof Integer) != null) {
                        this.f32834a.f32845h = Kind.m27384a(((Integer) obj).intValue());
                    }
                } else if ("mv".equals(name)) {
                    if ((obj instanceof int[]) != null) {
                        this.f32834a.f32838a = new JvmMetadataVersion((int[]) obj);
                    }
                } else if ("bv".equals(name)) {
                    if ((obj instanceof int[]) != null) {
                        this.f32834a.f32839b = new JvmBytecodeBinaryVersion((int[]) obj);
                    }
                } else if ("xs".equals(name)) {
                    if ((obj instanceof String) != null) {
                        this.f32834a.f32840c = (String) obj;
                    }
                } else if (!("xi".equals(name) == null || (obj instanceof Integer) == null)) {
                    this.f32834a.f32841d = ((Integer) obj).intValue();
                }
            }
        }

        public final AnnotationArrayArgumentVisitor mo5815a(Name name) {
            if (name == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"name", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor", "visitArray"}));
            }
            name = name.m27429a();
            if ("d1".equals(name)) {
                return new C27581(this);
            }
            return "d2".equals(name) != null ? new C27592(this) : null;
        }
    }

    private class OldDeprecatedAnnotationArgumentVisitor implements AnnotationArgumentVisitor {
        final /* synthetic */ ReadKotlinClassHeaderAnnotationVisitor f32835a;

        class C27601 extends CollectStringArrayAnnotationVisitor {
            final /* synthetic */ OldDeprecatedAnnotationArgumentVisitor f36127a;

            C27601(OldDeprecatedAnnotationArgumentVisitor oldDeprecatedAnnotationArgumentVisitor) {
                this.f36127a = oldDeprecatedAnnotationArgumentVisitor;
            }

            protected final void mo6722a(String[] strArr) {
                if (strArr == null) {
                    throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"data", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor$1", "visitEnd"}));
                } else {
                    this.f36127a.f32835a.f32842e = strArr;
                }
            }
        }

        class C27612 extends CollectStringArrayAnnotationVisitor {
            final /* synthetic */ OldDeprecatedAnnotationArgumentVisitor f36128a;

            C27612(OldDeprecatedAnnotationArgumentVisitor oldDeprecatedAnnotationArgumentVisitor) {
                this.f36128a = oldDeprecatedAnnotationArgumentVisitor;
            }

            protected final void mo6722a(String[] strArr) {
                if (strArr == null) {
                    throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"data", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor$2", "visitEnd"}));
                } else {
                    this.f36128a.f32835a.f32843f = strArr;
                }
            }
        }

        public final AnnotationArgumentVisitor mo5814a(Name name, ClassId classId) {
            if (name == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"name", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor", "visitAnnotation"}));
            } else if (classId != null) {
                return null;
            } else {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"classId", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor", "visitAnnotation"}));
            }
        }

        public final void mo5816a() {
        }

        public final void mo5818a(Name name, ClassId classId, Name name2) {
            if (name == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"name", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor", "visitEnum"}));
            } else if (classId == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"enumClassId", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor", "visitEnum"}));
            } else if (name2 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"enumEntryName", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor", "visitEnum"}));
            }
        }

        private OldDeprecatedAnnotationArgumentVisitor(ReadKotlinClassHeaderAnnotationVisitor readKotlinClassHeaderAnnotationVisitor) {
            this.f32835a = readKotlinClassHeaderAnnotationVisitor;
        }

        public final void mo5817a(Name name, Object obj) {
            if (name != null) {
                name = name.m27429a();
                if ("version".equals(name)) {
                    if ((obj instanceof int[]) != null) {
                        int[] iArr = (int[]) obj;
                        this.f32835a.f32838a = new JvmMetadataVersion(iArr);
                        if (this.f32835a.f32839b == null) {
                            this.f32835a.f32839b = new JvmBytecodeBinaryVersion(iArr);
                        }
                    }
                } else if ("multifileClassName".equals(name) != null) {
                    this.f32835a.f32840c = obj instanceof String ? (String) obj : null;
                }
            }
        }

        public final AnnotationArrayArgumentVisitor mo5815a(Name name) {
            if (name == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"name", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor", "visitArray"}));
            }
            name = name.m27429a();
            if (!"data".equals(name)) {
                if (!"filePartClassNames".equals(name)) {
                    return "strings".equals(name) != null ? new C27612(this) : null;
                }
            }
            return new C27601(this);
        }
    }

    public final void mo5803a() {
    }

    static {
        Map hashMap = new HashMap();
        f32837j = hashMap;
        hashMap.put(ClassId.m27396a(new FqName("kotlin.jvm.internal.KotlinClass")), Kind.f25828b);
        f32837j.put(ClassId.m27396a(new FqName("kotlin.jvm.internal.KotlinFileFacade")), Kind.f25829c);
        f32837j.put(ClassId.m27396a(new FqName("kotlin.jvm.internal.KotlinMultifileClass")), Kind.f25831e);
        f32837j.put(ClassId.m27396a(new FqName("kotlin.jvm.internal.KotlinMultifileClassPart")), Kind.f25832f);
        f32837j.put(ClassId.m27396a(new FqName("kotlin.jvm.internal.KotlinSyntheticClass")), Kind.f25830d);
    }

    public final AnnotationArgumentVisitor mo5802a(ClassId classId, SourceElement sourceElement) {
        if (classId == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"classId", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor", "visitAnnotation"}));
        } else if (classId.m27403f().equals(JvmAnnotationNames.f25630a)) {
            return new KotlinMetadataArgumentVisitor();
        } else {
            if (f32836i || this.f32845h != null) {
                return null;
            }
            Kind kind = (Kind) f32837j.get(classId);
            if (kind == null) {
                return null;
            }
            this.f32845h = kind;
            return new OldDeprecatedAnnotationArgumentVisitor();
        }
    }
}
