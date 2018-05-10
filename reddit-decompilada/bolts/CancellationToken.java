package bolts;

import java.util.Locale;

public class CancellationToken {
    final CancellationTokenSource f2697a;

    public String toString() {
        return String.format(Locale.US, "%s@%s[cancellationRequested=%s]", new Object[]{getClass().getName(), Integer.toHexString(hashCode()), Boolean.toString(this.f2697a.m2402a())});
    }
}
