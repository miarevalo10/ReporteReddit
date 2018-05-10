package android.support.transition;

import android.view.View;
import android.view.ViewGroup;

public class Scene {
    ViewGroup f851a;
    Runnable f852b;

    static void m440a(View view) {
        view.setTag(C0069R.id.transition_current_scene, null);
    }

    static Scene m441b(View view) {
        return (Scene) view.getTag(C0069R.id.transition_current_scene);
    }
}
