package android.support.transition;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TransitionValues {
    public final Map<String, Object> f902a = new HashMap();
    public View f903b;
    final ArrayList<Transition> f904c = new ArrayList();

    public boolean equals(Object obj) {
        if (obj instanceof TransitionValues) {
            TransitionValues transitionValues = (TransitionValues) obj;
            if (this.f903b == transitionValues.f903b && this.f902a.equals(transitionValues.f902a) != null) {
                return true;
            }
        }
        return null;
    }

    public int hashCode() {
        return (31 * this.f903b.hashCode()) + this.f902a.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("TransitionValues@");
        stringBuilder.append(Integer.toHexString(hashCode()));
        stringBuilder.append(":\n");
        String stringBuilder2 = stringBuilder.toString();
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(stringBuilder2);
        stringBuilder3.append("    view = ");
        stringBuilder3.append(this.f903b);
        stringBuilder3.append("\n");
        stringBuilder2 = stringBuilder3.toString();
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(stringBuilder2);
        stringBuilder3.append("    values:");
        stringBuilder2 = stringBuilder3.toString();
        for (String str : this.f902a.keySet()) {
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append(stringBuilder2);
            stringBuilder4.append("    ");
            stringBuilder4.append(str);
            stringBuilder4.append(": ");
            stringBuilder4.append(this.f902a.get(str));
            stringBuilder4.append("\n");
            stringBuilder2 = stringBuilder4.toString();
        }
        return stringBuilder2;
    }
}
