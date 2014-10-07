package ru.ima.smedialinktest1.myitems;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import ru.ima.smedialinktest1.R;

/**
 * An adapter to manipulate text and buttons in our custom data.
 * Created by Imaskar on 07 Oct 2014.
 */
public class TextNButtonAdapter extends ArrayAdapter<MyitemsContentProvider.MyListItem> {
    private final Context context;
    private final List<MyitemsContentProvider.MyListItem> values;

    public TextNButtonAdapter(Context context, List<MyitemsContentProvider.MyListItem> values) {
        super(context, R.layout.text_n_btn, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.text_n_btn, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.label);
        Button btn = (Button) rowView.findViewById(R.id.btn);
        textView.setText(values.get(position).content);
        btn.setBackground(BitmapFactory.get(values.get(position).fillRatio));
        return rowView;
    }
}
