package ru.ima.smedialinktest1.myitems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class MyitemsHistoryContentProvider {

    /**
     * An array of items.
     */
    public static List<MyitemsContentProvider.MyListItem> ITEMS = new ArrayList<MyitemsContentProvider.MyListItem>(10);

    /**
     * A map of items by ID.
     */
    public static Map<String, MyitemsContentProvider.MyListItem> ITEM_MAP = new HashMap<String, MyitemsContentProvider.MyListItem>();

    public static void addItem(MyitemsContentProvider.MyListItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }
}
