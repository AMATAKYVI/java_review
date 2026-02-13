package d4.GenericExtras;

import java.util.ArrayList;
import java.util.List;

public class QueryList<T extends QueryItem> {

    private List<T> items;

    public QueryList(List<T> items) {
        this.items = items;
    }

    public List<T> query(String fieldName, String value) {
        List<T> result = new ArrayList<>();
        for (T item : items) {
            if (item.matchFieldValue(fieldName, value)) {
                result.add(item);
            }
        }
        return result;
    }

}
