package org.jsoup.select;

import java.util.Iterator;
import org.jsoup.nodes.Element;
import org.jsoup.select.Evaluator.AllElements;

abstract class StructuralEvaluator extends Evaluator {
    Evaluator f33403a;

    static class Root extends Evaluator {
        public final boolean mo6353a(Element element, Element element2) {
            return element == element2;
        }

        Root() {
        }
    }

    static class Has extends StructuralEvaluator {
        public Has(Evaluator evaluator) {
            this.a = evaluator;
        }

        public String toString() {
            return String.format(":has(%s)", new Object[]{this.a});
        }

        public final boolean mo6353a(Element element, Element element2) {
            Iterator it = Collector.m28624a(new AllElements(), element2).iterator();
            while (it.hasNext()) {
                Element element3 = (Element) it.next();
                if (element3 != element2 && this.a.mo6353a(element, element3)) {
                    return true;
                }
            }
            return null;
        }
    }

    static class ImmediateParent extends StructuralEvaluator {
        public ImmediateParent(Evaluator evaluator) {
            this.a = evaluator;
        }

        public String toString() {
            return String.format(":ImmediateParent%s", new Object[]{this.a});
        }

        public final boolean mo6353a(Element element, Element element2) {
            if (element == element2) {
                return false;
            }
            element2 = element2.d;
            if (element2 == null || this.a.mo6353a(element, element2) == null) {
                return false;
            }
            return true;
        }
    }

    static class ImmediatePreviousSibling extends StructuralEvaluator {
        public ImmediatePreviousSibling(Evaluator evaluator) {
            this.a = evaluator;
        }

        public final boolean mo6353a(Element element, Element element2) {
            if (element == element2) {
                return false;
            }
            element2 = element2.m33936g();
            if (element2 == null || this.a.mo6353a(element, element2) == null) {
                return false;
            }
            return true;
        }

        public String toString() {
            return String.format(":prev%s", new Object[]{this.a});
        }
    }

    static class Not extends StructuralEvaluator {
        public Not(Evaluator evaluator) {
            this.a = evaluator;
        }

        public final boolean mo6353a(Element element, Element element2) {
            return this.a.mo6353a(element, element2) == null ? true : null;
        }

        public String toString() {
            return String.format(":not%s", new Object[]{this.a});
        }
    }

    static class Parent extends StructuralEvaluator {
        public Parent(Evaluator evaluator) {
            this.a = evaluator;
        }

        public String toString() {
            return String.format(":parent%s", new Object[]{this.a});
        }

        public final boolean mo6353a(Element element, Element element2) {
            if (element == element2) {
                return false;
            }
            do {
                element2 = element2.d;
                if (this.a.mo6353a(element, element2)) {
                    return true;
                }
            } while (element2 != element);
            return false;
        }
    }

    static class PreviousSibling extends StructuralEvaluator {
        public PreviousSibling(Evaluator evaluator) {
            this.a = evaluator;
        }

        public final boolean mo6353a(Element element, Element element2) {
            if (element == element2) {
                return false;
            }
            for (element2 = element2.m33936g(); element2 != null; element2 = element2.m33936g()) {
                if (this.a.mo6353a(element, element2)) {
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            return String.format(":prev*%s", new Object[]{this.a});
        }
    }

    StructuralEvaluator() {
    }
}
