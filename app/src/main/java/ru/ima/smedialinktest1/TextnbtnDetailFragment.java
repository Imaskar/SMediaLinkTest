package ru.ima.smedialinktest1;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import ru.ima.smedialinktest1.myitems.BitmapFactory;
import ru.ima.smedialinktest1.myitems.MyitemsContentProvider;

/**
 * A fragment representing a single Text_n_btn detail screen.
 * This fragment is either contained in a {@link TextnbtnListActivity}
 * in two-pane mode (on tablets) or a {@link TextnbtnDetailActivity}
 * on handsets.
 */
public class TextnbtnDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private MyitemsContentProvider.MyListItem mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public TextnbtnDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = MyitemsContentProvider.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
            Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_textnbtn_detail, container, false);

        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.label)).setText(mItem.content);
            // color the Button
            Button btn = ((Button) rootView.findViewById(R.id.btn));
            btn.setBackground(BitmapFactory.get(mItem.fillRatio));
        }

        return rootView;
    }
}
