package android.support.v4.widget;

import android.database.Cursor;
import android.widget.Filter;
import android.widget.Filter.FilterResults;

class CursorFilter extends Filter {
    CursorFilterClient f1605a;

    interface CursorFilterClient {
        Cursor mo383a();

        Cursor mo384a(CharSequence charSequence);

        void mo385a(Cursor cursor);

        CharSequence mo386b(Cursor cursor);
    }

    CursorFilter(CursorFilterClient cursorFilterClient) {
        this.f1605a = cursorFilterClient;
    }

    public CharSequence convertResultToString(Object obj) {
        return this.f1605a.mo386b((Cursor) obj);
    }

    protected FilterResults performFiltering(CharSequence charSequence) {
        charSequence = this.f1605a.mo384a(charSequence);
        FilterResults filterResults = new FilterResults();
        if (charSequence != null) {
            filterResults.count = charSequence.getCount();
            filterResults.values = charSequence;
        } else {
            filterResults.count = null;
            filterResults.values = null;
        }
        return filterResults;
    }

    protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
        charSequence = this.f1605a.mo383a();
        if (filterResults.values != null && filterResults.values != charSequence) {
            this.f1605a.mo385a((Cursor) filterResults.values);
        }
    }
}
