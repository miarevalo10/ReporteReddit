package org.apache.commons.cli;

import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class OptionGroup implements Serializable {
    String f26709a;
    boolean f26710b;
    private Map f26711c = new HashMap();

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = this.f26711c.values().iterator();
        stringBuffer.append("[");
        while (it.hasNext()) {
            Option option = (Option) it.next();
            if (option.f26699a != null) {
                stringBuffer.append(Operation.MINUS);
                stringBuffer.append(option.f26699a);
            } else {
                stringBuffer.append("--");
                stringBuffer.append(option.f26700b);
            }
            stringBuffer.append(" ");
            stringBuffer.append(option.f26702d);
            if (it.hasNext()) {
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
