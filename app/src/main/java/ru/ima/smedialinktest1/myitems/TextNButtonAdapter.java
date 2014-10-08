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

    static class ViewHolder {

        private TextView content;
        private Button btn;
        private TextView arrow;
    }

    public TextNButtonAdapter(Context context, List<MyitemsContentProvider.MyListItem> values) {
        super(context, R.layout.text_n_btn, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //View rowView = convertView;
        ViewHolder viewHolder = null;
        // reuse views
        if (convertView == null) {
            viewHolder = new ViewHolder();
            ;
            convertView = inflater.inflate(R.layout.text_n_btn, parent, false);
            viewHolder.content = (TextView) convertView.findViewById(R.id.label);
            viewHolder.btn = (Button) convertView.findViewById(R.id.btn);
            viewHolder.arrow = (TextView) convertView.findViewById(R.id.arrow);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();

        }
        viewHolder.content.setText(values.get(position).content);
        viewHolder.btn.setBackground(BitmapFactory.get(values.get(position).fillRatio));
        return convertView;
    }
}
