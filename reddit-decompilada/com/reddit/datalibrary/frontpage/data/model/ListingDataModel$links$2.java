package com.reddit.datalibrary.frontpage.data.model;

import com.raizlabs.android.dbflow.kotlinextensions.OperatorExtensionsKt;
import com.raizlabs.android.dbflow.kotlinextensions.QueryExtensionsKt;
import com.raizlabs.android.dbflow.sql.language.IConditional;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.raizlabs.android.dbflow.sql.language.SQLOperator;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.sql.language.Select;
import com.raizlabs.android.dbflow.sql.language.Where;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;
import com.raizlabs.android.dbflow.sql.language.property.Property;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/raizlabs/android/dbflow/sql/language/Where;", "Lcom/reddit/datalibrary/frontpage/data/model/LinkDataModel;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: ListingDataModel.kt */
final class ListingDataModel$links$2 extends Lambda implements Function0<Where<LinkDataModel>> {
    final /* synthetic */ ListingDataModel this$0;

    ListingDataModel$links$2(ListingDataModel listingDataModel) {
        this.this$0 = listingDataModel;
        super(0);
    }

    public final Where<LinkDataModel> invoke() {
        Select select = SQLite.select(new IProperty[0]);
        Intrinsics.a(select, "SQLite.select()");
        Where where = QueryExtensionsKt.leftOuterJoin(QueryExtensionsKt.from(select, Reflection.a(LinkDataModel.class)), Reflection.a(LinkMutationsDataModel.class)).on(LinkDataModel_Table.linkId.withTable().eq((IConditional) LinkMutationsDataModel_Table.linkId.withTable())).where(LinkDataModel_Table.listing_id.eq(Long.valueOf(this.this$0.getId())));
        Operator eq = LinkMutationsDataModel_Table.isHidden.withTable().eq(Boolean.valueOf(false));
        Intrinsics.a(eq, "LinkMutationsDataModel_T…den.withTable().eq(false)");
        Property withTable = LinkMutationsDataModel_Table.isHidden.withTable();
        Intrinsics.a(withTable, "LinkMutationsDataModel_Table.isHidden.withTable()");
        Operator isNull = withTable.isNull();
        Intrinsics.a(isNull, "LinkMutationsDataModel_T…Hidden.withTable().isNull");
        return where.and(OperatorExtensionsKt.or(eq, (SQLOperator) isNull)).orderBy(LinkDataModel_Table.listingPosition.asc());
    }
}
