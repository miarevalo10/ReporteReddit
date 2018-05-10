package com.raizlabs.android.dbflow.rx2.language;

import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.runtime.OnTableChangedListener;
import com.raizlabs.android.dbflow.runtime.TableNotifierRegister;
import com.raizlabs.android.dbflow.sql.language.From;
import com.raizlabs.android.dbflow.sql.language.Where;
import com.raizlabs.android.dbflow.sql.queriable.ModelQueriable;
import com.raizlabs.android.dbflow.structure.BaseModel.Action;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.disposables.Disposables;

public class TableChangeOnSubscribe<TModel> implements FlowableOnSubscribe<ModelQueriable<TModel>> {
    private FlowableEmitter<ModelQueriable<TModel>> flowableEmitter;
    private final ModelQueriable<TModel> modelQueriable;
    private final OnTableChangedListener onTableChangedListener = new C14662();
    private final TableNotifierRegister register;

    class C08591 implements Runnable {
        C08591() {
        }

        public void run() {
            TableChangeOnSubscribe.this.register.unregisterAll();
        }
    }

    class C14662 implements OnTableChangedListener {
        C14662() {
        }

        public void onTableChanged(Class<?> cls, Action action) {
            if (TableChangeOnSubscribe.this.modelQueriable.getTable().equals(cls) != null) {
                TableChangeOnSubscribe.this.flowableEmitter.a(TableChangeOnSubscribe.this.modelQueriable);
            }
        }
    }

    public TableChangeOnSubscribe(ModelQueriable<TModel> modelQueriable) {
        this.modelQueriable = modelQueriable;
        this.register = FlowManager.newRegisterForTable(modelQueriable.getTable());
    }

    public void subscribe(FlowableEmitter<ModelQueriable<TModel>> flowableEmitter) throws Exception {
        this.flowableEmitter = flowableEmitter;
        this.flowableEmitter.a(Disposables.a(new C08591()));
        flowableEmitter = (this.modelQueriable instanceof From) != null ? (From) this.modelQueriable : ((this.modelQueriable instanceof Where) == null || (((Where) this.modelQueriable).getWhereBase() instanceof From) == null) ? null : (From) ((Where) this.modelQueriable).getWhereBase();
        if (flowableEmitter != null) {
            flowableEmitter = flowableEmitter.getAssociatedTables().iterator();
            while (flowableEmitter.hasNext()) {
                this.register.register((Class) flowableEmitter.next());
            }
        } else {
            this.register.register(this.modelQueriable.getTable());
        }
        this.register.setListener(this.onTableChangedListener);
        this.flowableEmitter.a(this.modelQueriable);
    }
}
