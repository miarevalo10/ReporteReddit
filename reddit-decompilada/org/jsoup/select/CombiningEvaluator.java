package org.jsoup.select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Element;

abstract class CombiningEvaluator extends Evaluator {
    final ArrayList<Evaluator> f33383a;
    int f33384b;

    static final class And extends CombiningEvaluator {
        And(Collection<Evaluator> collection) {
            super(collection);
        }

        And(Evaluator... evaluatorArr) {
            this(Arrays.asList(evaluatorArr));
        }

        public final boolean mo6353a(Element element, Element element2) {
            for (int i = 0; i < this.b; i++) {
                if (!((Evaluator) this.a.get(i)).mo6353a(element, element2)) {
                    return false;
                }
            }
            return true;
        }

        public final String toString() {
            return StringUtil.m28444a(this.a, " ");
        }
    }

    static final class Or extends CombiningEvaluator {
        private Or(Collection<Evaluator> collection) {
            if (this.b > 1) {
                this.a.add(new And((Collection) collection));
            } else {
                this.a.addAll(collection);
            }
            m34146a();
        }

        Or(Evaluator... evaluatorArr) {
            this(Arrays.asList(evaluatorArr));
        }

        Or() {
        }

        public final void m36609a(Evaluator evaluator) {
            this.a.add(evaluator);
            m34146a();
        }

        public final boolean mo6353a(Element element, Element element2) {
            for (int i = 0; i < this.b; i++) {
                if (((Evaluator) this.a.get(i)).mo6353a(element, element2)) {
                    return true;
                }
            }
            return false;
        }

        public final String toString() {
            return String.format(":or%s", new Object[]{this.a});
        }
    }

    CombiningEvaluator() {
        this.f33384b = 0;
        this.f33383a = new ArrayList();
    }

    CombiningEvaluator(Collection<Evaluator> collection) {
        this();
        this.f33383a.addAll(collection);
        m34146a();
    }

    final void m34146a() {
        this.f33384b = this.f33383a.size();
    }
}
