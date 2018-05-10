package kotlin.reflect.jvm.internal.impl.utils;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import kotlin.jvm.functions.Function1;

public class DFS {

    public interface Neighbors<N> {
        Iterable<? extends N> mo5785a(N n);
    }

    public interface NodeHandler<N, R> {
        R mo6700a();

        boolean mo5948a(N n);

        void mo5949b(N n);
    }

    public interface Visited<N> {
        boolean mo5950a(N n);
    }

    public static abstract class AbstractNodeHandler<N, R> implements NodeHandler<N, R> {
        public boolean mo5948a(N n) {
            return true;
        }

        public void mo5949b(N n) {
        }
    }

    public static class VisitedWithSet<N> implements Visited<N> {
        private final Set<N> f33099a;

        public VisitedWithSet() {
            this(new HashSet());
        }

        private VisitedWithSet(Set<N> set) {
            this.f33099a = set;
        }

        public final boolean mo5950a(N n) {
            return this.f33099a.add(n);
        }
    }

    private static <N, R> R m28102a(Collection<N> collection, Neighbors<N> neighbors, Visited<N> visited, NodeHandler<N, R> nodeHandler) {
        if (collection == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"nodes", "kotlin/reflect/jvm/internal/impl/utils/DFS", "dfs"}));
        } else if (neighbors == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"neighbors", "kotlin/reflect/jvm/internal/impl/utils/DFS", "dfs"}));
        } else if (nodeHandler == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"handler", "kotlin/reflect/jvm/internal/impl/utils/DFS", "dfs"}));
        } else {
            for (N a : collection) {
                m28103a((Object) a, (Neighbors) neighbors, (Visited) visited, (NodeHandler) nodeHandler);
            }
            return nodeHandler.mo6700a();
        }
    }

    public static <N, R> R m28101a(Collection<N> collection, Neighbors<N> neighbors, NodeHandler<N, R> nodeHandler) {
        if (collection == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"nodes", "kotlin/reflect/jvm/internal/impl/utils/DFS", "dfs"}));
        } else if (neighbors != null) {
            return m28102a((Collection) collection, (Neighbors) neighbors, new VisitedWithSet(), (NodeHandler) nodeHandler);
        } else {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"neighbors", "kotlin/reflect/jvm/internal/impl/utils/DFS", "dfs"}));
        }
    }

    public static <N> Boolean m28100a(Collection<N> collection, Neighbors<N> neighbors, final Function1<N, Boolean> function1) {
        if (collection == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"nodes", "kotlin/reflect/jvm/internal/impl/utils/DFS", "ifAny"}));
        } else if (neighbors == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"neighbors", "kotlin/reflect/jvm/internal/impl/utils/DFS", "ifAny"}));
        } else if (function1 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"predicate", "kotlin/reflect/jvm/internal/impl/utils/DFS", "ifAny"}));
        } else {
            final boolean[] zArr = new boolean[1];
            return (Boolean) m28101a((Collection) collection, (Neighbors) neighbors, new AbstractNodeHandler<N, Boolean>() {
                public final boolean mo5948a(N n) {
                    if (((Boolean) function1.mo6492a(n)).booleanValue() != null) {
                        zArr[0] = 1;
                    }
                    return zArr[0] == null;
                }

                public final /* synthetic */ Object mo6700a() {
                    return Boolean.valueOf(zArr[0]);
                }
            });
        }
    }

    private static <N> void m28103a(N n, Neighbors<N> neighbors, Visited<N> visited, NodeHandler<N, ?> nodeHandler) {
        if (n == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"current", "kotlin/reflect/jvm/internal/impl/utils/DFS", "doDfs"}));
        } else if (neighbors == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"neighbors", "kotlin/reflect/jvm/internal/impl/utils/DFS", "doDfs"}));
        } else if (visited == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"visited", "kotlin/reflect/jvm/internal/impl/utils/DFS", "doDfs"}));
        } else if (nodeHandler == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"handler", "kotlin/reflect/jvm/internal/impl/utils/DFS", "doDfs"}));
        } else if (visited.mo5950a(n) && nodeHandler.mo5948a(n)) {
            for (Object a : neighbors.mo5785a(n)) {
                m28103a(a, (Neighbors) neighbors, (Visited) visited, (NodeHandler) nodeHandler);
            }
            nodeHandler.mo5949b(n);
        }
    }
}
