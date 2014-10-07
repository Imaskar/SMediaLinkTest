package ru.ima.smedialinktest1.myitems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class MyitemsContentProvider {

    public static List<MyListItem> ITEMS = new ArrayList<MyListItem>(100);

    public static Map<String, MyListItem> ITEM_MAP = new HashMap<String, MyListItem>();

    static {
        // TODO: restore maybe?
        for (int i=0;i<100;i++) {
            addItem(new MyListItem(String.valueOf(i), String.valueOf(i), 0));
        }
    }

    private static void addItem(MyListItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    /**
     * An item representing a piece of content.
     */
    public static class MyListItem implements Cloneable {
        public String id;
        public String content;
        public float fillRatio;

        public MyListItem(String id, String content, float fillRatio) {
            this.id = id;
            this.content = content;
            this.fillRatio = fillRatio;
        }

        @Override
        public String toString() {
            return content;
        }
        @Override
        public MyListItem clone(){
            return new MyListItem(id,content,fillRatio);
        }
    }
}
